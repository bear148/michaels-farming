package net.micbear.michaelsfarming.item;

import net.micbear.michaelsfarming.MichaelsFarming;
import net.micbear.michaelsfarming.block.ModBlocks;
import net.micbear.michaelsfarming.item.custom.GrapeHoeItem;
import net.micbear.michaelsfarming.item.custom.RakeItem;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static final Item STRAWBERRY = register("strawberry", Item::new, new Item.Settings().food(new FoodComponent.Builder()
                    .nutrition(2)
                    .saturationModifier(2f)
            .build()));

    public static final Item GRAPEHOE = register("grapehoe", GrapeHoeItem::new, new Item.Settings());

    public static final Item STRAWBERRY_SEEDS = register(
            "strawberry_seeds",
            settings -> new BlockItem(ModBlocks.STRAWBERRY_CROP, settings),
            new Item.Settings().useItemPrefixedTranslationKey());

    public static final Item RAKE = register("rake", RakeItem::new, new Item.Settings());

    public static void registerModItems() {
        MichaelsFarming.LOGGER.info("Registering mod items for: " + MichaelsFarming.MOD_ID);
    }

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MichaelsFarming.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);
        return item;
    }
}
