package com.yungnickyoung.minecraft.yungsextras.world.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.yungnickyoung.minecraft.yungsextras.YungsExtrasCommon;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class DesertWellFeatureConfiguration implements FeatureConfiguration {
    public static final Codec<DesertWellFeatureConfiguration> CODEC = RecordCodecBuilder.create((codecBuilder) -> codecBuilder
            .group(
                    Identifier.CODEC.fieldOf("location").forGetter(DesertWellFeatureConfiguration::getLocation),
                    ExtraCodecs.NON_NEGATIVE_INT.fieldOf("radius").forGetter(DesertWellFeatureConfiguration::getRadius))
            .apply(codecBuilder, DesertWellFeatureConfiguration::new));

    private final Identifier identifier;
    private final int radius;

    public DesertWellFeatureConfiguration(Identifier location, int radius) {
        this.identifier = location;
        this.radius = radius;
    }

    public DesertWellFeatureConfiguration(String id, int radius) {
        this.identifier = Identifier.fromNamespaceAndPath(YungsExtrasCommon.MOD_ID, id);
        this.radius = radius;
    }

    public int getRadius() {
        return this.radius;
    }

    public Identifier getLocation() {
        return this.identifier;
    }
}
