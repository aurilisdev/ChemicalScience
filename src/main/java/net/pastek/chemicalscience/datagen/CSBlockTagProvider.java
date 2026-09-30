package net.pastek.chemicalscience.datagen;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.registers.CSBlocks;
import net.pastek.chemicalscience.registers.CSTags;

public class CSBlockTagProvider extends BlockTagsProvider {
    public CSBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ChemicalScience.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(CSBlocks.ORE_ARSENOPYRITE_MOON.get()).add(CSBlocks.ORE_ARSENOPYRITE_MARS.get()).add(CSBlocks.ORE_ARSENOPYRITE_VENUS.get()).add(CSBlocks.ORE_ARSENOPYRITE_MERCURY.get()).add(CSBlocks.ORE_COOPERITE_MOON.get()).add(CSBlocks.ORE_COOPERITE_MARS.get()).add(CSBlocks.ORE_COOPERITE_VENUS.get()).add(CSBlocks.ORE_COOPERITE_MERCURY.get()).add(CSBlocks.ORE_MAGNESIUM_MOON.get()).add(CSBlocks.ORE_MAGNESIUM_MARS.get()).add(CSBlocks.ORE_MAGNESIUM_VENUS.get()).add(CSBlocks.ORE_MAGNESIUM_MERCURY.get()).add(CSBlocks.ORE_PYROLUSITE_MOON.get()).add(CSBlocks.ORE_PYROLUSITE_MARS.get()).add(CSBlocks.ORE_PYROLUSITE_VENUS.get()).add(CSBlocks.ORE_PYROLUSITE_MERCURY.get()).add(CSBlocks.ORE_SILICON_MOON.get()).add(CSBlocks.ORE_SILICON_MARS.get()).add(CSBlocks.ORE_SILICON_VENUS.get()).add(CSBlocks.ORE_SILICON_MERCURY.get()).add(CSBlocks.ORE_WOLFRAMITE_MOON.get()).add(CSBlocks.ORE_WOLFRAMITE_MARS.get()).add(CSBlocks.ORE_WOLFRAMITE_VENUS.get()).add(CSBlocks.ORE_WOLFRAMITE_MERCURY.get()).add(CSBlocks.ORE_ALUMINUM_MOON.get()).add(CSBlocks.ORE_ALUMINUM_MARS.get()).add(CSBlocks.ORE_ALUMINUM_VENUS.get()).add(CSBlocks.ORE_ALUMINUM_MERCURY.get()).add(CSBlocks.ORE_CHROMIUM_MOON.get()).add(CSBlocks.ORE_CHROMIUM_MARS.get()).add(CSBlocks.ORE_CHROMIUM_VENUS.get()).add(CSBlocks.ORE_CHROMIUM_MERCURY.get()).add(CSBlocks.ORE_FLUORITE_MOON.get()).add(CSBlocks.ORE_FLUORITE_MARS.get()).add(CSBlocks.ORE_FLUORITE_VENUS.get()).add(CSBlocks.ORE_FLUORITE_MERCURY.get()).add(CSBlocks.ORE_LEAD_MOON.get()).add(CSBlocks.ORE_LEAD_MARS.get()).add(CSBlocks.ORE_LEAD_VENUS.get()).add(CSBlocks.ORE_LEAD_MERCURY.get()).add(CSBlocks.ORE_LITHIUM_MOON.get()).add(CSBlocks.ORE_LITHIUM_MARS.get()).add(CSBlocks.ORE_LITHIUM_VENUS.get()).add(CSBlocks.ORE_LITHIUM_MERCURY.get()).add(CSBlocks.ORE_MOLYBDENUM_MOON.get()).add(CSBlocks.ORE_MOLYBDENUM_MARS.get()).add(CSBlocks.ORE_MOLYBDENUM_VENUS.get()).add(CSBlocks.ORE_MOLYBDENUM_MERCURY.get()).add(CSBlocks.ORE_MONAZITE_MOON.get()).add(CSBlocks.ORE_MONAZITE_MARS.get()).add(CSBlocks.ORE_MONAZITE_VENUS.get()).add(CSBlocks.ORE_MONAZITE_MERCURY.get()).add(CSBlocks.ORE_NITER_MOON.get()).add(CSBlocks.ORE_NITER_MARS.get()).add(CSBlocks.ORE_NITER_VENUS.get()).add(CSBlocks.ORE_NITER_MERCURY.get()).add(CSBlocks.ORE_SALT_MOON.get()).add(CSBlocks.ORE_SALT_MARS.get()).add(CSBlocks.ORE_SALT_VENUS.get()).add(CSBlocks.ORE_SALT_MERCURY.get()).add(CSBlocks.ORE_SILVER_MOON.get()).add(CSBlocks.ORE_SILVER_MARS.get()).add(CSBlocks.ORE_SILVER_VENUS.get()).add(CSBlocks.ORE_SILVER_MERCURY.get()).add(CSBlocks.ORE_SULFUR_MOON.get()).add(CSBlocks.ORE_SULFUR_MARS.get()).add(CSBlocks.ORE_SULFUR_VENUS.get()).add(CSBlocks.ORE_SULFUR_MERCURY.get()).add(CSBlocks.ORE_SYLVITE_MOON.get()).add(CSBlocks.ORE_SYLVITE_MARS.get()).add(CSBlocks.ORE_SYLVITE_VENUS.get()).add(CSBlocks.ORE_SYLVITE_MERCURY.get()).add(CSBlocks.ORE_TIN_MOON.get()).add(CSBlocks.ORE_TIN_MARS.get()).add(CSBlocks.ORE_TIN_VENUS.get()).add(CSBlocks.ORE_TIN_MERCURY.get()).add(CSBlocks.ORE_TITANIUM_MOON.get()).add(CSBlocks.ORE_TITANIUM_MARS.get()).add(CSBlocks.ORE_TITANIUM_VENUS.get()).add(CSBlocks.ORE_TITANIUM_MERCURY.get()).add(CSBlocks.ORE_THORIUM_MOON.get()).add(CSBlocks.ORE_THORIUM_MARS.get()).add(CSBlocks.ORE_THORIUM_VENUS.get()).add(CSBlocks.ORE_THORIUM_MERCURY.get()).add(CSBlocks.ORE_URANIUM_MOON.get()).add(CSBlocks.ORE_URANIUM_MARS.get()).add(CSBlocks.ORE_URANIUM_VENUS.get()).add(CSBlocks.ORE_URANIUM_MERCURY.get()).add(CSBlocks.ORE_VANADIUM_MOON.get()).add(CSBlocks.ORE_VANADIUM_MARS.get()).add(CSBlocks.ORE_VANADIUM_VENUS.get()).add(CSBlocks.ORE_VANADIUM_MERCURY.get())
                .add(
                        // Ores
                        CSBlocks.ORE_MAGNESIUM.get(),
                        CSBlocks.ORE_DEEPSLATE_MAGNESIUM.get(),
                        CSBlocks.ORE_SILICON.get(),
                        CSBlocks.ORE_DEEPSLATE_SILICON.get(),
                        CSBlocks.ORE_ARSENOPYRITE.get(),
                        CSBlocks.ORE_DEEPSLATE_ARSENOPYRITE.get(),
                        CSBlocks.ORE_WOLFRAMITE.get(),
                        CSBlocks.ORE_DEEPSLATE_WOLFRAMITE.get(),
                        CSBlocks.ORE_COOPERITE.get(),
                        CSBlocks.ORE_DEEPSLATE_COOPERITE.get(),
                        CSBlocks.ORE_PYROLUSITE.get(),
                        CSBlocks.ORE_DEEPSLATE_PYROLUSITE.get(),
                        CSBlocks.ORE_OIL.get(),
                        CSBlocks.ORE_DEEPSLATE_OIL.get(),

                        //Ressource Blocks
                        CSBlocks.MAGNESIUM_BLOCK.get(),
                        CSBlocks.SILICON_BLOCK.get(),
                        CSBlocks.MANGANESE_BLOCK.get(),
                        CSBlocks.TUNGSTEN_BLOCK.get(),
                        CSBlocks.PLATINUM_BLOCK.get(),

                        //Decorative
                        CSBlocks.MAGNESIUM_GA9Z1_BLOCK.get(),
                        CSBlocks.MAGNESIUM_GA9Z1_LAMP.get(),
                        CSBlocks.MAGNESIUM_GA9Z1_STAIR.get(),
                        CSBlocks.MAGNESIUM_GA9Z1_SLAB.get(),
                        CSBlocks.MAGNESIUM_GA9Z1_DOOR.get(),
                        CSBlocks.MAGNESIUM_GA9Z1_TRAPDOOR.get(),
                        CSBlocks.MAGNESIUM_GA9Z1_FENCE.get(),

                        CSBlocks.GRATE_MANGANESE.get(),
                        CSBlocks.LADDER_MANGANESE.get(),
                        CSBlocks.SCAFFOLDING_MANGANESE.get(),
                        CSBlocks.SCAFFOLDING_MANGANESE_GRATE.get(),
                        CSBlocks.SCAFFOLDING_MANGANESE_GLASS.get(),
                        CSBlocks.SCAFFOLDING_MANGANESE_HOLLOW.get(),
                        CSBlocks.SCAFFOLDING_MANGANESE_GRATE_HOLLOW.get(),
                        CSBlocks.SCAFFOLDING_MANGANESE_GLASS_HOLLOW.get(),
                        CSBlocks.SCAFFOLDING_MANGANESE_SLAB.get(),
                        CSBlocks.SCAFFOLDING_MANGANESE_GRATE_SLAB.get(),
                        CSBlocks.SCAFFOLDING_MANGANESE_GLASS_SLAB.get(),

                        CSBlocks.GRATE_STEEL.get(),
                        CSBlocks.LADDER_STEEL.get(),
                        CSBlocks.SCAFFOLDING_STEEL_GRATE.get(),
                        CSBlocks.SCAFFOLDING_STEEL_GLASS.get(),
                        CSBlocks.SCAFFOLDING_STEEL_HOLLOW.get(),
                        CSBlocks.SCAFFOLDING_STEEL_GRATE_HOLLOW.get(),
                        CSBlocks.SCAFFOLDING_STEEL_GLASS_HOLLOW.get(),
                        CSBlocks.SCAFFOLDING_STEEL_SLAB.get(),
                        CSBlocks.SCAFFOLDING_STEEL_GRATE_SLAB.get(),
                        CSBlocks.SCAFFOLDING_STEEL_GLASS_SLAB.get(),

                        CSBlocks.METAL_HALIDE_LAMP_MANGANESE_WHITE.get(),
                        CSBlocks.METAL_HALIDE_LAMP_MANGANESE_RED.get(),
                        CSBlocks.METAL_HALIDE_LAMP_MANGANESE_GREEN.get(),
                        CSBlocks.METAL_HALIDE_LAMP_MANGANESE_BLUE.get(),
                        CSBlocks.METAL_HALIDE_LAMP_STEEL_WHITE.get(),
                        CSBlocks.METAL_HALIDE_LAMP_STEEL_RED.get(),
                        CSBlocks.METAL_HALIDE_LAMP_STEEL_GREEN.get(),
                        CSBlocks.METAL_HALIDE_LAMP_STEEL_BLUE.get(),

                        CSBlocks.RACK_MANGANESE.get(),
                        CSBlocks.RACK_STEEL.get(),

                        CSBlocks.LABORATORY_BENCH.get(),
                        CSBlocks.LABORATORY_SUPPORT.get(),
                        CSBlocks.LABORATORY_SINK.get(),
                        CSBlocks.LABORATORY_STORAGE.get(),

                        CSBlocks.ASPHALT_BLOCK.get(),
                        CSBlocks.ASPHALT_STAIR.get(),
                        CSBlocks.ASPHALT_SLAB.get(),
                        CSBlocks.MARKED_LINE_WHITE_ASPHALT_BLOCK.get(),
                        CSBlocks.MARKED_DOT_WHITE_ASPHALT_BLOCK.get(),
                        CSBlocks.MARKED_LINE_YELLOW_ASPHALT_BLOCK.get(),
                        CSBlocks.MARKED_DOT_YELLOW_ASPHALT_BLOCK.get(),

                        CSBlocks.CONCRETE_SHIELDING.get(),
                        CSBlocks.TANTALUM_SHIELDING.get(),

                        //Machines
                        CSBlocks.ORGANIC_SOLAR_PANEL.get(),
                        CSBlocks.FUEL_CELL.get(),
                        CSBlocks.HDS_UNIT.get(),
                        CSBlocks.STEAM_CRACKER.get(),
                        CSBlocks.CATALYTIC_REFORMER.get(),
                        CSBlocks.SPIN_COATER.get(),
                        CSBlocks.FRACTIONATING_COLUMN.get(),
                        CSBlocks.CHEMICAL_BENCH.get(),
                        CSBlocks.REDOX_FURNACE.get()

                );
        tag(BlockTags.MINEABLE_WITH_HOE)
                .add(
                        CSBlocks.ORGANIC_SOLAR_PANEL.get()
                );
        tag(BlockTags.NEEDS_STONE_TOOL).add(
                        CSBlocks.ORE_MAGNESIUM.get(),
                        CSBlocks.ORE_DEEPSLATE_MAGNESIUM.get(),
                        CSBlocks.ORE_PYROLUSITE.get(),
                        CSBlocks.ORE_DEEPSLATE_PYROLUSITE.get(),
                        CSBlocks.ORE_OIL.get(),
                        CSBlocks.ORE_DEEPSLATE_OIL.get()
                );
        tag(BlockTags.NEEDS_IRON_TOOL).add(CSBlocks.ORE_ARSENOPYRITE_MOON.get()).add(CSBlocks.ORE_ARSENOPYRITE_MARS.get()).add(CSBlocks.ORE_ARSENOPYRITE_VENUS.get()).add(CSBlocks.ORE_ARSENOPYRITE_MERCURY.get()).add(CSBlocks.ORE_COOPERITE_MOON.get()).add(CSBlocks.ORE_COOPERITE_MARS.get()).add(CSBlocks.ORE_COOPERITE_VENUS.get()).add(CSBlocks.ORE_COOPERITE_MERCURY.get()).add(CSBlocks.ORE_MAGNESIUM_MOON.get()).add(CSBlocks.ORE_MAGNESIUM_MARS.get()).add(CSBlocks.ORE_MAGNESIUM_VENUS.get()).add(CSBlocks.ORE_MAGNESIUM_MERCURY.get()).add(CSBlocks.ORE_PYROLUSITE_MOON.get()).add(CSBlocks.ORE_PYROLUSITE_MARS.get()).add(CSBlocks.ORE_PYROLUSITE_VENUS.get()).add(CSBlocks.ORE_PYROLUSITE_MERCURY.get()).add(CSBlocks.ORE_SILICON_MOON.get()).add(CSBlocks.ORE_SILICON_MARS.get()).add(CSBlocks.ORE_SILICON_VENUS.get()).add(CSBlocks.ORE_SILICON_MERCURY.get()).add(CSBlocks.ORE_WOLFRAMITE_MOON.get()).add(CSBlocks.ORE_WOLFRAMITE_MARS.get()).add(CSBlocks.ORE_WOLFRAMITE_VENUS.get()).add(CSBlocks.ORE_WOLFRAMITE_MERCURY.get()).add(CSBlocks.ORE_ALUMINUM_MOON.get()).add(CSBlocks.ORE_ALUMINUM_MARS.get()).add(CSBlocks.ORE_ALUMINUM_VENUS.get()).add(CSBlocks.ORE_ALUMINUM_MERCURY.get()).add(CSBlocks.ORE_CHROMIUM_MOON.get()).add(CSBlocks.ORE_CHROMIUM_MARS.get()).add(CSBlocks.ORE_CHROMIUM_VENUS.get()).add(CSBlocks.ORE_CHROMIUM_MERCURY.get()).add(CSBlocks.ORE_FLUORITE_MOON.get()).add(CSBlocks.ORE_FLUORITE_MARS.get()).add(CSBlocks.ORE_FLUORITE_VENUS.get()).add(CSBlocks.ORE_FLUORITE_MERCURY.get()).add(CSBlocks.ORE_LEAD_MOON.get()).add(CSBlocks.ORE_LEAD_MARS.get()).add(CSBlocks.ORE_LEAD_VENUS.get()).add(CSBlocks.ORE_LEAD_MERCURY.get()).add(CSBlocks.ORE_LITHIUM_MOON.get()).add(CSBlocks.ORE_LITHIUM_MARS.get()).add(CSBlocks.ORE_LITHIUM_VENUS.get()).add(CSBlocks.ORE_LITHIUM_MERCURY.get()).add(CSBlocks.ORE_MOLYBDENUM_MOON.get()).add(CSBlocks.ORE_MOLYBDENUM_MARS.get()).add(CSBlocks.ORE_MOLYBDENUM_VENUS.get()).add(CSBlocks.ORE_MOLYBDENUM_MERCURY.get()).add(CSBlocks.ORE_MONAZITE_MOON.get()).add(CSBlocks.ORE_MONAZITE_MARS.get()).add(CSBlocks.ORE_MONAZITE_VENUS.get()).add(CSBlocks.ORE_MONAZITE_MERCURY.get()).add(CSBlocks.ORE_NITER_MOON.get()).add(CSBlocks.ORE_NITER_MARS.get()).add(CSBlocks.ORE_NITER_VENUS.get()).add(CSBlocks.ORE_NITER_MERCURY.get()).add(CSBlocks.ORE_SALT_MOON.get()).add(CSBlocks.ORE_SALT_MARS.get()).add(CSBlocks.ORE_SALT_VENUS.get()).add(CSBlocks.ORE_SALT_MERCURY.get()).add(CSBlocks.ORE_SILVER_MOON.get()).add(CSBlocks.ORE_SILVER_MARS.get()).add(CSBlocks.ORE_SILVER_VENUS.get()).add(CSBlocks.ORE_SILVER_MERCURY.get()).add(CSBlocks.ORE_SULFUR_MOON.get()).add(CSBlocks.ORE_SULFUR_MARS.get()).add(CSBlocks.ORE_SULFUR_VENUS.get()).add(CSBlocks.ORE_SULFUR_MERCURY.get()).add(CSBlocks.ORE_SYLVITE_MOON.get()).add(CSBlocks.ORE_SYLVITE_MARS.get()).add(CSBlocks.ORE_SYLVITE_VENUS.get()).add(CSBlocks.ORE_SYLVITE_MERCURY.get()).add(CSBlocks.ORE_TIN_MOON.get()).add(CSBlocks.ORE_TIN_MARS.get()).add(CSBlocks.ORE_TIN_VENUS.get()).add(CSBlocks.ORE_TIN_MERCURY.get()).add(CSBlocks.ORE_TITANIUM_MOON.get()).add(CSBlocks.ORE_TITANIUM_MARS.get()).add(CSBlocks.ORE_TITANIUM_VENUS.get()).add(CSBlocks.ORE_TITANIUM_MERCURY.get()).add(CSBlocks.ORE_THORIUM_MOON.get()).add(CSBlocks.ORE_THORIUM_MARS.get()).add(CSBlocks.ORE_THORIUM_VENUS.get()).add(CSBlocks.ORE_THORIUM_MERCURY.get()).add(CSBlocks.ORE_URANIUM_MOON.get()).add(CSBlocks.ORE_URANIUM_MARS.get()).add(CSBlocks.ORE_URANIUM_VENUS.get()).add(CSBlocks.ORE_URANIUM_MERCURY.get()).add(CSBlocks.ORE_VANADIUM_MOON.get()).add(CSBlocks.ORE_VANADIUM_MARS.get()).add(CSBlocks.ORE_VANADIUM_VENUS.get()).add(CSBlocks.ORE_VANADIUM_MERCURY.get())
                .add(
                        CSBlocks.ORE_SILICON.get(),
                        CSBlocks.ORE_DEEPSLATE_SILICON.get(),
                        CSBlocks.ORE_ARSENOPYRITE.get(),
                        CSBlocks.ORE_DEEPSLATE_ARSENOPYRITE.get(),
                        CSBlocks.ORE_WOLFRAMITE.get(),
                        CSBlocks.ORE_DEEPSLATE_WOLFRAMITE.get()
                );
        tag(BlockTags.CLIMBABLE)
                .add(
                        CSBlocks.LADDER_MANGANESE.get(),
                        CSBlocks.SCAFFOLDING_MANGANESE_HOLLOW.get(),
                        CSBlocks.SCAFFOLDING_MANGANESE_GRATE_HOLLOW.get(),
                        CSBlocks.SCAFFOLDING_MANGANESE_GLASS_HOLLOW.get(),
                        CSBlocks.LADDER_STEEL.get(),
                        CSBlocks.SCAFFOLDING_STEEL_HOLLOW.get(),
                        CSBlocks.SCAFFOLDING_STEEL_GRATE_HOLLOW.get(),
                        CSBlocks.SCAFFOLDING_STEEL_GLASS_HOLLOW.get()
                );

        tag(BlockTags.FENCES)
                .add(
                        CSBlocks.MAGNESIUM_GA9Z1_FENCE.get()
                );

        tag(CSTags.Blocks.NEEDS_TUNGSTEN_TOOL)
                .addTag(
                        BlockTags.NEEDS_DIAMOND_TOOL
                );

        tag(CSTags.Blocks.INCORRECT_FOR_TUNGSTEN_TOOL)
                .addTag(
                        BlockTags.INCORRECT_FOR_DIAMOND_TOOL
                )
                .remove(
                        CSTags.Blocks.NEEDS_TUNGSTEN_TOOL
                );
    }
}
