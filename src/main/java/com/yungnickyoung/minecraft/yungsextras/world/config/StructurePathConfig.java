package com.yungnickyoung.minecraft.yungsextras.world.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

/**
 * Contains the path to a structure NBT, as a string.
 * E.g. "swamp/pillar/swamp_pillar_1"
 */
public class StructurePathConfig implements FeatureConfiguration {
    public static final Codec<StructurePathConfig> CODEC = RecordCodecBuilder.create((builder) ->builder
            .group(Codec.STRING.fieldOf("path").forGetter((config) -> config.path))
            .apply(builder, StructurePathConfig::new));
    public final String path;

    public StructurePathConfig(String path) {
        this.path = path;
    }

}
