package com.yungnickyoung.minecraft.yungsextras.init;

import com.yungnickyoung.minecraft.yungsextras.world.processor.DesertWellProcessor;
import com.yungnickyoung.minecraft.yungsextras.world.processor.INbtFeatureProcessor;
import com.yungnickyoung.minecraft.yungsextras.world.processor.SwampFeatureProcessor;

import java.util.ArrayList;
import java.util.List;

public class YEModProcessors {
    /* List of all active processors. */
    public static List<INbtFeatureProcessor> PROCESSORS = new ArrayList<>();

    /* Processors */
    public static INbtFeatureProcessor DESERT_WELL_PROCESSOR = register(new DesertWellProcessor());
    public static INbtFeatureProcessor SWAMP_FEATURE_PROCESSOR = register(new SwampFeatureProcessor());

    private static INbtFeatureProcessor register(INbtFeatureProcessor processor) {
        PROCESSORS.add(processor);
        return processor;
    }
}
