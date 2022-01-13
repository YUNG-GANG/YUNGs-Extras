package com.yungnickyoung.minecraft.yungsextras.config.desert;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class ConfigDesertDecorations {
    @ConfigEntry.Gui.Tooltip(count = 6)
    public String additionalBiomeWhitelist = "[]";

    @ConfigEntry.Gui.Tooltip(count = 7)
    public String biomeBlacklist = "[]";

    @ConfigEntry.Category("Desert Wells")
    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Gui.Tooltip(count = 4)
    public ConfigDesertWells wells = new ConfigDesertWells();

    @ConfigEntry.Category("Desert Obelisks")
    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Gui.Tooltip(count = 4)
    public ConfigDesertObelisks obelisks = new ConfigDesertObelisks();

    @ConfigEntry.Category("Desert Miscellaneous")
    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Gui.Tooltip(count = 4)
    public ConfigDesertMisc misc = new ConfigDesertMisc();
}
