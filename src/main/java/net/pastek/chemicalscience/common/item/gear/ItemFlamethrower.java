package net.pastek.chemicalscience.common.item.gear;

import java.util.List;

import org.jetbrains.annotations.NotNull;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.protocol.game.ClientboundContainerSetSlotPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler.FluidAction;
import net.neoforged.neoforge.fluids.capability.IFluidHandlerItem;
import net.pastek.chemicalscience.common.entity.projectile.EntityFlameStream;
import net.pastek.chemicalscience.common.reloadlistener.FlamethrowerFuelManager;
import net.pastek.chemicalscience.registers.CSCreativeTabs;
import voltaic.api.electricity.formatting.ChatFormatter;
import voltaic.common.item.ItemVoltaic;
import voltaic.prefab.utilities.VoltaicTextUtils;

public class ItemFlamethrower extends ItemVoltaic {

    public static final int MAX_CAPACITY = 5000;
    boolean debug = false;

    public ItemFlamethrower() {
	super(new Item.Properties().stacksTo(1).fireResistant(), CSCreativeTabs.CHEMICAL_SCIENCE_TAB);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
	ItemStack stack = player.getItemInHand(hand);
	IFluidHandlerItem handler = stack.getCapability(Capabilities.FluidHandler.ITEM);
	if (handler == null)
	    return InteractionResultHolder.fail(stack);

	FluidStack fluidInTank = handler.getFluidInTank(0);
	if (fluidInTank.isEmpty())
	    return InteractionResultHolder.fail(stack);

	FlamethrowerFuelManager.FuelInfo info = FlamethrowerFuelManager.INSTANCE.getFuelInfo(fluidInTank.getFluid());

	if (info == null || fluidInTank.getAmount() < info.mBPerDrain()) {
	    return InteractionResultHolder.fail(stack);
	}

	player.startUsingItem(hand);
	return InteractionResultHolder.consume(stack);
    }

    @Override
    public void onUseTick(Level level, LivingEntity livingEntity, ItemStack stack, int remainingUseDuration) {
	if (!(livingEntity instanceof Player player))
	    return;

	IFluidHandlerItem handler = stack.getCapability(Capabilities.FluidHandler.ITEM);
	if (handler == null)
	    return;

	FluidStack fluidInTank = handler.getFluidInTank(0);
	FlamethrowerFuelManager.FuelInfo info = FlamethrowerFuelManager.INSTANCE.getFuelInfo(fluidInTank.getFluid());

	if (info == null || fluidInTank.getAmount() < info.mBPerDrain()) {
	    player.stopUsingItem();
	    return;
	}

	if (remainingUseDuration % 2 == 0) {
	    if (!level.isClientSide) {
		EntityFlameStream flame = getEntityFlameStream(level, player, info);
		level.addFreshEntity(flame);
	    }
	}

	if (remainingUseDuration % info.ticksPerDrain() == 0) {
	    handler.drain(info.mBPerDrain(), FluidAction.EXECUTE);
	}

    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entity, int timeLeft) {
	if (!level.isClientSide && entity instanceof ServerPlayer serverPlayer) {
	    syncStackToClient(serverPlayer, stack);
	}
    }

    @SuppressWarnings("static-method")
    private void syncStackToClient(ServerPlayer serverPlayer, ItemStack stack) {
	int slotIndex = -1;
	for (int i = 0; i < serverPlayer.containerMenu.slots.size(); i++) {
	    if (serverPlayer.containerMenu.slots.get(i).getItem() == stack) {
		slotIndex = i;
		break;
	    }
	}

	if (slotIndex != -1) {
	    serverPlayer.connection.send(new ClientboundContainerSetSlotPacket(serverPlayer.containerMenu.containerId,
		    serverPlayer.containerMenu.incrementStateId(), slotIndex, stack));
	}
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
	if (slotChanged)
	    return true;
	return !ItemStack.isSameItem(oldStack, newStack);
    }

    private static @NotNull EntityFlameStream getEntityFlameStream(Level level, Player player,
	    FlamethrowerFuelManager.FuelInfo info) {
	EntityFlameStream flame = new EntityFlameStream(level, player, info);

	Vec3 look = player.getLookAngle();
	double forwardOffset = 1.2;
	double x = player.getX() + look.x * forwardOffset;
	double y = player.getEyePosition(1.0f).y - 0.2 + look.y * forwardOffset;
	double z = player.getZ() + look.z * forwardOffset;

	flame.setPos(x, y, z);

	flame.shoot(look.x, look.y, look.z, 1.0F, 1.0F);
	return flame;
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
	return UseAnim.NONE;
    }

