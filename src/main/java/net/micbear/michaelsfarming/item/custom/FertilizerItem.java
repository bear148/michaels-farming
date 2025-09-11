package net.micbear.michaelsfarming.item.custom;

import net.micbear.michaelsfarming.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.Map;

public class FertilizerItem extends FarmItem {
    public static final Map<Block, Block> FERTILIZER_MAP = Map.of(
            ModBlocks.RAKED_COARSE_DIRT, Blocks.FARMLAND
    );
    public static final SoundEvent SOUND = SoundEvents.BLOCK_ROOTED_DIRT_PLACE;

    public FertilizerItem(Settings settings) {
        super(settings, FERTILIZER_MAP, SOUND);
    }
}
