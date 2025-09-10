package net.micbear.michaelsfarming.block;

import net.micbear.michaelsfarming.MichaelsFarming;
import net.micbear.michaelsfarming.block.custom.RakedCoarseDirtBlock;
import net.micbear.michaelsfarming.block.custom.StrawberryCropBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import java.util.function.Function;

/*
* This class doesn't really have any use as of right now. I want to focus on adding farming stuffs to the game before
* I add the economy system.
*/

public class ModBlocks {
    public static final Block CROP_MERCHANT_BLOCK = registerBlock(true, "crop_merchant_block",
            Block::new,
            AbstractBlock.Settings.create()
                    .strength(4f)
                    .sounds(BlockSoundGroup.WOOD));

    public static final Block RAKED_COARSE_DIRT = registerBlock(false, "raked_coarse_dirt",
            RakedCoarseDirtBlock::new,
            AbstractBlock.Settings.create()
                    .strength(0.6f)
                    .sounds(BlockSoundGroup.GRAVEL));

    public static final Block STRAWBERRY_CROP = registerBlock(false, "strawberry_crop",
            StrawberryCropBlock::new,
            AbstractBlock.Settings.copy(Blocks.WHEAT)
                    .noCollision()
                    .nonOpaque()
                    .ticksRandomly());


    private static Block registerBlock(boolean withItem, String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Identifier id = Identifier.of(MichaelsFarming.MOD_ID, name);
        RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, id);
        Block block = Blocks.register(blockKey, factory, settings);

        if (withItem)
            Items.register(block);

        return block;
    }

    public static void registerModBlocks() {
        MichaelsFarming.LOGGER.info("Registering mod blocks for: " + MichaelsFarming.MOD_ID);
    }
}