    @Override
    public void addCreativeModeItems(CreativeModeTab tab, List<ItemStack> items) {
	super.addCreativeModeItems(tab, items);
    }

    public static java.util.function.Predicate<FluidStack> getPredicate() {
	return fluidStack -> FlamethrowerFuelManager.INSTANCE.getFuelInfo(fluidStack.getFluid()) != null;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
	IFluidHandlerItem handler = stack.getCapability(Capabilities.FluidHandler.ITEM);
	if (handler == null) {
	    if (debug)
		tooltip.add(Component.literal("DEBUG: Capability MISSING!").withStyle(ChatFormatting.RED));
	    super.appendHoverText(stack, context, tooltip, flagIn);
	    return;
	}
	FluidStack fluid = handler.getFluidInTank(0);

	if (debug) {
	    tooltip.add(Component.literal("DEBUG: Capability Detected").withStyle(ChatFormatting.DARK_GREEN));

	    int fuelCount = FlamethrowerFuelManager.INSTANCE.getFuelMapSize();
	    tooltip.add(Component.literal("DEBUG: Fuels Loaded: " + fuelCount)
		    .withStyle(fuelCount > 0 ? ChatFormatting.DARK_GREEN : ChatFormatting.RED));

	    if (!fluid.isEmpty()) {
		FlamethrowerFuelManager.FuelInfo info = FlamethrowerFuelManager.INSTANCE.getFuelInfo(fluid.getFluid());
		if (info != null) {
		    tooltip.add(Component.literal("DEBUG: Valid fuel").withStyle(ChatFormatting.GREEN));
		    tooltip.add(Component.literal("Damage: " + info.damage()).withStyle(ChatFormatting.RED));
		} else {
		    tooltip.add(Component.literal("DEBUG: Invalid fuel").withStyle(ChatFormatting.DARK_RED));
		}
	    }
	}

	if (!fluid.isEmpty()) {
	    FlamethrowerFuelManager.FuelInfo info = FlamethrowerFuelManager.INSTANCE.getFuelInfo(fluid.getFluid());
	    int fuelColor = (info != null) ? info.color() : 0xFFAAAAAA;
	    tooltip.add(Component.translatable("tooltip.chemicalscience.flamethrower.fluid")
		    .withStyle(ChatFormatting.DARK_GRAY)
		    .append(fluid.getFluidType().getDescription().copy().withStyle(Style.EMPTY.withColor(fuelColor))));
	    if (info != null) {
		tooltip.add(Component.translatable("tooltip.chemicalscience.flamethrower.damage")
			.withStyle(ChatFormatting.DARK_GRAY).append(Component
				.literal(String.format("%.1f", info.damage())).withStyle(ChatFormatting.GRAY)));
		float mbPerSec = (20.0f / info.ticksPerDrain()) * info.mBPerDrain();
		tooltip.add(Component.translatable("tooltip.chemicalscience.flamethrower.usage")
			.withStyle(ChatFormatting.DARK_GRAY).append(Component
				.literal(String.format("%.1f mB/s", mbPerSec)).withStyle(ChatFormatting.GRAY)));
	    }
	}

	tooltip.add(VoltaicTextUtils.ratio(ChatFormatter.formatFluidMilibuckets(fluid.getAmount()),
		ChatFormatter.formatFluidMilibuckets(MAX_CAPACITY)).withStyle(ChatFormatting.GRAY));

	super.appendHoverText(stack, context, tooltip, flagIn);
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
	return 72000;
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
	return staticIsBarVisible(stack);
    }

    protected static boolean staticIsBarVisible(ItemStack stack) {
	IFluidHandlerItem handler = stack.getCapability(Capabilities.FluidHandler.ITEM);
	if (handler == null)
	    return false;
	return !handler.getFluidInTank(0).isEmpty();
    }

    @Override
    public int getBarWidth(ItemStack stack) {
	IFluidHandlerItem handler = stack.getCapability(Capabilities.FluidHandler.ITEM);
	if (handler == null)
	    return 13;
	return (int) (13.0 * handler.getFluidInTank(0).getAmount() / handler.getTankCapacity(0));
    }
}