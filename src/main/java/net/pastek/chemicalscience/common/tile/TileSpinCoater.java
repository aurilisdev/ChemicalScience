package net.pastek.chemicalscience.common.tile;

import electrodynamics.registers.ElectrodynamicsSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.pastek.chemicalscience.common.block.subtype.SubtypeChemicalMachine;
import net.pastek.chemicalscience.common.inventory.container.ContainerCircuitMaker;
import net.pastek.chemicalscience.common.inventory.container.ContainerSpinCoater;
import net.pastek.chemicalscience.registers.CSRecipies;
import net.pastek.chemicalscience.registers.CSTiles;
import voltaic.prefab.sound.ITickableSound;
import voltaic.prefab.sound.SoundBarrierMethods;
import voltaic.prefab.tile.components.IComponentType;
import voltaic.prefab.tile.components.type.ComponentContainerProvider;
import voltaic.prefab.tile.components.type.ComponentElectrodynamic;
import voltaic.prefab.tile.components.type.ComponentFluidHandlerMulti;
import voltaic.prefab.tile.components.type.ComponentInventory;
import voltaic.prefab.tile.components.type.ComponentInventory.InventoryBuilder;
import voltaic.prefab.tile.components.type.ComponentProcessor;
import voltaic.prefab.tile.components.type.ComponentTickable;
import voltaic.prefab.tile.types.GenericMaterialTile;
import voltaic.prefab.utilities.BlockEntityUtils;
import voltaic.prefab.utilities.BlockEntityUtils.MachineDirection;

public class TileSpinCoater extends GenericMaterialTile implements ITickableSound {
    public static final int MAX_TANK_CAPACITY = 200;
    private boolean isSoundPlaying = false;

    public TileSpinCoater(BlockPos worldPosition, BlockState blockState) {
        super(CSTiles.TILE_SPIN_COATER.get(), worldPosition, blockState);
        this.addComponent((new ComponentTickable(this)).tickClient(this::tickClient));
        this.addComponent((new ComponentElectrodynamic(this, false, true)).setInputDirections(new MachineDirection[]{MachineDirection.BACK}).voltage(120.0F));
        this.addComponent((new ComponentFluidHandlerMulti(this)).setInputTanks(1, new int[]{MAX_TANK_CAPACITY}).setInputDirections(new MachineDirection[]{MachineDirection.RIGHT}).setRecipeType(CSRecipies.SPIN_COATER_TYPE.get()));
        this.addComponent((new ComponentInventory(this, InventoryBuilder.newInv().processors(1, 0, 1, 0).bucketInputs(1).upgrades(3))).setDirectionsBySlot(0,MachineDirection.BOTTOM, MachineDirection.LEFT, MachineDirection.FRONT).validUpgrades(ContainerCircuitMaker.VALID_UPGRADES).valid(machineValidator()));
        this.addComponent((new ComponentContainerProvider(SubtypeChemicalMachine.spincoater.tag(), this)).createMenu((id, player) -> new ContainerSpinCoater(id, player, requireComponent(IComponentType.Inventory), getCoordsArray())));
        this.addComponent((new ComponentProcessor(this)).canProcess(this::canProcessSpinCoater).process(ComponentProcessor::processFluid2ItemRecipe));
    }

    protected void tickClient(Level level, ComponentTickable tickable) {
        if (this.shouldPlaySound()) {
            if (level.random.nextDouble() < 0.15) {
                Direction direction = this.getFacing();
                double d4 = level.random.nextDouble();
                double d5 = direction.getAxis() == Direction.Axis.X ? (double)(direction.getStepX() * (direction.getStepX() == -1 ? 0 : 1)) : d4;
                double d6 = level.random.nextDouble();
                double d7 = direction.getAxis() == Direction.Axis.Z ? (double)(direction.getStepZ() * (direction.getStepZ() == -1 ? 0 : 1)) : d4;
                level.addParticle(ParticleTypes.SMOKE, this.worldPosition.getX() + d5, this.worldPosition.getY() + d6, this.worldPosition.getZ() + d7, 0.0F, 0.0F, 0.0F);
            }

            if (!this.isSoundPlaying) {
                this.isSoundPlaying = true;
                SoundBarrierMethods.playTileSound(ElectrodynamicsSounds.SOUND_HUM.get(), this, true);
            }

        }
    }

    public boolean canProcessSpinCoater(ComponentProcessor pr, Level level, int procNumber) {
        boolean canProcess = pr.consumeBucket().canProcessFluid2ItemRecipe(level, procNumber, CSRecipies.SPIN_COATER_TYPE.get());
        if (BlockEntityUtils.isLit(this) ^ canProcess) {
            BlockEntityUtils.updateLit(this, canProcess);
        }

        return canProcess;
    }

    @Override
    public void setNotPlaying() {
        this.isSoundPlaying = false;
    }

    @Override
    public boolean shouldPlaySound() {
        return ((ComponentProcessor)this.requireComponent(IComponentType.Processor)).isActive(0);
    }

    public int getComparatorSignal() {
        return ((ComponentProcessor)this.requireComponent(IComponentType.Processor)).isActive(0) ? 15 : 0;
    }
}
