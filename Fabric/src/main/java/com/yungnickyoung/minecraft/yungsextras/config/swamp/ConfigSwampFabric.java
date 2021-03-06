package com.yungnickyoung.minecraft.yungsextras.config.swamp;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class ConfigSwampFabric {
    @ConfigEntry.Gui.Tooltip(count = 6)
    public String additionalBiomeWhitelist = "[]";

    @ConfigEntry.Gui.Tooltip(count = 7)
    public String biomeBlacklist = "[]";

    @ConfigEntry.Gui.Tooltip
    public int pillarSpawnRate = 900;

    @ConfigEntry.Gui.Tooltip
    public int ogreSpawnRate = 3000;

    @ConfigEntry.Gui.Tooltip
    public int cubbySpawnRate = 1000;

    @ConfigEntry.Gui.Tooltip
    public int archSpawnRate = 1200;

    @ConfigEntry.Gui.Tooltip
    public int doubleArchSpawnRate = 1500;

    @ConfigEntry.Gui.Tooltip
    public int churchSpawnRate = 2000;
}
