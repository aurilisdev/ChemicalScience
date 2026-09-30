package net.pastek.chemicalscience.prefab.screen.component;

import java.util.ArrayList;
import java.util.List;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.inventory.InventoryMenu;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.IFluidTank;
import net.pastek.chemicalscience.prefab.screen.CSTextures;
import voltaic.api.electricity.formatting.ChatFormatter;
import voltaic.api.screen.component.FluidTankSupplier;
import voltaic.prefab.screen.component.types.gauges.AbstractScreenComponentGauge;
import voltaic.prefab.utilities.RenderingUtils;
import voltaic.prefab.utilities.VoltaicTextUtils;
import voltaic.prefab.utilities.math.Color;

public class ScreenComponentFluidInfo extends AbstractScreenComponentGauge {
    public FluidTankSupplier fluidInfoHandler;

    private static final int GAUGE_WIDTH = 18;
    private static final int GAUGE_HEIGHT = 9;

    public ScreenComponentFluidInfo(FluidTankSupplier fluidInfoHandler, int x, int y) {
	super(x, y);
	this.fluidInfoHandler = fluidInfoHandler;
	this.width = GAUGE_WIDTH;
	this.height = GAUGE_HEIGHT;
    }

    @Override
    protected int getScaledLevel() {
	IFluidTank tank = this.fluidInfoHandler.getTank();
	return (tank != null && tank.getFluidAmount() > 0) ? GAUGE_HEIGHT - 2 : 0;
    }

    @Override
    protected void applyColor() {
	IFluidTank tank = this.fluidInfoHandler.getTank();
	if (tank != null) {
	    FluidStack fluidStack = tank.getFluid();
	    if (!fluidStack.isEmpty()) {
		IClientFluidTypeExtensions extensions = IClientFluidTypeExtensions.of(fluidStack.getFluid());
		RenderingUtils.setShaderColor(new Color(extensions.getTintColor(fluidStack)));
	    }
	}
    }

    @Override
    protected ResourceLocation getTexture() {
	IFluidTank tank = this.fluidInfoHandler.getTank();
	if (tank != null) {
	    FluidStack fluidStack = tank.getFluid();
	    IClientFluidTypeExtensions extensions = IClientFluidTypeExtensions.of(fluidStack.getFluid());
	    return extensions.getStillTexture();
	}
	return CSTextures.FLUID_INFO.getLocation();
    }

    @Override
    public void renderBackground(GuiGraphics graphics, int xAxis, int yAxis, int guiWidth, int guiHeight) {
	graphics.blit(CSTextures.FLUID_INFO.getLocation(), guiWidth + this.xLocation, guiHeight + this.yLocation, 0, 0,
		GAUGE_WIDTH, GAUGE_HEIGHT, 36, GAUGE_HEIGHT);

	ResourceLocation texture = this.getTexture();
	int scale = this.getScaledLevel();

	if (scale > 0) {
	    ResourceLocation blocks = InventoryMenu.BLOCK_ATLAS;
	    TextureAtlasSprite sprite = Minecraft.getInstance().getTextureAtlas(blocks).apply(texture);

	    this.applyColor();

	    int drawX = guiWidth + this.xLocation + 1;
	    int drawY = guiHeight + this.yLocation + 1 + ((GAUGE_HEIGHT - 2) - scale);

	    graphics.blit(drawX, drawY, 0, 16, scale, sprite);

	    RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
	}

	graphics.blit(CSTextures.FLUID_INFO.getLocation(), guiWidth + this.xLocation, guiHeight + this.yLocation,
		GAUGE_WIDTH, 0, GAUGE_WIDTH, GAUGE_HEIGHT, 36, GAUGE_HEIGHT);
    }

    @Override
    protected List<? extends FormattedCharSequence> getTooltips() {
	List<FormattedCharSequence> tooltips = new ArrayList<>();
	IFluidTank tank = this.fluidInfoHandler.getTank();
	if (tank != null) {
	    FluidStack fluidStack = tank.getFluid();
	    if (fluidStack.getAmount() > 0) {
		tooltips.add(Component.translatable(fluidStack.getHoverName().getString()).getVisualOrderText());
		tooltips.add(VoltaicTextUtils
			.ratio(ChatFormatter.formatFluidMilibuckets(tank.getFluidAmount()),
				ChatFormatter.formatFluidMilibuckets(tank.getCapacity()))
			.withStyle(ChatFormatting.GRAY).getVisualOrderText());
	    } else {
		tooltips.add(VoltaicTextUtils
			.ratio(Component.literal("0"),
				ChatFormatter.formatFluidMilibuckets(tank.getCapacity()))
			.withStyle(ChatFormatting.GRAY).getVisualOrderText());
	    }
	}

	return tooltips;
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
	if (this.isActiveAndVisible() && this.isValidClick(button) && this.isInClickRegion(mouseX, mouseY)) {
	    this.onMouseClick(mouseX, mouseY);
	    return true;
	}
	return false;
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
	if (this.isValidClick(button)) {
	    this.onMouseRelease(mouseX, mouseY);
	    return true;
	}
	return false;
    }
}