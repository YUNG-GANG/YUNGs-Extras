package com.yungnickyoung.minecraft.yungsextras.module;

import com.yungnickyoung.minecraft.yungsextras.YungsExtrasCommon;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.GenerationStep;

public class BiomeModificationModuleFabric {
    private static final int NUM_SWAMP_PILLARS = 3;
    private static final int NUM_SWAMP_CUBBIES = 8;
    private static final int NUM_SWAMP_ARCHES = 11;
    private static final int NUM_SWAMP_DOUBLE_ARCHES = 22;

    public static void init() {
        addFeaturesToBiomes();
    }

    private static void addFeaturesToBiomes() {
        // Remove vanilla wells
        BiomeModifications.create(new ResourceLocation(YungsExtrasCommon.MOD_ID, "vanilla_desert_well_removal"))
                .add(ModificationPhase.REMOVALS,
                        biomeSelectionContext -> biomeSelectionContext.hasPlacedFeature(MiscOverworldPlacements.DESERT_WELL),
                        modificationContext -> modificationContext.getGenerationSettings().removeFeature(MiscOverworldPlacements.DESERT_WELL));

        /* Desert Features */
        // Wells
        addToDesertBiome("desert/wells/desert_well_sm", GenerationStep.Decoration.SURFACE_STRUCTURES);
        addToDesertBiome("desert/wells/desert_well_md", GenerationStep.Decoration.SURFACE_STRUCTURES);
        addToDesertBiome("desert/wells/desert_well_lg", GenerationStep.Decoration.SURFACE_STRUCTURES);
        addToDesertBiome("desert/wells/desert_dry_well_sm", GenerationStep.Decoration.SURFACE_STRUCTURES);
        addToDesertBiome("desert/wells/desert_dry_well_md", GenerationStep.Decoration.SURFACE_STRUCTURES);
        addToDesertBiome("desert/wells/desert_dry_well_lg", GenerationStep.Decoration.SURFACE_STRUCTURES);
        addToDesertBiome("desert/wells/desert_wishing_well_sm", GenerationStep.Decoration.SURFACE_STRUCTURES);
        addToDesertBiome("desert/wells/desert_wishing_well_md", GenerationStep.Decoration.SURFACE_STRUCTURES);
        addToDesertBiome("desert/wells/desert_wishing_well_lg", GenerationStep.Decoration.SURFACE_STRUCTURES);

        // Obelisks
        addToDesertBiome("desert/obelisks/desert_obelisk", GenerationStep.Decoration.SURFACE_STRUCTURES);
        addToDesertBiome("desert/obelisks/desert_obelisk_creeper", GenerationStep.Decoration.SURFACE_STRUCTURES);
        addToDesertBiome("desert/obelisks/desert_obelisk_ruined", GenerationStep.Decoration.SURFACE_STRUCTURES);
        addToDesertBiome("desert/obelisks/desert_obelisk_rare", GenerationStep.Decoration.SURFACE_STRUCTURES);

        // Misc
        addToDesertBiome("desert/misc/desert_giant_torch", GenerationStep.Decoration.SURFACE_STRUCTURES);
        addToDesertBiome("desert/misc/desert_ruins_0", GenerationStep.Decoration.SURFACE_STRUCTURES);
        addToDesertBiome("desert/misc/desert_chillzone", GenerationStep.Decoration.SURFACE_STRUCTURES);

        /* Swamp Features */
        // Pillars
        for (int i = 0; i < NUM_SWAMP_PILLARS; i++) {
            addToSwampBiome("swamp/pillars/swamp_pillar_" + i, GenerationStep.Decoration.SURFACE_STRUCTURES);
        }

        // Cubbies
        for (int i = 0; i < NUM_SWAMP_CUBBIES; i++) {
            addToSwampBiome("swamp/cubbies/swamp_cubby_" + i, GenerationStep.Decoration.SURFACE_STRUCTURES);
        }

        // Arches
        for (int i = 0; i < NUM_SWAMP_ARCHES; i++) {
            addToSwampBiome("swamp/arches/swamp_arch_" + i, GenerationStep.Decoration.SURFACE_STRUCTURES);
        }

        // Double Arches
        for (int i = 0; i < NUM_SWAMP_DOUBLE_ARCHES; i++) {
            addToSwampBiome("swamp/double_arches/swamp_double_arch_" + i, GenerationStep.Decoration.SURFACE_STRUCTURES);
        }

        // Misc
        addToSwampBiome("swamp/misc/swamp_church", GenerationStep.Decoration.SURFACE_STRUCTURES);
        addToSwampBiome("swamp/misc/swamp_ogre", GenerationStep.Decoration.SURFACE_STRUCTURES);
    }

    private static void addToDesertBiome(String featurePath, GenerationStep.Decoration step) {
        BiomeModifications.create(new ResourceLocation(YungsExtrasCommon.MOD_ID, featurePath))
                .add(ModificationPhase.ADDITIONS,
                        context -> context.hasTag(TagKey.create(Registries.BIOME, new ResourceLocation(YungsExtrasCommon.MOD_ID, "has_structure/desert_decorations"))),
                        context -> context.getGenerationSettings().addFeature(step, ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(YungsExtrasCommon.MOD_ID, featurePath))));
    }

    private static void addToSwampBiome(String featurePath, GenerationStep.Decoration step) {
        BiomeModifications.create(new ResourceLocation(YungsExtrasCommon.MOD_ID, featurePath))
                .add(ModificationPhase.ADDITIONS,
                        context -> context.hasTag(TagKey.create(Registries.BIOME, new ResourceLocation(YungsExtrasCommon.MOD_ID, "has_structure/swamp_structures"))),
                        context -> context.getGenerationSettings().addFeature(step, ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(YungsExtrasCommon.MOD_ID, featurePath))));
    }
}
