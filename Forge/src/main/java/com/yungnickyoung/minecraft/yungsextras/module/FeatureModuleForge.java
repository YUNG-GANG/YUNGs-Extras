package com.yungnickyoung.minecraft.yungsextras.module;

import com.yungnickyoung.minecraft.yungsextras.YungsExtrasCommon;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.*;
import com.yungnickyoung.minecraft.yungsextras.world.feature.swamp.*;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

public class FeatureModuleForge {
    public static void init() {
        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Feature.class, FeatureModuleForge::registerFeatures);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(FeatureModuleForge::registerConfiguredFeatures);
        MinecraftForge.EVENT_BUS.addListener(FeatureModuleForge::addFeaturesToBiomes); // We use normal priority since we are both removing and adding stuff
    }

    private static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
        IForgeRegistry<Feature<?>> registry = event.getRegistry();

        /* Desert Features */
        FeatureModule.DESERT_WELL = register(registry, "desert_well", new DesertWellFeature());
        FeatureModule.DESERT_OBELISK = register(registry, "desert_obelisk", new DesertObeliskFeature());
        FeatureModule.DESERT_GIANT_TORCH = register(registry, "desert_giant_torch", new DesertGiantTorchFeature());
        FeatureModule.DESERT_RUINS_0 = register(registry, "desert_ruins_0", new DesertSmallRuinsFeature());
        FeatureModule.DESERT_CHILLZONE = register(registry, "desert_chillzone", new ChillzoneDesertFeature());

        /* Swamp Features */
        FeatureModule.SWAMP_PILLAR = register(registry, "swamp_pillar", new SwampPillarFeature());
        FeatureModule.SWAMP_OGRE = register(registry, "swamp_ogre", new SwampOgreFeature());
        FeatureModule.SWAMP_CUBBY = register(registry, "swamp_cubby", new SwampCubbyFeature());
        FeatureModule.SWAMP_ARCH = register(registry, "swamp_arch", new SwampArchFeature());
        FeatureModule.SWAMP_DOUBLE_ARCH = register(registry, "swamp_double_arch", new SwampDoubleArchFeature());
        FeatureModule.SWAMP_CHURCH = register(registry, "swamp_church", new SwampChurchFeature());
    }

    private static void registerConfiguredFeatures(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ConfiguredFeatureModule.registerConfiguredFeatures();
            ConfiguredFeatureModule.registerPlacedFeatures();
        });
    }

    private static void addFeaturesToBiomes(BiomeLoadingEvent event) {
        // Desert decorations
        if (!YungsExtrasCommon.CONFIG.desert.biomeBlacklist.contains(event.getName().toString())) {
            if (event.getCategory() == Biome.BiomeCategory.DESERT || YungsExtrasCommon.CONFIG.desert.additionalBiomeWhitelist.contains(event.getName().toString())) {
                // Remove vanilla desert wells from biome generation settings.
                event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).removeIf(supplier -> supplier.value().toString().equals(MiscOverworldPlacements.DESERT_WELL.toString()));

                ConfiguredFeatureModule.NAMED_PLACED_FEATURES_BY_BIOME.get(Biome.BiomeCategory.DESERT).forEach(namedPlacedFeature -> {
                    PlacedFeature placedFeature = namedPlacedFeature.placedFeature();
                    event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(Holder.direct(placedFeature));
                });
            }
        }

        // Swamp decorations
        if (!YungsExtrasCommon.CONFIG.swamp.biomeBlacklist.contains(event.getName().toString())) {
            if (event.getCategory() == Biome.BiomeCategory.SWAMP || YungsExtrasCommon.CONFIG.swamp.additionalBiomeWhitelist.contains(event.getName().toString())) {
                ConfiguredFeatureModule.NAMED_PLACED_FEATURES_BY_BIOME.get(Biome.BiomeCategory.SWAMP).forEach(namedPlacedFeature -> {
                    PlacedFeature placedFeature = namedPlacedFeature.placedFeature();
                    event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(Holder.direct(placedFeature));
                });
            }
        }
    }

    private static <FC extends FeatureConfiguration> Feature<FC> register(IForgeRegistry<Feature<?>> registry, String name, Feature<FC> feature) {
        feature.setRegistryName(new ResourceLocation(YungsExtrasCommon.MOD_ID, name));
        registry.register(feature);
        return feature;
    }
}
