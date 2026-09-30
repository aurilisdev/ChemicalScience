package net.pastek.chemicalscience.common.tile;

import java.util.List;

import electrodynamics.registers.ElectrodynamicsSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.pastek.chemicalscience.common.block.subtype.SubtypeChemicalMachine;
import net.pastek.chemicalscience.common.inventory.container.ContainerCircuitMaker;
import net.pastek.chemicalscience.common.inventory.container.ContainerSteamCracker;
import net.pastek.chemicalscience.common.recipe.categories.gas2gas.Gas2GasRecipe;
import net.pastek.chemicalscience.registers.CSRecipies;
import net.pastek.chemicalscience.registers.CSTiles;
import voltaic.api.gas.GasAction;
import voltaic.api.gas.GasTank;
import voltaic.common.recipe.recipeutils.ProbableItem;
import voltaic.prefab.sound.ITickableSound;
import voltaic.prefab.sound.SoundBarrierMethods;
import voltaic.prefab.tile.components.IComponentType;
import voltaic.prefab.tile.components.type.ComponentContainerProvider;
import voltaic.prefab.tile.components.type.ComponentElectrodynamic;
import voltaic.prefab.tile.components.type.ComponentGasHandlerMulti;
import voltaic.prefab.tile.components.type.ComponentInventory;
import voltaic.prefab.tile.components.type.ComponentInventory.InventoryBuilder;
import voltaic.prefab.tile.components.type.ComponentProcessor;
import voltaic.prefab.tile.components.type.ComponentTickable;
import voltaic.prefab.tile.types.GenericGasTile;
import voltaic.prefab.utilities.BlockEntityUtils.MachineDirection;

public class TileSteamCracker extends GenericGasTile implements ITickableSound {
    public static final int MAX_TANK_CAPACITY = 5000;
    private boolean isSoundPlaying = false;

    public TileSteamCracker(BlockPos worldPosition, BlockState blockState) {
        super(CSTiles.TILE_STEAM_CRACKER.get(), worldPosition, blockState);
        addComponent((new ComponentTickable(this)).tickClient(this::tickClient));
        addComponent((new ComponentElectrodynamic(this, false, true)).setInputDirections(new MachineDirection[]{MachineDirection.BOTTOM}).voltage(480.0F));
        addComponent((new ComponentGasHandlerMulti(this))
                .setInputTanks(1, new int[]{MAX_TANK_CAPACITY}, new int[]{1000}, new int[]{1024}).setInputDirections(new MachineDirection[]{MachineDirection.LEFT})
                .setOutputTanks(2, new int[]{MAX_TANK_CAPACITY, MAX_TANK_CAPACITY}, new int[]{1000, 1000}, new int[]{1024, 1024}).setOutputDirections(MachineDirection.RIGHT, MachineDirection.BACK)
                .setCondensedHandler(getCondensedHandler()));
        addComponent((new ComponentInventory(this, InventoryBuilder.newInv().processors(1, 0, 0, 1).gasInputs(1).gasOutputs(2).upgrades(3))).setDirectionsBySlot(0,MachineDirection.BOTTOM, MachineDirection.LEFT, MachineDirection.FRONT).validUpgrades(ContainerCircuitMaker.VALID_UPGRADES).valid(machineValidator()));
        addComponent((new ComponentContainerProvider(SubtypeChemicalMachine.steamcracker.tag(), this)).createMenu((id, player) -> new ContainerSteamCracker(id, player, (Container)requireComponent(IComponentType.Inventory), getCoordsArray())));
        addComponent(new ComponentProcessor(this).canProcess(this::canProcess).process(this::process));
    }

