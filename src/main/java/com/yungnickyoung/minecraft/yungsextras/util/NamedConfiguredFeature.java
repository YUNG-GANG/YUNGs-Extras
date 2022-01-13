package com.yungnickyoung.minecraft.yungsextras.util;

import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public record NamedConfiguredFeature(String name, ConfiguredFeature<?, ?> configuredFeature) {}
