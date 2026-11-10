package com.example;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;

public class ModServerParticles {
	private static final Map<UUID, Vec3d> LAST_POSITIONS = new ConcurrentHashMap<>();
    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
            	if(player.getUuidAsString().equals("887e835c-179e-4c0b-9777-dc4aa64128a6") && MyComponents.RENDER_ACE.maybeGet((LivingEntity) player).map(c -> c.getVitality() == 4).orElse(false)) {
            		spawnAuraParticles(player);
            	} else if(player.getUuidAsString().equals("887e835c-179e-4c0b-9777-dc4aa64128a6") && MyComponents.RENDER_ACE.maybeGet((LivingEntity) player).map(c -> c.getVitality() == 1).orElse(false)) {
            		spawnShadowstepParticles(player);
            	}
            }
        });
    }

    private static void spawnAuraParticles(ServerPlayerEntity player) {
    	
        ServerWorld world = player.getServerWorld();
        Random random = world.random;

        // Particle frequency (20 ticks = 1 second)
        if (random.nextInt(3) != 0) {
            return;
        }

        double radius = player.getWidth() * 0.8;

        double angle = random.nextDouble() * Math.PI * 2;

        double x = player.getX() + Math.cos(angle) * radius;
        double y = player.getY() + random.nextDouble() * player.getHeight();
        double z = player.getZ() + Math.sin(angle) * radius;

        world.spawnParticles(
                ParticleTypes.REVERSE_PORTAL,
                x,
                y,
                z,
                1,              // count
                0.0,            // velocity X
                0.05,           // velocity Y
                0.0,            // velocity Z
                0.02            // speed multiplier
        );
    }
    
    private static void spawnShadowstepParticles(ServerPlayerEntity player) {
        ServerWorld world = player.getServerWorld();
        Random random = world.random;

        Vec3d currentPos = player.getPos();
        Vec3d lastPos = LAST_POSITIONS.get(player.getUuid());

        // Start tracking the player
        if (lastPos == null) {
            LAST_POSITIONS.put(player.getUuid(), currentPos);
            return;
        }

        // Update position but don't spawn while idle or airborne
        if (currentPos.distanceTo(lastPos) < 0.15 || !player.isOnGround()) {
            LAST_POSITIONS.put(player.getUuid(), currentPos);
            return;
        }

        Vec3d movement = currentPos.subtract(lastPos);

        // Make sure movement has a direction
        if (movement.lengthSquared() > 0) {
            movement = movement.normalize();
        }

        // Spawn slightly behind where the player stepped
        Vec3d trailPos = lastPos.subtract(movement.multiply(0.35));

        double x = trailPos.x + (random.nextDouble() - 0.5) * 0.4;
        double y = player.getY() + 0.05;
        double z = trailPos.z + (random.nextDouble() - 0.5) * 0.4;

        world.spawnParticles(
                ParticleTypes.LARGE_SMOKE,
                x,
                y,
                z,
                2,
                0.1,
                0.02,
                0.1,
                0.005
        );

        if (random.nextInt(3) == 0) {
            world.spawnParticles(
                    ParticleTypes.REVERSE_PORTAL,
                    x,
                    y + 0.15,
                    z,
                    1,
                    (random.nextDouble() - 0.5) * 0.1,
                    0.05,
                    (random.nextDouble() - 0.5) * 0.1,
                    0.02
            );
        }

        LAST_POSITIONS.put(player.getUuid(), currentPos);
    }
}