package net.pastek.chemicalscience.compatibility.jei.recipecategories.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.neoforge.NeoForgeTypes;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.fluids.FluidStack;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.common.recipe.categories.misc.ChemicalBenchRecipe;
import net.pastek.chemicalscience.prefab.screen.CSBackgroundObject;
import net.pastek.chemicalscience.prefab.screen.CSTextures;
import net.pastek.chemicalscience.prefab.utils.CSTextUtils;
import net.pastek.chemicalscience.registers.CSBlocks;
import voltaic.api.gas.GasStack;
import voltaic.common.recipe.recipeutils.FluidIngredient;
import voltaic.common.recipe.recipeutils.GasIngredient;
import voltaic.compatibility.jei.recipecategories.AbstractRecipeCategory;
import voltaic.compatibility.jei.utils.gui.types.ArrowAnimatedObject;
import voltaic.compatibility.jei.utils.gui.types.BackgroundObject;
import voltaic.compatibility.jei.utils.gui.types.ItemSlotObject;
import voltaic.compatibility.jei.utils.gui.types.fluidgauge.AbstractFluidGaugeObject;
import voltaic.compatibility.jei.utils.gui.types.fluidgauge.FluidGaugeObject;
import voltaic.compatibility.jei.utils.gui.types.gasgauge.AbstractGasGaugeObject;
import voltaic.compatibility.jei.utils.gui.types.gasgauge.GasGaugeObject;
import voltaic.compatibility.jei.utils.ingredients.IngredientRendererGasStack;
import voltaic.compatibility.jei.utils.ingredients.VoltaicJeiTypes;
import voltaic.compatibility.jei.utils.label.types.PowerLabelWrapperElectroRecipe;
import voltaic.compatibility.jei.utils.label.types.TimeLabelWrapperElectroRecipe;
import voltaic.prefab.screen.component.types.ScreenComponentProgress;
import voltaic.prefab.screen.component.types.ScreenComponentSlot;
import voltaic.prefab.utilities.math.MathUtils;

public class ChemicalBenchRecipeCategory extends AbstractRecipeCategory<ChemicalBenchRecipe> {
    public static final BackgroundObject BACK_WRAP = new CSBackgroundObject(176, 160, CSTextures.CHEMICAL_BENCH_JEI);

