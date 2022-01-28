package com.yungnickyoung.minecraft.yungsextras;

import com.yungnickyoung.minecraft.yungsextras.config.YEConfig;
import com.yungnickyoung.minecraft.yungsextras.init.YEModConfig;
import com.yungnickyoung.minecraft.yungsextras.init.YEModFeatures;
import com.yungnickyoung.minecraft.yungsextras.init.YEModPlacements;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

// The value here should match an entry in the META-INF/mods.toml file

public class YungsExtras implements ModInitializer {
    public static final String MOD_ID = "yungsextras";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    /** YUNG's Extras config. Uses AutoConfig. **/
    public static YEConfig CONFIG;

    /**
     * Lists of whitelisted and blacklisted biomes.
     * Will be reinitialized later w/ values from config.
     */
    public static List<String> additionalWhitelistedBiomes = new ArrayList<>();
    public static List<String> blacklistedBiomes = new ArrayList<>();

    public void onInitialize() {
        YEModConfig.init();
        YEModPlacements.init();
        YEModFeatures.init();
    }
}
