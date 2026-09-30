package net.pastek.chemicalscience.prefab.screen.component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.pastek.chemicalscience.prefab.screen.CSTextures;
import voltaic.api.electricity.formatting.ChatFormatter;
import voltaic.api.electricity.formatting.DisplayUnits;
import voltaic.api.gas.GasStack;
import voltaic.api.gas.utils.IGasTank;
import voltaic.client.VoltaicClientRegister;
import voltaic.prefab.screen.component.types.gauges.AbstractScreenComponentGauge;
import voltaic.prefab.utilities.RenderingUtils;
import voltaic.prefab.utilities.VoltaicTextUtils;
import voltaic.prefab.utilities.math.Color;

public class ScreenComponentGasInfo extends AbstractScreenComponentGauge {
    public final Supplier<IGasTank> gasTank;

    private static final int GAUGE_WIDTH = 18;
    private static final int GAUGE_HEIGHT = 9;

    public ScreenComponentGasInfo(Supplier<IGasTank> gasStack, int x, int y) {
        super(x, y);
        this.gasTank = gasStack;
        this.width = GAUGE_WIDTH;
        this.height = GAUGE_HEIGHT;
    }

    @Override
    protected int getScaledLevel() {
        IGasTank tank = this.gasTank.get();
        return (tank != null && tank.getGasAmount() > 0) ? GAUGE_HEIGHT - 2 : 0;
    }

    @Override
    protected void applyColor() {
        IGasTank tank = this.gasTank.get();
        if (tank != null) {
            GasStack gasStack = tank.getGas();
            if (!gasStack.isEmpty()) {
                Color gasColor = gasStack.getGas().getColor();

                float r = gasColor.r() > 1.0f ? gasColor.r() / 255.0f : gasColor.r();
                float g = gasColor.g() > 1.0f ? gasColor.g() / 255.0f : gasColor.g();
                float b = gasColor.b() > 1.0f ? gasColor.b() / 255.0f : gasColor.b();
                float a = gasColor.a() > 1.0f ? gasColor.a() / 255.0f : gasColor.a();

                RenderSystem.setShaderColor(r, g, b, a);
            }
        }
    }

    @Override
    protected ResourceLocation getTexture() {
        IGasTank tank = this.gasTank.get();
        if (tank != null) {
            return VoltaicClientRegister.getSprite(VoltaicClientRegister.TEXTURE_GAS).atlasLocation();
        }
	return CSTextures.GAS_INFO.getLocation();
    }

    @Override
    public void renderBackground(GuiGraphics graphics, int xAxis, int yAxis, int guiWidth, int guiHeight) {
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        graphics.blit(CSTextures.GAS_INFO.getLocation(),
                guiWidth + this.xLocation, guiHeight + this.yLocation,
                0, 0,
                GAUGE_WIDTH, GAUGE_HEIGHT,
                36, GAUGE_HEIGHT);

        IGasTank tank = this.gasTank.get();
        int scale = this.getScaledLevel();

        if (tank != null && scale > 0) {
            TextureAtlasSprite sprite = VoltaicClientRegister.getSprite(VoltaicClientRegister.TEXTURE_GAS);
            RenderingUtils.bindTexture(sprite.atlasLocation());

            this.applyColor();

            int drawX = guiWidth + this.xLocation + 1;
            int drawY = guiHeight + this.yLocation + 1 + ((GAUGE_HEIGHT - 2) - scale);

            graphics.blit(drawX, drawY, 0, 16, scale, sprite);

            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        }

        graphics.blit(CSTextures.GAS_INFO.getLocation(),
                guiWidth + this.xLocation,
                guiHeight + this.yLocation,
                GAUGE_WIDTH, 0,
                GAUGE_WIDTH, GAUGE_HEIGHT,
                36, GAUGE_HEIGHT);

        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
    }

    @Override
    protected List<? extends FormattedCharSequence> getTooltips() {
        List<FormattedCharSequence> tooltips = new ArrayList<>();
        IGasTank tank = this.gasTank.get();
        if (tank == null) return tooltips;

        GasStack gas = tank.getGas();
        if (gas.isEmpty()) {
            tooltips.add(VoltaicTextUtils.ratio(Component.literal("0"),
                    ChatFormatter.formatFluidMilibuckets(tank.getCapacity())).withStyle(ChatFormatting.GRAY).getVisualOrderText());
        } else {
            tooltips.add(gas.getGas().getDescription().getVisualOrderText());
            tooltips.add(VoltaicTextUtils.ratio(ChatFormatter.formatFluidMilibuckets(tank.getGasAmount()),
                    ChatFormatter.formatFluidMilibuckets(tank.getCapacity())).withStyle(ChatFormatting.GRAY).getVisualOrderText());
            tooltips.add(ChatFormatter.getChatDisplayShort(gas.getTemperature(), DisplayUnits.TEMPERATURE_KELVIN).withStyle(ChatFormatting.GRAY).getVisualOrderText());
            tooltips.add(ChatFormatter.getChatDisplayShort(gas.getPressure(), DisplayUnits.PRESSURE_ATM).withStyle(ChatFormatting.GRAY).getVisualOrderText());
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
}
