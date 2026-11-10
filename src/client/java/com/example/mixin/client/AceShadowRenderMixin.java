package com.example.mixin.client;

import java.util.UUID;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.world.WorldView;

@Mixin(EntityRenderDispatcher.class)
public abstract class AceShadowRenderMixin<T extends Entity> {
	@Unique
    private static final UUID HIDDEN_UUID =
            UUID.fromString("887e835c-179e-4c0b-9777-dc4aa64128a6");

	@Inject(method = "renderShadow", at = @At("HEAD"), cancellable = true)
	private static void hideShadow(
	        MatrixStack matrices,
	        VertexConsumerProvider vertexConsumers,
	        Entity entity,
	        float opacity,
	        float tickDelta,
	        WorldView world,
	        float radius,
	        CallbackInfo ci) {

	    if (entity.getUuid().equals(HIDDEN_UUID)) {
	        ci.cancel();
	    }
	}
}
