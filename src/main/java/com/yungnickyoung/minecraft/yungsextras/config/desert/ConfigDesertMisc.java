package com.yungnickyoung.minecraft.yungsextras.config.desert;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigDesertMisc {
    public final ForgeConfigSpec.ConfigValue<Integer> smallRuinsSpawnRate;
    public final ForgeConfigSpec.ConfigValue<Integer> giantTorchSpawnRate;
    public final ForgeConfigSpec.ConfigValue<Integer> chillzoneSpawnRate;

    public ConfigDesertMisc(final ForgeConfigSpec.Builder BUILDER) {
        BUILDER
            .comment(
                "##########################################################################################################\n" +
                "# Settings for miscellaneous desert structures.\n" +
                "##########################################################################################################")
            .push("Desert Miscellaneous");

        smallRuinsSpawnRate = BUILDER
            .comment(
                " The spawn rate (chance per chunk) of a small ruins spawning.\n" +
                " Default: 1000")
            .worldRestart()
            .define("Ruins Spawn Rate (Small)", 1000);

        giantTorchSpawnRate = BUILDER
            .comment(
                " The spawn rate (chance per chunk) of a flame outpost spawning.\n" +
                " Default: 1000")
            .worldRestart()
            .define("Flame Outpost Spawn Rate", 1000);

        chillzoneSpawnRate = BUILDER
            .comment(
                " The spawn rate (chance per chunk) of an abandoned vacation spot spawning.\n" +
                " Default: 1000")
            .worldRestart()
            .define("Abandoned Vacation Spot Spawn Rate", 1000);

        BUILDER.pop();
    }
}
