package com.example;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;

import net.minecraft.client.network.AbstractClientPlayerEntity;

public class LandonFeatureRenderer extends FeatureRenderer<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> {
	LandonModel model;
	public LandonFeatureRenderer(FeatureRendererContext<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> featureRendererContext, EntityRendererFactory.Context loader) {
		super(featureRendererContext);
		
		this.model = new LandonModel(loader.getPart(LandonModel.MODEL_LAYER));;
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light,
			AbstractClientPlayerEntity entity, float limbAngle, float limbDistance, float tickDelta,
			float animationProgress, float headYaw, float headPitch) {
		if (MyComponents.RENDER_LANDON.maybeGet((LivingEntity) entity).map(c -> c.getVitality() == 1).orElse(false) && entity.getUuidAsString().equals("5692f14e-e4aa-4bb4-a2d1-e582811707b9")) {
			matrices.push();
			//((PlayerEntityModel)getContextModel()).head.visible = false;
			((PlayerEntityModel)getContextModel()).getHead().rotate(matrices);
			float scale = 1.0f;
			matrices.scale(scale, scale, scale);
			
			int p = LivingEntityRenderer.getOverlay((LivingEntity)entity, 0.0f);
			
			this.model.render(matrices, vertexConsumers.getBuffer(this.model.getLayer(ExampleMod.id("textures/entity/landon_model.png"))), light, p, 1.0f, 1.0f, 1.0f, 1.0f);
			matrices.pop();
		}
		
	}
	
	
}
