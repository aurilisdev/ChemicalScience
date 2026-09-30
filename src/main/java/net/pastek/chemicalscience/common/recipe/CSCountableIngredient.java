package net.pastek.chemicalscience.common.recipe;

import java.util.List;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.Ingredient;
import voltaic.common.recipe.recipeutils.CountableIngredient;

public record CSCountableIngredient(CountableIngredient ingredient, boolean isCatalyst) {
    public static final Codec<CSCountableIngredient> CODEC = RecordCodecBuilder.create(inst -> inst.group(
            Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(cs -> cs.ingredient().toVanilla()),
            Codec.INT.fieldOf("count").forGetter(cs -> cs.ingredient().getStackSize()),
            Codec.BOOL.optionalFieldOf("catalyst", false).forGetter(CSCountableIngredient::isCatalyst)
    ).apply(inst, (ing, count, catalyst) ->
            new CSCountableIngredient(new CountableIngredient(ing, count), catalyst)
    ));

    public static final StreamCodec<RegistryFriendlyByteBuf, CSCountableIngredient> STREAM_CODEC = StreamCodec.composite(
            CountableIngredient.STREAM_CODEC, CSCountableIngredient::ingredient,
            ByteBufCodecs.BOOL, CSCountableIngredient::isCatalyst,
            CSCountableIngredient::new
    );

    public static final Codec<List<CSCountableIngredient>> LIST_CODEC = CODEC.listOf();

    public static final StreamCodec<RegistryFriendlyByteBuf, List<CSCountableIngredient>> LIST_STREAM_CODEC =
            STREAM_CODEC.apply(ByteBufCodecs.list());
}
