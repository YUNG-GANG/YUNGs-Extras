package com.yungnickyoung.minecraft.yungsextras.world.feature.swamp;

import com.mojang.serialization.MapCodec;

import com.yungnickyoung.minecraft.yungsextras.world.config.IdentifierFeatureConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

public class SwampOgreFeature extends AbstractSwampFeature {
    public static final MapCodec<SwampOgreFeature> CODEC = IdentifierFeatureConfiguration.CODEC.xmap(SwampOgreFeature::new, feature -> feature.config);
    private final IdentifierFeatureConfiguration config;

    public SwampOgreFeature(IdentifierFeatureConfiguration config) {
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

        // Can only extend max 3 down in air
        mutable.set(cornerPos);
        if (level.isEmptyBlock(mutable)) return false;

        mutable.set(cornerPos).move(Direction.SOUTH, 3);
        if (level.isEmptyBlock(mutable)) return false;

        mutable.set(cornerPos).move(Direction.EAST, 3);
        if (level.isEmptyBlock(mutable)) return false;

        mutable.set(cornerPos).move(Direction.SOUTH, 3).move(Direction.EAST, 3);
        if (level.isEmptyBlock(mutable)) return false;

        // Generate
        StructureTemplate template = this.createTemplateFromCenter(location, level, randomSource, surfacePos);
        return template != null;
    }

    @Override
    public MapCodec<SwampOgreFeature> codec() {
        return CODEC;
    }
}