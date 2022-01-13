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
                "# \n" +
                "# The chance of each structure spawning in a given chunk is 1 / N, where N is the config value set below for that structure.\n" +
                "# For example, if the value is 1000 then there is a 1 in 1000 chance of spawning, per chunk.\n" +
                "##########################################################################################################")
            .push("Desert Miscellaneous");

        smallRuinsSpawnRate = BUILDER
            .comment(
                " Determines the spawn rate of small ruins.\n" +
                " Default: 1000")
            .worldRestart()
            .define("Ruins Spawn Rate (Small)", 1000);

        giantTorchSpawnRate = BUILDER
            .comment(
                " Determines the spawn rate of flame outposts.\n" +
                " Default: 700")
            .worldRestart()
            .define("Flame Outpost Spawn Rate", 700);

        chillzoneSpawnRate = BUILDER
            .comment(
                " Determines the spawn rate of abandoned vacation spots.\n" +
                " Default: 1000")
            .worldRestart()
            .define("Abandoned Vacation Spot Spawn Rate", 1000);

        BUILDER.pop();
    }
}
