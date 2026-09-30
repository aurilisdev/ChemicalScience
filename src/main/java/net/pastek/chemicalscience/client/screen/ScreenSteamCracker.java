package net.pastek.chemicalscience.client.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.common.inventory.container.ContainerSteamCracker;
import voltaic.prefab.screen.component.types.ScreenComponentProgress;
import voltaic.prefab.screen.component.types.ScreenComponentProgress.ProgressBars;
import voltaic.prefab.screen.component.types.gauges.ScreenComponentGasGauge;
import voltaic.prefab.screen.component.types.guitab.ScreenComponentElectricInfo;
import voltaic.prefab.screen.component.types.wrapper.WrapperInventoryIO;
import voltaic.prefab.screen.component.utils.AbstractScreenComponentInfo;
import voltaic.prefab.screen.types.GenericMaterialScreen;
import voltaic.prefab.tile.components.IComponentType;
import voltaic.prefab.tile.components.type.ComponentGasHandlerMulti;
import voltaic.prefab.tile.components.type.ComponentProcessor;

@OnlyIn(Dist.CLIENT)
public class ScreenSteamCracker extends GenericMaterialScreen<ContainerSteamCracker> {
    public ScreenSteamCracker(ContainerSteamCracker container, Inventory playerInventory, Component title) {
        super(container, playerInventory, title);

        this.defaultResource = ChemicalScience.rl("textures/screen/gui/steamcracker_gui.png");

        imageHeight += 35;
        inventoryLabelY += 35;

        this.addComponent(new ScreenComponentProgress(ProgressBars.PROGRESS_ARROW_RIGHT, () -> container.getSafeHost().map(furnace -> {
            ComponentProcessor processor = (ComponentProcessor)furnace.requireComponent(IComponentType.Processor);
            if (processor.isActive(0)) {
                return (float)(processor.operatingTicks.getValue()[0] / processor.requiredTicks.getValue()[0]);
            }
            return 0.0F;
        }).orElse(0.0F), 50, 45));

        this.addComponent(new ScreenComponentGasGauge(() -> container.getSafeHost().map(boiler -> ((ComponentGasHandlerMulti)boiler.requireComponent(IComponentType.GasHandler)).getInputTanks()[0]).orElse(null), 8, 30));

        this.addComponent(new ScreenComponentGasGauge(() -> container.getSafeHost().map(boiler -> ((ComponentGasHandlerMulti)boiler.requireComponent(IComponentType.GasHandler)).getOutputTanks()[0]).orElse(null), 99, 30));

        this.addComponent(new ScreenComponentGasGauge(() -> container.getSafeHost().map(boiler -> ((ComponentGasHandlerMulti)boiler.requireComponent(IComponentType.GasHandler)).getOutputTanks()[1]).orElse(null), 117, 30));


        addComponent(new ScreenComponentElectricInfo(-AbstractScreenComponentInfo.SIZE + 1, 2));
        new WrapperInventoryIO(this, -AbstractScreenComponentInfo.SIZE + 1, AbstractScreenComponentInfo.SIZE + 2, 75, 117, 8, 107);
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
                201
        );
    }
}
