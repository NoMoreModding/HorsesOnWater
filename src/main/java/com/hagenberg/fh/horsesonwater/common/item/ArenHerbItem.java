package com.hagenberg.fh.horsesonwater.common.item;

import com.hagenberg.fh.horsesonwater.HorsesOnWater;
import com.hagenberg.fh.horsesonwater.init.EffectInit;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

import javax.annotation.Nullable;
import java.util.List;


public class ArenHerbItem extends Item {

    private double range = 4;

    private static final FoodProperties ARENHERBFOOD = (new FoodProperties.Builder())
            .nutrition(1)
            .saturationMod(0.3f)
            .effect(new MobEffectInstance(MobEffects.POISON, 120, 2), 1.0f)
            .build();

    public ArenHerbItem(Properties builder) {
        super(builder);
    }

    @Override
    public boolean isEdible() {
        return true;
    }

    @Nullable
    @Override
    public FoodProperties getFoodProperties() {
        return ARENHERBFOOD;
    }

}
