package net.pastek.chemicalscience.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import electrodynamics.common.block.states.ElectrodynamicsBlockStates;
import electrodynamics.common.block.subtype.SubtypeMachine;
import electrodynamics.common.block.subtype.SubtypeResourceBlock;
import electrodynamics.registers.ElectrodynamicsBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Vec3i;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.common.tile.TileChemicalBench;
import net.pastek.chemicalscience.common.tile.TileFractionatingColumn;
import net.pastek.chemicalscience.common.tile.TileRedoxFurnace;
import net.pastek.chemicalscience.registers.CSBlocks;
import voltaic.api.multiblock.assemblybased.MultiblockSlaveNode;
import voltaic.common.block.states.VoltaicBlockStates;
import voltaic.datagen.utils.server.multiblock.BaseMultiblockProvider;
import voltaic.registers.VoltaicBlocks;

public class CSMultiblockProvider extends BaseMultiblockProvider {

    public CSMultiblockProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, existingFileHelper, ChemicalScience.MOD_ID);
    }

    @Override
    protected void gather() {

        BlockState slave = VoltaicBlocks.BLOCK_MULTIBLOCK_SLAVE.get().defaultBlockState().setValue(VoltaicBlockStates.WATERLOGGED, false);
        BlockState scaffold_steel = ElectrodynamicsBlocks.BLOCK_STEELSCAFFOLDING.get().defaultBlockState();
        BlockState grate_steel = CSBlocks.GRATE_STEEL.get().defaultBlockState();
        BlockState scaffold_manganese = CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState();

        ResourceLocation empty = ChemicalScience.rl("multiblock/empty");
//        ResourceLocation fcBottomcenter = ChemicalScience.rl("multiblock/fc_bottomcenter");
//        ResourceLocation fcBottomcorner = ChemicalScience.rl("multiblock/fc_bottomcorner");
//        ResourceLocation fcBottomseparator = ChemicalScience.rl("multiblock/fc_bottomcenter");
//        ResourceLocation fcBottomside = ChemicalScience.rl("multiblock/fc_bottomside");
//        ResourceLocation fcFluidin = ChemicalScience.rl("multiblock/fc_fluidin");
//        ResourceLocation fcFluidout = ChemicalScience.rl("multiblock/fc_fluidout");
//        ResourceLocation fcGasout = ChemicalScience.rl("multiblock/fc_gasout");
//        ResourceLocation fcGauge = ChemicalScience.rl("multiblock/fc_gauge");
//        ResourceLocation fcMetal = ChemicalScience.rl("multiblock/fc_metal");
//        ResourceLocation fcPowerin = ChemicalScience.rl("multiblock/fc_powerin");
//        ResourceLocation fcScaffold = ChemicalScience.rl("multiblock/fc_scaffold");
//        ResourceLocation fcSeparator = ChemicalScience.rl("multiblock/fc_separator");
//        ResourceLocation fcVent = ChemicalScience.rl("multiblock/fc_vent");



        /** Fractionating Column */
        addMultiblock(TileFractionatingColumn.ID, List.of(

                //Layer 0 - Power Input
                new MultiblockSlaveNode(slave, scaffold_steel, MultiblockSlaveNode.NOTAG, new Vec3i(0, -1, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_steel, MultiblockSlaveNode.NOTAG, new Vec3i(1, -1, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_steel, MultiblockSlaveNode.NOTAG, new Vec3i(-1, -1, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_steel, MultiblockSlaveNode.NOTAG, new Vec3i(1, -1, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_steel, MultiblockSlaveNode.NOTAG, new Vec3i(-1, -1, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_steel, MultiblockSlaveNode.NOTAG, new Vec3i(1, -1, -2), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_steel, MultiblockSlaveNode.NOTAG, new Vec3i(-1, -1, -2), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.electricarcfurnace).defaultBlockState().setValue(VoltaicBlockStates.WATERLOGGED, false).setValue(VoltaicBlockStates.LIT, false), MultiblockSlaveNode.NOTAG, new Vec3i(0, -1, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, Blocks.GOLD_BLOCK.defaultBlockState(), MultiblockSlaveNode.NOTAG, new Vec3i(0, -1, -2), Shapes.block(), empty),

                //Layer 1 - Fluid Input
                new MultiblockSlaveNode(slave, Blocks.IRON_BLOCK.defaultBlockState(), MultiblockSlaveNode.NOTAG, new Vec3i(1, 0, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, Blocks.IRON_BLOCK.defaultBlockState(), MultiblockSlaveNode.NOTAG, new Vec3i(-1, 0, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, Blocks.IRON_BLOCK.defaultBlockState(), MultiblockSlaveNode.NOTAG, new Vec3i(1, 0, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.tanksteel).defaultBlockState().setValue(VoltaicBlockStates.WATERLOGGED, false).setValue(VoltaicBlockStates.LIT, false), MultiblockSlaveNode.NOTAG, new Vec3i(-1, 0, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, Blocks.IRON_BLOCK.defaultBlockState(), MultiblockSlaveNode.NOTAG, new Vec3i(1, 0, -2), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, Blocks.IRON_BLOCK.defaultBlockState(), MultiblockSlaveNode.NOTAG, new Vec3i(-1, 0, -2), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, Blocks.IRON_BLOCK.defaultBlockState(), MultiblockSlaveNode.NOTAG, new Vec3i(0, 0, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, Blocks.IRON_BLOCK.defaultBlockState(), MultiblockSlaveNode.NOTAG, new Vec3i(0, 0, -2), Shapes.block(), empty),

                //Layer 2
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(0, 1, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(1, 1, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(-1, 1, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(1, 1, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(-1, 1, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(1, 1, -2), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(-1, 1, -2), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(0, 1, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(0, 1, -2), Shapes.block(), empty),

                //Layer 3 - Heavy Oil Output
                new MultiblockSlaveNode(slave, ElectrodynamicsBlocks.BLOCK_COMPRESSOR.get().defaultBlockState().setValue(VoltaicBlockStates.WATERLOGGED, false).setValue(VoltaicBlockStates.LIT, false).setValue(ElectrodynamicsBlockStates.COMPRESSORSIDE_HAS_TOPTANK, false), MultiblockSlaveNode.NOTAG, new Vec3i(0, 2, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(1, 2, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(-1, 2, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.tanksteel).defaultBlockState().setValue(VoltaicBlockStates.WATERLOGGED, false).setValue(VoltaicBlockStates.LIT, false), MultiblockSlaveNode.NOTAG, new Vec3i(1, 2, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(-1, 2, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(1, 2, -2), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(-1, 2, -2), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(0, 2, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(0, 2, -2), Shapes.block(), empty),

                //Layer 4
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(0, 3, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(1, 3, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(-1, 3, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(1, 3, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(-1, 3, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(1, 3, -2), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(-1, 3, -2), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(0, 3, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(0, 3, -2), Shapes.block(), empty),

                //Layer 5 - Diesel Output
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(0, 4, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(1, 4, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(-1, 4, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.tanksteel).defaultBlockState().setValue(VoltaicBlockStates.WATERLOGGED, false).setValue(VoltaicBlockStates.LIT, false), MultiblockSlaveNode.NOTAG, new Vec3i(1, 4, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(-1, 4, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(1, 4, -2), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(-1, 4, -2), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(0, 4, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(0, 4, -2), Shapes.block(), empty),

                //Layer 6
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(0, 5, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(1, 5, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(-1, 5, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(1, 5, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(-1, 5, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(1, 5, -2), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(-1, 5, -2), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(0, 5, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(0, 5, -2), Shapes.block(), empty),

                //Layer 7 - Fuel Output
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(0, 6, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(1, 6, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(-1, 6, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.tanksteel).defaultBlockState().setValue(VoltaicBlockStates.WATERLOGGED, false).setValue(VoltaicBlockStates.LIT, false), MultiblockSlaveNode.NOTAG, new Vec3i(1, 6, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(-1, 6, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(1, 6, -2), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(-1, 6, -2), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(0, 6, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(0, 6, -2), Shapes.block(), empty),

                //Layer 8
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(0, 7, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(1, 7, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(-1, 7, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(1, 7, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(-1, 7, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(1, 7, -2), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(-1, 7, -2), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(0, 7, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(0, 7, -2), Shapes.block(), empty),

                //Layer 9 - Naphta Output
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(0, 8, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(1, 8, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(-1, 8, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.tanksteel).defaultBlockState().setValue(VoltaicBlockStates.WATERLOGGED, false).setValue(VoltaicBlockStates.LIT, false), MultiblockSlaveNode.NOTAG, new Vec3i(1, 8, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(-1, 8, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(1, 8, -2), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(-1, 8, -2), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(0, 8, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(0, 8, -2), Shapes.block(), empty),

                //Layer 10
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(0, 9, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(1, 9, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(-1, 9, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(1, 9, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(-1, 9, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(1, 9, -2), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(-1, 9, -2), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(0, 9, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, grate_steel, MultiblockSlaveNode.NOTAG, new Vec3i(0, 9, -2), Shapes.block(), empty),

                //Layer 11 - Gas Output
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(0, 10, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(1, 10, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(-1, 10, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.gastanksteel).defaultBlockState().setValue(VoltaicBlockStates.WATERLOGGED, false).setValue(VoltaicBlockStates.LIT, false), MultiblockSlaveNode.NOTAG, new Vec3i(1, 10, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(-1, 10, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(1, 10, -2), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(-1, 10, -2), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(0, 10, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_manganese, MultiblockSlaveNode.NOTAG, new Vec3i(0, 10, -2), Shapes.block(), empty),

                //Layer 12 - Top vent
                new MultiblockSlaveNode(slave, scaffold_steel, MultiblockSlaveNode.NOTAG, new Vec3i(0, 11, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_steel, MultiblockSlaveNode.NOTAG, new Vec3i(1, 11, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_steel, MultiblockSlaveNode.NOTAG, new Vec3i(-1, 11, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_steel, MultiblockSlaveNode.NOTAG, new Vec3i(1, 11, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_steel, MultiblockSlaveNode.NOTAG, new Vec3i(-1, 11, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_steel, MultiblockSlaveNode.NOTAG, new Vec3i(1, 11, -2), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_steel, MultiblockSlaveNode.NOTAG, new Vec3i(-1, 11, -2), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.gasvent).defaultBlockState().setValue(VoltaicBlockStates.WATERLOGGED, false).setValue(VoltaicBlockStates.LIT, false), MultiblockSlaveNode.NOTAG, new Vec3i(0, 11, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, scaffold_steel, MultiblockSlaveNode.NOTAG, new Vec3i(0, 11, -2), Shapes.block(), empty)

        ));

        /** Chemical Bench */
        addMultiblock(TileChemicalBench.ID, List.of(

                //Layer 0
                new MultiblockSlaveNode(slave, CSBlocks.LABORATORY_STORAGE.get().defaultBlockState().setValue(VoltaicBlockStates.WATERLOGGED, false), MultiblockSlaveNode.NOTAG, new Vec3i(-1, 0, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, CSBlocks.LABORATORY_SINK.get().defaultBlockState(), MultiblockSlaveNode.NOTAG, new Vec3i(-1, 0, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, CSBlocks.LABORATORY_SINK.get().defaultBlockState(), MultiblockSlaveNode.NOTAG, new Vec3i(0, 0, -1), Shapes.block(), empty),

                //Layer 1
                new MultiblockSlaveNode(slave, CSBlocks.LABORATORY_SUPPORT.get().defaultBlockState(), MultiblockSlaveNode.NOTAG, new Vec3i(-1, 1, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, CSBlocks.LABORATORY_SUPPORT.get().defaultBlockState(), MultiblockSlaveNode.NOTAG, new Vec3i(-1, 1, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, CSBlocks.LABORATORY_SUPPORT.get().defaultBlockState(), MultiblockSlaveNode.NOTAG, new Vec3i(0, 1, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, CSBlocks.LABORATORY_SUPPORT.get().defaultBlockState(), MultiblockSlaveNode.NOTAG, new Vec3i(0, 1, 0), Shapes.block(), empty),

                //Layer 2
                new MultiblockSlaveNode(slave, ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.gasvent).defaultBlockState().setValue(VoltaicBlockStates.WATERLOGGED, false), MultiblockSlaveNode.NOTAG, new Vec3i(-1, 2, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.gasvent).defaultBlockState().setValue(VoltaicBlockStates.WATERLOGGED, false), MultiblockSlaveNode.NOTAG, new Vec3i(-1, 2, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.gasvent).defaultBlockState().setValue(VoltaicBlockStates.WATERLOGGED, false), MultiblockSlaveNode.NOTAG, new Vec3i(0, 2, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.gasvent).defaultBlockState().setValue(VoltaicBlockStates.WATERLOGGED, false), MultiblockSlaveNode.NOTAG, new Vec3i(0, 2, 0), Shapes.block(), empty)
        ));

        /** Redox furnace */
        addMultiblock(TileRedoxFurnace.ID, List.of(

                //Layer 0
                new MultiblockSlaveNode(slave, scaffold_steel, MultiblockSlaveNode.NOTAG, new Vec3i(-1, 0, 0), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, ElectrodynamicsBlocks.BLOCKS_RESOURCE.getValue(SubtypeResourceBlock.steel).defaultBlockState(), MultiblockSlaveNode.NOTAG, new Vec3i(-1, 0, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, ElectrodynamicsBlocks.BLOCKS_RESOURCE.getValue(SubtypeResourceBlock.steel).defaultBlockState(), MultiblockSlaveNode.NOTAG, new Vec3i(0, 0, -1), Shapes.block(), empty),

                //Layer 1
                new MultiblockSlaveNode(slave, CSBlocks.TUNGSTEN_BLOCK.get().defaultBlockState(), MultiblockSlaveNode.NOTAG, new Vec3i(-1, 1, -1), Shapes.block(), empty),
                new MultiblockSlaveNode(slave, ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.oxidationfurnace).defaultBlockState().setValue(VoltaicBlockStates.WATERLOGGED, false).setValue(VoltaicBlockStates.LIT, false), MultiblockSlaveNode.NOTAG, new Vec3i(0, 1, 0), Shapes.block(), empty),

                //Layer 2
                new MultiblockSlaveNode(slave, scaffold_steel, MultiblockSlaveNode.NOTAG, new Vec3i(-1, 2, -1), Shapes.block(), empty)
        ));
    }

}