package net.pastek.chemicalscience.registers;


import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.common.inventory.container.ContainerCatalyticReformer;
import net.pastek.chemicalscience.common.inventory.container.ContainerChemicalBench;
import net.pastek.chemicalscience.common.inventory.container.ContainerCircuitMaker;
import net.pastek.chemicalscience.common.inventory.container.ContainerFractionatingColumn;
import net.pastek.chemicalscience.common.inventory.container.ContainerFuelCell;
import net.pastek.chemicalscience.common.inventory.container.ContainerHDSUnit;
import net.pastek.chemicalscience.common.inventory.container.ContainerLabBench;
import net.pastek.chemicalscience.common.inventory.container.ContainerLabStorage;
import net.pastek.chemicalscience.common.inventory.container.ContainerOrganicSolarPanel;
import net.pastek.chemicalscience.common.inventory.container.ContainerRackM;
import net.pastek.chemicalscience.common.inventory.container.ContainerRackS;
import net.pastek.chemicalscience.common.inventory.container.ContainerRedoxFurnace;
import net.pastek.chemicalscience.common.inventory.container.ContainerRoadMap;
import net.pastek.chemicalscience.common.inventory.container.ContainerSpinCoater;
import net.pastek.chemicalscience.common.inventory.container.ContainerSteamCracker;

public class CSMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(Registries.MENU, ChemicalScience.MOD_ID);

    public static final DeferredHolder<MenuType<?>, MenuType<ContainerOrganicSolarPanel>> CONTAINER_SOLARPANEL = register("organicsolarpanel", ContainerOrganicSolarPanel::new);
    public static final DeferredHolder<MenuType<?>, MenuType<ContainerFuelCell>> CONTAINER_FUELCELL = register("fuelcell", ContainerFuelCell::new);
    public static final DeferredHolder<MenuType<?>, MenuType<ContainerRackM>> CONTAINER_RACK_M = register("rackm", ContainerRackM::new);
    public static final DeferredHolder<MenuType<?>, MenuType<ContainerRackS>> CONTAINER_RACK_S = register("racks", ContainerRackS::new);
    public static final DeferredHolder<MenuType<?>, MenuType<ContainerLabBench>> CONTAINER_LAB_BENCH = register("labbench", ContainerLabBench::new);
    public static final DeferredHolder<MenuType<?>, MenuType<ContainerLabStorage>> CONTAINER_LAB_STORAGE = register("labstorage", ContainerLabStorage::new);
    public static final DeferredHolder<MenuType<?>, MenuType<ContainerCircuitMaker>> CONTAINER_CIRCUIT_MAKER = register("circuitmaker", ContainerCircuitMaker::new);
    public static final DeferredHolder<MenuType<?>, MenuType<ContainerHDSUnit>> CONTAINER_HDS_UNIT = register("hdsunit", ContainerHDSUnit::new);
    public static final DeferredHolder<MenuType<?>, MenuType<ContainerSteamCracker>> CONTAINER_STEAM_CRACKER = register("steamcracker", ContainerSteamCracker::new);
    public static final DeferredHolder<MenuType<?>, MenuType<ContainerCatalyticReformer>> CONTAINER_CATALYTIC_REFORMER = register("catalyticreformer", ContainerCatalyticReformer::new);
    public static final DeferredHolder<MenuType<?>, MenuType<ContainerSpinCoater>> CONTAINER_SPIN_COATER = register("spincoater", ContainerSpinCoater::new);

    public static final DeferredHolder<MenuType<?>, MenuType<ContainerFractionatingColumn>> CONTAINER_FRACTIONATING_COLUMN = register("fractionatingcolumn", ContainerFractionatingColumn::new);
    public static final DeferredHolder<MenuType<?>, MenuType<ContainerChemicalBench>> CONTAINER_CHEMICAL_BENCH = register("chemicalbench", ContainerChemicalBench::new);
    public static final DeferredHolder<MenuType<?>, MenuType<ContainerRedoxFurnace>> CONTAINER_REDOX_FURNACE = register("redoxfurnace", ContainerRedoxFurnace::new);

    public static final DeferredHolder<MenuType<?>, MenuType<ContainerRoadMap>> CONTAINER_ROADMAP = register("roadmap", ContainerRoadMap::new);

    private static <T extends AbstractContainerMenu> DeferredHolder<MenuType<?>,MenuType<T>> register(String id, MenuType.MenuSupplier<T> supplier) {
        return MENU_TYPES.register(id, () -> new MenuType<>(supplier, FeatureFlags.DEFAULT_FLAGS));
    }
}