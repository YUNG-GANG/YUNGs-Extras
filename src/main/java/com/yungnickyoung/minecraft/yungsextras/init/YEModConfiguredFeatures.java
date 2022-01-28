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
            "desert_wishing_well_md",
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
    /* Pillars */
    public static final NamedConfiguredFeature SWAMP_PILLAR_0_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_PILLAR.get()
            .configured(new StructurePathConfig("swamp/pillar/swamp_pillar_0")), "swamp_pillar_0");
    public static final NamedPlacedFeature SWAMP_PILLAR_PLACED_0 = addPlacedFeature(SWAMP_PILLAR_0_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YEConfig.swamp.pillarSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "swamp_pillar_0",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_PILLAR_1_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_PILLAR.get()
            .configured(new StructurePathConfig("swamp/pillar/swamp_pillar_1")), "swamp_pillar_1");
    public static final NamedPlacedFeature SWAMP_PILLAR_PLACED_1 = addPlacedFeature(SWAMP_PILLAR_1_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YEConfig.swamp.pillarSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "swamp_pillar_1",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_PILLAR_2_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_PILLAR.get()
            .configured(new StructurePathConfig("swamp/pillar/swamp_pillar_2")), "swamp_pillar_2");
    public static final NamedPlacedFeature SWAMP_PILLAR_PLACED_2 = addPlacedFeature(SWAMP_PILLAR_2_CONFIGURED.configuredFeature().placed(
            RarityFilter.onAverageOnceEvery(YEConfig.swamp.pillarSpawnRate.get()),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            RngInitializerPlacement.randomize()),
            "swamp_pillar_2",
            Biome.BiomeCategory.SWAMP);

    /* Cubbies */
    public static final NamedConfiguredFeature SWAMP_CUBBY_0_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_CUBBY.get()
            .configured(new StructurePathConfig("swamp/cubby/swamp_cubby_0")), "swamp_cubby_0");
    public static final NamedPlacedFeature SWAMP_CUBBY_0_PLACED = addPlacedFeature(SWAMP_CUBBY_0_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.cubbySpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_cubby_0",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_CUBBY_1_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_CUBBY.get()
            .configured(new StructurePathConfig("swamp/cubby/swamp_cubby_1")), "swamp_cubby_1");
    public static final NamedPlacedFeature SWAMP_CUBBY_1_PLACED = addPlacedFeature(SWAMP_CUBBY_1_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.cubbySpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_cubby_1",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_CUBBY_2_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_CUBBY.get()
            .configured(new StructurePathConfig("swamp/cubby/swamp_cubby_2")), "swamp_cubby_2");
    public static final NamedPlacedFeature SWAMP_CUBBY_2_PLACED = addPlacedFeature(SWAMP_CUBBY_2_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.cubbySpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_cubby_2",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_CUBBY_3_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_CUBBY.get()
            .configured(new StructurePathConfig("swamp/cubby/swamp_cubby_3")), "swamp_cubby_3");
    public static final NamedPlacedFeature SWAMP_CUBBY_3_PLACED = addPlacedFeature(SWAMP_CUBBY_3_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.cubbySpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_cubby_3",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_CUBBY_4_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_CUBBY.get()
            .configured(new StructurePathConfig("swamp/cubby/swamp_cubby_4")), "swamp_cubby_4");
    public static final NamedPlacedFeature SWAMP_CUBBY_4_PLACED = addPlacedFeature(SWAMP_CUBBY_4_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.cubbySpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_cubby_4",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_CUBBY_5_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_CUBBY.get()
            .configured(new StructurePathConfig("swamp/cubby/swamp_cubby_5")), "swamp_cubby_5");
    public static final NamedPlacedFeature SWAMP_CUBBY_5_PLACED = addPlacedFeature(SWAMP_CUBBY_5_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.cubbySpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_cubby_5",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_CUBBY_6_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_CUBBY.get()
            .configured(new StructurePathConfig("swamp/cubby/swamp_cubby_6")), "swamp_cubby_6");
    public static final NamedPlacedFeature SWAMP_CUBBY_6_PLACED = addPlacedFeature(SWAMP_CUBBY_6_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.cubbySpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_cubby_6",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_CUBBY_7_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_CUBBY.get()
            .configured(new StructurePathConfig("swamp/cubby/swamp_cubby_7")), "swamp_cubby_7");
    public static final NamedPlacedFeature SWAMP_CUBBY_7_PLACED = addPlacedFeature(SWAMP_CUBBY_7_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.cubbySpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_cubby_7",
            Biome.BiomeCategory.SWAMP);

    /* Arches */
    public static final NamedConfiguredFeature SWAMP_ARCH_0_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_ARCH.get()
            .configured(new StructurePathConfig("swamp/arch/swamp_arch_0")), "swamp_arch_0");
    public static final NamedPlacedFeature SWAMP_ARCH_0_PLACED = addPlacedFeature(SWAMP_ARCH_0_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.archSpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_arch_0",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_ARCH_1_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_ARCH.get()
            .configured(new StructurePathConfig("swamp/arch/swamp_arch_1")), "swamp_arch_1");
    public static final NamedPlacedFeature SWAMP_ARCH_1_PLACED = addPlacedFeature(SWAMP_ARCH_1_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.archSpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_arch_1",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_ARCH_2_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_ARCH.get()
            .configured(new StructurePathConfig("swamp/arch/swamp_arch_2")), "swamp_arch_2");
    public static final NamedPlacedFeature SWAMP_ARCH_2_PLACED = addPlacedFeature(SWAMP_ARCH_2_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.archSpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_arch_2",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_ARCH_3_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_ARCH.get()
            .configured(new StructurePathConfig("swamp/arch/swamp_arch_3")), "swamp_arch_3");
    public static final NamedPlacedFeature SWAMP_ARCH_3_PLACED = addPlacedFeature(SWAMP_ARCH_3_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.archSpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_arch_3",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_ARCH_4_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_ARCH.get()
            .configured(new StructurePathConfig("swamp/arch/swamp_arch_4")), "swamp_arch_4");
    public static final NamedPlacedFeature SWAMP_ARCH_4_PLACED = addPlacedFeature(SWAMP_ARCH_4_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.archSpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_arch_4",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_ARCH_5_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_ARCH.get()
            .configured(new StructurePathConfig("swamp/arch/swamp_arch_5")), "swamp_arch_5");
    public static final NamedPlacedFeature SWAMP_ARCH_5_PLACED = addPlacedFeature(SWAMP_ARCH_5_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.archSpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_arch_5",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_ARCH_6_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_ARCH.get()
            .configured(new StructurePathConfig("swamp/arch/swamp_arch_6")), "swamp_arch_6");
    public static final NamedPlacedFeature SWAMP_ARCH_6_PLACED = addPlacedFeature(SWAMP_ARCH_6_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.archSpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_arch_6",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_ARCH_7_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_ARCH.get()
            .configured(new StructurePathConfig("swamp/arch/swamp_arch_7")), "swamp_arch_7");
    public static final NamedPlacedFeature SWAMP_ARCH_7_PLACED = addPlacedFeature(SWAMP_ARCH_7_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.archSpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_arch_7",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_ARCH_8_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_ARCH.get()
            .configured(new StructurePathConfig("swamp/arch/swamp_arch_8")), "swamp_arch_8");
    public static final NamedPlacedFeature SWAMP_ARCH_8_PLACED = addPlacedFeature(SWAMP_ARCH_8_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.archSpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_arch_8",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_ARCH_9_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_ARCH.get()
            .configured(new StructurePathConfig("swamp/arch/swamp_arch_9")), "swamp_arch_9");
    public static final NamedPlacedFeature SWAMP_ARCH_9_PLACED = addPlacedFeature(SWAMP_ARCH_9_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.archSpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_arch_9",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_ARCH_10_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_ARCH.get()
            .configured(new StructurePathConfig("swamp/arch/swamp_arch_10")), "swamp_arch_10");
    public static final NamedPlacedFeature SWAMP_ARCH_10_PLACED = addPlacedFeature(SWAMP_ARCH_10_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.archSpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_arch_10",
            Biome.BiomeCategory.SWAMP);

    /* Double arches */
    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_0_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_DOUBLE_ARCH.get()
            .configured(new StructurePathConfig("swamp/double_arch/swamp_double_arch_0")), "swamp_double_arch_0");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_0_PLACED = addPlacedFeature(SWAMP_DOUBLE_ARCH_0_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.doubleArchSpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_double_arch_0",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_1_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_DOUBLE_ARCH.get()
            .configured(new StructurePathConfig("swamp/double_arch/swamp_double_arch_1")), "swamp_double_arch_1");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_1_PLACED = addPlacedFeature(SWAMP_DOUBLE_ARCH_1_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.doubleArchSpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_double_arch_1",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_2_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_DOUBLE_ARCH.get()
            .configured(new StructurePathConfig("swamp/double_arch/swamp_double_arch_2")), "swamp_double_arch_2");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_2_PLACED = addPlacedFeature(SWAMP_DOUBLE_ARCH_2_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.doubleArchSpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_double_arch_2",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_3_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_DOUBLE_ARCH.get()
            .configured(new StructurePathConfig("swamp/double_arch/swamp_double_arch_3")), "swamp_double_arch_3");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_3_PLACED = addPlacedFeature(SWAMP_DOUBLE_ARCH_3_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.doubleArchSpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_double_arch_3",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_4_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_DOUBLE_ARCH.get()
            .configured(new StructurePathConfig("swamp/double_arch/swamp_double_arch_4")), "swamp_double_arch_4");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_4_PLACED = addPlacedFeature(SWAMP_DOUBLE_ARCH_4_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.doubleArchSpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_double_arch_4",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_5_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_DOUBLE_ARCH.get()
            .configured(new StructurePathConfig("swamp/double_arch/swamp_double_arch_5")), "swamp_double_arch_5");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_5_PLACED = addPlacedFeature(SWAMP_DOUBLE_ARCH_5_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.doubleArchSpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_double_arch_5",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_6_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_DOUBLE_ARCH.get()
            .configured(new StructurePathConfig("swamp/double_arch/swamp_double_arch_6")), "swamp_double_arch_6");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_6_PLACED = addPlacedFeature(SWAMP_DOUBLE_ARCH_6_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.doubleArchSpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_double_arch_6",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_7_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_DOUBLE_ARCH.get()
            .configured(new StructurePathConfig("swamp/double_arch/swamp_double_arch_7")), "swamp_double_arch_7");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_7_PLACED = addPlacedFeature(SWAMP_DOUBLE_ARCH_7_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.doubleArchSpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_double_arch_7",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_8_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_DOUBLE_ARCH.get()
            .configured(new StructurePathConfig("swamp/double_arch/swamp_double_arch_8")), "swamp_double_arch_8");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_8_PLACED = addPlacedFeature(SWAMP_DOUBLE_ARCH_8_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.doubleArchSpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_double_arch_8",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_9_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_DOUBLE_ARCH.get()
            .configured(new StructurePathConfig("swamp/double_arch/swamp_double_arch_9")), "swamp_double_arch_9");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_9_PLACED = addPlacedFeature(SWAMP_DOUBLE_ARCH_9_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.doubleArchSpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_double_arch_9",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_10_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_DOUBLE_ARCH.get()
            .configured(new StructurePathConfig("swamp/double_arch/swamp_double_arch_10")), "swamp_double_arch_10");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_10_PLACED = addPlacedFeature(SWAMP_DOUBLE_ARCH_10_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.doubleArchSpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_double_arch_10",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_11_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_DOUBLE_ARCH.get()
            .configured(new StructurePathConfig("swamp/double_arch/swamp_double_arch_11")), "swamp_double_arch_11");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_11_PLACED = addPlacedFeature(SWAMP_DOUBLE_ARCH_11_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.doubleArchSpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_double_arch_11",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_12_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_DOUBLE_ARCH.get()
            .configured(new StructurePathConfig("swamp/double_arch/swamp_double_arch_12")), "swamp_double_arch_12");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_12_PLACED = addPlacedFeature(SWAMP_DOUBLE_ARCH_12_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.doubleArchSpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_double_arch_12",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_13_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_DOUBLE_ARCH.get()
            .configured(new StructurePathConfig("swamp/double_arch/swamp_double_arch_13")), "swamp_double_arch_13");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_13_PLACED = addPlacedFeature(SWAMP_DOUBLE_ARCH_13_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.doubleArchSpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_double_arch_13",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_14_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_DOUBLE_ARCH.get()
            .configured(new StructurePathConfig("swamp/double_arch/swamp_double_arch_14")), "swamp_double_arch_14");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_14_PLACED = addPlacedFeature(SWAMP_DOUBLE_ARCH_14_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.doubleArchSpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_double_arch_14",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_15_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_DOUBLE_ARCH.get()
            .configured(new StructurePathConfig("swamp/double_arch/swamp_double_arch_15")), "swamp_double_arch_15");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_15_PLACED = addPlacedFeature(SWAMP_DOUBLE_ARCH_15_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.doubleArchSpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_double_arch_15",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_16_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_DOUBLE_ARCH.get()
            .configured(new StructurePathConfig("swamp/double_arch/swamp_double_arch_16")), "swamp_double_arch_16");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_16_PLACED = addPlacedFeature(SWAMP_DOUBLE_ARCH_16_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.doubleArchSpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_double_arch_16",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_17_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_DOUBLE_ARCH.get()
            .configured(new StructurePathConfig("swamp/double_arch/swamp_double_arch_17")), "swamp_double_arch_17");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_17_PLACED = addPlacedFeature(SWAMP_DOUBLE_ARCH_17_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.doubleArchSpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_double_arch_17",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_18_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_DOUBLE_ARCH.get()
            .configured(new StructurePathConfig("swamp/double_arch/swamp_double_arch_18")), "swamp_double_arch_18");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_18_PLACED = addPlacedFeature(SWAMP_DOUBLE_ARCH_18_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.doubleArchSpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_double_arch_18",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_19_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_DOUBLE_ARCH.get()
            .configured(new StructurePathConfig("swamp/double_arch/swamp_double_arch_19")), "swamp_double_arch_19");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_19_PLACED = addPlacedFeature(SWAMP_DOUBLE_ARCH_19_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.doubleArchSpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_double_arch_19",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_20_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_DOUBLE_ARCH.get()
            .configured(new StructurePathConfig("swamp/double_arch/swamp_double_arch_20")), "swamp_double_arch_20");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_20_PLACED = addPlacedFeature(SWAMP_DOUBLE_ARCH_20_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.doubleArchSpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_double_arch_20",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_21_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_DOUBLE_ARCH.get()
            .configured(new StructurePathConfig("swamp/double_arch/swamp_double_arch_21")), "swamp_double_arch_21");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_21_PLACED = addPlacedFeature(SWAMP_DOUBLE_ARCH_21_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.doubleArchSpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_double_arch_21",
            Biome.BiomeCategory.SWAMP);

    /* Miscellaneous swamp features */
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

    public static final NamedConfiguredFeature SWAMP_CHURCH_CONFIGURED = addConfiguredFeature(YEModFeatures.SWAMP_CHURCH.get()
            .configured(new StructurePathConfig("swamp/misc/swamp_church")), "swamp_church");
    public static final NamedPlacedFeature SWAMP_CHURCH_PLACED = addPlacedFeature(SWAMP_CHURCH_CONFIGURED.configuredFeature().placed(
                    RarityFilter.onAverageOnceEvery(YEConfig.swamp.churchSpawnRate.get()),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome(),
                    RngInitializerPlacement.randomize()),
            "swamp_church",
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
