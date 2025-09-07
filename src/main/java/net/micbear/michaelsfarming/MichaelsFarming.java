package net.micbear.michaelsfarming;

import net.fabricmc.api.ModInitializer;

import net.micbear.michaelsfarming.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MichaelsFarming implements ModInitializer {
	public static final String MOD_ID = "michaelsfarming";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItems.registerModItems();
	}
}