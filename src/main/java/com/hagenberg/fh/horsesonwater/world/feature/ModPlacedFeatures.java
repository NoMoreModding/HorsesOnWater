package com.hagenberg.fh.horsesonwater.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class ModPlacedFeatures {

    public static final Holder<PlacedFeature> PATCH_AREN_HERB =
            PlacementUtils.register("patch_pumpkin",
                    ModConfiguredFeatures.PATCH_AREN_HERB,
                    RarityFilter.onAverageOnceEvery(32),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome());
}
