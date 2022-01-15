package com.yungnickyoung.minecraft.yungsextras.config.swamp;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigSwamp {
    public final ForgeConfigSpec.ConfigValue<Integer> pillarSpawnRate;
    public final ForgeConfigSpec.ConfigValue<Integer> ogreSpawnRate;

    public ConfigSwamp(final ForgeConfigSpec.Builder BUILDER) {
        BUILDER
            .comment(
                "##########################################################################################################\n" +
                "# Settings for swamp structures.\n" +
                "# \n" +
                "# The chance of each structure spawning in a given chunk is 1 / N, where N is the config value set below for that structure.\n" +
                "# For example, if the value is 1000 then there is a 1 in 1000 chance of spawning, per chunk.\n" +
                "##########################################################################################################")
            .push("Swamp Structures");

        pillarSpawnRate = BUILDER
            .comment(
                " Determines the spawn rate of swamp pillars.\n" +
                " Default: 200")
            .worldRestart()
            .define("Swamp Pillar Spawn Rate", 200);

        ogreSpawnRate = BUILDER
            .comment(
                " Determines the spawn rate of outhouses.\n" +
                " Default: 3000")
            .worldRestart()
            .define("Outhouse Spawn Rate", 3000);

        BUILDER.pop();
    }
}
