package com.yungnickyoung.minecraft.yungsextras.world.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.yungnickyoung.minecraft.yungsextras.YungsExtrasCommon;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

/**
 * Contains the ResourceLocation to a structure NBT.
 */
public class ResourceLocationFeatureConfiguration implements FeatureConfiguration {
    public static final Codec<ResourceLocationFeatureConfiguration> CODEC = RecordCodecBuilder.create((builder) ->builder
            .group(ResourceLocation.CODEC.fieldOf("location").forGetter((config) -> config.location))
            .apply(builder, ResourceLocationFeatureConfiguration::new));
    public final ResourceLocation location;

    public ResourceLocationFeatureConfiguration(ResourceLocation location) {
        this.location = location;
    }

    public ResourceLocationFeatureConfiguration(String id) {
        this.location = new ResourceLocation(YungsExtrasCommon.MOD_ID, id);
    }

    public ResourceLocation getLocation() {
        return location;
    }
}
