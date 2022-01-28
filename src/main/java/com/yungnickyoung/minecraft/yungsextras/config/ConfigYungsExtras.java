package com.yungnickyoung.minecraft.yungsextras.config;

import com.yungnickyoung.minecraft.yungsextras.config.desert.ConfigDesertDecorations;
import com.yungnickyoung.minecraft.yungsextras.config.swamp.ConfigSwamp;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class ConfigYungsExtras {
    @ConfigEntry.Category("Desert Decorations")
    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Gui.Tooltip
    public ConfigDesertDecorations desertDecorations = new ConfigDesertDecorations();

    @ConfigEntry.Category("Swamp Structures")
    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Gui.Tooltip
    public ConfigSwamp swampStructures = new ConfigSwamp();
}
