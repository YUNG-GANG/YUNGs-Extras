package com.yungnickyoung.minecraft.yungsextras.world.feature.desert;

import com.yungnickyoung.minecraft.yungsextras.YungsExtrasCommon;
import com.yungnickyoung.minecraft.yungsextras.world.feature.AbstractNbtFeature;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.material.Material;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;

@ParametersAreNonnullByDefault
public class DesertSmallRuinsFeature extends AbstractNbtFeature<NoneFeatureConfiguration> {
    private static final ResourceLocation location = new ResourceLocation(YungsExtrasCommon.MOD_ID, "desert/misc/ruins_0");

    public DesertSmallRuinsFeature() {
        super(NoneFeatureConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
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
        Block block = level.getBlockState(surfacePos).getBlock();

        // Ensure valid position
        if (!block.defaultBlockState().is(BlockTags.SAND)) return false;

        // Check to avoid bits of the feature floating
        mutable.set(cornerPos);
        if (level.getBlockState(mutable).getMaterial() != Material.SAND) return false;

        mutable.set(cornerPos).move(Direction.SOUTH, 3);
        if (level.getBlockState(mutable).getMaterial() != Material.SAND) return false;

        mutable.set(cornerPos).move(Direction.EAST, 3);
        if (level.getBlockState(mutable).getMaterial() != Material.SAND) return false;

        mutable.set(cornerPos).move(Direction.SOUTH, 3).move(Direction.EAST, 3);
        if (level.getBlockState(mutable).getMaterial() != Material.SAND) return false;

        // Generate the feature
        StructureTemplate template = this.createTemplateFromCenter(location, level, rand, surfacePos);
        return template != null;
    }
}
