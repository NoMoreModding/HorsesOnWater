package com.hagenberg.fh.horsesonwater;

import com.hagenberg.fh.horsesonwater.init.BlockInit;
import com.hagenberg.fh.horsesonwater.init.ItemInit;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(HorsesOnWater.MODID)
public class HorsesOnWater
{
    public static final String MODID = "horsesonwater";
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    IEventBus bus;

    public HorsesOnWater() {
        this.bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::setup);

        BlockInit.BLOCKS.register(bus);
        ItemInit.ITEMS.register(bus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }


    private void setup(final FMLCommonSetupEvent event)
    {

    }



}
