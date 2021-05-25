package com.example.horsesonwater.init;

import com.example.horsesonwater.HorsesOnWater;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, HorsesOnWater.MODID);

    public static final RegistryObject<BlockItem> ARENHERB = ITEMS.register("arenherb", () -> new BlockItem(BlockInit.ARENHERB.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));

    public static final RegistryObject<Item> AREN_SEEDS = ITEMS.register("aren_seeds", () -> new BlockNamedItem(BlockInit.ARENHERB.get(), (new Item.Properties()).group(ItemGroup.MATERIALS)));

}
