package com.yungnickyoung.minecraft.yungsextras.world;

import com.yungnickyoung.minecraft.yungsapi.world.BlockSetSelector;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

import java.util.Random;

/**
 * Singleton class holding map of blocks to probabilities.
 * The class is a singleton so that it may be synchronized with the JSON file as a single source of truth.
 * If no JSON exists, this class will be populated with the default values shown below
 * (and a JSON with the default values created)
 */
public class WishingWellChances {
    /** Singleton stuff **/

    public static WishingWellChances instance; // This technically shouldn't be public, but it is necessary for loading data from JSON
    public static WishingWellChances get() {
        if (instance == null) {
            instance = new WishingWellChances();
        }
        return instance;
    }

    private WishingWellChances() {
        lootBlockChances = new BlockSetSelector(Blocks.SANDSTONE.getDefaultState())
            .addBlock(Blocks.GOLD_ORE.getDefaultState(), .5f)
            .addBlock(Blocks.EMERALD_ORE.getDefaultState(), .05f)
            .addBlock(Blocks.GOLD_BLOCK.getDefaultState(), .01f);
    }

    /** Instance variables and methods **/

    private BlockSetSelector lootBlockChances;

    public BlockState getRandomLootBlock(Random random) {
        return lootBlockChances.get(random);
    }
}
