package com.yungnickyoung.minecraft.yungsextras.world.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.yungnickyoung.minecraft.yungsextras.YungsExtrasCommon;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

/**
 * Contains the Identifier to a structure NBT.
 */
public class IdentifierFeatureConfiguration implements FeatureConfiguration {
    public static final Codec<IdentifierFeatureConfiguration> CODEC = RecordCodecBuilder.create((builder) ->builder
            .group(Identifier.CODEC.fieldOf("location").forGetter((config) -> config.identifier))
            .apply(builder, IdentifierFeatureConfiguration::new));
    public final Identifier identifier;

    public IdentifierFeatureConfiguration(Identifier location) {
        this.identifier = location;
    }

    public IdentifierFeatureConfiguration(String id) {
        this.identifier = Identifier.fromNamespaceAndPath(YungsExtrasCommon.MOD_ID, id);
    }

    public Identifier getLocation() {
        return identifier;
    }
}
