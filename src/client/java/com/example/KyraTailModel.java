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

public class KyraTailModel extends EntityModel<Entity> {
	public static EntityModelLayer TAIL_MODEL_LAYER = new EntityModelLayer(ExampleMod.id("kyra_tail_model"), "main");
	
	public ModelPart body;
	public ModelPart Tail;
	public ModelPart Tail2;
	public KyraTailModel(ModelPart root) {
		this.body = root.getChild("body");
		this.Tail = this.body.getChild("Tail");
		this.Tail2 = this.Tail.getChild("Tail2");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(70, 12).cuboid(-0.5F, 10.0F, 2.1F, 1.0F, 1.0F, 1.0F, new Dilation(0.3F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData Tail = body.addChild("Tail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 10.3F, 3.0F));

		ModelPartData cube_r1 = Tail.addChild("cube_r1", ModelPartBuilder.create().uv(70, 12).cuboid(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.3F)), ModelTransform.of(-0.5F, -0.8F, 3.1F, 0.6109F, 0.0F, 0.0F));

		ModelPartData cube_r2 = Tail.addChild("cube_r2", ModelPartBuilder.create().uv(70, 12).cuboid(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.3F)), ModelTransform.of(-0.5F, 0.1F, 1.7F, 0.4625F, 0.0F, 0.0F));

		ModelPartData Tail2 = Tail.addChild("Tail2", ModelPartBuilder.create().uv(70, 12).cuboid(-0.5F, -0.6F, 1.1F, 1.0F, 1.0F, 1.0F, new Dilation(0.3F)), ModelTransform.pivot(0.0F, -1.6F, 3.0F));

		ModelPartData cube_r3 = Tail2.addChild("cube_r3", ModelPartBuilder.create().uv(70, 12).cuboid(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.3F)), ModelTransform.of(-0.5F, 0.4F, 1.1F, 0.3054F, 0.0F, 0.0F));

		ModelPartData cube_r4 = Tail2.addChild("cube_r4", ModelPartBuilder.create().uv(70, 12).cuboid(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.3F)), ModelTransform.of(-0.5F, 0.7F, 3.1F, -0.2618F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 128, 64);
	}
	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}
