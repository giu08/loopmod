package net.loop.loopmod.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.loop.loopmod.block.ModBlocks;
import net.loop.loopmod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BAT)
                .pattern("A")
                .pattern("B")
                .pattern("C")
                .input('A', ItemTags.PLANKS)
                .input('B', Items.STRING)
                .input('C', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(Items.STRING),
                        FabricRecipeProvider.conditionsFromItem(Items.STRING))
                .criterion(FabricRecipeProvider.hasItem(ModItems.BAT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.BAT))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.BAT)));

    }
}