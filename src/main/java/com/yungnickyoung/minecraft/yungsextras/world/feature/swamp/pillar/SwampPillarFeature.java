package com.yungnickyoung.minecraft.yungsextras.world.feature.swamp.pillar;

import com.google.common.collect.Sets;
import com.yungnickyoung.minecraft.yungsapi.world.BlockSetSelector;
import com.yungnickyoung.minecraft.yungsextras.YungsExtras;
import com.yungnickyoung.minecraft.yungsextras.world.config.StructurePathConfig;
import com.yungnickyoung.minecraft.yungsextras.world.feature.AbstractTemplateFeature;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.material.Material;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;
import java.util.Set;

@ParametersAreNonnullByDefault
public class SwampPillarFeature extends AbstractTemplateFeature<StructurePathConfig> {
    public SwampPillarFeature() {
        super(StructurePathConfig.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<StructurePathConfig> context) {
        WorldGenLevel level = context.level();
        Random rand = context.random();
        BlockPos pos = context.origin();

        // Find the surface
        BlockPos.MutableBlockPos mutable = pos.mutable();
        while (level.isEmptyBlock(mutable) && mutable.getY() > 2) {
            mutable.move(Direction.DOWN);
        }

        BlockPos surfacePos = mutable.immutable();
        BlockPos cornerPos = surfacePos.offset(-2, 0, -2);

        // Obelisk can only extend max 3 down
        mutable.set(cornerPos).move(Direction.DOWN, 4);
        if (level.isEmptyBlock(mutable)) return false;

        mutable.set(cornerPos).move(Direction.SOUTH, 3).move(Direction.DOWN, 4);
        if (level.isEmptyBlock(mutable)) return false;

        mutable.set(cornerPos).move(Direction.EAST, 3).move(Direction.DOWN, 4);
        if (level.isEmptyBlock(mutable)) return false;

        mutable.set(cornerPos).move(Direction.SOUTH, 3).move(Direction.EAST, 3).move(Direction.DOWN, 4);
        if (level.isEmptyBlock(mutable)) return false;

        // Generate the obelisk
        ResourceLocation templateResource = new ResourceLocation(YungsExtras.MOD_ID, context.config().path);
        StructureTemplate template = this.createTemplate(templateResource, level, rand, surfacePos);
        return template != null;
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
    }

    private static final Set<Material> INVALID_MATERIALS = Sets.newHashSet(
            Material.AIR, Material.WATER, Material.LAVA, Material.WATER_PLANT, Material.PLANT, Material.REPLACEABLE_WATER_PLANT, Material.REPLACEABLE_PLANT
    );

    private static final BlockSetSelector STONE_BRICK_SELECTOR = new BlockSetSelector(Blocks.STONE_BRICKS.defaultBlockState())
            .addBlock(Blocks.MOSSY_STONE_BRICKS.defaultBlockState(), 0.45f)
            .addBlock(Blocks.CRACKED_STONE_BRICKS.defaultBlockState(), 0.45f);

    private static final BlockSetSelector STONE_BRICK_STAIRS_SELECTOR = new BlockSetSelector(Blocks.STONE_BRICK_STAIRS.defaultBlockState())
            .addBlock(Blocks.MOSSY_STONE_BRICK_STAIRS.defaultBlockState(), 0.6f);
}
