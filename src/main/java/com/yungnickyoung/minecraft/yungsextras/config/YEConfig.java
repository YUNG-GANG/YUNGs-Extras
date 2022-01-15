package com.yungnickyoung.minecraft.yungsextras.config;

import com.yungnickyoung.minecraft.yungsextras.config.desert.ConfigDesertDecorations;
import com.yungnickyoung.minecraft.yungsextras.config.swamp.ConfigSwamp;
import net.minecraftforge.common.ForgeConfigSpec;

public class YEConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ConfigDesertDecorations desertDecorations;
    public static final ConfigSwamp swamp;

    static {
        BUILDER.push("YUNG's Extras");

        desertDecorations = new ConfigDesertDecorations(BUILDER);
        swamp = new ConfigSwamp(BUILDER);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
