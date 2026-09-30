package net.pastek.chemicalscience.client;

import javax.annotation.Nullable;

import org.jetbrains.annotations.NotNull;
import org.lwjgl.glfw.GLFW;

import com.mojang.blaze3d.platform.InputConstants;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.entity.NoopRenderer;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.client.event.RegisterClientTooltipComponentFactoriesEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.client.guidebook.ModuleChemicalScience;
import net.pastek.chemicalscience.client.model.armor.BulletProofVest;
import net.pastek.chemicalscience.client.model.armor.OrganicNightVisionGoggles;
import net.pastek.chemicalscience.client.particles.ColoredFlameParticle;
import net.pastek.chemicalscience.client.render.tile.RenderChemicalBench;
import net.pastek.chemicalscience.client.render.tile.RenderFractionatingColumn;
import net.pastek.chemicalscience.client.render.tile.RenderLabStorage;
import net.pastek.chemicalscience.client.render.tile.RenderRackM;
import net.pastek.chemicalscience.client.render.tile.RenderRackS;
import net.pastek.chemicalscience.client.render.tile.RenderRedoxFurnace;
import net.pastek.chemicalscience.client.roadmap.ScreenRoadMap;
import net.pastek.chemicalscience.client.screen.ScreenCatalyticReformer;
import net.pastek.chemicalscience.client.screen.ScreenChemicalBench;
import net.pastek.chemicalscience.client.screen.ScreenCircuitMaker;
import net.pastek.chemicalscience.client.screen.ScreenFractionatingColumn;
import net.pastek.chemicalscience.client.screen.ScreenFuelCell;
import net.pastek.chemicalscience.client.screen.ScreenHDSUnit;
import net.pastek.chemicalscience.client.screen.ScreenLabBench;
import net.pastek.chemicalscience.client.screen.ScreenLabStorage;
import net.pastek.chemicalscience.client.screen.ScreenRackM;
import net.pastek.chemicalscience.client.screen.ScreenRackS;
import net.pastek.chemicalscience.client.screen.ScreenRedoxFurnace;
import net.pastek.chemicalscience.client.screen.ScreenSolarPanel;
import net.pastek.chemicalscience.client.screen.ScreenSpinCoater;
import net.pastek.chemicalscience.client.screen.ScreenSteamCracker;
import net.pastek.chemicalscience.client.tooltip.CSTooltipRenderer;
import net.pastek.chemicalscience.common.item.CSTooltipItem;
import net.pastek.chemicalscience.common.item.gear.ItemFlamethrower;
import net.pastek.chemicalscience.common.packet.PacketToggleNightVisionMode;
import net.pastek.chemicalscience.registers.CSEntities;
import net.pastek.chemicalscience.registers.CSItems;
import net.pastek.chemicalscience.registers.CSMenuTypes;
import net.pastek.chemicalscience.registers.CSParticles;
import net.pastek.chemicalscience.registers.CSTiles;
import net.pastek.chemicalscience.registers.fluids.CSFluids;
import voltaic.client.guidebook.ScreenGuidebook;
import voltaic.client.misc.SWBFClientExtensions;
import voltaic.common.fluid.SimpleWaterBasedFluidType;

@EventBusSubscriber(modid = ChemicalScience.MOD_ID, value = {Dist.CLIENT})
public class CSClientRegister {

    public static final LayerDefinition ORGANIC_NIGHT_VISION_GOGGLES = OrganicNightVisionGoggles.createBodyLayer();
    public static final LayerDefinition BULLETPROOF_VEST = BulletProofVest.createBodyLayer(3, false);
    private static @Nullable OrganicNightVisionGoggles<LivingEntity> GOGGLES_MODEL;
    private static @Nullable BulletProofVest<LivingEntity> VEST_MODEL;

