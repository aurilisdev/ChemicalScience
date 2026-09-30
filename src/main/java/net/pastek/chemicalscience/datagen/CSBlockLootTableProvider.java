package net.pastek.chemicalscience.datagen;

import java.util.List;

import electrodynamics.common.item.subtype.SubtypeCrystal;
import electrodynamics.common.item.subtype.SubtypeDust;
import electrodynamics.common.item.subtype.SubtypeRawOre;
import electrodynamics.registers.ElectrodynamicsBlocks;
import electrodynamics.registers.ElectrodynamicsItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.registers.CSBlocks;
import net.pastek.chemicalscience.registers.CSItems;
import voltaic.datagen.utils.server.loottable.BaseLootTablesProvider;

public class CSBlockLootTableProvider extends BaseLootTablesProvider {
    public CSBlockLootTableProvider(HolderLookup.Provider provider) {
        super(ChemicalScience.MOD_ID, provider);
    }

    @Override
    protected void generate() {

        // Ores
        // Overworld
        add(CSBlocks.ORE_MAGNESIUM.get(),block -> createMultipleOreDrops(CSBlocks.ORE_MAGNESIUM.get(), CSItems.RAW_ORE_MAGNESIUM.get(), 1, 1));
        add(CSBlocks.ORE_DEEPSLATE_MAGNESIUM.get(),block -> createMultipleOreDrops(CSBlocks.ORE_DEEPSLATE_MAGNESIUM.get(), CSItems.RAW_ORE_MAGNESIUM.get(), 1, 1));
        add(CSBlocks.ORE_SILICON.get(),block -> createMultipleOreDrops(CSBlocks.ORE_SILICON.get(), CSItems.RAW_ORE_SILICON.get(), 1, 1));
        add(CSBlocks.ORE_DEEPSLATE_SILICON.get(),block -> createMultipleOreDrops(CSBlocks.ORE_DEEPSLATE_SILICON.get(), CSItems.RAW_ORE_SILICON.get(), 1, 1));
        add(CSBlocks.ORE_ARSENOPYRITE.get(),block -> createMultipleOreDrops(CSBlocks.ORE_ARSENOPYRITE.get(), CSItems.RAW_ORE_ARSENOPYRITE.get(), 1, 1));
        add(CSBlocks.ORE_DEEPSLATE_ARSENOPYRITE.get(),block -> createMultipleOreDrops(CSBlocks.ORE_DEEPSLATE_ARSENOPYRITE.get(), CSItems.RAW_ORE_ARSENOPYRITE.get(), 1, 1));
        add(CSBlocks.ORE_WOLFRAMITE.get(),block -> createMultipleOreDrops(CSBlocks.ORE_WOLFRAMITE.get(), CSItems.RAW_ORE_WOLFRAMITE.get(), 1, 1));
        add(CSBlocks.ORE_DEEPSLATE_WOLFRAMITE.get(),block -> createMultipleOreDrops(CSBlocks.ORE_DEEPSLATE_WOLFRAMITE.get(), CSItems.RAW_ORE_WOLFRAMITE.get(), 1, 1));
        add(CSBlocks.ORE_COOPERITE.get(),block -> createMultipleOreDrops(CSBlocks.ORE_COOPERITE.get(), CSItems.RAW_ORE_COOPERITE.get(), 1, 1));
        add(CSBlocks.ORE_DEEPSLATE_COOPERITE.get(),block -> createMultipleOreDrops(CSBlocks.ORE_DEEPSLATE_COOPERITE.get(), CSItems.RAW_ORE_COOPERITE.get(), 1, 1));
        add(CSBlocks.ORE_PYROLUSITE.get(),block -> createMultipleOreDrops(CSBlocks.ORE_PYROLUSITE.get(), CSItems.RAW_ORE_PYROLUSITE.get(), 1, 1));
        add(CSBlocks.ORE_DEEPSLATE_PYROLUSITE.get(),block -> createMultipleOreDrops(CSBlocks.ORE_DEEPSLATE_PYROLUSITE.get(), CSItems.RAW_ORE_PYROLUSITE.get(), 1, 1));
        dropSelf(CSBlocks.ORE_OIL.get());
        dropSelf(CSBlocks.ORE_DEEPSLATE_OIL.get());

        // Stellaris
        add(CSBlocks.ORE_COOPERITE_MOON.get(),block -> createMultipleOreDrops(CSBlocks.ORE_COOPERITE_MOON.get(), CSItems.RAW_ORE_COOPERITE.get(), 1, 1));
        add(CSBlocks.ORE_COOPERITE_MARS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_COOPERITE_MARS.get(), CSItems.RAW_ORE_COOPERITE.get(), 1, 1));
        add(CSBlocks.ORE_COOPERITE_VENUS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_COOPERITE_VENUS.get(), CSItems.RAW_ORE_COOPERITE.get(), 1, 1));
        add(CSBlocks.ORE_COOPERITE_MERCURY.get(),block -> createMultipleOreDrops(CSBlocks.ORE_COOPERITE_MERCURY.get(), CSItems.RAW_ORE_COOPERITE.get(), 1, 1));
        add(CSBlocks.ORE_ARSENOPYRITE_MOON.get(),block -> createMultipleOreDrops(CSBlocks.ORE_ARSENOPYRITE_MOON.get(), CSItems.RAW_ORE_ARSENOPYRITE.get(), 1, 1));
        add(CSBlocks.ORE_ARSENOPYRITE_MARS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_ARSENOPYRITE_MARS.get(), CSItems.RAW_ORE_ARSENOPYRITE.get(), 1, 1));
        add(CSBlocks.ORE_ARSENOPYRITE_VENUS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_ARSENOPYRITE_VENUS.get(), CSItems.RAW_ORE_ARSENOPYRITE.get(), 1, 1));
        add(CSBlocks.ORE_ARSENOPYRITE_MERCURY.get(),block -> createMultipleOreDrops(CSBlocks.ORE_ARSENOPYRITE_MERCURY.get(), CSItems.RAW_ORE_ARSENOPYRITE.get(), 1, 1));
        add(CSBlocks.ORE_WOLFRAMITE_MOON.get(),block -> createMultipleOreDrops(CSBlocks.ORE_WOLFRAMITE_MOON.get(), CSItems.RAW_ORE_WOLFRAMITE.get(), 1, 1));
        add(CSBlocks.ORE_WOLFRAMITE_MARS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_WOLFRAMITE_MARS.get(), CSItems.RAW_ORE_WOLFRAMITE.get(), 1, 1));
        add(CSBlocks.ORE_WOLFRAMITE_VENUS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_WOLFRAMITE_VENUS.get(), CSItems.RAW_ORE_WOLFRAMITE.get(), 1, 1));
        add(CSBlocks.ORE_WOLFRAMITE_MERCURY.get(),block -> createMultipleOreDrops(CSBlocks.ORE_WOLFRAMITE_MERCURY.get(), CSItems.RAW_ORE_WOLFRAMITE.get(), 1, 1));
        add(CSBlocks.ORE_MAGNESIUM_MOON.get(),block -> createMultipleOreDrops(CSBlocks.ORE_MAGNESIUM_MOON.get(), CSItems.RAW_ORE_MAGNESIUM.get(), 1, 1));
        add(CSBlocks.ORE_MAGNESIUM_MARS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_MAGNESIUM_MARS.get(), CSItems.RAW_ORE_MAGNESIUM.get(), 1, 1));
        add(CSBlocks.ORE_MAGNESIUM_VENUS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_MAGNESIUM_VENUS.get(), CSItems.RAW_ORE_MAGNESIUM.get(), 1, 1));
        add(CSBlocks.ORE_MAGNESIUM_MERCURY.get(),block -> createMultipleOreDrops(CSBlocks.ORE_MAGNESIUM_MERCURY.get(), CSItems.RAW_ORE_MAGNESIUM.get(), 1, 1));
        add(CSBlocks.ORE_PYROLUSITE_MOON.get(),block -> createMultipleOreDrops(CSBlocks.ORE_PYROLUSITE_MOON.get(), CSItems.RAW_ORE_PYROLUSITE.get(), 1, 1));
        add(CSBlocks.ORE_PYROLUSITE_MARS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_PYROLUSITE_MARS.get(), CSItems.RAW_ORE_PYROLUSITE.get(), 1, 1));
        add(CSBlocks.ORE_PYROLUSITE_VENUS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_PYROLUSITE_VENUS.get(), CSItems.RAW_ORE_PYROLUSITE.get(), 1, 1));
        add(CSBlocks.ORE_PYROLUSITE_MERCURY.get(),block -> createMultipleOreDrops(CSBlocks.ORE_PYROLUSITE_MERCURY.get(), CSItems.RAW_ORE_PYROLUSITE.get(), 1, 1));
        add(CSBlocks.ORE_SILICON_MOON.get(),block -> createMultipleOreDrops(CSBlocks.ORE_SILICON_MOON.get(), CSItems.RAW_ORE_SILICON.get(), 1, 1));
        add(CSBlocks.ORE_SILICON_MARS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_SILICON_MARS.get(), CSItems.RAW_ORE_SILICON.get(), 1, 1));
        add(CSBlocks.ORE_SILICON_VENUS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_SILICON_VENUS.get(), CSItems.RAW_ORE_SILICON.get(), 1, 1));
        add(CSBlocks.ORE_SILICON_MERCURY.get(),block -> createMultipleOreDrops(CSBlocks.ORE_SILICON_MERCURY.get(), CSItems.RAW_ORE_SILICON.get(), 1, 1));
        add(CSBlocks.ORE_CHROMIUM_MOON.get(),block -> createMultipleOreDrops(CSBlocks.ORE_CHROMIUM_MOON.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.chromium), 1, 1));
        add(CSBlocks.ORE_CHROMIUM_MARS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_CHROMIUM_MARS.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.chromium), 1, 1));
        add(CSBlocks.ORE_CHROMIUM_VENUS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_CHROMIUM_VENUS.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.chromium), 1, 1));
        add(CSBlocks.ORE_CHROMIUM_MERCURY.get(),block -> createMultipleOreDrops(CSBlocks.ORE_CHROMIUM_MERCURY.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.chromium), 1, 1));
        add(CSBlocks.ORE_FLUORITE_MOON.get(),block -> createMultipleOreDrops(CSBlocks.ORE_FLUORITE_MOON.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.fluorite), 1, 1));
        add(CSBlocks.ORE_FLUORITE_MARS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_FLUORITE_MARS.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.fluorite), 1, 1));
        add(CSBlocks.ORE_FLUORITE_VENUS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_FLUORITE_VENUS.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.fluorite), 1, 1));
        add(CSBlocks.ORE_FLUORITE_MERCURY.get(),block -> createMultipleOreDrops(CSBlocks.ORE_FLUORITE_MERCURY.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.fluorite), 1, 1));
        add(CSBlocks.ORE_LEAD_MOON.get(),block -> createMultipleOreDrops(CSBlocks.ORE_LEAD_MOON.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.lead), 1, 1));
        add(CSBlocks.ORE_LEAD_MARS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_LEAD_MARS.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.lead), 1, 1));
        add(CSBlocks.ORE_LEAD_VENUS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_LEAD_VENUS.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.lead), 1, 1));
        add(CSBlocks.ORE_LEAD_MERCURY.get(),block -> createMultipleOreDrops(CSBlocks.ORE_LEAD_MERCURY.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.lead), 1, 1));
        add(CSBlocks.ORE_LITHIUM_MOON.get(),block -> createMultipleOreDrops(CSBlocks.ORE_LITHIUM_MOON.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.lepidolite), 1, 1));
        add(CSBlocks.ORE_LITHIUM_MARS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_LITHIUM_MARS.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.lepidolite), 1, 1));
        add(CSBlocks.ORE_LITHIUM_VENUS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_LITHIUM_VENUS.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.lepidolite), 1, 1));
        add(CSBlocks.ORE_LITHIUM_MERCURY.get(),block -> createMultipleOreDrops(CSBlocks.ORE_LITHIUM_MERCURY.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.lepidolite), 1, 1));
        add(CSBlocks.ORE_NITER_MOON.get(),block -> createMultipleOreDrops(CSBlocks.ORE_NITER_MOON.get(), ElectrodynamicsItems.ITEMS_DUST.getValue(SubtypeDust.niter), 1, 1));
        add(CSBlocks.ORE_NITER_MARS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_NITER_MARS.get(), ElectrodynamicsItems.ITEMS_DUST.getValue(SubtypeDust.niter), 1, 1));
        add(CSBlocks.ORE_NITER_VENUS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_NITER_VENUS.get(), ElectrodynamicsItems.ITEMS_DUST.getValue(SubtypeDust.niter), 1, 1));
        add(CSBlocks.ORE_NITER_MERCURY.get(),block -> createMultipleOreDrops(CSBlocks.ORE_NITER_MERCURY.get(), ElectrodynamicsItems.ITEMS_DUST.getValue(SubtypeDust.niter), 1, 1));
        add(CSBlocks.ORE_SALT_MOON.get(),block -> createMultipleOreDrops(CSBlocks.ORE_SALT_MOON.get(), ElectrodynamicsItems.ITEMS_CRYSTAL.getValue(SubtypeCrystal.halite), 1, 1));
        add(CSBlocks.ORE_SALT_MARS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_SALT_MARS.get(), ElectrodynamicsItems.ITEMS_CRYSTAL.getValue(SubtypeCrystal.halite), 1, 1));
        add(CSBlocks.ORE_SALT_VENUS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_SALT_VENUS.get(), ElectrodynamicsItems.ITEMS_CRYSTAL.getValue(SubtypeCrystal.halite), 1, 1));
        add(CSBlocks.ORE_SALT_MERCURY.get(),block -> createMultipleOreDrops(CSBlocks.ORE_SALT_MERCURY.get(), ElectrodynamicsItems.ITEMS_CRYSTAL.getValue(SubtypeCrystal.halite), 1, 1));
        add(CSBlocks.ORE_SILVER_MOON.get(),block -> createMultipleOreDrops(CSBlocks.ORE_SILVER_MOON.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.silver), 1, 1));
        add(CSBlocks.ORE_SILVER_MARS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_SILVER_MARS.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.silver), 1, 1));
        add(CSBlocks.ORE_SILVER_VENUS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_SILVER_VENUS.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.silver), 1, 1));
        add(CSBlocks.ORE_SILVER_MERCURY.get(),block -> createMultipleOreDrops(CSBlocks.ORE_SILVER_MERCURY.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.silver), 1, 1));
        add(CSBlocks.ORE_SULFUR_MOON.get(),block -> createMultipleOreDrops(CSBlocks.ORE_SULFUR_MOON.get(), ElectrodynamicsItems.ITEMS_DUST.getValue(SubtypeDust.sulfur), 1, 1));
        add(CSBlocks.ORE_SULFUR_MARS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_SULFUR_MARS.get(), ElectrodynamicsItems.ITEMS_DUST.getValue(SubtypeDust.sulfur), 1, 1));
        add(CSBlocks.ORE_SULFUR_VENUS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_SULFUR_VENUS.get(), ElectrodynamicsItems.ITEMS_DUST.getValue(SubtypeDust.sulfur), 1, 1));
        add(CSBlocks.ORE_SULFUR_MERCURY.get(),block -> createMultipleOreDrops(CSBlocks.ORE_SULFUR_MERCURY.get(), ElectrodynamicsItems.ITEMS_DUST.getValue(SubtypeDust.sulfur), 1, 1));
        add(CSBlocks.ORE_SYLVITE_MOON.get(),block -> createMultipleOreDrops(CSBlocks.ORE_SYLVITE_MOON.get(), ElectrodynamicsItems.ITEMS_CRYSTAL.getValue(SubtypeCrystal.potassiumchloride), 1, 1));
        add(CSBlocks.ORE_SYLVITE_MARS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_SYLVITE_MARS.get(), ElectrodynamicsItems.ITEMS_CRYSTAL.getValue(SubtypeCrystal.potassiumchloride), 1, 1));
        add(CSBlocks.ORE_SYLVITE_VENUS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_SYLVITE_VENUS.get(), ElectrodynamicsItems.ITEMS_CRYSTAL.getValue(SubtypeCrystal.potassiumchloride), 1, 1));
        add(CSBlocks.ORE_SYLVITE_MERCURY.get(),block -> createMultipleOreDrops(CSBlocks.ORE_SYLVITE_MERCURY.get(), ElectrodynamicsItems.ITEMS_CRYSTAL.getValue(SubtypeCrystal.potassiumchloride), 1, 1));
        add(CSBlocks.ORE_TIN_MOON.get(),block -> createMultipleOreDrops(CSBlocks.ORE_TIN_MOON.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.tin), 1, 1));
        add(CSBlocks.ORE_TIN_MARS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_TIN_MARS.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.tin), 1, 1));
        add(CSBlocks.ORE_TIN_VENUS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_TIN_VENUS.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.tin), 1, 1));
        add(CSBlocks.ORE_TIN_MERCURY.get(),block -> createMultipleOreDrops(CSBlocks.ORE_TIN_MERCURY.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.tin), 1, 1));
        add(CSBlocks.ORE_TITANIUM_MOON.get(),block -> createMultipleOreDrops(CSBlocks.ORE_TITANIUM_MOON.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.titanium), 1, 1));
        add(CSBlocks.ORE_TITANIUM_MARS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_TITANIUM_MARS.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.titanium), 1, 1));
        add(CSBlocks.ORE_TITANIUM_VENUS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_TITANIUM_VENUS.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.titanium), 1, 1));
        add(CSBlocks.ORE_TITANIUM_MERCURY.get(),block -> createMultipleOreDrops(CSBlocks.ORE_TITANIUM_MERCURY.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.titanium), 1, 1));
        add(CSBlocks.ORE_THORIUM_MOON.get(),block -> createMultipleOreDrops(CSBlocks.ORE_THORIUM_MOON.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.thorium), 1, 1));
        add(CSBlocks.ORE_THORIUM_MARS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_THORIUM_MARS.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.thorium), 1, 1));
        add(CSBlocks.ORE_THORIUM_VENUS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_THORIUM_VENUS.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.thorium), 1, 1));
        add(CSBlocks.ORE_THORIUM_MERCURY.get(),block -> createMultipleOreDrops(CSBlocks.ORE_THORIUM_MERCURY.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.thorium), 1, 1));
        add(CSBlocks.ORE_URANIUM_MOON.get(),block -> createMultipleOreDrops(CSBlocks.ORE_URANIUM_MOON.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.uranium), 1, 1));
        add(CSBlocks.ORE_URANIUM_MARS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_URANIUM_MARS.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.uranium), 1, 1));
        add(CSBlocks.ORE_URANIUM_VENUS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_URANIUM_VENUS.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.uranium), 1, 1));
        add(CSBlocks.ORE_URANIUM_MERCURY.get(),block -> createMultipleOreDrops(CSBlocks.ORE_URANIUM_MERCURY.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.uranium), 1, 1));
        add(CSBlocks.ORE_VANADIUM_MOON.get(),block -> createMultipleOreDrops(CSBlocks.ORE_VANADIUM_MOON.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.vanadinite), 1, 1));
        add(CSBlocks.ORE_VANADIUM_MARS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_VANADIUM_MARS.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.vanadinite), 1, 1));
        add(CSBlocks.ORE_VANADIUM_VENUS.get(),block -> createMultipleOreDrops(CSBlocks.ORE_VANADIUM_VENUS.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.vanadinite), 1, 1));
        add(CSBlocks.ORE_VANADIUM_MERCURY.get(),block -> createMultipleOreDrops(CSBlocks.ORE_VANADIUM_MERCURY.get(), ElectrodynamicsItems.ITEMS_RAWORE.getValue(SubtypeRawOre.vanadinite), 1, 1));
        dropSelf(CSBlocks.ORE_ALUMINUM_MOON.get());
        dropSelf(CSBlocks.ORE_ALUMINUM_MARS.get());
        dropSelf(CSBlocks.ORE_ALUMINUM_VENUS.get());
        dropSelf(CSBlocks.ORE_ALUMINUM_MERCURY.get());
        dropSelf(CSBlocks.ORE_MOLYBDENUM_MOON.get());
        dropSelf(CSBlocks.ORE_MOLYBDENUM_MARS.get());
        dropSelf(CSBlocks.ORE_MOLYBDENUM_VENUS.get());
        dropSelf(CSBlocks.ORE_MOLYBDENUM_MERCURY.get());
        dropSelf(CSBlocks.ORE_MONAZITE_MOON.get());
        dropSelf(CSBlocks.ORE_MONAZITE_MARS.get());
        dropSelf(CSBlocks.ORE_MONAZITE_VENUS.get());
        dropSelf(CSBlocks.ORE_MONAZITE_MERCURY.get());



        // Ressource Block
        dropSelf(CSBlocks.MAGNESIUM_BLOCK.get());
        dropSelf(CSBlocks.SILICON_BLOCK.get());
        dropSelf(CSBlocks.MANGANESE_BLOCK.get());
        dropSelf(CSBlocks.TUNGSTEN_BLOCK.get());
        dropSelf(CSBlocks.PLATINUM_BLOCK.get());

        // Decorative
        dropSelf(CSBlocks.MAGNESIUM_GA9Z1_BLOCK.get());
        dropSelf(CSBlocks.MAGNESIUM_GA9Z1_STAIR.get());
        dropSelf(CSBlocks.MAGNESIUM_GA9Z1_SLAB.get());
        dropSelf(CSBlocks.MAGNESIUM_GA9Z1_LAMP.get());
        dropSelf(CSBlocks.MAGNESIUM_GA9Z1_TRAPDOOR.get());
        add(CSBlocks.MAGNESIUM_GA9Z1_DOOR.get(), block -> createDoorTable(CSBlocks.MAGNESIUM_GA9Z1_DOOR.get()));
        dropSelf(CSBlocks.MAGNESIUM_GA9Z1_FENCE.get());
        dropSelf(CSBlocks.GRATE_MANGANESE.get());
        dropSelf(CSBlocks.LADDER_MANGANESE.get());
        dropSelf(CSBlocks.SCAFFOLDING_MANGANESE.get());
        dropSelf(CSBlocks.SCAFFOLDING_MANGANESE_GRATE.get());
        dropSelf(CSBlocks.SCAFFOLDING_MANGANESE_GLASS.get());
        dropSelf(CSBlocks.SCAFFOLDING_MANGANESE_HOLLOW.get());
        dropSelf(CSBlocks.SCAFFOLDING_MANGANESE_GRATE_HOLLOW.get());
        dropSelf(CSBlocks.SCAFFOLDING_MANGANESE_GLASS_HOLLOW.get());
        dropSelf(CSBlocks.SCAFFOLDING_MANGANESE_SLAB.get());
        dropSelf(CSBlocks.SCAFFOLDING_MANGANESE_GRATE_SLAB.get());
        dropSelf(CSBlocks.SCAFFOLDING_MANGANESE_GLASS_SLAB.get());
        dropSelf(CSBlocks.GRATE_STEEL.get());
        dropSelf(CSBlocks.LADDER_STEEL.get());
        dropSelf(CSBlocks.SCAFFOLDING_STEEL_GRATE.get());
        dropSelf(CSBlocks.SCAFFOLDING_STEEL_GLASS.get());
        dropSelf(CSBlocks.SCAFFOLDING_STEEL_HOLLOW.get());
        dropSelf(CSBlocks.SCAFFOLDING_STEEL_GRATE_HOLLOW.get());
        dropSelf(CSBlocks.SCAFFOLDING_STEEL_GLASS_HOLLOW.get());
        dropSelf(CSBlocks.SCAFFOLDING_STEEL_SLAB.get());
        dropSelf(CSBlocks.SCAFFOLDING_STEEL_GRATE_SLAB.get());
        dropSelf(CSBlocks.SCAFFOLDING_STEEL_GLASS_SLAB.get());
        dropSelf(CSBlocks.METAL_HALIDE_LAMP_MANGANESE_WHITE.get());
        dropSelf(CSBlocks.METAL_HALIDE_LAMP_MANGANESE_RED.get());
        dropSelf(CSBlocks.METAL_HALIDE_LAMP_MANGANESE_GREEN.get());
        dropSelf(CSBlocks.METAL_HALIDE_LAMP_MANGANESE_BLUE.get());
        dropSelf(CSBlocks.METAL_HALIDE_LAMP_STEEL_WHITE.get());
        dropSelf(CSBlocks.METAL_HALIDE_LAMP_STEEL_RED.get());
        dropSelf(CSBlocks.METAL_HALIDE_LAMP_STEEL_GREEN.get());
        dropSelf(CSBlocks.METAL_HALIDE_LAMP_STEEL_BLUE.get());
        dropSelf(CSBlocks.SYMBOL_BIOHAZARD.get());
        dropSelf(CSBlocks.SYMBOL_RADIATION.get());
        dropSelf(CSBlocks.SYMBOL_DANGER.get());
        dropSelf(CSBlocks.SYMBOL_ELECTRICAL.get());
        dropSelf(CSBlocks.SYMBOL_FLAMMABLE.get());
        dropSelf(CSBlocks.SYMBOL_TOXIC.get());
        dropSelf(CSBlocks.SYMBOL_CORROSIVE.get());
        dropSelf(CSBlocks.SYMBOL_PRESSURE.get());
        dropSelf(CSBlocks.SYMBOL_EXPLOSIVE.get());
        dropSelf(CSBlocks.RACK_MANGANESE.get());
        dropSelf(CSBlocks.RACK_STEEL.get());
        dropSelf(CSBlocks.LABORATORY_BENCH.get());
        dropSelf(CSBlocks.LABORATORY_SUPPORT.get());
        dropSelf(CSBlocks.LABORATORY_SINK.get());
        dropSelf(CSBlocks.LABORATORY_STORAGE.get());

        dropSelf(CSBlocks.ASPHALT_BLOCK.get());
        dropSelf(CSBlocks.ASPHALT_STAIR.get());
        dropSelf(CSBlocks.ASPHALT_SLAB.get());
        dropSelf(CSBlocks.MARKED_LINE_WHITE_ASPHALT_BLOCK.get());
        dropSelf(CSBlocks.MARKED_DOT_WHITE_ASPHALT_BLOCK.get());
        dropSelf(CSBlocks.MARKED_LINE_YELLOW_ASPHALT_BLOCK.get());
        dropSelf(CSBlocks.MARKED_DOT_YELLOW_ASPHALT_BLOCK.get());

        dropSelf(CSBlocks.CONCRETE_SHIELDING.get());
        dropSelf(CSBlocks.TANTALUM_SHIELDING.get());

        // Machines
        dropSelf(CSBlocks.ORGANIC_SOLAR_PANEL.get());
        dropSelf(CSBlocks.FUEL_CELL.get());
        dropSelf(CSBlocks.CIRCUIT_MAKER.get());
        dropSelf(CSBlocks.HDS_UNIT.get());
        dropSelf(CSBlocks.STEAM_CRACKER.get());
        dropSelf(CSBlocks.CATALYTIC_REFORMER.get());
        dropSelf(CSBlocks.SPIN_COATER.get());
        dropSelf(CSBlocks.FRACTIONATING_COLUMN.get());
        dropSelf(CSBlocks.CHEMICAL_BENCH.get());
        dropSelf(CSBlocks.REDOX_FURNACE.get());

            // Periodic table
        dropSelf(CSBlocks.ELEMENT_H.get());
        dropSelf(CSBlocks.ELEMENT_HE.get());
        dropSelf(CSBlocks.ELEMENT_LI.get());
        dropSelf(CSBlocks.ELEMENT_BE.get());
        dropSelf(CSBlocks.ELEMENT_B.get());
        dropSelf(CSBlocks.ELEMENT_C.get());
        dropSelf(CSBlocks.ELEMENT_N.get());
        dropSelf(CSBlocks.ELEMENT_O.get());
        dropSelf(CSBlocks.ELEMENT_F.get());
        dropSelf(CSBlocks.ELEMENT_NE.get());
        dropSelf(CSBlocks.ELEMENT_NA.get());
        dropSelf(CSBlocks.ELEMENT_MG.get());
        dropSelf(CSBlocks.ELEMENT_AL.get());
        dropSelf(CSBlocks.ELEMENT_SI.get());
        dropSelf(CSBlocks.ELEMENT_P.get());
        dropSelf(CSBlocks.ELEMENT_S.get());
        dropSelf(CSBlocks.ELEMENT_CL.get());
        dropSelf(CSBlocks.ELEMENT_AR.get());
        dropSelf(CSBlocks.ELEMENT_K.get());
        dropSelf(CSBlocks.ELEMENT_CA.get());
        dropSelf(CSBlocks.ELEMENT_SC.get());
        dropSelf(CSBlocks.ELEMENT_TI.get());
        dropSelf(CSBlocks.ELEMENT_V.get());
        dropSelf(CSBlocks.ELEMENT_CR.get());
        dropSelf(CSBlocks.ELEMENT_MN.get());
        dropSelf(CSBlocks.ELEMENT_FE.get());
        dropSelf(CSBlocks.ELEMENT_CO.get());
        dropSelf(CSBlocks.ELEMENT_NI.get());
        dropSelf(CSBlocks.ELEMENT_CU.get());
        dropSelf(CSBlocks.ELEMENT_ZN.get());
        dropSelf(CSBlocks.ELEMENT_GA.get());
        dropSelf(CSBlocks.ELEMENT_GE.get());
        dropSelf(CSBlocks.ELEMENT_AS.get());
        dropSelf(CSBlocks.ELEMENT_SE.get());
        dropSelf(CSBlocks.ELEMENT_BR.get());
        dropSelf(CSBlocks.ELEMENT_KR.get());
        dropSelf(CSBlocks.ELEMENT_RB.get());
        dropSelf(CSBlocks.ELEMENT_SR.get());
        dropSelf(CSBlocks.ELEMENT_Y.get());
        dropSelf(CSBlocks.ELEMENT_ZR.get());
        dropSelf(CSBlocks.ELEMENT_NB.get());
        dropSelf(CSBlocks.ELEMENT_MO.get());
        dropSelf(CSBlocks.ELEMENT_TC.get());
        dropSelf(CSBlocks.ELEMENT_RU.get());
        dropSelf(CSBlocks.ELEMENT_RH.get());
        dropSelf(CSBlocks.ELEMENT_PD.get());
        dropSelf(CSBlocks.ELEMENT_AG.get());
        dropSelf(CSBlocks.ELEMENT_CD.get());
        dropSelf(CSBlocks.ELEMENT_IN.get());
        dropSelf(CSBlocks.ELEMENT_SN.get());
        dropSelf(CSBlocks.ELEMENT_SB.get());
        dropSelf(CSBlocks.ELEMENT_TE.get());
        dropSelf(CSBlocks.ELEMENT_I.get());
        dropSelf(CSBlocks.ELEMENT_XE.get());
        dropSelf(CSBlocks.ELEMENT_CS.get());
        dropSelf(CSBlocks.ELEMENT_BA.get());
        dropSelf(CSBlocks.ELEMENT_LA.get());
        dropSelf(CSBlocks.ELEMENT_CE.get());
        dropSelf(CSBlocks.ELEMENT_PR.get());
        dropSelf(CSBlocks.ELEMENT_ND.get());
        dropSelf(CSBlocks.ELEMENT_PM.get());
        dropSelf(CSBlocks.ELEMENT_SM.get());
        dropSelf(CSBlocks.ELEMENT_EU.get());
        dropSelf(CSBlocks.ELEMENT_GD.get());
        dropSelf(CSBlocks.ELEMENT_TB.get());
        dropSelf(CSBlocks.ELEMENT_DY.get());
        dropSelf(CSBlocks.ELEMENT_HO.get());
        dropSelf(CSBlocks.ELEMENT_ER.get());
        dropSelf(CSBlocks.ELEMENT_TM.get());
        dropSelf(CSBlocks.ELEMENT_YB.get());
        dropSelf(CSBlocks.ELEMENT_LU.get());
        dropSelf(CSBlocks.ELEMENT_HF.get());
        dropSelf(CSBlocks.ELEMENT_TA.get());
        dropSelf(CSBlocks.ELEMENT_W.get());
        dropSelf(CSBlocks.ELEMENT_RE.get());
        dropSelf(CSBlocks.ELEMENT_OS.get());
        dropSelf(CSBlocks.ELEMENT_IR.get());
        dropSelf(CSBlocks.ELEMENT_PT.get());
        dropSelf(CSBlocks.ELEMENT_AU.get());
        dropSelf(CSBlocks.ELEMENT_HG.get());
        dropSelf(CSBlocks.ELEMENT_TL.get());
        dropSelf(CSBlocks.ELEMENT_PB.get());
        dropSelf(CSBlocks.ELEMENT_BI.get());
        dropSelf(CSBlocks.ELEMENT_PO.get());
        dropSelf(CSBlocks.ELEMENT_AT.get());
        dropSelf(CSBlocks.ELEMENT_RN.get());
        dropSelf(CSBlocks.ELEMENT_FR.get());
        dropSelf(CSBlocks.ELEMENT_RA.get());
        dropSelf(CSBlocks.ELEMENT_AC.get());
        dropSelf(CSBlocks.ELEMENT_TH.get());
        dropSelf(CSBlocks.ELEMENT_PA.get());
        dropSelf(CSBlocks.ELEMENT_U.get());
        dropSelf(CSBlocks.ELEMENT_NP.get());
        dropSelf(CSBlocks.ELEMENT_PU.get());
        dropSelf(CSBlocks.ELEMENT_AM.get());
        dropSelf(CSBlocks.ELEMENT_CM.get());
        dropSelf(CSBlocks.ELEMENT_BK.get());
        dropSelf(CSBlocks.ELEMENT_CF.get());
        dropSelf(CSBlocks.ELEMENT_ES.get());
        dropSelf(CSBlocks.ELEMENT_FM.get());
        dropSelf(CSBlocks.ELEMENT_MD.get());
        dropSelf(CSBlocks.ELEMENT_NO.get());
        dropSelf(CSBlocks.ELEMENT_LR.get());
        dropSelf(CSBlocks.ELEMENT_RF.get());
        dropSelf(CSBlocks.ELEMENT_DB.get());
        dropSelf(CSBlocks.ELEMENT_SG.get());
        dropSelf(CSBlocks.ELEMENT_BH.get());
        dropSelf(CSBlocks.ELEMENT_HS.get());
        dropSelf(CSBlocks.ELEMENT_MT.get());
        dropSelf(CSBlocks.ELEMENT_DS.get());
        dropSelf(CSBlocks.ELEMENT_RG.get());
        dropSelf(CSBlocks.ELEMENT_CN.get());
        dropSelf(CSBlocks.ELEMENT_NH.get());
        dropSelf(CSBlocks.ELEMENT_FL.get());
        dropSelf(CSBlocks.ELEMENT_MC.get());
        dropSelf(CSBlocks.ELEMENT_LV.get());
        dropSelf(CSBlocks.ELEMENT_TS.get());
        dropSelf(CSBlocks.ELEMENT_OG.get());



    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return CSBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }

    @Override
    public List<Block> getExcludedBlocks() {
        return List.of((Block) ElectrodynamicsBlocks.BLOCK_FRAME.get(), (Block)ElectrodynamicsBlocks.BLOCK_FRAME_CORNER.get(), (Block)ElectrodynamicsBlocks.BLOCK_COMPRESSOR_SIDE.get(), (Block)ElectrodynamicsBlocks.BLOCK_CHEMICALREACTOREXTRA_MIDDLE.get(), (Block)ElectrodynamicsBlocks.BLOCK_CHEMICALREACTOREXTRA_TOP.get());
    }
}
