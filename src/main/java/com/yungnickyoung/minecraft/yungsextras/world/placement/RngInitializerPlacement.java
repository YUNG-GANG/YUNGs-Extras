package com.yungnickyoung.minecraft.yungsextras.world.placement;

import com.mojang.serialization.Codec;
import com.yungnickyoung.minecraft.yungsextras.init.YEModPlacements;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Properly initializes this placement's Random seed (which MC doesn't do on its own)
 * to maximize variability in feature placement.
 */
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class RngInitializerPlacement extends PlacementModifier {
    private static final RngInitializerPlacement INSTANCE = new RngInitializerPlacement();
    public static final Codec<RngInitializerPlacement> CODEC = Codec.unit(() -> INSTANCE);

    public static RngInitializerPlacement randomize() {
        return INSTANCE;
    }

    @Override
    public Stream<BlockPos> getPositions(PlacementContext placementContext, Random random, BlockPos pos) {
        long a = random.nextLong() | 1L;
        long b = random.nextLong() | 1L;
        random.setSeed(((pos.getX() * a * 341873128712L + 12412146) * (pos.getZ() * b * 132897987541L + 5813717)) ^ 423487234);
        return Stream.of(pos);
    }

    @Override
    public PlacementModifierType<?> type() {
        return YEModPlacements.RNG_INITIALIZER;
    }
}
