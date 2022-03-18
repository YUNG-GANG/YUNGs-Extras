package com.yungnickyoung.minecraft.yungsextras.services;

import com.yungnickyoung.minecraft.yungsextras.module.ConfigModuleForge;
import com.yungnickyoung.minecraft.yungsextras.module.FeatureModuleForge;
import com.yungnickyoung.minecraft.yungsextras.module.PlacementModuleForge;

public class ForgeModulesLoader implements IModulesLoader {
    @Override
    public void loadModules() {
        ConfigModuleForge.init();
        PlacementModuleForge.init();
        FeatureModuleForge.init();
    }
}
