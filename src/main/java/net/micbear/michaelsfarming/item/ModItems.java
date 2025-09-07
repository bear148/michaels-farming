package net.micbear.michaelsfarming.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.micbear.michaelsfarming.MichaelsFarming;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item STRAWBERRY_SEEDS = registerItem("strawberry_seeds", create("strawberry_seeds"));
    public static final Item STRAWBERRY = registerItem("strawberry", create("strawberry"));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MichaelsFarming.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MichaelsFarming.LOGGER.info("Registering mod items for: " + MichaelsFarming.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(STRAWBERRY_SEEDS);
            fabricItemGroupEntries.add(STRAWBERRY);
        });
    }

    private static Item create(String name) {
        return new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MichaelsFarming.MOD_ID, name))));
    }
}
