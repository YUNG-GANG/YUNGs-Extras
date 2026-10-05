package com.yungnickyoung.minecraft.yungsextras.module;

import com.mojang.serialization.MapCodec;
import com.yungnickyoung.minecraft.yungsapi.api.autoregister.AutoRegister;
import com.yungnickyoung.minecraft.yungsextras.YungsExtrasCommon;
import com.yungnickyoung.minecraft.yungsextras.world.placement.RngInitializerPlacement;

@AutoRegister(YungsExtrasCommon.MOD_ID)
public class PlacementModifierTypeModule {
    @AutoRegister("rng_initializer")
    public static MapCodec<RngInitializerPlacement> RNG_INITIALIZER = RngInitializerPlacement.CODEC;
}
