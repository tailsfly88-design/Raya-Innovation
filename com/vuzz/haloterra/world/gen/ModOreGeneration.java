package com.vuzz.haloterra.world.gen;

import com.vuzz.haloterra.world.gen.OreType;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class ModOreGeneration {
    public static void generateOres(BiomeLoadingEvent event) {
        for (OreType ore : OreType.values()) {
            OreFeatureConfig oreFeatureConfig = new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, ((Block)ore.getBlock().get()).func_176223_P(), ore.getMaxVeinSize());
            ConfiguredPlacement configuredPlacement = Placement.field_242907_l.func_227446_a_((IPlacementConfig)new TopSolidRangeConfig(ore.getMinHeight(), ore.getMinHeight(), ore.getMaxHeight()));
            ConfiguredFeature<?, ?> oreFeature = ModOreGeneration.registerOreFeature(ore, oreFeatureConfig, configuredPlacement);
            event.getGeneration().func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, oreFeature);
        }
    }

    private static ConfiguredFeature<?, ?> registerOreFeature(OreType ore, OreFeatureConfig oreFeatureConfig, ConfiguredPlacement configuredPlacement) {
        return (ConfiguredFeature)Registry.func_218322_a((Registry)WorldGenRegistries.field_243653_e, (ResourceLocation)((Block)ore.getBlock().get()).getRegistryName(), (Object)((ConfiguredFeature)Feature.field_202290_aj.func_225566_b_((IFeatureConfig)oreFeatureConfig).func_227228_a_(configuredPlacement).func_242728_a()).func_242731_b(ore.getMaxVeinSize()));
    }
}
