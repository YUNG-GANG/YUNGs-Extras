package com.yungnickyoung.minecraft.yungsextras.services;

import com.yungnickyoung.minecraft.yungsextras.module.FeatureModule;
import com.yungnickyoung.minecraft.yungsextras.module.PlacementModifierTypeModule;

public interface IModulesLoader {
    default void loadModules() {
        FeatureModule.init();
        PlacementModifierTypeModule.init();
    }
}
