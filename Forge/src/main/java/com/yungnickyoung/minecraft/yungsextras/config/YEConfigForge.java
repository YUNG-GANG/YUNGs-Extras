package com.yungnickyoung.minecraft.yungsextras.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class YEConfigForge {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    static {
        BUILDER.push("YUNG's Extras - spawn rates config has been moved to data pack JSON as of 1.19!");

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
