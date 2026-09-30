package net.pastek.chemicalscience.common.tile;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import net.neoforged.neoforge.items.IItemHandler;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.common.block.subtype.SubtypeChemicalMachine;
import net.pastek.chemicalscience.common.inventory.container.ContainerFractionatingColumn;
import net.pastek.chemicalscience.registers.CSRecipies;
import net.pastek.chemicalscience.registers.CSTiles;
import voltaic.api.IWrenchItem;
import voltaic.api.electricity.ICapabilityElectrodynamic;
import voltaic.api.multiblock.assemblybased.Multiblock;
import voltaic.api.multiblock.assemblybased.MultiblockSlaveNode;
import voltaic.api.multiblock.assemblybased.TileMultiblockController;
import voltaic.api.multiblock.assemblybased.TileMultiblockSlave;
import voltaic.common.block.states.VoltaicBlockStates;
import voltaic.common.network.utils.FluidUtilities;
import voltaic.prefab.properties.types.PropertyTypes;
import voltaic.prefab.properties.variant.SingleProperty;
import voltaic.prefab.tile.components.CapabilityInputType;
import voltaic.prefab.tile.components.IComponentType;
import voltaic.prefab.tile.components.type.ComponentContainerProvider;
import voltaic.prefab.tile.components.type.ComponentElectrodynamic;
import voltaic.prefab.tile.components.type.ComponentFluidHandlerMulti;
import voltaic.prefab.tile.components.type.ComponentInventory;
import voltaic.prefab.tile.components.type.ComponentProcessor;
import voltaic.prefab.tile.components.type.ComponentTickable;
import voltaic.prefab.tile.components.utils.IComponentFluidHandler;
import voltaic.prefab.utilities.BlockEntityUtils;
import voltaic.registers.VoltaicCapabilities;

public class TileFractionatingColumn extends TileMultiblockController {
    public static final ResourceLocation ID = ChemicalScience.rl("fractionatingcolumn");
    public static final ResourceKey<Multiblock> RESOURCE_KEY = Multiblock.makeKey(ID);
    public static final int MAX_INPUT_TANK_CAPACITY = 5000, MAX_OUTPUT_TANK_CAPACITY = 5000;

    public final SingleProperty<Integer> processAmount = property(
	    new SingleProperty<>(getPropertyManager(), PropertyTypes.INTEGER, "processamount", 0));
    public final SingleProperty<Double> operatingTicks = property(
	    new SingleProperty<>(getPropertyManager(), PropertyTypes.DOUBLE, "operatingticks", 0.0));
    public final SingleProperty<Double> neededTicks = property(
	    new SingleProperty<>(getPropertyManager(), PropertyTypes.DOUBLE, "neededticks", 0.0));
    public final SingleProperty<Boolean> isActive = property(
	    new SingleProperty<>(getPropertyManager(), PropertyTypes.BOOLEAN, "isactive", false));

//     private @Nullable FractionatingColumnRecipe currRecipe = null;

    public TileFractionatingColumn(BlockPos pos, BlockState state) {
	super(CSTiles.TILE_FRACTIONATING_COLUMN.get(), pos, state);
	addComponent(new ComponentElectrodynamic(this, false, true)
		.setInputDirections(BlockEntityUtils.MachineDirection.BACK)
		.voltage(VoltaicCapabilities.DEFAULT_VOLTAGE * 4));
	addComponent(new ComponentFluidHandlerMulti(this).setInputDirections(BlockEntityUtils.MachineDirection.RIGHT)
		.setInputTanks(1, arr(MAX_INPUT_TANK_CAPACITY))
		.setOutputDirections(BlockEntityUtils.MachineDirection.LEFT)
		.setOutputTanks(5, MAX_OUTPUT_TANK_CAPACITY, MAX_OUTPUT_TANK_CAPACITY, MAX_OUTPUT_TANK_CAPACITY,
			MAX_OUTPUT_TANK_CAPACITY, MAX_OUTPUT_TANK_CAPACITY)
		.setRecipeType(CSRecipies.FRACTIONATING_COLUMN_TYPE.get()));
	addComponent(new ComponentContainerProvider(SubtypeChemicalMachine.fractionatingcolumn.tag(), this)
		.createMenu((id, player) -> new ContainerFractionatingColumn(id, player,
			requireComponent(IComponentType.Inventory), getCoordsArray())));
	addComponent(new ComponentInventory(this,
		ComponentInventory.InventoryBuilder.newInv().bucketInputs(1).bucketOutputs(5).upgrades(3))
		.validUpgrades(ContainerFractionatingColumn.VALID_UPGRADES).valid(machineValidator()));
	addComponent(new ComponentProcessor(this).canProcess(this::canProcess)
		.process(ComponentProcessor::processFluid2FluidRecipe));
    }

    private boolean canProcess(ComponentProcessor pr, Level level, int procNumber) {
	outputToPipe(level);
	return pr.canProcessFluid2FluidRecipe(level, procNumber, CSRecipies.FRACTIONATING_COLUMN_TYPE.get());
    }

    @Override
    public void tickServer(Level level, ComponentTickable tickable) {
	super.tickServer(level, tickable);

	ComponentFluidHandlerMulti fluidHandler = requireComponent(IComponentType.FluidHandler);

	FluidUtilities.drainItem(this, fluidHandler.getInputTanks());
	FluidUtilities.fillItem(this, fluidHandler.getOutputTanks());
    }