    private boolean canProcess(ComponentProcessor pr, Level level, int procNumber) {
        pr.consumeGasCylinder().dispenseGasCylinder().outputToGasPipe();
        Gas2GasRecipe locRecipe;
        if (!pr.checkExistingRecipe(procNumber)) {
            pr.setShouldKeepProgress(false, procNumber);
            pr.operatingTicks.setValue(0.0, procNumber);
            locRecipe = (Gas2GasRecipe) pr.getRecipe(CSRecipies.STEAM_CRACKER_TYPE.get(), procNumber);
            if (locRecipe == null) return false;
        } else {
            pr.setShouldKeepProgress(true, procNumber);
            locRecipe = (Gas2GasRecipe) pr.getRecipe(procNumber);
        }
        if(locRecipe == null) return false;
        
        pr.setRecipe(locRecipe, procNumber);
        pr.requiredTicks.setValue((double) locRecipe.getTicks(), procNumber);
        pr.usage.setValue(locRecipe.getUsagePerTick(), procNumber);

        ComponentElectrodynamic electro = requireComponent(IComponentType.Electrodynamic);
        if (electro.getJoulesStored() < pr.getUsage(procNumber)) return false;

        ComponentGasHandlerMulti gasHandler = requireComponent(IComponentType.GasHandler);
        GasTank[] outGasTanks = gasHandler.getOutputTanks();

        GasTank inTank = gasHandler.getInputTanks()[0];
        if (inTank.getGasAmount() < locRecipe.getGasIngredients().get(0).getGasStack().getAmount()) {
            return false;
        }

        if (gasHandler.getOutputTanks()[1].getGasAmount() > 4900) {
            return false;
        }

        if (outGasTanks[0].fill(locRecipe.getGasRecipeOutput(), GasAction.SIMULATE)
                < locRecipe.getGasRecipeOutput().getAmount()) {
            return false;
        }

        return true;
    }

    private void process(ComponentProcessor pr, Level level, int procNumber) {
        if (pr.getRecipe(procNumber) == null) return;

        ComponentInventory inv = requireComponent(IComponentType.Inventory);
        Gas2GasRecipe locRecipe = (Gas2GasRecipe) pr.getRecipe(procNumber);
        if(locRecipe == null) return;
        ComponentGasHandlerMulti gasHandler = requireComponent(IComponentType.GasHandler);
        GasTank[] outGasTanks = gasHandler.getOutputTanks();

        outGasTanks[0].fill(locRecipe.getGasRecipeOutput(), GasAction.EXECUTE);
        outGasTanks[1].fill(locRecipe.getGasBiproducts().getFirst().roll(), GasAction.EXECUTE);

        gasHandler.getInputTanks()[0].drain(
                locRecipe.getGasIngredients().getFirst().getGasStack().getAmount(),
                GasAction.EXECUTE
        );

        if (locRecipe.hasItemBiproducts()) {
            List<ProbableItem> itemBi = locRecipe.getItemBiproducts();
            int index = 0;
            for (int slot : inv.getBiprodSlotsForProcessor(procNumber)) {
                ItemStack stack = inv.getItem(slot);
                if (stack.isEmpty()) {
                    inv.setItem(slot, itemBi.get(index).roll().copy());
                } else {
                    stack.grow(itemBi.get(index).roll().getCount());
                    inv.setItem(slot, stack);
                }
                index++;
                if(index >= itemBi.size()) {
                    break;
                }
            }
        }

        pr.setChanged();
    }

    protected void tickClient(Level level, ComponentTickable tickable) {
        if (shouldPlaySound()) {
            if (level.random.nextDouble() < 0.15) {
                Direction direction = getFacing();
                double d4 = level.random.nextDouble();
                double d5 = direction.getAxis() == Direction.Axis.X ? (double)(direction.getStepX() * (direction.getStepX() == -1 ? 0 : 1)) : d4;
                double d6 = level.random.nextDouble();
                double d7 = direction.getAxis() == Direction.Axis.Z ? (double)(direction.getStepZ() * (direction.getStepZ() == -1 ? 0 : 1)) : d4;
                level.addParticle(ParticleTypes.SMOKE, worldPosition.getX() + d5, worldPosition.getY() + d6, worldPosition.getZ() + d7, 0.0F, 0.0F, 0.0F);
            }

            if (!isSoundPlaying) {
                isSoundPlaying = true;
                SoundBarrierMethods.playTileSound(ElectrodynamicsSounds.SOUND_HUM.get(), this, true);
            }

        }
    }

    @Override
    public void setNotPlaying() {
        isSoundPlaying = false;
    }

    @Override
    public boolean shouldPlaySound() {
        return ((ComponentProcessor)requireComponent(IComponentType.Processor)).isActive(0);
    }

    public int getComparatorSignal() {
        return ((ComponentProcessor)requireComponent(IComponentType.Processor)).isActive(0) ? 15 : 0;
    }
}
