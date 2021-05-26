package com.example.horsesonwater.init;

import com.example.horsesonwater.HorsesOnWater;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, HorsesOnWater.MODID);


    private static final Food ARENHERBFOOD = (new Food.Builder())
            .hunger(1)
            .saturation(0.3f)
            .effect(new EffectInstance(Effects.POISON, 1200, 3),1.0f)
            .build();


    public static final RegistryObject<Item> ARENHERB = ITEMS.register("arenherb", () -> new Item(new Item.Properties()
            .group(ItemGroup.FOOD)
            .food(ARENHERBFOOD)));

    public static final RegistryObject<Item> AREN_SEEDS = ITEMS.register("aren_seeds", () -> new BlockNamedItem(BlockInit.ARENHERB.get(),
            (new Item.Properties())
                    .group(ItemGroup.MATERIALS)));

}
