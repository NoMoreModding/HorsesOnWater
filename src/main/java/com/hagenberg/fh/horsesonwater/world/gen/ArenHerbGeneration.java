package com.hagenberg.fh.horsesonwater.world.gen;

import com.hagenberg.fh.horsesonwater.world.feature.ModPlacedFeatures;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;

public class ArenHerbGeneration {
    public static void generateArenHerbs(final BiomeLoadingEvent event) {
        if (event.getCategory().equals(Biome.BiomeCategory.ICY) || event.getCategory().equals(Biome.BiomeCategory.TAIGA)){
            List<Holder<PlacedFeature>> base =
                    event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);

            base.add(ModPlacedFeatures.PATCH_AREN_HERB);
        }
    }
}
