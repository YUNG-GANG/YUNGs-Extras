package com.yungnickyoung.minecraft.yungsextras.config.desert;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class ConfigDesertObelisks {
    @ConfigEntry.Gui.Tooltip
    public int normalObeliskSpawnRate = 700;

    @ConfigEntry.Gui.Tooltip
    public int creeperObeliskSpawnRate = 700;

    @ConfigEntry.Gui.Tooltip
    public int ruinedObeliskSpawnRate = 700;

    @ConfigEntry.Gui.Tooltip
    public int blackstoneObeliskSpawnRate = 3000;
}
