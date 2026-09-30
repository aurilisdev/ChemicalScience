package net.pastek.chemicalscience.client.guidebook;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.pastek.chemicalscience.client.roadmap.MultiblockVisualizer;
import voltaic.client.guidebook.utils.components.Page;
import voltaic.client.guidebook.utils.pagedata.graphics.AbstractGraphicWrapper;

public class MultiblockWrapperObject extends AbstractGraphicWrapper<MultiblockWrapperObject> {
    private final MultiblockVisualizer visualizer;
    private final float scale;
    private final List<ItemStack> requiredItems = new ArrayList<>();

    public MultiblockWrapperObject(int xOffset, int yOffset, int width, int height, int trueHeight, float scale, MultiblockVisualizer visualizer) {
        super(xOffset, yOffset, xOffset - (width / 2), yOffset - height, width, height*2, trueHeight);

        this.visualizer = visualizer;
        this.scale = scale;

        this.onClick((xAxis, yAxis, xSet, ySet, screen) -> {
            this.visualizer.resetAnimation();
        });

        this.onTooltip((graphics, mouseX, mouseY, screen) -> {
            if (requiredItems.isEmpty()) return;

            int rowHeight = 18;
            int padding = 6;
            int tooltipHeight = (requiredItems.size() * rowHeight) + (padding * 2);

            int maxTextWidth = 0;
            for (ItemStack stack : requiredItems) {
                String text = stack.getCount() + "x " + stack.getHoverName().getString();
                int textwidth = screen.getFontRenderer().width(text);
                if (textwidth > maxTextWidth) maxTextWidth = textwidth;
            }
            int tooltipWidth = 20 + maxTextWidth + (padding * 2);

            int renderX = mouseX + 10;
            int renderY = mouseY - 15;

            graphics.pose().pushPose();
            graphics.pose().translate(0, 0, 400);

            drawFancyTooltipBackground(graphics, renderX, renderY, tooltipWidth, tooltipHeight);

            for (int i = 0; i < requiredItems.size(); i++) {
                ItemStack stack = requiredItems.get(i);
                int yPos = renderY + padding + (i * rowHeight);
                int xPos = renderX + padding;

                graphics.renderItem(stack, xPos, yPos);
                String text = stack.getCount() + "x " + stack.getHoverName().getString();

                graphics.drawString(screen.getFontRenderer(), text, xPos + 20, yPos + 4, 0xFFFFFFFF, true);
            }

            graphics.pose().popPose();
        });
    }

    public MultiblockWrapperObject addRequiredItem(ItemLike item, int count) {
        this.requiredItems.add(new ItemStack(item, count));
        return this;
    }

    @SuppressWarnings("static-method")
    private void drawFancyTooltipBackground(GuiGraphics graphics, int x, int y, int width, int height) {
        int backgroundColor = 0xF0100010;
        int borderColorStart = 0x505000FF;
        int borderColorEnd = 0x5028007F;

        graphics.fillGradient(x, y, x + width, y + height, backgroundColor, backgroundColor);

        graphics.fillGradient(x, y - 1, x + width, y, borderColorStart, borderColorStart); // Top
        graphics.fillGradient(x, y + height, x + width, y + height + 1, borderColorEnd, borderColorEnd); // Bottom
        graphics.fillGradient(x - 1, y, x, y + height, borderColorStart, borderColorEnd); // Left
        graphics.fillGradient(x + width, y, x + width + 1, y + height, borderColorStart, borderColorEnd); // Right
    }

    @Override
    public void render(GuiGraphics graphics, int wrapperX, int wrapperY, int xShift, int guiWidth, int guiHeight, Page page) {
        int renderX = guiWidth + this.xOffset + wrapperX + xShift;
        int renderY = guiHeight + this.yOffset + wrapperY;

        this.visualizer.render(graphics, renderX, renderY, this.scale);
    }
}