package com.yungnickyoung.minecraft.yungsextras.world.feature.swamp;

import com.yungnickyoung.minecraft.yungsextras.YungsExtras;
import com.yungnickyoung.minecraft.yungsextras.world.config.StructurePathConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import java.util.Random;

public class SwampOgreFeature extends AbstractSwampFeature<StructurePathConfig> {
    public SwampOgreFeature() {
        super(StructurePathConfig.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<StructurePathConfig> context) {
        WorldGenLevel level = context.level();
        Random rand = context.random();
        BlockPos pos = context.origin();

        // Find the surface
        BlockPos.MutableBlockPos mutable = pos.mutable();
        while (level.isEmptyBlock(mutable) && mutable.getY() > 2) {
            mutable.move(Direction.DOWN);
        }

        BlockPos surfacePos = mutable.immutable();
        BlockPos cornerPos = surfacePos.offset(-2, 0, -2);

        // Obelisk can only extend max 3 down
        mutable.set(cornerPos);
        if (level.isEmptyBlock(mutable)) return false;

        mutable.set(cornerPos).move(Direction.SOUTH, 3);
        if (level.isEmptyBlock(mutable)) return false;

        mutable.set(cornerPos).move(Direction.EAST, 3);
        if (level.isEmptyBlock(mutable)) return false;

        mutable.set(cornerPos).move(Direction.SOUTH, 3).move(Direction.EAST, 3);
        if (level.isEmptyBlock(mutable)) return false;

        // Generate the obelisk
        ResourceLocation templateResource = new ResourceLocation(YungsExtras.MOD_ID, context.config().path);
        StructureTemplate template = this.createTemplate(templateResource, level, rand, surfacePos);
        return template != null;
    }
}