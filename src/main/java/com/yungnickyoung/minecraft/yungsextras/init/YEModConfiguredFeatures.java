package com.yungnickyoung.minecraft.yungsextras.init;

import com.yungnickyoung.minecraft.yungsextras.YungsExtras;
import com.yungnickyoung.minecraft.yungsextras.util.NamedConfiguredFeature;
import com.yungnickyoung.minecraft.yungsextras.util.NamedPlacedFeature;
import com.yungnickyoung.minecraft.yungsextras.world.placement.RngInitializerPlacement;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

import java.util.ArrayList;
import java.util.List;

public class YEModConfiguredFeatures {
    /* Lists of all configured & placed features for convenience during registration */
    public static final List<NamedConfiguredFeature> NAMED_CONFIGURED_FEATURES = new ArrayList<>();
    public static final List<NamedPlacedFeature> NAMED_PLACED_FEATURES = new ArrayList<>();

    /* Normal wells */
    public static final NamedConfiguredFeature WELL_SM_CONFIGURED = addConfiguredFeature(YEModFeatures.WELL_SM.feature()
            .configured(FeatureConfiguration.NONE), "desert_well_sm");
    public static final NamedPlacedFeature WELL_SM_PLACED = addPlacedFeature(WELL_SM_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YungsExtras.CONFIG.yungsExtras.desertDecorations.wells.smallNormalWellSpawnRate),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "desert_well_sm");

    public static final NamedConfiguredFeature WELL_MD_CONFIGURED = addConfiguredFeature(YEModFeatures.WELL_MD.feature()
            .configured(FeatureConfiguration.NONE), "desert_well_md");
    public static final NamedPlacedFeature WELL_MD_PLACED = addPlacedFeature(WELL_MD_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YungsExtras.CONFIG.yungsExtras.desertDecorations.wells.mediumNormalWellSpawnRate),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "desert_well_md");

    public static final NamedConfiguredFeature WELL_LG_CONFIGURED = addConfiguredFeature(YEModFeatures.WELL_LG.feature()
            .configured(FeatureConfiguration.NONE), "desert_well_lg");
    public static final NamedPlacedFeature WELL_LG_PLACED = addPlacedFeature(WELL_LG_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YungsExtras.CONFIG.yungsExtras.desertDecorations.wells.largeNormalWellSpawnRate),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "desert_well_lg");

    /* Dry wells */
    public static final NamedConfiguredFeature DRY_WELL_SM_CONFIGURED = addConfiguredFeature(YEModFeatures.DRY_WELL_SM.feature()
            .configured(FeatureConfiguration.NONE), "desert_dry_well_sm");
    public static final NamedPlacedFeature DRY_WELL_SM_PLACED = addPlacedFeature(DRY_WELL_SM_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YungsExtras.CONFIG.yungsExtras.desertDecorations.wells.smallDryWellSpawnRate),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "desert_dry_well_sm");

    public static final NamedConfiguredFeature DRY_WELL_MD_CONFIGURED = addConfiguredFeature(YEModFeatures.DRY_WELL_MD.feature()
            .configured(FeatureConfiguration.NONE), "desert_dry_well_md");
    public static final NamedPlacedFeature DRY_WELL_MD_PLACED = addPlacedFeature(DRY_WELL_MD_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YungsExtras.CONFIG.yungsExtras.desertDecorations.wells.mediumDryWellSpawnRate),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "desert_dry_well_md");

    public static final NamedConfiguredFeature DRY_WELL_LG_CONFIGURED = addConfiguredFeature(YEModFeatures.DRY_WELL_LG.feature()
            .configured(FeatureConfiguration.NONE), "desert_dry_well_lg");
    public static final NamedPlacedFeature DRY_WELL_LG_PLACED = addPlacedFeature(DRY_WELL_LG_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YungsExtras.CONFIG.yungsExtras.desertDecorations.wells.largeDryWellSpawnRate),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "desert_dry_well_lg");

    /* Wishing wells */
    public static final NamedConfiguredFeature WISHING_WELL_SM_CONFIGURED = addConfiguredFeature(YEModFeatures.WISHING_WELL_SM.feature()
            .configured(FeatureConfiguration.NONE), "desert_wishing_well_sm");
    public static final NamedPlacedFeature WISHING_WELL_SM_PLACED = addPlacedFeature(WISHING_WELL_SM_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YungsExtras.CONFIG.yungsExtras.desertDecorations.wells.smallWishingWellSpawnRate),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "desert_wishing_well_sm");

    public static final NamedConfiguredFeature WISHING_WELL_MD_CONFIGURED = addConfiguredFeature(YEModFeatures.WISHING_WELL_MD.feature()
            .configured(FeatureConfiguration.NONE), "desert_wishing_well_md");
    public static final NamedPlacedFeature WISHING_WELL_MD_PLACED = addPlacedFeature(WISHING_WELL_MD_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YungsExtras.CONFIG.yungsExtras.desertDecorations.wells.mediumWishingWellSpawnRate),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "desert_wishing_well_md");

    public static final NamedConfiguredFeature WISHING_WELL_LG_CONFIGURED = addConfiguredFeature(YEModFeatures.WISHING_WELL_LG.feature()
            .configured(FeatureConfiguration.NONE), "desert_wishing_well_lg");
    public static final NamedPlacedFeature WISHING_WELL_LG_PLACED = addPlacedFeature(WISHING_WELL_LG_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YungsExtras.CONFIG.yungsExtras.desertDecorations.wells.largeWishingWellSpawnRate),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "desert_wishing_well_lg");

    /* Obelisks */
    public static final NamedConfiguredFeature OBELISK_CONFIGURED = addConfiguredFeature(YEModFeatures.OBELISK.feature()
            .configured(FeatureConfiguration.NONE), "desert_obelisk");
    public static final NamedPlacedFeature OBELISK_PLACED = addPlacedFeature(OBELISK_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YungsExtras.CONFIG.yungsExtras.desertDecorations.obelisks.normalObeliskSpawnRate),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "desert_obelisk");

    public static final NamedConfiguredFeature OBELISK_CREEPER_CONFIGURED = addConfiguredFeature(YEModFeatures.OBELISK_CREEPER.feature()
            .configured(FeatureConfiguration.NONE), "desert_obelisk_creeper");
    public static final NamedPlacedFeature OBELISK_CREEPER_PLACED = addPlacedFeature(OBELISK_CREEPER_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YungsExtras.CONFIG.yungsExtras.desertDecorations.obelisks.creeperObeliskSpawnRate),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "desert_obelisk_creeper");

    public static final NamedConfiguredFeature OBELISK_RUINED_CONFIGURED = addConfiguredFeature(YEModFeatures.OBELISK_RUINED.feature()
            .configured(FeatureConfiguration.NONE), "desert_obelisk_ruined");
    public static final NamedPlacedFeature OBELISK_RUINED_PLACED = addPlacedFeature(OBELISK_RUINED_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YungsExtras.CONFIG.yungsExtras.desertDecorations.obelisks.ruinedObeliskSpawnRate),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "desert_obelisk_ruined");

    public static final NamedConfiguredFeature OBELISK_RARE_CONFIGURED = addConfiguredFeature(YEModFeatures.OBELISK_RARE.feature()
            .configured(FeatureConfiguration.NONE), "desert_obelisk_rare");
    public static final NamedPlacedFeature OBELISK_RARE_PLACED = addPlacedFeature(OBELISK_RARE_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YungsExtras.CONFIG.yungsExtras.desertDecorations.obelisks.blackstoneObeliskSpawnRate),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "desert_obelisk_rare");

    /* Miscellaneous Desert Features */
    public static final NamedConfiguredFeature GIANT_TORCH_CONFIGURED = addConfiguredFeature(YEModFeatures.GIANT_TORCH.feature()
            .configured(FeatureConfiguration.NONE), "desert_giant_torch");
    public static final NamedPlacedFeature GIANT_TORCH_PLACED = addPlacedFeature(GIANT_TORCH_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YungsExtras.CONFIG.yungsExtras.desertDecorations.misc.giantTorchSpawnRate),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "desert_giant_torch");

    public static final NamedConfiguredFeature DESERT_RUINS_0_CONFIGURED = addConfiguredFeature(YEModFeatures.DESERT_RUINS_0.feature()
            .configured(FeatureConfiguration.NONE), "desert_ruins_0");
    public static final NamedPlacedFeature DESERT_RUINS_0_PLACED = addPlacedFeature(DESERT_RUINS_0_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YungsExtras.CONFIG.yungsExtras.desertDecorations.misc.smallRuinsSpawnRate),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "desert_ruins_0");

    public static final NamedConfiguredFeature CHILLZONE_CONFIGURED = addConfiguredFeature(YEModFeatures.CHILLZONE.feature()
            .configured(FeatureConfiguration.NONE), "desert_chillzone");
    public static final NamedPlacedFeature CHILLZONE_PLACED = addPlacedFeature(CHILLZONE_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YungsExtras.CONFIG.yungsExtras.desertDecorations.misc.chillzoneSpawnRate),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "desert_chillzone");

    /**
     * Adds a ConfiguredFeature & its registry name to the NAMED_CONFIGURED_FEATURES list.
     */
    private static NamedConfiguredFeature addConfiguredFeature(ConfiguredFeature<?, ?> configuredFeature, String name) {
        NamedConfiguredFeature namedConfiguredFeature = new NamedConfiguredFeature(name, configuredFeature);
        NAMED_CONFIGURED_FEATURES.add(namedConfiguredFeature);
        return namedConfiguredFeature;
    }

    /**
     * Adds a PlacedFeature & its registry name to the NAMED_PLACED_FEATURES list.
     */
    private static NamedPlacedFeature addPlacedFeature(PlacedFeature placedFeature, String name) {
        NamedPlacedFeature namedPlacedFeature = new NamedPlacedFeature(name, placedFeature);
        NAMED_PLACED_FEATURES.add(namedPlacedFeature);
        return namedPlacedFeature;
    }

    /**
     * Registers all ConfiguredFeatures, listed above.
     */
    public static void registerConfiguredFeatures() {
        NAMED_CONFIGURED_FEATURES.forEach(namedConfiguredFeature -> {
            ConfiguredFeature<?, ?> configuredFeature = namedConfiguredFeature.configuredFeature();
            String name = namedConfiguredFeature.name();
            Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(YungsExtras.MOD_ID, name), configuredFeature);
        });
    }

    /**
     * Registers all PlacedFeatures, listed above.
     */
    public static void registerPlacedFeatures() {
        NAMED_PLACED_FEATURES.forEach(namedPlacedFeature -> {
            PlacedFeature placedFeature = namedPlacedFeature.placedFeature();
            String name = namedPlacedFeature.name();
            Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(YungsExtras.MOD_ID, name), placedFeature);
        });
    }
}
