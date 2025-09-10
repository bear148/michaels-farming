package net.micbear.michaelsfarming;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.micbear.michaelsfarming.block.ModBlocks;
import net.minecraft.client.render.BlockRenderLayer;

public class MichaelsFarmingClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(ModBlocks.STRAWBERRY_CROP, BlockRenderLayer.CUTOUT);
    }
}
