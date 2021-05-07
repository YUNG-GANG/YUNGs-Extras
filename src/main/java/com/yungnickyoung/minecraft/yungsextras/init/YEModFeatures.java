package com.yungnickyoung.minecraft.yungsextras.init;

import com.yungnickyoung.minecraft.yungsextras.YungsExtras;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.misc.ChillzoneDesertFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.misc.GiantDesertTorchFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.misc.SmallRuinsDesertFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.well.dry.LargeDesertDryWellFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.well.dry.MedDesertDryWellFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.well.dry.SmallDesertDryWellFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.well.normal.LargeDesertWellFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.well.normal.MedDesertWellFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.well.normal.SmallDesertWellFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.well.wishing.LargeDesertWishingWellFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.well.wishing.MedDesertWishingWellFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.well.wishing.SmallDesertWishingWellFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.obelisk.CreeperDesertObeliskFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.obelisk.DesertObeliskFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.obelisk.RareDesertObeliskFeature;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.obelisk.RuinedDesertObeliskFeature;
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

    /* Desert Features */
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

    /* Obelisks */
    public static final RegistryObject<Feature<NoFeatureConfig>> OBELISK = register("desert_obelisk", DesertObeliskFeature::new);
    public static final RegistryObject<Feature<NoFeatureConfig>> OBELISK_CREEPER = register("desert_obelisk_creeper", CreeperDesertObeliskFeature::new);
    public static final RegistryObject<Feature<NoFeatureConfig>> OBELISK_RUINED = register("desert_obelisk_ruined", RuinedDesertObeliskFeature::new);
    public static final RegistryObject<Feature<NoFeatureConfig>> OBELISK_RARE = register("desert_obelisk_rare", RareDesertObeliskFeature::new);

    /* Miscellaneous Desert Features */
    public static final RegistryObject<Feature<NoFeatureConfig>> GIANT_TORCH = register("desert_giant_torch", GiantDesertTorchFeature::new);
    public static final RegistryObject<Feature<NoFeatureConfig>> DESERT_RUINS_0 = register("desert_ruins_0", SmallRuinsDesertFeature::new);
    public static final RegistryObject<Feature<NoFeatureConfig>> CHILLZONE = register("desert_chillzone", ChillzoneDesertFeature::new);

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
            event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> YEModConfiguredFeatures.OBELISK);
            event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> YEModConfiguredFeatures.OBELISK_CREEPER);
            event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> YEModConfiguredFeatures.OBELISK_RARE);
            event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> YEModConfiguredFeatures.OBELISK_RUINED);
            event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> YEModConfiguredFeatures.GIANT_TORCH);
            event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> YEModConfiguredFeatures.DESERT_RUINS_0);
            event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> YEModConfiguredFeatures.CHILLZONE);
        }
    }

    private static <T extends Feature<?>> RegistryObject<T> register(String name, Supplier<T> feature) {
        return FEATURES.register(name, feature);
    }
}