    public static final ItemSlotObject INPUT_SLOT_1 = new ItemSlotObject(ScreenComponentSlot.SlotType.NORMAL, 7, 105,
	    RecipeIngredientRole.INPUT);
    public static final ItemSlotObject INPUT_SLOT_2 = new ItemSlotObject(ScreenComponentSlot.SlotType.NORMAL, 25, 105,
	    RecipeIngredientRole.INPUT);
    public static final ItemSlotObject INPUT_SLOT_3 = new ItemSlotObject(ScreenComponentSlot.SlotType.NORMAL, 43, 105,
	    RecipeIngredientRole.INPUT);
    public static final ItemSlotObject INPUT_SLOT_4 = new ItemSlotObject(ScreenComponentSlot.SlotType.NORMAL, 61, 105,
	    RecipeIngredientRole.INPUT);
    public static final ItemSlotObject INPUT_SLOT_5 = new ItemSlotObject(ScreenComponentSlot.SlotType.NORMAL, 25, 123,
	    RecipeIngredientRole.INPUT);
    public static final ItemSlotObject INPUT_SLOT_6 = new ItemSlotObject(ScreenComponentSlot.SlotType.NORMAL, 43, 123,
	    RecipeIngredientRole.INPUT);
    public static final ItemSlotObject OUTPUT_SLOT_1 = new ItemSlotObject(ScreenComponentSlot.SlotType.NORMAL, 97, 105,
	    RecipeIngredientRole.OUTPUT);
    public static final ItemSlotObject OUTPUT_SLOT_2 = new ItemSlotObject(ScreenComponentSlot.SlotType.NORMAL, 115, 105,
	    RecipeIngredientRole.OUTPUT);
    public static final ItemSlotObject OUTPUT_SLOT_3 = new ItemSlotObject(ScreenComponentSlot.SlotType.NORMAL, 133, 105,
	    RecipeIngredientRole.OUTPUT);
    public static final ItemSlotObject OUTPUT_SLOT_4 = new ItemSlotObject(ScreenComponentSlot.SlotType.NORMAL, 151, 105,
	    RecipeIngredientRole.OUTPUT);
    public static final ItemSlotObject OUTPUT_SLOT_5 = new ItemSlotObject(ScreenComponentSlot.SlotType.NORMAL, 115, 123,
	    RecipeIngredientRole.OUTPUT);
    public static final ItemSlotObject OUTPUT_SLOT_6 = new ItemSlotObject(ScreenComponentSlot.SlotType.NORMAL, 133, 123,
	    RecipeIngredientRole.OUTPUT);
    public static final FluidGaugeObject IN_FLUID_GAUGE_1 = new FluidGaugeObject(9, 5);
    public static final FluidGaugeObject IN_FLUID_GAUGE_2 = new FluidGaugeObject(27, 5);
    public static final FluidGaugeObject IN_FLUID_GAUGE_3 = new FluidGaugeObject(45, 5);
    public static final FluidGaugeObject IN_FLUID_GAUGE_4 = new FluidGaugeObject(63, 5);
    public static final FluidGaugeObject OUT_FLUID_GAUGE_1 = new FluidGaugeObject(99, 5);
    public static final FluidGaugeObject OUT_FLUID_GAUGE_2 = new FluidGaugeObject(117, 5);
    public static final FluidGaugeObject OUT_FLUID_GAUGE_3 = new FluidGaugeObject(135, 5);
    public static final FluidGaugeObject OUT_FLUID_GAUGE_4 = new FluidGaugeObject(153, 5);
    public static final GasGaugeObject IN_GAS_GAUGE_1 = new GasGaugeObject(9, 55);
    public static final GasGaugeObject IN_GAS_GAUGE_2 = new GasGaugeObject(27, 55);
    public static final GasGaugeObject IN_GAS_GAUGE_3 = new GasGaugeObject(45, 55);
    public static final GasGaugeObject IN_GAS_GAUGE_4 = new GasGaugeObject(63, 55);
    public static final GasGaugeObject OUT_GAS_GAUGE_1 = new GasGaugeObject(99, 55);
    public static final GasGaugeObject OUT_GAS_GAUGE_2 = new GasGaugeObject(117, 55);
    public static final GasGaugeObject OUT_GAS_GAUGE_3 = new GasGaugeObject(135, 55);
    public static final GasGaugeObject OUT_GAS_GAUGE_4 = new GasGaugeObject(153, 55);

    public static final ArrowAnimatedObject ANIM_ARROW = new ArrowAnimatedObject(
	    ScreenComponentProgress.ProgressBars.PROGRESS_ARROW_RIGHT, 78, 75, IDrawableAnimated.StartDirection.LEFT);

    public static final PowerLabelWrapperElectroRecipe POWER_LABEL = new PowerLabelWrapperElectroRecipe(9, 150, 240);
    public static final TimeLabelWrapperElectroRecipe TIME_LABEL = new TimeLabelWrapperElectroRecipe(167, 150);

    public static final int ANIM_TIME = 50;

    public static ItemStack INPUT_MACHINE = new ItemStack(CSBlocks.CHEMICAL_BENCH.get());

    public static final RecipeType<ChemicalBenchRecipe> RECIPE_TYPE = RecipeType.create(ChemicalScience.MOD_ID,
	    ChemicalBenchRecipe.RECIPE_GROUP, ChemicalBenchRecipe.class);

    public ChemicalBenchRecipeCategory(IGuiHelper guiHelper) {
	super(guiHelper, CSTextUtils.jeiTranslated(ChemicalBenchRecipe.RECIPE_GROUP), INPUT_MACHINE, BACK_WRAP,
		RECIPE_TYPE, ANIM_TIME);
	setInputSlots(guiHelper, INPUT_SLOT_1, INPUT_SLOT_2, INPUT_SLOT_3, INPUT_SLOT_4, INPUT_SLOT_5, INPUT_SLOT_6);
	setOutputSlots(guiHelper, OUTPUT_SLOT_1, OUTPUT_SLOT_2, OUTPUT_SLOT_3, OUTPUT_SLOT_4, OUTPUT_SLOT_5,
		OUTPUT_SLOT_6);
	setFluidInputs(guiHelper, IN_FLUID_GAUGE_1, IN_FLUID_GAUGE_2, IN_FLUID_GAUGE_3, IN_FLUID_GAUGE_4);
	setFluidOutputs(guiHelper, OUT_FLUID_GAUGE_1, OUT_FLUID_GAUGE_2, OUT_FLUID_GAUGE_3, OUT_FLUID_GAUGE_4);
	setGasInputs(guiHelper, IN_GAS_GAUGE_1, IN_GAS_GAUGE_2, IN_GAS_GAUGE_3, IN_GAS_GAUGE_4);
	setGasOutputs(guiHelper, OUT_GAS_GAUGE_1, OUT_GAS_GAUGE_2, OUT_GAS_GAUGE_3, OUT_GAS_GAUGE_4);
	setAnimatedArrows(guiHelper, ANIM_ARROW);
	setLabels(POWER_LABEL, TIME_LABEL);
    }

