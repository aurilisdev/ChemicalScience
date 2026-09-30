package net.pastek.chemicalscience.client.guidebook.chapters;

import javax.annotation.Nullable;

import electrodynamics.prefab.utilities.ElectroTextUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ItemStack;
import net.pastek.chemicalscience.prefab.utils.CSTextUtils;
import net.pastek.chemicalscience.registers.CSBlocks;
import voltaic.client.guidebook.ScreenGuidebook;
import voltaic.client.guidebook.utils.components.Chapter;
import voltaic.client.guidebook.utils.components.Module;
import voltaic.client.guidebook.utils.pagedata.OnKeyPress;
import voltaic.client.guidebook.utils.pagedata.OnTooltip;
import voltaic.client.guidebook.utils.pagedata.graphics.AbstractGraphicWrapper;
import voltaic.client.guidebook.utils.pagedata.graphics.ItemWrapperObject;
import voltaic.compatibility.jei.JeiBuffer;


public class ChapterOres extends Chapter {

    private static final ItemWrapperObject LOGO = new ItemWrapperObject(7, 10, 32, 32, 32, 2.0F, CSBlocks.ORE_MAGNESIUM.asItem());

    public ChapterOres(Module module) {
        super(module);
    }

    @Override
    public ItemWrapperObject getLogo() {
        return LOGO;
    }

    @Override
    public MutableComponent getTitle() {
        return CSTextUtils.guidebook("chapter.ores");
    }

