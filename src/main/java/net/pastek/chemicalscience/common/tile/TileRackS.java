package net.pastek.chemicalscience.common.tile;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.pastek.chemicalscience.common.block.subtype.SubtypeChemicalMachine;
import net.pastek.chemicalscience.common.inventory.container.ContainerRackS;
import net.pastek.chemicalscience.registers.CSTiles;
import voltaic.prefab.tile.GenericTile;
import voltaic.prefab.tile.components.IComponentType;
import voltaic.prefab.tile.components.type.ComponentContainerProvider;
import voltaic.prefab.tile.components.type.ComponentInventory;
import voltaic.prefab.tile.components.type.ComponentTickable;


public class TileRackS extends GenericTile {

    public TileRackS(BlockPos worldPosition, BlockState blockState) {
        super(CSTiles.TILE_RACK_S.get(), worldPosition, blockState);
        addComponent(new ComponentTickable(this));
        addComponent(new ComponentInventory(this, ComponentInventory.InventoryBuilder.newInv().forceSize(27)));
        addComponent(new ComponentContainerProvider(SubtypeChemicalMachine.racks.tag(), this).createMenu((id, player) -> new ContainerRackS(id, player, requireComponent(IComponentType.Inventory), getCoordsArray())));
    }


    public int getCount() {
        int count = 0;
        ComponentInventory inv = requireComponent(IComponentType.Inventory);
        for (int i = 0; i < inv.getContainerSize(); i++) {
            ItemStack stack = inv.getItem(i);
            if (!stack.isEmpty()) {
                count += stack.getCount();
            }
        }
        return count;
    }

    public int getComparatorSignal() {
        ComponentInventory inv = requireComponent(IComponentType.Inventory);
        return (int) (((double) getCount() / (double) Math.max(1, inv.getContainerSize())) * 15.0);
    }
}