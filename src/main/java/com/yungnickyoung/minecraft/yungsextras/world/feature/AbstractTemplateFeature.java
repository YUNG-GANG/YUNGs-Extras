package com.yungnickyoung.minecraft.yungsextras.world.feature;

import com.mojang.serialization.Codec;
import com.yungnickyoung.minecraft.yungsextras.YungsExtras;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import java.util.Optional;
import java.util.Random;

public abstract class AbstractTemplateFeature<C extends FeatureConfiguration> extends Feature<C> {
    public AbstractTemplateFeature(Codec<C> codec) {
        super(codec);
    }

    protected StructureTemplate createTemplate(ResourceLocation templateName, WorldGenLevel level, Random rand, BlockPos centerPos) {
        Optional<StructureTemplate> templateOptional = level.getLevel().getStructureManager().get(templateName);

        if (templateOptional.isEmpty()) { // Unsuccessful creation. Name is probably invalid.
            YungsExtras.LOGGER.warn("Failed to create invalid feature {}", templateName);
            return null;
        }

        StructureTemplate template = templateOptional.get();

        // Find the corner from which we should spawn the template.
        // We are using the centerPos parameter passed in as the center of the feature, so we must offset.
        BlockPos cornerPos = centerPos.offset(-template.getSize().getX() / 2, 0, -template.getSize().getZ() / 2);

        // Create template
        StructurePlaceSettings placement = new StructurePlaceSettings();
        template.placeInWorld(level, cornerPos, centerPos, placement, rand, 2);

        // Additional optional processing
        processTemplate(template, level, rand, cornerPos, centerPos, placement);

        return template;
    }

    protected void processTemplate(StructureTemplate template, WorldGenLevel world, Random rand, BlockPos cornerPos, BlockPos centerPosm, StructurePlaceSettings placementSettings) {}
}
