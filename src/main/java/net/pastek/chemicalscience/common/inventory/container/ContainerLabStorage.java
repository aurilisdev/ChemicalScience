package net.pastek.chemicalscience.common.inventory.container;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.pastek.chemicalscience.common.tile.TileLabStorage;
import net.pastek.chemicalscience.registers.CSMenuTypes;
import voltaic.prefab.inventory.container.types.GenericContainerBlockEntity;

public class ContainerLabStorage extends GenericContainerBlockEntity<TileLabStorage> {

    public ContainerLabStorage(int id, Inventory playerinv) {
        this(id, playerinv, new SimpleContainer(30), new SimpleContainerData(30));
    }

    public ContainerLabStorage(int id, Inventory playerinv, Container inventory, ContainerData inventorydata) {
        super(CSMenuTypes.CONTAINER_LAB_STORAGE.get(), id, playerinv, inventory, inventorydata);
    }

    @Override
    public void addInventorySlots(Container inv, Inventory playerinv) {
        for (int chestRow = 0; chestRow < 3; chestRow++) {
            for (int chestCol = 0; chestCol < 9; chestCol++) {
                this.addSlot(new Slot(inv, chestCol + chestRow * 9, 8 + chestCol * 18, 18 + chestRow * 18));
            }
        }
        this.addSlot(new Slot(inv,27, 15 + 9 * 18, 18));
        this.addSlot(new Slot(inv,28, 15 + 9 * 18, 36));
        this.addSlot(new Slot(inv,29, 15 + 9 * 18, 54));
    }
}