package net.pastek.chemicalscience.client.guidebook.chapters;

import javax.annotation.Nullable;

import electrodynamics.common.block.subtype.SubtypeMachine;
import electrodynamics.common.block.subtype.SubtypeResourceBlock;
import electrodynamics.prefab.utilities.ElectroTextUtils;
import electrodynamics.registers.ElectrodynamicsBlocks;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.pastek.chemicalscience.client.guidebook.MultiblockWrapperObject;
import net.pastek.chemicalscience.client.roadmap.MultiblockVisualizer;
import net.pastek.chemicalscience.prefab.utils.CSTextUtils;
import net.pastek.chemicalscience.registers.CSBlocks;
import voltaic.client.guidebook.ScreenGuidebook;
import voltaic.client.guidebook.utils.components.Chapter;
import voltaic.client.guidebook.utils.components.Module;
import voltaic.client.guidebook.utils.pagedata.OnKeyPress;
import voltaic.client.guidebook.utils.pagedata.graphics.AbstractGraphicWrapper;
import voltaic.client.guidebook.utils.pagedata.graphics.ItemWrapperObject;
import voltaic.client.guidebook.utils.pagedata.text.TextWrapperObject;
import voltaic.compatibility.jei.JeiBuffer;

public class ChapterMachines extends Chapter {

    private static final ItemWrapperObject LOGO = new ItemWrapperObject(7, 10, 32, 32, 32, 2.0F,
	    CSBlocks.ORGANIC_SOLAR_PANEL.get().asItem());

    public ChapterMachines(Module module) {
	super(module);
    }

    @Override
    public ItemWrapperObject getLogo() {
	return LOGO;
    }

    @Override
    public MutableComponent getTitle() {
	return CSTextUtils.guidebook("chapter.machines");
    }

