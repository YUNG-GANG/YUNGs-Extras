package com.yungnickyoung.minecraft.yungsextras.module;

import com.yungnickyoung.minecraft.yungsextras.YungsExtrasCommon;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.*;
import com.yungnickyoung.minecraft.yungsextras.world.feature.swamp.*;
import net.fabricmc.fabric.api.biome.v1.BiomeModificationContext;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class FeatureModuleFabric {
    public static void init() {
        registerFeatures();
        ConfiguredFeatureModule.registerConfiguredFeatures();
        ConfiguredFeatureModule.registerPlacedFeatures();
        addFeaturesToBiomes();
    }

    private static void registerFeatures() {
        /* Desert Features */
        FeatureModule.DESERT_WELL = register("desert_well", new DesertWellFeature());
        FeatureModule.DESERT_OBELISK = register("desert_obelisk", new DesertObeliskFeature());
        FeatureModule.DESERT_GIANT_TORCH = register("desert_giant_torch", new DesertGiantTorchFeature());
        FeatureModule.DESERT_RUINS_0 = register("desert_ruins_0", new DesertSmallRuinsFeature());
        FeatureModule.DESERT_CHILLZONE = register("desert_chillzone", new ChillzoneDesertFeature());

        /* Swamp Features */
        FeatureModule.SWAMP_PILLAR = register("swamp_pillar", new SwampPillarFeature());
        FeatureModule.SWAMP_OGRE = register("swamp_ogre", new SwampOgreFeature());
        FeatureModule.SWAMP_CUBBY = register("swamp_cubby", new SwampCubbyFeature());
        FeatureModule.SWAMP_ARCH = register("swamp_arch", new SwampArchFeature());
        FeatureModule.SWAMP_DOUBLE_ARCH = register("swamp_double_arch", new SwampDoubleArchFeature());
        FeatureModule.SWAMP_CHURCH = register("swamp_church", new SwampChurchFeature());
    }

    private static void addFeaturesToBiomes() {
        // Remove vanilla wells
        BiomeModifications.create(new ResourceLocation(YungsExtrasCommon.MOD_ID, "vanilla_desert_well_removal"))
                .add(ModificationPhase.REMOVALS,
                        biomeSelectionContext -> biomeSelectionContext.hasBuiltInPlacedFeature(MiscOverworldPlacements.DESERT_WELL.value()),
                        modificationContext -> modificationContext.getGenerationSettings().removeBuiltInFeature(MiscOverworldPlacements.DESERT_WELL.value()));

        // Add desert decorations
        BiomeModifications.create(new ResourceLocation(YungsExtrasCommon.MOD_ID, "desert_decorations_addition"))
                .add(ModificationPhase.ADDITIONS,
                        context -> selectBiomes(context, Biome.BiomeCategory.DESERT, YungsExtrasCommon.CONFIG.desert.biomeBlacklist, YungsExtrasCommon.CONFIG.desert.additionalBiomeWhitelist),
                        context -> modifyBiomes(context, Biome.BiomeCategory.DESERT));

        // Add swamp structures
        BiomeModifications.create(new ResourceLocation(YungsExtrasCommon.MOD_ID, "swamp_structures_addition"))
                .add(ModificationPhase.ADDITIONS,
                        context -> selectBiomes(context, Biome.BiomeCategory.SWAMP, YungsExtrasCommon.CONFIG.swamp.biomeBlacklist, YungsExtrasCommon.CONFIG.swamp.additionalBiomeWhitelist),
                        context -> modifyBiomes(context, Biome.BiomeCategory.SWAMP));
    }

    private static boolean selectBiomes(BiomeSelectionContext context, Biome.BiomeCategory biomeCategory, List<String> blacklistedBiomes, List<String> additionalWhitelistedBiomes) {
        String biomeName = context.getBiomeKey().location().toString();
        if (blacklistedBiomes.contains(biomeName)) return false;
        return (Biome.getBiomeCategory(Holder.direct(context.getBiome())) == biomeCategory || additionalWhitelistedBiomes.contains(biomeName));
    }

    private static void modifyBiomes(BiomeModificationContext context, Biome.BiomeCategory biomeCategory) {
        ConfiguredFeatureModule.NAMED_PLACED_FEATURES_BY_BIOME.get(biomeCategory).forEach(namedPlacedFeature -> {
            PlacedFeature placedFeature = namedPlacedFeature.placedFeature();
            context.getGenerationSettings().addBuiltInFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, placedFeature);
        });
    }

    private static <FC extends FeatureConfiguration> Feature<FC> register(String name, Feature<FC> feature) {
        return Registry.register(Registry.FEATURE, new ResourceLocation(YungsExtrasCommon.MOD_ID, name), feature);
    }
}
