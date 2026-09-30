package net.pastek.chemicalscience.common.world;

import java.util.List;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.registers.CSBlocks;

public class CSConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_MAGNESIUM_ORE_KEY = registerKey("magnesium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_SILICON_ORE_KEY = registerKey("silicon_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ARSENOPYRITE_ORE_KEY = registerKey("arsenopyrite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_WOLFRAMITE_ORE_KEY = registerKey("wolframite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_COOPERITE_ORE_KEY = registerKey("cooperite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_PYROLUSITE_ORE_KEY = registerKey("pyrolusite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_OIL_ORE_KEY = registerKey("oil_ore");


    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);


        // Overworld
        List<OreConfiguration.TargetBlockState> overworldMagnesiumOres = List.of(
                OreConfiguration.target(stoneReplaceables, CSBlocks.ORE_MAGNESIUM.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, CSBlocks.ORE_DEEPSLATE_MAGNESIUM.get().defaultBlockState()));

        register(context, OVERWORLD_MAGNESIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldMagnesiumOres, 9));

        List<OreConfiguration.TargetBlockState> overworldSiliconOres = List.of(
                OreConfiguration.target(stoneReplaceables, CSBlocks.ORE_SILICON.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, CSBlocks.ORE_DEEPSLATE_SILICON.get().defaultBlockState()));

        register(context, OVERWORLD_SILICON_ORE_KEY, Feature.ORE, new OreConfiguration(overworldSiliconOres, 4));

        List<OreConfiguration.TargetBlockState> overworldArsenopyriteOres = List.of(
                OreConfiguration.target(stoneReplaceables, CSBlocks.ORE_ARSENOPYRITE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, CSBlocks.ORE_DEEPSLATE_ARSENOPYRITE.get().defaultBlockState()));

        register(context, OVERWORLD_ARSENOPYRITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldArsenopyriteOres, 4));

        List<OreConfiguration.TargetBlockState> overworldWolframiteOres = List.of(
                OreConfiguration.target(stoneReplaceables, CSBlocks.ORE_WOLFRAMITE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, CSBlocks.ORE_DEEPSLATE_WOLFRAMITE.get().defaultBlockState()));

        register(context, OVERWORLD_WOLFRAMITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldWolframiteOres, 5));

        List<OreConfiguration.TargetBlockState> overworldCooperiteOres = List.of(
                OreConfiguration.target(stoneReplaceables, CSBlocks.ORE_COOPERITE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, CSBlocks.ORE_DEEPSLATE_COOPERITE.get().defaultBlockState()));

        register(context, OVERWORLD_COOPERITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldCooperiteOres, 3));

        List<OreConfiguration.TargetBlockState> overworldPyrolusiteOres = List.of(
                OreConfiguration.target(stoneReplaceables, CSBlocks.ORE_PYROLUSITE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, CSBlocks.ORE_DEEPSLATE_PYROLUSITE.get().defaultBlockState()));

        register(context, OVERWORLD_PYROLUSITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldPyrolusiteOres, 6));

        List<OreConfiguration.TargetBlockState> overworldOilOres = List.of(
                OreConfiguration.target(stoneReplaceables, CSBlocks.ORE_OIL.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, CSBlocks.ORE_DEEPSLATE_OIL.get().defaultBlockState()));

        register(context, OVERWORLD_OIL_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOilOres, 48));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}