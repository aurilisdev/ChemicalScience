package net.pastek.chemicalscience.common.inventory.container;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.pastek.chemicalscience.common.tile.TileSpinCoater;
import net.pastek.chemicalscience.registers.CSMenuTypes;
import voltaic.common.item.subtype.SubtypeItemUpgrade;
import voltaic.prefab.inventory.container.slot.item.type.SlotFluid;
import voltaic.prefab.inventory.container.slot.item.type.SlotRestricted;
import voltaic.prefab.inventory.container.slot.item.type.SlotUpgrade;
import voltaic.prefab.inventory.container.types.GenericContainerBlockEntity;
import voltaic.prefab.utilities.math.Color;

public class ContainerSpinCoater extends GenericContainerBlockEntity<TileSpinCoater> {
    public static final SubtypeItemUpgrade[] VALID_UPGRADES;

    public ContainerSpinCoater(int id, Inventory playerinv) {
        this(id, playerinv, new SimpleContainer(10), new SimpleContainerData(3));
    }

    public ContainerSpinCoater(int id, Inventory playerinv, Container inventory, ContainerData inventorydata) {
        super(CSMenuTypes.CONTAINER_SPIN_COATER.get(), id, playerinv, inventory, inventorydata);
    }

    @Override
    public void addInventorySlots(Container inv, Inventory playerinv) {
        addSlot((new SlotRestricted(inv, nextIndex(), 116, 30)).setIOColor(new Color(255, 0, 0, 255)));
        addSlot((new SlotFluid(inv, nextIndex(), 26, 48)).setIOColor(new Color(0, 240, 255, 255)));
        addSlot(new SlotUpgrade(inv, nextIndex(), 153, 10, VALID_UPGRADES));
        addSlot(new SlotUpgrade(inv, nextIndex(), 153, 30, VALID_UPGRADES));
        addSlot(new SlotUpgrade(inv, nextIndex(), 153, 50, VALID_UPGRADES));
    }

    static {
        VALID_UPGRADES = new SubtypeItemUpgrade[]{SubtypeItemUpgrade.advancedspeed, SubtypeItemUpgrade.basicspeed};
    }
}
