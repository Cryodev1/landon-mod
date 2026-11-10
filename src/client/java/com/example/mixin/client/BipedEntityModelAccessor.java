package com.example.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.BipedEntityModel;

@Mixin({BipedEntityModel.class})
public interface BipedEntityModelAccessor {
  @Invoker("getHeadParts")
  Iterable<ModelPart> moltensmartians$getHeadParts();
  
  @Invoker("getBodyParts")
  Iterable<ModelPart> moltensmartians$getBodyParts();
}
