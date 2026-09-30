package net.pastek.chemicalscience.registers;

import com.google.common.collect.Sets;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.common.block.subtype.SubtypeChemicalMachine;
import net.pastek.chemicalscience.common.tile.TileCatalyticReformer;
import net.pastek.chemicalscience.common.tile.TileChemicalBench;
import net.pastek.chemicalscience.common.tile.TileCircuitMaker;
import net.pastek.chemicalscience.common.tile.TileFractionatingColumn;
import net.pastek.chemicalscience.common.tile.TileFuelCell;
import net.pastek.chemicalscience.common.tile.TileHDSUnit;
import net.pastek.chemicalscience.common.tile.TileLabBench;
import net.pastek.chemicalscience.common.tile.TileLabStorage;
import net.pastek.chemicalscience.common.tile.TileOrganicSolarPanel;
import net.pastek.chemicalscience.common.tile.TileRackM;
import net.pastek.chemicalscience.common.tile.TileRackS;
import net.pastek.chemicalscience.common.tile.TileRedoxFurnace;
import net.pastek.chemicalscience.common.tile.TileSpinCoater;
import net.pastek.chemicalscience.common.tile.TileSteamCracker;

@SuppressWarnings("null")
public class CSTiles {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister
	    .create(Registries.BLOCK_ENTITY_TYPE, ChemicalScience.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileOrganicSolarPanel>> TILE_ORGANICSOLARPANEL = BLOCK_ENTITY_TYPES
	    .register(SubtypeChemicalMachine.organicsolarpanel.tag(),
		    () -> new BlockEntityType<>(TileOrganicSolarPanel::new,
			    Sets.newHashSet(CSBlocks.ORGANIC_SOLAR_PANEL.get()), null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileFuelCell>> TILE_FUELCELL = BLOCK_ENTITY_TYPES
	    .register(SubtypeChemicalMachine.fuelcell.tag(),
		    () -> new BlockEntityType<>(TileFuelCell::new, Sets.newHashSet(CSBlocks.FUEL_CELL.get()), null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileRackM>> TILE_RACK_M = BLOCK_ENTITY_TYPES
	    .register(SubtypeChemicalMachine.rackm.tag(),
		    () -> new BlockEntityType<>(TileRackM::new, Sets.newHashSet(CSBlocks.RACK_MANGANESE.get()), null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileRackS>> TILE_RACK_S = BLOCK_ENTITY_TYPES
	    .register(SubtypeChemicalMachine.racks.tag(),
		    () -> new BlockEntityType<>(TileRackS::new, Sets.newHashSet(CSBlocks.RACK_STEEL.get()), null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileLabBench>> TILE_LAB_BENCH = BLOCK_ENTITY_TYPES
	    .register(SubtypeChemicalMachine.labbench.tag(), () -> new BlockEntityType<>(TileLabBench::new,
		    Sets.newHashSet(CSBlocks.LABORATORY_BENCH.get()), null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileLabStorage>> TILE_LAB_STORAGE = BLOCK_ENTITY_TYPES
	    .register(SubtypeChemicalMachine.labstorage.tag(), () -> new BlockEntityType<>(TileLabStorage::new,
		    Sets.newHashSet(CSBlocks.LABORATORY_STORAGE.get()), null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileCircuitMaker>> TILE_CIRCUIT_MAKER = BLOCK_ENTITY_TYPES
	    .register(SubtypeChemicalMachine.circuitmaker.tag(), () -> new BlockEntityType<>(TileCircuitMaker::new,
		    Sets.newHashSet(CSBlocks.CIRCUIT_MAKER.get()), null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileHDSUnit>> TILE_HDS_UNIT = BLOCK_ENTITY_TYPES
	    .register(SubtypeChemicalMachine.hdsunit.tag(),
		    () -> new BlockEntityType<>(TileHDSUnit::new, Sets.newHashSet(CSBlocks.HDS_UNIT.get()), null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileSteamCracker>> TILE_STEAM_CRACKER = BLOCK_ENTITY_TYPES
	    .register(SubtypeChemicalMachine.steamcracker.tag(), () -> new BlockEntityType<>(TileSteamCracker::new,
		    Sets.newHashSet(CSBlocks.STEAM_CRACKER.get()), null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileCatalyticReformer>> TILE_CATALYTIC_REFORMER = BLOCK_ENTITY_TYPES
	    .register(SubtypeChemicalMachine.catalyticreformer.tag(),
		    () -> new BlockEntityType<>(TileCatalyticReformer::new,
			    Sets.newHashSet(CSBlocks.CATALYTIC_REFORMER.get()), null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileSpinCoater>> TILE_SPIN_COATER = BLOCK_ENTITY_TYPES
	    .register(SubtypeChemicalMachine.spincoater.tag(), () -> new BlockEntityType<>(TileSpinCoater::new,
		    Sets.newHashSet(CSBlocks.SPIN_COATER.get()), null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileFractionatingColumn>> TILE_FRACTIONATING_COLUMN = BLOCK_ENTITY_TYPES
	    .register(SubtypeChemicalMachine.fractionatingcolumn.tag(),
		    () -> new BlockEntityType<>(TileFractionatingColumn::new,
			    Sets.newHashSet(CSBlocks.FRACTIONATING_COLUMN.get()), null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileChemicalBench>> TILE_CHEMICAL_BENCH = BLOCK_ENTITY_TYPES
	    .register(SubtypeChemicalMachine.chemicalbench.tag(), () -> new BlockEntityType<>(TileChemicalBench::new,
		    Sets.newHashSet(CSBlocks.CHEMICAL_BENCH.get()), null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileRedoxFurnace>> TILE_REDOX_FURNACE = BLOCK_ENTITY_TYPES
	    .register(SubtypeChemicalMachine.redoxfurnace.tag(), () -> new BlockEntityType<>(TileRedoxFurnace::new,
		    Sets.newHashSet(CSBlocks.REDOX_FURNACE.get()), null));

}