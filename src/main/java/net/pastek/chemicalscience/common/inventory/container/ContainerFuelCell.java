package net.pastek.chemicalscience.common.inventory.container;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.pastek.chemicalscience.common.tile.TileFuelCell;
import net.pastek.chemicalscience.registers.CSMenuTypes;
import voltaic.prefab.inventory.container.slot.item.type.SlotFluid;
import voltaic.prefab.inventory.container.types.GenericContainerBlockEntity;

public class ContainerFuelCell extends GenericContainerBlockEntity<TileFuelCell> {
    public ContainerFuelCell(int id, Inventory playerinv) {
        this(id, playerinv, new SimpleContainer(1), new SimpleContainerData(3));
    }

    public ContainerFuelCell(int id, Inventory playerinv, Container inventory, ContainerData inventorydata) {
        super(CSMenuTypes.CONTAINER_FUELCELL.get(), id, playerinv, inventory, inventorydata);
    }

    @Override
    public void addInventorySlots(Container inv, Inventory playerinv) {
        this.addSlot(new SlotFluid(inv, this.nextIndex(), 45, 34));
    }
}
