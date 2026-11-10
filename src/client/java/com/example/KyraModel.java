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

public class KyraModel extends EntityModel<Entity> {
	public static EntityModelLayer MODEL_LAYER = new EntityModelLayer(ExampleMod.id("kyra_model"), "main");
	
	private final ModelPart head;
	public KyraModel(ModelPart root) {
		this.head = root.getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(64, 62).cuboid(-5.0F, -1.0F, 4.0F, 10.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(64, 62).cuboid(-5.0F, 0.0F, 3.0F, 10.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(64, 62).cuboid(-5.0F, 0.0F, 2.0F, 10.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(68, 60).cuboid(-3.0F, -2.0F, 4.0F, 6.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(64, 62).cuboid(-5.0F, -3.0F, 4.0F, 10.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(64, 62).cuboid(3.0F, -2.0F, 4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(65, 62).cuboid(-4.0F, -2.0F, 4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(70, 10).cuboid(-5.0F, -2.0F, 2.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(70, 10).cuboid(4.0F, -2.0F, 2.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(66, 10).cuboid(0.0F, -7.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(66, 10).cuboid(1.0F, -8.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(66, 10).cuboid(2.0F, -7.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(66, 10).cuboid(1.0F, -6.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(66, 12).cuboid(1.0F, -7.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(19, 4).cuboid(1.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(19, 4).cuboid(0.0F, -3.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(19, 4).cuboid(-1.0F, -3.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(19, 4).cuboid(-2.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(19, 4).cuboid(-2.0F, -1.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(19, 4).cuboid(-2.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(19, 4).cuboid(-1.0F, -3.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(19, 4).cuboid(0.0F, -3.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(19, 4).cuboid(1.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(19, 4).cuboid(1.0F, -1.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(19, 4).cuboid(0.0F, -1.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(19, 4).cuboid(-1.0F, -1.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(19, 4).cuboid(-2.0F, -1.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(19, 4).cuboid(-1.0F, -1.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(19, 4).cuboid(0.0F, -1.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(19, 4).cuboid(1.0F, -1.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(66, 8).cuboid(-1.0F, -2.0F, -5.4F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(70, 8).cuboid(0.0F, -2.0F, -5.4F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(16, 2).cuboid(1.4F, -9.5F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(-0.5F))
		.uv(16, 2).cuboid(-3.3F, -9.5F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(-0.5F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r1 = head.addChild("cube_r1", ModelPartBuilder.create().uv(66, 4).cuboid(-1.0F, -1.9F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(-0.3F)), ModelTransform.of(-1.5F, -9.1F, 0.0F, 0.0F, 3.1416F, -0.3927F));

		ModelPartData cube_r2 = head.addChild("cube_r2", ModelPartBuilder.create().uv(66, 4).cuboid(-1.0F, -1.9F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(-0.3F)), ModelTransform.of(-3.6F, -7.8F, 0.0F, 0.0F, 0.0F, 0.4363F));

		ModelPartData cube_r3 = head.addChild("cube_r3", ModelPartBuilder.create().uv(66, 4).cuboid(-1.0F, -1.9F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(-0.301F)), ModelTransform.of(-3.0F, -9.05F, 0.0F, 0.0F, 0.0F, 0.4363F));

		ModelPartData cube_r4 = head.addChild("cube_r4", ModelPartBuilder.create().uv(66, 4).cuboid(-1.0F, -1.9F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(-0.3F)), ModelTransform.of(3.7F, -7.8F, 0.0F, 0.0F, 3.1416F, -0.3927F));

		ModelPartData cube_r5 = head.addChild("cube_r5", ModelPartBuilder.create().uv(66, 4).cuboid(-1.0F, -1.9F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(-0.3F)), ModelTransform.of(3.2F, -9.1F, 0.0F, 0.0F, 3.1416F, -0.3927F));

		ModelPartData cube_r6 = head.addChild("cube_r6", ModelPartBuilder.create().uv(66, 4).cuboid(-1.0F, -1.9F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(-0.301F)), ModelTransform.of(1.7F, -9.05F, 0.0F, 0.0F, 0.0F, 0.4363F));

		ModelPartData cube_r7 = head.addChild("cube_r7", ModelPartBuilder.create().uv(66, 4).cuboid(-1.0F, -1.9F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(-0.3F)), ModelTransform.of(1.1F, -7.8F, 0.0F, 0.0F, 0.0F, 0.4363F));

		ModelPartData cube_r8 = head.addChild("cube_r8", ModelPartBuilder.create().uv(66, 4).cuboid(-1.0F, -1.9F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(-0.3F)), ModelTransform.of(-1.0F, -7.8F, 0.0F, 0.0F, 3.1416F, -0.3927F));

		ModelPartData cube_r9 = head.addChild("cube_r9", ModelPartBuilder.create().uv(64, 62).cuboid(-3.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, -1.0F, 2.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r10 = head.addChild("cube_r10", ModelPartBuilder.create().uv(65, 62).cuboid(-3.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, -2.0F, 1.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r11 = head.addChild("cube_r11", ModelPartBuilder.create().uv(65, 62).cuboid(-3.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, -1.0F, 2.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r12 = head.addChild("cube_r12", ModelPartBuilder.create().uv(67, 62).cuboid(-6.0F, -1.0F, -1.0F, 7.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(66, 62).cuboid(-3.0F, -2.0F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, 0.0F, -1.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r13 = head.addChild("cube_r13", ModelPartBuilder.create().uv(64, 62).cuboid(-3.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, -2.0F, 1.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r14 = head.addChild("cube_r14", ModelPartBuilder.create().uv(64, 62).cuboid(-3.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(64, 62).cuboid(-6.0F, 0.0F, -1.0F, 7.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, -1.0F, -1.0F, 0.0F, 1.5708F, 0.0F));
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