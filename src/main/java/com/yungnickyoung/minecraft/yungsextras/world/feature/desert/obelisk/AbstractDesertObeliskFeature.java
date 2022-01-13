package com.yungnickyoung.minecraft.yungsextras.world.feature.desert.obelisk;

import com.yungnickyoung.minecraft.yungsextras.YungsExtras;
import com.yungnickyoung.minecraft.yungsextras.world.feature.AbstractTemplateFeature;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;

@ParametersAreNonnullByDefault
public abstract class AbstractDesertObeliskFeature extends AbstractTemplateFeature<NoneFeatureConfiguration> {
    private static final String path = "desert/obelisk/";
    protected ResourceLocation name;

    public AbstractDesertObeliskFeature(String name) {
        super(NoneFeatureConfiguration.CODEC);
        this.name = new ResourceLocation(YungsExtras.MOD_ID, path + name);
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
        if (!BlockTags.SAND.contains(block)) return false;

        // Check to avoid bits of the obelisk floating
        mutable.set(cornerPos);
        if (level.isEmptyBlock(mutable)) return false;

        mutable.set(cornerPos).move(Direction.SOUTH, 3);
        if (level.isEmptyBlock(mutable)) return false;

        mutable.set(cornerPos).move(Direction.EAST, 3);
        if (level.isEmptyBlock(mutable)) return false;

        mutable.set(cornerPos).move(Direction.SOUTH, 3).move(Direction.EAST, 3);
        if (level.isEmptyBlock(mutable)) return false;

        // Generate the obelisk
        StructureTemplate template = this.createTemplate(this.name, level, rand, surfacePos.above());
        return template != null;
    }
}
