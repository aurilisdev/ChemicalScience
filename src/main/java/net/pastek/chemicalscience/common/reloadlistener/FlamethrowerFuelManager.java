package net.pastek.chemicalscience.common.reloadlistener;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.tags.TagKey;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

public class FlamethrowerFuelManager extends SimpleJsonResourceReloadListener {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    public static final FlamethrowerFuelManager INSTANCE = new FlamethrowerFuelManager();

    private final java.util.List<FuelEntry> fuelEntries = new java.util.ArrayList<>();
    private final Map<Fluid, FuelInfo> lookupCache = new HashMap<>();

    public FlamethrowerFuelManager() {
	super(GSON, "flamethrower_fuels");
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> objectIn, ResourceManager resourceManagerIn,
	    ProfilerFiller profilerIn) {
	fuelEntries.clear();
	lookupCache.clear();

	objectIn.forEach((location, jsonElement) -> {
	    try {
		JsonObject json = jsonElement.getAsJsonObject();

		int color = json.has("color") ? json.get("color").getAsInt() : 0xFF4400;
		float damage = json.has("damage") ? json.get("damage").getAsFloat() : 4.0f;
		int mB = json.has("mB_per_drain") ? json.get("mB_per_drain").getAsInt() : 2;
		int interval = json.has("ticks_per_drain") ? json.get("ticks_per_drain").getAsInt() : 2;

		FuelInfo info = new FuelInfo(color, damage, mB, interval);
		String input = json.get("fluid").getAsString();

		if (input.startsWith("#")) {
		    ResourceLocation tagId = ResourceLocation.parse(input.substring(1));
		    fuelEntries.add(new FuelEntry(tagId, null, info));
		} else {
		    ResourceLocation fluidId = ResourceLocation.parse(input);
		    Fluid fluid = BuiltInRegistries.FLUID.get(fluidId);
		    if (fluid != Fluids.EMPTY) {
			fuelEntries.add(new FuelEntry(null, fluid, info));
		    }
		}
	    } catch (Exception e) {
	    }
	});
    }

    public @Nullable FuelInfo getFuelInfo(Fluid fluid) {
	if (lookupCache.containsKey(fluid))
	    return lookupCache.get(fluid);

	for (FuelEntry entry : fuelEntries) {
	    if (entry.matches(fluid)) {
		lookupCache.put(fluid, entry.info());
		return entry.info();
	    }
	}

	return null;
    }

    public int getFuelMapSize() {
	return this.fuelEntries.size();
    }

    public record FuelInfo(int color, float damage, int mBPerDrain, int ticksPerDrain) {
    }

    private record FuelEntry(ResourceLocation tagId, @Nullable Fluid fluid, FuelInfo info) {
	public boolean matches(Fluid input) {
	    if (this.fluid != null)
		return this.fluid == input;

	    if (this.tagId != null) {
		var tagKey = TagKey.create(net.minecraft.core.registries.Registries.FLUID, tagId);
		return input.builtInRegistryHolder().is(tagKey);
	    }
	    return false;
	}
    }
}