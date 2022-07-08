package com.hagenberg.fh.horsesonwater;

import com.hagenberg.fh.horsesonwater.init.BlockInit;
import com.hagenberg.fh.horsesonwater.init.EffectInit;
import com.hagenberg.fh.horsesonwater.init.ItemInit;
import com.hagenberg.fh.horsesonwater.world.ModWorldEvents;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
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
        EffectInit.EFFECTS.register(bus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }



}

//Todo Adding some sort of Gui to indicated how long the effect will last
//Todo making a logo for the mod
//Todo take some pictures of the mod
//Todo add the cursforge link to the mods.toml
