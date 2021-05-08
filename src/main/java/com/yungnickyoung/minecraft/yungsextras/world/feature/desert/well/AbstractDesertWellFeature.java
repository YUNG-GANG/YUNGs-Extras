package com.yungnickyoung.minecraft.yungsextras.world.feature.desert.well;

import com.yungnickyoung.minecraft.yungsextras.YungsExtras;
import com.yungnickyoung.minecraft.yungsextras.world.WishingWellChances;
import com.yungnickyoung.minecraft.yungsextras.world.feature.AbstractTemplateFeature;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;

@ParametersAreNonnullByDefault
public abstract class AbstractDesertWellFeature extends AbstractTemplateFeature<NoFeatureConfig> {
    private static final String path = "desert/wells/";
    private final int radius;
    protected ResourceLocation name;

    public AbstractDesertWellFeature(String name, int size) {
        super(NoFeatureConfig.field_236558_a_);
        this.name = new ResourceLocation(YungsExtras.MOD_ID, path + name);
        this.radius = size;
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

        // Naive check to avoid spawning on a shallow overhang or steep cliff
        for (int i = 1; i <= 7; i++) {
            mutable.setPos(surfacePos).move(Direction.DOWN, i);
            if (world.isAirBlock(mutable)) return false;
            mutable.setPos(surfacePos).move(Direction.DOWN, i).move(Direction.NORTH, radius).move(Direction.EAST, radius);
            if (world.isAirBlock(mutable)) return false;
            mutable.setPos(surfacePos).move(Direction.DOWN, i).move(Direction.EAST, radius).move(Direction.SOUTH, radius);
            if (world.isAirBlock(mutable)) return false;
            mutable.setPos(surfacePos).move(Direction.DOWN, i).move(Direction.SOUTH, radius).move(Direction.WEST, radius);
            if (world.isAirBlock(mutable)) return false;
            mutable.setPos(surfacePos).move(Direction.DOWN, i).move(Direction.WEST, radius).move(Direction.NORTH, radius);
            if (world.isAirBlock(mutable)) return false;
        }

        // Generate the well
        Template template = this.createTemplate(this.name, world, rand, surfacePos.offset(Direction.DOWN, 6));
        return template != null;
    }

    @Override
    protected void processTemplate(Template template, ISeedReader world, Random rand, BlockPos cornerPos, PlacementSettings placementSettings) {
        for (Template.BlockInfo blockInfo : template.func_215381_a(cornerPos, placementSettings, Blocks.YELLOW_STAINED_GLASS)) {
            BlockState blockState = WishingWellChances.get().getRandomLootBlock(rand);
            world.setBlockState(blockInfo.pos, blockState, 2);
        }
    }
}
