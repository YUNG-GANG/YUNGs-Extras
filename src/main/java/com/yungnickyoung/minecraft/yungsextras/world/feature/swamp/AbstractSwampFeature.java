package com.yungnickyoung.minecraft.yungsextras.world.feature.swamp;

import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;
import com.yungnickyoung.minecraft.yungsapi.world.BlockSetSelector;
import com.yungnickyoung.minecraft.yungsextras.world.feature.AbstractTemplateFeature;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.material.Material;

import java.util.List;
import java.util.Random;
import java.util.Set;

public abstract class AbstractSwampFeature<C extends FeatureConfiguration> extends AbstractTemplateFeature<C> {
    public AbstractSwampFeature(Codec<C> codec) {
        super(codec);
    }

    @Override
    protected void processTemplate(StructureTemplate template, WorldGenLevel world, Random rand, BlockPos cornerPos, BlockPos centerPos, StructurePlaceSettings placementSettings) {
        // Fill below the pillar
        for (StructureTemplate.StructureBlockInfo blockInfo : template.filterBlocks(cornerPos, placementSettings, Blocks.GRAY_STAINED_GLASS)) {
            world.setBlock(blockInfo.pos, STONE_BRICK_SELECTOR.get(rand), 2);
            // Replace any air or water under this position with stone brick until we hit a solid block
            BlockPos.MutableBlockPos mutable = blockInfo.pos.mutable().move(Direction.DOWN);
            while (INVALID_MATERIALS.contains(world.getBlockState(mutable).getMaterial())) {
                world.setBlock(mutable, STONE_BRICK_SELECTOR.get(rand), 2);
                mutable.move(Direction.DOWN);
            }
        }

        // Randomize stairs in the pillar, for a ruined effect
        for (StructureTemplate.StructureBlockInfo blockInfo : template.filterBlocks(cornerPos, placementSettings, Blocks.LIGHT_GRAY_STAINED_GLASS)) {
            world.setBlock(blockInfo.pos, STONE_BRICK_STAIRS_SELECTOR.get(rand).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.Plane.HORIZONTAL.getRandomDirection(rand)), 2);
        }

        // Randomize stone bricks throughout the pillar
        for (StructureTemplate.StructureBlockInfo blockInfo : template.filterBlocks(cornerPos, placementSettings, Blocks.STONE_BRICKS)) {
            world.setBlock(blockInfo.pos, STONE_BRICK_SELECTOR.get(rand), 2);
        }

        // Randomize stone brick stairs throughout the pillar
        for (StructureTemplate.StructureBlockInfo blockInfo : template.filterBlocks(cornerPos, placementSettings, Blocks.STONE_BRICK_STAIRS)) {
            world.setBlock(blockInfo.pos, STONE_BRICK_STAIRS_SELECTOR.get(rand)
                            .setValue(StairBlock.FACING, blockInfo.state.getValue(StairBlock.FACING))
                            .setValue(StairBlock.HALF, blockInfo.state.getValue(StairBlock.HALF))
                            .setValue(StairBlock.SHAPE, blockInfo.state.getValue(StairBlock.SHAPE))
                            .setValue(StairBlock.WATERLOGGED, blockInfo.state.getValue(StairBlock.WATERLOGGED)),
                    2);
        }

        // Candles
        for (StructureTemplate.StructureBlockInfo blockInfo : template.filterBlocks(cornerPos, placementSettings, Blocks.GREEN_CANDLE)) {
            int numCandles = rand.nextInt(4) + 1;
            boolean lit = rand.nextFloat() < .1f;
            world.setBlock(blockInfo.pos, getRandomCandle(rand).defaultBlockState()
                            .setValue(CandleBlock.CANDLES, numCandles)
                            .setValue(CandleBlock.LIT, lit),
                    2);

        }
    }

    private static final Set<Material> INVALID_MATERIALS = Sets.newHashSet(
            Material.AIR, Material.WATER, Material.LAVA, Material.WATER_PLANT, Material.PLANT, Material.REPLACEABLE_WATER_PLANT, Material.REPLACEABLE_PLANT
    );

    private static final BlockSetSelector STONE_BRICK_SELECTOR = new BlockSetSelector(Blocks.STONE_BRICKS.defaultBlockState())
            .addBlock(Blocks.MOSSY_STONE_BRICKS.defaultBlockState(), 0.45f)
            .addBlock(Blocks.CRACKED_STONE_BRICKS.defaultBlockState(), 0.45f);

    private static final BlockSetSelector STONE_BRICK_STAIRS_SELECTOR = new BlockSetSelector(Blocks.STONE_BRICK_STAIRS.defaultBlockState())
            .addBlock(Blocks.MOSSY_STONE_BRICK_STAIRS.defaultBlockState(), 0.6f);

    private static final List<Block> CANDLES = List.of(Blocks.CANDLE, Blocks.WHITE_CANDLE, Blocks.GRAY_CANDLE,
            Blocks.LIGHT_GRAY_CANDLE, Blocks.BROWN_CANDLE, Blocks.GREEN_CANDLE, Blocks.PURPLE_CANDLE, Blocks.BLACK_CANDLE);

    private static Block getRandomCandle(Random random) {
        int i = random.nextInt(CANDLES.size());
        return CANDLES.get(i);
    }
}