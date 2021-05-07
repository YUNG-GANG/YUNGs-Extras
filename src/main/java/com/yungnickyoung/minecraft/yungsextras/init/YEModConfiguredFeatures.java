package com.yungnickyoung.minecraft.yungsextras.init;

import com.yungnickyoung.minecraft.yungsextras.YungsExtras;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class YEModConfiguredFeatures {
    /* Normal wells */
    public static ConfiguredFeature<?, ?> WELL_SM = YEModFeatures.WELL_SM.get()
        .withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
        .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
        .chance(10);
    public static ConfiguredFeature<?, ?> WELL_MD = YEModFeatures.WELL_MD.get()
        .withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
        .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
        .chance(10);
    public static ConfiguredFeature<?, ?> WELL_LG = YEModFeatures.WELL_LG.get()
        .withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
        .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
        .chance(10);

    /* Dry wells */
    public static ConfiguredFeature<?, ?> DRY_WELL_SM = YEModFeatures.DRY_WELL_SM.get()
        .withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
        .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
        .chance(10);
    public static ConfiguredFeature<?, ?> DRY_WELL_MD = YEModFeatures.DRY_WELL_MD.get()
        .withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
        .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
        .chance(10);
    public static ConfiguredFeature<?, ?> DRY_WELL_LG = YEModFeatures.DRY_WELL_LG.get()
        .withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
        .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
        .chance(10);

    /* Wishing wells */
    public static ConfiguredFeature<?, ?> WISHING_WELL_SM = YEModFeatures.WISHING_WELL_SM.get()
        .withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
        .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
        .chance(10);
    public static ConfiguredFeature<?, ?> WISHING_WELL_MD = YEModFeatures.WISHING_WELL_MD.get()
        .withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
        .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
        .chance(10);
    public static ConfiguredFeature<?, ?> WISHING_WELL_LG = YEModFeatures.WISHING_WELL_LG.get()
        .withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
        .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
        .chance(10);

    public static void registerConfiguredFeatures() {
        Registry<ConfiguredFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_FEATURE;
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_well_sm"), WELL_SM);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_well_md"), WELL_MD);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_well_lg"), WELL_LG);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_dry_well_sm"), DRY_WELL_SM);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_dry_well_md"), DRY_WELL_MD);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_dry_well_lg"), DRY_WELL_LG);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_wishing_well_sm"), WISHING_WELL_SM);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_wishing_well_md"), WISHING_WELL_MD);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_wishing_well_lg"), WISHING_WELL_LG);
    }
}
