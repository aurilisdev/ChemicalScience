package net.pastek.chemicalscience.common.inventory.container;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.pastek.chemicalscience.common.tile.TileRedoxFurnace;
import net.pastek.chemicalscience.registers.CSMenuTypes;
import voltaic.common.item.subtype.SubtypeItemUpgrade;
import voltaic.prefab.inventory.container.slot.item.SlotGeneric;
import voltaic.prefab.inventory.container.slot.item.type.SlotRestricted;
import voltaic.prefab.inventory.container.slot.item.type.SlotUpgrade;
import voltaic.prefab.inventory.container.types.GenericContainerBlockEntity;
import voltaic.prefab.utilities.math.Color;

public class ContainerRedoxFurnace extends GenericContainerBlockEntity<TileRedoxFurnace> {
    public static final SubtypeItemUpgrade[] VALID_UPGRADES;

    public ContainerRedoxFurnace(int id, Inventory playerinv) {
        this(id, playerinv, new SimpleContainer(11), new SimpleContainerData(3));
    }

    public ContainerRedoxFurnace(int id, Inventory playerinv, Container inventory, ContainerData inventorydata) {
        super(CSMenuTypes.CONTAINER_REDOX_FURNACE.get(), id, playerinv, inventory, inventorydata);
    }

    @Override
    public void addInventorySlots(Container inv, Inventory playerinv) {
        setPlayerInvOffset(35);
        addSlot((new SlotGeneric(inv, nextIndex(), 8, 64)).setIOColor(new Color(0, 240, 255, 255)));
        addSlot((new SlotGeneric(inv, nextIndex(), 26, 64)).setIOColor(new Color(0, 240, 255, 255)));
        addSlot((new SlotRestricted(inv, nextIndex(), 98, 28)).setIOColor(new Color(255, 0, 0, 255)));
        addSlot((new SlotRestricted(inv, nextIndex(), 116, 28)).setIOColor(new Color(255, 0, 0, 255)));
        addSlot((new SlotRestricted(inv, nextIndex(), 98, 46)).setIOColor(new Color(255, 0, 0, 255)));
        addSlot((new SlotRestricted(inv, nextIndex(), 116, 46)).setIOColor(new Color(255, 0, 0, 255)));
        addSlot((new SlotRestricted(inv, nextIndex(), 98, 64)).setIOColor(new Color(255, 0, 0, 255)));
        addSlot((new SlotRestricted(inv, nextIndex(), 116, 64)).setIOColor(new Color(255, 0, 0, 255)));
        this.addSlot(new SlotUpgrade(inv, this.nextIndex(), 152, 23, VALID_UPGRADES));
        this.addSlot(new SlotUpgrade(inv, this.nextIndex(), 152, 43, VALID_UPGRADES));
        this.addSlot(new SlotUpgrade(inv, this.nextIndex(), 152, 63, VALID_UPGRADES));
    }

    static {
        VALID_UPGRADES = new SubtypeItemUpgrade[]{SubtypeItemUpgrade.advancedspeed, SubtypeItemUpgrade.basicspeed};
    }
}
