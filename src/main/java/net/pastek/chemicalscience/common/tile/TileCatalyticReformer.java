package net.pastek.chemicalscience.common.tile;

import electrodynamics.registers.ElectrodynamicsSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.Container;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.pastek.chemicalscience.common.block.subtype.SubtypeChemicalMachine;
import net.pastek.chemicalscience.common.inventory.container.ContainerCatalyticReformer;
import net.pastek.chemicalscience.registers.CSRecipies;
import net.pastek.chemicalscience.registers.CSTiles;
import voltaic.prefab.sound.ITickableSound;
import voltaic.prefab.sound.SoundBarrierMethods;
import voltaic.prefab.tile.components.IComponentType;
import voltaic.prefab.tile.components.type.ComponentContainerProvider;
import voltaic.prefab.tile.components.type.ComponentElectrodynamic;
import voltaic.prefab.tile.components.type.ComponentFluidHandlerMulti;
import voltaic.prefab.tile.components.type.ComponentGasHandlerMulti;
import voltaic.prefab.tile.components.type.ComponentInventory;
import voltaic.prefab.tile.components.type.ComponentInventory.InventoryBuilder;
import voltaic.prefab.tile.components.type.ComponentProcessor;
import voltaic.prefab.tile.components.type.ComponentTickable;
import voltaic.prefab.tile.types.GenericGasTile;
import voltaic.prefab.utilities.BlockEntityUtils.MachineDirection;

public class TileCatalyticReformer extends GenericGasTile implements ITickableSound {
    public static final int MAX_TANK_CAPACITY = 5000;
    private boolean isSoundPlaying = false;

    public TileCatalyticReformer(BlockPos worldPosition, BlockState blockState) {
	super(CSTiles.TILE_CATALYTIC_REFORMER.get(), worldPosition, blockState);
	addComponent((new ComponentTickable(this)).tickClient(this::tickClient));
	addComponent((new ComponentElectrodynamic(this, false, true))
		.setInputDirections(new MachineDirection[] { MachineDirection.BOTTOM }).voltage(480.0F));
	addComponent((new ComponentFluidHandlerMulti(this)).setInputTanks(1, MAX_TANK_CAPACITY)
		.setInputDirections(new MachineDirection[] { MachineDirection.LEFT })
		.setOutputTanks(2, MAX_TANK_CAPACITY, MAX_TANK_CAPACITY)
		.setOutputDirections(MachineDirection.RIGHT, MachineDirection.BACK)
		.setRecipeType(CSRecipies.CATALYTIC_REFORMER_TYPE.get()));
	addComponent((new ComponentGasHandlerMulti(this))
		.setOutputTanks(1, new int[] { 5000 }, new int[] { 1000 }, new int[] { 1024 })
		.setOutputDirections(new MachineDirection[] { MachineDirection.TOP })
		.setCondensedHandler(getCondensedHandler()));
	addComponent((new ComponentInventory(this,
		InventoryBuilder.newInv().processors(1, 1, 0, 1).bucketInputs(1).bucketOutputs(2).gasOutputs(1)
			.upgrades(3)))
		.setDirectionsBySlot(1, MachineDirection.FRONT).validUpgrades(ContainerCatalyticReformer.VALID_UPGRADES)
		.valid(machineValidator()));
	addComponent((new ComponentContainerProvider(SubtypeChemicalMachine.catalyticreformer.tag(), this))
		.createMenu((id, player) -> new ContainerCatalyticReformer(id, player,
			(Container) this.requireComponent(IComponentType.Inventory), this.getCoordsArray())));
	addComponent(new ComponentProcessor(this).canProcess(this::canProcess)
		.process(ComponentProcessor::processFluidItem2FluidRecipe));
    }

    protected void tickClient(Level level, ComponentTickable tickable) {
	if (this.shouldPlaySound()) {
//	    ComponentGasHandlerMulti gasHandler = requireComponent(IComponentType.GasHandler);
	    if (level.random.nextDouble() < 0.15) {
		Direction direction = this.getFacing();
		double d4 = level.random.nextDouble();
		double d5 = direction.getAxis() == Direction.Axis.X
			? (double) (direction.getStepX() * (direction.getStepX() == -1 ? 0 : 1))
			: d4;
		double d6 = level.random.nextDouble();
		double d7 = direction.getAxis() == Direction.Axis.Z
			? (double) (direction.getStepZ() * (direction.getStepZ() == -1 ? 0 : 1))
			: d4;
		level.addParticle(ParticleTypes.SMOKE, this.worldPosition.getX() + d5,
			this.worldPosition.getY() + d6, this.worldPosition.getZ() + d7, 0.0F,
			0.0F, 0.0F);
	    }
	    if (!this.isSoundPlaying) {
		this.isSoundPlaying = true;
		SoundBarrierMethods.playTileSound(ElectrodynamicsSounds.SOUND_HUM.get(), this, true);
	    }

	}
    }

    private boolean canProcess(ComponentProcessor pr, Level level, int procNumber) {
	pr.consumeBucket().dispenseGasCylinder().dispenseBucket().outputToGasPipe().outputToFluidPipe();
	return pr.canProcessFluidItem2FluidRecipe(level, procNumber, CSRecipies.CATALYTIC_REFORMER_TYPE.get());
    }

    @Override
    public void setNotPlaying() {
	this.isSoundPlaying = false;
    }

    @Override
    public boolean shouldPlaySound() {
	return ((ComponentProcessor) this.requireComponent(IComponentType.Processor)).isActive(0);
    }

    public int getComparatorSignal() {
	return ((ComponentProcessor) this.requireComponent(IComponentType.Processor)).isActive(0) ? 15 : 0;
    }
}
