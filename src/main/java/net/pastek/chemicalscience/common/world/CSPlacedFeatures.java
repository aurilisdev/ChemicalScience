package net.pastek.chemicalscience.common.world;

import java.util.List;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.pastek.chemicalscience.ChemicalScience;

public class CSPlacedFeatures {
    public static final ResourceKey<PlacedFeature> MAGNESIUM_ORE_PLACED_KEY = registerKey("magnesium_ore_placed");
    public static final ResourceKey<PlacedFeature> SILICON_ORE_PLACED_KEY = registerKey("silicon_ore_placed");
    public static final ResourceKey<PlacedFeature> ARSENOPYRITE_ORE_PLACED_KEY = registerKey("arsenopyrite_ore_placed");
    public static final ResourceKey<PlacedFeature> WOLFRAMITE_ORE_PLACED_KEY = registerKey("wolframite_ore_placed");
    public static final ResourceKey<PlacedFeature> COOPERITE_ORE_PLACED_KEY = registerKey("cooperite_ore_placed");
    public static final ResourceKey<PlacedFeature> PYROLUSITE_ORE_PLACED_KEY = registerKey("pyrolusite_ore_placed");
    public static final ResourceKey<PlacedFeature> OIL_ORE_PLACED_KEY = registerKey("oil_ore_placed");


    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        // Overworld
        register(context, MAGNESIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(CSConfiguredFeatures.OVERWORLD_MAGNESIUM_ORE_KEY),
                CSOrePlacement.commonOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, SILICON_ORE_PLACED_KEY, configuredFeatures.getOrThrow(CSConfiguredFeatures.OVERWORLD_SILICON_ORE_KEY),
                CSOrePlacement.commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-8), VerticalAnchor.absolute(30))));
        register(context, ARSENOPYRITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(CSConfiguredFeatures.OVERWORLD_ARSENOPYRITE_ORE_KEY),
                CSOrePlacement.commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(-8), VerticalAnchor.absolute(48))));
        register(context, WOLFRAMITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(CSConfiguredFeatures.OVERWORLD_WOLFRAMITE_ORE_KEY),
                CSOrePlacement.commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(8))));
        register(context, COOPERITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(CSConfiguredFeatures.OVERWORLD_COOPERITE_ORE_KEY),
                CSOrePlacement.commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(-8), VerticalAnchor.absolute(48))));
        register(context, PYROLUSITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(CSConfiguredFeatures.OVERWORLD_PYROLUSITE_ORE_KEY),
                CSOrePlacement.commonOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(-8), VerticalAnchor.absolute(80))));
        register(context, OIL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(CSConfiguredFeatures.OVERWORLD_OIL_ORE_KEY),
                CSOrePlacement.rareOrePlacement(5, HeightRangePlacement.triangle(VerticalAnchor.absolute(-48), VerticalAnchor.absolute(80))));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}