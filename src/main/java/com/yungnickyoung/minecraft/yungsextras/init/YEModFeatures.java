package com.yungnickyoung.minecraft.yungsextras.init;

import com.yungnickyoung.minecraft.yungsextras.YungsExtras;
import com.yungnickyoung.minecraft.yungsextras.world.config.DesertWellFeatureConfiguration;
import com.yungnickyoung.minecraft.yungsextras.world.config.ResourceLocationFeatureConfiguration;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.*;
import com.yungnickyoung.minecraft.yungsextras.world.feature.swamp.*;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class YEModFeatures {
    /* Registry for deferred registration */
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, YungsExtras.MOD_ID);

    /* Desert Features */
    public static final RegistryObject<Feature<DesertWellFeatureConfiguration>> DESERT_WELL = register("desert_well", DesertWellFeature::new);
    public static final RegistryObject<Feature<ResourceLocationFeatureConfiguration>> DESERT_OBELISK = register("desert_obelisk", DesertObeliskFeature::new);
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> DESERT_GIANT_TORCH = register("desert_giant_torch", DesertGiantTorchFeature::new);
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> DESERT_RUINS_0 = register("desert_ruins_0", DesertSmallRuinsFeature::new);
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> DESERT_CHILLZONE = register("desert_chillzone", ChillzoneDesertFeature::new);

    /* Swamp Features */
    public static final RegistryObject<Feature<ResourceLocationFeatureConfiguration>> SWAMP_PILLAR = register("swamp_pillar", SwampPillarFeature::new);
    public static final RegistryObject<Feature<ResourceLocationFeatureConfiguration>> SWAMP_OGRE = register("swamp_ogre", SwampOgreFeature::new);
    public static final RegistryObject<Feature<ResourceLocationFeatureConfiguration>> SWAMP_CUBBY = register("swamp_cubby", SwampCubbyFeature::new);
    public static final RegistryObject<Feature<ResourceLocationFeatureConfiguration>> SWAMP_ARCH = register("swamp_arch", SwampArchFeature::new);
    public static final RegistryObject<Feature<ResourceLocationFeatureConfiguration>> SWAMP_DOUBLE_ARCH = register("swamp_double_arch", SwampDoubleArchFeature::new);
    public static final RegistryObject<Feature<ResourceLocationFeatureConfiguration>> SWAMP_CHURCH = register("swamp_church", SwampChurchFeature::new);

    public static void init () {
        FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());
        FMLJavaModLoadingContext.get().getModEventBus().addListener(YEModFeatures::commonSetup);
        MinecraftForge.EVENT_BUS.addListener(YEModFeatures::onBiomeLoad); // We use normal priority since we are both removing and adding stuff
    }

    /**
     * Set up features.
     */
    private static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            YEModConfiguredFeatures.registerConfiguredFeatures();
            YEModConfiguredFeatures.registerPlacedFeatures();
        });
    }

    /**
     * Adds features to appropriate biomes.
     */
    private static void onBiomeLoad(BiomeLoadingEvent event) {
        // Ignore blacklisted biomes
        if (YungsExtras.blacklistedBiomes.contains(event.getName().toString())) return;

        // Desert decorations
        if (event.getCategory() == Biome.BiomeCategory.DESERT || YungsExtras.additionalWhitelistedBiomes.contains(event.getName().toString())) {
            // Remove vanilla desert wells from biome generation settings.
            event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).removeIf(supplier -> supplier.value().toString().equals(MiscOverworldPlacements.DESERT_WELL.toString()));

            YEModConfiguredFeatures.NAMED_PLACED_FEATURES_BY_BIOME.get(Biome.BiomeCategory.DESERT).forEach(namedPlacedFeature -> {
                PlacedFeature placedFeature = namedPlacedFeature.placedFeature();
                event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(Holder.direct(placedFeature));
            });
        }

        // Swamp decorations
        if (event.getCategory() == Biome.BiomeCategory.SWAMP) {
            YEModConfiguredFeatures.NAMED_PLACED_FEATURES_BY_BIOME.get(Biome.BiomeCategory.SWAMP).forEach(namedPlacedFeature -> {
                PlacedFeature placedFeature = namedPlacedFeature.placedFeature();
                event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(Holder.direct(placedFeature));
            });
        }
    }

    private static <T extends Feature<?>> RegistryObject<T> register(String name, Supplier<T> feature) {
        return FEATURES.register(name, feature);
    }
}
