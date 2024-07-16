package com.yungnickyoung.minecraft.yungsextras.world.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.yungnickyoung.minecraft.yungsextras.YungsExtrasCommon;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class DesertWellFeatureConfiguration implements FeatureConfiguration {
    public static final Codec<DesertWellFeatureConfiguration> CODEC = RecordCodecBuilder.create((codecBuilder) -> codecBuilder
            .group(
                    ResourceLocation.CODEC.fieldOf("location").forGetter(DesertWellFeatureConfiguration::getLocation),
                    ExtraCodecs.NON_NEGATIVE_INT.fieldOf("radius").forGetter(DesertWellFeatureConfiguration::getRadius))
            .apply(codecBuilder, DesertWellFeatureConfiguration::new));

    private final ResourceLocation location;
    private final int radius;

    public DesertWellFeatureConfiguration(ResourceLocation location, int radius) {
        this.location = location;
        this.radius = radius;
    }

    public DesertWellFeatureConfiguration(String id, int radius) {
        this.location = ResourceLocation.fromNamespaceAndPath(YungsExtrasCommon.MOD_ID, id);
        this.radius = radius;
    }

    public int getRadius() {
        return this.radius;
    }

    public ResourceLocation getLocation() {
        return this.location;
    }
}
