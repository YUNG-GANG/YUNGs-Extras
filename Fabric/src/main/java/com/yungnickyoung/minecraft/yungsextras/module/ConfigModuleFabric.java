package com.yungnickyoung.minecraft.yungsextras.module;

import com.google.common.collect.Lists;
import com.yungnickyoung.minecraft.yungsapi.io.JSON;
import com.yungnickyoung.minecraft.yungsextras.YungsExtrasCommon;
import com.yungnickyoung.minecraft.yungsextras.config.YEConfigFabric;
import com.yungnickyoung.minecraft.yungsextras.world.WishingWellChances;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.InteractionResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ConfigModuleFabric {
    public static final String CUSTOM_CONFIG_PATH = "YungsExtras";
    public static final String VERSION_PATH = "fabric-1_18";

    public static void init() {
        initCustomFiles();
        AutoConfig.register(YEConfigFabric.class, Toml4jConfigSerializer::new);
        AutoConfig.getConfigHolder(YEConfigFabric.class).registerSaveListener(ConfigModuleFabric::bakeConfig);
        AutoConfig.getConfigHolder(YEConfigFabric.class).registerLoadListener(ConfigModuleFabric::bakeConfig);
    }

    private static InteractionResult bakeConfig(ConfigHolder<YEConfigFabric> configHolder, YEConfigFabric configFabric) {
        bakeConfig(configFabric);
        return InteractionResult.SUCCESS;
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
        File parentDir = new File(FabricLoader.getInstance().getConfigDir().toString(), CUSTOM_CONFIG_PATH);
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
        Path path = Paths.get(FabricLoader.getInstance().getConfigDir().toString(), CUSTOM_CONFIG_PATH, "README.txt");
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
        Path path = Paths.get(FabricLoader.getInstance().getConfigDir().toString(), CUSTOM_CONFIG_PATH, VERSION_PATH, "README.txt");
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
        Path jsonPath = Paths.get(FabricLoader.getInstance().getConfigDir().toString(), CUSTOM_CONFIG_PATH, VERSION_PATH, "wishing_wells.json");
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

    private static void bakeConfig(YEConfigFabric configFabric) {
        YungsExtrasCommon.CONFIG.desert.wells.smallNormalWellSpawnRate = configFabric.desertDecorations.wells.smallNormalWellSpawnRate;
        YungsExtrasCommon.CONFIG.desert.wells.mediumNormalWellSpawnRate = configFabric.desertDecorations.wells.mediumNormalWellSpawnRate;
        YungsExtrasCommon.CONFIG.desert.wells.largeNormalWellSpawnRate = configFabric.desertDecorations.wells.largeNormalWellSpawnRate;
        YungsExtrasCommon.CONFIG.desert.wells.smallWishingWellSpawnRate = configFabric.desertDecorations.wells.smallWishingWellSpawnRate;
        YungsExtrasCommon.CONFIG.desert.wells.mediumWishingWellSpawnRate = configFabric.desertDecorations.wells.mediumWishingWellSpawnRate;
        YungsExtrasCommon.CONFIG.desert.wells.largeWishingWellSpawnRate = configFabric.desertDecorations.wells.largeWishingWellSpawnRate;
        YungsExtrasCommon.CONFIG.desert.wells.smallDryWellSpawnRate = configFabric.desertDecorations.wells.smallDryWellSpawnRate;
        YungsExtrasCommon.CONFIG.desert.wells.mediumDryWellSpawnRate = configFabric.desertDecorations.wells.mediumDryWellSpawnRate;
        YungsExtrasCommon.CONFIG.desert.wells.largeDryWellSpawnRate = configFabric.desertDecorations.wells.largeDryWellSpawnRate;
        YungsExtrasCommon.CONFIG.desert.obelisks.normalObeliskSpawnRate = configFabric.desertDecorations.obelisks.normalObeliskSpawnRate;
        YungsExtrasCommon.CONFIG.desert.obelisks.creeperObeliskSpawnRate = configFabric.desertDecorations.obelisks.creeperObeliskSpawnRate;
        YungsExtrasCommon.CONFIG.desert.obelisks.ruinedObeliskSpawnRate = configFabric.desertDecorations.obelisks.ruinedObeliskSpawnRate;
        YungsExtrasCommon.CONFIG.desert.obelisks.blackstoneObeliskSpawnRate = configFabric.desertDecorations.obelisks.blackstoneObeliskSpawnRate;
        YungsExtrasCommon.CONFIG.desert.misc.smallRuinsSpawnRate = configFabric.desertDecorations.misc.smallRuinsSpawnRate;
        YungsExtrasCommon.CONFIG.desert.misc.giantTorchSpawnRate = configFabric.desertDecorations.misc.giantTorchSpawnRate;
        YungsExtrasCommon.CONFIG.desert.misc.chillzoneSpawnRate = configFabric.desertDecorations.misc.chillzoneSpawnRate;
        YungsExtrasCommon.CONFIG.swamp.pillarSpawnRate = configFabric.swampStructures.pillarSpawnRate;
        YungsExtrasCommon.CONFIG.swamp.ogreSpawnRate = configFabric.swampStructures.ogreSpawnRate;
        YungsExtrasCommon.CONFIG.swamp.cubbySpawnRate = configFabric.swampStructures.cubbySpawnRate;
        YungsExtrasCommon.CONFIG.swamp.archSpawnRate = configFabric.swampStructures.archSpawnRate;
        YungsExtrasCommon.CONFIG.swamp.doubleArchSpawnRate = configFabric.swampStructures.doubleArchSpawnRate;
        YungsExtrasCommon.CONFIG.swamp.churchSpawnRate = configFabric.swampStructures.churchSpawnRate;
        YungsExtrasCommon.CONFIG.desert.additionalBiomeWhitelist = parseList(configFabric.desertDecorations.additionalBiomeWhitelist, "Additional Biome Whitelist (Desert)");
        YungsExtrasCommon.CONFIG.desert.biomeBlacklist = parseList(configFabric.desertDecorations.biomeBlacklist, "Biome Blacklist (Desert)");
        YungsExtrasCommon.CONFIG.swamp.additionalBiomeWhitelist = parseList(configFabric.swampStructures.additionalBiomeWhitelist, "Additional Biome Whitelist (Swamp)");
        YungsExtrasCommon.CONFIG.swamp.biomeBlacklist = parseList(configFabric.swampStructures.biomeBlacklist, "Biome Blacklist (Swamp)");
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
