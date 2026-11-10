package com.example.mixin.client;

import com.example.MyComponents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

import java.util.UUID;

@Mixin(LivingEntityRenderer.class)
public abstract class HidePlayerMixin<T extends LivingEntity, M extends EntityModel<T>> {

    @Unique
    private static final UUID HIDDEN_UUID =
            UUID.fromString("887e835c-179e-4c0b-9777-dc4aa64128a6");

    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void hideSpecificPlayer(
            T entity,
            float entityYaw,
            float tickDelta,
            MatrixStack matrices,
            VertexConsumerProvider vertexConsumers,
            int light,
            CallbackInfo ci
    ) {
        MinecraftClient client = MinecraftClient.getInstance();

        if (client.player == null) return;

        int vitality = MyComponents.RENDER_ACE
                .maybeGet(entity)
                .map(c -> c.getVitality())
                .orElse(0);

        // Completely hide from everyone except the hidden player.
        if (entity.getUuid().equals(HIDDEN_UUID)
                && !client.player.getUuid().equals(HIDDEN_UUID)
                && vitality < 2) {
            ci.cancel();
            return;
        }

        // Vitality 2: hide when directly looked at.
        if (vitality == 2 && entity.getUuid().equals(HIDDEN_UUID)) {
            Camera camera = client.gameRenderer.getCamera();

            Vec3d cameraPos = camera.getPos();
            Vec3d look = camera.getFocusedEntity().getRotationVec(1.0F);

            Vec3d targetPos = entity.getPos().add(0, entity.getStandingEyeHeight(), 0);
            Vec3d toTarget = targetPos.subtract(cameraPos).normalize();

            double dot = look.dotProduct(toTarget);

            if (dot > 0.5D) {
                ci.cancel();
            }
        }
    }

    @ModifyArgs(
            method = "render",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/render/entity/model/EntityModel;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;IIFFFF)V"
            )
    )
    private void modifyAlpha(
            Args args,
            T entity,
            float entityYaw,
            float tickDelta,
            MatrixStack matrices,
            VertexConsumerProvider vertexConsumers,
            int light
    ) {
        MinecraftClient client = MinecraftClient.getInstance();

        if (client.player == null) return;

        int vitality = MyComponents.RENDER_ACE
                .maybeGet(entity)
                .map(c -> c.getVitality())
                .orElse(0);

        if (client.player.getUuid().equals(HIDDEN_UUID)
                && entity.getUuid().equals(HIDDEN_UUID)) {
            args.set(7, 0.75F);
            return;
        }

        if (vitality == 2) {
            if (!entity.getUuid().equals(HIDDEN_UUID)) return;

            Camera camera = client.gameRenderer.getCamera();

            Vec3d cameraPos = camera.getPos();
            Vec3d look = camera.getFocusedEntity().getRotationVec(1.0F);

            Vec3d targetPos = entity.getPos().add(0, entity.getStandingEyeHeight(), 0);
            Vec3d toTarget = targetPos.subtract(cameraPos).normalize();

            double dot = look.dotProduct(toTarget);

            args.set(7, dot > 0.5D ? 0.0F : 0.25F);
            return;
        }

        if (vitality == 3) {
            args.set(7, 0.0F);
            return;
        }

        if (entity.getUuid().equals(HIDDEN_UUID)) {
            args.set(7, 0.25F);
        }
    }
}