    @Override
    public void addData() {
	// Redox Furnace
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSBlocks.REDOX_FURNACE.get().asItem(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSBlocks.REDOX_FURNACE.get().asItem().getDescription().copy()
				.withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BOLD)
				.withStyle(ChatFormatting.DARK_PURPLE)))
		.onTooltip((graphics, xAxis, yAxis, screen) -> {
		    if (JeiBuffer.isJeiInstalled()) {
			graphics.renderTooltip(screen.getFontRenderer(),
				ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis,
				yAxis);
		    }
		}).onKeyPress(new OnKeyPress() {
		    @Override
		    public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis,
			    ScreenGuidebook screen) {
		    }

		    @Override
		    public @Nullable Object getJeiLookup() {
			return new ItemStack(CSBlocks.REDOX_FURNACE.get().asItem());
		    }
		}));
	pageData.add(new TextWrapperObject(CSTextUtils.guidebook("chapter.machines.redoxfurnace")).setIndentions(1));
	pageData.add(new MultiblockWrapperObject(95, 70, 64, 64, 80, 25.0F, new MultiblockVisualizer()
		.addBlock(0, 0, 0,
			CSBlocks.REDOX_FURNACE.get().defaultBlockState()
				.setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH))
		.addBlock(-1, 0, 0, ElectrodynamicsBlocks.BLOCK_STEELSCAFFOLDING.get().defaultBlockState())
		.addBlock(-1, 0, -1,
			ElectrodynamicsBlocks.BLOCKS_RESOURCE.getValue(SubtypeResourceBlock.steel).defaultBlockState())
		.addBlock(0, 0, -1,
			ElectrodynamicsBlocks.BLOCKS_RESOURCE.getValue(SubtypeResourceBlock.steel).defaultBlockState())
		.addBlock(-1, 1, -1, CSBlocks.TUNGSTEN_BLOCK.get().defaultBlockState())
		.addBlock(0, 1, 0,
			ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.oxidationfurnace)
				.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH))
		.addBlock(-1, 2, -1, ElectrodynamicsBlocks.BLOCK_STEELSCAFFOLDING.get().defaultBlockState()))
		.addRequiredItem(CSBlocks.REDOX_FURNACE.get(), 1)
		.addRequiredItem(ElectrodynamicsBlocks.BLOCK_STEELSCAFFOLDING.get(), 2)
		.addRequiredItem(ElectrodynamicsBlocks.BLOCKS_RESOURCE.getValue(SubtypeResourceBlock.steel), 2)
		.addRequiredItem(CSBlocks.TUNGSTEN_BLOCK.get(), 1)
		.addRequiredItem(ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.oxidationfurnace), 1)
		.setNewPage());

	// Fractionating Column
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSBlocks.FRACTIONATING_COLUMN.get().asItem(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSBlocks.FRACTIONATING_COLUMN.get().asItem().getDescription().copy()
				.withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BOLD)
				.withStyle(ChatFormatting.DARK_PURPLE)))
		.setNewPage().onTooltip((graphics, xAxis, yAxis, screen) -> {
		    if (JeiBuffer.isJeiInstalled()) {
			graphics.renderTooltip(screen.getFontRenderer(),
				ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis,
				yAxis);
		    }
		}).onKeyPress(new OnKeyPress() {
		    @Override
		    public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis,
			    ScreenGuidebook screen) {
		    }

		    @Override
		    public @Nullable Object getJeiLookup() {
			return new ItemStack(CSBlocks.FRACTIONATING_COLUMN.get().asItem());
		    }
		}));
	pageData.add(
		new TextWrapperObject(CSTextUtils.guidebook("chapter.machines.fractionatingcolumn")).setIndentions(1));
	pageData.add(new MultiblockWrapperObject(75, 75, 64, 64, 150, 12.0F, new MultiblockVisualizer()
		// Layer 0 - Power Input
		.addBlock(0, -1, 0, ElectrodynamicsBlocks.BLOCK_STEELSCAFFOLDING.get().defaultBlockState())
		.addBlock(1, -1, 0, ElectrodynamicsBlocks.BLOCK_STEELSCAFFOLDING.get().defaultBlockState())
		.addBlock(-1, -1, 0, ElectrodynamicsBlocks.BLOCK_STEELSCAFFOLDING.get().defaultBlockState())
		.addBlock(1, -1, -1, ElectrodynamicsBlocks.BLOCK_STEELSCAFFOLDING.get().defaultBlockState())
		.addBlock(-1, -1, -1, ElectrodynamicsBlocks.BLOCK_STEELSCAFFOLDING.get().defaultBlockState())
		.addBlock(1, -1, -2, ElectrodynamicsBlocks.BLOCK_STEELSCAFFOLDING.get().defaultBlockState())
		.addBlock(-1, -1, -2, ElectrodynamicsBlocks.BLOCK_STEELSCAFFOLDING.get().defaultBlockState())
		.addBlock(0, -1, -1,
			ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.electricarcfurnace)
				.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH))
		.addBlock(0, -1, -2, Blocks.GOLD_BLOCK.defaultBlockState())

		.addBlock(0, 0, 0,
			CSBlocks.FRACTIONATING_COLUMN.get().defaultBlockState()
				.setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH))
		.addBlock(1, 0, 0, Blocks.IRON_BLOCK.defaultBlockState())
		.addBlock(-1, 0, 0, Blocks.IRON_BLOCK.defaultBlockState())
		.addBlock(1, 0, -1, Blocks.IRON_BLOCK.defaultBlockState())
		.addBlock(-1, 0, -1,
			ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.tanksteel).defaultBlockState())
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
		.addBlock(1, 2, -1,
			ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.tanksteel).defaultBlockState())
		.addBlock(-1, 2, -1, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
		.addBlock(1, 2, -2, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
		.addBlock(-1, 2, -2, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
		.addBlock(0, 2, -1, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
		.addBlock(0, 2, -2, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())

		.addBlock(0, 3, 0, CSBlocks.GRATE_STEEL.get().defaultBlockState())
		.addBlock(1, 3, 0, CSBlocks.GRATE_STEEL.get().defaultBlockState())
		.addBlock(-1, 3, 0, CSBlocks.GRATE_STEEL.get().defaultBlockState())
		.addBlock(1, 3, -1, CSBlocks.GRATE_STEEL.get().defaultBlockState())
		.addBlock(-1, 3, -1, CSBlocks.GRATE_STEEL.get().defaultBlockState())
		.addBlock(1, 3, -2, CSBlocks.GRATE_STEEL.get().defaultBlockState())
		.addBlock(-1, 3, -2, CSBlocks.GRATE_STEEL.get().defaultBlockState())
		.addBlock(0, 3, -1, CSBlocks.GRATE_STEEL.get().defaultBlockState())
		.addBlock(0, 3, -2, CSBlocks.GRATE_STEEL.get().defaultBlockState())
		.addBlock(0, 5, 0, CSBlocks.GRATE_STEEL.get().defaultBlockState())
		.addBlock(1, 5, 0, CSBlocks.GRATE_STEEL.get().defaultBlockState())
		.addBlock(-1, 5, 0, CSBlocks.GRATE_STEEL.get().defaultBlockState())
		.addBlock(1, 5, -1, CSBlocks.GRATE_STEEL.get().defaultBlockState())
		.addBlock(-1, 5, -1, CSBlocks.GRATE_STEEL.get().defaultBlockState())
		.addBlock(1, 5, -2, CSBlocks.GRATE_STEEL.get().defaultBlockState())
		.addBlock(-1, 5, -2, CSBlocks.GRATE_STEEL.get().defaultBlockState())
		.addBlock(0, 5, -1, CSBlocks.GRATE_STEEL.get().defaultBlockState())
		.addBlock(0, 5, -2, CSBlocks.GRATE_STEEL.get().defaultBlockState())
		.addBlock(0, 7, 0, CSBlocks.GRATE_STEEL.get().defaultBlockState())
		.addBlock(1, 7, 0, CSBlocks.GRATE_STEEL.get().defaultBlockState())
		.addBlock(-1, 7, 0, CSBlocks.GRATE_STEEL.get().defaultBlockState())
		.addBlock(1, 7, -1, CSBlocks.GRATE_STEEL.get().defaultBlockState())
		.addBlock(-1, 7, -1, CSBlocks.GRATE_STEEL.get().defaultBlockState())
		.addBlock(1, 7, -2, CSBlocks.GRATE_STEEL.get().defaultBlockState())
		.addBlock(-1, 7, -2, CSBlocks.GRATE_STEEL.get().defaultBlockState())
		.addBlock(0, 7, -1, CSBlocks.GRATE_STEEL.get().defaultBlockState())
		.addBlock(0, 7, -2, CSBlocks.GRATE_STEEL.get().defaultBlockState())
		.addBlock(0, 9, 0, CSBlocks.GRATE_STEEL.get().defaultBlockState())
		.addBlock(1, 9, 0, CSBlocks.GRATE_STEEL.get().defaultBlockState())
		.addBlock(-1, 9, 0, CSBlocks.GRATE_STEEL.get().defaultBlockState())
		.addBlock(1, 9, -1, CSBlocks.GRATE_STEEL.get().defaultBlockState())
		.addBlock(-1, 9, -1, CSBlocks.GRATE_STEEL.get().defaultBlockState())
		.addBlock(1, 9, -2, CSBlocks.GRATE_STEEL.get().defaultBlockState())
		.addBlock(-1, 9, -2, CSBlocks.GRATE_STEEL.get().defaultBlockState())
		.addBlock(0, 9, -1, CSBlocks.GRATE_STEEL.get().defaultBlockState())
		.addBlock(0, 9, -2, CSBlocks.GRATE_STEEL.get().defaultBlockState())

		.addBlock(0, 4, 0, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
		.addBlock(1, 4, 0, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
		.addBlock(-1, 4, 0, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
		.addBlock(1, 4, -1,
			ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.tanksteel).defaultBlockState())
		.addBlock(-1, 4, -1, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
		.addBlock(1, 4, -2, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
		.addBlock(-1, 4, -2, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
		.addBlock(0, 4, -1, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
		.addBlock(0, 4, -2, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
		.addBlock(0, 6, 0, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
		.addBlock(1, 6, 0, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
		.addBlock(-1, 6, 0, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
		.addBlock(1, 6, -1,
			ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.tanksteel).defaultBlockState())
		.addBlock(-1, 6, -1, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
		.addBlock(1, 6, -2, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
		.addBlock(-1, 6, -2, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
		.addBlock(0, 6, -1, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
		.addBlock(0, 6, -2, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
		.addBlock(0, 8, 0, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
		.addBlock(1, 8, 0, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
		.addBlock(-1, 8, 0, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
		.addBlock(1, 8, -1,
			ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.tanksteel).defaultBlockState())
		.addBlock(-1, 8, -1, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
		.addBlock(1, 8, -2, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
		.addBlock(-1, 8, -2, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
		.addBlock(0, 8, -1, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
		.addBlock(0, 8, -2, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())

		.addBlock(0, 10, 0, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
		.addBlock(1, 10, 0, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
		.addBlock(-1, 10, 0, CSBlocks.SCAFFOLDING_MANGANESE.get().defaultBlockState())
		.addBlock(1, 10, -1,
			ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.gastanksteel).defaultBlockState())
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
		.addBlock(0, 11, -1,
			ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.gasvent).defaultBlockState())
		.addBlock(0, 11, -2, ElectrodynamicsBlocks.BLOCK_STEELSCAFFOLDING.get().defaultBlockState()))
		.addRequiredItem(CSBlocks.FRACTIONATING_COLUMN.get(), 1)
		.addRequiredItem(ElectrodynamicsBlocks.BLOCK_STEELSCAFFOLDING.get(), 15)
		.addRequiredItem(CSBlocks.SCAFFOLDING_MANGANESE.get(), 39).addRequiredItem(Blocks.IRON_BLOCK, 7)
		.addRequiredItem(CSBlocks.GRATE_STEEL.get(), 45).addRequiredItem(Blocks.GOLD_BLOCK, 1)
		.addRequiredItem(ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.electricarcfurnace), 1)
		.addRequiredItem(ElectrodynamicsBlocks.BLOCK_COMPRESSOR.get(), 1)
		.addRequiredItem(ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.tanksteel), 5)
		.addRequiredItem(ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.gastanksteel), 1)
		.addRequiredItem(ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.gasvent), 1)
		.setNewPage());

	// HDS Unit
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSBlocks.HDS_UNIT.get().asItem(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSBlocks.HDS_UNIT.get().asItem().getDescription().copy().withStyle(ChatFormatting.UNDERLINE)
				.withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_PURPLE)))
		.onTooltip((graphics, xAxis, yAxis, screen) -> {
		    if (JeiBuffer.isJeiInstalled()) {
			graphics.renderTooltip(screen.getFontRenderer(),
				ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis,
				yAxis);
		    }
		}).onKeyPress(new OnKeyPress() {
		    @Override
		    public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis,
			    ScreenGuidebook screen) {
		    }

		    @Override
		    public @Nullable Object getJeiLookup() {
			return new ItemStack(CSBlocks.HDS_UNIT.get().asItem());
		    }
		}));
	pageData.add(new TextWrapperObject(CSTextUtils.guidebook("chapter.machines.hdsunit")).setIndentions(1));

	// Catalytic reformer
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSBlocks.CATALYTIC_REFORMER.get().asItem(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSBlocks.CATALYTIC_REFORMER.get().asItem().getDescription().copy()
				.withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BOLD)
				.withStyle(ChatFormatting.DARK_PURPLE)))
		.setNewPage().onTooltip((graphics, xAxis, yAxis, screen) -> {
		    if (JeiBuffer.isJeiInstalled()) {
			graphics.renderTooltip(screen.getFontRenderer(),
				ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis,
				yAxis);
		    }
		}).onKeyPress(new OnKeyPress() {
		    @Override
		    public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis,
			    ScreenGuidebook screen) {
		    }

		    @Override
		    public @Nullable Object getJeiLookup() {
			return new ItemStack(CSBlocks.CATALYTIC_REFORMER.get().asItem());
		    }
		}));
	pageData.add(
		new TextWrapperObject(CSTextUtils.guidebook("chapter.machines.catalyticreformer")).setIndentions(1));

	// Steam Cracker
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSBlocks.STEAM_CRACKER.get().asItem(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSBlocks.STEAM_CRACKER.get().asItem().getDescription().copy()
				.withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BOLD)
				.withStyle(ChatFormatting.DARK_PURPLE)))
		.setNewPage().onTooltip((graphics, xAxis, yAxis, screen) -> {
		    if (JeiBuffer.isJeiInstalled()) {
			graphics.renderTooltip(screen.getFontRenderer(),
				ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis,
				yAxis);
		    }
		}).onKeyPress(new OnKeyPress() {
		    @Override
		    public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis,
			    ScreenGuidebook screen) {
		    }

		    @Override
		    public @Nullable Object getJeiLookup() {
			return new ItemStack(CSBlocks.STEAM_CRACKER.get().asItem());
		    }
		}));
	pageData.add(new TextWrapperObject(CSTextUtils.guidebook("chapter.machines.steamcracker")).setIndentions(1));

	// Organic Solar Panel
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSBlocks.ORGANIC_SOLAR_PANEL.get().asItem(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSBlocks.ORGANIC_SOLAR_PANEL.get().asItem().getDescription().copy()
				.withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BOLD)
				.withStyle(ChatFormatting.DARK_PURPLE)))
		.setNewPage().onTooltip((graphics, xAxis, yAxis, screen) -> {
		    if (JeiBuffer.isJeiInstalled()) {
			graphics.renderTooltip(screen.getFontRenderer(),
				ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis,
				yAxis);
		    }
		}).onKeyPress(new OnKeyPress() {
		    @Override
		    public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis,
			    ScreenGuidebook screen) {
		    }

		    @Override
		    public @Nullable Object getJeiLookup() {
			return new ItemStack(CSBlocks.ORGANIC_SOLAR_PANEL.get().asItem());
		    }
		}));
	pageData.add(
		new TextWrapperObject(CSTextUtils.guidebook("chapter.machines.organicsolarpanel")).setIndentions(1));

	// Chemical Bench
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSBlocks.CHEMICAL_BENCH.get().asItem(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSBlocks.CHEMICAL_BENCH.get().asItem().getDescription().copy()
				.withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BOLD)
				.withStyle(ChatFormatting.DARK_PURPLE)))
		.setNewPage().onTooltip((graphics, xAxis, yAxis, screen) -> {
		    if (JeiBuffer.isJeiInstalled()) {
			graphics.renderTooltip(screen.getFontRenderer(),
				ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis,
				yAxis);
		    }
		}).onKeyPress(new OnKeyPress() {
		    @Override
		    public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis,
			    ScreenGuidebook screen) {
		    }

		    @Override
		    public @Nullable Object getJeiLookup() {
			return new ItemStack(CSBlocks.CHEMICAL_BENCH.get().asItem());
		    }
		}));
	pageData.add(new TextWrapperObject(CSTextUtils.guidebook("chapter.machines.chemicalbench")).setIndentions(1));
	pageData.add(new MultiblockWrapperObject(95, 70, 64, 64, 80, 25.0F, new MultiblockVisualizer()
		.addBlock(0, 0, 0,
			CSBlocks.CHEMICAL_BENCH.get().defaultBlockState()
				.setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH))
		.addBlock(-1, 0, 0,
			CSBlocks.LABORATORY_STORAGE.get().defaultBlockState()
				.setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH))
		.addBlock(-1, 0, -1,
			CSBlocks.LABORATORY_SINK.get().defaultBlockState()
				.setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH))
		.addBlock(0, 0, -1,
			CSBlocks.LABORATORY_SINK.get().defaultBlockState()
				.setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH))
		.addBlock(0, 1, -1, CSBlocks.LABORATORY_SUPPORT.get().defaultBlockState())
		.addBlock(-1, 1, -1, CSBlocks.LABORATORY_SUPPORT.get().defaultBlockState())
		.addBlock(-1, 1, 0, CSBlocks.LABORATORY_SUPPORT.get().defaultBlockState())
		.addBlock(0, 1, 0, CSBlocks.LABORATORY_SUPPORT.get().defaultBlockState())
		.addBlock(0, 2, 0,
			ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.gasvent).defaultBlockState())
		.addBlock(-1, 2, 0,
			ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.gasvent).defaultBlockState())
		.addBlock(-1, 2, -1,
			ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.gasvent).defaultBlockState())
		.addBlock(0, 2, -1,
			ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.gasvent).defaultBlockState()))
		.addRequiredItem(CSBlocks.CHEMICAL_BENCH.get(), 1).addRequiredItem(CSBlocks.LABORATORY_STORAGE.get(), 1)
		.addRequiredItem(CSBlocks.LABORATORY_SINK.get(), 2)
		.addRequiredItem(CSBlocks.LABORATORY_SUPPORT.get(), 4)
		.addRequiredItem(ElectrodynamicsBlocks.BLOCKS_MACHINE.getValue(SubtypeMachine.gasvent), 4)
		.setNewPage());

	// Spin Coater
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSBlocks.SPIN_COATER.get().asItem(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSBlocks.SPIN_COATER.get().asItem().getDescription().copy().withStyle(ChatFormatting.UNDERLINE)
				.withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_PURPLE)))
		.setNewPage().onTooltip((graphics, xAxis, yAxis, screen) -> {
		    if (JeiBuffer.isJeiInstalled()) {
			graphics.renderTooltip(screen.getFontRenderer(),
				ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis,
				yAxis);
		    }
		}).onKeyPress(new OnKeyPress() {
		    @Override
		    public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis,
			    ScreenGuidebook screen) {
		    }

		    @Override
		    public @Nullable Object getJeiLookup() {
			return new ItemStack(CSBlocks.SPIN_COATER.get().asItem());
		    }
		}));
	pageData.add(new TextWrapperObject(CSTextUtils.guidebook("chapter.machines.spincoater")).setIndentions(1));

	// Circuit maker
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSBlocks.CIRCUIT_MAKER.get().asItem(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSBlocks.CIRCUIT_MAKER.get().asItem().getDescription().copy()
				.withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BOLD)
				.withStyle(ChatFormatting.DARK_PURPLE)))
		.setNewPage().onTooltip((graphics, xAxis, yAxis, screen) -> {
		    if (JeiBuffer.isJeiInstalled()) {
			graphics.renderTooltip(screen.getFontRenderer(),
				ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis,
				yAxis);
		    }
		}).onKeyPress(new OnKeyPress() {
		    @Override
		    public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis,
			    ScreenGuidebook screen) {
		    }

		    @Override
		    public @Nullable Object getJeiLookup() {
			return new ItemStack(CSBlocks.CIRCUIT_MAKER.get().asItem());
		    }
		}));
	pageData.add(new TextWrapperObject(CSTextUtils.guidebook("chapter.machines.circuitmaker")).setIndentions(1));

    }
}