    private void outputToPipe(Level level) {
	ComponentFluidHandlerMulti component = requireComponent(IComponentType.FluidHandler);
	Direction facing = getFacing();

	Direction[] outputDirections = component.outputDirections;
	int[] yOffsets = { 2, 4, 6, 8, 10 };
	FluidTank[] tanks = component.getOutputTanks();

	for (Direction relative : outputDirections) {
	    Direction direction = BlockEntityUtils.getRelativeSide(facing, relative);

	    for (int tankIndex = 0; tankIndex < yOffsets.length; tankIndex++) {
		if (tankIndex >= tanks.length)
		    break;

		Vec3 offset = getOffset(facing);
		BlockPos pipePos = getBlockPos().relative(direction).offset((int) offset.x, yOffsets[tankIndex],
			(int) offset.z);
		BlockEntity faceTile = level.getBlockEntity(pipePos);

		if (faceTile == null)
		    continue;

		IFluidHandler handler = level.getCapability(Capabilities.FluidHandler.BLOCK, faceTile.getBlockPos(),
			faceTile.getBlockState(), faceTile, direction.getOpposite());

		if (handler == null)
		    continue;

		FluidTank fluidTank = tanks[tankIndex];
		FluidStack tankFluid = fluidTank.getFluid();

		if (!tankFluid.isEmpty()) {
		    int amtAccepted = handler.fill(tankFluid, IFluidHandler.FluidAction.EXECUTE);
		    FluidStack taken = new FluidStack(tankFluid.getFluid(), amtAccepted);
		    fluidTank.drain(taken, IFluidHandler.FluidAction.EXECUTE);
		}
	    }
	}
    }

    private static Vec3 getOffset(Direction facing) {
	return switch (facing) {
	case SOUTH -> new Vec3(1, 0, -1);
	case WEST -> new Vec3(1, 0, 1);
	case EAST -> new Vec3(-1, 0, -1);
	case NORTH -> new Vec3(-1, 0, 1);
	default -> Vec3.ZERO;
	};
    }

    @Override
    public @Nullable IFluidHandler getFluidHandlerCapability(@Nullable Direction side) {
	return null;
    }

    @Nullable
    @Override
    public IFluidHandler getSlaveFluidHandlerCapability(TileMultiblockSlave slave, @Nullable Direction side) {
	if (slave.index.getValue() != 12 && slave.index.getValue() != 29 && slave.index.getValue() != 47
		&& slave.index.getValue() != 65 && slave.index.getValue() != 83 && slave.index.getValue() != 101) {
	    return null;
	}
	return this.<IComponentFluidHandler>requireComponent(IComponentType.FluidHandler).getCapability(side,
		CapabilityInputType.NONE);
    }

    @Override
    public @Nullable ICapabilityElectrodynamic getElectrodynamicCapability(@Nullable Direction side) {
	return null;
    }

    @Nullable
    @Override
    public ICapabilityElectrodynamic getSlaveCapabilityElectrodynamic(TileMultiblockSlave slave,
	    @Nullable Direction side) {
	if (slave.index.getValue() != 8) {
	    return null;
	}
	return this.<ComponentElectrodynamic>requireComponent(IComponentType.Electrodynamic).getCapability(side,
		CapabilityInputType.NONE);
    }

    @Override
    public @Nullable IItemHandler getItemHandlerCapability(@Nullable Direction side) {
	return null;
    }

    @Override
    public ItemInteractionResult useWithItem(Level level, ItemStack used, Player player, InteractionHand hand,
	    BlockHitResult hit) {
	if (!level.isClientSide() && hit.getBlockPos().equals(getBlockPos()) && used.getItem() instanceof IWrenchItem) {
	    checkFormed();
	    if (isFormed.getValue())
		formMultiblock(level);
	    else
		destroyMultiblock(level);
	    return ItemInteractionResult.CONSUME;
	}
	return super.useWithItem(level, used, player, hand, hit);
    }

    @Override
    public InteractionResult useWithoutItem(Level level, Player player, BlockHitResult hit) {
	return isFormed.getValue() ? super.useWithoutItem(level, player, hit) : InteractionResult.FAIL;
    }

    @Override
    public void formMultiblock(Level level) {
	Direction facing = this.getFacing().getOpposite();
	List<MultiblockSlaveNode> nodes = Multiblock.getNodes(level, this.getResourceKey(), facing);
	int index = 0;

	for (MultiblockSlaveNode node : nodes) {
	    BlockPos nodePos = this.getBlockPos().offset(node.offset());
	    this.slavePositions.addValue(nodePos, index);

	    BlockState placedState = node.placeState().setValue(VoltaicBlockStates.FACING, this.getFacing());
	    level.setBlockAndUpdate(nodePos, placedState);

	    TileMultiblockSlave slave = (TileMultiblockSlave) level.getBlockEntity(nodePos);
	    if (slave != null) {
		BlockState disguise = node.replaceState();
		slave.setDisguise(disguise);

		slave.controller.setValue(this.getBlockPos());
		slave.index.setValue(index);
		slave.renderModel.setValue(node.model());
		this.slaveList.add(slave);
	    } else {
		ChemicalScience.LOGGER.warn("Failed to get TileMultiblockSlave at {}", nodePos);
	    }

	    ++index;
	}

	level.playSound((Player) null, this.getBlockPos(), SoundEvents.ANVIL_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
    }

    @Override
    public ResourceLocation getMultiblockId() {
	return ID;
    }

    @Override
    public ResourceKey<Multiblock> getResourceKey() {
	return RESOURCE_KEY;
    }
}
