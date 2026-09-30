package net.pastek.chemicalscience.client.roadmap;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import electrodynamics.common.block.subtype.SubtypeMachine;
import electrodynamics.common.block.subtype.SubtypeResourceBlock;
import electrodynamics.common.block.subtype.SubtypeWire;
import electrodynamics.common.item.subtype.SubtypeDust;
import electrodynamics.common.item.subtype.SubtypeImpureDust;
import electrodynamics.common.item.subtype.SubtypeIngot;
import electrodynamics.common.item.subtype.SubtypePlate;
import electrodynamics.registers.ElectrodynamicsBlocks;
import electrodynamics.registers.ElectrodynamicsItems;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.registers.CSBlocks;
import voltaic.registers.VoltaicItems;

public class RoadMapNodes {

    public static int colorWireiron = 0xFFBEBEBE;
    public static int colorWiretin = 0xFFC0BBB6;
    public static int colorWirecopper = 0xFFD46B46;
    public static int colorWiresilver = 0xFFDCDCDC;
    public static int colorWiregold = 0xFFFBE554;
    public static int colorWiresuperconductive = 0xFFA2A293;

    public static final List<ScreenRoadMap.RoadmapNode> NODES = List.of(
            new ScreenRoadMap.RoadmapNode(
                    rl("electrodynamics"),
                    -128, 0,
                    new ItemStack(Items.CRAFTING_TABLE),
                    Component.translatable("roadmap.chemicalscience.node.electrodynamics.title").withStyle(ChatFormatting.YELLOW),
                    Component.translatable("roadmap.chemicalscience.node.electrodynamics.desc"),
                    rl("textures/screen/roadmap/nodes/root.png"),
                    1,
                    List.of(),
                    colorWireiron,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("ingotsteel"),
                    -64, -64,
                    new ItemStack(ElectrodynamicsItems.ITEMS_INGOT.getValue(SubtypeIngot.steel)),
                    Component.translatable("roadmap.chemicalscience.node.ingotsteel.title"),
                    Component.translatable("roadmap.chemicalscience.node.ingotsteel.desc"),
                    null,
                    1,
                    List.of(rl("wirecopper")),
                    colorWireiron,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
            null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("platesteel"),
                    0, -64,
                    new ItemStack(ElectrodynamicsItems.ITEMS_PLATE.getValue(SubtypePlate.steel)),
                    Component.translatable("roadmap.chemicalscience.node.platesteel.title"),
                    Component.translatable("roadmap.chemicalscience.node.platesteel.desc"),
                    null,
                    1,
                    List.of(rl("ingotsteel")),
                    colorWireiron,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("wirecopper"),
                    -64, 0,
                    new ItemStack(ElectrodynamicsItems.ITEMS_WIRE.getValue(SubtypeWire.copper)),
                    Component.translatable("roadmap.chemicalscience.node.wirecopper.title"),
                    Component.translatable("roadmap.chemicalscience.node.wirecopper.desc"),
                    null,
                    1,
                    List.of(rl("electrodynamics")),
                    colorWireiron,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("coil"),
                    0, 0,
                    new ItemStack(ElectrodynamicsItems.ITEM_COIL),
                    Component.translatable("roadmap.chemicalscience.node.coil.title"),
                    Component.translatable("roadmap.chemicalscience.node.coil.desc"),
                    null,
                    1,
                    List.of(rl("wirecopper")),
                    colorWireiron,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("insulation"),
                    -64, 64,
                    new ItemStack(ElectrodynamicsItems.ITEM_INSULATION),
                    Component.translatable("roadmap.chemicalscience.node.insulation.title"),
                    Component.translatable("roadmap.chemicalscience.node.insulation.desc"),
                    null,
                    1,
                    List.of(rl("wirecopper")),
                    colorWireiron,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("insulatedwire"),
                    0, 64,
                    new ItemStack(ElectrodynamicsItems.ITEMS_WIRE.getValue(SubtypeWire.insulatedcopperblack)),
                    Component.translatable("roadmap.chemicalscience.node.insulatedwire.title"),
                    Component.translatable("roadmap.chemicalscience.node.insulatedwire.desc"),
                    null,
                    1,
                    List.of(rl("insulation")),
                    colorWireiron,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("motor"),
                    64, 0,
                    new ItemStack(ElectrodynamicsItems.ITEM_MOTOR),
                    Component.translatable("roadmap.chemicalscience.node.motor.title"),
                    Component.translatable("roadmap.chemicalscience.node.motor.desc"),
                    null,
                    1,
                    List.of(rl("coil"), rl("platesteel"), rl("insulatedwire")),
                    colorWireiron,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("coalgenerator"),
                    128, 0,
                    new ItemStack(ElectrodynamicsItems.ITEMS_MACHINE.getValue(SubtypeMachine.coalgenerator)),
                    Component.translatable("roadmap.chemicalscience.node.coalgenerator.title"),
                    Component.translatable("roadmap.chemicalscience.node.coalgenerator.desc"),
                    null,
                    1,
                    List.of(rl("motor")),
                    colorWiretin,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("tiningot"),
                    128, 64,
                    new ItemStack(ElectrodynamicsItems.ITEMS_INGOT.getValue(SubtypeIngot.tin)),
                    Component.translatable("roadmap.chemicalscience.node.tiningot.title"),
                    Component.translatable("roadmap.chemicalscience.node.tiningot.desc"),
                    null,
                    1,
                    List.of(rl("coalgenerator")),
                    colorWiretin,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("battery"),
                    196, 64,
                    new ItemStack(ElectrodynamicsItems.ITEM_BATTERY),
                    Component.translatable("roadmap.chemicalscience.node.battery.title"),
                    Component.translatable("roadmap.chemicalscience.node.battery.desc"),
                    null,
                    1,
                    List.of(rl("tiningot")),
                    colorWiretin,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("batterybox"),
                    196, 0,
                    new ItemStack(ElectrodynamicsItems.ITEMS_MACHINE.getValue(SubtypeMachine.batterybox)),
                    Component.translatable("roadmap.chemicalscience.node.batterybox.title"),
                    Component.translatable("roadmap.chemicalscience.node.batterybox.desc"),
                    null,
                    1,
                    List.of(rl("battery"), rl("coalgenerator"), rl("thermoelectricgenerator")),
                    colorWiretin,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("grinder"),
                    256, 0,
                    new ItemStack(ElectrodynamicsItems.ITEMS_MACHINE.getValue(SubtypeMachine.mineralgrinder)),
                    Component.translatable("roadmap.chemicalscience.node.grinder.title"),
                    Component.translatable("roadmap.chemicalscience.node.grinder.desc"),
                    null,
                    1,
                    List.of(rl("batterybox")),
                    colorWiretin,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("grinderdouble"),
                    256, 64,
                    new ItemStack(ElectrodynamicsItems.ITEMS_MACHINE.getValue(SubtypeMachine.mineralgrinderdouble)),
                    Component.translatable("roadmap.chemicalscience.node.grinderdouble.title"),
                    Component.translatable("roadmap.chemicalscience.node.grinderdouble.desc"),
                    null,
                    1,
                    List.of(rl("grinder")),
                    colorWiresilver,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("grindertriple"),
                    256, 128,
                    new ItemStack(ElectrodynamicsItems.ITEMS_MACHINE.getValue(SubtypeMachine.mineralgrindertriple)),
                    Component.translatable("roadmap.chemicalscience.node.grindertriple.title"),
                    Component.translatable("roadmap.chemicalscience.node.grindertriple.desc"),
                    null,
                    1,
                    List.of(rl("grinderdouble")),
                    colorWiregold,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("dustcopper"),
                    256, -64,
                    new ItemStack(ElectrodynamicsItems.ITEMS_DUST.getValue(SubtypeDust.copper)),
                    Component.translatable("roadmap.chemicalscience.node.dustcopper.title"),
                    Component.translatable("roadmap.chemicalscience.node.dustcopper.desc"),
                    null,
                    1,
                    List.of(rl("grinder")),
                    colorWiretin,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("thermoelectricgenerator"),
                    128, -64,
                    new ItemStack(ElectrodynamicsItems.ITEMS_MACHINE.getValue(SubtypeMachine.thermoelectricgenerator)),
                    Component.translatable("roadmap.chemicalscience.node.thermoelectricgenerator.title"),
                    Component.translatable("roadmap.chemicalscience.node.thermoelectricgenerator.desc"),
                    null,
                    1,
                    List.of(rl("platesteel")),
                    colorWiretin,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("upgradetransformer"),
                    320, 0,
                    new ItemStack(ElectrodynamicsItems.ITEMS_MACHINE.getValue(SubtypeMachine.upgradetransformer)),
                    Component.translatable("roadmap.chemicalscience.node.upgradetransformer.title"),
                    Component.translatable("roadmap.chemicalscience.node.upgradetransformer.desc"),
                    null,
                    1,
                    List.of(rl("grinder")),
                    colorWiretin,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("downgradetransformer"),
                    320, 64,
                    new ItemStack(ElectrodynamicsItems.ITEMS_MACHINE.getValue(SubtypeMachine.downgradetransformer)),
                    Component.translatable("roadmap.chemicalscience.node.downgradetransformer.title"),
                    Component.translatable("roadmap.chemicalscience.node.downgradetransformer.desc"),
                    null,
                    1,
                    List.of(rl("upgradetransformer")),
                    colorWiretin,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("crusher"),
                    384, 0,
                    new ItemStack(ElectrodynamicsItems.ITEMS_MACHINE.getValue(SubtypeMachine.mineralcrusher)),
                    Component.translatable("roadmap.chemicalscience.node.crusher.title"),
                    Component.translatable("roadmap.chemicalscience.node.crusher.desc"),
                    null,
                    1,
                    List.of(rl("upgradetransformer")),
                    colorWirecopper,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("crusherdouble"),
                    384, 64,
                    new ItemStack(ElectrodynamicsItems.ITEMS_MACHINE.getValue(SubtypeMachine.mineralcrusherdouble)),
                    Component.translatable("roadmap.chemicalscience.node.crusherdouble.title"),
                    Component.translatable("roadmap.chemicalscience.node.crusherdouble.desc"),
                    null,
                    1,
                    List.of(rl("crusher")),
                    colorWiregold,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("crushertriple"),
                    384, 128,
                    new ItemStack(ElectrodynamicsItems.ITEMS_MACHINE.getValue(SubtypeMachine.mineralcrushertriple)),
                    Component.translatable("roadmap.chemicalscience.node.crushertriple.title"),
                    Component.translatable("roadmap.chemicalscience.node.crushertriple.desc"),
                    null,
                    1,
                    List.of(rl("crusherdouble")),
                    colorWiresuperconductive,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("impuredustcopper"),
                    384, -64,
                    new ItemStack(ElectrodynamicsItems.ITEMS_IMPUREDUST.getValue(SubtypeImpureDust.copper)),
                    Component.translatable("roadmap.chemicalscience.node.impuredustcopper.title"),
                    Component.translatable("roadmap.chemicalscience.node.impuredustcopper.desc"),
                    null,
                    1,
                    List.of(rl("crusher")),
                    colorWirecopper,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("furnace"),
                    448, 0,
                    new ItemStack(ElectrodynamicsItems.ITEMS_MACHINE.getValue(SubtypeMachine.electricfurnace)),
                    Component.translatable("roadmap.chemicalscience.node.furnace.title"),
                    Component.translatable("roadmap.chemicalscience.node.furnace.desc"),
                    null,
                    1,
                    List.of(rl("crusher")),
                    colorWirecopper,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("furnacedouble"),
                    448, 64,
                    new ItemStack(ElectrodynamicsItems.ITEMS_MACHINE.getValue(SubtypeMachine.electricfurnacedouble)),
                    Component.translatable("roadmap.chemicalscience.node.furnacedouble.title"),
                    Component.translatable("roadmap.chemicalscience.node.furnacedouble.desc"),
                    null,
                    1,
                    List.of(rl("furnace")),
                    colorWiresilver,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("furnacetriple"),
                    448, 128,
                    new ItemStack(ElectrodynamicsItems.ITEMS_MACHINE.getValue(SubtypeMachine.electricarcfurnacetriple)),
                    Component.translatable("roadmap.chemicalscience.node.furnacetriple.title"),
                    Component.translatable("roadmap.chemicalscience.node.furnacetriple.desc"),
                    null,
                    1,
                    List.of(rl("furnacedouble")),
                    colorWiregold,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("arcfurnace"),
                    512, 0,
                    new ItemStack(ElectrodynamicsItems.ITEMS_MACHINE.getValue(SubtypeMachine.electricarcfurnace)),
                    Component.translatable("roadmap.chemicalscience.node.arcfurnace.title"),
                    Component.translatable("roadmap.chemicalscience.node.arcfurnace.desc"),
                    null,
                    1,
                    List.of(rl("furnace")),
                    colorWirecopper,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("arcfurnacedouble"),
                    512, 64,
                    new ItemStack(ElectrodynamicsItems.ITEMS_MACHINE.getValue(SubtypeMachine.electricarcfurnacedouble)),
                    Component.translatable("roadmap.chemicalscience.node.arcfurnacedouble.title"),
                    Component.translatable("roadmap.chemicalscience.node.arcfurnacedouble.desc"),
                    null,
                    1,
                    List.of(rl("arcfurnace")),
                    colorWiresilver,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("arcfurnacetriple"),
                    512, 128,
                    new ItemStack(ElectrodynamicsItems.ITEMS_MACHINE.getValue(SubtypeMachine.electricarcfurnacetriple)),
                    Component.translatable("roadmap.chemicalscience.node.arcfurnacetriple.title"),
                    Component.translatable("roadmap.chemicalscience.node.arcfurnacetriple.desc"),
                    null,
                    1,
                    List.of(rl("arcfurnacedouble")),
                    colorWiregold,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("wiremill"),
                    576, 0,
                    new ItemStack(ElectrodynamicsItems.ITEMS_MACHINE.getValue(SubtypeMachine.wiremill)),
                    Component.translatable("roadmap.chemicalscience.node.wiremill.title"),
                    Component.translatable("roadmap.chemicalscience.node.wiremill.desc"),
                    null,
                    1,
                    List.of(rl("arcfurnace")),
                    colorWirecopper,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("wiremilldouble"),
                    576, 64,
                    new ItemStack(ElectrodynamicsItems.ITEMS_MACHINE.getValue(SubtypeMachine.wiremilldouble)),
                    Component.translatable("roadmap.chemicalscience.node.wiremilldouble.title"),
                    Component.translatable("roadmap.chemicalscience.node.wiremilldouble.desc"),
                    null,
                    1,
                    List.of(rl("wiremill")),
                    colorWiresilver,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("wiremilltriple"),
                    576, 128,
                    new ItemStack(ElectrodynamicsItems.ITEMS_MACHINE.getValue(SubtypeMachine.wiremilltriple)),
                    Component.translatable("roadmap.chemicalscience.node.wiremilltriple.title"),
                    Component.translatable("roadmap.chemicalscience.node.wiremilltriple.desc"),
                    null,
                    1,
                    List.of(rl("wiremilldouble")),
                    colorWiregold,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("oxidationfurnace"),
                    640, 0,
                    new ItemStack(ElectrodynamicsItems.ITEMS_MACHINE.getValue(SubtypeMachine.oxidationfurnace)),
                    Component.translatable("roadmap.chemicalscience.node.oxidationfurnace.title"),
                    Component.translatable("roadmap.chemicalscience.node.oxidationfurnace.desc"),
                    null,
                    1,
                    List.of(rl("wiremill")),
                    colorWirecopper,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("alloyer"),
                    704, 0,
                    new ItemStack(ElectrodynamicsItems.ITEMS_MACHINE.getValue(SubtypeMachine.energizedalloyer)),
                    Component.translatable("roadmap.chemicalscience.node.alloyer.title"),
                    Component.translatable("roadmap.chemicalscience.node.alloyer.desc"),
                    null,
                    1,
                    List.of(rl("oxidationfurnace")),
                    colorWirecopper,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("lithiumbattery"),
                    768, 0,
                    new ItemStack(ElectrodynamicsItems.ITEM_LITHIUMBATTERY),
                    Component.translatable("roadmap.chemicalscience.node.lithiumbattery.title"),
                    Component.translatable("roadmap.chemicalscience.node.lithiumbattery.desc"),
                    null,
                    1,
                    List.of(rl("alloyer")),
                    colorWirecopper,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("lithiumbatterybox"),
                    832, 0,
                    new ItemStack(ElectrodynamicsItems.ITEMS_MACHINE.getValue(SubtypeMachine.lithiumbatterybox)),
                    Component.translatable("roadmap.chemicalscience.node.lithiumbatterybox.title"),
                    Component.translatable("roadmap.chemicalscience.node.lithiumbatterybox.desc"),
                    null,
                    1,
                    List.of(rl("lithiumbattery")),
                    colorWirecopper,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("chemicalbench"),
                    896, 0,
                    new ItemStack(CSBlocks.CHEMICAL_BENCH),
                    Component.translatable("roadmap.chemicalscience.node.chemicalbench.title"),
                    Component.translatable("roadmap.chemicalscience.node.chemicalbench.desc"),
                    null,
                    1,
                    List.of(rl("lithiumbatterybox")),
                    colorWirecopper,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    new MultiblockVisualizer()
                            .addBlock(0, 0, 0, CSBlocks.CHEMICAL_BENCH.get().defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH))
                            .addBlock(-1, 0, 0, CSBlocks.LABORATORY_STORAGE.get().defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH))
                            .addBlock(-1, 0, -1, CSBlocks.LABORATORY_SINK.get().defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH))
                            .addBlock(0, 0, -1, CSBlocks.LABORATORY_SINK.get().defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH))
                            .addBlock(0, 1, -1, CSBlocks.LABORATORY_SUPPORT.get().defaultBlockState())
                            .addBlock(-1, 1, -1, CSBlocks.LABORATORY_SUPPORT.get().defaultBlockState())
                            .addBlock(-1, 1, 0, CSBlocks.LABORATORY_SUPPORT.get().defaultBlockState())
                            .addBlock(0, 1, 0, CSBlocks.LABORATORY_SUPPORT.get().defaultBlockState())
                            .addBlock(0, 2, 0, ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.gasvent).defaultBlockState())
                            .addBlock(-1, 2, 0, ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.gasvent).defaultBlockState())
                            .addBlock(-1, 2, -1, ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.gasvent).defaultBlockState())
                            .addBlock(0, 2, -1, ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.gasvent).defaultBlockState())
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("redoxfurnace"),
                    896, -64,
                    new ItemStack(CSBlocks.REDOX_FURNACE),
                    Component.translatable("roadmap.chemicalscience.node.redoxfurnace.title"),
                    Component.translatable("roadmap.chemicalscience.node.redoxfurnace.desc"),
                    null,
                    1,
                    List.of(rl("chemicalbench")),
                    colorWirecopper,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    new MultiblockVisualizer()
                            .addBlock(0, 0, 0, CSBlocks.REDOX_FURNACE.get().defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH))
                            .addBlock(-1, 0, 0, ElectrodynamicsBlocks.BLOCK_STEELSCAFFOLDING.get().defaultBlockState())
                            .addBlock(-1, 0, -1, ElectrodynamicsBlocks.BLOCKS_RESOURCE.getValue(SubtypeResourceBlock.steel).defaultBlockState())
                            .addBlock(0, 0, -1, ElectrodynamicsBlocks.BLOCKS_RESOURCE.getValue(SubtypeResourceBlock.steel).defaultBlockState())
                            .addBlock(-1, 1, -1, CSBlocks.TUNGSTEN_BLOCK.get().defaultBlockState())
                            .addBlock(0, 1, 0, ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.oxidationfurnace).defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH))
                            .addBlock(-1, 2, -1, ElectrodynamicsBlocks.BLOCK_STEELSCAFFOLDING.get().defaultBlockState())
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("fractionatingcolumn"),
                    896, 64,
                    new ItemStack(CSBlocks.FRACTIONATING_COLUMN),
                    Component.translatable("roadmap.chemicalscience.node.fractionatingcolumn.title"),
                    Component.translatable("roadmap.chemicalscience.node.fractionatingcolumn.desc"),
                    null,
                    1,
                    List.of(rl("chemicalbench")),
                    colorWirecopper,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    new MultiblockVisualizer()
                            .addBlock(0, -1, 0, ElectrodynamicsBlocks.BLOCK_STEELSCAFFOLDING.get().defaultBlockState())
                            .addBlock(1, -1, 0, ElectrodynamicsBlocks.BLOCK_STEELSCAFFOLDING.get().defaultBlockState())
                            .addBlock(-1, -1, 0, ElectrodynamicsBlocks.BLOCK_STEELSCAFFOLDING.get().defaultBlockState())
                            .addBlock(1, -1, -1, ElectrodynamicsBlocks.BLOCK_STEELSCAFFOLDING.get().defaultBlockState())
                            .addBlock(-1, -1, -1, ElectrodynamicsBlocks.BLOCK_STEELSCAFFOLDING.get().defaultBlockState())
                            .addBlock(1, -1, -2, ElectrodynamicsBlocks.BLOCK_STEELSCAFFOLDING.get().defaultBlockState())
                            .addBlock(-1, -1, -2, ElectrodynamicsBlocks.BLOCK_STEELSCAFFOLDING.get().defaultBlockState())
                            .addBlock(0, -1, -1, ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.electricarcfurnace).defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH))
                            .addBlock(0, -1, -2, Blocks.GOLD_BLOCK.defaultBlockState())

                            .addBlock(0, 0, 0, CSBlocks.FRACTIONATING_COLUMN.get().defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH))
                            .addBlock(1, 0, 0, Blocks.IRON_BLOCK.defaultBlockState())
                            .addBlock(-1, 0, 0, Blocks.IRON_BLOCK.defaultBlockState())
                            .addBlock(1, 0, -1, Blocks.IRON_BLOCK.defaultBlockState())
                            .addBlock(-1, 0, -1, ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.tanksteel).defaultBlockState())
                            .addBlock(1, 0, -2, Blocks.IRON_BLOCK.defaultBlockState())
                            .addBlock(-1, 0, -2, Blocks.IRON_BLOCK.defaultBlockState())
                            .addBlock(0, 0, -1, Blocks.IRON_BLOCK.defaultBlockState())
                            .addBlock(0, 0, -2, Blocks.IRON_BLOCK.defaultBlockState())

                            .addBlock(0, 1, 0, CSBlocks.GRATE_STEEL.get().defaultBlockState())
                            .addBlock(1, 1, 0, CSBlocks.GRATE_STEEL.get().defaultBlockState())
                            .addBlock(-1, 1, 0, CSBlocks.GRATE_STEEL.get().defaultBlockState())
                            .addBlock(1, 1, -1, CSBlocks.GRATE_STEEL.get().defaultBlockState())
                            .addBlock(-1, 1, -1, CSBlocks.GRATE_STEEL.get().defaultBlockState())
                            .addBlock(1, 1, -2, CSBlocks.GRATE_STEEL.get().defaultBlockState())
                            .addBlock(-1, 1, -2, CSBlocks.GRATE_STEEL.get().defaultBlockState())
                            .addBlock(0, 1, -1, CSBlocks.GRATE_STEEL.get().defaultBlockState())
                            .addBlock(0, 1, -2, CSBlocks.GRATE_STEEL.get().defaultBlockState())

                            .addBlock(0, 2, 0, ElectrodynamicsBlocks.BLOCK_COMPRESSOR.get().defaultBlockState())
                            .addBlock(1, 2, 0, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
                            .addBlock(-1, 2, 0, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
                            .addBlock(1, 2, -1, ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.tanksteel).defaultBlockState())
                            .addBlock(-1, 2, -1, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
                            .addBlock(1, 2, -2, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
                            .addBlock(-1, 2, -2, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
                            .addBlock(0, 2, -1, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
                            .addBlock(0, 2, -2, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())

                            .addBlock(0, 3, 0, CSBlocks.GRATE_STEEL.get().defaultBlockState()).addBlock(1, 3, 0, CSBlocks.GRATE_STEEL.get().defaultBlockState()).addBlock(-1, 3, 0, CSBlocks.GRATE_STEEL.get().defaultBlockState()).addBlock(1, 3, -1, CSBlocks.GRATE_STEEL.get().defaultBlockState()).addBlock(-1, 3, -1, CSBlocks.GRATE_STEEL.get().defaultBlockState()).addBlock(1, 3, -2, CSBlocks.GRATE_STEEL.get().defaultBlockState()).addBlock(-1, 3, -2, CSBlocks.GRATE_STEEL.get().defaultBlockState()).addBlock(0, 3, -1, CSBlocks.GRATE_STEEL.get().defaultBlockState()).addBlock(0, 3, -2, CSBlocks.GRATE_STEEL.get().defaultBlockState())
                            .addBlock(0, 5, 0, CSBlocks.GRATE_STEEL.get().defaultBlockState()).addBlock(1, 5, 0, CSBlocks.GRATE_STEEL.get().defaultBlockState()).addBlock(-1, 5, 0, CSBlocks.GRATE_STEEL.get().defaultBlockState()).addBlock(1, 5, -1, CSBlocks.GRATE_STEEL.get().defaultBlockState()).addBlock(-1, 5, -1, CSBlocks.GRATE_STEEL.get().defaultBlockState()).addBlock(1, 5, -2, CSBlocks.GRATE_STEEL.get().defaultBlockState()).addBlock(-1, 5, -2, CSBlocks.GRATE_STEEL.get().defaultBlockState()).addBlock(0, 5, -1, CSBlocks.GRATE_STEEL.get().defaultBlockState()).addBlock(0, 5, -2, CSBlocks.GRATE_STEEL.get().defaultBlockState())
                            .addBlock(0, 7, 0, CSBlocks.GRATE_STEEL.get().defaultBlockState()).addBlock(1, 7, 0, CSBlocks.GRATE_STEEL.get().defaultBlockState()).addBlock(-1, 7, 0, CSBlocks.GRATE_STEEL.get().defaultBlockState()).addBlock(1, 7, -1, CSBlocks.GRATE_STEEL.get().defaultBlockState()).addBlock(-1, 7, -1, CSBlocks.GRATE_STEEL.get().defaultBlockState()).addBlock(1, 7, -2, CSBlocks.GRATE_STEEL.get().defaultBlockState()).addBlock(-1, 7, -2, CSBlocks.GRATE_STEEL.get().defaultBlockState()).addBlock(0, 7, -1, CSBlocks.GRATE_STEEL.get().defaultBlockState()).addBlock(0, 7, -2, CSBlocks.GRATE_STEEL.get().defaultBlockState())
                            .addBlock(0, 9, 0, CSBlocks.GRATE_STEEL.get().defaultBlockState()).addBlock(1, 9, 0, CSBlocks.GRATE_STEEL.get().defaultBlockState()).addBlock(-1, 9, 0, CSBlocks.GRATE_STEEL.get().defaultBlockState()).addBlock(1, 9, -1, CSBlocks.GRATE_STEEL.get().defaultBlockState()).addBlock(-1, 9, -1, CSBlocks.GRATE_STEEL.get().defaultBlockState()).addBlock(1, 9, -2, CSBlocks.GRATE_STEEL.get().defaultBlockState()).addBlock(-1, 9, -2, CSBlocks.GRATE_STEEL.get().defaultBlockState()).addBlock(0, 9, -1, CSBlocks.GRATE_STEEL.get().defaultBlockState()).addBlock(0, 9, -2, CSBlocks.GRATE_STEEL.get().defaultBlockState())

                            .addBlock(0, 4, 0, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState()).addBlock(1, 4, 0, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState()).addBlock(-1, 4, 0, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState()).addBlock(1, 4, -1, ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.tanksteel).defaultBlockState()).addBlock(-1, 4, -1, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState()).addBlock(1, 4, -2, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState()).addBlock(-1, 4, -2, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState()).addBlock(0, 4, -1, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState()).addBlock(0, 4, -2, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
                            .addBlock(0, 6, 0, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState()).addBlock(1, 6, 0, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState()).addBlock(-1, 6, 0, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState()).addBlock(1, 6, -1, ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.tanksteel).defaultBlockState()).addBlock(-1, 6, -1, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState()).addBlock(1, 6, -2, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState()).addBlock(-1, 6, -2, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState()).addBlock(0, 6, -1, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState()).addBlock(0, 6, -2, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
                            .addBlock(0, 8, 0, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState()).addBlock(1, 8, 0, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState()).addBlock(-1, 8, 0, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState()).addBlock(1, 8, -1, ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.tanksteel).defaultBlockState()).addBlock(-1, 8, -1, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState()).addBlock(1, 8, -2, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState()).addBlock(-1, 8, -2, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState()).addBlock(0, 8, -1, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState()).addBlock(0, 8, -2, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())

                            .addBlock(0, 10, 0, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
                            .addBlock(1, 10, 0, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
                            .addBlock(-1, 10, 0, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
                            .addBlock(1, 10, -1, ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.gastanksteel).defaultBlockState())
                            .addBlock(-1, 10, -1, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
                            .addBlock(1, 10, -2, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
                            .addBlock(-1, 10, -2, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
                            .addBlock(0, 10, -1, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
                            .addBlock(0, 10, -2, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())

                            .addBlock(0, 11, 0, ElectrodynamicsBlocks.BLOCK_STEELSCAFFOLDING.get().defaultBlockState())
                            .addBlock(1, 11, 0, ElectrodynamicsBlocks.BLOCK_STEELSCAFFOLDING.get().defaultBlockState())
                            .addBlock(-1, 11, 0, ElectrodynamicsBlocks.BLOCK_STEELSCAFFOLDING.get().defaultBlockState())
                            .addBlock(1, 11, -1, ElectrodynamicsBlocks.BLOCK_STEELSCAFFOLDING.get().defaultBlockState())
                            .addBlock(-1, 11, -1, ElectrodynamicsBlocks.BLOCK_STEELSCAFFOLDING.get().defaultBlockState())
                            .addBlock(1, 11, -2, ElectrodynamicsBlocks.BLOCK_STEELSCAFFOLDING.get().defaultBlockState())
                            .addBlock(-1, 11, -2, ElectrodynamicsBlocks.BLOCK_STEELSCAFFOLDING.get().defaultBlockState())
                            .addBlock(0, 11, -1, ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.gasvent).defaultBlockState())
                            .addBlock(0, 11, -2, ElectrodynamicsBlocks.BLOCK_STEELSCAFFOLDING.get().defaultBlockState())
            ),

            new ScreenRoadMap.RoadmapNode(
                    rl("workinprogess"),
                    960, 0,
                    new ItemStack(VoltaicItems.ITEM_WRENCH),
                    Component.translatable("roadmap.chemicalscience.node.workinprogess.title").withStyle(ChatFormatting.GOLD),
                    Component.translatable("roadmap.chemicalscience.node.workinprogess.desc"),
                    null,
                    1,
                    List.of(rl("chemicalbench")),
                    colorWirecopper,
                    true,
                    96, -112, 16, 10, 8, 10, 48, 110,
                    null
            )
    );

    public static final Map<ResourceLocation, ScreenRoadMap.RoadmapNode> NODE_MAP = NODES.stream()
            .collect(Collectors.toMap(ScreenRoadMap.RoadmapNode::id, Function.identity()));

    private static ResourceLocation rl(String path) {
        return ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, path);
    }
}