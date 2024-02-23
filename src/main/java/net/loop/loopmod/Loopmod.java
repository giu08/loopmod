package net.loop.loopmod;

import net.fabricmc.api.ModInitializer;

import net.loop.loopmod.block.ModBlocks;
import net.loop.loopmod.item.ModItemGroup;
import net.loop.loopmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Loopmod implements ModInitializer {
	public static final String MOD_ID = "loopmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		LOGGER.info("Hello Fabric world!");
	}
}