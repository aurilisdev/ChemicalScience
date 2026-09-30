package net.pastek.chemicalscience.registers;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.pastek.chemicalscience.ChemicalScience;
import voltaic.Voltaic;

public class CSTags {

    public static void init() {
        Fluids.init();
    }

    public static class Blocks {
        public static final TagKey<Block> NEEDS_TUNGSTEN_TOOL = createTag("needs_tungsten_tool");
        public static final TagKey<Block> INCORRECT_FOR_TUNGSTEN_TOOL = createTag("incorrect_for_tungsten_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");
        public static final TagKey<Item> HAZARD_SYMBOL = createTag("hazard_symbol");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, name));
        }
    }

    public static class Fluids {
        public static final TagKey<Fluid> HYDROGEN = forgeTag("hydrogen");

        private static void init() {

        }

        private static TagKey<Fluid> forgeTag(String name) {
            return FluidTags.create(Voltaic.commonrl(name));
        }
    }
}