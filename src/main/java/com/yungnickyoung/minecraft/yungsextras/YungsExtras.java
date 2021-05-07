package com.yungnickyoung.minecraft.yungsextras;

import com.yungnickyoung.minecraft.yungsextras.init.YEModFeatures;
import com.yungnickyoung.minecraft.yungsextras.init.YEModPlacements;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file

@Mod(YungsExtras.MOD_ID)
public class YungsExtras {
    public static final String MOD_ID = "yungsextras";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public YungsExtras() {
        init();
    }

    private void init() {
        YEModPlacements.init();
        YEModFeatures.init();
    }
}
