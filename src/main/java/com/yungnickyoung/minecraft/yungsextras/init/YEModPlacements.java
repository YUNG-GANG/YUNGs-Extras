package com.yungnickyoung.minecraft.yungsextras.init;

import com.mojang.serialization.Codec;
import com.yungnickyoung.minecraft.yungsextras.YungsExtras;
import com.yungnickyoung.minecraft.yungsextras.world.placement.RngInitializerPlacement;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

public class YEModPlacements {
    /* Placements */
    public static PlacementModifierType<?> RNG_INITIALIZER;

    /**
     * Set up placements.
     */
    public static void init() {
         RNG_INITIALIZER = register("rng_initializer", RngInitializerPlacement.CODEC);
    }

    private static <P extends PlacementModifier> PlacementModifierType<P> register(String name, Codec<P> codec) {
        return Registry.register(Registry.PLACEMENT_MODIFIERS, new ResourceLocation(YungsExtras.MOD_ID, name), () -> codec);
    }
}
