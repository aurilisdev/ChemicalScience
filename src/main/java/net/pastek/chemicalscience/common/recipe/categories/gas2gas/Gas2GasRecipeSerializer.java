package net.pastek.chemicalscience.common.recipe.categories.gas2gas;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import voltaic.api.gas.GasStack;
import voltaic.common.recipe.VoltaicRecipeSerializer;
import voltaic.common.recipe.recipeutils.GasIngredient;
import voltaic.common.recipe.recipeutils.ProbableFluid;
import voltaic.common.recipe.recipeutils.ProbableGas;
import voltaic.common.recipe.recipeutils.ProbableItem;
import voltaic.prefab.utilities.CodecUtils;

public class Gas2GasRecipeSerializer<T extends Gas2GasRecipe> extends VoltaicRecipeSerializer<T> {
    @SuppressWarnings("unused")
    private final Gas2GasRecipe.Factory<T> factory;
    private final MapCodec<T> codec;

    private final StreamCodec<RegistryFriendlyByteBuf, T> streamCodec;

    public Gas2GasRecipeSerializer(Gas2GasRecipe.Factory<T> factory) {
        this.factory = factory;
        codec = RecordCodecBuilder.mapCodec(instance -> instance.group(
                                //
                                Codec.STRING.fieldOf(GROUP).forGetter(T::getGroup),
                                //
                                GasIngredient.LIST_CODEC.fieldOf(GAS_INPUTS).forGetter(T::getGasIngredients),
                                //
                                GasStack.CODEC.fieldOf(OUTPUT).forGetter(T::getGasRecipeOutput),
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
                GasIngredient.LIST_STREAM_CODEC, T::getGasIngredients,
                GasStack.STREAM_CODEC, T::getGasRecipeOutput,
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