package com.example.horsesonwater.init;

import net.minecraft.util.ResourceLocation;
import com.example.horsesonwater.HorsesOnWater;
import com.example.horsesonwater.world.ArenHerbWorldConfig;
import com.example.horsesonwater.world.ArenHerbWorldFeature;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.WorldGenRegion;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class FeatureInit {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, HorsesOnWater.MODID);

    public static final Feature<ArenHerbWorldConfig> AREN_HERB_FEAT = new ArenHerbWorldFeature();

    //public static final RegistryObject <Feature<ArenHerbWorldConfig>> AREN_HERB = FEATURES.register("feature_aren_herb",() -> new ArenHerbWorldFeature());

    public static final ConfiguredFeature<?,?> AREN_HERB_CONF = AREN_HERB_FEAT
            .withConfiguration(new ArenHerbWorldConfig(5))
            .withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG));

    @SubscribeEvent
    public static void onBiomeLoad(BiomeLoadingEvent event){
        if(event.getCategory() == Biome.Category.ICY){
            event.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,AREN_HERB_CONF );
        }
    }

    @SubscribeEvent
    public static void registerFeatures(RegistryEvent.Register<Feature<?>> event){
        event.getRegistry().register(AREN_HERB_FEAT.setRegistryName(new ResourceLocation(HorsesOnWater.MODID,"aren_herb")));
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(HorsesOnWater.MODID,"aren_herb"),AREN_HERB_CONF);
    }
}
