package net.micbear.michaelsfarming.block;

import net.micbear.michaelsfarming.MichaelsFarming;
import net.micbear.michaelsfarming.block.custom.RakedCoarseDirtBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
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
    public static final Block CROP_MERCHANT_BLOCK = registerBlock("crop_merchant_block",
            Block::new,
            AbstractBlock.Settings.create()
                    .strength(4f)
                    .sounds(BlockSoundGroup.WOOD));

    public static final Block RAKED_COARSE_DIRT = registerBlock("raked_coarse_dirt",
            RakedCoarseDirtBlock::new,
            AbstractBlock.Settings.create()
                    .strength(0.6f)
                    .sounds(BlockSoundGroup.GRAVEL));


    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Identifier id = Identifier.of(MichaelsFarming.MOD_ID, name);
        RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, id);
        Block block = Blocks.register(blockKey, factory, settings);
        Items.register(block);
        return block;
    }

    private static void registerBlockItem(String name, Block block) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MichaelsFarming.MOD_ID, name));
        BlockItem item = new BlockItem(block, new Item.Settings().registryKey(key));
        Registry.register(Registries.ITEM, key, item);
    }

    public static void registerModBlocks() {
        MichaelsFarming.LOGGER.info("Registering mod blocks for: " + MichaelsFarming.MOD_ID);
    }
}
