package net.pastek.chemicalscience.common.inventory.container;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.SimpleContainerData;
import net.pastek.chemicalscience.common.tile.TileHDSUnit;
import net.pastek.chemicalscience.prefab.screen.CSTextures;
import net.pastek.chemicalscience.registers.CSMenuTypes;
import voltaic.common.item.subtype.SubtypeItemUpgrade;
import voltaic.prefab.inventory.container.slot.item.SlotGeneric;
import voltaic.prefab.inventory.container.slot.item.type.SlotFluid;
import voltaic.prefab.inventory.container.slot.item.type.SlotGas;
import voltaic.prefab.inventory.container.slot.item.type.SlotUpgrade;
import voltaic.prefab.inventory.container.types.GenericContainerBlockEntity;
import voltaic.prefab.screen.component.types.ScreenComponentSlot;
import voltaic.prefab.utilities.math.Color;

public class ContainerHDSUnit extends GenericContainerBlockEntity<TileHDSUnit> {
    public static final SubtypeItemUpgrade[] VALID_UPGRADES;

    public ContainerHDSUnit(int id, Inventory playerinv) {
        this(id, playerinv, new SimpleContainer(10), new SimpleContainerData(3));
    }

    public ContainerHDSUnit(int id, Inventory playerinv, Container inventory, ContainerData inventorydata) {
        super(CSMenuTypes.CONTAINER_HDS_UNIT.get(), id, playerinv, inventory, inventorydata);
    }

    public ContainerHDSUnit(MenuType<?> type, int id, Inventory playerinv, Container inventory, ContainerData inventorydata) {
        super(type, id, playerinv, inventory, inventorydata);
    }

    @Override
    public void addInventorySlots(Container inv, Inventory playerinv) {
        setPlayerInvOffset(35);
        this.addSlot((new SlotGeneric(ScreenComponentSlot.SlotType.NORMAL, CSTextures.CATALYST_ICON, inv, this.nextIndex(), 80, 28)).setIOColor(new Color(80, 160, 130, 0)));
        this.addSlot(new SlotFluid(inv, this.nextIndex(), 8, 82));
        this.addSlot(new SlotGas(inv, this.nextIndex(), 26, 82));
        this.addSlot(new SlotFluid(inv, this.nextIndex(), 134, 82));
        this.addSlot(new SlotGas(inv, this.nextIndex(), 152, 82));
        this.addSlot(new SlotUpgrade(inv, this.nextIndex(), 62, 82, VALID_UPGRADES));
        this.addSlot(new SlotUpgrade(inv, this.nextIndex(), 80, 82, VALID_UPGRADES));
        this.addSlot(new SlotUpgrade(inv, this.nextIndex(), 98, 82, VALID_UPGRADES));
    }

    static {
        VALID_UPGRADES = new SubtypeItemUpgrade[]{SubtypeItemUpgrade.advancedspeed, SubtypeItemUpgrade.basicspeed};
    }
}
