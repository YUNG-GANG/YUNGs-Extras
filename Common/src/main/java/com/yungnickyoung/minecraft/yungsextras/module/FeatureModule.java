package com.yungnickyoung.minecraft.yungsextras.module;

import com.yungnickyoung.minecraft.yungsextras.world.config.DesertWellFeatureConfiguration;
import com.yungnickyoung.minecraft.yungsextras.world.config.ResourceLocationFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class FeatureModule {
    /* Desert Features */
    public static Feature<DesertWellFeatureConfiguration> DESERT_WELL;
    public static Feature<ResourceLocationFeatureConfiguration> DESERT_OBELISK;
    public static Feature<NoneFeatureConfiguration> DESERT_GIANT_TORCH;
    public static Feature<NoneFeatureConfiguration> DESERT_RUINS_0;
    public static Feature<NoneFeatureConfiguration> DESERT_CHILLZONE;

    /* Swamp Features */
    public static Feature<ResourceLocationFeatureConfiguration> SWAMP_PILLAR;
    public static Feature<ResourceLocationFeatureConfiguration> SWAMP_OGRE;
    public static Feature<ResourceLocationFeatureConfiguration> SWAMP_CUBBY;
    public static Feature<ResourceLocationFeatureConfiguration> SWAMP_ARCH;
    public static Feature<ResourceLocationFeatureConfiguration> SWAMP_DOUBLE_ARCH;
    public static Feature<ResourceLocationFeatureConfiguration> SWAMP_CHURCH;
}
