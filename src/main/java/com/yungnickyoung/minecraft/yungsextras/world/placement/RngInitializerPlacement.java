package com.yungnickyoung.minecraft.yungsextras.world.placement;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.WorldDecoratingHelper;
import net.minecraft.world.gen.placement.NoPlacementConfig;
import net.minecraft.world.gen.placement.Placement;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Properly initializes this placement's Random seed (which MC doesn't do on its own)
 * to maximize variability in feature placement.
 */
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class RngInitializerPlacement extends Placement<NoPlacementConfig> {
    public RngInitializerPlacement() {
        super(NoPlacementConfig.CODEC);
    }

    @Override
    public Stream<BlockPos> getPositions(WorldDecoratingHelper helper, Random rand, NoPlacementConfig config, BlockPos pos) {
        long a = rand.nextLong() | 1L;
        long b = rand.nextLong() | 1L;
        rand.setSeed(((pos.getX() * a * 341873128712L + 12412146) * (pos.getZ() * b * 132897987541L + 5813717)) ^ 423487234);
        return Stream.of(pos);
    }
}
