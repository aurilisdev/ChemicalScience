package net.pastek.chemicalscience.registers;

import java.util.function.Supplier;

import electrodynamics.registers.ElectrodynamicsBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pastek.chemicalscience.ChemicalScience;

public class CSCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ChemicalScience.MOD_ID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CHEMICAL_SCIENCE_TAB = CREATIVE_MODE_TAB.register("chemicalscience_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(CSBlocks.ORGANIC_SOLAR_PANEL.get())).title(Component.translatable("creativetab.chemicalscience")).displayItems((itemDisplayParameters, output) -> {

        /** Road Map */
        output.accept(CSItems.ROAD_MAP);

        /** BLOCKS */
        /** Ores */
        // Overworld
        output.accept(CSBlocks.ORE_ARSENOPYRITE);
        output.accept(CSBlocks.ORE_MAGNESIUM);
        output.accept(CSBlocks.ORE_SILICON);
        output.accept(CSBlocks.ORE_WOLFRAMITE);
        output.accept(CSBlocks.ORE_COOPERITE);
        output.accept(CSBlocks.ORE_PYROLUSITE);
        output.accept(CSBlocks.ORE_OIL);
        output.accept(CSBlocks.ORE_DEEPSLATE_ARSENOPYRITE);
        output.accept(CSBlocks.ORE_DEEPSLATE_MAGNESIUM);
        output.accept(CSBlocks.ORE_DEEPSLATE_SILICON);
        output.accept(CSBlocks.ORE_DEEPSLATE_WOLFRAMITE);
        output.accept(CSBlocks.ORE_DEEPSLATE_COOPERITE);
        output.accept(CSBlocks.ORE_DEEPSLATE_PYROLUSITE);
        output.accept(CSBlocks.ORE_DEEPSLATE_OIL);
        // Stellaris, Ad Astra, Galacticraft
        if (ModList.get().isLoaded("stellaris")) {output.accept(CSBlocks.ORE_ARSENOPYRITE_MOON);output.accept(CSBlocks.ORE_ARSENOPYRITE_MARS);output.accept(CSBlocks.ORE_ARSENOPYRITE_VENUS);output.accept(CSBlocks.ORE_ARSENOPYRITE_MERCURY);output.accept(CSBlocks.ORE_COOPERITE_MOON);output.accept(CSBlocks.ORE_COOPERITE_MARS);output.accept(CSBlocks.ORE_COOPERITE_VENUS);output.accept(CSBlocks.ORE_COOPERITE_MERCURY);output.accept(CSBlocks.ORE_MAGNESIUM_MOON);output.accept(CSBlocks.ORE_MAGNESIUM_MARS);output.accept(CSBlocks.ORE_MAGNESIUM_VENUS);output.accept(CSBlocks.ORE_MAGNESIUM_MERCURY);output.accept(CSBlocks.ORE_PYROLUSITE_MOON);output.accept(CSBlocks.ORE_PYROLUSITE_MARS);output.accept(CSBlocks.ORE_PYROLUSITE_MERCURY);output.accept(CSBlocks.ORE_PYROLUSITE_VENUS);output.accept(CSBlocks.ORE_SILICON_MOON);output.accept(CSBlocks.ORE_SILICON_MARS);output.accept(CSBlocks.ORE_SILICON_VENUS);output.accept(CSBlocks.ORE_SILICON_MERCURY);output.accept(CSBlocks.ORE_WOLFRAMITE_MOON);output.accept(CSBlocks.ORE_WOLFRAMITE_MARS);output.accept(CSBlocks.ORE_WOLFRAMITE_VENUS);output.accept(CSBlocks.ORE_WOLFRAMITE_MERCURY);output.accept(CSBlocks.ORE_ALUMINUM_MOON);output.accept(CSBlocks.ORE_ALUMINUM_MARS);output.accept(CSBlocks.ORE_ALUMINUM_VENUS);output.accept(CSBlocks.ORE_ALUMINUM_MERCURY);output.accept(CSBlocks.ORE_CHROMIUM_MOON);output.accept(CSBlocks.ORE_CHROMIUM_MARS);output.accept(CSBlocks.ORE_CHROMIUM_VENUS);output.accept(CSBlocks.ORE_CHROMIUM_MERCURY);output.accept(CSBlocks.ORE_FLUORITE_MOON);output.accept(CSBlocks.ORE_FLUORITE_MARS);output.accept(CSBlocks.ORE_FLUORITE_VENUS);output.accept(CSBlocks.ORE_FLUORITE_MERCURY);output.accept(CSBlocks.ORE_LEAD_MOON);output.accept(CSBlocks.ORE_LEAD_MARS);output.accept(CSBlocks.ORE_LEAD_VENUS);output.accept(CSBlocks.ORE_LEAD_MERCURY);output.accept(CSBlocks.ORE_LITHIUM_MOON);output.accept(CSBlocks.ORE_LITHIUM_MARS);output.accept(CSBlocks.ORE_LITHIUM_VENUS);output.accept(CSBlocks.ORE_LITHIUM_MERCURY);output.accept(CSBlocks.ORE_MOLYBDENUM_MOON);output.accept(CSBlocks.ORE_MOLYBDENUM_MARS);output.accept(CSBlocks.ORE_MOLYBDENUM_VENUS);output.accept(CSBlocks.ORE_MOLYBDENUM_MERCURY);output.accept(CSBlocks.ORE_MONAZITE_MOON);output.accept(CSBlocks.ORE_MONAZITE_MARS);output.accept(CSBlocks.ORE_MONAZITE_VENUS);output.accept(CSBlocks.ORE_MONAZITE_MERCURY);output.accept(CSBlocks.ORE_NITER_MOON);output.accept(CSBlocks.ORE_NITER_MARS);output.accept(CSBlocks.ORE_NITER_VENUS);output.accept(CSBlocks.ORE_NITER_MERCURY);output.accept(CSBlocks.ORE_SALT_MOON);output.accept(CSBlocks.ORE_SALT_MARS);output.accept(CSBlocks.ORE_SALT_VENUS);output.accept(CSBlocks.ORE_SALT_MERCURY);output.accept(CSBlocks.ORE_SILVER_MOON);output.accept(CSBlocks.ORE_SILVER_MARS);output.accept(CSBlocks.ORE_SILVER_VENUS);output.accept(CSBlocks.ORE_SILVER_MERCURY);output.accept(CSBlocks.ORE_SULFUR_MOON);output.accept(CSBlocks.ORE_SULFUR_MARS);output.accept(CSBlocks.ORE_SULFUR_VENUS);output.accept(CSBlocks.ORE_SULFUR_MERCURY);output.accept(CSBlocks.ORE_SYLVITE_MOON);output.accept(CSBlocks.ORE_SYLVITE_MARS);output.accept(CSBlocks.ORE_SYLVITE_VENUS);output.accept(CSBlocks.ORE_SYLVITE_MERCURY);output.accept(CSBlocks.ORE_TIN_MOON);output.accept(CSBlocks.ORE_TIN_MARS);output.accept(CSBlocks.ORE_TIN_VENUS);output.accept(CSBlocks.ORE_TIN_MERCURY);output.accept(CSBlocks.ORE_TITANIUM_MOON);output.accept(CSBlocks.ORE_TITANIUM_MARS);output.accept(CSBlocks.ORE_TITANIUM_VENUS);output.accept(CSBlocks.ORE_TITANIUM_MERCURY);output.accept(CSBlocks.ORE_THORIUM_MOON);output.accept(CSBlocks.ORE_THORIUM_MARS);output.accept(CSBlocks.ORE_THORIUM_VENUS);output.accept(CSBlocks.ORE_THORIUM_MERCURY);output.accept(CSBlocks.ORE_URANIUM_MOON);output.accept(CSBlocks.ORE_URANIUM_MARS);output.accept(CSBlocks.ORE_URANIUM_VENUS);output.accept(CSBlocks.ORE_URANIUM_MERCURY);output.accept(CSBlocks.ORE_VANADIUM_MOON);output.accept(CSBlocks.ORE_VANADIUM_MARS);output.accept(CSBlocks.ORE_VANADIUM_VENUS);output.accept(CSBlocks.ORE_VANADIUM_MERCURY);}
        /** Ressource Blocks */
        output.accept(CSBlocks.MAGNESIUM_BLOCK);
        output.accept(CSBlocks.SILICON_BLOCK);
        output.accept(CSBlocks.MANGANESE_BLOCK);
        output.accept(CSBlocks.TUNGSTEN_BLOCK);
        output.accept(CSBlocks.PLATINUM_BLOCK);

        /** Construction Blocks */
        // Magnesium alloy
        output.accept(CSBlocks.MAGNESIUM_GA9Z1_BLOCK);
        output.accept(CSBlocks.MAGNESIUM_GA9Z1_LAMP);
        output.accept(CSBlocks.MAGNESIUM_GA9Z1_STAIR);
        output.accept(CSBlocks.MAGNESIUM_GA9Z1_SLAB);
        output.accept(CSBlocks.MAGNESIUM_GA9Z1_DOOR);
        output.accept(CSBlocks.MAGNESIUM_GA9Z1_TRAPDOOR);
        output.accept(CSBlocks.MAGNESIUM_GA9Z1_FENCE);
        // Scaffolding (Steel)
        output.accept(CSBlocks.GRATE_STEEL);
        output.accept(ElectrodynamicsBlocks.BLOCK_STEELSCAFFOLDING.get());
        output.accept(CSBlocks.SCAFFOLDING_STEEL_GRATE);
        output.accept(CSBlocks.SCAFFOLDING_STEEL_GLASS);
        output.accept(CSBlocks.SCAFFOLDING_STEEL_HOLLOW);
        output.accept(CSBlocks.SCAFFOLDING_STEEL_GRATE_HOLLOW);
        output.accept(CSBlocks.SCAFFOLDING_STEEL_GLASS_HOLLOW);
        output.accept(CSBlocks.SCAFFOLDING_STEEL_SLAB);
        output.accept(CSBlocks.SCAFFOLDING_STEEL_GRATE_SLAB);
        output.accept(CSBlocks.SCAFFOLDING_STEEL_GLASS_SLAB);
        output.accept(CSBlocks.LADDER_STEEL);
        // Scaffolding (Manganese)
        output.accept(CSBlocks.GRATE_MANGANESE);
        output.accept(CSBlocks.SCAFFOLDING_MANGANESE);
        output.accept(CSBlocks.SCAFFOLDING_MANGANESE_GRATE);
        output.accept(CSBlocks.SCAFFOLDING_MANGANESE_GLASS);
        output.accept(CSBlocks.SCAFFOLDING_MANGANESE_HOLLOW);
        output.accept(CSBlocks.SCAFFOLDING_MANGANESE_GRATE_HOLLOW);
        output.accept(CSBlocks.SCAFFOLDING_MANGANESE_GLASS_HOLLOW);
        output.accept(CSBlocks.SCAFFOLDING_MANGANESE_SLAB);
        output.accept(CSBlocks.SCAFFOLDING_MANGANESE_GRATE_SLAB);
        output.accept(CSBlocks.SCAFFOLDING_MANGANESE_GLASS_SLAB);
        output.accept(CSBlocks.LADDER_MANGANESE);
        // Halide Lamps
        output.accept(CSBlocks.METAL_HALIDE_LAMP_MANGANESE_WHITE);
        output.accept(CSBlocks.METAL_HALIDE_LAMP_MANGANESE_RED);
        output.accept(CSBlocks.METAL_HALIDE_LAMP_MANGANESE_GREEN);
        output.accept(CSBlocks.METAL_HALIDE_LAMP_MANGANESE_BLUE);
        output.accept(CSBlocks.METAL_HALIDE_LAMP_STEEL_WHITE);
        output.accept(CSBlocks.METAL_HALIDE_LAMP_STEEL_RED);
        output.accept(CSBlocks.METAL_HALIDE_LAMP_STEEL_GREEN);
        output.accept(CSBlocks.METAL_HALIDE_LAMP_STEEL_BLUE);
        // Symbols
        output.accept(CSBlocks.SYMBOL_BIOHAZARD);
        output.accept(CSBlocks.SYMBOL_RADIATION);
        output.accept(CSBlocks.SYMBOL_ELECTRICAL);
        output.accept(CSBlocks.SYMBOL_DANGER);
        output.accept(CSBlocks.SYMBOL_FLAMMABLE);
        output.accept(CSBlocks.SYMBOL_TOXIC);
        output.accept(CSBlocks.SYMBOL_CORROSIVE);
        output.accept(CSBlocks.SYMBOL_PRESSURE);
        output.accept(CSBlocks.SYMBOL_EXPLOSIVE);
        // Storage
        output.accept(CSBlocks.RACK_MANGANESE);
        output.accept(CSBlocks.RACK_STEEL);
        // Laboratory Decoration
        output.accept(CSBlocks.LABORATORY_BENCH);
        output.accept(CSBlocks.LABORATORY_SUPPORT);
        output.accept(CSBlocks.LABORATORY_SINK);
        output.accept(CSBlocks.LABORATORY_STORAGE);
        // Asphalt
        output.accept(CSBlocks.ASPHALT_BLOCK);
        output.accept(CSBlocks.ASPHALT_STAIR);
        output.accept(CSBlocks.ASPHALT_SLAB);
        output.accept(CSBlocks.MARKED_LINE_WHITE_ASPHALT_BLOCK);
        output.accept(CSBlocks.MARKED_DOT_WHITE_ASPHALT_BLOCK);
        output.accept(CSBlocks.MARKED_LINE_YELLOW_ASPHALT_BLOCK);
        output.accept(CSBlocks.MARKED_DOT_YELLOW_ASPHALT_BLOCK);
        // Radiation Shielding
        output.accept(CSBlocks.CONCRETE_SHIELDING);
        output.accept(CSBlocks.TANTALUM_SHIELDING);
        output.accept(CSBlocks.GLASS_SHIELDING);
        output.accept(CSBlocks.ADVANCED_GLASS_SHIELDING);

        /** Machines */
        output.accept(CSBlocks.ORGANIC_SOLAR_PANEL);
        /* output.accept(CSBlocks.FUEL_CELL); */
        output.accept(CSBlocks.CIRCUIT_MAKER);
        output.accept(CSBlocks.REDOX_FURNACE);
        output.accept(CSBlocks.FRACTIONATING_COLUMN);
        output.accept(CSBlocks.HDS_UNIT);
        output.accept(CSBlocks.STEAM_CRACKER);
        output.accept(CSBlocks.CATALYTIC_REFORMER);
        output.accept(CSBlocks.SPIN_COATER);
        output.accept(CSBlocks.CHEMICAL_BENCH);

        /** ITEMS */
        /** Raw Materials */
        output.accept(CSItems.RAW_ORE_MAGNESIUM);
        output.accept(CSItems.RAW_ORE_SILICON);
        output.accept(CSItems.RAW_ORE_PYROLUSITE);
        output.accept(CSItems.RAW_ORE_ARSENOPYRITE);
        output.accept(CSItems.RAW_ORE_WOLFRAMITE);
        output.accept(CSItems.RAW_ORE_COOPERITE);

        /** Ingots */
        output.accept(CSItems.INGOT_BERYLLIUM);
        output.accept(CSItems.INGOT_BORON);
        output.accept(CSItems.INGOT_BORON_CARBIDE);
        output.accept(CSItems.INGOT_MAGNESIUM);
        output.accept(CSItems.INGOT_MAGNESIUM_ALUMINUM);
        output.accept(CSItems.INGOT_SILICON);
        output.accept(CSItems.INGOT_MANGANESE);
        output.accept(CSItems.INGOT_MANGANESE_ALUMINUM);
        output.accept(CSItems.INGOT_NICKEL);
        output.accept(CSItems.INGOT_MANGANIN);
        output.accept(CSItems.INGOT_ZINC);
        output.accept(CSItems.INGOT_GALLIUMARSENIDE);
        output.accept(CSItems.INGOT_GERMANIUM);
        output.accept(CSItems.INGOT_NIOBIUM);
        output.accept(CSItems.INGOT_NIOBIUM_TITANIUM);
        output.accept(CSItems.INGOT_PALLADIUM);
        output.accept(CSItems.INGOT_TANTALUM);
        output.accept(CSItems.INGOT_TUNGSTEN);
        output.accept(CSItems.INGOT_TUNGSTEN_CARBIDE);
        output.accept(CSItems.INGOT_PLATINUM);

        /** Nuggets */
        output.accept(CSItems.NUGGET_MANGANESEALUMINUM);
        output.accept(CSItems.NUGGET_TUNGSTEN);

        /** Dusts */
        output.accept(CSItems.DUST_BERYLLIUM);
        output.accept(CSItems.DUST_BORON);
        output.accept(CSItems.DUST_ACTIVATEDCARBON);
        output.accept(CSItems.DUST_SODIUM);
        output.accept(CSItems.DUST_MAGNESIUM);
        output.accept(CSItems.DUST_SILICON);
        output.accept(CSItems.DUST_PHOSPHORUS);
        output.accept(CSItems.DUST_POTASSIUM);
        output.accept(CSItems.DUST_CALCIUM);
        output.accept(CSItems.DUST_SCANDIUM);
        output.accept(CSItems.DUST_MANGANESE);
        output.accept(CSItems.DUST_COBALT);
        output.accept(CSItems.DUST_NICKEL);
        output.accept(CSItems.DUST_ZINC);
        output.accept(CSItems.DUST_GALLIUM);
        output.accept(CSItems.DUST_GERMANIUM);
        output.accept(CSItems.DUST_ARSENIC);
        output.accept(CSItems.DUST_SELENIUM);
        output.accept(CSItems.DUST_RUBIDIUM);
        output.accept(CSItems.DUST_STRONTIUM);
        output.accept(CSItems.DUST_YTTRIUM);
        output.accept(CSItems.DUST_NIOBIUM);
        output.accept(CSItems.DUST_TECHNETIUM);
        output.accept(CSItems.DUST_RUTHENIUM);
        output.accept(CSItems.DUST_RHODIUM);
        output.accept(CSItems.DUST_PALLADIUM);
        output.accept(CSItems.DUST_CADMIUM);
        output.accept(CSItems.DUST_INDIUM);
        output.accept(CSItems.DUST_ANTIMONY);
        output.accept(CSItems.DUST_TELLURIUM);
        output.accept(CSItems.DUST_IODINE);
        output.accept(CSItems.DUST_CESIUM);
        output.accept(CSItems.DUST_BARIUM);
        output.accept(CSItems.DUST_LANTHANUM);
        output.accept(CSItems.DUST_CERIUM);
        output.accept(CSItems.DUST_PRASEODYMIUM);
        output.accept(CSItems.DUST_NEODYMIUM);
        output.accept(CSItems.DUST_PROMETHIUM);
        output.accept(CSItems.DUST_SAMARIUM);
        output.accept(CSItems.DUST_EUROPIUM);
        output.accept(CSItems.DUST_GADOLINIUM);
        output.accept(CSItems.DUST_TERBIUM);
        output.accept(CSItems.DUST_DYSPROSIUM);
        output.accept(CSItems.DUST_HOLMIUM);
        output.accept(CSItems.DUST_ERBIUM);
        output.accept(CSItems.DUST_THULIUM);
        output.accept(CSItems.DUST_YTTERBIUM);
        output.accept(CSItems.DUST_LUTECIUM);
        output.accept(CSItems.DUST_HAFNIUM);
        output.accept(CSItems.DUST_TANTALUM);
        output.accept(CSItems.DUST_TUNGSTEN);
        output.accept(CSItems.DUST_RHENIUM);
        output.accept(CSItems.DUST_OSMIUM);
        output.accept(CSItems.DUST_PLATINUM);
        output.accept(CSItems.DUST_BISMUTH);
        output.accept(CSItems.DUST_THORIUM);
        output.accept(CSItems.DUST_URANIUM);

        output.accept(CSItems.IMPURE_DUST_BERYLLIUM);
        output.accept(CSItems.IMPURE_DUST_BORON);
        output.accept(CSItems.IMPURE_DUST_SODIUM);
        output.accept(CSItems.IMPURE_DUST_MAGNESIUM);
        output.accept(CSItems.IMPURE_DUST_SILICON);
        output.accept(CSItems.IMPURE_DUST_POTASSIUM);
        output.accept(CSItems.IMPURE_DUST_CALCIUM);
        output.accept(CSItems.IMPURE_DUST_SCANDIUM);
        output.accept(CSItems.IMPURE_DUST_MANGANESE);
        output.accept(CSItems.IMPURE_DUST_COBALT);
        output.accept(CSItems.IMPURE_DUST_NICKEL);
        output.accept(CSItems.IMPURE_DUST_ZINC);
        output.accept(CSItems.IMPURE_DUST_GALLIUM);
        output.accept(CSItems.IMPURE_DUST_GERMANIUM);
        output.accept(CSItems.IMPURE_DUST_ARSENIC);
        output.accept(CSItems.IMPURE_DUST_SELENIUM);
        output.accept(CSItems.IMPURE_DUST_RUBIDIUM);
        output.accept(CSItems.IMPURE_DUST_STRONTIUM);
        output.accept(CSItems.IMPURE_DUST_YTTRIUM);
        output.accept(CSItems.IMPURE_DUST_NIOBIUM);
        output.accept(CSItems.IMPURE_DUST_RHODIUM);
        output.accept(CSItems.IMPURE_DUST_PALLADIUM);
        output.accept(CSItems.IMPURE_DUST_CADMIUM);
        output.accept(CSItems.IMPURE_DUST_ANTIMONY);
        output.accept(CSItems.IMPURE_DUST_TELLURIUM);
        output.accept(CSItems.IMPURE_DUST_IODINE);
        output.accept(CSItems.IMPURE_DUST_CESIUM);
        output.accept(CSItems.IMPURE_DUST_BARIUM);
        output.accept(CSItems.IMPURE_DUST_CERIUM);
        output.accept(CSItems.IMPURE_DUST_HAFNIUM);
        output.accept(CSItems.IMPURE_DUST_TANTALUM);
        output.accept(CSItems.IMPURE_DUST_TUNGSTEN);
        output.accept(CSItems.IMPURE_DUST_RHENIUM);
        output.accept(CSItems.IMPURE_DUST_OSMIUM);
        output.accept(CSItems.IMPURE_DUST_PLATINUM);
        output.accept(CSItems.IMPURE_DUST_MERCURY);
        output.accept(CSItems.IMPURE_DUST_BISMUTH);
        output.accept(CSItems.IMPURE_DUST_THORIUM);
        output.accept(CSItems.IMPURE_DUST_URANIUM);

        /** Crystals */
        output.accept(CSItems.CRYSTAL_MAGNESIUM);
        output.accept(CSItems.CRYSTAL_MAGNESIUMCHLORIDE);
        output.accept(CSItems.CRYSTAL_POTASSIUMBROMIDE);
        output.accept(CSItems.CRYSTAL_ACETIC_ANHYDRIDE);

        /** Compound Dusts */
        output.accept(CSItems.DUST_CALCIUMOXIDE);
        output.accept(CSItems.DUST_ALUMINA);
        output.accept(CSItems.DUST_IRONOXIDE);
        output.accept(CSItems.DUST_IRONTETROXIDE);
        output.accept(CSItems.DUST_URANIUMOXIDE);
        output.accept(CSItems.DUST_PLUTONIUMOXIDE);
        output.accept(CSItems.DUST_PLUTONIUMHYDROXIDE);
        output.accept(CSItems.DUST_MONAZITE);
        output.accept(CSItems.DUST_POTASSIUMCARBONATE);
        output.accept(CSItems.DUST_TUNGSTEN_CARBIDE);
        output.accept(CSItems.DUST_SILVERFLUORIDE);
        output.accept(CSItems.DUST_PHOSPHORUS_CHLORIDE);
        output.accept(CSItems.DUST_TINCHLORIDE);
        output.accept(CSItems.DUST_PALLADIUM_CHLORIDE);
        output.accept(CSItems.DUST_PLATINUM_CHLORIDE);
        output.accept(CSItems.DUST_IRONARSENIDE);
        output.accept(CSItems.DUST_CHROMIUM_BROMIDE);

        /** Organic Compounds */
        output.accept(CSItems.UREA);
        output.accept(CSItems.DIMETHYLUREA);
        output.accept(CSItems.AMMONIUMCARBONATE);
        output.accept(CSItems.AMMONIUMDIURANATE);
        output.accept(CSItems.OXALICACID);
        output.accept(CSItems.MALONITRILE);
        output.accept(CSItems.SODIUM_CYANIDE);
        output.accept(CSItems.CAFFEINE);
        output.accept(CSItems.SUCCINIMIDE);
        output.accept(CSItems.NBROMOSUCCINIMIDE);
        output.accept(CSItems.TEREPHTHALOYLCHLORIDE);
        output.accept(CSItems.NITROCHLOROBENZENE);
        output.accept(CSItems.PARAPHENYLENEDIAMINE);
        output.accept(CSItems.LI_DIISOPROPYLAMIDE);
        output.accept(CSItems.CINNAMICACID);
        output.accept(CSItems.PHENYLPROPANOICACID);
        output.accept(CSItems.TRIPHENYLPHOSPHINE);
        output.accept(CSItems.TRIMETHYLTINCHLORIDE);
        output.accept(CSItems.DIFLUOROPHENYLPROPIONICACID);
        output.accept(CSItems.DIFLUOROINDANONE);
        output.accept(CSItems.DIFLUORODICYANOMETHYLIDIENEINDANONE);
        output.accept(CSItems.BENZOTHIADIAZOLE);
        output.accept(CSItems.DIBROMOBENZOTHIADIAZOLE);
        output.accept(CSItems.DIBROMODINITROBENZOTHIADIAZOLE);
        output.accept(CSItems.THIENOTHIOPHENE);
        output.accept(CSItems.UNDECYLTHIENOTHIOPHENE);
        output.accept(CSItems.TRIMETHYLSTANNYLUNDECYLTHIENOTHIOPHENE);
        output.accept(CSItems.DINITROUNDECYLTHIENOTHIOPHENEBENZOTHIADIAZOLE);
        output.accept(CSItems.ETHYLHEXYLUNDECYLTHIENOTHIOPHENEPYRROLOBENZOTHIADIAZOLE);
        output.accept(CSItems.ETHYLHEXYLUNDECYLOXOTHIENOTHIOPHENEPYRROLOBENZOTHIADIAZOLE);
        output.accept(CSItems.YBTPF);
        output.accept(CSItems.DIBROMOTHIOPHENEDICARBOXYLICACID);
        output.accept(CSItems.DIBROMOTHIOPHENEDIACYLCHLORIDE);
        output.accept(CSItems.BISETHYLHEXYLTHIOPHENE);
        output.accept(CSItems.DIBROMOETHYLHEXYLTHIENOTHIOPHENEDIKETONE);
        output.accept(CSItems.BENZODITHIOPHENEDIONE);
        output.accept(CSItems.DIBROMOBENZODITHIOPHENDIONE);
        output.accept(CSItems.BDD);
        output.accept(CSItems.DIBROMOBDD);
        output.accept(CSItems.BROMOETHYLHEXYLTHIOPHENE);
        output.accept(CSItems.BROMOETHYLHEXYLTRIMETHYLSILYLTHIOPHENE);
        output.accept(CSItems.FLUOROETHYLHEXYLTRIMETHYLSILYLTHIOPHENE);
        output.accept(CSItems.FLUOROETHYLHEXYLTHIOPHENE);
        output.accept(CSItems.TRIMETHYLTHIOPHENESTANNANE);
        output.accept(CSItems.BDT);
        output.accept(CSItems.TRIMETHYLSTANNANEBDT);
        output.accept(CSItems.PBDBTF);

        /** Plates */
        output.accept(CSItems.PLATE_BERYLLIUM);
        output.accept(CSItems.PLATE_BORONCARBIDE);
        output.accept(CSItems.PLATE_SILICON);
        output.accept(CSItems.PLATE_NIOBIUM);
        output.accept(CSItems.PLATE_TANTALUM);
        output.accept(CSItems.PLATE_TUNGSTEN);

        /** Circuits */
        output.accept(CSItems.CIRCUIT_ORGANIC);

        /** Rods */
        output.accept(CSItems.ROD_MANGANESEALUMINUM);

        /** Catalysts */
        output.accept(CSItems.SUPPORT_CATALYST);
        output.accept(CSItems.TITANIUM_MAGNESIUM_CATALYST);
        output.accept(CSItems.VANADIUM_CATALYST);
        output.accept(CSItems.IRON_ON_CARBON_CATALYST);
        output.accept(CSItems.IRON_FLUORIDE_CATALYST);
        output.accept(CSItems.IRON_CHLORIDE_CATALYST);
        output.accept(CSItems.IRON_BROMIDE_CATALYST);
        output.accept(CSItems.PYRIDINE_NICKEL_CATALYST);
        output.accept(CSItems.COPPER_ZINC_ALUMINATE_CATALYST);
        output.accept(CSItems.MOLYBDENUM_SULFUR_CATALYST);
        output.accept(CSItems.RUTHENIUM_SULFUR_CATALYST);
        output.accept(CSItems.RHODIUM_SILICA_CATALYST);
        output.accept(CSItems.RHODIUM_MANGANESE_BROMINE_CATALYST);
        output.accept(CSItems.PALLADIUM_ON_CARBON_CATALYST);
        output.accept(CSItems.PALLADIUM_CHLORIDE_CATALYST);
        output.accept(CSItems.PALLADIUM_PHOSPHATE_CATALYST);
        output.accept(CSItems.TRIPHENYLPHOSPHINE_PALLADIUM_CATALYST);
        output.accept(CSItems.PLATINUM_SILICA_CATALYST);
        output.accept(CSItems.PLATINUM_THORIUM_CATALYST);
        output.accept(CSItems.SILICA_ALUMINA_CATALYST);
        output.accept(CSItems.SULFONATED_POLYSTYRENE_CATALYST);

        /** Materials */
        // Chromatography Cards
        output.accept(CSItems.CHROMOTOGRAPHYCARD_HELIUM);
        output.accept(CSItems.CHROMOTOGRAPHYCARD_NEON);
        output.accept(CSItems.CHROMOTOGRAPHYCARD_KRYPTON);
        output.accept(CSItems.CHROMOTOGRAPHYCARD_XENON);
        output.accept(CSItems.CHROMOTOGRAPHYCARD_RADON);
        output.accept(CSItems.CHROMOTOGRAPHYCARD_METHANE);
        output.accept(CSItems.CHROMOTOGRAPHYCARD_CARBONMONOXIDE);
        // Gas Samples
        output.accept(CSItems.CARBON_SAMPLE_HELIUM);
        output.accept(CSItems.CARBON_SAMPLE_NEON);
        output.accept(CSItems.CARBON_SAMPLE_ARGON);
        output.accept(CSItems.CARBON_SAMPLE_KRYPTON);
        output.accept(CSItems.CARBON_SAMPLE_XENON);
        output.accept(CSItems.CARBON_SAMPLE_RADON);
        // Polymer
        output.accept(CSItems.POLYPROPYLENE);
        output.accept(CSItems.POLYSTYRENE);
        output.accept(CSItems.PVC);
        output.accept(CSItems.PARAPHENYLENETEREPHTHALAMIDE_POLYMER);
        output.accept(CSItems.DPP_POLYMER);
        output.accept(CSItems.DTT_POLYMER);
        output.accept(CSItems.DPPDTT_POLYMER);
        output.accept(CSItems.PBDBY_POLYMER);
        // Misc
        output.accept(CSItems.COIL_NIOBIUM_TITANIUM);
        output.accept(CSItems.ORGANIC_SOLAR_PANEL_PLATE);
        output.accept(CSItems.RAW_BORON_COMPOSITE);
        output.accept(CSItems.PLATING_BORON_COMPOSITE);
        output.accept(CSItems.RADIATIONSHIELDING_GLASS_DUST);
        output.accept(CSItems.RADIATIONSHIELDING_ADVANCEDGLASS_DUST);
        output.accept(CSItems.TRINITROTOLUENE);
        output.accept(CSItems.ASPHALT);
        output.accept(CSItems.CERAMIC_PASTE);
        output.accept(CSItems.PETRI_DISH);
        output.accept(CSItems.CULTURE_MEDIUM);
        output.accept(CSItems.E_COLI);
        output.accept(CSItems.CLOSTRIDIUM);
        output.accept(CSItems.SODA);

        /** Equipment */
        // Tools
        output.accept(CSItems.TUNGSTENCARBIDE_SWORD);
        output.accept(CSItems.TUNGSTENCARBIDE_PICKAXE);
        output.accept(CSItems.TUNGSTENCARBIDE_AXE);
        output.accept(CSItems.TUNGSTENCARBIDE_SHOVEL);
        output.accept(CSItems.TUNGSTENCARBIDE_HOE);
        output.accept(CSItems.FLAME_THROWER);
        // Armor
        output.accept(CSItems.ORGANICNIGHTVISIONGOGGLES);
        output.accept(CSItems.BULLETPROOF_VEST);
    }).build());

    public static final Supplier<CreativeModeTab> CHEMICAL_SCIENCE_PERIODICTABLE_TAB = CREATIVE_MODE_TAB.register("chemicalscienceperiodictable_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(CSBlocks.ELEMENT_MG.get())).title(Component.translatable("creativetab.chemicalscienceperiodictable")).displayItems((itemDisplayParameters, output) -> {

        output.accept(CSBlocks.ELEMENT_H);
        output.accept(CSBlocks.ELEMENT_HE);
        output.accept(CSBlocks.ELEMENT_LI);
        output.accept(CSBlocks.ELEMENT_BE);
        output.accept(CSBlocks.ELEMENT_B);
        output.accept(CSBlocks.ELEMENT_C);
        output.accept(CSBlocks.ELEMENT_N);
        output.accept(CSBlocks.ELEMENT_O);
        output.accept(CSBlocks.ELEMENT_F);
        output.accept(CSBlocks.ELEMENT_NE);
        output.accept(CSBlocks.ELEMENT_NA);
        output.accept(CSBlocks.ELEMENT_MG);
        output.accept(CSBlocks.ELEMENT_AL);
        output.accept(CSBlocks.ELEMENT_SI);
        output.accept(CSBlocks.ELEMENT_P);
        output.accept(CSBlocks.ELEMENT_S);
        output.accept(CSBlocks.ELEMENT_CL);
        output.accept(CSBlocks.ELEMENT_AR);
        output.accept(CSBlocks.ELEMENT_K);
        output.accept(CSBlocks.ELEMENT_CA);
        output.accept(CSBlocks.ELEMENT_SC);
        output.accept(CSBlocks.ELEMENT_TI);
        output.accept(CSBlocks.ELEMENT_V);
        output.accept(CSBlocks.ELEMENT_CR);
        output.accept(CSBlocks.ELEMENT_MN);
        output.accept(CSBlocks.ELEMENT_FE);
        output.accept(CSBlocks.ELEMENT_CO);
        output.accept(CSBlocks.ELEMENT_NI);
        output.accept(CSBlocks.ELEMENT_CU);
        output.accept(CSBlocks.ELEMENT_ZN);
        output.accept(CSBlocks.ELEMENT_GA);
        output.accept(CSBlocks.ELEMENT_GE);
        output.accept(CSBlocks.ELEMENT_AS);
        output.accept(CSBlocks.ELEMENT_SE);
        output.accept(CSBlocks.ELEMENT_BR);
        output.accept(CSBlocks.ELEMENT_KR);
        output.accept(CSBlocks.ELEMENT_RB);
        output.accept(CSBlocks.ELEMENT_SR);
        output.accept(CSBlocks.ELEMENT_Y);
        output.accept(CSBlocks.ELEMENT_ZR);
        output.accept(CSBlocks.ELEMENT_NB);
        output.accept(CSBlocks.ELEMENT_MO);
        output.accept(CSBlocks.ELEMENT_TC);
        output.accept(CSBlocks.ELEMENT_RU);
        output.accept(CSBlocks.ELEMENT_RH);
        output.accept(CSBlocks.ELEMENT_PD);
        output.accept(CSBlocks.ELEMENT_AG);
        output.accept(CSBlocks.ELEMENT_CD);
        output.accept(CSBlocks.ELEMENT_IN);
        output.accept(CSBlocks.ELEMENT_SN);
        output.accept(CSBlocks.ELEMENT_SB);
        output.accept(CSBlocks.ELEMENT_TE);
        output.accept(CSBlocks.ELEMENT_I);
        output.accept(CSBlocks.ELEMENT_XE);
        output.accept(CSBlocks.ELEMENT_CS);
        output.accept(CSBlocks.ELEMENT_BA);
        output.accept(CSBlocks.ELEMENT_LA);
        output.accept(CSBlocks.ELEMENT_CE);
        output.accept(CSBlocks.ELEMENT_PR);
        output.accept(CSBlocks.ELEMENT_ND);
        output.accept(CSBlocks.ELEMENT_PM);
        output.accept(CSBlocks.ELEMENT_SM);
        output.accept(CSBlocks.ELEMENT_EU);
        output.accept(CSBlocks.ELEMENT_GD);
        output.accept(CSBlocks.ELEMENT_TB);
        output.accept(CSBlocks.ELEMENT_DY);
        output.accept(CSBlocks.ELEMENT_HO);
        output.accept(CSBlocks.ELEMENT_ER);
        output.accept(CSBlocks.ELEMENT_TM);
        output.accept(CSBlocks.ELEMENT_YB);
        output.accept(CSBlocks.ELEMENT_LU);
        output.accept(CSBlocks.ELEMENT_HF);
        output.accept(CSBlocks.ELEMENT_TA);
        output.accept(CSBlocks.ELEMENT_W);
        output.accept(CSBlocks.ELEMENT_RE);
        output.accept(CSBlocks.ELEMENT_OS);
        output.accept(CSBlocks.ELEMENT_IR);
        output.accept(CSBlocks.ELEMENT_PT);
        output.accept(CSBlocks.ELEMENT_AU);
        output.accept(CSBlocks.ELEMENT_HG);
        output.accept(CSBlocks.ELEMENT_TL);
        output.accept(CSBlocks.ELEMENT_PB);
        output.accept(CSBlocks.ELEMENT_BI);
        output.accept(CSBlocks.ELEMENT_PO);
        output.accept(CSBlocks.ELEMENT_AT);
        output.accept(CSBlocks.ELEMENT_RN);
        output.accept(CSBlocks.ELEMENT_FR);
        output.accept(CSBlocks.ELEMENT_RA);
        output.accept(CSBlocks.ELEMENT_AC);
        output.accept(CSBlocks.ELEMENT_TH);
        output.accept(CSBlocks.ELEMENT_PA);
        output.accept(CSBlocks.ELEMENT_U);
        output.accept(CSBlocks.ELEMENT_NP);
        output.accept(CSBlocks.ELEMENT_PU);
        output.accept(CSBlocks.ELEMENT_AM);
        output.accept(CSBlocks.ELEMENT_CM);
        output.accept(CSBlocks.ELEMENT_BK);
        output.accept(CSBlocks.ELEMENT_CF);
        output.accept(CSBlocks.ELEMENT_ES);
        output.accept(CSBlocks.ELEMENT_FM);
        output.accept(CSBlocks.ELEMENT_MD);
        output.accept(CSBlocks.ELEMENT_NO);
        output.accept(CSBlocks.ELEMENT_LR);
        output.accept(CSBlocks.ELEMENT_RF);
        output.accept(CSBlocks.ELEMENT_DB);
        output.accept(CSBlocks.ELEMENT_SG);
        output.accept(CSBlocks.ELEMENT_BH);
        output.accept(CSBlocks.ELEMENT_HS);
        output.accept(CSBlocks.ELEMENT_MT);
        output.accept(CSBlocks.ELEMENT_DS);
        output.accept(CSBlocks.ELEMENT_RG);
        output.accept(CSBlocks.ELEMENT_CN);
        output.accept(CSBlocks.ELEMENT_NH);
        output.accept(CSBlocks.ELEMENT_FL);
        output.accept(CSBlocks.ELEMENT_MC);
        output.accept(CSBlocks.ELEMENT_LV);
        output.accept(CSBlocks.ELEMENT_TS);
        output.accept(CSBlocks.ELEMENT_OG);

    }).build());
}