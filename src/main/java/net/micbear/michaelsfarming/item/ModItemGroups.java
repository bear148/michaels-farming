package net.micbear.michaelsfarming.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.micbear.michaelsfarming.MichaelsFarming;
import net.micbear.michaelsfarming.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup MICHAELS_FARMING = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MichaelsFarming.MOD_ID, "michaels_farming"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.STRAWBERRY))
                    .displayName(Text.translatable("itemgroup.michaelsfarming.michaels_farming"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.CROP_MERCHANT_BLOCK);
                        entries.add(ModItems.STRAWBERRY);
                        entries.add(ModItems.STRAWBERRY_SEEDS);
                        entries.add(ModItems.GRAPEHOE);
                        entries.add(ModItems.RAKE);
                        entries.add(ModItems.FERTILIZER);
                    }).build());

    public static void registerItemGroups() {
        MichaelsFarming.LOGGER.info("Registering item groups for: " + MichaelsFarming.MOD_ID);
    }
}
