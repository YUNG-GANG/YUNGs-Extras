package com.yungnickyoung.minecraft.yungsextras.module;

import com.yungnickyoung.minecraft.yungsapi.api.autoregister.AutoRegister;
import com.yungnickyoung.minecraft.yungsextras.YungsExtrasCommon;
import com.yungnickyoung.minecraft.yungsextras.world.placement.RngInitializerPlacement;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

@AutoRegister(YungsExtrasCommon.MOD_ID)
public class PlacementModifierTypeModule {
    @AutoRegister("rng_initializer")
    public static PlacementModifierType<?> RNG_INITIALIZER = () -> RngInitializerPlacement.CODEC;
}
