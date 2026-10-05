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




public class SwampChurchFeature extends AbstractSwampFeature {
    public static final MapCodec<SwampChurchFeature> CODEC = IdentifierFeatureConfiguration.CODEC.xmap(SwampChurchFeature::new, feature -> feature.config);
    private final IdentifierFeatureConfiguration config;

    public SwampChurchFeature(IdentifierFeatureConfiguration config) {
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
        BlockPos cornerPos = surfacePos.offset(-6, 0, -2);

        // Can only extend max 3 down in air
        mutable.set(cornerPos).move(Direction.DOWN, 4);
        if (level.isEmptyBlock(mutable)) return false;

        mutable.set(cornerPos).move(Direction.SOUTH, 4).move(Direction.DOWN, 4);
        if (level.isEmptyBlock(mutable)) return false;

        mutable.set(cornerPos).move(Direction.EAST, 12).move(Direction.DOWN, 4);
        if (level.isEmptyBlock(mutable)) return false;

        mutable.set(cornerPos).move(Direction.SOUTH, 4).move(Direction.EAST, 12).move(Direction.DOWN, 4);
        if (level.isEmptyBlock(mutable)) return false;

        // Generate
        StructureTemplate template = this.createTemplateFromCenter(location, level, randomSource, surfacePos);
        return template != null;
    }

    @Override
    public MapCodec<SwampChurchFeature> codec() {
        return CODEC;
    }
}
