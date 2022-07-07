package com.yungnickyoung.minecraft.yungsextras.module;

import com.yungnickyoung.minecraft.yungsextras.YungsExtrasCommon;
import com.yungnickyoung.minecraft.yungsextras.services.Services;
import com.yungnickyoung.minecraft.yungsextras.world.config.DesertWellFeatureConfiguration;
import com.yungnickyoung.minecraft.yungsextras.world.config.ResourceLocationFeatureConfiguration;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.*;
import com.yungnickyoung.minecraft.yungsextras.world.feature.swamp.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class FeatureModule {
    /* Desert Features */
    public static Feature<DesertWellFeatureConfiguration> DESERT_WELL = new DesertWellFeature();
    public static Feature<ResourceLocationFeatureConfiguration> DESERT_OBELISK = new DesertObeliskFeature();
    public static Feature<NoneFeatureConfiguration> DESERT_GIANT_TORCH = new DesertGiantTorchFeature();
    public static Feature<NoneFeatureConfiguration> DESERT_RUINS_0 = new DesertSmallRuinsFeature();
    public static Feature<NoneFeatureConfiguration> DESERT_CHILLZONE = new ChillzoneDesertFeature();

    /* Swamp Features */
    public static Feature<ResourceLocationFeatureConfiguration> SWAMP_PILLAR = new SwampPillarFeature();
    public static Feature<ResourceLocationFeatureConfiguration> SWAMP_OGRE = new SwampOgreFeature();
    public static Feature<ResourceLocationFeatureConfiguration> SWAMP_CUBBY = new SwampCubbyFeature();
    public static Feature<ResourceLocationFeatureConfiguration> SWAMP_ARCH = new SwampArchFeature();
    public static Feature<ResourceLocationFeatureConfiguration> SWAMP_DOUBLE_ARCH = new SwampDoubleArchFeature();
    public static Feature<ResourceLocationFeatureConfiguration> SWAMP_CHURCH = new SwampChurchFeature();

    public static void init() {
        /* Desert Features */
        Services.REGISTRY.registerFeature(new ResourceLocation(YungsExtrasCommon.MOD_ID, "desert_well"), DESERT_WELL);
        Services.REGISTRY.registerFeature(new ResourceLocation(YungsExtrasCommon.MOD_ID, "desert_obelisk"), DESERT_OBELISK);
        Services.REGISTRY.registerFeature(new ResourceLocation(YungsExtrasCommon.MOD_ID, "desert_giant_torch"), DESERT_GIANT_TORCH);
        Services.REGISTRY.registerFeature(new ResourceLocation(YungsExtrasCommon.MOD_ID, "desert_ruins_0"), DESERT_RUINS_0);
        Services.REGISTRY.registerFeature(new ResourceLocation(YungsExtrasCommon.MOD_ID, "desert_chillzone"), DESERT_CHILLZONE);

        /* Swamp Features */
        Services.REGISTRY.registerFeature(new ResourceLocation(YungsExtrasCommon.MOD_ID, "swamp_pillar"), SWAMP_PILLAR);
        Services.REGISTRY.registerFeature(new ResourceLocation(YungsExtrasCommon.MOD_ID, "swamp_ogre"), SWAMP_OGRE);
        Services.REGISTRY.registerFeature(new ResourceLocation(YungsExtrasCommon.MOD_ID, "swamp_cubby"), SWAMP_CUBBY);
        Services.REGISTRY.registerFeature(new ResourceLocation(YungsExtrasCommon.MOD_ID, "swamp_arch"), SWAMP_ARCH);
        Services.REGISTRY.registerFeature(new ResourceLocation(YungsExtrasCommon.MOD_ID, "swamp_double_arch"), SWAMP_DOUBLE_ARCH);
        Services.REGISTRY.registerFeature(new ResourceLocation(YungsExtrasCommon.MOD_ID, "swamp_church"), SWAMP_CHURCH);
    }
}
