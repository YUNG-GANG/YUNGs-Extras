package com.yungnickyoung.minecraft.yungsextras.config;

import com.yungnickyoung.minecraft.yungsextras.config.desert.ConfigDesertDecorations;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class ConfigYungsExtras {
    @ConfigEntry.Category("Desert Decorations")
    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Gui.Tooltip
    public ConfigDesertDecorations desertDecorations = new ConfigDesertDecorations();
}
