package com.yungnickyoung.minecraft.yungsextras.init;

import com.yungnickyoung.minecraft.yungsextras.YungsExtras;
import com.yungnickyoung.minecraft.yungsextras.config.YEConfig;
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

public class YEModConfiguredFeatures {
    /* Normal wells */
    public static final ConfiguredFeature<?, ?> WELL_SM_CONFIGURED = YEModFeatures.WELL_SM.get().configured(FeatureConfiguration.NONE);
    public static final PlacedFeature WELL_SM_PLACED = WELL_SM_CONFIGURED.placed(
            RarityFilter.onAverageOnceEvery(YEConfig.desertDecorations.wells.smallNormalWellSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize());

    public static final ConfiguredFeature<?, ?> WELL_MD_CONFIGURED = YEModFeatures.WELL_MD.get().configured(FeatureConfiguration.NONE);
    public static final PlacedFeature WELL_MD_PLACED = WELL_MD_CONFIGURED.placed(
            RarityFilter.onAverageOnceEvery(YEConfig.desertDecorations.wells.mediumNormalWellSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize());

    public static final ConfiguredFeature<?, ?> WELL_LG_CONFIGURED = YEModFeatures.WELL_LG.get().configured(FeatureConfiguration.NONE);
    public static final PlacedFeature WELL_LG_PLACED = WELL_LG_CONFIGURED.placed(
            RarityFilter.onAverageOnceEvery(YEConfig.desertDecorations.wells.largeNormalWellSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize());

    /* Dry wells */
    public static final ConfiguredFeature<?, ?> DRY_WELL_SM_CONFIGURED = YEModFeatures.DRY_WELL_SM.get().configured(FeatureConfiguration.NONE);
    public static final PlacedFeature DRY_WELL_SM_PLACED = DRY_WELL_SM_CONFIGURED.placed(
            RarityFilter.onAverageOnceEvery(YEConfig.desertDecorations.wells.smallDryWellSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize());

    public static final ConfiguredFeature<?, ?> DRY_WELL_MD_CONFIGURED = YEModFeatures.DRY_WELL_MD.get().configured(FeatureConfiguration.NONE);
    public static final PlacedFeature DRY_WELL_MD_PLACED = DRY_WELL_MD_CONFIGURED.placed(
            RarityFilter.onAverageOnceEvery(YEConfig.desertDecorations.wells.mediumDryWellSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize());

    public static final ConfiguredFeature<?, ?> DRY_WELL_LG_CONFIGURED = YEModFeatures.DRY_WELL_LG.get().configured(FeatureConfiguration.NONE);
    public static final PlacedFeature DRY_WELL_LG_PLACED = DRY_WELL_LG_CONFIGURED.placed(
            RarityFilter.onAverageOnceEvery(YEConfig.desertDecorations.wells.largeDryWellSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize());

    /* Wishing wells */
    public static final ConfiguredFeature<?, ?> WISHING_WELL_SM_CONFIGURED = YEModFeatures.WISHING_WELL_SM.get().configured(FeatureConfiguration.NONE);
    public static final PlacedFeature WISHING_WELL_SM_PLACED = WISHING_WELL_SM_CONFIGURED.placed(
            RarityFilter.onAverageOnceEvery(YEConfig.desertDecorations.wells.smallWishingWellSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize());

    public static final ConfiguredFeature<?, ?> WISHING_WELL_MD_CONFIGURED = YEModFeatures.WISHING_WELL_MD.get().configured(FeatureConfiguration.NONE);
    public static final PlacedFeature WISHING_WELL_MD_PLACED = WISHING_WELL_MD_CONFIGURED.placed(
            RarityFilter.onAverageOnceEvery(YEConfig.desertDecorations.wells.mediumWishingWellSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize());

    public static final ConfiguredFeature<?, ?> WISHING_WELL_LG_CONFIGURED = YEModFeatures.WISHING_WELL_LG.get().configured(FeatureConfiguration.NONE);
    public static final PlacedFeature WISHING_WELL_LG_PLACED = WISHING_WELL_LG_CONFIGURED.placed(
            RarityFilter.onAverageOnceEvery(YEConfig.desertDecorations.wells.largeWishingWellSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize());

    /* Obelisks */
    public static final ConfiguredFeature<?, ?> OBELISK_CONFIGURED = YEModFeatures.OBELISK.get().configured(FeatureConfiguration.NONE);
    public static final PlacedFeature OBELISK_PLACED = OBELISK_CONFIGURED.placed(
            RarityFilter.onAverageOnceEvery(YEConfig.desertDecorations.obelisks.normalObeliskSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize());

    public static final ConfiguredFeature<?, ?> OBELISK_CREEPER_CONFIGURED = YEModFeatures.OBELISK_CREEPER.get().configured(FeatureConfiguration.NONE);
    public static final PlacedFeature OBELISK_CREEPER_PLACED = OBELISK_CREEPER_CONFIGURED.placed(
            RarityFilter.onAverageOnceEvery(YEConfig.desertDecorations.obelisks.creeperObeliskSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize());

    public static final ConfiguredFeature<?, ?> OBELISK_RUINED_CONFIGURED = YEModFeatures.OBELISK_RUINED.get().configured(FeatureConfiguration.NONE);
    public static final PlacedFeature OBELISK_RUINED_PLACED = OBELISK_RUINED_CONFIGURED.placed(
            RarityFilter.onAverageOnceEvery(YEConfig.desertDecorations.obelisks.ruinedObeliskSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize());

    public static final ConfiguredFeature<?, ?> OBELISK_RARE_CONFIGURED = YEModFeatures.OBELISK_RARE.get().configured(FeatureConfiguration.NONE);
    public static final PlacedFeature OBELISK_RARE_PLACED = OBELISK_RARE_CONFIGURED.placed(
            RarityFilter.onAverageOnceEvery(YEConfig.desertDecorations.obelisks.blackstoneObeliskSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize());

    /* Miscellaneous Desert Features */
    public static final ConfiguredFeature<?, ?> GIANT_TORCH_CONFIGURED = YEModFeatures.GIANT_TORCH.get().configured(FeatureConfiguration.NONE);
    public static final PlacedFeature GIANT_TORCH_PLACED = GIANT_TORCH_CONFIGURED.placed(
            RarityFilter.onAverageOnceEvery(YEConfig.desertDecorations.misc.giantTorchSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize());

    public static final ConfiguredFeature<?, ?> DESERT_RUINS_0_CONFIGURED = YEModFeatures.DESERT_RUINS_0.get().configured(FeatureConfiguration.NONE);
    public static final PlacedFeature DESERT_RUINS_0_PLACED = DESERT_RUINS_0_CONFIGURED.placed(
            RarityFilter.onAverageOnceEvery(YEConfig.desertDecorations.misc.smallRuinsSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize());

    public static final ConfiguredFeature<?, ?> CHILLZONE_CONFIGURED = YEModFeatures.CHILLZONE.get().configured(FeatureConfiguration.NONE);
    public static final PlacedFeature CHILLZONE_PLACED = CHILLZONE_CONFIGURED.placed(
            RarityFilter.onAverageOnceEvery(YEConfig.desertDecorations.misc.chillzoneSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize());

    public static void registerConfiguredFeatures() {
        Registry<ConfiguredFeature<?, ?>> registry = BuiltinRegistries.CONFIGURED_FEATURE;
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_well_sm"), WELL_SM_CONFIGURED);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_well_md"), WELL_MD_CONFIGURED);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_well_lg"), WELL_LG_CONFIGURED);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_dry_well_sm"), DRY_WELL_SM_CONFIGURED);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_dry_well_md"), DRY_WELL_MD_CONFIGURED);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_dry_well_lg"), DRY_WELL_LG_CONFIGURED);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_wishing_well_sm"), WISHING_WELL_SM_CONFIGURED);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_wishing_well_md"), WISHING_WELL_MD_CONFIGURED);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_wishing_well_lg"), WISHING_WELL_LG_CONFIGURED);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_obelisk"), OBELISK_CONFIGURED);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_obelisk_creeper"), OBELISK_CREEPER_CONFIGURED);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_obelisk_ruined"), OBELISK_RUINED_CONFIGURED);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_obelisk_rare"), OBELISK_RARE_CONFIGURED);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_giant_torch"), GIANT_TORCH_CONFIGURED);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_ruins_0"), DESERT_RUINS_0_CONFIGURED);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_chillzone"), CHILLZONE_CONFIGURED);
    }

    public static void registerPlacedFeatures() {
        Registry<PlacedFeature> registry = BuiltinRegistries.PLACED_FEATURE;
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_well_sm"), WELL_SM_PLACED);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_well_md"), WELL_MD_PLACED);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_well_lg"), WELL_LG_PLACED);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_dry_well_sm"), DRY_WELL_SM_PLACED);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_dry_well_md"), DRY_WELL_MD_PLACED);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_dry_well_lg"), DRY_WELL_LG_PLACED);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_wishing_well_sm"), WISHING_WELL_SM_PLACED);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_wishing_well_md"), WISHING_WELL_MD_PLACED);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_wishing_well_lg"), WISHING_WELL_LG_PLACED);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_obelisk"), OBELISK_PLACED);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_obelisk_creeper"), OBELISK_CREEPER_PLACED);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_obelisk_ruined"), OBELISK_RUINED_PLACED);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_obelisk_rare"), OBELISK_RARE_PLACED);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_giant_torch"), GIANT_TORCH_PLACED);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_ruins_0"), DESERT_RUINS_0_PLACED);
        Registry.register(registry, new ResourceLocation(YungsExtras.MOD_ID, "desert_chillzone"), CHILLZONE_PLACED);
    }
}
