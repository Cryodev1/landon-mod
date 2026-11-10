package com.example;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.network.AbstractClientPlayerEntity;

public class LandonTailFeatureRenderer extends FeatureRenderer<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> {
	LandonTailModel tailModel;
	public LandonTailFeatureRenderer(FeatureRendererContext<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> featureRendererContext, EntityRendererFactory.Context loader) {
		super(featureRendererContext);
		
		this.tailModel = new LandonTailModel(loader.getPart(LandonTailModel.TAIL_MODEL_LAYER));;
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light,
			AbstractClientPlayerEntity entity, float limbAngle, float limbDistance, float tickDelta,
			float animationProgress, float headYaw, float headPitch) {
		if(MyComponents.RENDER_LANDON.maybeGet((LivingEntity) entity).map(c -> c.getVitality() == 1).orElse(false) && entity.getUuidAsString().equals("5692f14e-e4aa-4bb4-a2d1-e582811707b9")) {
			matrices.push();
			float scale = 1.0f;
			matrices.scale(scale, scale, scale);
			
			int p = LivingEntityRenderer.getOverlay((LivingEntity)entity, 0.0f);
			
			float time = animationProgress * 0.05F;
			this.tailModel.Tail.yaw = MathHelper.cos(time * 0.9F) * 0.3F;
			
			this.tailModel.render(matrices, vertexConsumers.getBuffer(this.tailModel.getLayer(ExampleMod.id("textures/entity/landon_tail_model.png"))), light, p, 1.0f, 1.0f, 1.0f, 1.0f);
			matrices.pop();
		}
		
	}
	
	
}