    @Override
    public void addData() {
        //Magnesium
        pageData.add(new ItemWrapperObject(7, 10, 32, 32, 50, 2.0F, CSBlocks.ORE_MAGNESIUM.asItem(), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 0, CSBlocks.ORE_MAGNESIUM.asItem().getDescription().copy().withStyle(ChatFormatting.ITALIC)), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10, CSTextUtils.guidebook("chapter.ores.material", CSTextUtils.guidebook("chapter.ores.material_magnesium"))), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20, CSTextUtils.guidebook("chapter.ores.spawnrange", "-64", "80")), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 30, CSTextUtils.guidebook("chapter.ores.veinsperchunk", "6")), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 40, CSTextUtils.guidebook("chapter.ores.veinsize", "9")), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 50, CSTextUtils.guidebook("chapter.ores.miningtier", "Stone"))).onTooltip(new OnTooltip() {
            @Override
            public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {
                if (JeiBuffer.isJeiInstalled()) {
                    graphics.renderTooltip(screen.getFontRenderer(), ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis, yAxis);
                }
            }
        }).onKeyPress(new OnKeyPress() {
            @Override
            public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis, ScreenGuidebook screen) {
            }
            @Override
            public @Nullable Object getJeiLookup() {
                return new ItemStack(CSBlocks.ORE_MAGNESIUM);
            }
        }));

        //Silicium
        pageData.add(new ItemWrapperObject(7, 10, 32, 32, 50, 2.0F, CSBlocks.ORE_SILICON.asItem(), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 0, CSBlocks.ORE_SILICON.asItem().getDescription().copy().withStyle(ChatFormatting.ITALIC)), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10, CSTextUtils.guidebook("chapter.ores.material", CSTextUtils.guidebook("chapter.ores.material_silicon"))), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20, CSTextUtils.guidebook("chapter.ores.spawnrange", "-8", "30")), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 30, CSTextUtils.guidebook("chapter.ores.veinsperchunk", "4")), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 40, CSTextUtils.guidebook("chapter.ores.veinsize", "4")), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 50, CSTextUtils.guidebook("chapter.ores.miningtier", "Iron"))).onTooltip(new OnTooltip() {
            @Override
            public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {
                if (JeiBuffer.isJeiInstalled()) {
                    graphics.renderTooltip(screen.getFontRenderer(), ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis, yAxis);
                }
            }
        }).onKeyPress(new OnKeyPress() {
            @Override
            public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis, ScreenGuidebook screen) {
            }
            @Override
            public @Nullable Object getJeiLookup() {
                return new ItemStack(CSBlocks.ORE_SILICON);
            }
        }));

        //Arsenopyrite
        pageData.add(new ItemWrapperObject(7, 10, 32, 32, 50, 2.0F, CSBlocks.ORE_ARSENOPYRITE.asItem(), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 0, CSBlocks.ORE_ARSENOPYRITE.asItem().getDescription().copy().withStyle(ChatFormatting.ITALIC)), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10, CSTextUtils.guidebook("chapter.ores.material", CSTextUtils.guidebook("chapter.ores.material_arsenopyrite"))), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20, CSTextUtils.guidebook("chapter.ores.spawnrange", "-8", "48")), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 30, CSTextUtils.guidebook("chapter.ores.veinsperchunk", "2")), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 40, CSTextUtils.guidebook("chapter.ores.veinsize", "4")), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 50, CSTextUtils.guidebook("chapter.ores.miningtier", "Iron"))).onTooltip(new OnTooltip() {
            @Override
            public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {
                if (JeiBuffer.isJeiInstalled()) {
                    graphics.renderTooltip(screen.getFontRenderer(), ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis, yAxis);
                }
            }
        }).onKeyPress(new OnKeyPress() {
            @Override
            public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis, ScreenGuidebook screen) {
            }
            @Override
            public @Nullable Object getJeiLookup() {
                return new ItemStack(CSBlocks.ORE_ARSENOPYRITE);
            }
        }));

        //Wolframite
        pageData.add(new ItemWrapperObject(7, 10, 32, 32, 50, 2.0F, CSBlocks.ORE_WOLFRAMITE.asItem(), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 0, CSBlocks.ORE_WOLFRAMITE.asItem().getDescription().copy().withStyle(ChatFormatting.ITALIC)), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10, CSTextUtils.guidebook("chapter.ores.material", CSTextUtils.guidebook("chapter.ores.material_wolframite"))), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20, CSTextUtils.guidebook("chapter.ores.spawnrange", "-64", "8")), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 30, CSTextUtils.guidebook("chapter.ores.veinsperchunk", "4")), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 40, CSTextUtils.guidebook("chapter.ores.veinsize", "5")), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 50, CSTextUtils.guidebook("chapter.ores.miningtier", "Iron"))).onTooltip(new OnTooltip() {
            @Override
            public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {
                if (JeiBuffer.isJeiInstalled()) {
                    graphics.renderTooltip(screen.getFontRenderer(), ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis, yAxis);
                }
            }
        }).onKeyPress(new OnKeyPress() {
            @Override
            public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis, ScreenGuidebook screen) {
            }
            @Override
            public @Nullable Object getJeiLookup() {
                return new ItemStack(CSBlocks.ORE_WOLFRAMITE);
            }
        }));

        //Cooperite
        pageData.add(new ItemWrapperObject(7, 10, 32, 32, 50, 2.0F, CSBlocks.ORE_COOPERITE.asItem(), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 0, CSBlocks.ORE_COOPERITE.asItem().getDescription().copy().withStyle(ChatFormatting.ITALIC)), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10, CSTextUtils.guidebook("chapter.ores.material", CSTextUtils.guidebook("chapter.ores.material_cooperite"))), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20, CSTextUtils.guidebook("chapter.ores.spawnrange", "-8", "48")), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 30, CSTextUtils.guidebook("chapter.ores.veinsperchunk", "4")), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 40, CSTextUtils.guidebook("chapter.ores.veinsize", "3")), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 50, CSTextUtils.guidebook("chapter.ores.miningtier", "Iron"))).onTooltip(new OnTooltip() {
            @Override
            public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {
                if (JeiBuffer.isJeiInstalled()) {
                    graphics.renderTooltip(screen.getFontRenderer(), ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis, yAxis);
                }
            }
        }).onKeyPress(new OnKeyPress() {
            @Override
            public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis, ScreenGuidebook screen) {
            }
            @Override
            public @Nullable Object getJeiLookup() {
                return new ItemStack(CSBlocks.ORE_COOPERITE);
            }
        }));

        //Pyrolusite
        pageData.add(new ItemWrapperObject(7, 10, 32, 32, 50, 2.0F, CSBlocks.ORE_PYROLUSITE.asItem(), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 0, CSBlocks.ORE_PYROLUSITE.asItem().getDescription().copy().withStyle(ChatFormatting.ITALIC)), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10, CSTextUtils.guidebook("chapter.ores.material", CSTextUtils.guidebook("chapter.ores.material_pyrolusite"))), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20, CSTextUtils.guidebook("chapter.ores.spawnrange", "-8", "80")), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 30, CSTextUtils.guidebook("chapter.ores.veinsperchunk", "6")), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 40, CSTextUtils.guidebook("chapter.ores.veinsize", "6")), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 50, CSTextUtils.guidebook("chapter.ores.miningtier", "Stone"))).onTooltip(new OnTooltip() {
            @Override
            public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {
                if (JeiBuffer.isJeiInstalled()) {
                    graphics.renderTooltip(screen.getFontRenderer(), ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis, yAxis);
                }
            }
        }).onKeyPress(new OnKeyPress() {
            @Override
            public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis, ScreenGuidebook screen) {
            }
            @Override
            public @Nullable Object getJeiLookup() {
                return new ItemStack(CSBlocks.ORE_PYROLUSITE);
            }
        }));

        //Source rock
        pageData.add(new ItemWrapperObject(7, 10, 32, 32, 50, 2.0F, CSBlocks.ORE_OIL.asItem(), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 0, CSBlocks.ORE_OIL.asItem().getDescription().copy().withStyle(ChatFormatting.ITALIC)), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 10, CSTextUtils.guidebook("chapter.ores.material", CSTextUtils.guidebook("chapter.ores.material_oil"))), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 20, CSTextUtils.guidebook("chapter.ores.spawnrange", "-48", "80")), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 30, CSTextUtils.guidebook("chapter.ores.veinsperchunk", "1")), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 40, CSTextUtils.guidebook("chapter.ores.veinsize", "48")), new AbstractGraphicWrapper.GraphicTextDescriptor(40, 50, CSTextUtils.guidebook("chapter.ores.miningtier", "Stone"))).onTooltip(new OnTooltip() {
            @Override
            public void onTooltip(GuiGraphics graphics, int xAxis, int yAxis, ScreenGuidebook screen) {
                if (JeiBuffer.isJeiInstalled()) {
                    graphics.renderTooltip(screen.getFontRenderer(), ElectroTextUtils.tooltip("guidebookjeiuse").withStyle(ChatFormatting.GRAY), xAxis, yAxis);
                }
            }
        }).onKeyPress(new OnKeyPress() {
            @Override
            public void onKeyPress(int keyCode, int scanCode, int modifiers, int x, int y, int xAxis, int yAxis, ScreenGuidebook screen) {
            }
            @Override
            public @Nullable Object getJeiLookup() {
                return new ItemStack(CSBlocks.ORE_OIL);
            }
        }));
    }

}