package net.pastek.chemicalscience.client.sound.flamethrower;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.pastek.chemicalscience.common.item.gear.ItemFlamethrower;
import net.pastek.chemicalscience.registers.CSSounds;

@EventBusSubscriber(value = Dist.CLIENT)
public class FlamethrowerAudioHandler {

    private static final Map<Integer, FlamethrowerSession> SESSIONS = new HashMap<>();
    private static final int START_DURATION = 20;

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {
	var level = Minecraft.getInstance().level;
	if (level == null)
	    return;

	for (Player player : level.players()) {
	    int id = player.getId();
	    boolean isUsing = player.isUsingItem() && player.getUseItem().getItem() instanceof ItemFlamethrower;

	    if (isUsing) {
		handleFlamethrowerFiring(player, id);
	    } else if (SESSIONS.containsKey(id)) {
		SESSIONS.get(id).stop();
		SESSIONS.remove(id);
	    }
	}

	SESSIONS.entrySet().removeIf(e -> e.getValue().sound.isStopped());
    }

    private static void handleFlamethrowerFiring(Player player, int id) {
	if (!SESSIONS.containsKey(id)) {
	    FlamethrowerSoundInstance startSound = new FlamethrowerSoundInstance(player,
		    CSSounds.SOUND_FLAMETHROWER_START.get(), false);
	    Minecraft.getInstance().getSoundManager().play(startSound);
	    SESSIONS.put(id, new FlamethrowerSession(startSound));
	} else {
	    FlamethrowerSession session = SESSIONS.get(id);
	    session.ticksActive++;

	    if (!session.isLooping && session.ticksActive >= START_DURATION) {
		session.stop();

		FlamethrowerSoundInstance loopSound = new FlamethrowerSoundInstance(player,
			CSSounds.SOUND_FLAMETHROWER_LOOP.get(), true);
		Minecraft.getInstance().getSoundManager().play(loopSound);

		session.sound = loopSound;
		session.isLooping = true;
	    }
	}
    }

    private static class FlamethrowerSession {
	public FlamethrowerSoundInstance sound;
	public int ticksActive = 0;
	public boolean isLooping = false;

	public FlamethrowerSession(FlamethrowerSoundInstance sound) {
	    this.sound = sound;
	}

	public void stop() {
	    this.sound.forceStop();
	}
    }
}