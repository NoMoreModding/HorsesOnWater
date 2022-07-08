package com.hagenberg.fh.horsesonwater.world.feature;

import com.hagenberg.fh.horsesonwater.init.BlockInit;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.List;

public class ModConfiguredFeatures {

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_AREN_HERB =
            FeatureUtils.register("patch_aren_herb",
                    Feature.FLOWER,
                        new RandomPatchConfiguration(8,3,2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(BlockStateProvider.simple(BlockInit.ARENHERB_WILD.get())))));

}
