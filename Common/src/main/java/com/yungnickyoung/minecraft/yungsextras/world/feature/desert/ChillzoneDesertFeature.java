package com.yungnickyoung.minecraft.yungsextras.world.feature.desert;

import com.yungnickyoung.minecraft.yungsextras.YungsExtrasCommon;
import com.yungnickyoung.minecraft.yungsextras.world.feature.AbstractNbtFeature;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class ChillzoneDesertFeature extends AbstractNbtFeature<NoneFeatureConfiguration> {
    private static final ResourceLocation location = new ResourceLocation(YungsExtrasCommon.MOD_ID, "desert/misc/chillzone");

    public ChillzoneDesertFeature() {
        super(NoneFeatureConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        RandomSource rand = context.random();
        BlockPos pos = context.origin();

        // Find the surface
        BlockPos.MutableBlockPos mutable = pos.mutable();
        while (level.isEmptyBlock(mutable) && mutable.getY() > 2) {
            mutable.move(Direction.DOWN);
        }

        BlockPos surfacePos = mutable.immutable();
        BlockPos cornerPos = surfacePos.offset(-1, 0, -2);
        Block block = level.getBlockState(surfacePos).getBlock();

        // Ensure valid position
        if (!block.defaultBlockState().is(BlockTags.SAND)) return false;

        // Check to avoid bits of the feature floating
        mutable.set(cornerPos).move(Direction.SOUTH, 2);
        if (!level.getBlockState(mutable).isSolid()) return false;

        mutable.set(cornerPos).move(Direction.SOUTH, 3).move(Direction.EAST, 2);
        if (!level.getBlockState(mutable).isSolid()) return false;

        mutable.set(cornerPos).move(Direction.SOUTH, 1).move(Direction.EAST, 1);
        if (!level.getBlockState(mutable).isSolid()) return false;

        mutable.set(cornerPos).move(Direction.SOUTH, 2).move(Direction.EAST, 2);
        if (!level.getBlockState(mutable).isSolid()) return false;

        // Generate the feature
        StructureTemplate template = this.createTemplateFromCenter(location, level, rand, surfacePos.above());
        return template != null;
    }
}
