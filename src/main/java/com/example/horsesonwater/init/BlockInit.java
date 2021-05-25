package com.example.horsesonwater.init;

import com.example.horsesonwater.HorsesOnWater;
import com.example.horsesonwater.common.block.ArenHerbBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, HorsesOnWater.MODID);

    public static final RegistryObject<Block> ARENHERB = BLOCKS.register("arenherb", () -> new ArenHerbBlock(
            AbstractBlock.Properties.create(Material.PLANTS)
    ));



}
