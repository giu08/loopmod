package net.loop.loopmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.loop.loopmod.Loopmod;
import net.loop.loopmod.item.custom.Bat;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item BAT = registerItem("bat",
            new Bat(ToolMaterials.WOOD, 6, -2.4f, new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Loopmod.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ItemGroups.COMBAT, BAT);
        addToItemGroup(ItemGroups.TOOLS, BAT);
    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
    public static void registerModItems() {
        Loopmod.LOGGER.info("Registering Mod Items for " + Loopmod.MOD_ID);

        addItemsToItemGroup();
    }
}