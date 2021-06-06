package com.hagenberg.fh.horsesonwater.init;

import com.hagenberg.fh.horsesonwater.HorsesOnWater;
import com.hagenberg.fh.horsesonwater.common.block.ArenHerbBlock;
import com.hagenberg.fh.horsesonwater.common.block.ArenHerbWildBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.logging.Logger;

@Mod.EventBusSubscriber(modid = HorsesOnWater.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, HorsesOnWater.MODID);

    public static final RegistryObject<Block> ARENHERB = BLOCKS.register("arenherb", () -> new ArenHerbBlock(
            AbstractBlock.Properties.create(Material.PLANTS)
    ));

    public static final RegistryObject<Block> ARENHERB_WILD = BLOCKS.register("arenherb_wild", () -> new ArenHerbWildBlock(
            AbstractBlock.Properties.create(Material.PLANTS)
    ));

    @SubscribeEvent
    public static void onClientSetupEvent(FMLClientSetupEvent event){
        RenderTypeLookup.setRenderLayer(ARENHERB.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ARENHERB_WILD.get(), RenderType.getCutout());
    }

}
