package net.pastek.chemicalscience.common.event;

import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.common.item.gear.armor.types.ItemBulletProofVest;

@EventBusSubscriber(modid = ChemicalScience.MOD_ID)
public class ArmorResistanceEvents {

    @SubscribeEvent
    public static void onProjectileDamage(LivingDamageEvent.Pre event) {
        if (!(event.getEntity() instanceof Player player)) return;

        if (event.getSource().is(DamageTypeTags.IS_PROJECTILE)) {
            if (player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof ItemBulletProofVest) {

                float oldAmount = event.getOriginalDamage();
                float newAmount = oldAmount * 0.2f;

                event.setNewDamage(newAmount);
            }
        }
    }
}