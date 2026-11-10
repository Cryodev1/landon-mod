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

public class ShadeFeatureRenderer extends FeatureRenderer<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> {
	ShadeModel model;
	public ShadeFeatureRenderer(FeatureRendererContext<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> featureRendererContext, EntityRendererFactory.Context loader) {
		super(featureRendererContext);
		
		this.model = new ShadeModel(loader.getPart(ShadeModel.MODEL_LAYER));;
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light,
			AbstractClientPlayerEntity entity, float limbAngle, float limbDistance, float tickDelta,
			float animationProgress, float headYaw, float headPitch) {
		if (MyComponents.RENDER_SHADE.maybeGet((LivingEntity) entity).map(c -> c.getVitality() == 1).orElse(false) && entity.getUuidAsString().equals("67535684-38c1-4733-9b22-78a50e7e86a1")) {
			matrices.push();
			//((PlayerEntityModel)getContextModel()).head.visible = false;
			float scale = 1.0f;
			matrices.scale(scale, scale, scale);
			
			int p = LivingEntityRenderer.getOverlay((LivingEntity)entity, 0.0f);
			
			this.model.render(matrices, vertexConsumers.getBuffer(this.model.getLayer(ExampleMod.id("textures/entity/shade_model.png"))), light, p, 1.0f, 1.0f, 1.0f, 1.0f);
			matrices.pop();
		}
		
	}
	
	
}
