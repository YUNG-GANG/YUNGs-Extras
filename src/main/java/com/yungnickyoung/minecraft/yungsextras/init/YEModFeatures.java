package com.yungnickyoung.minecraft.yungsextras.init;

import com.yungnickyoung.minecraft.yungsextras.YungsExtras;
import com.yungnickyoung.minecraft.yungsextras.util.NamedFeature;
import com.yungnickyoung.minecraft.yungsextras.world.config.StructurePathConfig;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.misc.ChillzoneDesertFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.misc.GiantDesertTorchFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.misc.SmallRuinsDesertFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.obelisk.CreeperDesertObeliskFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.obelisk.DesertObeliskFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.obelisk.RareDesertObeliskFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.obelisk.RuinedDesertObeliskFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.well.dry.LargeDesertDryWellFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.well.dry.MedDesertDryWellFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.well.dry.SmallDesertDryWellFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.well.normal.LargeDesertWellFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.well.normal.MedDesertWellFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.well.normal.SmallDesertWellFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.well.wishing.LargeDesertWishingWellFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.well.wishing.MedDesertWishingWellFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.well.wishing.SmallDesertWishingWellFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.swamp.*;
import net.fabricmc.fabric.api.biome.v1.BiomeModificationContext;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class YEModFeatures {
    /* List of all features for convenience */
    public static final List<NamedFeature<?>> NAMED_FEATURES = new ArrayList<>();

    /* Desert Features */
    /* Normal wells */
    public static final NamedFeature<NoneFeatureConfiguration> WELL_SM = addFeature(SmallDesertWellFeature::new, "desert_well_sm");
    public static final NamedFeature<NoneFeatureConfiguration> WELL_MD = addFeature(MedDesertWellFeature::new, "desert_well_md");
    public static final NamedFeature<NoneFeatureConfiguration> WELL_LG = addFeature(LargeDesertWellFeature::new, "desert_well_lg");

    /* Dry wells */
    public static final NamedFeature<NoneFeatureConfiguration> DRY_WELL_SM = addFeature(SmallDesertDryWellFeature::new, "desert_dry_well_sm");
    public static final NamedFeature<NoneFeatureConfiguration> DRY_WELL_MD = addFeature(MedDesertDryWellFeature::new, "desert_dry_well_md");
    public static final NamedFeature<NoneFeatureConfiguration> DRY_WELL_LG = addFeature(LargeDesertDryWellFeature::new, "desert_dry_well_lg");

    /* Wishing wells */
    public static final NamedFeature<NoneFeatureConfiguration> WISHING_WELL_SM = addFeature(SmallDesertWishingWellFeature::new, "desert_wishing_well_sm");
    public static final NamedFeature<NoneFeatureConfiguration> WISHING_WELL_MD = addFeature(MedDesertWishingWellFeature::new, "desert_wishing_well_md");
    public static final NamedFeature<NoneFeatureConfiguration> WISHING_WELL_LG = addFeature(LargeDesertWishingWellFeature::new, "desert_wishing_well_lg");

    /* Obelisks */
    public static final NamedFeature<NoneFeatureConfiguration> OBELISK = addFeature(DesertObeliskFeature::new, "desert_obelisk");
    public static final NamedFeature<NoneFeatureConfiguration> OBELISK_CREEPER = addFeature(CreeperDesertObeliskFeature::new, "desert_obelisk_creeper");
    public static final NamedFeature<NoneFeatureConfiguration> OBELISK_RUINED = addFeature(RuinedDesertObeliskFeature::new, "desert_obelisk_ruined");
    public static final NamedFeature<NoneFeatureConfiguration> OBELISK_RARE = addFeature(RareDesertObeliskFeature::new, "desert_obelisk_rare");

    /* Miscellaneous Desert Features */
    public static final NamedFeature<NoneFeatureConfiguration> GIANT_TORCH = addFeature(GiantDesertTorchFeature::new, "desert_giant_torch");
    public static final NamedFeature<NoneFeatureConfiguration> DESERT_RUINS_0 = addFeature(SmallRuinsDesertFeature::new, "desert_ruins_0");
    public static final NamedFeature<NoneFeatureConfiguration> CHILLZONE = addFeature(ChillzoneDesertFeature::new, "desert_chillzone");

    /* Swamp Features */
    public static final NamedFeature<StructurePathConfig> SWAMP_PILLAR = addFeature(SwampPillarFeature::new, "swamp_pillar");
    public static final NamedFeature<StructurePathConfig> SWAMP_OGRE = addFeature(SwampOgreFeature::new, "swamp_ogre");
    public static final NamedFeature<StructurePathConfig> SWAMP_CUBBY = addFeature(SwampCubbyFeature::new, "swamp_cubby");
    public static final NamedFeature<StructurePathConfig> SWAMP_ARCH = addFeature(SwampArchFeature::new, "swamp_arch");
    public static final NamedFeature<StructurePathConfig> SWAMP_DOUBLE_ARCH = addFeature(SwampDoubleArchFeature::new, "swamp_double_arch");
    public static final NamedFeature<StructurePathConfig> SWAMP_CHURCH = addFeature(SwampChurchFeature::new, "swamp_church");

    private static <FC extends FeatureConfiguration> NamedFeature<FC> addFeature(Supplier<Feature<FC>> featureSupplier, String name) {
        Feature<FC> feature = featureSupplier.get();
        NamedFeature<FC> namedFeature = new NamedFeature<>(name, feature);
        NAMED_FEATURES.add(namedFeature);
        return namedFeature;
    }

    public static void init () {
        registerFeatures();
        YEModConfiguredFeatures.registerConfiguredFeatures();
        YEModConfiguredFeatures.registerPlacedFeatures();
        addFeaturesToBiomes();
    }

    private static void registerFeatures() {
        NAMED_FEATURES.forEach(namedFeature -> {
            Feature<?> feature = namedFeature.feature();
            String name = namedFeature.name();
            Registry.register(Registry.FEATURE, new ResourceLocation(YungsExtras.MOD_ID, name), feature);
        });
    }

    /**
     * Adds features to appropriate biomes.
     */
    private static void addFeaturesToBiomes() {
        // Remove vanilla wells
        BiomeModifications.create(new ResourceLocation(YungsExtras.MOD_ID, "vanilla_desert_well_removal"))
                .add(ModificationPhase.REMOVALS,
                        biomeSelectionContext -> biomeSelectionContext.hasBuiltInPlacedFeature(MiscOverworldPlacements.DESERT_WELL),
                        modificationContext -> modificationContext.getGenerationSettings().removeBuiltInFeature(MiscOverworldPlacements.DESERT_WELL));

        // Add desert decorations
        BiomeModifications.create(new ResourceLocation(YungsExtras.MOD_ID, "desert_decorations_addition"))
                .add(ModificationPhase.ADDITIONS,
                        context -> selectBiomes(context, Biome.BiomeCategory.DESERT),
                        context -> modifyBiomes(context, Biome.BiomeCategory.DESERT));

        // Add swamp structures
        BiomeModifications.create(new ResourceLocation(YungsExtras.MOD_ID, "swamp_structures_addition"))
                .add(ModificationPhase.ADDITIONS,
                        context -> selectBiomes(context, Biome.BiomeCategory.SWAMP),
                        context -> modifyBiomes(context, Biome.BiomeCategory.SWAMP));
    }

    private static boolean selectBiomes(BiomeSelectionContext context, Biome.BiomeCategory biomeCategory) {
        String biomeName = context.getBiomeKey().location().toString();
        if (YungsExtras.blacklistedBiomes.contains(biomeName)) return false;
        return (context.getBiome().getBiomeCategory() == biomeCategory || YungsExtras.additionalWhitelistedBiomes.contains(biomeName));
    }

    private static void modifyBiomes(BiomeModificationContext context, Biome.BiomeCategory biomeCategory) {
        YEModConfiguredFeatures.NAMED_PLACED_FEATURES_BY_BIOME.get(biomeCategory).forEach(namedPlacedFeature -> {
            PlacedFeature placedFeature = namedPlacedFeature.placedFeature();
            context.getGenerationSettings().addBuiltInFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, placedFeature);
        });
    }
}
