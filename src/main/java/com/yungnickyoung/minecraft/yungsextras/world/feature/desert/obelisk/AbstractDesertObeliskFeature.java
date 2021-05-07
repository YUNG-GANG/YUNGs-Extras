package com.yungnickyoung.minecraft.yungsextras.world.feature.desert.obelisk;

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
public abstract class AbstractDesertObeliskFeature extends AbstractTemplateFeature<NoFeatureConfig> {
    private static final String path = "desert/obelisk/";
    protected ResourceLocation name;

    public AbstractDesertObeliskFeature(String name) {
        super(NoFeatureConfig.field_236558_a_);
        this.name = new ResourceLocation(YungsExtras.MOD_ID, path + name);
    }

    @Override
    public boolean generate(ISeedReader world, ChunkGenerator chunkGenerator, Random rand, BlockPos pos, NoFeatureConfig config) {
        // Find the surface
        BlockPos.Mutable mutable = pos.toMutable();
        while (world.isAirBlock(mutable) && mutable.getY() > 2) {
            mutable.move(Direction.DOWN);
        }

        BlockPos surfacePos = mutable.toImmutable();
        BlockPos cornerPos = surfacePos.add(-2, 0, -2);
        Block block = world.getBlockState(surfacePos).getBlock();

        // Ensure valid position
        if (!BlockTags.SAND.contains(block)) return false;

        // Check to avoid bits of the obelisk floating
        mutable.setPos(cornerPos);
        if (world.isAirBlock(mutable)) return false;

        mutable.setPos(cornerPos).move(Direction.SOUTH, 3);
        if (world.isAirBlock(mutable)) return false;

        mutable.setPos(cornerPos).move(Direction.EAST, 3);
        if (world.isAirBlock(mutable)) return false;

        mutable.setPos(cornerPos).move(Direction.SOUTH, 3).move(Direction.EAST, 3);
        if (world.isAirBlock(mutable)) return false;

        // Generate the obelisk
        Template template = this.createTemplate(this.name, world, rand, surfacePos.offset(Direction.UP));
        return template != null;
    }
}
