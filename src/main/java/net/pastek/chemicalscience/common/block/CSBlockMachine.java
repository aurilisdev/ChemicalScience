package net.pastek.chemicalscience.common.block;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item.TooltipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import voltaic.api.tile.IMachine;
import voltaic.common.block.BlockMachine;
import voltaic.common.block.states.VoltaicBlockStates;

public class CSBlockMachine extends BlockMachine {
    protected final IMachine machine;
    private final int voltage;
    private final @Nullable Component description;

    public CSBlockMachine(IMachine machine, int voltage, Component description) {
	super(machine);
	this.machine = machine;
	this.voltage = voltage;
	this.description = description;
	if (machine.usesLit()) {
	    this.registerDefaultState(this.stateDefinition.any().setValue(VoltaicBlockStates.LIT, false));
	}

    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents,
	    TooltipFlag tooltipFlag) {
	super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);

	if (voltage > 0) {
	    tooltipComponents.add(Component.translatable("tooltip.chemicalscience.machine.voltage")
		    .withStyle(ChatFormatting.DARK_GRAY)
		    .append(Component.literal(voltage + "V").withStyle(ChatFormatting.GRAY)));
	}
	Component parDescription = description;
	if (parDescription != null) {

	    if (parDescription.getString().equalsIgnoreCase("multiblock")) {
		tooltipComponents.add(Component.translatable("tooltip.chemicalscience.machine.multiblock.info")
			.withStyle(ChatFormatting.GREEN));
		tooltipComponents.add(Component.translatable("tooltip.chemicalscience.machine.multiblock.help")
			.withStyle(ChatFormatting.GRAY));
	    } else {
		tooltipComponents.add(parDescription.copy().withStyle(ChatFormatting.GRAY));
	    }
	}
    }
}
