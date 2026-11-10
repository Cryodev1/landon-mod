package com.example.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.example.KyraFeatureRenderer;
import com.example.KyraTailFeatureRenderer;
import com.example.LandonFeatureRenderer;
import com.example.LandonTailFeatureRenderer;
import com.example.ShadeFeatureRenderer;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.PlayerEntityModel;

@Mixin({PlayerEntityRenderer.class})
public abstract class KyraRendererMixin extends LivingEntityRenderer<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> {
   public KyraRendererMixin(EntityRendererFactory.Context ctx, PlayerEntityModel<AbstractClientPlayerEntity> model, float shadowRadius) {
     super(ctx, model, shadowRadius);
   }
   
   @Inject(method = {"<init>"}, at = {@At("TAIL")})
   private void moltensmartians$appendFeatures(EntityRendererFactory.Context ctx, boolean slim, CallbackInfo callbackInfo) {
     addFeature((FeatureRenderer)new KyraFeatureRenderer((FeatureRendererContext)this, ctx));
     addFeature((FeatureRenderer)new KyraTailFeatureRenderer((FeatureRendererContext)this, ctx));
     addFeature((FeatureRenderer)new LandonFeatureRenderer((FeatureRendererContext)this, ctx));
     addFeature((FeatureRenderer)new LandonTailFeatureRenderer((FeatureRendererContext)this, ctx));
     addFeature((FeatureRenderer)new ShadeFeatureRenderer((FeatureRendererContext)this, ctx));
   }
}
