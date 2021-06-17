package com.hagenberg.fh.horsesonwater.world;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class ArenHerbWorldConfig implements IFeatureConfig {

    private final int HerbChance;
    private final int HerbPlotSize;

    public ArenHerbWorldConfig(int HerbChance, int HerbPlotSize){
        this.HerbChance = HerbChance;
        this.HerbPlotSize = HerbPlotSize;
    }

    public static final Codec<ArenHerbWorldConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("herb_chance").forGetter(ArenHerbWorldConfig::getHerbChance),Codec.INT.fieldOf("herb_plot_size").forGetter(ArenHerbWorldConfig::getHerbPlotSize))
            .apply(instance, ArenHerbWorldConfig::new));


    public int getHerbChance(){
        return this.HerbChance;
    }
    public int getHerbPlotSize(){ return this.HerbPlotSize;}
}

