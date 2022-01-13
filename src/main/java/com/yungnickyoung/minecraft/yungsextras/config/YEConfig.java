package com.yungnickyoung.minecraft.yungsextras.config;

import com.google.common.collect.Lists;
import com.yungnickyoung.minecraft.yungsextras.YungsExtras;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

import java.util.List;

@Config(name="yungsextras-fabric-1_18")
public class YEConfig implements ConfigData {
    @ConfigEntry.Category("YUNG's Extras")
    @ConfigEntry.Gui.TransitiveObject
    public ConfigYungsExtras yungsExtras = new ConfigYungsExtras();

    /**
     * Parses the whitelisted & blacklisted biomes strings and updates the stored values.
     */
    @Override
    public void validatePostLoad() {
        YungsExtras.desertDecorationsAdditionalWhitelist = parseListString(yungsExtras.desertDecorations.additionalBiomeWhitelist, YungsExtras.desertDecorationsAdditionalWhitelist, "Additional Whitelisted Biomes");
        YungsExtras.desertDecorationsBlacklist = parseListString(yungsExtras.desertDecorations.biomeBlacklist, YungsExtras.desertDecorationsBlacklist, "Blacklisted Biomes");
    }

    private List<String> parseListString(String dimensionWhitelistString, List<String> defaultList, String settingName) {
        int strLen = dimensionWhitelistString.length();

        // Validate the string's format
        if (strLen < 2 || dimensionWhitelistString.charAt(0) != '[' || dimensionWhitelistString.charAt(strLen - 1) != ']') {
            YungsExtras.LOGGER.error("INVALID VALUE FOR SETTING '{}'. Using empty list instead...", settingName);
            return defaultList;
        }

        // Parse string to list
        return Lists.newArrayList(dimensionWhitelistString.substring(1, strLen - 1).split(",\\s*"));
    }
}
