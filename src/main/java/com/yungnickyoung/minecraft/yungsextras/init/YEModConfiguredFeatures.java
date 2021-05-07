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
    public static final ConfiguredFeature<?, ?> WELL_SM = YEModFeatures.WELL_SM.get()
        .withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
        .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
        .chance(10)
        .withPlacement(YEModConfiguredPlacements.RNG_INITIALIZER);
    public static final ConfiguredFeature<?, ?> WELL_MD = YEModFeatures.WELL_MD.get()
        .withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
        .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
        .chance(10)
        .withPlacement(YEModConfiguredPlacements.RNG_INITIALIZER);
    public static final ConfiguredFeature<?, ?> WELL_LG = YEModFeatures.WELL_LG.get()
        .withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
        .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
        .chance(10)
        .withPlacement(YEModConfiguredPlacements.RNG_INITIALIZER);

    /* Dry wells */
    public static final ConfiguredFeature<?, ?> DRY_WELL_SM = YEModFeatures.DRY_WELL_SM.get()
        .withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
        .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
        .chance(10)
        .withPlacement(YEModConfiguredPlacements.RNG_INITIALIZER);
    public static final ConfiguredFeature<?, ?> DRY_WELL_MD = YEModFeatures.DRY_WELL_MD.get()
        .withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
        .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
        .chance(10)
        .withPlacement(YEModConfiguredPlacements.RNG_INITIALIZER);
    public static final ConfiguredFeature<?, ?> DRY_WELL_LG = YEModFeatures.DRY_WELL_LG.get()
        .withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
        .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
        .chance(10)
        .withPlacement(YEModConfiguredPlacements.RNG_INITIALIZER);

    /* Wishing wells */
    public static final ConfiguredFeature<?, ?> WISHING_WELL_SM = YEModFeatures.WISHING_WELL_SM.get()
        .withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
        .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
        .chance(10)
        .withPlacement(YEModConfiguredPlacements.RNG_INITIALIZER);
    public static final ConfiguredFeature<?, ?> WISHING_WELL_MD = YEModFeatures.WISHING_WELL_MD.get()
        .withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
        .withPlacement(YEModConfiguredPlacements.RNG_INITIALIZER)
        .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
        .chance(10);
    public static final ConfiguredFeature<?, ?> WISHING_WELL_LG = YEModFeatures.WISHING_WELL_LG.get()
        .withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
        .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
        .chance(10)
        .withPlacement(YEModConfiguredPlacements.RNG_INITIALIZER);

    /* Obelisks */
    public static final ConfiguredFeature<?, ?> OBELISK = YEModFeatures.OBELISK.get()
        .withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
        .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
        .chance(10)
        .withPlacement(YEModConfiguredPlacements.RNG_INITIALIZER);
    public static final ConfiguredFeature<?, ?> OBELISK_CREEPER = YEModFeatures.OBELISK_CREEPER.get()
        .withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
        .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
        .chance(10)
        .withPlacement(YEModConfiguredPlacements.RNG_INITIALIZER);
    public static final ConfiguredFeature<?, ?> OBELISK_RUINED = YEModFeatures.OBELISK_RUINED.get()
        .withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
        .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
        .chance(10)
        .withPlacement(YEModConfiguredPlacements.RNG_INITIALIZER);
    public static final ConfiguredFeature<?, ?> OBELISK_RARE = YEModFeatures.OBELISK_RARE.get()
        .withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
        .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
        .chance(10)
        .withPlacement(YEModConfiguredPlacements.RNG_INITIALIZER);

    /* Miscellaneous Desert Features */
    public static final ConfiguredFeature<?, ?> GIANT_TORCH = YEModFeatures.GIANT_TORCH.get()
        .withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
        .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
        .chance(10)
        .withPlacement(YEModConfiguredPlacements.RNG_INITIALIZER);
    public static final ConfiguredFeature<?, ?> DESERT_RUINS_0 = YEModFeatures.DESERT_RUINS_0.get()
        .withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
        .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
        .chance(10)
        .withPlacement(YEModConfiguredPlacements.RNG_INITIALIZER);
    public static final ConfiguredFeature<?, ?> CHILLZONE = YEModFeatures.CHILLZONE.get()
        .withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
        .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
        .chance(10)
        .withPlacement(YEModConfiguredPlacements.RNG_INITIALIZER);

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
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_obelisk"), OBELISK);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_obelisk_creeper"), OBELISK_CREEPER);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_obelisk_ruined"), OBELISK_RUINED);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_obelisk_rare"), OBELISK_RARE);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_giant_torch"), GIANT_TORCH);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_ruins_0"), DESERT_RUINS_0);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_chillzone"), CHILLZONE);
    }
}
