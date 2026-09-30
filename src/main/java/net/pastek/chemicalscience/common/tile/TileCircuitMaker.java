package net.pastek.chemicalscience.common.tile;

import electrodynamics.registers.ElectrodynamicsSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.pastek.chemicalscience.common.block.subtype.SubtypeChemicalMachine;
import net.pastek.chemicalscience.common.inventory.container.ContainerCircuitMaker;
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

public class TileCircuitMaker extends GenericMaterialTile implements ITickableSound {
    public static final int MAX_TANK_CAPACITY = 5000;
    private boolean isSoundPlaying = false;

    public TileCircuitMaker(BlockPos worldPosition, BlockState blockState) {
        super(CSTiles.TILE_CIRCUIT_MAKER.get(), worldPosition, blockState);
        this.addComponent((new ComponentTickable(this)).tickClient(this::tickClient));
        this.addComponent((new ComponentElectrodynamic(this, false, true)).setInputDirections(new BlockEntityUtils.MachineDirection[]{MachineDirection.BACK}).voltage(480.0F));
        this.addComponent((new ComponentFluidHandlerMulti(this)).setInputTanks(1, new int[]{5000}).setInputDirections(new BlockEntityUtils.MachineDirection[]{MachineDirection.RIGHT}).setRecipeType(CSRecipies.CIRCUIT_MAKER_TYPE.get()));
        this.addComponent((new ComponentInventory(this, InventoryBuilder.newInv().processors(1, 5, 1, 0).bucketInputs(1).upgrades(3))).setSlotsByDirection(MachineDirection.TOP, 0, 1, 2, 3, 4).setDirectionsBySlot(5,MachineDirection.BOTTOM, MachineDirection.LEFT, MachineDirection.FRONT).validUpgrades(ContainerCircuitMaker.VALID_UPGRADES).valid(machineValidator()));
        this.addComponent((new ComponentContainerProvider(SubtypeChemicalMachine.circuitmaker.tag(), this)).createMenu((id, player) -> new ContainerCircuitMaker(id, player, requireComponent(IComponentType.Inventory), getCoordsArray())));
        this.addComponent((new ComponentProcessor(this)).canProcess(this::canProcessCircuitMaker).process(ComponentProcessor::processFluidItem2ItemRecipe));
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

    public boolean canProcessCircuitMaker(ComponentProcessor pr, Level level, int procNumber) {
        boolean canProcess = pr.consumeBucket().canProcessFluidItem2ItemRecipe(level, procNumber, CSRecipies.CIRCUIT_MAKER_TYPE.get());
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
