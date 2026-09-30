package net.pastek.chemicalscience.common.recipe.categories.misc;

import java.util.Collections;

import org.jetbrains.annotations.NotNull;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.fluids.FluidStack;
import net.pastek.chemicalscience.common.recipe.CSCountableIngredient;
import voltaic.api.gas.GasStack;
import voltaic.common.recipe.VoltaicRecipeSerializer;
import voltaic.common.recipe.recipeutils.FluidIngredient;
import voltaic.common.recipe.recipeutils.GasIngredient;
import voltaic.common.recipe.recipeutils.ProbableFluid;
import voltaic.common.recipe.recipeutils.ProbableGas;
import voltaic.common.recipe.recipeutils.ProbableItem;
import voltaic.prefab.utilities.CodecUtils;

public class ChemicalBenchRecipeSerializer extends VoltaicRecipeSerializer<ChemicalBenchRecipe> {

    private static final MapCodec<ChemicalBenchRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                    Codec.STRING.fieldOf(GROUP).forGetter(ChemicalBenchRecipe::getGroup),
                    CSCountableIngredient.LIST_CODEC.optionalFieldOf(ITEM_INPUTS, Collections.emptyList()).forGetter(ChemicalBenchRecipe::getCSCountedIngredients),
                    FluidIngredient.LIST_CODEC.optionalFieldOf(FLUID_INPUTS, Collections.emptyList()).forGetter(ChemicalBenchRecipe::getFluidIngredients),
                    GasIngredient.LIST_CODEC.optionalFieldOf(GAS_INPUTS, Collections.emptyList()).forGetter(ChemicalBenchRecipe::getGasIngredients),
                    ItemStack.OPTIONAL_CODEC.optionalFieldOf("itemoutput", ItemStack.EMPTY).forGetter(ChemicalBenchRecipe::getItemRecipeOutput),
                    FluidStack.OPTIONAL_CODEC.optionalFieldOf("fluidoutput", FluidStack.EMPTY).forGetter(ChemicalBenchRecipe::getFluidRecipeOutput),
                    GasStack.CODEC.optionalFieldOf("gasoutput", GasStack.EMPTY).forGetter(ChemicalBenchRecipe::getGasRecipeOutput),
                    Codec.DOUBLE.optionalFieldOf(EXPERIENCE, 0.0).forGetter(ChemicalBenchRecipe::getXp),
                    Codec.INT.fieldOf(TICKS).forGetter(ChemicalBenchRecipe::getTicks),
                    Codec.DOUBLE.fieldOf(USAGE_PER_TICK).forGetter(ChemicalBenchRecipe::getUsagePerTick),
                    ProbableItem.LIST_CODEC.optionalFieldOf(ITEM_BIPRODUCTS, ProbableItem.NONE).forGetter(ChemicalBenchRecipe::getItemBiproducts),
                    ProbableFluid.LIST_CODEC.optionalFieldOf(FLUID_BIPRODUCTS, ProbableFluid.NONE).forGetter(ChemicalBenchRecipe::getFluidBiproducts),
                    ProbableGas.LIST_CODEC.optionalFieldOf(GAS_BIPRODUCTS, ProbableGas.NONE).forGetter(ChemicalBenchRecipe::getGasBiproducts)
            ).apply(instance, ChemicalBenchRecipe::new));

    private static final StreamCodec<RegistryFriendlyByteBuf, ChemicalBenchRecipe> STREAM_CODEC = CodecUtils.composite(
            ByteBufCodecs.STRING_UTF8, ChemicalBenchRecipe::getGroup,
            CSCountableIngredient.LIST_STREAM_CODEC, ChemicalBenchRecipe::getCSCountedIngredients,
            FluidIngredient.LIST_STREAM_CODEC, ChemicalBenchRecipe::getFluidIngredients,
            GasIngredient.LIST_STREAM_CODEC, ChemicalBenchRecipe::getGasIngredients,
            ItemStack.OPTIONAL_STREAM_CODEC, ChemicalBenchRecipe::getItemRecipeOutput,
            FluidStack.OPTIONAL_STREAM_CODEC, ChemicalBenchRecipe::getFluidRecipeOutput,
            GasStack.STREAM_CODEC, ChemicalBenchRecipe::getGasRecipeOutput,
            ByteBufCodecs.DOUBLE, ChemicalBenchRecipe::getXp,
            ByteBufCodecs.INT, ChemicalBenchRecipe::getTicks,
            ByteBufCodecs.DOUBLE, ChemicalBenchRecipe::getUsagePerTick,
            ProbableItem.LIST_STREAM_CODEC, ChemicalBenchRecipe::getItemBiproducts,
            ProbableFluid.LIST_STREAM_CODEC, ChemicalBenchRecipe::getFluidBiproducts,
            ProbableGas.LIST_STREAM_CODEC, ChemicalBenchRecipe::getGasBiproducts,
            ChemicalBenchRecipe::new
    );

    @Override
    public @NotNull MapCodec<ChemicalBenchRecipe> codec() {
        return CODEC;
    }

    @Override
    public @NotNull StreamCodec<RegistryFriendlyByteBuf, ChemicalBenchRecipe> streamCodec() {
        return STREAM_CODEC;
    }
}