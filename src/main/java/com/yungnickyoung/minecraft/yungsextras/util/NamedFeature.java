package com.yungnickyoung.minecraft.yungsextras.util;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public record NamedFeature<C extends FeatureConfiguration>(String name, Feature<C> feature) {}