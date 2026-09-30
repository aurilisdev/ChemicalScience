package net.pastek.chemicalscience.common.tile;

import electrodynamics.registers.ElectrodynamicsSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.Container;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import net.pastek.chemicalscience.common.block.subtype.SubtypeChemicalMachine;
import net.pastek.chemicalscience.common.inventory.container.ContainerCircuitMaker;
import net.pastek.chemicalscience.common.inventory.container.ContainerHDSUnit;
import net.pastek.chemicalscience.common.recipe.categories.gasfluiditem2gasfluid.GasFluidItem2FluidRecipe;
import net.pastek.chemicalscience.registers.CSRecipies;
import net.pastek.chemicalscience.registers.CSTiles;
import voltaic.api.gas.GasAction;
import voltaic.api.gas.GasTank;
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

public class TileHDSUnit extends GenericGasTile implements ITickableSound {
    public static final int MAX_TANK_CAPACITY = 5000;
    private boolean isSoundPlaying = false;

    public TileHDSUnit(BlockPos worldPosition, BlockState blockState) {
	super(CSTiles.TILE_HDS_UNIT.get(), worldPosition, blockState);
	addComponent((new ComponentTickable(this)).tickClient(this::tickClient));
	addComponent((new ComponentElectrodynamic(this, false, true))
		.setInputDirections(new MachineDirection[] { MachineDirection.BOTTOM }).voltage(480.0F));
	addComponent((new ComponentFluidHandlerMulti(this)).setInputTanks(1, new int[] { 5000 })
		.setInputDirections(new MachineDirection[] { MachineDirection.LEFT })
		.setOutputTanks(1, new int[] { 5000 })
		.setOutputDirections(new MachineDirection[] { MachineDirection.RIGHT })
		.setRecipeType(CSRecipies.HDS_UNIT_TYPE.get()));
	addComponent((new ComponentGasHandlerMulti(this))
		.setInputTanks(1, new int[] { 5000 }, new int[] { 1000 }, new int[] { 1024 })
		.setInputDirections(new MachineDirection[] { MachineDirection.FRONT })
		.setOutputTanks(1, new int[] { 5000 }, new int[] { 1000 }, new int[] { 1024 })
		.setOutputDirections(new MachineDirection[] { MachineDirection.BACK })
		.setCondensedHandler(getCondensedHandler()));
	addComponent((new ComponentInventory(this,
		InventoryBuilder.newInv().processors(1, 1, 0, 0).bucketInputs(1).gasInputs(1).upgrades(3)))
		.setDirectionsBySlot(0, MachineDirection.TOP).validUpgrades(ContainerCircuitMaker.VALID_UPGRADES)
		.valid(machineValidator()));
	addComponent((new ComponentContainerProvider(SubtypeChemicalMachine.hdsunit.tag(), this))
		.createMenu((id, player) -> new ContainerHDSUnit(id, player,
			(Container) this.requireComponent(IComponentType.Inventory), this.getCoordsArray())));
	addComponent(new ComponentProcessor(this).canProcess(this::canProcess).process(this::process));
    }

    protected void tickClient(Level level, ComponentTickable tickable) {
	if (this.shouldPlaySound()) {
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
	pr.consumeBucket().consumeGasCylinder().dispenseGasCylinder().dispenseBucket().outputToGasPipe()
		.outputToFluidPipe();

	GasFluidItem2FluidRecipe recipe = pr.prepareRecipe(procNumber, CSRecipies.HDS_UNIT_TYPE.get(),
		GasFluidItem2FluidRecipe.class);

	if (recipe == null)
	    return false;

	ComponentElectrodynamic electro = requireComponent(IComponentType.Electrodynamic);

	if (electro.getJoulesStored() < pr.getUsage(procNumber))
	    return false;

	ComponentFluidHandlerMulti fluidHandler = requireComponent(IComponentType.FluidHandler);
	FluidTank[] fluidOutputs = fluidHandler.getOutputTanks();

	if (!recipe.getFluidIngredients().getFirst().test(fluidHandler.getInputTanks()[0].getFluid()))
	    return false;

	FluidStack fluidOutput = recipe.getFluidRecipeOutput();

	if (fluidOutputs[0].fill(fluidOutput, IFluidHandler.FluidAction.SIMULATE) < fluidOutput.getAmount())
	    return false;

	ComponentGasHandlerMulti gasHandler = requireComponent(IComponentType.GasHandler);
	GasTank[] gasOutputs = gasHandler.getOutputTanks();

	if (!recipe.getGasIngredients().getFirst().test(gasHandler.getInputTanks()[0].getGas()))
	    return false;

	return ComponentProcessor.hasRoomForGasBiproducts(gasOutputs, recipe.getFullGasBiStacks(), 0);
    }

    private void process(ComponentProcessor pr, Level level, int procNumber) {
	if (!(pr.getRecipe(procNumber) instanceof GasFluidItem2FluidRecipe recipe))
	    return;

	ComponentFluidHandlerMulti fluidHandler = requireComponent(IComponentType.FluidHandler);
	ComponentGasHandlerMulti gasHandler = requireComponent(IComponentType.GasHandler);

	fluidHandler.getOutputTanks()[0].fill(recipe.getFluidRecipeOutput(), IFluidHandler.FluidAction.EXECUTE);

	for (int i = 0; i < recipe.getGasBiproducts().size(); i++)
	    gasHandler.getOutputTanks()[i].fill(recipe.getGasBiproducts().get(i).roll(), GasAction.EXECUTE);

	fluidHandler.getInputTanks()[0].drain(recipe.getFluidIngredients().getFirst().getAmount(),
		IFluidHandler.FluidAction.EXECUTE);

	gasHandler.getInputTanks()[0].drain(recipe.getGasIngredients().getFirst().getGasStack().getAmount(),
		GasAction.EXECUTE);

	pr.setChanged();
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
