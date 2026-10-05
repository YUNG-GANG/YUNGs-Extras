package com.yungnickyoung.minecraft.yungsextras.world.feature.desert;

import com.mojang.serialization.MapCodec;

import com.yungnickyoung.minecraft.yungsextras.world.config.IdentifierFeatureConfiguration;
import com.yungnickyoung.minecraft.yungsextras.world.feature.AbstractNbtFeature;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;




public class DesertObeliskFeature extends AbstractNbtFeature {
    public static final MapCodec<DesertObeliskFeature> CODEC = IdentifierFeatureConfiguration.CODEC.xmap(DesertObeliskFeature::new, feature -> feature.config);
    private final IdentifierFeatureConfiguration config;

    public DesertObeliskFeature(IdentifierFeatureConfiguration config) {
        this.config = config;
    }

    @Override
    public boolean place(WorldGenLevel level, ChunkGenerator chunkGenerator, RandomSource randomSource, BlockPos pos) {
        Identifier location = config.getLocation();

        // Find the surface
        BlockPos.MutableBlockPos mutable = pos.mutable();
        while (level.isEmptyBlock(mutable) && mutable.getY() > 2) {
            mutable.move(Direction.DOWN);
        }

        BlockPos surfacePos = mutable.immutable();
        BlockPos cornerPos = surfacePos.offset(-2, 0, -2);
        Block block = level.getBlockState(surfacePos).getBlock();

        // Ensure valid position
        if (!block.defaultBlockState().is(BlockTags.SAND)) return false;

        // Check to avoid bits of the obelisk floating
        mutable.set(cornerPos);
        if (!level.getBlockState(mutable).isSolid()) return false;

        mutable.set(cornerPos).move(Direction.SOUTH, 3);
        if (!level.getBlockState(mutable).isSolid()) return false;

        mutable.set(cornerPos).move(Direction.EAST, 3);
        if (!level.getBlockState(mutable).isSolid()) return false;

        mutable.set(cornerPos).move(Direction.SOUTH, 3).move(Direction.EAST, 3);
        if (!level.getBlockState(mutable).isSolid()) return false;

        // Generate the obelisk
        StructureTemplate template = this.createTemplateFromCenter(location, level, randomSource, surfacePos.above());
        return template != null;
    }

    @Override
    public MapCodec<DesertObeliskFeature> codec() {
        return CODEC;
    }
}
