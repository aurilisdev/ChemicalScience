package net.pastek.chemicalscience.common.tile;

import electrodynamics.prefab.utilities.ElectricityUtils;
import electrodynamics.registers.ElectrodynamicsSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.Container;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities.FluidHandler;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler.FluidAction;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import net.pastek.chemicalscience.common.block.subtype.SubtypeChemicalMachine;
import net.pastek.chemicalscience.common.inventory.container.ContainerFuelCell;
import net.pastek.chemicalscience.common.settings.CSConstants;
import net.pastek.chemicalscience.registers.CSTags;
import net.pastek.chemicalscience.registers.CSTiles;
import voltaic.api.electricity.generator.IElectricGenerator;
import voltaic.common.network.utils.FluidUtilities;
import voltaic.prefab.properties.types.PropertyTypes;
import voltaic.prefab.properties.variant.SingleProperty;
import voltaic.prefab.sound.ITickableSound;
import voltaic.prefab.sound.SoundBarrierMethods;
import voltaic.prefab.tile.components.IComponentType;
import voltaic.prefab.tile.components.type.ComponentContainerProvider;
import voltaic.prefab.tile.components.type.ComponentElectrodynamic;
import voltaic.prefab.tile.components.type.ComponentFluidHandlerMulti;
import voltaic.prefab.tile.components.type.ComponentInventory;
import voltaic.prefab.tile.components.type.ComponentInventory.InventoryBuilder;
import voltaic.prefab.tile.components.type.ComponentTickable;
import voltaic.prefab.tile.types.GenericMaterialTile;
import voltaic.prefab.utilities.BlockEntityUtils.MachineDirection;
import voltaic.prefab.utilities.object.TransferPack;
import voltaic.registers.VoltaicCapabilities;

public class TileFuelCell extends GenericMaterialTile implements IElectricGenerator, ITickableSound {
    public static final int TANK_CAPACITY = 5000;
    public SingleProperty<Boolean> running;
    public SingleProperty<Integer> burnTime;
   // private SingleProperty<Double> multiplier;
    private SingleProperty<Boolean> hasRedstoneSignal;
    private boolean isSoundPlaying;

    public TileFuelCell(BlockPos worldPosition, BlockState blockState) {
	super(CSTiles.TILE_FUELCELL.get(), worldPosition, blockState);
	this.running = this.property(new SingleProperty(getPropertyManager(), PropertyTypes.BOOLEAN, "running", false));
	this.burnTime = this.property(new SingleProperty(getPropertyManager(), PropertyTypes.INTEGER, "burnTime", 0));
	this.hasRedstoneSignal = this
		.property(new SingleProperty(getPropertyManager(), PropertyTypes.BOOLEAN, "redstonesignal", false));
	this.isSoundPlaying = false;
	this.addComponent((new ComponentTickable(this)).tickServer(this::tickServer).tickClient(this::tickClient));
	this.addComponent(new ComponentElectrodynamic(this, true, false)
		.voltage(VoltaicCapabilities.DEFAULT_VOLTAGE * 2).setOutputDirections(MachineDirection.LEFT));
	this.addComponent(
		new ComponentInventory(this, InventoryBuilder.newInv().bucketInputs(1)).valid((slot, stack, i) -> {
		    return stack.getCapability(FluidHandler.ITEM) != null;
		}));
	this.addComponent(new ComponentFluidHandlerMulti(this).setInputTanks(1, arr(TANK_CAPACITY))
		.setInputFluidTags(CSTags.Fluids.HYDROGEN).setInputDirections(MachineDirection.RIGHT));
	this.addComponent((new ComponentContainerProvider(SubtypeChemicalMachine.fuelcell.tag(), this))
		.createMenu((id, player) -> {
		    return new ContainerFuelCell(id, player,
			    (Container) this.requireComponent(IComponentType.Inventory), this.getCoordsArray());
		}));
    }

    protected void tickServer(Level level, ComponentTickable tickable) {
	if (hasRedstoneSignal.getValue()) {
	    running.setValue(false);
	    return;
	}

	Direction facing = getFacing();

	ComponentFluidHandlerMulti handler = requireComponent(IComponentType.FluidHandler);
	FluidUtilities.drainItem(this, handler.getInputTanks());

	FluidTank tank = handler.getInputTanks()[0];

	if (burnTime.getValue() <= 0) {
	    running.setValue(false);

	    if (tank.getFluidAmount() > 0) {
		tank.drain(new FluidStack(tank.getFluid().getFluid(), 1), FluidAction.EXECUTE);
		running.setValue(true);
		burnTime.setValue(3);
	    }
	} else {
	    running.setValue(true);
	}

	if (burnTime.getValue() > 0)
	    burnTime.setValue(burnTime.getValue() - 1);

	if (!running.getValue() || burnTime.getValue() <= 0)
	    return;

	BlockEntity output = level.getBlockEntity(worldPosition.relative(facing.getClockWise()));

	if (output != null)
	    ElectricityUtils.receivePower(output, facing.getClockWise().getOpposite(), getProduced(), false);
    }

    protected void tickClient(Level level, ComponentTickable tickable) {
	if (this.running.getValue()) {
	    if (level.random.nextDouble() < 0.15) {
		level.addParticle(ParticleTypes.BUBBLE, this.worldPosition.getX() + level.random.nextDouble(),
			this.worldPosition.getY() + level.random.nextDouble(),
			this.worldPosition.getZ() + level.random.nextDouble(), 0.0, 0.0, 0.0);
	    }

	    if (!this.isSoundPlaying) {
		this.isSoundPlaying = true;
		SoundBarrierMethods.playTileSound(ElectrodynamicsSounds.SOUND_HUM.get(), this, true);
	    }

	}
    }

    @Override
    public void setNotPlaying() {
	this.isSoundPlaying = false;
    }

    @Override
    public boolean shouldPlaySound() {
	return this.running.getValue();
    }

    @Override
    public void setMultiplier(double val) {
//	this.multiplier.setValue(val);
    }

    @Override
    public double getMultiplier() {
//	return (Double) this.multiplier.getValue();
	return 1.0;
    }

    @Override
    public TransferPack getProduced() {
	return TransferPack.joulesVoltage(CSConstants.FUEL_CELL_JOULES_PER_TICK, 240);
    }

    public int getComparatorSignal() {
	return this.running.getValue() ? 15 : 0;
    }
}
