package net.pastek.chemicalscience.registers;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.common.item.CSTooltipItem;
import net.pastek.chemicalscience.common.item.food.ItemSoda;
import net.pastek.chemicalscience.common.item.gear.CSToolTiers;
import net.pastek.chemicalscience.common.item.gear.ItemFlamethrower;
import net.pastek.chemicalscience.common.item.gear.ItemRoadMap;
import net.pastek.chemicalscience.common.item.gear.armor.types.ItemBulletProofVest;
import net.pastek.chemicalscience.common.item.gear.armor.types.ItemOrganicNightVisionGoggles;
import voltaic.common.item.ItemVoltaic;
import voltaic.prefab.item.ElectricItemProperties;
import voltaic.prefab.utilities.object.TransferPack;

@SuppressWarnings("null")
public class CSItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ChemicalScience.MOD_ID);

    /** Raw ores */
    public static final DeferredItem<Item> RAW_ORE_MAGNESIUM = ITEMS.register("rawore_magnesium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_ORE_SILICON = ITEMS.register("rawore_silicon",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_ORE_ARSENOPYRITE = ITEMS.register("rawore_arsenopyrite",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_ORE_WOLFRAMITE = ITEMS.register("rawore_wolframite",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_ORE_COOPERITE = ITEMS.register("rawore_cooperite",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_ORE_PYROLUSITE = ITEMS.register("rawore_pyrolusite",
	    () -> new Item(new Item.Properties()));

    /** Crystals */
    public static final DeferredItem<Item> CRYSTAL_MAGNESIUM = ITEMS.register("crystal_magnesium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CRYSTAL_ACETIC_ANHYDRIDE = ITEMS.register("crystal_aceticanhydride",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CRYSTAL_MAGNESIUMCHLORIDE = ITEMS.register("crystal_magnesiumchloride",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CRYSTAL_POTASSIUMBROMIDE = ITEMS.register("crystal_potassiumbromide",
	    () -> new Item(new Item.Properties()));

    /** Dusts */
    // Dust
    public static final DeferredItem<Item> DUST_BORON = ITEMS.register("dust_boron",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_BERYLLIUM = ITEMS.register("dust_beryllium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_ACTIVATEDCARBON = ITEMS.register("dust_activatedcarbon",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_SODIUM = ITEMS.register("dust_sodium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_MAGNESIUM = ITEMS.register("dust_magnesium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_SILICON = ITEMS.register("dust_silicon",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_PHOSPHORUS = ITEMS.register("dust_phosphorus",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_PHOSPHORUS_CHLORIDE = ITEMS.register("dust_phosphoruschloride",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_POTASSIUM = ITEMS.register("dust_potassium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_CALCIUM = ITEMS.register("dust_calcium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_CALCIUMOXIDE = ITEMS.register("dust_calciumoxide",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_SCANDIUM = ITEMS.register("dust_scandium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_CHROMIUM_BROMIDE = ITEMS.register("dust_chromiumbromide",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_IRONOXIDE = ITEMS.register("dust_ironoxide",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_IRONTETROXIDE = ITEMS.register("dust_irontetroxide",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_MANGANESE = ITEMS.register("dust_manganese",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_COBALT = ITEMS.register("dust_cobalt",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_NICKEL = ITEMS.register("dust_nickel",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_ZINC = ITEMS.register("dust_zinc",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_GALLIUM = ITEMS.register("dust_gallium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_GERMANIUM = ITEMS.register("dust_germanium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_ARSENIC = ITEMS.register("dust_arsenic",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_IRONARSENIDE = ITEMS.register("dust_ironarsenide",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_SELENIUM = ITEMS.register("dust_selenium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_RUBIDIUM = ITEMS.register("dust_rubidium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_STRONTIUM = ITEMS.register("dust_strontium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_YTTRIUM = ITEMS.register("dust_yttrium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_NIOBIUM = ITEMS.register("dust_niobium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_TECHNETIUM = ITEMS.register("dust_technetium",
	    () -> new ItemVoltaic(new Item.Properties(), null));
    public static final DeferredItem<Item> DUST_RUTHENIUM = ITEMS.register("dust_ruthenium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_RHODIUM = ITEMS.register("dust_rhodium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_PALLADIUM = ITEMS.register("dust_palladium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_PALLADIUM_CHLORIDE = ITEMS.register("dust_palladiumchloride",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_CADMIUM = ITEMS.register("dust_cadmium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_INDIUM = ITEMS.register("dust_indium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_ANTIMONY = ITEMS.register("dust_antimony",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_TELLURIUM = ITEMS.register("dust_tellurium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_IODINE = ITEMS.register("dust_iodine",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_CESIUM = ITEMS.register("dust_cesium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_BARIUM = ITEMS.register("dust_barium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_HAFNIUM = ITEMS.register("dust_hafnium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_TANTALUM = ITEMS.register("dust_tantalum",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_TUNGSTEN = ITEMS.register("dust_tungsten",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_TUNGSTEN_CARBIDE = ITEMS.register("dust_tungstencarbide",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_RHENIUM = ITEMS.register("dust_rhenium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_OSMIUM = ITEMS.register("dust_osmium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_PLATINUM = ITEMS.register("dust_platinum",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_PLATINUM_CHLORIDE = ITEMS.register("dust_platinumchloride",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_BISMUTH = ITEMS.register("dust_bismuth",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_MONAZITE = ITEMS.register("dust_monazite",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_LANTHANUM = ITEMS.register("dust_lanthanum",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_CERIUM = ITEMS.register("dust_cerium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_NEODYMIUM = ITEMS.register("dust_neodymium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_PRASEODYMIUM = ITEMS.register("dust_praseodymium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_SAMARIUM = ITEMS.register("dust_samarium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_PROMETHIUM = ITEMS.register("dust_promethium",
	    () -> new ItemVoltaic(new Item.Properties(), null));
    public static final DeferredItem<Item> DUST_EUROPIUM = ITEMS.register("dust_europium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_GADOLINIUM = ITEMS.register("dust_gadolinium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_TERBIUM = ITEMS.register("dust_terbium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_DYSPROSIUM = ITEMS.register("dust_dysprosium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_HOLMIUM = ITEMS.register("dust_holmium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_ERBIUM = ITEMS.register("dust_erbium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_THULIUM = ITEMS.register("dust_thulium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_YTTERBIUM = ITEMS.register("dust_ytterbium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_LUTECIUM = ITEMS.register("dust_lutecium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_THORIUM = ITEMS.register("dust_thorium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_URANIUM = ITEMS.register("dust_uranium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_URANIUMOXIDE = ITEMS.register("dust_uraniumoxide",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_PLUTONIUMOXIDE = ITEMS.register("dust_plutoniumoxide",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_PLUTONIUMHYDROXIDE = ITEMS.register("dust_plutoniumhydroxide",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_SILVERFLUORIDE = ITEMS.register("dust_silverfluoride",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_TINCHLORIDE = ITEMS.register("dust_tinchloride",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_POTASSIUMCARBONATE = ITEMS.register("dust_potassiumcarbonate",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DUST_ALUMINA = ITEMS.register("dust_alumina",
	    () -> new Item(new Item.Properties()));

    // Impure dust
    public static final DeferredItem<Item> IMPURE_DUST_BORON = ITEMS.register("impuredust_boron",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_BERYLLIUM = ITEMS.register("impuredust_beryllium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_SODIUM = ITEMS.register("impuredust_sodium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_MAGNESIUM = ITEMS.register("impuredust_magnesium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_SILICON = ITEMS.register("impuredust_silicon",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_POTASSIUM = ITEMS.register("impuredust_potassium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_CALCIUM = ITEMS.register("impuredust_calcium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_SCANDIUM = ITEMS.register("impuredust_scandium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_CERIUM = ITEMS.register("impuredust_cerium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_MANGANESE = ITEMS.register("impuredust_manganese",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_COBALT = ITEMS.register("impuredust_cobalt",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_NICKEL = ITEMS.register("impuredust_nickel",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_ZINC = ITEMS.register("impuredust_zinc",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_GALLIUM = ITEMS.register("impuredust_gallium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_GERMANIUM = ITEMS.register("impuredust_germanium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_ARSENIC = ITEMS.register("impuredust_arsenic",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_SELENIUM = ITEMS.register("impuredust_selenium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_RUBIDIUM = ITEMS.register("impuredust_rubidium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_STRONTIUM = ITEMS.register("impuredust_strontium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_YTTRIUM = ITEMS.register("impuredust_yttrium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_NIOBIUM = ITEMS.register("impuredust_niobium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_HAFNIUM = ITEMS.register("impuredust_hafnium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_TUNGSTEN = ITEMS.register("impuredust_tungsten",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_RHENIUM = ITEMS.register("impuredust_rhenium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_OSMIUM = ITEMS.register("impuredust_osmium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_PLATINUM = ITEMS.register("impuredust_platinum",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_MERCURY = ITEMS.register("impuredust_mercury",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_BISMUTH = ITEMS.register("impuredust_bismuth",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_RHODIUM = ITEMS.register("impuredust_rhodium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_PALLADIUM = ITEMS.register("impuredust_palladium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_CADMIUM = ITEMS.register("impuredust_cadmium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_ANTIMONY = ITEMS.register("impuredust_antimony",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_TELLURIUM = ITEMS.register("impuredust_tellurium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_IODINE = ITEMS.register("impuredust_iodine",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_CESIUM = ITEMS.register("impuredust_cesium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_BARIUM = ITEMS.register("impuredust_barium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_TANTALUM = ITEMS.register("impuredust_tantalum",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_THORIUM = ITEMS.register("impuredust_thorium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_DUST_URANIUM = ITEMS.register("impuredust_uranium",
	    () -> new Item(new Item.Properties()));

    /** Organic */
    public static final DeferredItem<Item> AMMONIUMDIURANATE = ITEMS.register("ammoniumdiuranate",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> UREA = ITEMS.register("urea",
	    () -> new CSTooltipItem(new Item.Properties(),
		    Component.translatable("tooltip.chemicalscience.info.organic")
			    .withStyle(ChatFormatting.DARK_PURPLE),
		    ChemicalScience.rl("textures/screen/tooltip/molecules/urea.png"), 64, 64));
    public static final DeferredItem<Item> DIMETHYLUREA = ITEMS.register("dimethylurea",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CAFFEINE = ITEMS.register("caffeine", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SUCCINIMIDE = ITEMS.register("succinimide",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> NBROMOSUCCINIMIDE = ITEMS.register("nbromosuccinimide",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> AMMONIUMCARBONATE = ITEMS.register("ammoniumcarbonate",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TEREPHTHALOYLCHLORIDE = ITEMS.register("terephthaloylchloride",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> NITROCHLOROBENZENE = ITEMS.register("nitrochlorobenzene",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PARAPHENYLENEDIAMINE = ITEMS.register("paraphenylenediamine",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> LI_DIISOPROPYLAMIDE = ITEMS.register("lithium_diisopropylamide",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BENZODITHIOPHENEDIONE = ITEMS.register("benzodithiophendione",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TRIMETHYLTINCHLORIDE = ITEMS.register("trimethyltinchloride",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DIBROMOTHIOPHENEDICARBOXYLICACID = ITEMS
	    .register("dibromothiophenedicarboxylicacid", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BISETHYLHEXYLTHIOPHENE = ITEMS.register("bisethylhexylthiophene",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TRIMETHYLTHIOPHENESTANNANE = ITEMS.register("trimethylthiophenestannane",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BENZOTHIADIAZOLE = ITEMS.register("benzothiadiazole",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DIFLUOROPHENYLPROPIONICACID = ITEMS.register("difluorophenylpropionicacid",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MALONITRILE = ITEMS.register("malonitrile",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> OXALICACID = ITEMS.register("oxalicacid",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TRIPHENYLPHOSPHINE = ITEMS.register("triphenylphosphine",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SODIUM_CYANIDE = ITEMS.register("sodium_cyanide",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CINNAMICACID = ITEMS.register("cinnamicacid",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PHENYLPROPANOICACID = ITEMS.register("phenylpropanoicacid",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DIBROMOBENZODITHIOPHENDIONE = ITEMS.register("dibromobenzodithiophendione",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BROMOETHYLHEXYLTHIOPHENE = ITEMS.register("bromoethylhexylthiophene",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BROMOETHYLHEXYLTRIMETHYLSILYLTHIOPHENE = ITEMS
	    .register("bromoethylhexyltrimethylsilylthiophene", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> FLUOROETHYLHEXYLTRIMETHYLSILYLTHIOPHENE = ITEMS
	    .register("fluoroethylhexyltrimethylsilylthiophene", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> FLUOROETHYLHEXYLTHIOPHENE = ITEMS.register("fluoroethylhexylthiophene",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BDT = ITEMS.register("bdt", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TRIMETHYLSTANNANEBDT = ITEMS.register("trimethylstannanebdt",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DIBROMOTHIOPHENEDIACYLCHLORIDE = ITEMS
	    .register("dibromothiophenediacylchloride", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DIBROMOETHYLHEXYLTHIENOTHIOPHENEDIKETONE = ITEMS
	    .register("dibromoethylhexylthienothiophenediketone", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BDD = ITEMS.register("bdd", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DIBROMOBDD = ITEMS.register("dibromobdd",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DIBROMOBENZOTHIADIAZOLE = ITEMS.register("dibromobenzothiadiazole",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DIBROMODINITROBENZOTHIADIAZOLE = ITEMS
	    .register("dibromodinitrobenzothiadiazole", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> THIENOTHIOPHENE = ITEMS.register("thienothiophene",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> UNDECYLTHIENOTHIOPHENE = ITEMS.register("undecylthienothiophene",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TRIMETHYLSTANNYLUNDECYLTHIENOTHIOPHENE = ITEMS
	    .register("trimethylstannylundecylthienothiophene", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DINITROUNDECYLTHIENOTHIOPHENEBENZOTHIADIAZOLE = ITEMS
	    .register("dinitroundecylthienothiophenebenzothiadiazole", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ETHYLHEXYLUNDECYLTHIENOTHIOPHENEPYRROLOBENZOTHIADIAZOLE = ITEMS
	    .register("ethylhexylundecylthienothiophenepyrrolobenzothiadiazole", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ETHYLHEXYLUNDECYLOXOTHIENOTHIOPHENEPYRROLOBENZOTHIADIAZOLE = ITEMS.register(
	    "ethylhexylundecyloxothienothiophenepyrrolobenzothiadiazole", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DIFLUOROINDANONE = ITEMS.register("difluoroindanone",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DIFLUORODICYANOMETHYLIDIENEINDANONE = ITEMS
	    .register("difluorodicyanomethylidieneindanone", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PBDBTF = ITEMS.register("pbdbtf", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> YBTPF = ITEMS.register("ybtpf", () -> new Item(new Item.Properties()));

    /** Ingots */
    public static final DeferredItem<Item> INGOT_BORON = ITEMS.register("ingot_boron",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INGOT_BERYLLIUM = ITEMS.register("ingot_beryllium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INGOT_BORON_CARBIDE = ITEMS.register("ingot_boroncarbide",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INGOT_MAGNESIUM = ITEMS.register("ingot_magnesium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INGOT_MAGNESIUM_ALUMINUM = ITEMS.register("ingot_magnesiumaluminum",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INGOT_MANGANESE_ALUMINUM = ITEMS.register("ingot_manganesealuminum",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INGOT_SILICON = ITEMS.register("ingot_silicon",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INGOT_ZINC = ITEMS.register("ingot_zinc",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INGOT_NICKEL = ITEMS.register("ingot_nickel",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INGOT_GERMANIUM = ITEMS.register("ingot_germanium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INGOT_TANTALUM = ITEMS.register("ingot_tantalum",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INGOT_GALLIUMARSENIDE = ITEMS.register("ingot_galliumarsenide",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INGOT_TUNGSTEN = ITEMS.register("ingot_tungsten",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INGOT_MANGANESE = ITEMS.register("ingot_manganese",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INGOT_NIOBIUM = ITEMS.register("ingot_niobium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INGOT_NIOBIUM_TITANIUM = ITEMS.register("ingot_niobiumtitanium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INGOT_PLATINUM = ITEMS.register("ingot_platinum",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INGOT_PALLADIUM = ITEMS.register("ingot_palladium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INGOT_MANGANIN = ITEMS.register("ingot_manganin",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INGOT_TUNGSTEN_CARBIDE = ITEMS.register("ingot_tungstencarbide",
	    () -> new Item(new Item.Properties()));
    /** Nuggets */
    public static final DeferredItem<Item> NUGGET_MANGANESEALUMINUM = ITEMS.register("nugget_manganesealuminum",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> NUGGET_TUNGSTEN = ITEMS.register("nugget_tungsten",
	    () -> new Item(new Item.Properties()));
    /** Plates */
    public static final DeferredItem<Item> PLATE_BORONCARBIDE = ITEMS.register("plate_boroncarbide",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PLATE_BERYLLIUM = ITEMS.register("plate_beryllium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PLATE_SILICON = ITEMS.register("plate_silicon",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PLATE_NIOBIUM = ITEMS.register("plate_niobium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PLATE_TANTALUM = ITEMS.register("plate_tantalum",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PLATE_TUNGSTEN = ITEMS.register("plate_tungsten",
	    () -> new Item(new Item.Properties()));
    /** Circuits */
    public static final DeferredItem<Item> CIRCUIT_ORGANIC = ITEMS.register("circuitorganic",
	    () -> new Item(new Item.Properties()));
    /** Rods */
    public static final DeferredItem<Item> ROD_MANGANESEALUMINUM = ITEMS.register("rod_manganesealuminum",
	    () -> new Item(new Item.Properties()));

    /** Catalysts */
    public static final DeferredItem<Item> SUPPORT_CATALYST = ITEMS.register("support_catalyst",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> COPPER_ZINC_ALUMINATE_CATALYST = ITEMS.register("copper_aluminate_catalyst",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IRON_ON_CARBON_CATALYST = ITEMS.register("iron_carbon_catalyst",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PALLADIUM_ON_CARBON_CATALYST = ITEMS.register("palladium_carbon_catalyst",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MOLYBDENUM_SULFUR_CATALYST = ITEMS.register("molybdenum_sulfur_catalyst",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RUTHENIUM_SULFUR_CATALYST = ITEMS.register("ruthenium_sulfur_catalyst",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SILICA_ALUMINA_CATALYST = ITEMS.register("silica_alumina_catalyst",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TITANIUM_MAGNESIUM_CATALYST = ITEMS.register("titanium_magnesium_catalyst",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SULFONATED_POLYSTYRENE_CATALYST = ITEMS
	    .register("sulfonated_polystyrene_catalyst", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RHODIUM_MANGANESE_BROMINE_CATALYST = ITEMS
	    .register("rhodium_manganese_bromine_catalyst", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PLATINUM_THORIUM_CATALYST = ITEMS.register("platinum_thorium_catalyst",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PLATINUM_SILICA_CATALYST = ITEMS.register("platinum_silica_catalyst",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RHODIUM_SILICA_CATALYST = ITEMS.register("rhodium_silica_catalyst",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TRIPHENYLPHOSPHINE_PALLADIUM_CATALYST = ITEMS
	    .register("tripph_palladium_catalyst", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PYRIDINE_NICKEL_CATALYST = ITEMS.register("pyridine_nickel_catalyst",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PALLADIUM_CHLORIDE_CATALYST = ITEMS.register("palladium_chloride_catalyst",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PALLADIUM_PHOSPHATE_CATALYST = ITEMS.register("palladium_phosphate_catalyst",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> VANADIUM_CATALYST = ITEMS.register("vanadium_catalyst",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IRON_FLUORIDE_CATALYST = ITEMS.register("iron_fluoride_catalyst",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IRON_CHLORIDE_CATALYST = ITEMS.register("iron_chloride_catalyst",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IRON_BROMIDE_CATALYST = ITEMS.register("iron_bromide_catalyst",
	    () -> new Item(new Item.Properties()));

    /** Materials */
    // Chromatography Cards
    public static final DeferredItem<Item> CHROMOTOGRAPHYCARD_CARBONMONOXIDE = ITEMS
	    .register("chromotographycardcarbonmonoxide", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CHROMOTOGRAPHYCARD_METHANE = ITEMS.register("chromotographycardmethane",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CHROMOTOGRAPHYCARD_HELIUM = ITEMS.register("chromotographycardhelium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CHROMOTOGRAPHYCARD_NEON = ITEMS.register("chromotographycardneon",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CHROMOTOGRAPHYCARD_KRYPTON = ITEMS.register("chromotographycardkrypton",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CHROMOTOGRAPHYCARD_XENON = ITEMS.register("chromotographycardxenon",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CHROMOTOGRAPHYCARD_RADON = ITEMS.register("chromotographycardradon",
	    () -> new Item(new Item.Properties()));
    // Gas samples
    public static final DeferredItem<Item> CARBON_SAMPLE_HELIUM = ITEMS.register("carbonsamplehelium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CARBON_SAMPLE_NEON = ITEMS.register("carbonsampleneon",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CARBON_SAMPLE_ARGON = ITEMS.register("carbonsampleargon",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CARBON_SAMPLE_KRYPTON = ITEMS.register("carbonsamplekrypton",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CARBON_SAMPLE_XENON = ITEMS.register("carbonsamplexenon",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CARBON_SAMPLE_RADON = ITEMS.register("carbonsampleradon",
	    () -> new Item(new Item.Properties()));
    // Polymer
    public static final DeferredItem<Item> DPP_POLYMER = ITEMS.register("polymer_dpp",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DTT_POLYMER = ITEMS.register("polymer_dtt",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DPPDTT_POLYMER = ITEMS.register("polymer_dppdtt",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PBDBY_POLYMER = ITEMS.register("polymer_pbdby",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> POLYPROPYLENE = ITEMS.register("polymer_propylene",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> POLYSTYRENE = ITEMS.register("polymer_styrene",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PVC = ITEMS.register("polymer_vinylchloride",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PARAPHENYLENETEREPHTHALAMIDE_POLYMER = ITEMS
	    .register("polymer_paraphenyleneterephthalamide", () -> new Item(new Item.Properties()));
    // Misc
    public static final DeferredItem<Item> COIL_NIOBIUM_TITANIUM = ITEMS.register("niobiumtitaniumcoil",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ORGANIC_SOLAR_PANEL_PLATE = ITEMS.register("organicsolarpanelplate",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_BORON_COMPOSITE = ITEMS.register("boroncompositeplatingraw",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PLATING_BORON_COMPOSITE = ITEMS.register("boroncompositeplating",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RADIATIONSHIELDING_GLASS_DUST = ITEMS
	    .register("radiationshielding_glass_dust", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RADIATIONSHIELDING_ADVANCEDGLASS_DUST = ITEMS
	    .register("radiationshielding_advancedglass_dust", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TRINITROTOLUENE = ITEMS.register("trinitrotoluene",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ASPHALT = ITEMS.register("asphalt", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CERAMIC_PASTE = ITEMS.register("ceramicpaste",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PETRI_DISH = ITEMS.register("petri_dish",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CULTURE_MEDIUM = ITEMS.register("culture_medium",
	    () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> E_COLI = ITEMS.register("escherichia_coli",
	    () -> new Item(new Item.Properties().food(CSProperties.E_COLI)));
    public static final DeferredItem<Item> CLOSTRIDIUM = ITEMS.register("clostridium",
	    () -> new Item(new Item.Properties().food(CSProperties.CLOSTRIDIUM)));
    public static final DeferredItem<Item> SODA = ITEMS.register("soda",
	    () -> new ItemSoda(new Item.Properties().food(CSProperties.SODA).stacksTo(16)));
    public static final DeferredItem<Item> PARACETAMOL = ITEMS.register("paracetamol",
	    () -> new Item(new Item.Properties().food(CSProperties.PARACETAMOL)));

    /** Equipment */
    // Tools
    public static final DeferredItem<Item> TUNGSTENCARBIDE_SWORD = ITEMS.register("sword_tungstencarbide",
	    () -> new SwordItem(CSToolTiers.TUNGSTENCARBIDE, new Item.Properties()
		    .attributes(SwordItem.createAttributes(CSToolTiers.TUNGSTENCARBIDE, 4.0F, -2.6F)).fireResistant()));
    public static final DeferredItem<Item> TUNGSTENCARBIDE_PICKAXE = ITEMS.register("pickaxe_tungstencarbide",
	    () -> new PickaxeItem(CSToolTiers.TUNGSTENCARBIDE, new Item.Properties()
		    .attributes(SwordItem.createAttributes(CSToolTiers.TUNGSTENCARBIDE, 2.0F, -3.0F)).fireResistant()));
    public static final DeferredItem<Item> TUNGSTENCARBIDE_AXE = ITEMS.register("axe_tungstencarbide",
	    () -> new AxeItem(CSToolTiers.TUNGSTENCARBIDE, new Item.Properties()
		    .attributes(SwordItem.createAttributes(CSToolTiers.TUNGSTENCARBIDE, 6.0F, -3.2F)).fireResistant()));
    public static final DeferredItem<Item> TUNGSTENCARBIDE_SHOVEL = ITEMS.register("shovel_tungstencarbide",
	    () -> new ShovelItem(CSToolTiers.TUNGSTENCARBIDE, new Item.Properties()
		    .attributes(SwordItem.createAttributes(CSToolTiers.TUNGSTENCARBIDE, 2.5F, -3.2F)).fireResistant()));
    public static final DeferredItem<Item> TUNGSTENCARBIDE_HOE = ITEMS.register("hoe_tungstencarbide",
	    () -> new HoeItem(CSToolTiers.TUNGSTENCARBIDE,
		    new Item.Properties()
			    .attributes(SwordItem.createAttributes(CSToolTiers.TUNGSTENCARBIDE, -2.0F, -0.2F))
			    .fireResistant()));
    public static final DeferredItem<Item> FLAME_THROWER = ITEMS.register("flamethrower", ItemFlamethrower::new);

    // Armor
    public static final DeferredItem<Item> ORGANICNIGHTVISIONGOGGLES = ITEMS.register("organicnightvisiongoggles",
	    () -> new ItemOrganicNightVisionGoggles(
		    (ElectricItemProperties) new ElectricItemProperties().capacity(1.0)
			    .extract(TransferPack.joulesVoltage(1.0 / (120.0 * 20.0), 120))
			    .receive(TransferPack.joulesVoltage(1.0 / (120.0 * 20.0), 120)).stacksTo(1),
		    CSCreativeTabs.CHEMICAL_SCIENCE_TAB));
    public static final DeferredItem<Item> BULLETPROOF_VEST = ITEMS.register("bulletproofvest",
	    () -> new ItemBulletProofVest(ArmorItem.Type.CHESTPLATE));

    /** Chemists Road Map */
    public static final DeferredItem<Item> ROAD_MAP = ITEMS.register("roadmap",
	    () -> new ItemRoadMap(new Item.Properties(), null));
}