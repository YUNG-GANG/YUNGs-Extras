package com.yungnickyoung.minecraft.yungsextras.services;

import com.yungnickyoung.minecraft.yungsextras.module.ConfigModuleFabric;
import com.yungnickyoung.minecraft.yungsextras.module.BiomeModificationModuleFabric;

public class FabricModulesLoader implements IModulesLoader {
    @Override
    public void loadModules() {
        IModulesLoader.super.loadModules(); // Load common modules
        ConfigModuleFabric.init();
        BiomeModificationModuleFabric.init();
    }
}
