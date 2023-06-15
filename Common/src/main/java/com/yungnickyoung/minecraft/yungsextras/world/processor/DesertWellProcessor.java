package com.yungnickyoung.minecraft.yungsextras.world.processor;

import com.yungnickyoung.minecraft.yungsextras.YungsExtrasCommon;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;

import java.util.ArrayList;
import java.util.List;

public class DesertWellProcessor implements INbtFeatureProcessor {
    private static final ResourceLocation EXTRA = new ResourceLocation(YungsExtrasCommon.MOD_ID, "desert/extra_archeology");

    @Override
    public void processTemplate(StructureTemplate template, WorldGenLevel level, RandomSource random, BlockPos cornerPos, BlockPos centerPos, StructurePlaceSettings placementSettings) {
        // Add vanilla suspicious sand
        List<BlockPos> changedPositions = new ArrayList<>();
        int maxSusSand = random.nextInt(3) + 2;
        int susSandPlaced = 0;
        for (StructureTemplate.StructureBlockInfo blockInfo : template.filterBlocks(cornerPos, placementSettings, Blocks.BROWN_STAINED_GLASS)) {
            if (susSandPlaced < maxSusSand && random.nextFloat() < 0.1f) {
                placeSusSand(level, blockInfo.pos(), BuiltInLootTables.DESERT_WELL_ARCHAEOLOGY);
                susSandPlaced++;
            } else {
                level.setBlock(blockInfo.pos(), Blocks.SAND.defaultBlockState(), 2);
                changedPositions.add(blockInfo.pos());
            }
        }

        // Ensure at least 2 vanilla suspicious sand blocks were placed
        if (susSandPlaced < 2) {
            for (BlockPos pos : changedPositions) {
                if (susSandPlaced >= 2) break;
                placeSusSand(level, pos, BuiltInLootTables.DESERT_WELL_ARCHAEOLOGY);
                susSandPlaced++;
            }
        }

        // Add our own suspicious sand with extra loot (no pottery sherds though)
        int extraSusSand = random.nextInt(3) + 2; // 2-4 extra suspicious sand blocks w/ custom loot table (wishing wells only)
        for (StructureTemplate.StructureBlockInfo blockInfo : template.filterBlocks(cornerPos, placementSettings, Blocks.YELLOW_STAINED_GLASS)) {
            if (extraSusSand > 0 && random.nextFloat() < 0.4f) {
                placeSusSand(level, blockInfo.pos(), EXTRA);
                extraSusSand--;
            } else {
                level.setBlock(blockInfo.pos(), Blocks.SAND.defaultBlockState(), 2);
            }
        }
    }

    private void placeSusSand(WorldGenLevel level, BlockPos pos, ResourceLocation lootTable) {
        level.setBlock(pos, Blocks.SUSPICIOUS_SAND.defaultBlockState(), 3);
        level.getBlockEntity(pos, BlockEntityType.BRUSHABLE_BLOCK).ifPresent((blockEntity) -> {
            blockEntity.setLootTable(lootTable, pos.asLong());
        });
    }
}
