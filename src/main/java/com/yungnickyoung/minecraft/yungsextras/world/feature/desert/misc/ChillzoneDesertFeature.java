package com.yungnickyoung.minecraft.yungsextras.world.feature.desert.misc;

import com.yungnickyoung.minecraft.yungsextras.YungsExtras;
import com.yungnickyoung.minecraft.yungsextras.world.feature.AbstractTemplateFeature;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.template.Template;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;

@ParametersAreNonnullByDefault
public class ChillzoneDesertFeature extends AbstractTemplateFeature<NoFeatureConfig> {
    private static final ResourceLocation path = new ResourceLocation(YungsExtras.MOD_ID, "desert/misc/chillzone");

    public ChillzoneDesertFeature() {
        super(NoFeatureConfig.field_236558_a_);
    }

    @Override
    public boolean generate(ISeedReader world, ChunkGenerator chunkGenerator, Random rand, BlockPos pos, NoFeatureConfig config) {
        // Find the surface
        BlockPos.Mutable mutable = pos.toMutable();
        while (world.isAirBlock(mutable) && mutable.getY() > 2) {
            mutable.move(Direction.DOWN);
        }

        BlockPos surfacePos = mutable.toImmutable();
        BlockPos cornerPos = surfacePos.add(-1, 0, -2);
        Block block = world.getBlockState(surfacePos).getBlock();

        // Ensure valid position
        if (!BlockTags.SAND.contains(block)) return false;

        // Check to avoid bits of the feature floating
        mutable.setPos(cornerPos).move(Direction.SOUTH, 2);
        if (world.isAirBlock(mutable)) return false;

        mutable.setPos(cornerPos).move(Direction.SOUTH, 3).move(Direction.EAST, 2);
        if (world.isAirBlock(mutable)) return false;

        mutable.setPos(cornerPos).move(Direction.SOUTH, 1).move(Direction.EAST, 1);
        if (world.isAirBlock(mutable)) return false;

        mutable.setPos(cornerPos).move(Direction.SOUTH, 2).move(Direction.EAST, 2);
        if (world.isAirBlock(mutable)) return false;

        // Generate the feature
        Template template = this.createTemplate(path, world, rand, surfacePos.offset(Direction.UP));
        return template != null;
    }
}
