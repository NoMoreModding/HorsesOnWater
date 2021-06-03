package com.example.horsesonwater;

import com.example.horsesonwater.init.BlockInit;
import com.example.horsesonwater.init.FeatureInit;
import com.example.horsesonwater.init.ItemInit;
import net.minecraft.block.BlockState;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("horsesonwater")
public class HorsesOnWater
{
    public static final String MODID = "horsesonwater";
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    IEventBus bus;

    public HorsesOnWater() {
        this.bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::setup);

        BlockInit.BLOCKS.register(bus);
        ItemInit.ITEMS.register(bus);
        FeatureInit.FEATURES.register(bus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }


    private void setup(final FMLCommonSetupEvent event)
    {

    }



}
