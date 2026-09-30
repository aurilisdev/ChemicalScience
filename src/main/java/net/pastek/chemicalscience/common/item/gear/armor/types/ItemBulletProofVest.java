package net.pastek.chemicalscience.common.item.gear.armor.types;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Consumer;

import org.jetbrains.annotations.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.registers.CSArmor;
import net.pastek.chemicalscience.registers.CSCreativeTabs;
import voltaic.common.item.gear.ItemVoltaicArmor;

public class ItemBulletProofVest extends ItemVoltaicArmor {
    public static final EnumMap<ArmorItem.Type, Integer> DEFENSE_MAP = Util.make(new EnumMap(ArmorItem.Type.class), (map) -> {
        map.put(Type.HELMET, 0);
        map.put(Type.CHESTPLATE, 12);
        map.put(Type.LEGGINGS, 0);
        map.put(Type.BOOTS, 0);
    });

    public static final ResourceLocation ARMOR_TEXTURE_LOCATION = ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID,"textures/model/armor/bulletproofvest.png");

    public ItemBulletProofVest(ArmorItem.Type slot) {
        super(CSArmor.BULLETPROOFVEST, Type.CHESTPLATE,
                new Item.Properties()
                        .stacksTo(1)
                        .durability(830),
                CSCreativeTabs.CHEMICAL_SCIENCE_TAB);
    }

    @Override
    public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, @Nullable T entity, Consumer<Item> onBroken) {
        return 0;
    }

    @Override
    public int getEnchantmentValue() {
        return this.getMaterial().value().enchantmentValue();
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(Component.translatable("tooltip.chemicalscience.bulletproofvest")
                .withStyle(ChatFormatting.DARK_GRAY));
        super.appendHoverText(stack, context, tooltip, flagIn);
    }

    @Override
    public @Nullable ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
        return ARMOR_TEXTURE_LOCATION;
    }
}
