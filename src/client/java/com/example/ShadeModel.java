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

public class ShadeModel extends EntityModel<Entity> {
	public static EntityModelLayer MODEL_LAYER = new EntityModelLayer(ExampleMod.id("shade_model"), "main");
	
	private final ModelPart body;
	public ShadeModel(ModelPart root) {
		this.body = root.getChild("body");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(122, 55).mirrored().cuboid(-3.0F, -16.0F, 2.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
		.uv(122, 55).cuboid(1.0F, -16.0F, 2.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(122, 55).cuboid(-1.0F, -15.0F, 2.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(123, 52).mirrored().cuboid(-4.0F, -20.0F, 2.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
		.uv(122, 57).mirrored().cuboid(-3.0F, -21.0F, 2.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
		.uv(122, 62).cuboid(-1.0F, -22.0F, 2.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(122, 62).cuboid(1.0F, -21.0F, 2.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(123, 59).mirrored().cuboid(3.0F, -20.0F, 2.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
		.uv(116, 47).mirrored().cuboid(1.0F, -20.0F, 1.75F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
		.uv(115, 47).mirrored().cuboid(-1.0F, -21.0F, 1.75F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
		.uv(116, 47).mirrored().cuboid(-2.0F, -20.0F, 1.75F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
		.uv(115, 49).mirrored().cuboid(-1.0F, -19.0F, 1.75F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
		.uv(116, 52).mirrored().cuboid(-3.0F, -20.0F, 1.75F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
		.uv(116, 57).mirrored().cuboid(2.0F, -20.0F, 1.75F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
		.uv(117, 62).mirrored().cuboid(-2.0F, -17.0F, 1.75F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
		.uv(117, 62).mirrored().cuboid(1.0F, -17.0F, 1.75F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
		.uv(115, 62).mirrored().cuboid(-1.0F, -16.0F, 1.75F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
		.uv(109, 61).cuboid(-2.0F, -19.0F, 2.25F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(109, 61).cuboid(1.0F, -19.0F, 2.25F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(108, 61).cuboid(-1.0F, -17.0F, 2.25F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(108, 61).cuboid(-1.0F, -20.0F, 2.25F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		return TexturedModelData.of(modelData, 128, 64);
	}
	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netbodyYaw, float bodyPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}




}