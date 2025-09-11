package net.micbear.michaelsfarming.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.Map;

public class GrapeHoeItem extends FarmItem {
    public static final Map<Block, Block> GRAPEHOE_MAP =
            Map.of(
                    Blocks.DIRT, Blocks.COARSE_DIRT
            );
    public static final SoundEvent SOUND = SoundEvents.ITEM_HOE_TILL;

    public GrapeHoeItem(Settings settings) {
        super(settings, GRAPEHOE_MAP, SOUND);
    }
}
