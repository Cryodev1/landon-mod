package com.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class ExampleModClient implements ClientModInitializer {
	public static boolean renderKyra = true;
	
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistries.LANDON_DOOR, RenderLayer.getCutout());
        EntityRendererRegistry.register(ExampleMod.LandonEntityType, FlyingItemEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(KyraModel.MODEL_LAYER, KyraModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(KyraTailModel.TAIL_MODEL_LAYER, KyraTailModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(LandonModel.MODEL_LAYER, LandonModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(LandonTailModel.TAIL_MODEL_LAYER, LandonTailModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ShadeModel.MODEL_LAYER, ShadeModel::getTexturedModelData);
    }
}