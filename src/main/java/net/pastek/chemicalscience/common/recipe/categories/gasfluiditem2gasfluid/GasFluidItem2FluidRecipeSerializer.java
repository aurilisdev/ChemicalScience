package net.pastek.chemicalscience.common.recipe.categories.gasfluiditem2gasfluid;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.neoforge.fluids.FluidStack;
import voltaic.common.recipe.VoltaicRecipeSerializer;
import voltaic.common.recipe.recipeutils.CountableIngredient;
import voltaic.common.recipe.recipeutils.FluidIngredient;
import voltaic.common.recipe.recipeutils.GasIngredient;
import voltaic.common.recipe.recipeutils.ProbableFluid;
import voltaic.common.recipe.recipeutils.ProbableGas;
import voltaic.common.recipe.recipeutils.ProbableItem;
import voltaic.prefab.utilities.CodecUtils;

public class GasFluidItem2FluidRecipeSerializer<T extends GasFluidItem2FluidRecipe> extends VoltaicRecipeSerializer<T> {
    @SuppressWarnings("unused")
    private final GasFluidItem2FluidRecipe.Factory<T> factory;
    private final MapCodec<T> codec;

    private final StreamCodec<RegistryFriendlyByteBuf, T> streamCodec;

    public GasFluidItem2FluidRecipeSerializer(GasFluidItem2FluidRecipe.Factory<T> factory) {
        this.factory = factory;
        codec = RecordCodecBuilder.mapCodec(instance -> instance.group(
                                //
                                Codec.STRING.fieldOf(GROUP).forGetter(T::getGroup),
                                //
                                CountableIngredient.LIST_CODEC.fieldOf(ITEM_INPUTS).forGetter(T::getCountedIngredients),
                                //
                                FluidIngredient.LIST_CODEC.fieldOf(FLUID_INPUTS).forGetter(T::getFluidIngredients),
                                //
                                GasIngredient.LIST_CODEC.fieldOf(GAS_INPUTS).forGetter(T::getGasIngredients),
                                //
                                FluidStack.CODEC.fieldOf(OUTPUT).forGetter(T::getFluidRecipeOutput),
                                //
                                Codec.DOUBLE.optionalFieldOf(EXPERIENCE, 0.0).forGetter(T::getXp),
                                //
                                Codec.INT.fieldOf(TICKS).forGetter(T::getTicks),
                                //
                                Codec.DOUBLE.fieldOf(USAGE_PER_TICK).forGetter(T::getUsagePerTick),
                                //
                                ProbableItem.LIST_CODEC.optionalFieldOf(ITEM_BIPRODUCTS, ProbableItem.NONE).forGetter(T::getItemBiproducts),
                                //
                                ProbableFluid.LIST_CODEC.optionalFieldOf(FLUID_BIPRODUCTS, ProbableFluid.NONE).forGetter(T::getFluidBiproducts),
                                //
                                ProbableGas.LIST_CODEC.optionalFieldOf(GAS_BIPRODUCTS, ProbableGas.NONE).forGetter(T::getGasBiproducts)
                                //

                        )
                        //
                        .apply(instance, factory::create)

        );

        streamCodec = CodecUtils.composite(
                ByteBufCodecs.STRING_UTF8, T::getGroup,
                CountableIngredient.LIST_STREAM_CODEC, T::getCountedIngredients,
                FluidIngredient.LIST_STREAM_CODEC, T::getFluidIngredients,
                GasIngredient.LIST_STREAM_CODEC, T::getGasIngredients,
                FluidStack.STREAM_CODEC, T::getFluidRecipeOutput,
                ByteBufCodecs.DOUBLE, T::getXp,
                ByteBufCodecs.INT, T::getTicks,
                ByteBufCodecs.DOUBLE, T::getUsagePerTick,
                ProbableItem.LIST_STREAM_CODEC, T::getItemBiproducts,
                ProbableFluid.LIST_STREAM_CODEC, T::getFluidBiproducts,
                ProbableGas.LIST_STREAM_CODEC, T::getGasBiproducts,
                factory::create
        );
    }

    @Override
    public MapCodec<T> codec() {
        return codec;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, T> streamCodec() {
        return streamCodec;
    }
}