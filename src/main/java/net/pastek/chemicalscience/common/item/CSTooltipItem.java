package net.pastek.chemicalscience.common.item;

import java.util.List;
import java.util.Optional;

import javax.annotation.Nullable;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

public class CSTooltipItem extends Item {
    private final Component description;
    
    private final @Nullable ResourceLocation imageLocation;
    private final int imgW, imgH;

    public CSTooltipItem(Properties properties, Component description, @Nullable ResourceLocation image, int imgW, int imgH) {
        super(properties);
        this.description = description;
        this.imageLocation = image;
        this.imgW = imgW;
        this.imgH = imgH;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
            tooltipComponents.add(description);
    }

    @Override
    public Optional<TooltipComponent> getTooltipImage(ItemStack stack) {
        if (imageLocation != null) {
            return Optional.of(new ImageTooltipComponent(imageLocation, imgW, imgH));
        }
        return Optional.empty();
    }

    public record ImageTooltipComponent(ResourceLocation image, int width, int height) implements TooltipComponent {}
}