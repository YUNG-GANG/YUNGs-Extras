package com.yungnickyoung.minecraft.yungsextras.init;

import com.yungnickyoung.minecraft.yungsextras.YungsExtras;
import com.yungnickyoung.minecraft.yungsextras.config.YEConfig;
import com.yungnickyoung.minecraft.yungsextras.util.NamedConfiguredFeature;
import com.yungnickyoung.minecraft.yungsextras.util.NamedPlacedFeature;
import com.yungnickyoung.minecraft.yungsextras.world.config.StructurePathConfig;
import com.yungnickyoung.minecraft.yungsextras.world.placement.RngInitializerPlacement;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YEModConfiguredFeatures {
    /* Lists of all configured & placed features for convenience during registration */
    public static final List<NamedConfiguredFeature> NAMED_CONFIGURED_FEATURES = new ArrayList<>();
    public static final List<NamedPlacedFeature> NAMED_PLACED_FEATURES = new ArrayList<>();
    public static final Map<Biome.BiomeCategory, List<NamedPlacedFeature>> NAMED_PLACED_FEATURES_BY_BIOME = new HashMap<>();
    static {
        NAMED_PLACED_FEATURES_BY_BIOME.put(Biome.BiomeCategory.DESERT, new ArrayList<>());
        NAMED_PLACED_FEATURES_BY_BIOME.put(Biome.BiomeCategory.SWAMP, new ArrayList<>());
    }

    /* Desert features */
    /* Normal wells */
    public static final NamedConfiguredFeature WELL_SM_CONFIGURED = addConfiguredFeature(YEModFeatures.WELL_SM.get()
            .configured(FeatureConfiguration.NONE), "desert_well_sm");
    public static final NamedPlacedFeature WELL_SM_PLACED = addPlacedFeature(WELL_SM_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YEConfig.desertDecorations.wells.smallNormalWellSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "desert_well_sm",
            Biome.BiomeCategory.DESERT);

    public static final NamedConfiguredFeature WELL_MD_CONFIGURED = addConfiguredFeature(YEModFeatures.WELL_MD.get()
            .configured(FeatureConfiguration.NONE), "desert_well_md");
    public static final NamedPlacedFeature WELL_MD_PLACED = addPlacedFeature(WELL_MD_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YEConfig.desertDecorations.wells.mediumNormalWellSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "desert_well_md",
            Biome.BiomeCategory.DESERT);

    public static final NamedConfiguredFeature WELL_LG_CONFIGURED = addConfiguredFeature(YEModFeatures.WELL_LG.get()
            .configured(FeatureConfiguration.NONE), "desert_well_lg");
    public static final NamedPlacedFeature WELL_LG_PLACED = addPlacedFeature(WELL_LG_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YEConfig.desertDecorations.wells.largeNormalWellSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "desert_well_lg",
            Biome.BiomeCategory.DESERT);

    /* Dry wells */
    public static final NamedConfiguredFeature DRY_WELL_SM_CONFIGURED = addConfiguredFeature(YEModFeatures.DRY_WELL_SM.get()
            .configured(FeatureConfiguration.NONE), "desert_dry_well_sm");
    public static final NamedPlacedFeature DRY_WELL_SM_PLACED = addPlacedFeature(DRY_WELL_SM_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YEConfig.desertDecorations.wells.smallDryWellSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "desert_dry_well_sm",
            Biome.BiomeCategory.DESERT);

    public static final NamedConfiguredFeature DRY_WELL_MD_CONFIGURED = addConfiguredFeature(YEModFeatures.DRY_WELL_MD.get()
            .configured(FeatureConfiguration.NONE), "desert_dry_well_md");
    public static final NamedPlacedFeature DRY_WELL_MD_PLACED = addPlacedFeature(DRY_WELL_MD_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YEConfig.desertDecorations.wells.mediumDryWellSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "desert_dry_well_md",
            Biome.BiomeCategory.DESERT);

    public static final NamedConfiguredFeature DRY_WELL_LG_CONFIGURED = addConfiguredFeature(YEModFeatures.DRY_WELL_LG.get()
            .configured(FeatureConfiguration.NONE), "desert_dry_well_lg");
    public static final NamedPlacedFeature DRY_WELL_LG_PLACED = addPlacedFeature(DRY_WELL_LG_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YEConfig.desertDecorations.wells.largeDryWellSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "desert_dry_well_lg",
            Biome.BiomeCategory.DESERT);

    /* Wishing wells */
    public static final NamedConfiguredFeature WISHING_WELL_SM_CONFIGURED = addConfiguredFeature(YEModFeatures.WISHING_WELL_SM.get()
            .configured(FeatureConfiguration.NONE), "desert_wishing_well_sm");
    public static final NamedPlacedFeature WISHING_WELL_SM_PLACED = addPlacedFeature(WISHING_WELL_SM_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YEConfig.desertDecorations.wells.smallWishingWellSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "desert_wishing_well_sm",
            Biome.BiomeCategory.DESERT);

    public static final NamedConfiguredFeature WISHING_WELL_MD_CONFIGURED = addConfiguredFeature(YEModFeatures.WISHING_WELL_MD.get()
            .configured(FeatureConfiguration.NONE), "desert_wishing_well_md");
    public static final NamedPlacedFeature WISHING_WELL_MD_PLACED = addPlacedFeature(WISHING_WELL_MD_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YEConfig.desertDecorations.wells.mediumWishingWellSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "desert_wishing_well_sm",
            Biome.BiomeCategory.DESERT);

    public static final NamedConfiguredFeature WISHING_WELL_LG_CONFIGURED = addConfiguredFeature(YEModFeatures.WISHING_WELL_LG.get()
            .configured(FeatureConfiguration.NONE), "desert_wishing_well_lg");
    public static final NamedPlacedFeature WISHING_WELL_LG_PLACED = addPlacedFeature(WISHING_WELL_LG_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YEConfig.desertDecorations.wells.largeWishingWellSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "desert_wishing_well_lg",
            Biome.BiomeCategory.DESERT);

    /* Obelisks */
    public static final NamedConfiguredFeature OBELISK_CONFIGURED = addConfiguredFeature(YEModFeatures.OBELISK.get()
            .configured(FeatureConfiguration.NONE), "desert_obelisk");
    public static final NamedPlacedFeature OBELISK_PLACED = addPlacedFeature(OBELISK_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YEConfig.desertDecorations.obelisks.normalObeliskSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "desert_obelisk",
            Biome.BiomeCategory.DESERT);

    public static final NamedConfiguredFeature OBELISK_CREEPER_CONFIGURED = addConfiguredFeature(YEModFeatures.OBELISK_CREEPER.get()
            .configured(FeatureConfiguration.NONE), "desert_obelisk_creeper");
    public static final NamedPlacedFeature OBELISK_CREEPER_PLACED = addPlacedFeature(OBELISK_CREEPER_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YEConfig.desertDecorations.obelisks.creeperObeliskSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "desert_obelisk_creeper",
            Biome.BiomeCategory.DESERT);

    public static final NamedConfiguredFeature OBELISK_RUINED_CONFIGURED = addConfiguredFeature(YEModFeatures.OBELISK_RUINED.get()
            .configured(FeatureConfiguration.NONE), "desert_obelisk_ruined");
    public static final NamedPlacedFeature OBELISK_RUINED_PLACED = addPlacedFeature(OBELISK_RUINED_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YEConfig.desertDecorations.obelisks.ruinedObeliskSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "desert_obelisk_ruined",
            Biome.BiomeCategory.DESERT);

    public static final NamedConfiguredFeature OBELISK_RARE_CONFIGURED = addConfiguredFeature(YEModFeatures.OBELISK_RARE.get()
            .configured(FeatureConfiguration.NONE), "desert_obelisk_rare");
    public static final NamedPlacedFeature OBELISK_RARE_PLACED = addPlacedFeature(OBELISK_RARE_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YEConfig.desertDecorations.obelisks.blackstoneObeliskSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "desert_obelisk_rare",
            Biome.BiomeCategory.DESERT);

    /* Miscellaneous Desert Features */
    public static final NamedConfiguredFeature GIANT_TORCH_CONFIGURED = addConfiguredFeature(YEModFeatures.GIANT_TORCH.get()
            .configured(FeatureConfiguration.NONE), "desert_giant_torch");
    public static final NamedPlacedFeature GIANT_TORCH_PLACED = addPlacedFeature(GIANT_TORCH_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YEConfig.desertDecorations.misc.giantTorchSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "desert_giant_torch",
            Biome.BiomeCategory.DESERT);

    public static final NamedConfiguredFeature DESERT_RUINS_0_CONFIGURED = addConfiguredFeature(YEModFeatures.DESERT_RUINS_0.get()
            .configured(FeatureConfiguration.NONE), "desert_ruins_0");
    public static final NamedPlacedFeature DESERT_RUINS_0_PLACED = addPlacedFeature(DESERT_RUINS_0_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YEConfig.desertDecorations.misc.smallRuinsSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "desert_ruins_0",
            Biome.BiomeCategory.DESERT);

    public static final NamedConfiguredFeature CHILLZONE_CONFIGURED = addConfiguredFeature(YEModFeatures.CHILLZONE.get().
            configured(FeatureConfiguration.NONE), "desert_chillzone");
    public static final NamedPlacedFeature CHILLZONE_PLACED = addPlacedFeature(CHILLZONE_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YEConfig.desertDecorations.misc.chillzoneSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "desert_chillzone",
            Biome.BiomeCategory.DESERT);

    /* Swamp features */
    public static final NamedConfiguredFeature SWAMP_PILLAR_CONFIGURED_0 = addConfiguredFeature(YEModFeatures.SWAMP_PILLAR.get()
            .configured(new StructurePathConfig("swamp/pillar/swamp_pillar_0")), "swamp_pillar_0");
    public static final NamedPlacedFeature SWAMP_PILLAR_PLACED_0 = addPlacedFeature(SWAMP_PILLAR_CONFIGURED_0.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YEConfig.swamp.pillarSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "swamp_pillar_0",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_PILLAR_CONFIGURED_1 = addConfiguredFeature(YEModFeatures.SWAMP_PILLAR.get()
            .configured(new StructurePathConfig("swamp/pillar/swamp_pillar_1")), "swamp_pillar_1");
    public static final NamedPlacedFeature SWAMP_PILLAR_PLACED_1 = addPlacedFeature(SWAMP_PILLAR_CONFIGURED_1.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YEConfig.swamp.pillarSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "swamp_pillar_1",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_PILLAR_CONFIGURED_2 = addConfiguredFeature(YEModFeatures.SWAMP_PILLAR.get()
            .configured(new StructurePathConfig("swamp/pillar/swamp_pillar_2")), "swamp_pillar_2");
    public static final NamedPlacedFeature SWAMP_PILLAR_PLACED_2 = addPlacedFeature(SWAMP_PILLAR_CONFIGURED_2.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YEConfig.swamp.pillarSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "swamp_pillar_2",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_OGRE_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_OGRE.get()
            .configured(new StructurePathConfig("swamp/misc/swamp_ogre_0")), "swamp_ogre");
    public static final NamedPlacedFeature SWAMP_OGRE_PLACED = addPlacedFeature(SWAMP_OGRE_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YEConfig.swamp.ogreSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "swamp_ogre",
            Biome.BiomeCategory.SWAMP);

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
    private static NamedPlacedFeature addPlacedFeature(PlacedFeature placedFeature, String name, Biome.BiomeCategory biomeCategory) {
        NamedPlacedFeature namedPlacedFeature = new NamedPlacedFeature(name, placedFeature);
        NAMED_PLACED_FEATURES.add(namedPlacedFeature);
        NAMED_PLACED_FEATURES_BY_BIOME.get(biomeCategory).add(namedPlacedFeature);
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
