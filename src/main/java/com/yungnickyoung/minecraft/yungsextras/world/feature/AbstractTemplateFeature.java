package com.yungnickyoung.minecraft.yungsextras.world.feature;

import com.mojang.serialization.Codec;
import com.yungnickyoung.minecraft.yungsextras.YungsExtras;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;

import java.util.Random;

public abstract class AbstractTemplateFeature<C extends IFeatureConfig> extends Feature<C> {
    public AbstractTemplateFeature(Codec<C> codec) {
        super(codec);
    }

    protected Template createTemplate(ResourceLocation templateName, ISeedReader world, Random rand, BlockPos pos) {
        Template template = world.getWorld().getStructureTemplateManager().getTemplate(templateName);

        if (template == null) { // Unsuccessful creation. Name is probably invalid.
            YungsExtras.LOGGER.warn("Failed to create invalid feature {}", templateName);
            return null;
        }

        // Find the corner from which we should spawn the template.
        // We are using the pos parameter passed in as the center of the feature, so we must offset.
        BlockPos cornerPos = pos.add(-template.getSize().getX() / 2, 0, -template.getSize().getZ() / 2);

        // Create template
        PlacementSettings placement = new PlacementSettings();
        template.func_237144_a_(world, cornerPos, placement, rand);

        // Additional optional processing
        processTemplate(template, world, rand, cornerPos, placement);

        return template;
    }

    protected void processTemplate(Template template, ISeedReader world, Random rand, BlockPos cornerPos, PlacementSettings placementSettings) {}
}