    public boolean isInputCatalyst(ChemicalBenchRecipe recipe, int index) {
	var ingredients = recipe.getCSCountedIngredients();

	if (index >= 0 && index < ingredients.size()) {
	    return ingredients.get(index).isCatalyst();
	}
	return false;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, ChemicalBenchRecipe recipe, IFocusGroup focuses) {
	List<List<ItemStack>> inputs = getItemInputs(recipe);
	for (int i = 0; i < inputSlotWrappers.length; i++) {
	    SlotDataWrapper wrapper = inputSlotWrappers[i];
	    if (inputs.get(i).isEmpty())
		continue;

	    var slot = builder.addSlot(wrapper.role(), wrapper.x(), wrapper.y()).addItemStacks(inputs.get(i));

	    if (isInputCatalyst(recipe, i)) {
		slot.addRichTooltipCallback((recipeSlotView, tooltip) -> tooltip
			.add(Component.translatable("jei.catalyst").withColor(0x51997C)));
	    }
	}

	setItemOutputs(getItemOutputs(recipe), builder);
	setFluidInputs(getFluidInputs(recipe), builder);
	setFluidOutputs(getFluidOutputs(recipe), builder);
	setGasInputs(getGasInputs(recipe), builder);
	setGasOutputs(getGasOutputs(recipe), builder);
    }

    @Override
    public void draw(ChemicalBenchRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics,
	    double mouseX, double mouseY) {
	super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);

