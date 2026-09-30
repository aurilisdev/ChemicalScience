package net.pastek.chemicalscience.client.guidebook.chapters;

import javax.annotation.Nullable;

import electrodynamics.prefab.utilities.ElectroTextUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ItemStack;
import net.pastek.chemicalscience.prefab.utils.CSTextUtils;
import net.pastek.chemicalscience.registers.CSItems;
import voltaic.client.guidebook.ScreenGuidebook;
import voltaic.client.guidebook.utils.components.Chapter;
import voltaic.client.guidebook.utils.components.Module;
import voltaic.client.guidebook.utils.pagedata.OnKeyPress;
import voltaic.client.guidebook.utils.pagedata.graphics.AbstractGraphicWrapper;
import voltaic.client.guidebook.utils.pagedata.graphics.ItemWrapperObject;
import voltaic.client.guidebook.utils.pagedata.text.TextWrapperObject;
import voltaic.compatibility.jei.JeiBuffer;

public class ChapterEquipment extends Chapter {

    private static final ItemWrapperObject LOGO = new ItemWrapperObject(7, 10, 32, 32, 32, 2.0F,
	    CSItems.ORGANICNIGHTVISIONGOGGLES.asItem());

    public ChapterEquipment(Module module) {
	super(module);
    }

    @Override
    public ItemWrapperObject getLogo() {
	return LOGO;
    }

    @Override
    public MutableComponent getTitle() {
	return CSTextUtils.guidebook("chapter.equipment");
    }

    @Override
    public void addData() {
	// Organic Night Vision goggles
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.ORGANICNIGHTVISIONGOGGLES.asItem(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSItems.ORGANICNIGHTVISIONGOGGLES.asItem().getDescription().copy()
				.withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BOLD)
				.withStyle(ChatFormatting.DARK_GREEN)))
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
			return new ItemStack(CSItems.ORGANICNIGHTVISIONGOGGLES.asItem());
		    }
		}));
	pageData.add(new TextWrapperObject(CSTextUtils.guidebook("chapter.equipment.onvg")).setIndentions(1));

	// Bulletproof vest
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.BULLETPROOF_VEST.asItem(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSItems.BULLETPROOF_VEST.asItem().getDescription().copy().withStyle(ChatFormatting.UNDERLINE)
				.withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_GREEN)))
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
			return new ItemStack(CSItems.BULLETPROOF_VEST.asItem());
		    }
		}));
	pageData.add(
		new TextWrapperObject(CSTextUtils.guidebook("chapter.equipment.bulletproofvest")).setIndentions(1));

	// Flamethrower
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.FLAME_THROWER.asItem(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSItems.FLAME_THROWER.asItem().getDescription().copy().withStyle(ChatFormatting.UNDERLINE)
				.withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_GREEN)))
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
			return new ItemStack(CSItems.FLAME_THROWER.asItem());
		    }
		}));
	pageData.add(new TextWrapperObject(CSTextUtils.guidebook("chapter.equipment.flamethrower")).setIndentions(1));

	// Tungsten tools
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.TUNGSTENCARBIDE_PICKAXE.asItem(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSItems.TUNGSTENCARBIDE_PICKAXE.asItem().getDescription().copy()
				.withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BOLD)
				.withStyle(ChatFormatting.DARK_GREEN)))
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
			return new ItemStack(CSItems.TUNGSTENCARBIDE_PICKAXE.asItem());
		    }
		}));
	pageData.add(new TextWrapperObject(CSTextUtils.guidebook("chapter.equipment.tungsten")).setIndentions(1));

    }
}