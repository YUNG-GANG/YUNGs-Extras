package com.yungnickyoung.minecraft.yungsextras.config;

import com.yungnickyoung.minecraft.yungsextras.config.desert.ConfigDesertDecorationsForge;
import com.yungnickyoung.minecraft.yungsextras.config.swamp.ConfigSwampForge;
import net.minecraftforge.common.ForgeConfigSpec;

public class YEConfigForge {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ConfigDesertDecorationsForge desertDecorations;
    public static final ConfigSwampForge swamp;

    static {
        BUILDER.push("YUNG's Extras");

        desertDecorations = new ConfigDesertDecorationsForge(BUILDER);
        swamp = new ConfigSwampForge(BUILDER);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
