package com.hagenberg.fh.horsesonwater.init;

import com.hagenberg.fh.horsesonwater.HorsesOnWater;
import com.hagenberg.fh.horsesonwater.common.effect.FrostWalkerEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EffectInit {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, HorsesOnWater.MODID);


    public static final RegistryObject<MobEffect> FROST_WALKER_EFFECT = EFFECTS.register("frost_walker_effect",() -> new FrostWalkerEffect());
}
