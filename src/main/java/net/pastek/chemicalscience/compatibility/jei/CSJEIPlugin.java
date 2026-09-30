package net.pastek.chemicalscience.compatibility.jei;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.jetbrains.annotations.NotNull;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.neoforge.NeoForgeTypes;
import mezz.jei.api.registration.IExtraIngredientRegistration;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.client.screen.ScreenCatalyticReformer;
import net.pastek.chemicalscience.client.screen.ScreenChemicalBench;
import net.pastek.chemicalscience.client.screen.ScreenCircuitMaker;
import net.pastek.chemicalscience.client.screen.ScreenFractionatingColumn;
import net.pastek.chemicalscience.client.screen.ScreenHDSUnit;
import net.pastek.chemicalscience.client.screen.ScreenRedoxFurnace;
import net.pastek.chemicalscience.client.screen.ScreenSpinCoater;
import net.pastek.chemicalscience.client.screen.ScreenSteamCracker;
import net.pastek.chemicalscience.compatibility.jei.recipecategories.fluid2fluid.FractionatingColumnRecipeCategory;
import net.pastek.chemicalscience.compatibility.jei.recipecategories.fluid2item.SpinCoaterRecipeCategory;
import net.pastek.chemicalscience.compatibility.jei.recipecategories.fluiditem2fluid.CatalyticReformerRecipeCategory;
import net.pastek.chemicalscience.compatibility.jei.recipecategories.fluiditem2item.CircuitMakerRecipeCategory;
import net.pastek.chemicalscience.compatibility.jei.recipecategories.gas2gas.SteamCrackerRecipeCategory;
import net.pastek.chemicalscience.compatibility.jei.recipecategories.gasfluiditem2gasfluid.HDSUnitRecipeCategory;
import net.pastek.chemicalscience.compatibility.jei.recipecategories.item2item.RedoxFurnaceRecipeCategory;
import net.pastek.chemicalscience.compatibility.jei.recipecategories.misc.ChemicalBenchRecipeCategory;
import net.pastek.chemicalscience.registers.CSRecipies;
import net.pastek.chemicalscience.registers.fluids.CSFluids;
import net.pastek.chemicalscience.registers.gases.CSGases;
import voltaic.api.gas.Gas;
import voltaic.api.gas.GasStack;
import voltaic.compatibility.jei.utils.ingredients.VoltaicJeiTypes;
import voltaic.registers.VoltaicGases;

