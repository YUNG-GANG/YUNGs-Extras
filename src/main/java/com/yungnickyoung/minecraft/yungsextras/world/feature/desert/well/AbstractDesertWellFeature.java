package com.yungnickyoung.minecraft.yungsextras.world.feature.desert.well;

import com.yungnickyoung.minecraft.yungsextras.YungsExtras;
import com.yungnickyoung.minecraft.yungsextras.world.WishingWellChances;
import com.yungnickyoung.minecraft.yungsextras.world.feature.AbstractTemplateFeature;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;

@ParametersAreNonnullByDefault
public abstract class AbstractDesertWellFeature extends AbstractTemplateFeature<NoneFeatureConfiguration> {
    private static final String path = "desert/wells/";
    private final int radius;
    protected ResourceLocation name;

    public AbstractDesertWellFeature(String name, int size) {
        super(NoneFeatureConfiguration.CODEC);
        this.name = new ResourceLocation(YungsExtras.MOD_ID, path + name);
        this.radius = size;
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        Random rand = context.random();
        BlockPos pos = context.origin();

        // Find the surface
        BlockPos.MutableBlockPos mutable = pos.mutable();
        while (level.isEmptyBlock(mutable) && mutable.getY() > 7) {
            mutable.move(Direction.DOWN);
        }

        BlockPos surfacePos = mutable.immutable();
        Block block = level.getBlockState(surfacePos).getBlock();

        // Ensure valid position
        if (!BlockTags.SAND.contains(block)) return false;

        // Naive check to avoid spawning on a shallow overhang or steep cliff
        for (int i = 1; i <= 7; i++) {
            mutable.set(surfacePos).move(Direction.DOWN, i);
            if (level.isEmptyBlock(mutable)) return false;
            mutable.set(surfacePos).move(Direction.DOWN, i).move(Direction.NORTH, radius).move(Direction.EAST, radius);
            if (level.isEmptyBlock(mutable)) return false;
            mutable.set(surfacePos).move(Direction.DOWN, i).move(Direction.EAST, radius).move(Direction.SOUTH, radius);
            if (level.isEmptyBlock(mutable)) return false;
            mutable.set(surfacePos).move(Direction.DOWN, i).move(Direction.SOUTH, radius).move(Direction.WEST, radius);
            if (level.isEmptyBlock(mutable)) return false;
            mutable.set(surfacePos).move(Direction.DOWN, i).move(Direction.WEST, radius).move(Direction.NORTH, radius);
            if (level.isEmptyBlock(mutable)) return false;
        }

        // Generate the well
        StructureTemplate template = this.createTemplate(this.name, level, rand, surfacePos.relative(Direction.DOWN, 6));
        return template != null;
    }

    @Override
    protected void processTemplate(StructureTemplate template, WorldGenLevel world, Random rand, BlockPos cornerPos, BlockPos centerPos, StructurePlaceSettings placementSettings) {
        for (StructureTemplate.StructureBlockInfo blockInfo : template.filterBlocks(cornerPos, placementSettings, Blocks.YELLOW_STAINED_GLASS)) {
            BlockState blockState = WishingWellChances.get().getRandomLootBlock(rand);
            world.setBlock(blockInfo.pos, blockState, 2);
        }
    }
}
