package net.pastek.chemicalscience.compatibility.jei.recipecategories.gas2gas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.pastek.chemicalscience.common.recipe.categories.gas2gas.Gas2GasRecipe;
import voltaic.api.gas.GasStack;
import voltaic.common.recipe.recipeutils.GasIngredient;
import voltaic.compatibility.jei.recipecategories.AbstractRecipeCategory;
import voltaic.compatibility.jei.utils.gui.types.BackgroundObject;

public abstract class Gas2GasRecipeCategory<T extends Gas2GasRecipe> extends AbstractRecipeCategory<T> {
    public Gas2GasRecipeCategory(IGuiHelper guiHelper, Component title, ItemStack inputMachine, BackgroundObject bWrap, RecipeType<T> recipeType, int animTime) {
        super(guiHelper, title, inputMachine, bWrap, recipeType, animTime);
    }

    @Override
    public List<List<GasStack>> getGasInputs(Gas2GasRecipe recipe) {
        List<List<GasStack>> ingredients = new ArrayList<>();

        for(GasIngredient ing : recipe.getGasIngredients()) {

            List<GasStack> gas = new ArrayList<>(ing.getMatchingGases());

            ingredients.add(gas);
        }

        return ingredients;
    }

    @Override
    public List<GasStack> getGasOutputs(Gas2GasRecipe recipe) {
        List<GasStack> outputGas = new ArrayList<>();
        outputGas.add(recipe.getGasRecipeOutput());
        if (recipe.hasGasBiproducts()) {
            outputGas.addAll(Arrays.asList(recipe.getFullGasBiStacks()));
        }
        return outputGas;
    }

    @Override
    public List<ItemStack> getItemOutputs(Gas2GasRecipe recipe) {
        List<ItemStack> outputItems = new ArrayList<>();

        outputItems.add(recipe.getItemRecipeOutput());

        if (recipe.hasItemBiproducts()) {
            outputItems.addAll(Arrays.asList(recipe.getFullItemBiStacks()));
        }

        return outputItems;
    }
}
