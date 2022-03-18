package com.yungnickyoung.minecraft.yungsextras.module;

import com.google.common.collect.Lists;
import com.yungnickyoung.minecraft.yungsapi.io.JSON;
import com.yungnickyoung.minecraft.yungsextras.YungsExtrasCommon;
import com.yungnickyoung.minecraft.yungsextras.config.YEConfigForge;
import com.yungnickyoung.minecraft.yungsextras.world.WishingWellChances;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ConfigModuleForge {
    public static final String CUSTOM_CONFIG_PATH = "YungsExtras";
    public static final String VERSION_PATH = "forge-1_18";

    public static void init() {
        initCustomFiles();
        // Register mod config with Forge
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, YEConfigForge.SPEC, "YungsExtras-forge-1_18.toml");
        MinecraftForge.EVENT_BUS.addListener(ConfigModuleForge::onWorldLoad);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ConfigModuleForge::onConfigChange);
    }

    private static void onWorldLoad(WorldEvent.Load event) {
        bakeConfig();
    }

    private static void onConfigChange(ModConfigEvent event) {
        if (event.getConfig().getSpec() == YEConfigForge.SPEC) {
            bakeConfig();
        }
    }

    private static void initCustomFiles() {
        createDirectory();
        createBaseReadMe();
        createJsonReadMe();
        loadJSON();
    }

    private static void loadJSON() {
        loadWishingWellsJSON();
    }

    private static void createDirectory() {
        File parentDir = new File(FMLPaths.CONFIGDIR.get().toString(), CUSTOM_CONFIG_PATH);
        File customConfigDir = new File(parentDir, VERSION_PATH);
        try {
            String filePath = customConfigDir.getCanonicalPath();
            if (customConfigDir.mkdirs()) {
                YungsExtrasCommon.LOGGER.info("Creating directory for additional YUNG's Extras configuration at {}", filePath);
            }
        } catch (IOException e) {
            YungsExtrasCommon.LOGGER.error("ERROR creating YUNG's Extras config directory: {}", e.toString());
        }
    }

    private static void createBaseReadMe() {
        Path path = Paths.get(FMLPaths.CONFIGDIR.get().toString(), CUSTOM_CONFIG_PATH, "README.txt");
        File readme = new File(path.toString());
        if (!readme.exists()) {
            String readmeText =
                    """
                            This directory is for a few additional options for YUNG's Extras.
                            Options provided may vary by version.
                            This directory contains subdirectories for supported versions. The first time you run YUNG's Extras, a version subdirectory will be created if that version supports advanced options.
                            For example, the first time you use YUNG's Extras for MC 1.16 on Forge, the 'forge-1_16' subdirectory will be created in this folder.
                            If no subdirectory for your version is created, then that version probably does not support the additional options.

                            NOTE -- MOST OPTIONS CAN BE FOUND IN A CONFIG FILE OUTSIDE THIS FOLDER!
                            For example, on Forge 1.16 the file is 'YungsExtras-forge-1_16.toml'.""";
            try {
                Files.write(path, readmeText.getBytes());
            } catch (IOException e) {
                YungsExtrasCommon.LOGGER.error("Unable to create README file!");
            }
        }
    }

    private static void createJsonReadMe() {
        Path path = Paths.get(FMLPaths.CONFIGDIR.get().toString(), CUSTOM_CONFIG_PATH, VERSION_PATH, "README.txt");
        File readme = new File(path.toString());
        if (!readme.exists()) {
            String readmeText =
                    """
                            ######################################
                            #        wishing_wells.json          #
                            ######################################

                            This file contains a BlockSetSelector (see below) describing the probability of a given block being chosen.
                            These probabilities are used for Wishing Wells, which have\s
                            loot deposits at the bottom of them.

                            ######################################
                            #         BlockSetSelectors          #
                            ######################################

                            Describes a set of blockstates and the probability of each blockstate being chosen.
                             - entries: An object where each entry's key is a blockstate, and each value is that blockstate's probability of being chosen.
                                  The total sum of all probabilities SHOULD NOT exceed 1.0!
                             - defaultBlock: The blockstate used for any leftover probability ranges.
                                  For example, if the total sum of all the probabilities of the entries is 0.6, then
                                  there is a 0.4 chance of the defaultBlock being selected.

                            Here's an example block selector:
                            "entries": {
                              "minecraft:cobblestone": 0.25,
                              "minecraft:air": 0.2,
                              "minecraft:stone_bricks": 0.1
                            },
                            "defaultBlock": "minecraft:oak_planks"

                            For each block, this selector has a 25% chance of returning cobblestone, 20% chance of choosing air,
                            10% chance of choosing stone bricks, and a 100 - (25 + 20 + 10) = 45% chance of choosing oak planks (since it's the default block).
                            """;
            try {
                Files.write(path, readmeText.getBytes());
            } catch (IOException e) {
                YungsExtrasCommon.LOGGER.error("Unable to create wishing wells README file!");
            }
        }
    }

    /**
     * If a JSON file already exists, it loads its contents into WishingWellChances.
     * Otherwise, it creates a default JSON and from the default options in WishingWellChances.
     */
    private static void loadWishingWellsJSON() {
        Path jsonPath = Paths.get(FMLPaths.CONFIGDIR.get().toString(), CUSTOM_CONFIG_PATH, VERSION_PATH, "wishing_wells.json");
        File jsonFile = new File(jsonPath.toString());

        if (!jsonFile.exists()) {
            // Create default file if JSON file doesn't already exist
            try {
                JSON.createJsonFileFromObject(jsonPath, WishingWellChances.get());
            } catch (IOException e) {
                YungsExtrasCommon.LOGGER.error("Unable to create wishing_wells.json file: {}", e.toString());
            }
        } else {
            // If file already exists, load data into OreChances singleton instance
            if (!jsonFile.canRead()) {
                YungsExtrasCommon.LOGGER.error("YUNG's Extras wishing_wells.json file not readable! Using default configuration...");
                return;
            }

            try {
                WishingWellChances.instance = JSON.loadObjectFromJsonFile(jsonPath, WishingWellChances.class);
            } catch (IOException e) {
                YungsExtrasCommon.LOGGER.error("Error loading YUNG's Extras wishing_wells.json file: {}", e.toString());
                YungsExtrasCommon.LOGGER.error("Using default configuration...");
            }
        }
    }

    private static void bakeConfig() {
        YungsExtrasCommon.CONFIG.desert.wells.smallNormalWellSpawnRate = YEConfigForge.desertDecorations.wells.smallNormalWellSpawnRate.get();
        YungsExtrasCommon.CONFIG.desert.wells.mediumNormalWellSpawnRate = YEConfigForge.desertDecorations.wells.mediumNormalWellSpawnRate.get();
        YungsExtrasCommon.CONFIG.desert.wells.largeNormalWellSpawnRate = YEConfigForge.desertDecorations.wells.largeNormalWellSpawnRate.get();
        YungsExtrasCommon.CONFIG.desert.wells.smallWishingWellSpawnRate = YEConfigForge.desertDecorations.wells.smallWishingWellSpawnRate.get();
        YungsExtrasCommon.CONFIG.desert.wells.mediumWishingWellSpawnRate = YEConfigForge.desertDecorations.wells.mediumWishingWellSpawnRate.get();
        YungsExtrasCommon.CONFIG.desert.wells.largeWishingWellSpawnRate = YEConfigForge.desertDecorations.wells.largeWishingWellSpawnRate.get();
        YungsExtrasCommon.CONFIG.desert.wells.smallDryWellSpawnRate = YEConfigForge.desertDecorations.wells.smallDryWellSpawnRate.get();
        YungsExtrasCommon.CONFIG.desert.wells.mediumDryWellSpawnRate = YEConfigForge.desertDecorations.wells.mediumDryWellSpawnRate.get();
        YungsExtrasCommon.CONFIG.desert.wells.largeDryWellSpawnRate = YEConfigForge.desertDecorations.wells.largeDryWellSpawnRate.get();
        YungsExtrasCommon.CONFIG.desert.obelisks.normalObeliskSpawnRate = YEConfigForge.desertDecorations.obelisks.normalObeliskSpawnRate.get();
        YungsExtrasCommon.CONFIG.desert.obelisks.creeperObeliskSpawnRate = YEConfigForge.desertDecorations.obelisks.creeperObeliskSpawnRate.get();
        YungsExtrasCommon.CONFIG.desert.obelisks.ruinedObeliskSpawnRate = YEConfigForge.desertDecorations.obelisks.ruinedObeliskSpawnRate.get();
        YungsExtrasCommon.CONFIG.desert.obelisks.blackstoneObeliskSpawnRate = YEConfigForge.desertDecorations.obelisks.blackstoneObeliskSpawnRate.get();
        YungsExtrasCommon.CONFIG.desert.misc.smallRuinsSpawnRate = YEConfigForge.desertDecorations.misc.smallRuinsSpawnRate.get();
        YungsExtrasCommon.CONFIG.desert.misc.giantTorchSpawnRate = YEConfigForge.desertDecorations.misc.giantTorchSpawnRate.get();
        YungsExtrasCommon.CONFIG.desert.misc.chillzoneSpawnRate = YEConfigForge.desertDecorations.misc.chillzoneSpawnRate.get();
        YungsExtrasCommon.CONFIG.swamp.pillarSpawnRate = YEConfigForge.swamp.pillarSpawnRate.get();
        YungsExtrasCommon.CONFIG.swamp.ogreSpawnRate = YEConfigForge.swamp.ogreSpawnRate.get();
        YungsExtrasCommon.CONFIG.swamp.cubbySpawnRate = YEConfigForge.swamp.cubbySpawnRate.get();
        YungsExtrasCommon.CONFIG.swamp.archSpawnRate = YEConfigForge.swamp.archSpawnRate.get();
        YungsExtrasCommon.CONFIG.swamp.doubleArchSpawnRate = YEConfigForge.swamp.doubleArchSpawnRate.get();
        YungsExtrasCommon.CONFIG.swamp.churchSpawnRate = YEConfigForge.swamp.churchSpawnRate.get();
        YungsExtrasCommon.CONFIG.desert.additionalBiomeWhitelist = parseList(YEConfigForge.desertDecorations.additionalBiomeWhitelist.get(), "Additional Biome Whitelist (Desert)");
        YungsExtrasCommon.CONFIG.desert.biomeBlacklist = parseList(YEConfigForge.desertDecorations.biomeBlacklist.get(), "Biome Blacklist (Desert)");
        YungsExtrasCommon.CONFIG.swamp.additionalBiomeWhitelist = parseList(YEConfigForge.swamp.additionalBiomeWhitelist.get(), "Additional Biome Whitelist (Swamp)");
        YungsExtrasCommon.CONFIG.swamp.biomeBlacklist = parseList(YEConfigForge.swamp.biomeBlacklist.get(), "Biome Blacklist (Swamp)");
    }

    private static List<String> parseList(String rawStringOfList, String settingName) {
        int strLen = rawStringOfList.length();

        // Validate the string's format
        if (strLen < 2 || rawStringOfList.charAt(0) != '[' || rawStringOfList.charAt(strLen - 1) != ']') {
            YungsExtrasCommon.LOGGER.error("INVALID VALUE FOR SETTING '" + settingName + "'. Using empty list instead...");
            return new ArrayList<>();
        }

        return Lists.newArrayList(rawStringOfList.substring(1, strLen - 1).split(",\\s*"));
    }
}
