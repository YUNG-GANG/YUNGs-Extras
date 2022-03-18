package com.yungnickyoung.minecraft.yungsextras.config.desert;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class ConfigDesertDecorationsFabric {
    @ConfigEntry.Gui.Tooltip(count = 6)
    public String additionalBiomeWhitelist = "[]";

    @ConfigEntry.Gui.Tooltip(count = 7)
    public String biomeBlacklist = "[]";

    @ConfigEntry.Category("Desert Wells")
    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Gui.Tooltip(count = 4)
    public ConfigDesertWellsFabric wells = new ConfigDesertWellsFabric();

    @ConfigEntry.Category("Desert Obelisks")
    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Gui.Tooltip(count = 4)
    public ConfigDesertObelisksFabric obelisks = new ConfigDesertObelisksFabric();

    @ConfigEntry.Category("Desert Miscellaneous")
    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Gui.Tooltip(count = 4)
    public ConfigDesertMiscFabric misc = new ConfigDesertMiscFabric();
}
