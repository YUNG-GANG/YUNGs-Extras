package com.yungnickyoung.minecraft.yungsextras.config.desert;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigDesertWells {
    public final ForgeConfigSpec.ConfigValue<Integer> smallNormalWellSpawnRate;
    public final ForgeConfigSpec.ConfigValue<Integer> mediumNormalWellSpawnRate;
    public final ForgeConfigSpec.ConfigValue<Integer> largeNormalWellSpawnRate;
    public final ForgeConfigSpec.ConfigValue<Integer> smallWishingWellSpawnRate;
    public final ForgeConfigSpec.ConfigValue<Integer> mediumWishingWellSpawnRate;
    public final ForgeConfigSpec.ConfigValue<Integer> largeWishingWellSpawnRate;
    public final ForgeConfigSpec.ConfigValue<Integer> smallDryWellSpawnRate;
    public final ForgeConfigSpec.ConfigValue<Integer> mediumDryWellSpawnRate;
    public final ForgeConfigSpec.ConfigValue<Integer> largeDryWellSpawnRate;

    public ConfigDesertWells(final ForgeConfigSpec.Builder BUILDER) {
        BUILDER
            .comment(
                "##########################################################################################################\n" +
                "# Settings for the different Desert Well variations.\n" +
                "# \n" +
                "# The chance of each type of well spawning in a given chunk is 1 / N, where N is the config value set below for that well.\n" +
                "# For example, if the value is 1000 then there is a 1 in 1000 chance of spawning, per chunk.\n" +
                "##########################################################################################################")
            .push("Desert Wells");

        smallNormalWellSpawnRate = BUILDER
            .comment(
                " Determines the spawn rate of small normal wells.\n" +
                " Default: 1200")
            .worldRestart()
            .define("Normal Well Spawn Rate (Small)", 1200);

        mediumNormalWellSpawnRate = BUILDER
            .comment(
                " Determines the spawn rate of medium-sized normal wells.\n" +
                " Default: 1200")
            .worldRestart()
            .define("Normal Well Spawn Rate (Medium)", 1200);

        largeNormalWellSpawnRate = BUILDER
            .comment(
                " Determines the spawn rate of large normal wells.\n" +
                " Default: 1200")
            .worldRestart()
            .define("Normal Well Spawn Rate (Large)", 1200);

        smallWishingWellSpawnRate = BUILDER
            .comment(
                " Determines the spawn rate of small Wishing Wells.\n" +
                " Default: 1200")
            .worldRestart()
            .define("Wishing Well Spawn Rate (Small)", 1200);

        mediumWishingWellSpawnRate = BUILDER
            .comment(
                " Determines the spawn rate of medium-sized Wishing Wells.\n" +
                " Default: 1200")
            .worldRestart()
            .define("Wishing Well Spawn Rate (Medium)", 1200);

        largeWishingWellSpawnRate = BUILDER
            .comment(
                " Determines the spawn rate of large Wishing Wells.\n" +
                " Default: 1200")
            .worldRestart()
            .define("Wishing Well Spawn Rate (Large)", 1200);

        smallDryWellSpawnRate = BUILDER
            .comment(
                " Determines the spawn rate of small dry wells.\n" +
                " Default: 1200")
            .worldRestart()
            .define("Dry Well Spawn Rate (Small)", 1200);

        mediumDryWellSpawnRate = BUILDER
            .comment(
                " Determines the spawn rate of medium-sized dry wells.\n" +
                " Default: 1200")
            .worldRestart()
            .define("Dry Well Spawn Rate (Medium)", 1200);

        largeDryWellSpawnRate = BUILDER
            .comment(
                " Determines the spawn rate of large dry wells.\n" +
                " Default: 1200")
            .worldRestart()
            .define("Dry Well Spawn Rate (Large)", 1200);

        BUILDER.pop();
    }
}
