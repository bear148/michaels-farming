package net.micbear.michaelsfarming.item.custom;

import net.micbear.michaelsfarming.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.Map;

public class RakeItem extends FarmItem {
    public static final Map<Block, Block> RAKE_MAP =
            Map.of(
                    Blocks.COARSE_DIRT, ModBlocks.RAKED_COARSE_DIRT
            );
    public static final SoundEvent SOUND = SoundEvents.ITEM_HOE_TILL;

    public RakeItem(Settings settings) {
        super(settings, RAKE_MAP, SOUND);
    }
}
