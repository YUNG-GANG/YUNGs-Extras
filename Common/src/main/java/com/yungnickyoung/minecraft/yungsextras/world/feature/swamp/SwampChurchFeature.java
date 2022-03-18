package com.yungnickyoung.minecraft.yungsextras.world.feature.swamp;


import com.yungnickyoung.minecraft.yungsextras.world.config.ResourceLocationFeatureConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;

@ParametersAreNonnullByDefault
public class SwampChurchFeature extends AbstractSwampFeature<ResourceLocationFeatureConfiguration> {
    public SwampChurchFeature() {
        super(ResourceLocationFeatureConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<ResourceLocationFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        Random rand = context.random();
        BlockPos pos = context.origin();
        ResourceLocation location = context.config().getLocation();

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
        StructureTemplate template = this.createTemplateFromCenter(location, level, rand, surfacePos);
        return template != null;
    }
}
