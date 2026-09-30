package net.pastek.chemicalscience.registers.gases;

import electrodynamics.registers.ElectrodynamicsItems;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.prefab.utils.CSTextUtils;
import net.pastek.chemicalscience.registers.fluids.CSFluids;
import voltaic.api.gas.Gas;
import voltaic.prefab.utilities.math.Color;
import voltaic.registers.VoltaicGases;

public class CSGases {
    public static final DeferredRegister<Gas> GASES = DeferredRegister.create(VoltaicGases.GAS_REGISTRY_KEY, ChemicalScience.MOD_ID);

    /** Hydrocarbons */
    public static final DeferredHolder<Gas, Gas> METHANE = GASES.register("methane", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER, CSTextUtils.gas("methane"), 112, new Color(255, 255, 255, 180), CSFluids.FLUID_METHANE));
    public static final DeferredHolder<Gas, Gas> ETHYLENE = GASES.register("ethylene", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER, CSTextUtils.gas("ethylene"), 170, new Color(255, 255, 255, 180), CSFluids.FLUID_ETHYLENE));
    public static final DeferredHolder<Gas, Gas> PROPANE = GASES.register("propane", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER, CSTextUtils.gas("propane"), 231, new Color(255, 255, 255, 180), CSFluids.FLUID_PROPANE));
    public static final DeferredHolder<Gas, Gas> PROPYLENE = GASES.register("propylene", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER, CSTextUtils.gas("propylene"), 226, new Color(255, 255, 255, 180), CSFluids.FLUID_PROPYLENE));
    public static final DeferredHolder<Gas, Gas> BUTANE = GASES.register("butane", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER, CSTextUtils.gas("butane"), 272, new Color(255, 255, 255, 180), CSFluids.FLUID_BUTANE));

    /** Petroleum */
    public static final DeferredHolder<Gas, Gas> IMPUREPETROLEUMGAS = GASES.register("impurelpg", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER, CSTextUtils.gas("impurepetroleumgas"), 310, new Color(155, 155, 155, 180), CSFluids.FLUID_IMPUREPETROLEUMGAS));
    public static final DeferredHolder<Gas, Gas> IMPURENAPHTA = GASES.register("impurenaphta", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER, CSTextUtils.gas("impurenaphta"), 447, new Color(155, 155, 155, 180), CSFluids.FLUID_IMPURENAPHTA));
    public static final DeferredHolder<Gas, Gas> NAPHTA = GASES.register("naphta", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER, CSTextUtils.gas("naphta"), 447, new Color(155, 155, 100, 180), CSFluids.FLUID_NAPHTA));
    public static final DeferredHolder<Gas, Gas> LPG = GASES.register("lpg", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER, CSTextUtils.gas("lpg"), 310, new Color(185, 155, 100, 180), CSFluids.FLUID_PETROLEUMGAS));


    /** Misc */
    public static final DeferredHolder<Gas, Gas> CARBON_MONOXIDE = GASES.register("carbonmonoxide", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER, CSTextUtils.gas("carbonmonoxide"), 81, new Color(255, 255, 255, 180), CSFluids.FLUID_CARBONMONOXIDE));
    public static final DeferredHolder<Gas, Gas> HYDROGENSULFIDE = GASES.register("hydrogensulfide", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER, CSTextUtils.gas("hydrogensulfide"), 213, new Color(255, 255, 225, 180), CSFluids.FLUID_HYDROGENSULFIDE));

    /** Halides */
    public static final DeferredHolder<Gas, Gas> FLUORINE = GASES.register("fluorine", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER, CSTextUtils.gas("fluorine"), 54, new Color(0, 255, 175, 180), CSFluids.FLUID_FLUORINE));
    public static final DeferredHolder<Gas, Gas> CHLORINE = GASES.register("chlorine", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER, CSTextUtils.gas("chlorine"), 239, new Color(225, 255, 0, 180), CSFluids.FLUID_CHLORINE));
    public static final DeferredHolder<Gas, Gas> VINYLCHLORIDE = GASES.register("vinylchloride", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER, CSTextUtils.gas("vinylchloride"), 260, new Color(255, 255, 255, 180), CSFluids.FLUID_VINYLCHLORIDE));
    public static final DeferredHolder<Gas, Gas> BROMINE = GASES.register("bromine", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER, CSTextUtils.gas("bromine"), 331, new Color(255, 0, 30, 180), CSFluids.FLUID_BROMINE));
    public static final DeferredHolder<Gas, Gas> BROMOMETHANE = GASES.register("bromomethane", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER, CSTextUtils.gas("bromomethane"), 179, new Color(255, 255, 255, 180), CSFluids.FLUID_BROMOMETHANE));

    /** Noble gases */
    public static final DeferredHolder<Gas, Gas> HELIUM = GASES.register("helium", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER, CSTextUtils.gas("helium"), 4, new Color(255, 255, 255, 255), CSFluids.FLUID_HELIUM));
    public static final DeferredHolder<Gas, Gas> NEON = GASES.register("neon", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER, CSTextUtils.gas("neon"), 27, new Color(255, 255, 255, 255), CSFluids.FLUID_NEON));
    public static final DeferredHolder<Gas, Gas> KRYPTON = GASES.register("krypton", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER, CSTextUtils.gas("krypton"), 120, new Color(255, 255, 255, 255), CSFluids.FLUID_KRYPTON));
    public static final DeferredHolder<Gas, Gas> XENON = GASES.register("xenon", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER, CSTextUtils.gas("xenon"), 165, new Color(255, 255, 255, 255), CSFluids.FLUID_XENON));
    public static final DeferredHolder<Gas, Gas> RADON = GASES.register("radon", () -> new Gas(ElectrodynamicsItems.ITEM_PORTABLECYLINDER, CSTextUtils.gas("radon"), 212, new Color(255, 255, 255, 255), CSFluids.FLUID_RADON));
}