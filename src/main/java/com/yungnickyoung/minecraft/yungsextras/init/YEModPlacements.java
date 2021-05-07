package com.yungnickyoung.minecraft.yungsextras.init;

import com.yungnickyoung.minecraft.yungsextras.YungsExtras;
import com.yungnickyoung.minecraft.yungsextras.world.placement.RngInitializerPlacement;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.HeightmapWorldSurfacePlacement;
import net.minecraft.world.gen.placement.NoPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class YEModPlacements {
    /* Registry for deferred registration */
    public static final DeferredRegister<Placement<?>> PLACEMENTS = DeferredRegister.create(ForgeRegistries.DECORATORS, YungsExtras.MOD_ID);

    /* Placements */
    public static final RegistryObject<Placement<NoPlacementConfig>> RNG_INITIALIZER = register("rng_initializer", RngInitializerPlacement::new);

    public static void init() {
        PLACEMENTS.register(FMLJavaModLoadingContext.get().getModEventBus());
        FMLJavaModLoadingContext.get().getModEventBus().addListener(YEModPlacements::commonSetup);
    }

    /**
     * Set up placements.
     */
    private static void commonSetup(FMLCommonSetupEvent event) {
    }

    private static <T extends Placement<?>> RegistryObject<T> register(String name, Supplier<T> feature) {
        return PLACEMENTS.register(name, feature);
    }
}