@JeiPlugin
public class CSJEIPlugin implements IModPlugin {

    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, "jei");

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return ID;
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(CircuitMakerRecipeCategory.INPUT_MACHINE, CircuitMakerRecipeCategory.RECIPE_TYPE);
        registration.addRecipeCatalyst(FractionatingColumnRecipeCategory.INPUT_MACHINE, FractionatingColumnRecipeCategory.RECIPE_TYPE);
        registration.addRecipeCatalyst(HDSUnitRecipeCategory.INPUT_MACHINE, HDSUnitRecipeCategory.RECIPE_TYPE);
        registration.addRecipeCatalyst(SteamCrackerRecipeCategory.INPUT_MACHINE, SteamCrackerRecipeCategory.RECIPE_TYPE);
        registration.addRecipeCatalyst(CatalyticReformerRecipeCategory.INPUT_MACHINE, CatalyticReformerRecipeCategory.RECIPE_TYPE);
        registration.addRecipeCatalyst(ChemicalBenchRecipeCategory.INPUT_MACHINE, ChemicalBenchRecipeCategory.RECIPE_TYPE);
        registration.addRecipeCatalyst(SpinCoaterRecipeCategory.INPUT_MACHINE, SpinCoaterRecipeCategory.RECIPE_TYPE);
        registration.addRecipeCatalyst(RedoxFurnaceRecipeCategory.INPUT_MACHINE, RedoxFurnaceRecipeCategory.RECIPE_TYPE);
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        Minecraft mc = Minecraft.getInstance();
        ClientLevel world = Objects.requireNonNull(mc.level);
        RecipeManager recipeManager = world.getRecipeManager();
        registration.addRecipes(CircuitMakerRecipeCategory.RECIPE_TYPE, recipeManager.getAllRecipesFor(CSRecipies.CIRCUIT_MAKER_TYPE.get()).stream().map(RecipeHolder::value).toList());
        registration.addRecipes(FractionatingColumnRecipeCategory.RECIPE_TYPE, recipeManager.getAllRecipesFor(CSRecipies.FRACTIONATING_COLUMN_TYPE.get()).stream().map(RecipeHolder::value).toList());
        registration.addRecipes(HDSUnitRecipeCategory.RECIPE_TYPE, recipeManager.getAllRecipesFor(CSRecipies.HDS_UNIT_TYPE.get()).stream().map(RecipeHolder::value).toList());
        registration.addRecipes(SteamCrackerRecipeCategory.RECIPE_TYPE, recipeManager.getAllRecipesFor(CSRecipies.STEAM_CRACKER_TYPE.get()).stream().map(RecipeHolder::value).toList());
        registration.addRecipes(CatalyticReformerRecipeCategory.RECIPE_TYPE, recipeManager.getAllRecipesFor(CSRecipies.CATALYTIC_REFORMER_TYPE.get()).stream().map(RecipeHolder::value).toList());
        registration.addRecipes(ChemicalBenchRecipeCategory.RECIPE_TYPE, recipeManager.getAllRecipesFor(CSRecipies.CHEMICAL_BENCH_TYPE.get()).stream().map(RecipeHolder::value).toList());
        registration.addRecipes(SpinCoaterRecipeCategory.RECIPE_TYPE, recipeManager.getAllRecipesFor(CSRecipies.SPIN_COATER_TYPE.get()).stream().map(RecipeHolder::value).toList());
        registration.addRecipes(RedoxFurnaceRecipeCategory.RECIPE_TYPE, recipeManager.getAllRecipesFor(CSRecipies.REDOX_FURNACE_TYPE.get()).stream().map(RecipeHolder::value).toList());

    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IGuiHelper guiHelper = registration.getJeiHelpers().getGuiHelper();
        registration.addRecipeCategories(new CircuitMakerRecipeCategory(guiHelper));
        registration.addRecipeCategories(new FractionatingColumnRecipeCategory(guiHelper));
        registration.addRecipeCategories(new HDSUnitRecipeCategory(guiHelper));
        registration.addRecipeCategories(new SteamCrackerRecipeCategory(guiHelper));
        registration.addRecipeCategories(new CatalyticReformerRecipeCategory(guiHelper));
        registration.addRecipeCategories(new ChemicalBenchRecipeCategory(guiHelper));
        registration.addRecipeCategories(new SpinCoaterRecipeCategory(guiHelper));
        registration.addRecipeCategories(new RedoxFurnaceRecipeCategory(guiHelper));
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registry) {
        registry.addRecipeClickArea(ScreenCircuitMaker.class, 124, 54, 22, 16, CircuitMakerRecipeCategory.RECIPE_TYPE);
        registry.addRecipeClickArea(ScreenFractionatingColumn.class, 39, 34, 64, 15, FractionatingColumnRecipeCategory.RECIPE_TYPE);
        registry.addRecipeClickArea(ScreenHDSUnit.class, 56, 45, 64, 13, HDSUnitRecipeCategory.RECIPE_TYPE);
        registry.addRecipeClickArea(ScreenSteamCracker.class, 50, 45, 22, 16, SteamCrackerRecipeCategory.RECIPE_TYPE);
        registry.addRecipeClickArea(ScreenCatalyticReformer.class, 50, 45, 22, 16, CatalyticReformerRecipeCategory.RECIPE_TYPE);
        registry.addRecipeClickArea(ScreenChemicalBench.class, 56, 49, 64, 13, ChemicalBenchRecipeCategory.RECIPE_TYPE);
        registry.addRecipeClickArea(ScreenSpinCoater.class, 43, 30, 64, 13, SpinCoaterRecipeCategory.RECIPE_TYPE);
        registry.addRecipeClickArea(ScreenRedoxFurnace.class, 57, 46, 22, 16, RedoxFurnaceRecipeCategory.RECIPE_TYPE);
    }

    @Override
    public void registerExtraIngredients(@NotNull IExtraIngredientRegistration registration) {
        List<FluidStack> fluids = new ArrayList<>();
        for (DeferredHolder<Fluid, ? extends Fluid> fluid : CSFluids.FLUIDS.getEntries()) {
            fluids.add(new FluidStack(fluid.get(), 1000));
        }
        registration.addExtraIngredients(NeoForgeTypes.FLUID_STACK, fluids);

        List<GasStack> gases = new ArrayList<>();
        for(DeferredHolder<Gas, ? extends Gas> gas : CSGases.GASES.getEntries()) {
            if(gas.get() == VoltaicGases.EMPTY.value()) {
                continue;
            }

            gases.add(new GasStack(gas.get(), 1000, Gas.ROOM_TEMPERATURE, Gas.PRESSURE_AT_SEA_LEVEL));
        }
        registration.addExtraIngredients(VoltaicJeiTypes.GAS_STACK, gases);
    }
}