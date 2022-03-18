package com.yungnickyoung.minecraft.yungsextras.world.feature;

import com.mojang.serialization.Codec;
import com.yungnickyoung.minecraft.yungsextras.YungsExtrasCommon;
import com.yungnickyoung.minecraft.yungsextras.world.processor.INbtFeatureProcessor;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public abstract class AbstractNbtFeature<C extends FeatureConfiguration> extends Feature<C> {
    protected List<INbtFeatureProcessor> processors;

    public AbstractNbtFeature(Codec<C> codec) {
        super(codec);
        this.processors = useProcessors();
    }

    /**
     * Generates the template feature with default placement settings and applies processors.
     * @param id ID of this template feature (i.e. namespaced path to the structure NBT)
     * @param level WorldGenLevel
     * @param rand Random
     * @param centerPos The position to generate the feature at. This will be the center of the feature.
     * @return The generated Template
     */
    protected StructureTemplate createTemplateFromCenter(ResourceLocation id, WorldGenLevel level, Random rand, BlockPos centerPos) {
        return createTemplateFromCenterWithPlacement(id, level, rand, centerPos, new StructurePlaceSettings());
    }

    /**
     * Generates the template feature with applies processors.
     * @param id ID of this template feature (i.e. namespaced path to the structure NBT)
     * @param level WorldGenLevel
     * @param rand Random
     * @param centerPos The position to generate the feature at. This will be the center of the feature.
     * @param placement Placement settings
     * @return The generated Template
     */
    protected StructureTemplate createTemplateFromCenterWithPlacement(
            ResourceLocation id,
            WorldGenLevel level,
            Random rand,
            BlockPos centerPos,
            StructurePlaceSettings placement
    ) {
        Optional<StructureTemplate> templateOptional = level.getLevel().getStructureManager().get(id);

        if (templateOptional.isEmpty()) { // Unsuccessful creation. Name is probably invalid.
            YungsExtrasCommon.LOGGER.warn("Failed to create invalid feature {}", id);
            return null;
        }

        StructureTemplate template = templateOptional.get();

        // Find the corner from which we should spawn the template.
        // We are using the centerPos parameter passed in as the center of the feature, so we must offset.
        BlockPos cornerPos = centerPos.offset(-template.getSize().getX() / 2, 0, -template.getSize().getZ() / 2);

        // Create template
        template.placeInWorld(level, cornerPos, centerPos, placement, rand, 2);

        // Additional optional processing
        processors.forEach(processor -> processor.processTemplate(template, level, rand, cornerPos, centerPos, placement));

        return template;
    }

    /**
     * Generates the template feature with default placement settings and applies processors.
     * @param id ID of this template feature (i.e. namespaced path to the structure NBT)
     * @param level WorldGenLevel
     * @param rand Random
     * @param cornerPos The position to generate the feature at. This is the lowest x-y-z corner of the feature.
     * @return The generated Template
     */
    protected StructureTemplate createTemplateFromCorner(ResourceLocation id, WorldGenLevel level, Random rand, BlockPos cornerPos) {
        return createTemplateFromCornerWithPlacement(id, level, rand, cornerPos, new StructurePlaceSettings());
    }

    /**
     * Generates the template feature with applies processors.
     * @param id ID of this template feature (i.e. namespaced path to the structure NBT)
     * @param level WorldGenLevel
     * @param rand Random
     * @param cornerPos The position to generate the feature at. This is the lowest x-y-z corner of the feature.
     * @param placement Placement settings
     * @return The generated Template
     */
    protected StructureTemplate createTemplateFromCornerWithPlacement(
            ResourceLocation id,
            WorldGenLevel level,
            Random rand,
            BlockPos cornerPos,
            StructurePlaceSettings placement
    ) {
        Optional<StructureTemplate> templateOptional = level.getLevel().getStructureManager().get(id);

        if (templateOptional.isEmpty()) { // Unsuccessful creation. Name is probably invalid.
            YungsExtrasCommon.LOGGER.warn("Failed to create invalid feature {}", id);
            return null;
        }

        StructureTemplate template = templateOptional.get();

        // Find the corner from which we should spawn the template.
        // We are using the cornerPos parameter passed in as the center of the feature, so we must offset.
        BlockPos centerPos = cornerPos.offset(template.getSize().getX() / 2, 0, template.getSize().getZ() / 2);

        // Create template
        template.placeInWorld(level, cornerPos, centerPos, placement, rand, 2);

        // Additional optional processing
        processors.forEach(processor -> processor.processTemplate(template, level, rand, cornerPos, centerPos, placement));

        return template;
    }

    /**
     * Attaches specified TemplateFeatureProcessors to this feature.
     * Override this method to return whatever processors you want this feature to have.
     */
    protected List<INbtFeatureProcessor> useProcessors() {
        return new ArrayList<>();
    }
}
