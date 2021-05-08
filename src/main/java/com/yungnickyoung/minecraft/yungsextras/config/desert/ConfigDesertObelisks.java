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
                "##########################################################################################################")
            .push("Desert Obelisks");

        normalObeliskSpawnRate = BUILDER
            .comment(
                " The spawn rate (chance per chunk) of a normal obelisk spawning.\n" +
                " Default: 700")
            .worldRestart()
            .define("Normal Obelisk Spawn Rate", 700);

        creeperObeliskSpawnRate = BUILDER
            .comment(
                " The spawn rate (chance per chunk) of a chiseled obelisk spawning.\n" +
                " Default: 700")
            .worldRestart()
            .define("Chiseled Obelisk Spawn Rate", 700);

        ruinedObeliskSpawnRate = BUILDER
            .comment(
                " The spawn rate (chance per chunk) of a ruined obelisk spawning.\n" +
                " Default: 700")
            .worldRestart()
            .define("Ruined Obelisk Spawn Rate", 700);

        blackstoneObeliskSpawnRate = BUILDER
            .comment(
                " The spawn rate (chance per chunk) of a blackstone obelisk spawning.\n" +
                " Default: 3000")
            .worldRestart()
            .define("Blackstone Obelisk Spawn Rate", 3000);

        BUILDER.pop();
    }
}
