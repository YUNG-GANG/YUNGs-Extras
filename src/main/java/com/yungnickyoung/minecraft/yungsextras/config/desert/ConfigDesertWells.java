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
                "##########################################################################################################")
            .push("Desert Wells");

        smallNormalWellSpawnRate = BUILDER
            .comment(
                " The spawn rate (chance per chunk) of a small normal well spawning.\n" +
                " Default: 3000")
            .worldRestart()
            .define("Normal Well Spawn Rate (Small)", 3000);

        mediumNormalWellSpawnRate = BUILDER
            .comment(
                " The spawn rate (chance per chunk) of a medium-sized normal well spawning.\n" +
                " Default: 3000")
            .worldRestart()
            .define("Normal Well Spawn Rate (Medium)", 3000);

        largeNormalWellSpawnRate = BUILDER
            .comment(
                " The spawn rate (chance per chunk) of a large normal well spawning.\n" +
                " Default: 3000")
            .worldRestart()
            .define("Normal Well Spawn Rate (Large)", 3000);

        smallWishingWellSpawnRate = BUILDER
            .comment(
                " The spawn rate (chance per chunk) of a small Wishing Well spawning.\n" +
                " Default: 3000")
            .worldRestart()
            .define("Wishing Well Spawn Rate (Small)", 3000);

        mediumWishingWellSpawnRate = BUILDER
            .comment(
                " The spawn rate (chance per chunk) of a medium-sized Wishing Well spawning.\n" +
                " Default: 3000")
            .worldRestart()
            .define("Wishing Well Spawn Rate (Medium)", 3000);

        largeWishingWellSpawnRate = BUILDER
            .comment(
                " The spawn rate (chance per chunk) of a large Wishing Well spawning.\n" +
                " Default: 3000")
            .worldRestart()
            .define("Wishing Well Spawn Rate (Large)", 3000);

        smallDryWellSpawnRate = BUILDER
            .comment(
                " The spawn rate (chance per chunk) of a small dry well spawning.\n" +
                " Default: 3000")
            .worldRestart()
            .define("Dry Well Spawn Rate (Small)", 3000);

        mediumDryWellSpawnRate = BUILDER
            .comment(
                " The spawn rate (chance per chunk) of a medium-sized dry well spawning.\n" +
                " Default: 3000")
            .worldRestart()
            .define("Dry Well Spawn Rate (Medium)", 3000);

        largeDryWellSpawnRate = BUILDER
            .comment(
                " The spawn rate (chance per chunk) of a large dry well spawning.\n" +
                " Default: 3000")
            .worldRestart()
            .define("Dry Well Spawn Rate (Large)", 3000);

        BUILDER.pop();
    }
}
