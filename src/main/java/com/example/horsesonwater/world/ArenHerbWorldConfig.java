package com.example.horsesonwater.world;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class ArenHerbWorldConfig implements IFeatureConfig {

    private final int HerbChance;

    public ArenHerbWorldConfig(int HerbChance){
        this.HerbChance = HerbChance;
    }

    public static final Codec<ArenHerbWorldConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("herb_chance").forGetter(ArenHerbWorldConfig::getHerbChance))
            .apply(instance, ArenHerbWorldConfig::new));


    public int getHerbChance(){
        return this.HerbChance;
    }
}

