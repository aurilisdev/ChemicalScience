package net.pastek.chemicalscience.common.recipe.categories.gas2gas;

import java.util.List;

import com.mojang.datafixers.util.Pair;

import voltaic.api.gas.GasStack;
import voltaic.common.recipe.recipeutils.AbstractMaterialRecipe;
import voltaic.common.recipe.recipeutils.GasIngredient;
import voltaic.common.recipe.recipeutils.ProbableFluid;
import voltaic.common.recipe.recipeutils.ProbableGas;
import voltaic.common.recipe.recipeutils.ProbableItem;
import voltaic.prefab.tile.components.IComponentType;
import voltaic.prefab.tile.components.type.ComponentGasHandlerMulti;
import voltaic.prefab.tile.components.type.ComponentProcessor;

public abstract class Gas2GasRecipe extends AbstractMaterialRecipe {

    private List<GasIngredient> gasIngredients;
    private GasStack outputStack;

    public Gas2GasRecipe(String group, List<GasIngredient> inputGases, GasStack outputGas, double experience, int ticks, double usagePerTick, List<ProbableItem> itemBiproducts, List<ProbableFluid> fluidBiproducts, List<ProbableGas> gasBiproducts) {
        super(group, experience, ticks, usagePerTick, itemBiproducts, fluidBiproducts, gasBiproducts);
        gasIngredients = inputGases;
        outputStack = outputGas;
    }

    @Override
    public boolean matchesRecipe(ComponentProcessor pr, int procNumber) {
        Pair<List<Integer>, Boolean> gasPair = areGasesValid(getGasIngredients(), pr.getHolder().<ComponentGasHandlerMulti>requireComponent(IComponentType.GasHandler).getInputTanks());
        if (gasPair.getSecond()) {
            setGasArrangement(gasPair.getFirst());
            return true;
        }

        return false;
    }

    @Override
    public List<GasIngredient> getGasIngredients() {
        return gasIngredients;
    }

    @Override
    public GasStack getGasRecipeOutput() {
        return outputStack;
    }

    public interface Factory<T extends Gas2GasRecipe> {

        T create(String group, List<GasIngredient> inputGases, GasStack outputGas, double experience, int ticks, double usagePerTick, List<ProbableItem> itemBiproducts, List<ProbableFluid> fluidBiproducts, List<ProbableGas> gasBiproducts);

    }

}