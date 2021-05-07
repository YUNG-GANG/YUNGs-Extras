package com.yungnickyoung.minecraft.yungsextras.world.feature.desert_well;

import com.mojang.serialization.Codec;
import com.yungnickyoung.minecraft.yungsextras.YungsExtras;
import com.yungnickyoung.minecraft.yungsextras.world.feature.AbstractTemplateFeature;
import net.minecraft.block.Block;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.template.Template;

import java.util.Random;

public abstract class AbstractDesertWellFeature extends AbstractTemplateFeature<NoFeatureConfig> {
    private static final String path = "desert/wells/";
    protected ResourceLocation name;

    public AbstractDesertWellFeature(String name) {
        super(NoFeatureConfig.field_236558_a_);
        this.name = new ResourceLocation(YungsExtras.MOD_ID, path + name);
    }

    @Override
    public boolean generate(ISeedReader world, ChunkGenerator chunkGenerator, Random rand, BlockPos pos, NoFeatureConfig config) {
        // Find the surface
        BlockPos.Mutable mutable = pos.toMutable();
        while (world.isAirBlock(mutable) && mutable.getY() > 7) {
            mutable.move(Direction.DOWN);
        }

        BlockPos surfacePos = mutable.toImmutable();
        Block block = world.getBlockState(surfacePos).getBlock();

        // Ensure valid position
        if (!BlockTags.SAND.contains(block)) return false;

        // Naive check to avoid spawning on a shallow overhang
        for (int i = 1; i <= 7; i++) {
            mutable.setPos(surfacePos).move(Direction.DOWN, i);
            if (world.isAirBlock(mutable)) return false;
        }

        // Generate the well
        Template template = this.createTemplate(this.name, world, rand, surfacePos.offset(Direction.DOWN, 6));
        return template != null;
    }
}
