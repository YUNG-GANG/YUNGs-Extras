package com.yungnickyoung.minecraft.yungsextras.world.placement;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.function.Consumer;

/**
 * Properly initializes this placement's Random seed (which MC doesn't do on its own)
 * to maximize variability in feature placement.
 */


public class RngInitializerPlacement implements PlacementModifier {
    private static final RngInitializerPlacement INSTANCE = new RngInitializerPlacement();
    public static final MapCodec<RngInitializerPlacement> CODEC = MapCodec.unit(() -> INSTANCE);

    public static RngInitializerPlacement randomize() {
        return INSTANCE;
    }

    @Override
    public void modify(PlacementContext placementContext, RandomSource random, BlockPos pos, Consumer<BlockPos> output) {
        long a = random.nextLong() | 1L;
        long b = random.nextLong() | 1L;
        random.setSeed(((pos.getX() * a * 341873128712L + 12412146) * (pos.getZ() * b * 132897987541L + 5813717)) ^ 423487234);
        output.accept(pos);
    }

    @Override
    public MapCodec<RngInitializerPlacement> codec() {
        return CODEC;
    }
}
