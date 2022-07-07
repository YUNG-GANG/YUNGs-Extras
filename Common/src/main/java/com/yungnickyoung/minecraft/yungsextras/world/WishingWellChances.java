package com.yungnickyoung.minecraft.yungsextras.world;

import com.yungnickyoung.minecraft.yungsapi.world.BlockStateRandomizer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

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
        lootBlockChances = new BlockStateRandomizer(Blocks.SANDSTONE.defaultBlockState())
            .addBlock(Blocks.GOLD_ORE.defaultBlockState(), .5f)
            .addBlock(Blocks.EMERALD_ORE.defaultBlockState(), .05f)
            .addBlock(Blocks.GOLD_BLOCK.defaultBlockState(), .01f);
    }

    /** Instance variables and methods **/

    private BlockStateRandomizer lootBlockChances;

    public BlockState getRandomLootBlock(RandomSource randomSource) {
        return lootBlockChances.get(randomSource);
    }
}
