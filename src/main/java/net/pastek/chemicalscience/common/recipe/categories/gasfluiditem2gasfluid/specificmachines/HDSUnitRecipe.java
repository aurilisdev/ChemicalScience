package net.pastek.chemicalscience.common.recipe.categories.gasfluiditem2gasfluid.specificmachines;

import java.util.List;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.fluids.FluidStack;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.common.recipe.categories.gasfluiditem2gasfluid.GasFluidItem2FluidRecipe;
import net.pastek.chemicalscience.registers.CSRecipies;
import voltaic.common.recipe.recipeutils.CountableIngredient;
import voltaic.common.recipe.recipeutils.FluidIngredient;
import voltaic.common.recipe.recipeutils.GasIngredient;
import voltaic.common.recipe.recipeutils.ProbableFluid;
import voltaic.common.recipe.recipeutils.ProbableGas;
import voltaic.common.recipe.recipeutils.ProbableItem;

public class HDSUnitRecipe extends GasFluidItem2FluidRecipe {
    public static final String RECIPE_GROUP = "hds_unit_recipe";
    public static final ResourceLocation RECIPE_ID = ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, "hds_unit_recipe");

    public HDSUnitRecipe(String group, List<CountableIngredient> inputItems, List<FluidIngredient> inputFluids, List<GasIngredient> inputGases, FluidStack fluidOutput, double experience, int ticks, double usagePerTick, List<ProbableItem> itemBiproducts, List<ProbableFluid> fluidBiproducts, List<ProbableGas> gasBiproducts) {
        super(group, inputItems, inputFluids, inputGases, fluidOutput, experience, ticks, usagePerTick, itemBiproducts, fluidBiproducts, gasBiproducts);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return CSRecipies.HDS_UNIT_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return CSRecipies.HDS_UNIT_TYPE.get();
    }
}
