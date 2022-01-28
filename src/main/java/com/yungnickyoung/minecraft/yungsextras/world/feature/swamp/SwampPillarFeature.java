package com.yungnickyoung.minecraft.yungsextras.world.feature.swamp;

import com.yungnickyoung.minecraft.yungsextras.YungsExtras;
import com.yungnickyoung.minecraft.yungsextras.world.config.StructurePathConfig;
import com.yungnickyoung.minecraft.yungsextras.world.feature.swamp.AbstractSwampFeature;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;

@ParametersAreNonnullByDefault
public class SwampPillarFeature extends AbstractSwampFeature<StructurePathConfig> {
    public SwampPillarFeature() {
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

        // Can only extend max 3 down
        mutable.set(cornerPos).move(Direction.DOWN, 4);
        if (level.isEmptyBlock(mutable)) return false;

        mutable.set(cornerPos).move(Direction.SOUTH, 3).move(Direction.DOWN, 4);
        if (level.isEmptyBlock(mutable)) return false;

        mutable.set(cornerPos).move(Direction.EAST, 3).move(Direction.DOWN, 4);
        if (level.isEmptyBlock(mutable)) return false;

        mutable.set(cornerPos).move(Direction.SOUTH, 3).move(Direction.EAST, 3).move(Direction.DOWN, 4);
        if (level.isEmptyBlock(mutable)) return false;

        // Generate
        ResourceLocation templateResource = new ResourceLocation(YungsExtras.MOD_ID, context.config().path);
        StructureTemplate template = this.createTemplate(templateResource, level, rand, surfacePos);
        return template != null;
    }
}
