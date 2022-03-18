package com.yungnickyoung.minecraft.yungsextras.services;

import com.yungnickyoung.minecraft.yungsextras.module.ConfigModuleFabric;
import com.yungnickyoung.minecraft.yungsextras.module.FeatureModuleFabric;
import com.yungnickyoung.minecraft.yungsextras.module.PlacementModuleFabric;

public class FabricModulesLoader implements IModulesLoader {
    @Override
    public void loadModules() {
        ConfigModuleFabric.init();
        PlacementModuleFabric.init();
        FeatureModuleFabric.init();
    }
}
