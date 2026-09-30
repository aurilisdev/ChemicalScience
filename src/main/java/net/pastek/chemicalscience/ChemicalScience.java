package net.pastek.chemicalscience;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.AddReloadListenerEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.pastek.chemicalscience.client.CSClientRegister;
import net.pastek.chemicalscience.common.reloadlistener.FlamethrowerFuelManager;
import net.pastek.chemicalscience.registers.CSEntities;
import net.pastek.chemicalscience.registers.UnifiedCSRegister;

@Mod(ChemicalScience.MOD_ID)
public class ChemicalScience {
    public static final String MOD_ID = "chemicalscience";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public ChemicalScience(IEventBus EventBus) {
        EventBus.addListener(this::commonSetup);
        EventBus.addListener(this::registerRenderers);
        NeoForge.EVENT_BUS.register(this);
        UnifiedCSRegister.register(EventBus);
        NeoForge.EVENT_BUS.addListener(this::onAddReloadListeners);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    private void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(CSEntities.ENTITY_FLAMESTREAM.get(), ThrownItemRenderer::new);
    }

    private void onAddReloadListeners(AddReloadListenerEvent event) {
        event.addListener(FlamethrowerFuelManager.INSTANCE);
    }

    @EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            event.enqueueWork(CSClientRegister::setup);
        }
    }

    public static ResourceLocation rl(String path) {
        return ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, path);
    }
}