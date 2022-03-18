package com.yungnickyoung.minecraft.yungsextras.config;

import com.yungnickyoung.minecraft.yungsextras.config.desert.ConfigDesertDecorationsFabric;
import com.yungnickyoung.minecraft.yungsextras.config.swamp.ConfigSwampFabric;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name="yungsextras-fabric-1_18")
public class YEConfigFabric implements ConfigData {
    @ConfigEntry.Category("Desert Decorations")
    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Gui.Tooltip
    public ConfigDesertDecorationsFabric desertDecorations = new ConfigDesertDecorationsFabric();

    @ConfigEntry.Category("Swamp Structures")
    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Gui.Tooltip
    public ConfigSwampFabric swampStructures = new ConfigSwampFabric();
}
