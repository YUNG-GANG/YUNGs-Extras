package com.yungnickyoung.minecraft.yungsextras.services;

import com.yungnickyoung.minecraft.yungsextras.module.ConfigModuleForge;
import com.yungnickyoung.minecraft.yungsextras.module.FeatureModuleForge;
import com.yungnickyoung.minecraft.yungsextras.module.PlacementModifierTypeModuleForge;

public class ForgeModulesLoader implements IModulesLoader {
    @Override
    public void loadModules() {
        IModulesLoader.super.loadModules(); // Load common modules
        ConfigModuleForge.init();
        PlacementModifierTypeModuleForge.init();
        FeatureModuleForge.init();
    }
}
