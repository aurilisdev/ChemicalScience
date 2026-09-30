package net.pastek.chemicalscience.client.guidebook.chapters;

import javax.annotation.Nullable;

import electrodynamics.prefab.utilities.ElectroTextUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.prefab.utils.CSTextUtils;
import net.pastek.chemicalscience.registers.CSItems;
import voltaic.client.guidebook.ScreenGuidebook;
import voltaic.client.guidebook.utils.components.Chapter;
import voltaic.client.guidebook.utils.components.Module;
import voltaic.client.guidebook.utils.pagedata.OnKeyPress;
import voltaic.client.guidebook.utils.pagedata.OnTooltip;
import voltaic.client.guidebook.utils.pagedata.graphics.AbstractGraphicWrapper;
import voltaic.client.guidebook.utils.pagedata.graphics.ImageWrapperObject;
import voltaic.client.guidebook.utils.pagedata.graphics.ItemWrapperObject;
import voltaic.compatibility.jei.JeiBuffer;

public class ChapterMolecules extends Chapter {

    private static final ItemWrapperObject LOGO = new ItemWrapperObject(7, 10, 32, 32, 32, 2.0F, CSItems.UREA.get());

    public ChapterMolecules(Module module) {
	super(module);
    }

    @Override
    public ItemWrapperObject getLogo() {
	return LOGO;
    }

    @Override
    public MutableComponent getTitle() {
	return CSTextUtils.guidebook("chapter.molecules");
    }

