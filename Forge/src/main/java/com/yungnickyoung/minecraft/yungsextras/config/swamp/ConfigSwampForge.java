package com.yungnickyoung.minecraft.yungsextras.config.swamp;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigSwampForge {
    public final ForgeConfigSpec.ConfigValue<String> additionalBiomeWhitelist;
    public final ForgeConfigSpec.ConfigValue<String> biomeBlacklist;

    public final ForgeConfigSpec.ConfigValue<Integer> pillarSpawnRate;
    public final ForgeConfigSpec.ConfigValue<Integer> ogreSpawnRate;
    public final ForgeConfigSpec.ConfigValue<Integer> cubbySpawnRate;
    public final ForgeConfigSpec.ConfigValue<Integer> archSpawnRate;
    public final ForgeConfigSpec.ConfigValue<Integer> doubleArchSpawnRate;
    public final ForgeConfigSpec.ConfigValue<Integer> churchSpawnRate;

    public ConfigSwampForge(final ForgeConfigSpec.Builder BUILDER) {
        BUILDER
            .comment(
                "##########################################################################################################\n" +
                "# Settings for swamp structures.\n" +
                "# \n" +
                "# The chance of each structure spawning in a given chunk is 1 / N, where N is the config value set below for that structure.\n" +
                "# For example, if the value is 1000 then there is a 1 in 1000 chance of spawning, per chunk.\n" +
                "##########################################################################################################")
            .push("Swamp Structures");

        additionalBiomeWhitelist = BUILDER
                .comment(
                        " List of additional biomes that will have Swamp Structures.\n" +
                                " By default, all biomes (including modded biomes) with the Swamp category are automatically included, \n" +
                                " and do not need to be added here.\n" +
                                " List must be comma-separated values enclosed in square brackets. \n" +
                                " Entries must have the mod namespace included.\n" +
                                " For example: \"[minecraft:plains, byg:alps]\"\n" +
                                " Default: \"[]\"")
                .worldRestart()
                .define("Additional Whitelisted Biomes (Swamp)", "[]");

        biomeBlacklist = BUILDER
                .comment(
                        " List of biomes that will NOT have Swamp Structures.\n" +
                                " By default, all Swamp biomes will automatically have Swamp Structures, \n" +
                                " so you only need to blacklist biomes with the Swamp category that you don't want to spawn \n" +
                                " Swamp Structures in.\n" +
                                " List must be comma-separated values enclosed in square brackets.\n" +
                                " Entries must have the mod namespace included.\n" +
                                " For example: \"[minecraft:desert, byg:dunes]\"\n" +
                                " Default: \"[]\"")
                .worldRestart()
                .define("Blacklisted Biomes (Swamp)", "[]");

        pillarSpawnRate = BUILDER
            .comment(
                " Determines the spawn rate of swamp pillars.\n" +
                " Default: 900")
            .worldRestart()
            .define("Swamp Pillar Spawn Rate", 900);

        ogreSpawnRate = BUILDER
            .comment(
                " Determines the spawn rate of outhouses.\n" +
                " Default: 3000")
            .worldRestart()
            .define("Outhouse Spawn Rate", 3000);

        cubbySpawnRate = BUILDER
            .comment(
                " Determines the spawn rate of swamp cubbies.\n" +
                " Default: 1000")
            .worldRestart()
            .define("Swamp Cubby Spawn Rate", 1000);

        archSpawnRate = BUILDER
            .comment(
                " Determines the spawn rate of ruined arches.\n" +
                " Default: 1200")
            .worldRestart()
            .define("Ruined Arch Spawn Rate", 1200);

        doubleArchSpawnRate = BUILDER
            .comment(
                " Determines the spawn rate of ruined double arches.\n" +
                " Default: 1500")
            .worldRestart()
            .define("Ruined Double Arch Spawn Rate", 1500);

        churchSpawnRate = BUILDER
            .comment(
                " Determines the spawn rate of ruined gateways.\n" +
                " Default: 2000")
            .worldRestart()
            .define("Ruined Gateway Spawn Rate", 2000);

        BUILDER.pop();
    }
}
