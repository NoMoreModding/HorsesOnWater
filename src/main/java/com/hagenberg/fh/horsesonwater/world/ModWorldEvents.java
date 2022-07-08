package com.hagenberg.fh.horsesonwater.world;

import com.hagenberg.fh.horsesonwater.HorsesOnWater;
import com.hagenberg.fh.horsesonwater.world.gen.ArenHerbGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HorsesOnWater.MODID)
public class ModWorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        ArenHerbGeneration.generateArenHerbs(event);
    }
}
