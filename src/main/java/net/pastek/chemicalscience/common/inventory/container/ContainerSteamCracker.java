package net.pastek.chemicalscience.common.inventory.container;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.SimpleContainerData;
import net.pastek.chemicalscience.common.tile.TileSteamCracker;
import net.pastek.chemicalscience.registers.CSMenuTypes;
import voltaic.common.item.subtype.SubtypeItemUpgrade;
import voltaic.prefab.inventory.container.slot.item.type.SlotGas;
import voltaic.prefab.inventory.container.slot.item.type.SlotRestricted;
import voltaic.prefab.inventory.container.slot.item.type.SlotUpgrade;
import voltaic.prefab.inventory.container.types.GenericContainerBlockEntity;

public class ContainerSteamCracker extends GenericContainerBlockEntity<TileSteamCracker> {
    public static final SubtypeItemUpgrade[] VALID_UPGRADES;

    public ContainerSteamCracker(int id, Inventory playerinv) {
        this(id, playerinv, new SimpleContainer(10), new SimpleContainerData(3));
    }

    public ContainerSteamCracker(int id, Inventory playerinv, Container inventory, ContainerData inventorydata) {
        super(CSMenuTypes.CONTAINER_STEAM_CRACKER.get(), id, playerinv, inventory, inventorydata);
    }

    public ContainerSteamCracker(MenuType<?> type, int id, Inventory playerinv, Container inventory, ContainerData inventorydata) {
        super(type, id, playerinv, inventory, inventorydata);
    }

    @Override
    public void addInventorySlots(Container inv, Inventory playerinv) {
        setPlayerInvOffset(35);
        this.addSlot(new SlotRestricted(inv, this.nextIndex(), 80, 45));
        this.addSlot(new SlotGas(inv, this.nextIndex(), 26, 63));
        this.addSlot(new SlotUpgrade(inv, this.nextIndex(), 152, 23, VALID_UPGRADES));
        this.addSlot(new SlotUpgrade(inv, this.nextIndex(), 152, 43, VALID_UPGRADES));
        this.addSlot(new SlotUpgrade(inv, this.nextIndex(), 152, 63, VALID_UPGRADES));
    }

    static {
        VALID_UPGRADES = new SubtypeItemUpgrade[]{SubtypeItemUpgrade.advancedspeed, SubtypeItemUpgrade.basicspeed};
    }
}
