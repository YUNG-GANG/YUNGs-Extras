package com.yungnickyoung.minecraft.yungsextras.init;

import com.yungnickyoung.minecraft.yungsapi.io.JSON;
import com.yungnickyoung.minecraft.yungsextras.YungsExtras;
import com.yungnickyoung.minecraft.yungsextras.config.YEConfig;
import com.yungnickyoung.minecraft.yungsextras.config.YESettings;
import com.yungnickyoung.minecraft.yungsextras.world.WishingWellChances;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class YEModConfig {
    public static void init() {
        initCustomFiles();
        // Register mod config with AutoConfig
        AutoConfig.register(YEConfig.class, Toml4jConfigSerializer::new);
        YungsExtras.CONFIG = AutoConfig.getConfigHolder(YEConfig.class).getConfig();
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
        File parentDir = new File(FabricLoader.getInstance().getConfigDir().toString(), YESettings.CUSTOM_CONFIG_PATH);
        File customConfigDir = new File(parentDir, YESettings.VERSION_PATH);
        try {
            String filePath = customConfigDir.getCanonicalPath();
            if (customConfigDir.mkdirs()) {
                YungsExtras.LOGGER.info("Creating directory for additional YUNG's Extras configuration at {}", filePath);
            }
        } catch (IOException e) {
            YungsExtras.LOGGER.error("ERROR creating YUNG's Extras config directory: {}", e.toString());
        }
    }

    private static void createBaseReadMe() {
        Path path = Paths.get(FabricLoader.getInstance().getConfigDir().toString(), YESettings.CUSTOM_CONFIG_PATH, "README.txt");
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
                YungsExtras.LOGGER.error("Unable to create README file!");
            }
        }
    }

    private static void createJsonReadMe() {
        Path path = Paths.get(FabricLoader.getInstance().getConfigDir().toString(), YESettings.CUSTOM_CONFIG_PATH, YESettings.VERSION_PATH, "README.txt");
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
                YungsExtras.LOGGER.error("Unable to create wishing wells README file!");
            }
        }
    }

    /**
     * If a JSON file already exists, it loads its contents into WishingWellChances.
     * Otherwise, it creates a default JSON and from the default options in WishingWellChances.
     */
    private static void loadWishingWellsJSON() {
        Path jsonPath = Paths.get(FabricLoader.getInstance().getConfigDir().toString(), YESettings.CUSTOM_CONFIG_PATH, YESettings.VERSION_PATH, "wishing_wells.json");
        File jsonFile = new File(jsonPath.toString());

        if (!jsonFile.exists()) {
            // Create default file if JSON file doesn't already exist
            try {
                JSON.createJsonFileFromObject(jsonPath, WishingWellChances.get());
            } catch (IOException e) {
                YungsExtras.LOGGER.error("Unable to create wishing_wells.json file: {}", e.toString());
            }
        } else {
            // If file already exists, load data into OreChances singleton instance
            if (!jsonFile.canRead()) {
                YungsExtras.LOGGER.error("YUNG's Extras wishing_wells.json file not readable! Using default configuration...");
                return;
            }

            try {
                WishingWellChances.instance = JSON.loadObjectFromJsonFile(jsonPath, WishingWellChances.class);
            } catch (IOException e) {
                YungsExtras.LOGGER.error("Error loading YUNG's Extras wishing_wells.json file: {}", e.toString());
                YungsExtras.LOGGER.error("Using default configuration...");
            }
        }
    }
}
