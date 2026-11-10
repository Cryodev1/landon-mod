package com.example.mixin.client;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import com.example.ExampleMod;
import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;

@Mixin({LivingEntityRenderer.class})
public abstract class KyraOverrideModelLivingEntityRendererMixin<T extends LivingEntity, M extends EntityModel<T>> {
	@Shadow
	public abstract M getModel();
	
	@Shadow
	protected abstract boolean isVisible(T paramT);
	
	@Shadow
	@Nullable
	protected abstract RenderLayer getRenderLayer(T paramT, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);

	@WrapWithCondition(method = {"render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/render/entity/model/EntityModel;render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;IIFFFF)V")})
	private boolean moltensmartians$overrideModelRender(M model, MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha, T entity, float yaw, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light2) {
		if (entity.isPlayer() && entity instanceof AbstractClientPlayerEntity && entity.getUuidAsString().equals("a825e802-c625-411c-81aa-c090843f588e")) {
			AbstractClientPlayerEntity player = (AbstractClientPlayerEntity)entity;
			return moltensmartians$overrideModelRender(player, matrices, light, overlay, red, green, blue, alpha, yaw, tickDelta, matrixStack, vertexConsumerProvider);
		}  
		return true;
	}
	
	@Unique
	protected boolean moltensmartians$overrideModelRender(@Nullable AbstractClientPlayerEntity player, MatrixStack matrices, int light, int overlay, float red, float green, float blue, float alpha, float yaw, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider) {
		return player.getUuidAsString().equals("a825e802-c625-411c-81aa-c090843f588e");
	}
}
