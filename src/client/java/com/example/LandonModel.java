package com.example;

import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class LandonModel extends EntityModel<Entity> {
	public static EntityModelLayer MODEL_LAYER = new EntityModelLayer(ExampleMod.id("landon_model"), "main");
	
	private final ModelPart head;
	public LandonModel(ModelPart root) {
		this.head = root.getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(2, 5).cuboid(-2.8F, -32.98F, -2.025F, 1.0F, 1.0F, 1.0F, new Dilation(-0.01F))
		.uv(2, 5).cuboid(1.92F, -32.98F, -2.025F, 1.0F, 1.0F, 1.0F, new Dilation(-0.01F))
		.uv(118, 1).cuboid(-0.56F, -33.12F, -0.52F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData cube_r1 = head.addChild("cube_r1", ModelPartBuilder.create().uv(124, 0).cuboid(-1.0647F, -2.0337F, -1.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.6692F, -31.9986F, -1.025F, 0.0F, 0.0F, 0.3622F));

		ModelPartData cube_r2 = head.addChild("cube_r2", ModelPartBuilder.create().uv(124, 0).cuboid(-0.328F, -1.7881F, -1.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.825F, -32.425F, -1.025F, 0.0F, 0.0F, -0.3622F));

		ModelPartData cube_r3 = head.addChild("cube_r3", ModelPartBuilder.create().uv(124, 0).cuboid(-1.0647F, -2.0337F, -1.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.0808F, -31.9986F, -1.025F, 0.0F, 0.0F, 0.3622F));

		ModelPartData cube_r4 = head.addChild("cube_r4", ModelPartBuilder.create().uv(124, 0).cuboid(-0.328F, -1.7881F, -1.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.925F, -32.425F, -1.025F, 0.0F, 0.0F, -0.3622F));

		return TexturedModelData.of(modelData, 128, 64);
	}
	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}




}