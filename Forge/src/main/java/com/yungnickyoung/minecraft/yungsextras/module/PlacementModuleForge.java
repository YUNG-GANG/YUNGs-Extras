package com.yungnickyoung.minecraft.yungsextras.module;

import com.mojang.serialization.Codec;
import com.yungnickyoung.minecraft.yungsextras.YungsExtrasCommon;
import com.yungnickyoung.minecraft.yungsextras.world.placement.RngInitializerPlacement;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class PlacementModuleForge {
    public static void init() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(PlacementModuleForge::commonSetup);
    }

    /**
     * Set up placements.
     */
    private static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            PlacementsModule.RNG_INITIALIZER = register("rng_initializer", RngInitializerPlacement.CODEC);
        });
    }

    private static <P extends PlacementModifier> PlacementModifierType<P> register(String name, Codec<P> codec) {
        return Registry.register(Registry.PLACEMENT_MODIFIERS, new ResourceLocation(YungsExtrasCommon.MOD_ID, name), () -> codec);
    }
}