    public static final ModelResourceLocation FRACTIONATINGCOLUMN_MODEL =
            ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, "multiblock/fractionating_column"));
    public static final ModelResourceLocation CHEMICALBENCH_MODEL =
            ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, "multiblock/chemical_bench"));
    public static final ModelResourceLocation REDOXFURNACE_MODEL =
            ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, "multiblock/redox_furnace"));

    public static void setup() {
        ScreenGuidebook.addGuidebookModule(new ModuleChemicalScience());
    }

    @SubscribeEvent
    public static void registerMenus(RegisterMenuScreensEvent event) {
        event.register(CSMenuTypes.CONTAINER_ROADMAP.get(), ScreenRoadMap::new);

        event.register(CSMenuTypes.CONTAINER_SOLARPANEL.get(), ScreenSolarPanel::new);
        event.register(CSMenuTypes.CONTAINER_FUELCELL.get(), ScreenFuelCell::new);
        event.register(CSMenuTypes.CONTAINER_CIRCUIT_MAKER.get(), ScreenCircuitMaker::new);
        event.register(CSMenuTypes.CONTAINER_HDS_UNIT.get(), ScreenHDSUnit::new);
        event.register(CSMenuTypes.CONTAINER_STEAM_CRACKER.get(), ScreenSteamCracker::new);
        event.register(CSMenuTypes.CONTAINER_CATALYTIC_REFORMER.get(), ScreenCatalyticReformer::new);
        event.register(CSMenuTypes.CONTAINER_SPIN_COATER.get(), ScreenSpinCoater::new);
        event.register(CSMenuTypes.CONTAINER_FRACTIONATING_COLUMN.get(), ScreenFractionatingColumn::new);
        event.register(CSMenuTypes.CONTAINER_CHEMICAL_BENCH.get(), ScreenChemicalBench::new);
        event.register(CSMenuTypes.CONTAINER_REDOX_FURNACE.get(), ScreenRedoxFurnace::new);
        event.register(CSMenuTypes.CONTAINER_RACK_M.get(), ScreenRackM::new);
        event.register(CSMenuTypes.CONTAINER_RACK_S.get(), ScreenRackS::new);
        event.register(CSMenuTypes.CONTAINER_LAB_BENCH.get(), ScreenLabBench::new);
        event.register(CSMenuTypes.CONTAINER_LAB_STORAGE.get(), ScreenLabStorage::new);
    }

    @SubscribeEvent
    public static void registerClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerItem(new IClientItemExtensions() {
            @Override
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity entity, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> properties) {
                OrganicNightVisionGoggles<LivingEntity> parGogglesModel = GOGGLES_MODEL;
		if (parGogglesModel == null) {
                    parGogglesModel = GOGGLES_MODEL = new OrganicNightVisionGoggles<>(CSClientRegister.ORGANIC_NIGHT_VISION_GOGGLES.bakeRoot());
                }

                ((HumanoidModel) properties).copyPropertiesTo(parGogglesModel);

                parGogglesModel.setAllVisible(false);
                parGogglesModel.head.visible = (armorSlot == EquipmentSlot.HEAD);
                parGogglesModel.hat.visible = (armorSlot == EquipmentSlot.HEAD);

                return parGogglesModel;
            }
        }, CSItems.ORGANICNIGHTVISIONGOGGLES);

        event.registerItem(new IClientItemExtensions() {
            @Override
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity entity, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> properties) {
                BulletProofVest<LivingEntity> parVestModel = VEST_MODEL;
		if (parVestModel == null) {
                    parVestModel = VEST_MODEL = new BulletProofVest<>(CSClientRegister.BULLETPROOF_VEST.bakeRoot(), armorSlot);
                }

                ((HumanoidModel) properties).copyPropertiesTo(parVestModel);

                parVestModel.setAllVisible(false);
                parVestModel.body.visible = (armorSlot == EquipmentSlot.CHEST);
                parVestModel.rightArm.visible = (armorSlot == EquipmentSlot.CHEST);
                parVestModel.leftArm.visible = (armorSlot == EquipmentSlot.CHEST);

                return parVestModel;
            }
        }, CSItems.BULLETPROOF_VEST);


        event.registerItem(new IClientItemExtensions() {
            @Override
            public HumanoidModel.ArmPose getArmPose(LivingEntity entity, InteractionHand hand, ItemStack stack) {
                if (stack.getItem() instanceof ItemFlamethrower && entity.isUsingItem() && entity.getUseItem() == stack) {
                    return HumanoidModel.ArmPose.CROSSBOW_HOLD;
                }
                return HumanoidModel.ArmPose.EMPTY;
            }
        }, CSItems.FLAME_THROWER.get());


        CSFluids.FLUIDS.getEntries().forEach((fluid) -> {
            event.registerFluidType(new SWBFClientExtensions((SimpleWaterBasedFluidType) fluid.get().getFluidType()), fluid.get().getFluidType());
        });
    }

    @SubscribeEvent
    public static void registerEntities(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(CSTiles.TILE_RACK_M.get(), RenderRackM::new);
        event.registerBlockEntityRenderer(CSTiles.TILE_RACK_S.get(), RenderRackS::new);
        event.registerBlockEntityRenderer(CSTiles.TILE_LAB_STORAGE.get(), RenderLabStorage::new);
        event.registerBlockEntityRenderer(CSTiles.TILE_FRACTIONATING_COLUMN.get(), RenderFractionatingColumn::new);
        event.registerBlockEntityRenderer(CSTiles.TILE_CHEMICAL_BENCH.get(), RenderChemicalBench::new);
        event.registerBlockEntityRenderer(CSTiles.TILE_REDOX_FURNACE.get(), RenderRedoxFurnace::new);
    }

    @SubscribeEvent
    public static void registerModels(ModelEvent.RegisterAdditional event) {
        event.register(FRACTIONATINGCOLUMN_MODEL);
        event.register(CHEMICALBENCH_MODEL);
        event.register(REDOXFURNACE_MODEL);
    }

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(CSEntities.ENTITY_FLAMESTREAM.get(), NoopRenderer::new);
    }

    @SubscribeEvent
    public static void onRegisterParticleProviders(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(CSParticles.COLORED_FLAME.get(), ColoredFlameParticle.Provider::new);
    }

    @SubscribeEvent
    public static void onRegisterTooltipFactories(RegisterClientTooltipComponentFactoriesEvent event) {
        event.register(CSTooltipItem.ImageTooltipComponent.class,
                CSTooltipRenderer::new);
    }

    public static final KeyMapping TOGGLE_MODE_KEY = new KeyMapping(
            "key.chemicalscience.toggle_goggles",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_N,
            "category.chemicalscience.keys"
    );

    @SubscribeEvent
    public static void RegisterKeyMapingsEvent(RegisterKeyMappingsEvent event) {
        event.register(TOGGLE_MODE_KEY);
    }

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        if (TOGGLE_MODE_KEY.consumeClick()) {
            PacketDistributor.sendToServer(new PacketToggleNightVisionMode());
        }
    }
}