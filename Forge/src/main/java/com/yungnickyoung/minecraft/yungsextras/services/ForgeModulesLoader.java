package com.yungnickyoung.minecraft.yungsextras.services;

import com.yungnickyoung.minecraft.yungsextras.module.ConfigModuleForge;

public class ForgeModulesLoader implements IModulesLoader {
    @Override
    public void loadModules() {
        IModulesLoader.super.loadModules(); // Load common modules
        ConfigModuleForge.init();
    }
}