    @Override
    public void addData() {
	// Ammonium Carbonate
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.AMMONIUMCARBONATE.get(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSItems.AMMONIUMCARBONATE.get().getDescription().copy().withStyle(ChatFormatting.UNDERLINE)
				.withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_BLUE)),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
			CSTextUtils.guidebook("chapter.molecules.ammoniumcarbonate")))
		.onTooltip(new OnTooltip() {
		    @Override
		    public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {
			if (JeiBuffer.isJeiInstalled()) {
			    graphics.renderTooltip(screen.getFontRenderer(),
				    ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis,
				    yAxis);
			}
		    }
		}).onKeyPress(new OnKeyPress() {
		    @Override
		    public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis,
			    ScreenGuidebook screen) {
		    }

		    @Override
		    public @Nullable Object getJeiLookup() {
			return new ItemStack(CSItems.AMMONIUMCARBONATE.get());
		    }
		}));
	pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75, ResourceLocation.fromNamespaceAndPath(
		ChemicalScience.MOD_ID, "textures/screen/guidebook/molecules/ammoniumcarbonate.png")));

	// Ammonium Diuranate
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.AMMONIUMDIURANATE.get(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSItems.AMMONIUMDIURANATE.get().getDescription().copy().withStyle(ChatFormatting.UNDERLINE)
				.withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_BLUE)),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
			CSTextUtils.guidebook("chapter.molecules.ammoniumdiuranate")))
		.onTooltip(new OnTooltip() {
		    @Override
		    public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {
			if (JeiBuffer.isJeiInstalled()) {
			    graphics.renderTooltip(screen.getFontRenderer(),
				    ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis,
				    yAxis);
			}
		    }
		}).onKeyPress(new OnKeyPress() {
		    @Override
		    public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis,
			    ScreenGuidebook screen) {
		    }

		    @Override
		    public @Nullable Object getJeiLookup() {
			return new ItemStack(CSItems.AMMONIUMDIURANATE.get());
		    }
		}));
	pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75, ResourceLocation.fromNamespaceAndPath(
		ChemicalScience.MOD_ID, "textures/screen/guidebook/molecules/ammoniumdiuranate.png")));

	// Caffeine
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.CAFFEINE.get(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSItems.CAFFEINE.get().getDescription().copy().withStyle(ChatFormatting.UNDERLINE)
				.withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_BLUE)),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
			CSTextUtils.guidebook("chapter.molecules.caffeine")))
		.onTooltip(new OnTooltip() {
		    @Override
		    public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {
			if (JeiBuffer.isJeiInstalled()) {
			    graphics.renderTooltip(screen.getFontRenderer(),
				    ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis,
				    yAxis);
			}
		    }
		}).onKeyPress(new OnKeyPress() {
		    @Override
		    public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis,
			    ScreenGuidebook screen) {
		    }

		    @Override
		    public @Nullable Object getJeiLookup() {
			return new ItemStack(CSItems.CAFFEINE.get());
		    }
		}));
	pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75, ResourceLocation
		.fromNamespaceAndPath(ChemicalScience.MOD_ID, "textures/screen/guidebook/molecules/caffeine.png")));

	// Calcium Oxide
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.DUST_CALCIUMOXIDE.get(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSItems.DUST_CALCIUMOXIDE.get().getDescription().copy().withStyle(ChatFormatting.UNDERLINE)
				.withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_BLUE)),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
			CSTextUtils.guidebook("chapter.molecules.calciumoxide")))
		.onTooltip(new OnTooltip() {
		    @Override
		    public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {
			if (JeiBuffer.isJeiInstalled()) {
			    graphics.renderTooltip(screen.getFontRenderer(),
				    ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis,
				    yAxis);
			}
		    }
		}).onKeyPress(new OnKeyPress() {
		    @Override
		    public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis,
			    ScreenGuidebook screen) {
		    }

		    @Override
		    public @Nullable Object getJeiLookup() {
			return new ItemStack(CSItems.DUST_CALCIUMOXIDE.get());
		    }
		}));
	pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75, ResourceLocation
		.fromNamespaceAndPath(ChemicalScience.MOD_ID, "textures/screen/guidebook/molecules/calciumoxide.png")));

	// Cerium Oxide
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.DUST_CERIUM.get(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSItems.DUST_CERIUM.get().getDescription().copy().withStyle(ChatFormatting.UNDERLINE)
				.withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_BLUE)),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
			CSTextUtils.guidebook("chapter.molecules.ceriumoxide")))
		.onTooltip(new OnTooltip() {
		    @Override
		    public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {
			if (JeiBuffer.isJeiInstalled()) {
			    graphics.renderTooltip(screen.getFontRenderer(),
				    ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis,
				    yAxis);
			}
		    }
		}).onKeyPress(new OnKeyPress() {
		    @Override
		    public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis,
			    ScreenGuidebook screen) {
		    }

		    @Override
		    public @Nullable Object getJeiLookup() {
			return new ItemStack(CSItems.DUST_CERIUM.get());
		    }
		}));
	pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75, ResourceLocation
		.fromNamespaceAndPath(ChemicalScience.MOD_ID, "textures/screen/guidebook/molecules/ceriumoxide.png")));

	// Chromium Bromide
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.DUST_CHROMIUM_BROMIDE.get(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSItems.DUST_CHROMIUM_BROMIDE.get().getDescription().copy().withStyle(ChatFormatting.UNDERLINE)
				.withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_BLUE)),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
			CSTextUtils.guidebook("chapter.molecules.chromiumbromide")))
		.onTooltip(new OnTooltip() {
		    @Override
		    public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {
			if (JeiBuffer.isJeiInstalled()) {
			    graphics.renderTooltip(screen.getFontRenderer(),
				    ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis,
				    yAxis);
			}
		    }
		}).onKeyPress(new OnKeyPress() {
		    @Override
		    public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis,
			    ScreenGuidebook screen) {
		    }

		    @Override
		    public @Nullable Object getJeiLookup() {
			return new ItemStack(CSItems.DUST_CHROMIUM_BROMIDE.get());
		    }
		}));
	pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75, ResourceLocation.fromNamespaceAndPath(
		ChemicalScience.MOD_ID, "textures/screen/guidebook/molecules/chromiumbromide.png")));

	// Dimethyl Urea
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.DIMETHYLUREA.get(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSItems.DIMETHYLUREA.get().getDescription().copy().withStyle(ChatFormatting.UNDERLINE)
				.withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_BLUE)),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
			CSTextUtils.guidebook("chapter.molecules.dimethylurea")))
		.onTooltip(new OnTooltip() {
		    @Override
		    public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {
			if (JeiBuffer.isJeiInstalled()) {
			    graphics.renderTooltip(screen.getFontRenderer(),
				    ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis,
				    yAxis);
			}
		    }
		}).onKeyPress(new OnKeyPress() {
		    @Override
		    public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis,
			    ScreenGuidebook screen) {
		    }

		    @Override
		    public @Nullable Object getJeiLookup() {
			return new ItemStack(CSItems.DIMETHYLUREA.get());
		    }
		}));
	pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75, ResourceLocation
		.fromNamespaceAndPath(ChemicalScience.MOD_ID, "textures/screen/guidebook/molecules/dimethylurea.png")));

	// DPP
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.DPP_POLYMER.get(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSItems.DPP_POLYMER.get().getDescription().copy().withStyle(ChatFormatting.UNDERLINE)
				.withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_BLUE)),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
			CSTextUtils.guidebook("chapter.molecules.dpp")))
		.onTooltip(new OnTooltip() {
		    @Override
		    public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {
			if (JeiBuffer.isJeiInstalled()) {
			    graphics.renderTooltip(screen.getFontRenderer(),
				    ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis,
				    yAxis);
			}
		    }
		}).onKeyPress(new OnKeyPress() {
		    @Override
		    public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis,
			    ScreenGuidebook screen) {
		    }

		    @Override
		    public @Nullable Object getJeiLookup() {
			return new ItemStack(CSItems.DPP_POLYMER.get());
		    }
		}));
	pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75, ResourceLocation
		.fromNamespaceAndPath(ChemicalScience.MOD_ID, "textures/screen/guidebook/molecules/dpp.png")));

	// DTT
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.DTT_POLYMER.get(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSItems.DTT_POLYMER.get().getDescription().copy().withStyle(ChatFormatting.UNDERLINE)
				.withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_BLUE)),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
			CSTextUtils.guidebook("chapter.molecules.dtt")))
		.onTooltip(new OnTooltip() {
		    @Override
		    public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {
			if (JeiBuffer.isJeiInstalled()) {
			    graphics.renderTooltip(screen.getFontRenderer(),
				    ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis,
				    yAxis);
			}
		    }
		}).onKeyPress(new OnKeyPress() {
		    @Override
		    public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis,
			    ScreenGuidebook screen) {
		    }

		    @Override
		    public @Nullable Object getJeiLookup() {
			return new ItemStack(CSItems.DTT_POLYMER.get());
		    }
		}));
	pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75, ResourceLocation
		.fromNamespaceAndPath(ChemicalScience.MOD_ID, "textures/screen/guidebook/molecules/dtt.png")));

	// DPP-DTT
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.DPPDTT_POLYMER.get(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSItems.DPPDTT_POLYMER.get().getDescription().copy().withStyle(ChatFormatting.UNDERLINE)
				.withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_BLUE)),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
			CSTextUtils.guidebook("chapter.molecules.dppdtt")))
		.onTooltip(new OnTooltip() {
		    @Override
		    public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {
			if (JeiBuffer.isJeiInstalled()) {
			    graphics.renderTooltip(screen.getFontRenderer(),
				    ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis,
				    yAxis);
			}
		    }
		}).onKeyPress(new OnKeyPress() {
		    @Override
		    public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis,
			    ScreenGuidebook screen) {
		    }

		    @Override
		    public @Nullable Object getJeiLookup() {
			return new ItemStack(CSItems.DPPDTT_POLYMER.get());
		    }
		}));
	pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75, ResourceLocation
		.fromNamespaceAndPath(ChemicalScience.MOD_ID, "textures/screen/guidebook/molecules/dppdtt.png")));

	// Iron Arsenide
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.DUST_IRONARSENIDE.get(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSItems.DUST_IRONARSENIDE.get().getDescription().copy().withStyle(ChatFormatting.UNDERLINE)
				.withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_BLUE)),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
			CSTextUtils.guidebook("chapter.molecules.ironarsenide")))
		.onTooltip(new OnTooltip() {
		    @Override
		    public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {
			if (JeiBuffer.isJeiInstalled()) {
			    graphics.renderTooltip(screen.getFontRenderer(),
				    ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis,
				    yAxis);
			}
		    }
		}).onKeyPress(new OnKeyPress() {
		    @Override
		    public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis,
			    ScreenGuidebook screen) {
		    }

		    @Override
		    public @Nullable Object getJeiLookup() {
			return new ItemStack(CSItems.DUST_IRONARSENIDE.get());
		    }
		}));
	pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75, ResourceLocation
		.fromNamespaceAndPath(ChemicalScience.MOD_ID, "textures/screen/guidebook/molecules/ironarsenide.png")));

	// Iron Oxide
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.DUST_IRONOXIDE.get(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSItems.DUST_IRONOXIDE.get().getDescription().copy().withStyle(ChatFormatting.UNDERLINE)
				.withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_BLUE)),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
			CSTextUtils.guidebook("chapter.molecules.ironoxide")))
		.onTooltip(new OnTooltip() {
		    @Override
		    public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {
			if (JeiBuffer.isJeiInstalled()) {
			    graphics.renderTooltip(screen.getFontRenderer(),
				    ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis,
				    yAxis);
			}
		    }
		}).onKeyPress(new OnKeyPress() {
		    @Override
		    public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis,
			    ScreenGuidebook screen) {
		    }

		    @Override
		    public @Nullable Object getJeiLookup() {
			return new ItemStack(CSItems.DUST_IRONOXIDE.get());
		    }
		}));
	pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75, ResourceLocation
		.fromNamespaceAndPath(ChemicalScience.MOD_ID, "textures/screen/guidebook/molecules/ironoxide.png")));

	// Magnesium Sulfate
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.CRYSTAL_MAGNESIUM.get(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSItems.CRYSTAL_MAGNESIUM.get().getDescription().copy().withStyle(ChatFormatting.UNDERLINE)
				.withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_BLUE)),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
			CSTextUtils.guidebook("chapter.molecules.magnesiumsulfate")))
		.onTooltip(new OnTooltip() {
		    @Override
		    public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {
			if (JeiBuffer.isJeiInstalled()) {
			    graphics.renderTooltip(screen.getFontRenderer(),
				    ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis,
				    yAxis);
			}
		    }
		}).onKeyPress(new OnKeyPress() {
		    @Override
		    public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis,
			    ScreenGuidebook screen) {
		    }

		    @Override
		    public @Nullable Object getJeiLookup() {
			return new ItemStack(CSItems.CRYSTAL_MAGNESIUM.get());
		    }
		}));
	pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75, ResourceLocation.fromNamespaceAndPath(
		ChemicalScience.MOD_ID, "textures/screen/guidebook/molecules/magnesiumsulfate.png")));

	// Nitrochlorobenzene
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.NITROCHLOROBENZENE.get(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSItems.NITROCHLOROBENZENE.get().getDescription().copy().withStyle(ChatFormatting.UNDERLINE)
				.withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_BLUE)),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
			CSTextUtils.guidebook("chapter.molecules.nitrochlorobenzene")))
		.onTooltip(new OnTooltip() {
		    @Override
		    public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {
			if (JeiBuffer.isJeiInstalled()) {
			    graphics.renderTooltip(screen.getFontRenderer(),
				    ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis,
				    yAxis);
			}
		    }
		}).onKeyPress(new OnKeyPress() {
		    @Override
		    public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis,
			    ScreenGuidebook screen) {
		    }

		    @Override
		    public @Nullable Object getJeiLookup() {
			return new ItemStack(CSItems.NITROCHLOROBENZENE.get());
		    }
		}));
	pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75, ResourceLocation.fromNamespaceAndPath(
		ChemicalScience.MOD_ID, "textures/screen/guidebook/molecules/nitrochlorobenzene.png")));

	// Palladium Chloride
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.DUST_PALLADIUM_CHLORIDE.get(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSItems.DUST_PALLADIUM_CHLORIDE.get().getDescription().copy()
				.withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BOLD)
				.withStyle(ChatFormatting.DARK_BLUE)),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
			CSTextUtils.guidebook("chapter.molecules.palladiumchloride")))
		.onTooltip(new OnTooltip() {
		    @Override
		    public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {
			if (JeiBuffer.isJeiInstalled()) {
			    graphics.renderTooltip(screen.getFontRenderer(),
				    ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis,
				    yAxis);
			}
		    }
		}).onKeyPress(new OnKeyPress() {
		    @Override
		    public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis,
			    ScreenGuidebook screen) {
		    }

		    @Override
		    public @Nullable Object getJeiLookup() {
			return new ItemStack(CSItems.DUST_PALLADIUM_CHLORIDE.get());
		    }
		}));
	pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75, ResourceLocation.fromNamespaceAndPath(
		ChemicalScience.MOD_ID, "textures/screen/guidebook/molecules/palladiumchloride.png")));

	// Platinum Chloride
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.DUST_PLATINUM_CHLORIDE.get(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSItems.DUST_PLATINUM_CHLORIDE.get().getDescription().copy().withStyle(ChatFormatting.UNDERLINE)
				.withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_BLUE)),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
			CSTextUtils.guidebook("chapter.molecules.platinumchloride")))
		.onTooltip(new OnTooltip() {
		    @Override
		    public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {
			if (JeiBuffer.isJeiInstalled()) {
			    graphics.renderTooltip(screen.getFontRenderer(),
				    ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis,
				    yAxis);
			}
		    }
		}).onKeyPress(new OnKeyPress() {
		    @Override
		    public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis,
			    ScreenGuidebook screen) {
		    }

		    @Override
		    public @Nullable Object getJeiLookup() {
			return new ItemStack(CSItems.DUST_PLATINUM_CHLORIDE.get());
		    }
		}));
	pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75, ResourceLocation.fromNamespaceAndPath(
		ChemicalScience.MOD_ID, "textures/screen/guidebook/molecules/platinumchloride.png")));

	// Paraphenylene diamine
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.PARAPHENYLENEDIAMINE.get(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSItems.PARAPHENYLENEDIAMINE.get().getDescription().copy().withStyle(ChatFormatting.UNDERLINE)
				.withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_BLUE)),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
			CSTextUtils.guidebook("chapter.molecules.paraphenylenediamine")))
		.onTooltip(new OnTooltip() {
		    @Override
		    public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {
			if (JeiBuffer.isJeiInstalled()) {
			    graphics.renderTooltip(screen.getFontRenderer(),
				    ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis,
				    yAxis);
			}
		    }
		}).onKeyPress(new OnKeyPress() {
		    @Override
		    public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis,
			    ScreenGuidebook screen) {
		    }

		    @Override
		    public @Nullable Object getJeiLookup() {
			return new ItemStack(CSItems.PARAPHENYLENEDIAMINE.get());
		    }
		}));
	pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75, ResourceLocation.fromNamespaceAndPath(
		ChemicalScience.MOD_ID, "textures/screen/guidebook/molecules/paraphenylenediamine.png")));

	// Terephthaloylchloride
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.TEREPHTHALOYLCHLORIDE.get(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSItems.TEREPHTHALOYLCHLORIDE.get().getDescription().copy().withStyle(ChatFormatting.UNDERLINE)
				.withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_BLUE)),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
			CSTextUtils.guidebook("chapter.molecules.terephthaloylchloride")))
		.onTooltip(new OnTooltip() {
		    @Override
		    public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {
			if (JeiBuffer.isJeiInstalled()) {
			    graphics.renderTooltip(screen.getFontRenderer(),
				    ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis,
				    yAxis);
			}
		    }
		}).onKeyPress(new OnKeyPress() {
		    @Override
		    public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis,
			    ScreenGuidebook screen) {
		    }

		    @Override
		    public @Nullable Object getJeiLookup() {
			return new ItemStack(CSItems.TEREPHTHALOYLCHLORIDE.get());
		    }
		}));
	pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75, ResourceLocation.fromNamespaceAndPath(
		ChemicalScience.MOD_ID, "textures/screen/guidebook/molecules/terephthaloylchloride.png")));

	// Paraphenyleneterephthalamide
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.PARAPHENYLENETEREPHTHALAMIDE_POLYMER.get(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSItems.PARAPHENYLENETEREPHTHALAMIDE_POLYMER.get().getDescription().copy()
				.withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BOLD)
				.withStyle(ChatFormatting.DARK_BLUE)),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
			CSTextUtils.guidebook("chapter.molecules.paraphenyleneterephthalamide")))
		.onTooltip(new OnTooltip() {
		    @Override
		    public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {
			if (JeiBuffer.isJeiInstalled()) {
			    graphics.renderTooltip(screen.getFontRenderer(),
				    ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis,
				    yAxis);
			}
		    }
		}).onKeyPress(new OnKeyPress() {
		    @Override
		    public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis,
			    ScreenGuidebook screen) {
		    }

		    @Override
		    public @Nullable Object getJeiLookup() {
			return new ItemStack(CSItems.PARAPHENYLENETEREPHTHALAMIDE_POLYMER.get());
		    }
		}));
	pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75, ResourceLocation.fromNamespaceAndPath(
		ChemicalScience.MOD_ID, "textures/screen/guidebook/molecules/paraphenyleneterephthalamide.png")));

	// Propylene
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.POLYPROPYLENE.get(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSItems.POLYPROPYLENE.get().getDescription().copy().withStyle(ChatFormatting.UNDERLINE)
				.withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_BLUE)),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
			CSTextUtils.guidebook("chapter.molecules.propylene")))
		.onTooltip(new OnTooltip() {
		    @Override
		    public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {
			if (JeiBuffer.isJeiInstalled()) {
			    graphics.renderTooltip(screen.getFontRenderer(),
				    ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis,
				    yAxis);
			}
		    }
		}).onKeyPress(new OnKeyPress() {
		    @Override
		    public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis,
			    ScreenGuidebook screen) {
		    }

		    @Override
		    public @Nullable Object getJeiLookup() {
			return new ItemStack(CSItems.POLYPROPYLENE.get());
		    }
		}));
	pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75, ResourceLocation
		.fromNamespaceAndPath(ChemicalScience.MOD_ID, "textures/screen/guidebook/molecules/propylene.png")));

	// Styrene
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.POLYSTYRENE.get(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSItems.POLYSTYRENE.get().getDescription().copy().withStyle(ChatFormatting.UNDERLINE)
				.withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_BLUE)),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
			CSTextUtils.guidebook("chapter.molecules.styrene")))
		.onTooltip(new OnTooltip() {
		    @Override
		    public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {
			if (JeiBuffer.isJeiInstalled()) {
			    graphics.renderTooltip(screen.getFontRenderer(),
				    ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis,
				    yAxis);
			}
		    }
		}).onKeyPress(new OnKeyPress() {
		    @Override
		    public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis,
			    ScreenGuidebook screen) {
		    }

		    @Override
		    public @Nullable Object getJeiLookup() {
			return new ItemStack(CSItems.POLYSTYRENE.get());
		    }
		}));
	pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75, ResourceLocation
		.fromNamespaceAndPath(ChemicalScience.MOD_ID, "textures/screen/guidebook/molecules/styrene.png")));

	// Succinimide
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.SUCCINIMIDE.get(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSItems.SUCCINIMIDE.get().getDescription().copy().withStyle(ChatFormatting.UNDERLINE)
				.withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_BLUE)),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
			CSTextUtils.guidebook("chapter.molecules.succinimide")))
		.onTooltip(new OnTooltip() {
		    @Override
		    public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {
			if (JeiBuffer.isJeiInstalled()) {
			    graphics.renderTooltip(screen.getFontRenderer(),
				    ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis,
				    yAxis);
			}
		    }
		}).onKeyPress(new OnKeyPress() {
		    @Override
		    public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis,
			    ScreenGuidebook screen) {
		    }

		    @Override
		    public @Nullable Object getJeiLookup() {
			return new ItemStack(CSItems.SUCCINIMIDE.get());
		    }
		}));
	pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75, ResourceLocation
		.fromNamespaceAndPath(ChemicalScience.MOD_ID, "textures/screen/guidebook/molecules/succinimide.png")));

	// Nbromosuccinimide
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.NBROMOSUCCINIMIDE.get(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSItems.NBROMOSUCCINIMIDE.get().getDescription().copy().withStyle(ChatFormatting.UNDERLINE)
				.withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_BLUE)),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
			CSTextUtils.guidebook("chapter.molecules.nbromosuccinimide")))
		.onTooltip(new OnTooltip() {
		    @Override
		    public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {
			if (JeiBuffer.isJeiInstalled()) {
			    graphics.renderTooltip(screen.getFontRenderer(),
				    ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis,
				    yAxis);
			}
		    }
		}).onKeyPress(new OnKeyPress() {
		    @Override
		    public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis,
			    ScreenGuidebook screen) {
		    }

		    @Override
		    public @Nullable Object getJeiLookup() {
			return new ItemStack(CSItems.NBROMOSUCCINIMIDE.get());
		    }
		}));
	pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75, ResourceLocation.fromNamespaceAndPath(
		ChemicalScience.MOD_ID, "textures/screen/guidebook/molecules/nbromosuccinimide.png")));

	// Urea
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.UREA.get(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSItems.UREA.get().getDescription().copy().withStyle(ChatFormatting.UNDERLINE)
				.withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_BLUE)),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
			CSTextUtils.guidebook("chapter.molecules.urea")))
		.onTooltip(new OnTooltip() {
		    @Override
		    public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {
			if (JeiBuffer.isJeiInstalled()) {
			    graphics.renderTooltip(screen.getFontRenderer(),
				    ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis,
				    yAxis);
			}
		    }
		}).onKeyPress(new OnKeyPress() {
		    @Override
		    public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis,
			    ScreenGuidebook screen) {
		    }

		    @Override
		    public @Nullable Object getJeiLookup() {
			return new ItemStack(CSItems.UREA.get());
		    }
		}));
	pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75, ResourceLocation
		.fromNamespaceAndPath(ChemicalScience.MOD_ID, "textures/screen/guidebook/molecules/urea.png")));

	// Vinyl Chloride
	pageData.add(new ItemWrapperObject(15, 10, 32, 32, 50, 2.0F, CSItems.PVC.get(),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10,
			CSItems.PVC.get().getDescription().copy().withStyle(ChatFormatting.UNDERLINE)
				.withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_BLUE)),
		new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20,
			CSTextUtils.guidebook("chapter.molecules.vinylchloride")))
		.onTooltip(new OnTooltip() {
		    @Override
		    public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {
			if (JeiBuffer.isJeiInstalled()) {
			    graphics.renderTooltip(screen.getFontRenderer(),
				    ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis,
				    yAxis);
			}
		    }
		}).onKeyPress(new OnKeyPress() {
		    @Override
		    public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis,
			    ScreenGuidebook screen) {
		    }

		    @Override
		    public @Nullable Object getJeiLookup() {
			return new ItemStack(CSItems.PVC.get());
		    }
		}));
	pageData.add(new ImageWrapperObject(20, 0, 0, 0, 100, 75, 100, 75, ResourceLocation.fromNamespaceAndPath(
		ChemicalScience.MOD_ID, "textures/screen/guidebook/molecules/vinylchloride.png")));

    }
}