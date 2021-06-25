package com.hagenberg.fh.horsesonwater.init;

import com.hagenberg.fh.horsesonwater.HorsesOnWater;
import com.hagenberg.fh.horsesonwater.common.effect.FrostWalkerEffect;
import net.minecraft.potion.Effect;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EffectInit {
    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, HorsesOnWater.MODID);


    public static final RegistryObject<Effect> FROST_WALKER_EFFECT = EFFECTS.register("frost_walker_effect",() -> new FrostWalkerEffect());
}
