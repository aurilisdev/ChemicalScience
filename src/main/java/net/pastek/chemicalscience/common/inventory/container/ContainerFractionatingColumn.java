package net.pastek.chemicalscience.common.inventory.container;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.SimpleContainerData;
import net.pastek.chemicalscience.common.tile.TileFractionatingColumn;
import net.pastek.chemicalscience.registers.CSMenuTypes;
import voltaic.common.item.subtype.SubtypeItemUpgrade;
import voltaic.prefab.inventory.container.slot.item.type.SlotFluid;
import voltaic.prefab.inventory.container.slot.item.type.SlotUpgrade;
import voltaic.prefab.inventory.container.types.GenericContainerBlockEntity;

public class ContainerFractionatingColumn extends GenericContainerBlockEntity<TileFractionatingColumn> {
    public static final SubtypeItemUpgrade[] VALID_UPGRADES;

    public ContainerFractionatingColumn(int id, Inventory playerinv) {
        this(id, playerinv, new SimpleContainer(15), new SimpleContainerData(3));
    }

    public ContainerFractionatingColumn(int id, Inventory playerinv, Container inventory, ContainerData inventorydata) {
        super(CSMenuTypes.CONTAINER_FRACTIONATING_COLUMN.get(), id, playerinv, inventory, inventorydata);
    }

    public ContainerFractionatingColumn(MenuType<?> type, int id, Inventory playerinv, Container inventory, ContainerData inventorydata) {
        super(type, id, playerinv, inventory, inventorydata);
    }

    @Override
    public void addInventorySlots(Container inv, Inventory playerinv) {
        setPlayerInvOffset(35);
        this.addSlot(new SlotFluid(inv, this.nextIndex(), 8, 82));
        this.addSlot(new SlotUpgrade(inv, this.nextIndex(), 153, 14, VALID_UPGRADES));
        this.addSlot(new SlotUpgrade(inv, this.nextIndex(), 153, 34, VALID_UPGRADES));
        this.addSlot(new SlotUpgrade(inv, this.nextIndex(), 153, 54, VALID_UPGRADES));
    }

    static {
        VALID_UPGRADES = new SubtypeItemUpgrade[]{SubtypeItemUpgrade.advancedspeed, SubtypeItemUpgrade.basicspeed};
    }
}
