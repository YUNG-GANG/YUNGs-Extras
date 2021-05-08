package com.yungnickyoung.minecraft.yungsextras.config.desert;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigDesertDecorations {
    public final ForgeConfigSpec.ConfigValue<String> additionalBiomeWhitelist;
    public final ForgeConfigSpec.ConfigValue<String> biomeBlacklist;

    public final ConfigDesertWells wells;
    public final ConfigDesertObelisks obelisks;
    public final ConfigDesertMisc misc;

    public ConfigDesertDecorations(final ForgeConfigSpec.Builder BUILDER) {
        BUILDER
            .comment(
                "##########################################################################################################\n" +
                "# Desert Decorations\n" +
                "##########################################################################################################")
            .push("Desert Decorations");

        additionalBiomeWhitelist = BUILDER
            .comment(
                " List of additional biomes that will have Desert Decorations.\n" +
                " By default, all biomes (including modded biomes) with the Desert category are automatically included, \n" +
                " and do not need to be added here.\n" +
                " List must be comma-separated values enclosed in square brackets. \n" +
                " Entries must have the mod namespace included.\n" +
                " For example: \"[minecraft:plains, byg:alps]\"\n" +
                " Default: \"[]\"")
            .worldRestart()
            .define("Additional Whitelisted Biomes", "[]");

        biomeBlacklist = BUILDER
            .comment(
                " List of biomes that will NOT have Desert Decorations.\n" +
                " By default, all Desert biomes will automatically have Desert Decorations, \n" +
                " so you only need to blacklist biomes with the Desert category that you don't want to spawn \n" +
                " Desert Decorations in.\n" +
                " List must be comma-separated values enclosed in square brackets.\n" +
                " Entries must have the mod namespace included.\n" +
                " For example: \"[minecraft:desert, byg:dunes]\"\n" +
                " Default: \"[]\"")
            .worldRestart()
            .define("Blacklisted Biomes", "[]");

        wells = new ConfigDesertWells(BUILDER);
        obelisks = new ConfigDesertObelisks(BUILDER);
        misc = new ConfigDesertMisc(BUILDER);

        BUILDER.pop();
    }
}
