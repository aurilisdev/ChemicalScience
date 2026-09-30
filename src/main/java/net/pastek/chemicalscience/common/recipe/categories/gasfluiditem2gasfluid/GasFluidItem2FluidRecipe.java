package net.pastek.chemicalscience.common.recipe.categories.gasfluiditem2gasfluid;

import java.util.List;

import com.mojang.datafixers.util.Pair;

import net.neoforged.neoforge.fluids.FluidStack;
import voltaic.common.recipe.recipeutils.AbstractMaterialRecipe;
import voltaic.common.recipe.recipeutils.CountableIngredient;
import voltaic.common.recipe.recipeutils.FluidIngredient;
import voltaic.common.recipe.recipeutils.GasIngredient;
import voltaic.common.recipe.recipeutils.ProbableFluid;
import voltaic.common.recipe.recipeutils.ProbableGas;
import voltaic.common.recipe.recipeutils.ProbableItem;
import voltaic.prefab.tile.components.IComponentType;
import voltaic.prefab.tile.components.type.ComponentFluidHandlerMulti;
import voltaic.prefab.tile.components.type.ComponentGasHandlerMulti;
import voltaic.prefab.tile.components.type.ComponentInventory;
import voltaic.prefab.tile.components.type.ComponentProcessor;

public abstract class GasFluidItem2FluidRecipe extends AbstractMaterialRecipe {

    private List<FluidIngredient> fluidIngredients;
    private List<GasIngredient> gasIngredients;
    private List<CountableIngredient> ingredients;
    private FluidStack outputStack;

    public GasFluidItem2FluidRecipe(String group, List<CountableIngredient> inputItems, List<FluidIngredient> inputFluids, List<GasIngredient> inputGases, FluidStack outputFluid, double experience, int ticks, double usagePerTick, List<ProbableItem> itemBiproducts, List<ProbableFluid> fluidBiproducts, List<ProbableGas> gasBiproducts) {
        super(group, experience, ticks, usagePerTick, itemBiproducts, fluidBiproducts, gasBiproducts);
        ingredients = inputItems;
        fluidIngredients = inputFluids;
        gasIngredients = inputGases;
        outputStack = outputFluid;
    }

    @Override
    public boolean matchesRecipe(ComponentProcessor pr, int procNumber) {
        Pair<List<Integer>, Boolean> itemPair = areItemsValid(getCountedIngredients(), ((ComponentInventory) pr.getHolder().requireComponent(IComponentType.Inventory)).getInputsForProcessor(procNumber));
        if (itemPair.getSecond()) {
            Pair<List<Integer>, Boolean> fluidPair = areFluidsValid(getFluidIngredients(), pr.getHolder().<ComponentFluidHandlerMulti>requireComponent(IComponentType.FluidHandler).getInputTanks());
            if (fluidPair.getSecond()) {
                Pair<List<Integer>, Boolean> gasPair = areGasesValid(getGasIngredients(), pr.getHolder().<ComponentGasHandlerMulti>requireComponent(IComponentType.GasHandler).getInputTanks());
                if (gasPair.getSecond()) {
                    setItemArrangement(procNumber, itemPair.getFirst());
                    setFluidArrangement(fluidPair.getFirst());
                    setGasArrangement(gasPair.getFirst());
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<FluidIngredient> getFluidIngredients() {
        return fluidIngredients;
    }

    @Override
    public List<GasIngredient> getGasIngredients() {
        return gasIngredients;
    }

    @Override
    public FluidStack getFluidRecipeOutput() {
        return outputStack;
    }

    @Override
    public List<CountableIngredient> getCountedIngredients() {
        return ingredients;
    }

    public interface Factory<T extends GasFluidItem2FluidRecipe> {

        T create(String group, List<CountableIngredient> inputItems, List<FluidIngredient> inputFluids, List<GasIngredient> inputGases, FluidStack outputFluid, double experience, int ticks, double usagePerTick, List<ProbableItem> itemBiproducts, List<ProbableFluid> fluidBiproducts, List<ProbableGas> gasBiproducts);

    }

}