package com.yungnickyoung.minecraft.yungsextras.config.desert;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigDesertObelisks {
    public final ForgeConfigSpec.ConfigValue<Integer> normalObeliskSpawnRate;
    public final ForgeConfigSpec.ConfigValue<Integer> creeperObeliskSpawnRate;
    public final ForgeConfigSpec.ConfigValue<Integer> ruinedObeliskSpawnRate;
    public final ForgeConfigSpec.ConfigValue<Integer> blackstoneObeliskSpawnRate;

    public ConfigDesertObelisks(final ForgeConfigSpec.Builder BUILDER) {
        BUILDER
            .comment(
                "##########################################################################################################\n" +
                "# Settings for the different Desert Obelisk variations.\n" +
                "# \n" +
                "# The chance of each type of obelisk spawning in a given chunk is 1 / N, where N is the config value set below for that obelisk.\n" +
                "# For example, if the value is 1000 then there is a 1 in 1000 chance of spawning, per chunk.\n" +
                "##########################################################################################################")
            .push("Desert Obelisks");

        normalObeliskSpawnRate = BUILDER
            .comment(
                " Determines the spawn rate of normal obelisks.\n" +
                " Default: 700")
            .worldRestart()
            .define("Normal Obelisk Spawn Rate", 700);

        creeperObeliskSpawnRate = BUILDER
            .comment(
                " Determines the spawn rate of chiseled obelisks.\n" +
                " Default: 700")
            .worldRestart()
            .define("Chiseled Obelisk Spawn Rate", 700);

        ruinedObeliskSpawnRate = BUILDER
            .comment(
                " Determines the spawn rate of ruined obelisks.\n" +
                " Default: 700")
            .worldRestart()
            .define("Ruined Obelisk Spawn Rate", 700);

        blackstoneObeliskSpawnRate = BUILDER
            .comment(
                " Determines the spawn rate of blackstone obelisks.\n" +
                " Default: 3000")
            .worldRestart()
            .define("Blackstone Obelisk Spawn Rate", 3000);

        BUILDER.pop();
    }
}
