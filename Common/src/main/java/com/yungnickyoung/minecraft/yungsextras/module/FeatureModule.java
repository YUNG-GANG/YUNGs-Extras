package com.yungnickyoung.minecraft.yungsextras.module;

import com.mojang.serialization.MapCodec;
import com.yungnickyoung.minecraft.yungsapi.api.autoregister.AutoRegister;
import com.yungnickyoung.minecraft.yungsextras.YungsExtrasCommon;
import com.yungnickyoung.minecraft.yungsextras.world.config.DesertWellFeatureConfiguration;
import com.yungnickyoung.minecraft.yungsextras.world.config.IdentifierFeatureConfiguration;
import com.yungnickyoung.minecraft.yungsextras.world.feature.desert.*;
import com.yungnickyoung.minecraft.yungsextras.world.feature.swamp.*;
import net.minecraft.world.level.levelgen.feature.Feature;

@AutoRegister(YungsExtrasCommon.MOD_ID)
public class FeatureModule {
    /* Desert Features */
    @AutoRegister("desert_well")
    public static MapCodec<? extends Feature> DESERT_WELL = DesertWellFeature.CODEC;

    @AutoRegister("desert_obelisk")
    public static MapCodec<? extends Feature> DESERT_OBELISK = DesertObeliskFeature.CODEC;

    @AutoRegister("desert_giant_torch")
    public static MapCodec<? extends Feature> DESERT_GIANT_TORCH = DesertGiantTorchFeature.CODEC;

    @AutoRegister("desert_ruins_0")
    public static MapCodec<? extends Feature> DESERT_RUINS_0 = DesertSmallRuinsFeature.CODEC;

    @AutoRegister("desert_chillzone")
    public static MapCodec<? extends Feature> DESERT_CHILLZONE = ChillzoneDesertFeature.CODEC;

    /* Swamp Features */
    @AutoRegister("swamp_pillar")
    public static MapCodec<? extends Feature> SWAMP_PILLAR = SwampPillarFeature.CODEC;

    @AutoRegister("swamp_ogre")
    public static MapCodec<? extends Feature> SWAMP_OGRE = SwampOgreFeature.CODEC;

    @AutoRegister("swamp_cubby")
    public static MapCodec<? extends Feature> SWAMP_CUBBY = SwampCubbyFeature.CODEC;

    @AutoRegister("swamp_arch")
    public static MapCodec<? extends Feature> SWAMP_ARCH = SwampArchFeature.CODEC;

    @AutoRegister("swamp_double_arch")
    public static MapCodec<? extends Feature> SWAMP_DOUBLE_ARCH = SwampDoubleArchFeature.CODEC;

    @AutoRegister("swamp_church")
    public static MapCodec<? extends Feature> SWAMP_CHURCH = SwampChurchFeature.CODEC;
}
