package com.yungnickyoung.minecraft.yungsextras.module;

import com.yungnickyoung.minecraft.yungsextras.YungsExtrasCommon;
import com.yungnickyoung.minecraft.yungsextras.services.Services;
import com.yungnickyoung.minecraft.yungsextras.world.placement.RngInitializerPlacement;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

public class PlacementModifierTypeModule {
    public static PlacementModifierType<?> RNG_INITIALIZER = () -> RngInitializerPlacement.CODEC;

    public static void init() {
        Services.REGISTRY.registerPlacementModifierType(new ResourceLocation(YungsExtrasCommon.MOD_ID, "rng_initializer"), RNG_INITIALIZER);
    }
}
