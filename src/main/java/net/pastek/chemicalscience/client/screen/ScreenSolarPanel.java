package net.pastek.chemicalscience.client.screen;

import java.util.Objects;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.common.inventory.container.ContainerOrganicSolarPanel;
import net.pastek.chemicalscience.common.packet.PacketTransparencyTogglePayload;
import net.pastek.chemicalscience.prefab.screen.CSTextures;
import net.pastek.chemicalscience.prefab.utils.CSTextUtils;
import voltaic.api.electricity.formatting.ChatFormatter;
import voltaic.api.electricity.formatting.DisplayUnits;
import voltaic.prefab.screen.GenericScreen;
import voltaic.prefab.screen.component.button.ScreenComponentButton;
import voltaic.prefab.screen.component.types.ScreenComponentMultiLabel;
import voltaic.prefab.screen.component.types.guitab.ScreenComponentElectricInfo;
import voltaic.prefab.screen.component.utils.AbstractScreenComponentInfo;
import voltaic.prefab.utilities.math.Color;
import voltaic.prefab.utilities.object.TransferPack;

@OnlyIn(Dist.CLIENT)
public class ScreenSolarPanel extends GenericScreen<ContainerOrganicSolarPanel> {

    public ScreenSolarPanel(ContainerOrganicSolarPanel container, Inventory playerInventory, Component title) {
        super(container, playerInventory, title);

        this.defaultResource = ChemicalScience.rl("textures/screen/gui/organicsolarpanel_gui.png");

        addComponent(new ScreenComponentElectricInfo(-AbstractScreenComponentInfo.SIZE + 1, 2));
        addComponent(new ScreenComponentMultiLabel(0, 0, graphics -> menu.getSafeHost().ifPresent(panel -> {
            TransferPack transfer = panel.getProduced();
            graphics.drawString(font, CSTextUtils.gui("machine.current", ChatFormatter.getChatDisplayShort(transfer.getAmps(), DisplayUnits.AMPERE)), inventoryLabelX + 60, inventoryLabelY - 48, Color.TEXT_GRAY.color(), false);
            graphics.drawString(font, CSTextUtils.gui("machine.output", ChatFormatter.getChatDisplayShort(transfer.getWatts(), DisplayUnits.WATT)), inventoryLabelX + 60, inventoryLabelY - 35, Color.TEXT_GRAY.color(), false);
            graphics.drawString(font, CSTextUtils.gui("machine.voltage", ChatFormatter.getChatDisplayShort(transfer.getVoltage(), DisplayUnits.VOLTAGE)), inventoryLabelX + 60, inventoryLabelY - 22, Color.TEXT_GRAY.color(), false);
        })));



        addComponent(new ScreenComponentButton<>(25, 18, 18, 18)
                .setOnPress(button -> menu.getSafeHost().ifPresent(panel -> Objects.requireNonNull(Minecraft.getInstance().getConnection()).send(new PacketTransparencyTogglePayload(panel.getBlockPos()))))
                .setIcon(CSTextures.OSP_ICON)

        );

    }

    @Override
    protected void renderBg(GuiGraphics graphics, float partialTick, int mouseX, int mouseY) {
        int left = this.leftPos;
        int top  = this.topPos;

        graphics.blit(
                this.defaultResource,
                left,
                top,
                0,
                0,
                176,
                166
        );
    }
}