package com.yungnickyoung.minecraft.yungsextras.world.feature.desert;

import com.mojang.serialization.MapCodec;

import com.yungnickyoung.minecraft.yungsextras.YungsExtrasCommon;
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




public class DesertGiantTorchFeature extends AbstractNbtFeature {
    private static final Identifier ID = Identifier.fromNamespaceAndPath(YungsExtrasCommon.MOD_ID, "desert/misc/giant_torch");

    public static final MapCodec<DesertGiantTorchFeature> CODEC = MapCodec.unit(DesertGiantTorchFeature::new);

    public DesertGiantTorchFeature() {
    }

    @Override
    public boolean place(WorldGenLevel level, ChunkGenerator chunkGenerator, RandomSource randomSource, BlockPos pos) {

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

        // Check to avoid bits of the feature floating
        mutable.set(cornerPos).move(Direction.SOUTH, 1).move(Direction.EAST, 1);
        if (!level.getBlockState(mutable).isSolid()) return false;

        mutable.set(cornerPos).move(Direction.SOUTH, 1).move(Direction.EAST, 2);
        if (!level.getBlockState(mutable).isSolid()) return false;

        mutable.set(cornerPos).move(Direction.SOUTH, 2).move(Direction.EAST, 1);
        if (!level.getBlockState(mutable).isSolid()) return false;

        mutable.set(cornerPos).move(Direction.SOUTH, 2).move(Direction.EAST, 2);
        if (!level.getBlockState(mutable).isSolid()) return false;

        // Generate the feature
        StructureTemplate template = this.createTemplateFromCenter(ID, level, randomSource, surfacePos.above());
        return template != null;
    }

    @Override
    public MapCodec<DesertGiantTorchFeature> codec() {
        return CODEC;
    }
}
