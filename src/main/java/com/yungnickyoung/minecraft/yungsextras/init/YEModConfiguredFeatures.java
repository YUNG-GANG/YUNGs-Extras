package com.yungnickyoung.minecraft.yungsextras.init;

import com.yungnickyoung.minecraft.yungsextras.YungsExtras;
import com.yungnickyoung.minecraft.yungsextras.config.YEConfig;
import com.yungnickyoung.minecraft.yungsextras.util.NamedConfiguredFeature;
import com.yungnickyoung.minecraft.yungsextras.util.NamedPlacedFeature;
import com.yungnickyoung.minecraft.yungsextras.world.config.DesertWellFeatureConfiguration;
import com.yungnickyoung.minecraft.yungsextras.world.config.ResourceLocationFeatureConfiguration;
import com.yungnickyoung.minecraft.yungsextras.world.placement.RngInitializerPlacement;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.*;

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

    private static List<PlacementModifier> placement(int rarity) {
        return List.of(
                RarityFilter.onAverageOnceEvery(rarity),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP,
                BiomeFilter.biome(),
                RngInitializerPlacement.randomize());
    }

    /* Desert features */
    /* Normal wells */
    public static final NamedConfiguredFeature WELL_SM_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.DESERT_WELL.get(), new DesertWellFeatureConfiguration("desert/wells/well_sm", 1)),
            "desert_well_sm");
    public static final NamedPlacedFeature WELL_SM_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(WELL_SM_CONFIGURED.configuredFeature()), placement(YEConfig.desertDecorations.wells.smallNormalWellSpawnRate.get())),
            "desert_well_sm",
            Biome.BiomeCategory.DESERT);

    public static final NamedConfiguredFeature WELL_MD_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.DESERT_WELL.get(), new DesertWellFeatureConfiguration("desert/wells/well_md", 2)),
            "desert_well_md");
    public static final NamedPlacedFeature WELL_MD_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(WELL_MD_CONFIGURED.configuredFeature()), placement(YEConfig.desertDecorations.wells.mediumNormalWellSpawnRate.get())),
            "desert_well_md",
            Biome.BiomeCategory.DESERT);

    public static final NamedConfiguredFeature WELL_LG_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.DESERT_WELL.get(), new DesertWellFeatureConfiguration("desert/wells/well_lg", 3)),
            "desert_well_lg");
    public static final NamedPlacedFeature WELL_LG_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(WELL_LG_CONFIGURED.configuredFeature()), placement(YEConfig.desertDecorations.wells.largeNormalWellSpawnRate.get())),
            "desert_well_lg",
            Biome.BiomeCategory.DESERT);

    /* Dry wells */
    public static final NamedConfiguredFeature DRY_WELL_SM_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.DESERT_WELL.get(), new DesertWellFeatureConfiguration("desert/wells/dry_well_sm", 1)),
            "desert_dry_well_sm");
    public static final NamedPlacedFeature DRY_WELL_SM_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(DRY_WELL_SM_CONFIGURED.configuredFeature()), placement(YEConfig.desertDecorations.wells.smallDryWellSpawnRate.get())),
            "desert_dry_well_sm",
            Biome.BiomeCategory.DESERT);

    public static final NamedConfiguredFeature DRY_WELL_MD_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.DESERT_WELL.get(), new DesertWellFeatureConfiguration("desert/wells/dry_well_md", 2)),
            "desert_dry_well_md");
    public static final NamedPlacedFeature DRY_WELL_MD_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(DRY_WELL_MD_CONFIGURED.configuredFeature()), placement(YEConfig.desertDecorations.wells.mediumDryWellSpawnRate.get())),
            "desert_dry_well_md",
            Biome.BiomeCategory.DESERT);

    public static final NamedConfiguredFeature DRY_WELL_LG_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.DESERT_WELL.get(), new DesertWellFeatureConfiguration("desert/wells/dry_well_lg", 3)),
            "desert_dry_well_lg");
    public static final NamedPlacedFeature DRY_WELL_LG_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(DRY_WELL_LG_CONFIGURED.configuredFeature()), placement(YEConfig.desertDecorations.wells.largeDryWellSpawnRate.get())),
            "desert_dry_well_lg",
            Biome.BiomeCategory.DESERT);

    /* Wishing wells */
    public static final NamedConfiguredFeature WISHING_WELL_SM_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.DESERT_WELL.get(), new DesertWellFeatureConfiguration("desert/wells/wishing_well_sm", 1)),
            "desert_wishing_well_sm");
    public static final NamedPlacedFeature WISHING_WELL_SM_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(WISHING_WELL_SM_CONFIGURED.configuredFeature()), placement(YEConfig.desertDecorations.wells.smallWishingWellSpawnRate.get())),
            "desert_wishing_well_sm",
            Biome.BiomeCategory.DESERT);

    public static final NamedConfiguredFeature WISHING_WELL_MD_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.DESERT_WELL.get(), new DesertWellFeatureConfiguration("desert/wells/wishing_well_md", 2)),
            "desert_wishing_well_md");
    public static final NamedPlacedFeature WISHING_WELL_MD_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(WISHING_WELL_MD_CONFIGURED.configuredFeature()), placement(YEConfig.desertDecorations.wells.mediumWishingWellSpawnRate.get())),
            "desert_wishing_well_md",
            Biome.BiomeCategory.DESERT);

    public static final NamedConfiguredFeature WISHING_WELL_LG_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.DESERT_WELL.get(), new DesertWellFeatureConfiguration("desert/wells/wishing_well_lg", 3)),
            "desert_wishing_well_lg");
    public static final NamedPlacedFeature WISHING_WELL_LG_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(WISHING_WELL_LG_CONFIGURED.configuredFeature()), placement(YEConfig.desertDecorations.wells.largeWishingWellSpawnRate.get())),
            "desert_wishing_well_lg",
            Biome.BiomeCategory.DESERT);

    /* Obelisks */
    public static final NamedConfiguredFeature OBELISK_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.DESERT_OBELISK.get(), new ResourceLocationFeatureConfiguration("desert/obelisk/obelisk")),
            "desert_obelisk");
    public static final NamedPlacedFeature OBELISK_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(OBELISK_CONFIGURED.configuredFeature()), placement(YEConfig.desertDecorations.obelisks.normalObeliskSpawnRate.get())),
            "desert_obelisk",
            Biome.BiomeCategory.DESERT);

    public static final NamedConfiguredFeature OBELISK_CREEPER_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.DESERT_OBELISK.get(), new ResourceLocationFeatureConfiguration("desert/obelisk/obelisk_creeper")),
            "desert_obelisk_creeper");
    public static final NamedPlacedFeature OBELISK_CREEPER_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(OBELISK_CREEPER_CONFIGURED.configuredFeature()), placement(YEConfig.desertDecorations.obelisks.creeperObeliskSpawnRate.get())),
            "desert_obelisk_creeper",
            Biome.BiomeCategory.DESERT);

    public static final NamedConfiguredFeature OBELISK_RUINED_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.DESERT_OBELISK.get(), new ResourceLocationFeatureConfiguration("desert/obelisk/obelisk_ruined")),
            "desert_obelisk_ruined");
    public static final NamedPlacedFeature OBELISK_RUINED_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(OBELISK_RUINED_CONFIGURED.configuredFeature()), placement(YEConfig.desertDecorations.obelisks.ruinedObeliskSpawnRate.get())),
            "desert_obelisk_ruined",
            Biome.BiomeCategory.DESERT);

    public static final NamedConfiguredFeature OBELISK_RARE_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.DESERT_OBELISK.get(), new ResourceLocationFeatureConfiguration("desert/obelisk/obelisk_rare")),
            "desert_obelisk_rare");
    public static final NamedPlacedFeature OBELISK_RARE_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(OBELISK_RARE_CONFIGURED.configuredFeature()), placement(YEConfig.desertDecorations.obelisks.blackstoneObeliskSpawnRate.get())),
            "desert_obelisk_rare",
            Biome.BiomeCategory.DESERT);

    /* Miscellaneous Desert Features */
    public static final NamedConfiguredFeature GIANT_TORCH_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.DESERT_GIANT_TORCH.get(), FeatureConfiguration.NONE),
            "desert_giant_torch");
    public static final NamedPlacedFeature GIANT_TORCH_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(GIANT_TORCH_CONFIGURED.configuredFeature()), placement(YEConfig.desertDecorations.misc.giantTorchSpawnRate.get())),
            "desert_giant_torch",
            Biome.BiomeCategory.DESERT);

    public static final NamedConfiguredFeature DESERT_RUINS_0_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.DESERT_RUINS_0.get(), FeatureConfiguration.NONE),
            "desert_ruins_0");
    public static final NamedPlacedFeature DESERT_RUINS_0_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(DESERT_RUINS_0_CONFIGURED.configuredFeature()), placement(YEConfig.desertDecorations.misc.smallRuinsSpawnRate.get())),
            "desert_ruins_0",
            Biome.BiomeCategory.DESERT);

    public static final NamedConfiguredFeature DESERT_CHILLZONE_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.DESERT_CHILLZONE.get(), FeatureConfiguration.NONE),
            "desert_chillzone");
    public static final NamedPlacedFeature DESERT_CHILLZONE_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(DESERT_CHILLZONE_CONFIGURED.configuredFeature()), placement(YEConfig.desertDecorations.misc.chillzoneSpawnRate.get())),
            "desert_chillzone",
            Biome.BiomeCategory.DESERT);

    /* Swamp features */
    /* Pillars */
    public static final NamedConfiguredFeature SWAMP_PILLAR_0_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_PILLAR.get(), new ResourceLocationFeatureConfiguration("swamp/pillar/swamp_pillar_0")),
            "swamp_pillar_0");
    public static final NamedPlacedFeature SWAMP_PILLAR_0_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_PILLAR_0_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.pillarSpawnRate.get())),
            "swamp_pillar_0",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_PILLAR_1_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_PILLAR.get(), new ResourceLocationFeatureConfiguration("swamp/pillar/swamp_pillar_1")),
            "swamp_pillar_1");
    public static final NamedPlacedFeature SWAMP_PILLAR_1_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_PILLAR_1_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.pillarSpawnRate.get())),
            "swamp_pillar_1",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_PILLAR_2_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_PILLAR.get(), new ResourceLocationFeatureConfiguration("swamp/pillar/swamp_pillar_2")),
            "swamp_pillar_2");
    public static final NamedPlacedFeature SWAMP_PILLAR_2_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_PILLAR_2_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.pillarSpawnRate.get())),
            "swamp_pillar_2",
            Biome.BiomeCategory.SWAMP);

    /* Cubbies */
    public static final NamedConfiguredFeature SWAMP_CUBBY_0_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_CUBBY.get(), new ResourceLocationFeatureConfiguration("swamp/cubby/swamp_cubby_0")),
            "swamp_cubby_0");
    public static final NamedPlacedFeature SWAMP_CUBBY_0_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_CUBBY_0_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.cubbySpawnRate.get())),
            "swamp_cubby_0",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_CUBBY_1_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_CUBBY.get(), new ResourceLocationFeatureConfiguration("swamp/cubby/swamp_cubby_1")),
            "swamp_cubby_1");
    public static final NamedPlacedFeature SWAMP_CUBBY_1_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_CUBBY_1_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.cubbySpawnRate.get())),
            "swamp_cubby_1",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_CUBBY_2_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_CUBBY.get(), new ResourceLocationFeatureConfiguration("swamp/cubby/swamp_cubby_2")),
            "swamp_cubby_2");
    public static final NamedPlacedFeature SWAMP_CUBBY_2_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_CUBBY_2_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.cubbySpawnRate.get())),
            "swamp_cubby_2",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_CUBBY_3_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_CUBBY.get(), new ResourceLocationFeatureConfiguration("swamp/cubby/swamp_cubby_3")),
            "swamp_cubby_3");
    public static final NamedPlacedFeature SWAMP_CUBBY_3_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_CUBBY_3_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.cubbySpawnRate.get())),
            "swamp_cubby_3",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_CUBBY_4_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_CUBBY.get(), new ResourceLocationFeatureConfiguration("swamp/cubby/swamp_cubby_4")),
            "swamp_cubby_4");
    public static final NamedPlacedFeature SWAMP_CUBBY_4_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_CUBBY_4_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.cubbySpawnRate.get())),
            "swamp_cubby_4",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_CUBBY_5_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_CUBBY.get(), new ResourceLocationFeatureConfiguration("swamp/cubby/swamp_cubby_5")),
            "swamp_cubby_5");
    public static final NamedPlacedFeature SWAMP_CUBBY_5_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_CUBBY_5_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.cubbySpawnRate.get())),
            "swamp_cubby_5",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_CUBBY_6_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_CUBBY.get(), new ResourceLocationFeatureConfiguration("swamp/cubby/swamp_cubby_6")),
            "swamp_cubby_6");
    public static final NamedPlacedFeature SWAMP_CUBBY_6_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_CUBBY_6_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.cubbySpawnRate.get())),
            "swamp_cubby_6",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_CUBBY_7_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_CUBBY.get(), new ResourceLocationFeatureConfiguration("swamp/cubby/swamp_cubby_7")),
            "swamp_cubby_7");
    public static final NamedPlacedFeature SWAMP_CUBBY_7_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_CUBBY_7_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.cubbySpawnRate.get())),
            "swamp_cubby_7",
            Biome.BiomeCategory.SWAMP);

    /* Arches */
    public static final NamedConfiguredFeature SWAMP_ARCH_0_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_ARCH.get(), new ResourceLocationFeatureConfiguration("swamp/arch/swamp_arch_0")),
            "swamp_arch_0");
    public static final NamedPlacedFeature SWAMP_ARCH_0_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_ARCH_0_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.archSpawnRate.get())),
            "swamp_arch_0",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_ARCH_1_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_ARCH.get(), new ResourceLocationFeatureConfiguration("swamp/arch/swamp_arch_1")),
            "swamp_arch_1");
    public static final NamedPlacedFeature SWAMP_ARCH_1_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_ARCH_1_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.archSpawnRate.get())),
            "swamp_arch_1",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_ARCH_2_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_ARCH.get(), new ResourceLocationFeatureConfiguration("swamp/arch/swamp_arch_2")),
            "swamp_arch_2");
    public static final NamedPlacedFeature SWAMP_ARCH_2_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_ARCH_2_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.archSpawnRate.get())),
            "swamp_arch_2",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_ARCH_3_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_ARCH.get(), new ResourceLocationFeatureConfiguration("swamp/arch/swamp_arch_3")),
            "swamp_arch_3");
    public static final NamedPlacedFeature SWAMP_ARCH_3_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_ARCH_3_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.archSpawnRate.get())),
            "swamp_arch_3",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_ARCH_4_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_ARCH.get(), new ResourceLocationFeatureConfiguration("swamp/arch/swamp_arch_4")),
            "swamp_arch_4");
    public static final NamedPlacedFeature SWAMP_ARCH_4_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_ARCH_4_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.archSpawnRate.get())),
            "swamp_arch_4",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_ARCH_5_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_ARCH.get(), new ResourceLocationFeatureConfiguration("swamp/arch/swamp_arch_5")),
            "swamp_arch_5");
    public static final NamedPlacedFeature SWAMP_ARCH_5_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_ARCH_5_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.archSpawnRate.get())),
            "swamp_arch_5",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_ARCH_6_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_ARCH.get(), new ResourceLocationFeatureConfiguration("swamp/arch/swamp_arch_6")),
            "swamp_arch_6");
    public static final NamedPlacedFeature SWAMP_ARCH_6_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_ARCH_6_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.archSpawnRate.get())),
            "swamp_arch_6",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_ARCH_7_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_ARCH.get(), new ResourceLocationFeatureConfiguration("swamp/arch/swamp_arch_7")),
            "swamp_arch_7");
    public static final NamedPlacedFeature SWAMP_ARCH_7_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_ARCH_7_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.archSpawnRate.get())),
            "swamp_arch_7",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_ARCH_8_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_ARCH.get(), new ResourceLocationFeatureConfiguration("swamp/arch/swamp_arch_8")),
            "swamp_arch_8");
    public static final NamedPlacedFeature SWAMP_ARCH_8_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_ARCH_8_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.archSpawnRate.get())),
            "swamp_arch_8",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_ARCH_10_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_ARCH.get(), new ResourceLocationFeatureConfiguration("swamp/arch/swamp_arch_10")),
            "swamp_arch_10");
    public static final NamedPlacedFeature SWAMP_ARCH_10_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_ARCH_10_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.archSpawnRate.get())),
            "swamp_arch_10",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_ARCH_11_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_ARCH.get(), new ResourceLocationFeatureConfiguration("swamp/arch/swamp_arch_11")),
            "swamp_arch_11");
    public static final NamedPlacedFeature SWAMP_ARCH_11_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_ARCH_11_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.archSpawnRate.get())),
            "swamp_arch_11",
            Biome.BiomeCategory.SWAMP);

    /* Double arches */
    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_0_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_DOUBLE_ARCH.get(), new ResourceLocationFeatureConfiguration("swamp/arch/swamp_double_arch_0")),
            "swamp_double_arch_0");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_0_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_DOUBLE_ARCH_0_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.doubleArchSpawnRate.get())),
            "swamp_double_arch_0",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_1_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_DOUBLE_ARCH.get(), new ResourceLocationFeatureConfiguration("swamp/arch/swamp_double_arch_1")),
            "swamp_double_arch_1");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_1_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_DOUBLE_ARCH_1_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.doubleArchSpawnRate.get())),
            "swamp_double_arch_1",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_2_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_DOUBLE_ARCH.get(), new ResourceLocationFeatureConfiguration("swamp/arch/swamp_double_arch_2")),
            "swamp_double_arch_2");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_2_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_DOUBLE_ARCH_2_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.doubleArchSpawnRate.get())),
            "swamp_double_arch_2",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_3_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_DOUBLE_ARCH.get(), new ResourceLocationFeatureConfiguration("swamp/arch/swamp_double_arch_3")),
            "swamp_double_arch_3");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_3_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_DOUBLE_ARCH_3_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.doubleArchSpawnRate.get())),
            "swamp_double_arch_3",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_4_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_DOUBLE_ARCH.get(), new ResourceLocationFeatureConfiguration("swamp/arch/swamp_double_arch_4")),
            "swamp_double_arch_4");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_4_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_DOUBLE_ARCH_4_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.doubleArchSpawnRate.get())),
            "swamp_double_arch_4",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_5_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_DOUBLE_ARCH.get(), new ResourceLocationFeatureConfiguration("swamp/arch/swamp_double_arch_5")),
            "swamp_double_arch_5");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_5_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_DOUBLE_ARCH_5_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.doubleArchSpawnRate.get())),
            "swamp_double_arch_5",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_6_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_DOUBLE_ARCH.get(), new ResourceLocationFeatureConfiguration("swamp/arch/swamp_double_arch_6")),
            "swamp_double_arch_6");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_6_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_DOUBLE_ARCH_6_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.doubleArchSpawnRate.get())),
            "swamp_double_arch_6",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_7_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_DOUBLE_ARCH.get(), new ResourceLocationFeatureConfiguration("swamp/arch/swamp_double_arch_7")),
            "swamp_double_arch_7");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_7_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_DOUBLE_ARCH_7_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.doubleArchSpawnRate.get())),
            "swamp_double_arch_7",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_8_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_DOUBLE_ARCH.get(), new ResourceLocationFeatureConfiguration("swamp/arch/swamp_double_arch_8")),
            "swamp_double_arch_8");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_8_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_DOUBLE_ARCH_8_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.doubleArchSpawnRate.get())),
            "swamp_double_arch_8",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_9_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_DOUBLE_ARCH.get(), new ResourceLocationFeatureConfiguration("swamp/arch/swamp_double_arch_9")),
            "swamp_double_arch_9");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_9_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_DOUBLE_ARCH_9_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.doubleArchSpawnRate.get())),
            "swamp_double_arch_9",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_10_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_DOUBLE_ARCH.get(), new ResourceLocationFeatureConfiguration("swamp/arch/swamp_double_arch_10")),
            "swamp_double_arch_10");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_10_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_DOUBLE_ARCH_10_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.doubleArchSpawnRate.get())),
            "swamp_double_arch_10",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_11_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_DOUBLE_ARCH.get(), new ResourceLocationFeatureConfiguration("swamp/arch/swamp_double_arch_11")),
            "swamp_double_arch_11");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_11_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_DOUBLE_ARCH_11_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.doubleArchSpawnRate.get())),
            "swamp_double_arch_11",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_12_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_DOUBLE_ARCH.get(), new ResourceLocationFeatureConfiguration("swamp/arch/swamp_double_arch_12")),
            "swamp_double_arch_12");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_12_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_DOUBLE_ARCH_12_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.doubleArchSpawnRate.get())),
            "swamp_double_arch_12",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_13_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_DOUBLE_ARCH.get(), new ResourceLocationFeatureConfiguration("swamp/arch/swamp_double_arch_13")),
            "swamp_double_arch_13");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_13_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_DOUBLE_ARCH_13_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.doubleArchSpawnRate.get())),
            "swamp_double_arch_13",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_14_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_DOUBLE_ARCH.get(), new ResourceLocationFeatureConfiguration("swamp/arch/swamp_double_arch_14")),
            "swamp_double_arch_14");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_14_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_DOUBLE_ARCH_14_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.doubleArchSpawnRate.get())),
            "swamp_double_arch_14",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_15_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_DOUBLE_ARCH.get(), new ResourceLocationFeatureConfiguration("swamp/arch/swamp_double_arch_15")),
            "swamp_double_arch_15");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_15_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_DOUBLE_ARCH_15_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.doubleArchSpawnRate.get())),
            "swamp_double_arch_15",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_16_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_DOUBLE_ARCH.get(), new ResourceLocationFeatureConfiguration("swamp/arch/swamp_double_arch_16")),
            "swamp_double_arch_16");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_16_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_DOUBLE_ARCH_16_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.doubleArchSpawnRate.get())),
            "swamp_double_arch_16",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_17_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_DOUBLE_ARCH.get(), new ResourceLocationFeatureConfiguration("swamp/arch/swamp_double_arch_17")),
            "swamp_double_arch_17");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_17_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_DOUBLE_ARCH_17_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.doubleArchSpawnRate.get())),
            "swamp_double_arch_17",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_18_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_DOUBLE_ARCH.get(), new ResourceLocationFeatureConfiguration("swamp/arch/swamp_double_arch_18")),
            "swamp_double_arch_18");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_18_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_DOUBLE_ARCH_18_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.doubleArchSpawnRate.get())),
            "swamp_double_arch_18",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_19_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_DOUBLE_ARCH.get(), new ResourceLocationFeatureConfiguration("swamp/arch/swamp_double_arch_19")),
            "swamp_double_arch_19");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_19_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_DOUBLE_ARCH_19_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.doubleArchSpawnRate.get())),
            "swamp_double_arch_19",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_20_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_DOUBLE_ARCH.get(), new ResourceLocationFeatureConfiguration("swamp/arch/swamp_double_arch_20")),
            "swamp_double_arch_20");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_20_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_DOUBLE_ARCH_20_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.doubleArchSpawnRate.get())),
            "swamp_double_arch_20",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_DOUBLE_ARCH_21_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_DOUBLE_ARCH.get(), new ResourceLocationFeatureConfiguration("swamp/arch/swamp_double_arch_21")),
            "swamp_double_arch_21");
    public static final NamedPlacedFeature SWAMP_DOUBLE_ARCH_21_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_DOUBLE_ARCH_21_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.doubleArchSpawnRate.get())),
            "swamp_double_arch_21",
            Biome.BiomeCategory.SWAMP);

    /* Miscellaneous swamp features */
    public static final NamedConfiguredFeature SWAMP_OGRE_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_OGRE.get(), new ResourceLocationFeatureConfiguration("swamp/misc/swamp_ogre_0")),
            "swamp_ogre");
    public static final NamedPlacedFeature SWAMP_OGRE_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_OGRE_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.ogreSpawnRate.get())),
            "swamp_ogre",
            Biome.BiomeCategory.SWAMP);

    public static final NamedConfiguredFeature SWAMP_CHURCH_CONFIGURED = addConfiguredFeature(
            new ConfiguredFeature<>(YEModFeatures.SWAMP_CHURCH.get(), new ResourceLocationFeatureConfiguration("swamp/misc/swamp_church")),
            "swamp_church");
    public static final NamedPlacedFeature SWAMP_CHURCH_PLACED = addPlacedFeature(
            new PlacedFeature(Holder.direct(SWAMP_CHURCH_CONFIGURED.configuredFeature()), placement(YEConfig.swamp.churchSpawnRate.get())),
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
