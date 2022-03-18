package com.yungnickyoung.minecraft.yungsextras.world.processor;

import com.yungnickyoung.minecraft.yungsextras.world.WishingWellChances;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import java.util.Random;

/**
 * Processor for Desert Wells.
 */
public class DesertWellProcessor implements INbtFeatureProcessor {
    @Override
    public void processTemplate(StructureTemplate template, WorldGenLevel level, Random rand, BlockPos cornerPos, BlockPos centerPos, StructurePlaceSettings placementSettings) {
        // Replaces yellow stained glass w/ wishing well loot
        for (StructureTemplate.StructureBlockInfo blockInfo : template.filterBlocks(cornerPos, placementSettings, Blocks.YELLOW_STAINED_GLASS)) {
            BlockState blockState = WishingWellChances.get().getRandomLootBlock(rand);
            level.setBlock(blockInfo.pos, blockState, 2);
        }
    }
}
