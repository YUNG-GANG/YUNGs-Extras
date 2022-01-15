package com.yungnickyoung.minecraft.yungsextras.init;

import com.yungnickyoung.minecraft.yungsextras.YungsExtras;
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
import com.yungnickyoung.minecraft.yungsextras.world.feature.swamp.pillar.SwampPillarFeature;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
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
    /* Normal wells */
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> WELL_SM = register("desert_well_sm", SmallDesertWellFeature::new);
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> WELL_MD = register("desert_well_md", MedDesertWellFeature::new);
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> WELL_LG = register("desert_well_lg", LargeDesertWellFeature::new);

    /* Dry wells */
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> DRY_WELL_SM = register("desert_dry_well_sm", SmallDesertDryWellFeature::new);
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> DRY_WELL_MD = register("desert_dry_well_md", MedDesertDryWellFeature::new);
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> DRY_WELL_LG = register("desert_dry_well_lg", LargeDesertDryWellFeature::new);

    /* Wishing wells */
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> WISHING_WELL_SM = register("desert_wishing_well_sm", SmallDesertWishingWellFeature::new);
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> WISHING_WELL_MD = register("desert_wishing_well_md", MedDesertWishingWellFeature::new);
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> WISHING_WELL_LG = register("desert_wishing_well_lg", LargeDesertWishingWellFeature::new);

    /* Obelisks */
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> OBELISK = register("desert_obelisk", DesertObeliskFeature::new);
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> OBELISK_CREEPER = register("desert_obelisk_creeper", CreeperDesertObeliskFeature::new);
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> OBELISK_RUINED = register("desert_obelisk_ruined", RuinedDesertObeliskFeature::new);
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> OBELISK_RARE = register("desert_obelisk_rare", RareDesertObeliskFeature::new);

    /* Miscellaneous Desert Features */
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> GIANT_TORCH = register("desert_giant_torch", GiantDesertTorchFeature::new);
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> DESERT_RUINS_0 = register("desert_ruins_0", SmallRuinsDesertFeature::new);
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> CHILLZONE = register("desert_chillzone", ChillzoneDesertFeature::new);

    /* Swamp Features */
    /* Pillars */
    public static final RegistryObject<Feature<StructurePathConfig>> SWAMP_PILLAR = register("swamp_pillar", SwampPillarFeature::new);

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
            event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).removeIf(supplier -> supplier.get().toString().equals(MiscOverworldPlacements.DESERT_WELL.toString()));

            // Add structures to biome generation settings for proper biomes
            event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> YEModConfiguredFeatures.WELL_SM_PLACED);
            event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> YEModConfiguredFeatures.WELL_MD_PLACED);
            event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> YEModConfiguredFeatures.WELL_LG_PLACED);
            event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> YEModConfiguredFeatures.DRY_WELL_SM_PLACED);
            event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> YEModConfiguredFeatures.DRY_WELL_MD_PLACED);
            event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> YEModConfiguredFeatures.DRY_WELL_LG_PLACED);
            event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> YEModConfiguredFeatures.WISHING_WELL_SM_PLACED);
            event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> YEModConfiguredFeatures.WISHING_WELL_MD_PLACED);
            event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> YEModConfiguredFeatures.WISHING_WELL_LG_PLACED);
            event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> YEModConfiguredFeatures.OBELISK_PLACED);
            event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> YEModConfiguredFeatures.OBELISK_CREEPER_PLACED);
            event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> YEModConfiguredFeatures.OBELISK_RARE_PLACED);
            event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> YEModConfiguredFeatures.OBELISK_RUINED_PLACED);
            event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> YEModConfiguredFeatures.GIANT_TORCH_PLACED);
            event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> YEModConfiguredFeatures.DESERT_RUINS_0_PLACED);
            event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> YEModConfiguredFeatures.CHILLZONE_PLACED);
        }

        // Swamp decorations
        if (event.getCategory() == Biome.BiomeCategory.SWAMP) {
            event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> YEModConfiguredFeatures.SWAMP_PILLAR_PLACED_0);
            event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> YEModConfiguredFeatures.SWAMP_PILLAR_PLACED_1);
            event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> YEModConfiguredFeatures.SWAMP_PILLAR_PLACED_2);
        }
    }

    private static <T extends Feature<?>> RegistryObject<T> register(String name, Supplier<T> feature) {
        return FEATURES.register(name, feature);
    }
}
