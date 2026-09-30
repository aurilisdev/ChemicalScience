package net.pastek.chemicalscience.client.render.gear;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RenderGuiLayerEvent;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.common.item.gear.armor.types.ItemOrganicNightVisionGoggles;

@EventBusSubscriber(modid = ChemicalScience.MOD_ID, value = Dist.CLIENT)
public class ClientNightVisionHandler {

    private static List<ScanResult> cachedBiometric = new ArrayList<>();
    private static List<OreResult> cachedOres = new ArrayList<>();
    private static int tickCounter = 0;
    private static final TagKey<Block> ORE_TAG = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", "ores"));
    private static ItemOrganicNightVisionGoggles.ScannerMode lastMode = ItemOrganicNightVisionGoggles.ScannerMode.OFF;
    private static int flashTicks = 0;
    private static final int MAX_FLASH_TICKS = 10;

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if (player == null || mc.level == null) return;

        ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);

        if (ItemOrganicNightVisionGoggles.canWork(helmet)) {
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 210, 0, true, false, false));

            if (++tickCounter >= 20) {
                tickCounter = 0;
                ItemOrganicNightVisionGoggles.ScannerMode mode = ItemOrganicNightVisionGoggles.getMode(helmet);
                if (mode == ItemOrganicNightVisionGoggles.ScannerMode.BIO) updateBiometricScan(mc, player);
                else if (mode == ItemOrganicNightVisionGoggles.ScannerMode.ORE) updateOreScan(mc, player);
            }
        }
    }
    @SubscribeEvent
    public static void onRenderGuiOverlay(RenderGuiLayerEvent.Post event) {
        if (event.getName() != VanillaGuiLayers.CAMERA_OVERLAYS) return;

        Minecraft mc = Minecraft.getInstance();
        ClientLevel level = mc.level;
	LocalPlayer player = mc.player;
	if (player == null || level == null) return;

        ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);
        if (!(helmet.getItem() instanceof ItemOrganicNightVisionGoggles)) return;

        ItemOrganicNightVisionGoggles.ScannerMode mode = ItemOrganicNightVisionGoggles.getMode(helmet);

        if (mode != lastMode) {
            if (mode != ItemOrganicNightVisionGoggles.ScannerMode.OFF) flashTicks = MAX_FLASH_TICKS;
            lastMode = mode;
        }

        if (mode == ItemOrganicNightVisionGoggles.ScannerMode.OFF) return;

        int width = mc.getWindow().getGuiScaledWidth();
        int height = mc.getWindow().getGuiScaledHeight();

        RenderSystem.enableBlend();

        drawStaticNoise(event, width, height, level.random);

        event.getGuiGraphics().fill(0, 0, width, height, 0x55052b05);
        drawVignette(event, width, height);

        if (flashTicks > 0) {
            renderPowerFlash(event, width, height);
            flashTicks--;
        }

        if (mode == ItemOrganicNightVisionGoggles.ScannerMode.BIO) renderBiometricHud(event, mc);
        else if (mode == ItemOrganicNightVisionGoggles.ScannerMode.ORE) renderOreHud(event, mc);

        RenderSystem.disableBlend();
    }

    private static void drawStaticNoise(RenderGuiLayerEvent.Post event, int width, int height, net.minecraft.util.RandomSource random) {
        for (int i = 0; i < 120; i++) {
            int rx = random.nextInt(width);
            int ry = random.nextInt(height);
            event.getGuiGraphics().fill(rx, ry, rx + 1, ry + 1, 0x55000500);
        }

        for (int i = 0; i < 30; i++) {
            int rx = random.nextInt(width);
            int ry = random.nextInt(height);
            event.getGuiGraphics().fill(rx, ry, rx + 1, ry + 1, 0x4400FF00);
        }
    }

    private static void renderBiometricHud(RenderGuiLayerEvent.Post event, Minecraft mc) {
        Level level = mc.level;
        if(level == null) return;
        
        int x = 10, y = 10;
	int jX = (flashTicks > 0) ? level.random.nextInt(3) - 1 : 0;
        int jY = (flashTicks > 0) ? level.random.nextInt(3) - 1 : 0;

        event.getGuiGraphics().drawString(mc.font, Component.translatable("component.chemicalscience.onvg.mode.entity"), x + jX, y + jY, 0x00FF00);
        y += 15;

        for (ScanResult res : cachedBiometric) {
            int color = getEntityColor(res.entity);
            String text = String.format("%s [%dm]", res.entity.getType().getDescription().getString().toUpperCase(), res.distance);
            event.getGuiGraphics().fill(x, y + 2, x + 4, y + 6, color);
            event.getGuiGraphics().drawString(mc.font, text, x + 8, y, color);
            y += 12;
        }
    }

    private static void renderOreHud(RenderGuiLayerEvent.Post event, Minecraft mc) {
        Level level = mc.level;
        if(level == null) return;
        
        int x = 10, y = 10;
	int jX = (flashTicks > 0) ? level.random.nextInt(3) - 1 : 0;
        int jY = (flashTicks > 0) ? level.random.nextInt(3) - 1 : 0;

        event.getGuiGraphics().drawString(mc.font, Component.translatable("component.chemicalscience.onvg.mode.ore"), x + jX, y + jY, 0x57007F);
        y += 15;

        if (cachedOres.isEmpty()) {
            event.getGuiGraphics().drawString(mc.font, Component.translatable("component.chemicalscience.onvg.mode.ore.nosignal"), x, y, 0x404040);
        } else {
            for (OreResult res : cachedOres) {
                event.getGuiGraphics().pose().pushPose();
                event.getGuiGraphics().pose().translate(x, y - 2, 0);
                event.getGuiGraphics().pose().scale(0.6f, 0.6f, 0.6f);
                event.getGuiGraphics().renderItem(new ItemStack(res.block), 0, 0);
                event.getGuiGraphics().pose().popPose();

                String name = res.block.getName().getString().replace("Deepslate ", "").replace(" Ore", "").toUpperCase();
                event.getGuiGraphics().drawString(mc.font, String.format("%s [%dm]", name, res.distance), x + 12, y, 0xB200FF);
                y += 12;
            }
        }
    }

    private static void updateBiometricScan(Minecraft mc, Player player) {
        ClientLevel level = mc.level;
	if (level == null) return;
        cachedBiometric = level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(40.0D), e -> e != player)
                .stream()
                .sorted((e1, e2) -> {
                    int s1 = getEntityPriority(e1), s2 = getEntityPriority(e2);
                    return s1 != s2 ? Integer.compare(s2, s1) : Double.compare(player.distanceToSqr(e1), player.distanceToSqr(e2));
                })
                .limit(5)
                .map(e -> new ScanResult(e, (int) Math.sqrt(player.distanceToSqr(e))))
                .toList();
    }

    private static void updateOreScan(Minecraft mc, Player player) {
        ClientLevel level = mc.level;
	if (level == null) return;

        java.util.Map<Block, Integer> closestOres = new java.util.HashMap<>();
        BlockPos p = player.blockPosition();
        int r = 12;

        for (int x = -r; x <= r; x++) {
            for (int y = -r; y <= r; y++) {
                for (int z = -r; z <= r; z++) {
                    BlockPos pos = p.offset(x, y, z);
                    BlockState s = level.getBlockState(pos);

                    if (s.is(ORE_TAG)) {
                        int dist = (int) Math.sqrt(p.distSqr(pos));
                        Block block = s.getBlock();

                        if (!closestOres.containsKey(block) || dist < closestOres.get(block)) {
                            closestOres.put(block, dist);
                        }
                    }
                }
            }
        }

        cachedOres = closestOres.entrySet().stream()
                .map(entry -> new OreResult(entry.getKey(), entry.getValue()))
                .sorted(Comparator.comparingInt(o -> o.distance))
                .limit(5)
                .collect(java.util.stream.Collectors.toList());
    }

    private static void renderPowerFlash(RenderGuiLayerEvent.Post event, int width, int height) {
        int alpha = (int) (((float) flashTicks / MAX_FLASH_TICKS) * 180);
        event.getGuiGraphics().fill(0, 0, width, height, (alpha << 24) | 0xFFFFFF);
    }

    private static void drawVignette(RenderGuiLayerEvent.Post event, int width, int height) {
        event.getGuiGraphics().fillGradient(0, 0, width, height / 4, 0xAA000000, 0x00000000);
        event.getGuiGraphics().fillGradient(0, height - (height / 4), width, height, 0x00000000, 0xAA000000);
    }

    private static int getEntityColor(LivingEntity entity) {
        if (entity instanceof Player) return 0x0026FF;
        if (entity instanceof Enemy) return 0xFF0000;
        return 0x55FF55;
    }

    private static int getEntityPriority(LivingEntity entity) {
        if (entity instanceof Player) return 3;
        if (entity instanceof Enemy) return 2;
        return 1;
    }

    private record ScanResult(LivingEntity entity, int distance) {}
    private record OreResult(Block block, int distance) {}
}