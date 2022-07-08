package com.hagenberg.fh.horsesonwater.init;

import com.hagenberg.fh.horsesonwater.HorsesOnWater;
import com.hagenberg.fh.horsesonwater.common.block.ArenHerbBlock;
import com.hagenberg.fh.horsesonwater.common.block.ArenHerbWildBlock;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderBuffers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.logging.Logger;

@Mod.EventBusSubscriber(modid = HorsesOnWater.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, HorsesOnWater.MODID);

    public static final RegistryObject<Block> ARENHERB = BLOCKS.register("arenherb", () -> new ArenHerbBlock(
            BlockBehaviour.Properties.of(Material.PLANT)
                    .noCollission()
                    .instabreak()
    ));

    public static final RegistryObject<Block> ARENHERB_WILD = BLOCKS.register("arenherb_wild", () -> new ArenHerbWildBlock(
            BlockBehaviour.Properties.of(Material.PLANT)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.WOOD)
    ));

    @SubscribeEvent
    public static void onClientSetupEvent(FMLClientSetupEvent event){

        ItemBlockRenderTypes.setRenderLayer(ARENHERB.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ARENHERB_WILD.get(), RenderType.cutout());
    }
}