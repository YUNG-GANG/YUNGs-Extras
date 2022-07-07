package com.yungnickyoung.minecraft.yungsextras.world.feature.desert;

import com.google.common.collect.Lists;
import com.yungnickyoung.minecraft.yungsextras.module.FeatureProcessorModule;
import com.yungnickyoung.minecraft.yungsextras.world.config.DesertWellFeatureConfiguration;
import com.yungnickyoung.minecraft.yungsextras.world.feature.AbstractNbtFeature;
import com.yungnickyoung.minecraft.yungsextras.world.processor.INbtFeatureProcessor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@ParametersAreNonnullByDefault
public class DesertWellFeature extends AbstractNbtFeature<DesertWellFeatureConfiguration> {
    public DesertWellFeature() {
        super(DesertWellFeatureConfiguration.CODEC);
    }

    /**
     * We override this method to supply the processors specific to this template feature.
     */
    @Override
    protected List<INbtFeatureProcessor> useProcessors() {
        return Lists.newArrayList(
                FeatureProcessorModule.DESERT_WELL_PROCESSOR
        );
    }

    @Override
    public boolean place(FeaturePlaceContext<DesertWellFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        RandomSource randomSource = context.random();
        BlockPos pos = context.origin();
        int radius = context.config().getRadius();
        ResourceLocation location = context.config().getLocation();

        // Find the surface
        BlockPos.MutableBlockPos mutable = pos.mutable();
        while (level.isEmptyBlock(mutable) && mutable.getY() > 7) {
            mutable.move(Direction.DOWN);
        }

        BlockPos surfacePos = mutable.immutable();
        Block block = level.getBlockState(surfacePos).getBlock();

        // Ensure valid position
        if (!block.defaultBlockState().is(BlockTags.SAND)) return false;

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
        StructureTemplate template = this.createTemplateFromCenter(location, level, randomSource, surfacePos.relative(Direction.DOWN, 6));
        return template != null;
    }
}
