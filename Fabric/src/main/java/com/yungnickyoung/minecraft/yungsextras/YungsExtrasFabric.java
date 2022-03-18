package com.yungnickyoung.minecraft.yungsextras;

import net.fabricmc.api.ModInitializer;

public class YungsExtrasFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        YungsExtrasCommon.init();
    }
}
