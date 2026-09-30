package net.pastek.chemicalscience.client.screen;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.pastek.chemicalscience.common.inventory.container.ContainerFuelCell;
import net.pastek.chemicalscience.prefab.screen.component.ScreenComponentOn;
import voltaic.prefab.screen.component.ScreenComponentGeneric;
import voltaic.prefab.screen.component.types.ScreenComponentProgress.ProgressTextures;
import voltaic.prefab.screen.component.types.gauges.ScreenComponentFluidGauge;
import voltaic.prefab.screen.component.types.guitab.ScreenComponentElectricInfo;
import voltaic.prefab.screen.types.GenericMaterialScreen;
import voltaic.prefab.tile.components.IComponentType;
import voltaic.prefab.tile.components.type.ComponentFluidHandlerMulti;

@OnlyIn(Dist.CLIENT)
public class ScreenFuelCell extends GenericMaterialScreen<ContainerFuelCell> {
    public ScreenFuelCell(ContainerFuelCell container, Inventory playerInventory, Component title) {
        super(container, playerInventory, title);
        this.addComponent(new ScreenComponentFluidGauge(() -> container.getSafeHost().map(boiler -> ((ComponentFluidHandlerMulti)boiler.requireComponent(IComponentType.FluidHandler)).getInputTanks()[0]).orElse(null), 98, 18));
        this.addComponent(new ScreenComponentGeneric(ProgressTextures.ARROW_RIGHT_OFF, 69, 33));
        this.addComponent(new ScreenComponentOn(ScreenComponentOn.ProgressBars.LIGHTNING, 119, 34));
        this.addComponent(new ScreenComponentElectricInfo(-25, 2));
    }
}
