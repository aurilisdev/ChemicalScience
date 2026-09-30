package net.pastek.chemicalscience.common.item.gear.armor.types;

import java.util.EnumMap;
import java.util.List;

import org.jetbrains.annotations.NotNull;

import electrodynamics.registers.ElectrodynamicsItems;
import electrodynamics.registers.ElectrodynamicsSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.prefab.utils.CSTextUtils;
import net.pastek.chemicalscience.registers.CSArmor;
import net.pastek.chemicalscience.registers.CSDataComponentTypes;
import voltaic.api.item.IItemElectric;
import voltaic.common.item.gear.ItemVoltaicArmor;
import voltaic.prefab.item.ElectricItemProperties;

public class ItemOrganicNightVisionGoggles extends ItemVoltaicArmor implements IItemElectric {

    public static final ResourceLocation ARMOR_TEXTURE_LOCATION = ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID,"textures/model/armor/organicnightvisiongoggles.png");
    private final ElectricItemProperties properties;

    public static final EnumMap<Type, Integer> DEFENSE_MAP = Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
        map.put(Type.HELMET, 4);
        map.put(Type.CHESTPLATE, 0);
        map.put(Type.LEGGINGS, 0);
        map.put(Type.BOOTS, 0);
    });

    public enum ScannerMode {
        OFF(0, "component.chemicalscience.onvg.mode.off", ChatFormatting.RED),
        NIGHT_VISION(1, "component.chemicalscience.onvg.mode.nv", ChatFormatting.GREEN),
        BIO(2, "component.chemicalscience.onvg.mode.entity", ChatFormatting.DARK_GREEN),
        ORE(3, "component.chemicalscience.onvg.mode.ore", ChatFormatting.LIGHT_PURPLE);

        final int id;
        final String key;
        final ChatFormatting color;

        ScannerMode(int id, String key, ChatFormatting color) {
            this.id = id;
            this.key = key;
            this.color = color;
        }

        public static ScannerMode byId(int id) {
            for (ScannerMode m : values()) {
                if (m.id == id) return m;
            }
            return OFF;
        }

        public ScannerMode next() {
            int nextId = (this.id + 1) % values().length;
            return byId(nextId);
        }
    }

    public ItemOrganicNightVisionGoggles(ElectricItemProperties properties, net.minecraft.core.Holder<CreativeModeTab> creativeTab) {
        super(CSArmor.ONVGS, Type.HELMET, properties, creativeTab);
        this.properties = properties;
    }

    public static boolean canWork(ItemStack stack) {
        return stack.getItem() instanceof ItemOrganicNightVisionGoggles &&
                stack.getOrDefault(CSDataComponentTypes.ON, true) &&
                getMode(stack) != ScannerMode.OFF;
    }

    public static ScannerMode getMode(ItemStack stack) {
        int modeId = stack.getOrDefault(CSDataComponentTypes.MODE, 0);
        return ScannerMode.byId(modeId);
    }

    public void cycleMode(ItemStack stack, Player player) {
        ScannerMode current = getMode(stack);
        ScannerMode next = current.next();

        stack.set(CSDataComponentTypes.MODE, next.id);

        if (!player.level().isClientSide) {
            if (next == ScannerMode.OFF) {
                player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                        ElectrodynamicsSounds.SOUND_NIGHTVISIONGOGGLESOFF, SoundSource.PLAYERS, 0.5f, 1.0f);
            } else if (current == ScannerMode.OFF) {
                player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                        ElectrodynamicsSounds.SOUND_NIGHTVISIONGOGGLESON, SoundSource.PLAYERS, 0.5f, 1.0f);

            } else {
                player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                        ElectrodynamicsSounds.SOUND_NIGHTVISIONGOGGLESOFF.value(), SoundSource.PLAYERS, 0.2f, 1.5f);
            }
        }

        player.displayClientMessage(Component.translatable("tooltip.chemicalscience.onvg.mode")
                .append(Component.translatable(next.key).withStyle(next.color)), true);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull List<Component> tooltip, @NotNull TooltipFlag flagIn) {
        super.appendHoverText(stack, context, tooltip, flagIn);
        ScannerMode mode = getMode(stack);
        tooltip.add(CSTextUtils.tooltip("onvg.mode").withStyle(ChatFormatting.DARK_GRAY)
                .append(Component.translatable(mode.key).withStyle(mode.color)));
    }

    @Override
    public ResourceLocation getArmorTexture(@NotNull ItemStack stack, @NotNull Entity entity, @NotNull EquipmentSlot slot, ArmorMaterial.@NotNull Layer layer, boolean innerModel) {
        return ARMOR_TEXTURE_LOCATION;
    }

    @Override
    public Item getDefaultStorageBattery() {
        return ElectrodynamicsItems.ITEM_BATTERY.get();
    }

    @Override
    public ElectricItemProperties getElectricProperties() {
        return properties;
    }
}