package net.pastek.chemicalscience.registers;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pastek.chemicalscience.common.recipe.categories.fluid2fluid.specificmachines.FractionatingColumnRecipe;
import net.pastek.chemicalscience.common.recipe.categories.fluid2item.specificmachines.SpinCoaterRecipe;
import net.pastek.chemicalscience.common.recipe.categories.fluiditem2fluid.specificmachines.CatalyticReformerRecipe;
import net.pastek.chemicalscience.common.recipe.categories.fluiditem2item.specificmachines.CircuitMakerRecipe;
import net.pastek.chemicalscience.common.recipe.categories.gas2gas.Gas2GasRecipeSerializer;
import net.pastek.chemicalscience.common.recipe.categories.gas2gas.specificmachines.SteamCrackerRecipe;
import net.pastek.chemicalscience.common.recipe.categories.gasfluiditem2gasfluid.GasFluidItem2FluidRecipeSerializer;
import net.pastek.chemicalscience.common.recipe.categories.gasfluiditem2gasfluid.specificmachines.HDSUnitRecipe;
import net.pastek.chemicalscience.common.recipe.categories.item2item.specificmachines.RedoxFurnaceRecipe;
import net.pastek.chemicalscience.common.recipe.categories.misc.ChemicalBenchRecipe;
import net.pastek.chemicalscience.common.recipe.categories.misc.ChemicalBenchRecipeSerializer;
import voltaic.common.recipe.VoltaicRecipeType;
import voltaic.common.recipe.categories.fluid2fluid.Fluid2FluidRecipeSerializer;
import voltaic.common.recipe.categories.fluid2item.Fluid2ItemRecipeSerializer;
import voltaic.common.recipe.categories.fluiditem2fluid.FluidItem2FluidRecipeSerializer;
import voltaic.common.recipe.categories.fluiditem2item.FluidItem2ItemRecipeSerializer;
import voltaic.common.recipe.categories.item2item.Item2ItemRecipeSerializer;

public class CSRecipies {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZER;
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES;
    public static final DeferredHolder<RecipeType<?>, RecipeType<CircuitMakerRecipe>> CIRCUIT_MAKER_TYPE;
    public static final DeferredHolder<RecipeType<?>, RecipeType<HDSUnitRecipe>> HDS_UNIT_TYPE;
    public static final DeferredHolder<RecipeType<?>, RecipeType<SteamCrackerRecipe>> STEAM_CRACKER_TYPE;
    public static final DeferredHolder<RecipeType<?>, RecipeType<CatalyticReformerRecipe>> CATALYTIC_REFORMER_TYPE;
    public static final DeferredHolder<RecipeType<?>, RecipeType<FractionatingColumnRecipe>> FRACTIONATING_COLUMN_TYPE;
    public static final DeferredHolder<RecipeType<?>, RecipeType<ChemicalBenchRecipe>> CHEMICAL_BENCH_TYPE;
    public static final DeferredHolder<RecipeType<?>, RecipeType<SpinCoaterRecipe>> SPIN_COATER_TYPE;
    public static final DeferredHolder<RecipeType<?>, RecipeType<RedoxFurnaceRecipe>> REDOX_FURNACE_TYPE;
    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<?>> CIRCUIT_MAKER_SERIALIZER;
    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<?>> HDS_UNIT_SERIALIZER;
    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<?>> STEAM_CRACKER_SERIALIZER;
    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<?>> CATALYTIC_REFORMER_SERIALIZER;
    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<?>> FRACTIONATING_COLUMN_SERIALIZER;
    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<?>> CHEMICAL_BENCH_SERIALIZER;
    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<?>> SPIN_COATER_SERIALIZER;
    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<?>> REDOX_FURNACE_SERIALIZER;

    static {
        RECIPE_SERIALIZER = DeferredRegister.create(Registries.RECIPE_SERIALIZER, "chemicalscience");
        RECIPE_TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, "chemicalscience");

        CIRCUIT_MAKER_TYPE = RECIPE_TYPES.register("circuit_maker_recipe", VoltaicRecipeType::new);
        HDS_UNIT_TYPE = RECIPE_TYPES.register("hds_unit_recipe", VoltaicRecipeType::new);
        STEAM_CRACKER_TYPE = RECIPE_TYPES.register("steam_cracker_recipe", VoltaicRecipeType::new);
        CATALYTIC_REFORMER_TYPE = RECIPE_TYPES.register("catalytic_reformer_recipe", VoltaicRecipeType::new);
        FRACTIONATING_COLUMN_TYPE = RECIPE_TYPES.register("fractionating_column_recipe", VoltaicRecipeType::new);
        CHEMICAL_BENCH_TYPE = RECIPE_TYPES.register("chemical_bench_recipe", VoltaicRecipeType::new);
        SPIN_COATER_TYPE = RECIPE_TYPES.register("spin_coater_recipe", VoltaicRecipeType::new);
        REDOX_FURNACE_TYPE = RECIPE_TYPES.register("redox_furnace_recipe", VoltaicRecipeType::new);

        CIRCUIT_MAKER_SERIALIZER = RECIPE_SERIALIZER.register("circuit_maker_recipe", () -> new FluidItem2ItemRecipeSerializer<>(CircuitMakerRecipe::new));
        HDS_UNIT_SERIALIZER = RECIPE_SERIALIZER.register("hds_unit_recipe", () -> new GasFluidItem2FluidRecipeSerializer<>(HDSUnitRecipe::new));
        STEAM_CRACKER_SERIALIZER = RECIPE_SERIALIZER.register("steam_cracker_recipe", () -> new Gas2GasRecipeSerializer<>(SteamCrackerRecipe::new));
        CATALYTIC_REFORMER_SERIALIZER = RECIPE_SERIALIZER.register("catalytic_reformer_recipe", () -> new FluidItem2FluidRecipeSerializer<>(CatalyticReformerRecipe::new));
        FRACTIONATING_COLUMN_SERIALIZER = RECIPE_SERIALIZER.register("fractionating_column_recipe", () -> new Fluid2FluidRecipeSerializer<>(FractionatingColumnRecipe::new));
        CHEMICAL_BENCH_SERIALIZER = RECIPE_SERIALIZER.register("chemical_bench_recipe", ChemicalBenchRecipeSerializer::new);
        SPIN_COATER_SERIALIZER = RECIPE_SERIALIZER.register("spin_coater_recipe", () -> new Fluid2ItemRecipeSerializer<>(SpinCoaterRecipe::new));
        REDOX_FURNACE_SERIALIZER = RECIPE_SERIALIZER.register("redox_furnace_recipe", () -> new Item2ItemRecipeSerializer<>(RedoxFurnaceRecipe::new));

    }
}
