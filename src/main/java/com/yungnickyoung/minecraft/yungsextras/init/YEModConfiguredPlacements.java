package com.yungnickyoung.minecraft.yungsextras.init;

import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.NoPlacementConfig;

public class YEModConfiguredPlacements {
    public static final ConfiguredPlacement<NoPlacementConfig> RNG_INITIALIZER = YEModPlacements.RNG_INITIALIZER.get()
        .configure(IPlacementConfig.NO_PLACEMENT_CONFIG);
}
