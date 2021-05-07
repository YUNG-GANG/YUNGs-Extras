package com.yungnickyoung.minecraft.yungsextras.init;

import com.yungnickyoung.minecraft.yungsextras.YungsExtras;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert_well.dry.LargeDesertDryWellFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert_well.dry.MedDesertDryWellFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert_well.dry.SmallDesertDryWellFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert_well.normal.LargeDesertWellFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert_well.normal.MedDesertWellFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert_well.normal.SmallDesertWellFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert_well.wishing.LargeDesertWishingWellFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert_well.wishing.MedDesertWishingWellFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert_well.wishing.SmallDesertWishingWellFeature;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class YEModFeatures {
    /* Registry for deferred registration */
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, YungsExtras.MOD_ID);

    /* Features */
    /* Normal wells */
    public static final RegistryObject<Feature<NoFeatureConfig>> WELL_SM = register("desert_well_sm", SmallDesertWellFeature::new);
    public static final RegistryObject<Feature<NoFeatureConfig>> WELL_MD = register("desert_well_md", MedDesertWellFeature::new);
    public static final RegistryObject<Feature<NoFeatureConfig>> WELL_LG = register("desert_well_lg", LargeDesertWellFeature::new);

    /* Dry wells */
    public static final RegistryObject<Feature<NoFeatureConfig>> DRY_WELL_SM = register("desert_dry_well_sm", SmallDesertDryWellFeature::new);
    public static final RegistryObject<Feature<NoFeatureConfig>> DRY_WELL_MD = register("desert_dry_well_md", MedDesertDryWellFeature::new);
    public static final RegistryObject<Feature<NoFeatureConfig>> DRY_WELL_LG = register("desert_dry_well_lg", LargeDesertDryWellFeature::new);

    /* Wishing wells */
    public static final RegistryObject<Feature<NoFeatureConfig>> WISHING_WELL_SM = register("desert_wishing_well_sm", SmallDesertWishingWellFeature::new);
    public static final RegistryObject<Feature<NoFeatureConfig>> WISHING_WELL_MD = register("desert_wishing_well_md", MedDesertWishingWellFeature::new);
    public static final RegistryObject<Feature<NoFeatureConfig>> WISHING_WELL_LG = register("desert_wishing_well_lg", LargeDesertWishingWellFeature::new);

    public static void init () {
        FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());
        FMLJavaModLoadingContext.get().getModEventBus().addListener(YEModFeatures::commonSetup);
        MinecraftForge.EVENT_BUS.addListener(YEModFeatures::onBiomeLoad); // We use normal priority since we are both removing and adding stuff
    }

    /**
     * Set up features.
     */
    private static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(YEModConfiguredFeatures::registerConfiguredFeatures);
    }

    /**
     * Adds features to appropriate biomes.
     */
    private static void onBiomeLoad(BiomeLoadingEvent event) {
        // Remove vanilla desert wells from biome generation settings.
        event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).removeIf(supplier -> supplier.get().feature == Feature.DESERT_WELL);

        // Add wells to biome generation settings for proper biomes
        if (event.getCategory() == Biome.Category.DESERT) {
            event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> YEModConfiguredFeatures.WELL_SM);
            event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> YEModConfiguredFeatures.WELL_MD);
            event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> YEModConfiguredFeatures.WELL_LG);
            event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> YEModConfiguredFeatures.DRY_WELL_SM);
            event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> YEModConfiguredFeatures.DRY_WELL_MD);
            event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> YEModConfiguredFeatures.DRY_WELL_LG);
            event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> YEModConfiguredFeatures.WISHING_WELL_SM);
            event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> YEModConfiguredFeatures.WISHING_WELL_MD);
            event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> YEModConfiguredFeatures.WISHING_WELL_LG);
        }
    }

    private static <T extends Feature<?>> RegistryObject<T> register(String name, Supplier<T> feature) {
        return FEATURES.register(name, feature);
    }
}
