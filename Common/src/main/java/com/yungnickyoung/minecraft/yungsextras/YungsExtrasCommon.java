package com.yungnickyoung.minecraft.yungsextras;

import com.yungnickyoung.minecraft.yungsapi.api.YungAutoRegister;
import com.yungnickyoung.minecraft.yungsextras.services.Services;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class YungsExtrasCommon {
    public static final String MOD_ID = "yungsextras";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static void init() {
        YungAutoRegister.scanPackageForAnnotations("com.yungnickyoung.minecraft.yungsextras.module");
        Services.MODULES.loadModules();
    }
}