	for (int i = 0; i < inputSlotWrappers.length; i++) {
	    if (isInputCatalyst(recipe, i)) {
		SlotDataWrapper wrapper = inputSlotWrappers[i];

		guiGraphics.blit(ChemicalScience.rl("textures/screen/component/icon/catalyst_empty.png"),
			wrapper.x() - 1, wrapper.y() - 1, 0, 0, 18, 18, 18, 18);
	    }
	}
    }

    @Override
    public List<List<ItemStack>> getItemInputs(ChemicalBenchRecipe recipe) {
	List<List<ItemStack>> inputs = new ArrayList<>();
	if (recipe.hasItemInputs()) {
	    recipe.getCSCountedIngredients().forEach(h -> inputs.add(Arrays.asList(h.ingredient().getItemsArray())));
	}

	while (inputs.size() < 6) {
	    inputs.add(Collections.emptyList());
	}
	return inputs;
    }

    @Override
    public List<ItemStack> getItemOutputs(ChemicalBenchRecipe recipe) {
	List<ItemStack> outputs = new ArrayList<>();
	if (recipe.hasItemOutput()) {
	    outputs.add(recipe.getItemRecipeOutput());
	}

	if (recipe.hasItemBiproducts()) {
	    outputs.addAll(Arrays.asList(recipe.getFullItemBiStacks()));
	}

	while (outputs.size() < 6) {
	    outputs.add(ItemStack.EMPTY);
	}
	return outputs;
    }

    @Override
    public List<List<FluidStack>> getFluidInputs(ChemicalBenchRecipe recipe) {
	List<List<FluidStack>> inputs = new ArrayList<>();
	if (recipe.hasFluidInputs()) {
	    for (FluidIngredient ing : recipe.getFluidIngredients()) {
		List<FluidStack> fluids = new ArrayList<>();
		for (FluidStack stack : ing.getMatchingFluids()) {
		    if (!BuiltInRegistries.FLUID.getKey(stack.getFluid()).toString().toLowerCase(Locale.ROOT)
			    .contains("flow")) {
			fluids.add(stack);
		    }
		}
		inputs.add(fluids);
	    }
	}

	while (inputs.size() < 4) {
	    inputs.add(Collections.emptyList());
	}
	return inputs;
    }

    @Override
    public List<FluidStack> getFluidOutputs(ChemicalBenchRecipe recipe) {
	List<FluidStack> outputs = new ArrayList<>();
	if (recipe.hasFluidOutput()) {
	    outputs.add(recipe.getFluidRecipeOutput());
	}

	if (recipe.hasFluidBiproducts()) {
	    outputs.addAll(Arrays.asList(recipe.getFullFluidBiStacks()));
	}

	while (outputs.size() < 4) {
	    outputs.add(FluidStack.EMPTY);
	}
	return outputs;
    }

    @Override
    public List<List<GasStack>> getGasInputs(ChemicalBenchRecipe recipe) {
	List<List<GasStack>> inputs = new ArrayList<>();
	if (recipe.hasGasInputs()) {
	    for (GasIngredient ing : recipe.getGasIngredients()) {
		inputs.add(ing.getMatchingGases());
	    }
	}

	while (inputs.size() < 4) {
	    inputs.add(Collections.emptyList());
	}
	return inputs;
    }

    @Override
    public List<GasStack> getGasOutputs(ChemicalBenchRecipe recipe) {
	List<GasStack> outputs = new ArrayList<>();
	if (recipe.hasGasOutput()) {
	    outputs.add(recipe.getGasRecipeOutput());
	}

	if (recipe.hasGasBiproducts()) {
	    outputs.addAll(Arrays.asList(recipe.getFullGasBiStacks()));
	}

	while (outputs.size() < 4) {
	    outputs.add(GasStack.EMPTY);
	}
	return outputs;
    }

    @Override
    public void setItemInputs(List<List<ItemStack>> inputs, IRecipeLayoutBuilder builder) {
	SlotDataWrapper wrapper;
	for (int i = 0; i < inputSlotWrappers.length; i++) {
	    wrapper = inputSlotWrappers[i];
	    if (inputs.get(i).isEmpty()) {
		continue;
	    }
	    builder.addSlot(wrapper.role(), wrapper.x(), wrapper.y()).addItemStacks(inputs.get(i));

	}
    }

    @Override
    public void setItemOutputs(List<ItemStack> outputs, IRecipeLayoutBuilder builder) {
	SlotDataWrapper wrapper;
	for (int i = 0; i < outputSlotWrappers.length; i++) {
	    wrapper = outputSlotWrappers[i];
	    if (i < outputs.size()) {
		if (outputs.get(i).isEmpty()) {
		    continue;
		}
		builder.addSlot(wrapper.role(), wrapper.x(), wrapper.y()).addItemStack(outputs.get(i));

	    }
	}
    }

    @Override
    public void setFluidInputs(List<List<FluidStack>> inputs, IRecipeLayoutBuilder builder) {
	AbstractFluidGaugeObject wrapper;
	RecipeIngredientRole role = RecipeIngredientRole.INPUT;
	FluidStack stack;

	int maxGaugeCap = 0;

	for (List<FluidStack> stacks : inputs) {

	    if (stacks.isEmpty()) {
		continue;
	    }

	    stack = stacks.get(0);
	    int gaugeCap = (int) Math.pow(10, MathUtils.nearestPowerOf10(stack.getAmount(), true));
	    if (gaugeCap > maxGaugeCap) {
		maxGaugeCap = gaugeCap;
	    }
	}

	for (int i = 0; i < fluidInputWrappers.length; i++) {
	    wrapper = fluidInputWrappers[i];

	    if (inputs.get(i).isEmpty()) {
		continue;
	    }
	    stack = inputs.get(i).get(0);

	    if (stack.isEmpty()) {
		continue;
	    }

	    int amt = stack.getAmount();

	    // int gaugeCap = (int) Math.pow(10, MathUtils.nearestPowerOf10(amt, true));

	    int height = (int) Math.ceil((float) amt / (float) maxGaugeCap * wrapper.getFluidTextHeight());

	    builder.addSlot(role, wrapper.getFluidXPos(), wrapper.getFluidYPos() - height)
		    .setFluidRenderer(stack.getAmount(), false, wrapper.getFluidTextWidth(), height)
		    .addIngredients(NeoForgeTypes.FLUID_STACK, inputs.get(i));
	}
    }

    @Override
    public void setFluidOutputs(List<FluidStack> outputs, IRecipeLayoutBuilder builder) {
	AbstractFluidGaugeObject wrapper;
	RecipeIngredientRole role = RecipeIngredientRole.OUTPUT;
	FluidStack stack;

	int maxGaugeCap = 0;

	for (FluidStack s : outputs) {
	    int gaugeCap = (int) Math.pow(10, MathUtils.nearestPowerOf10(s.getAmount(), true));
	    if (gaugeCap > maxGaugeCap) {
		maxGaugeCap = gaugeCap;
	    }
	}

	for (int i = 0; i < fluidOutputWrappers.length; i++) {
	    wrapper = fluidOutputWrappers[i];
	    stack = outputs.get(i);

	    if (stack.isEmpty()) {
		continue;
	    }

	    int amt = stack.getAmount();

	    // int gaugeCap = (int) Math.pow(10, MathUtils.nearestPowerOf10(amt, true));

	    int height = (int) Math.ceil((float) amt / (float) maxGaugeCap * wrapper.getFluidTextHeight());
	    builder.addSlot(role, wrapper.getFluidXPos(), wrapper.getFluidYPos() - height)
		    .setFluidRenderer(stack.getAmount(), false, wrapper.getFluidTextWidth(), height)
		    .addIngredient(NeoForgeTypes.FLUID_STACK, stack);
	}
    }

    @Override
    public void setGasInputs(List<List<GasStack>> inputs, IRecipeLayoutBuilder builder) {

	AbstractGasGaugeObject wrapper;
	RecipeIngredientRole role = RecipeIngredientRole.INPUT;
	List<GasStack> stacks;

	int maxGaugeCap = 0;

	for (List<GasStack> stackz : inputs) {

	    if (stackz.isEmpty()) {
		continue;
	    }

	    GasStack stack = stackz.get(0);
	    int gaugeCap = (int) Math.pow(10, MathUtils.nearestPowerOf10(stack.getAmount(), true));
	    if (gaugeCap > maxGaugeCap) {
		maxGaugeCap = gaugeCap;
	    }
	}

	for (int i = 0; i < gasInputWrappers.length; i++) {

	    wrapper = gasInputWrappers[i];
	    stacks = inputs.get(i);

	    if (stacks.isEmpty()) {
		continue;
	    }

	    double amt = stacks.get(0).getAmount();

	    // double gaugeCap = Math.pow(10, MathUtils.nearestPowerOf10(amt, true));

	    int height = (int) (Math.ceil(amt / maxGaugeCap * (wrapper.getHeight() - 2)));

	    int oneMinusHeight = wrapper.getHeight() - height;

	    builder.addSlot(role, wrapper.getX() + 1, wrapper.getY() + wrapper.getHeight() - height)
		    .addIngredients(VoltaicJeiTypes.GAS_STACK, stacks)
		    .setCustomRenderer(VoltaicJeiTypes.GAS_STACK, new IngredientRendererGasStack(maxGaugeCap,
			    -oneMinusHeight + 1, height, wrapper.getBarsTexture()));
	}

    }

    @Override
    public void setGasOutputs(List<GasStack> outputs, IRecipeLayoutBuilder builder) {

	AbstractGasGaugeObject wrapper;
	RecipeIngredientRole role = RecipeIngredientRole.OUTPUT;
	GasStack stack;

	int maxGaugeCap = 0;

	for (GasStack s : outputs) {
	    int gaugeCap = (int) Math.pow(10, MathUtils.nearestPowerOf10(s.getAmount(), true));
	    if (gaugeCap > maxGaugeCap) {
		maxGaugeCap = gaugeCap;
	    }
	}

	for (int i = 0; i < gasOutputWrappers.length; i++) {

	    wrapper = gasOutputWrappers[i];
	    stack = outputs.get(i);

	    if (stack.isEmpty()) {
		continue;
	    }

	    double amt = stack.getAmount();

	    // double gaugeCap = Math.pow(10, MathUtils.nearestPowerOf10(amt, true));

	    int height = (int) (Math.ceil(amt / maxGaugeCap * (wrapper.getHeight() - 2)));

	    int oneMinusHeight = wrapper.getHeight() - height;

	    builder.addSlot(role, wrapper.getX() + 1, wrapper.getY() + wrapper.getHeight() - height)
		    .addIngredient(VoltaicJeiTypes.GAS_STACK, stack)
		    .setCustomRenderer(VoltaicJeiTypes.GAS_STACK, new IngredientRendererGasStack(maxGaugeCap,
			    -oneMinusHeight + 1, height, wrapper.getBarsTexture()));
	}
    }
}