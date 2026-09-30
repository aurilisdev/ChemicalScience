package net.pastek.chemicalscience.common.recipe.categories.item2item.specificmachines;

import java.util.List;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.registers.CSRecipies;
import voltaic.common.recipe.categories.item2item.Item2ItemRecipe;
import voltaic.common.recipe.recipeutils.CountableIngredient;
import voltaic.common.recipe.recipeutils.ProbableFluid;
import voltaic.common.recipe.recipeutils.ProbableGas;
import voltaic.common.recipe.recipeutils.ProbableItem;

public class RedoxFurnaceRecipe extends Item2ItemRecipe {
    public static final String RECIPE_GROUP = "redox_furnace_recipe";
    public static final ResourceLocation RECIPE_ID = ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, "redox_furnace_recipe");

    public RedoxFurnaceRecipe(String group, List<CountableIngredient> inputItems, ItemStack itemOutput, double experience, int ticks, double usagePerTick, List<ProbableItem> itemBiproducts, List<ProbableFluid> fluidBiproducts, List<ProbableGas> gasBiproducts) {
        super(group, inputItems, itemOutput, experience, ticks, usagePerTick, itemBiproducts, fluidBiproducts, gasBiproducts);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return CSRecipies.REDOX_FURNACE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return CSRecipies.REDOX_FURNACE_TYPE.get();
    }
}
