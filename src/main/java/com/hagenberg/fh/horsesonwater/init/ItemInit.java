package com.hagenberg.fh.horsesonwater.init;

import com.hagenberg.fh.horsesonwater.HorsesOnWater;
import com.hagenberg.fh.horsesonwater.common.item.ArenHerbItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, HorsesOnWater.MODID);


//    private static final Food ARENHERBFOOD = (new Food.Builder())
//            .hunger(1)
//            .saturation(0.3f)
//            .effect(new EffectInstance(Effects.POISON, 1200, 3),1.0f)
//            .build();
//
//
//    public static final RegistryObject<Item> ARENHERB = ITEMS.register("arenherb", () -> new Item(new Item.Properties()
//            .group(ItemGroup.FOOD)
//            .food(ARENHERBFOOD)
//    ));

    public static final RegistryObject<Item> ARENHERB = ITEMS.register("arenherb", () -> new ArenHerbItem(new Item.Properties()
            .tab(CreativeModeTab.TAB_FOOD)));

    public static final RegistryObject<Item> AREN_SEEDS = ITEMS.register("aren_seeds", () -> new ItemNameBlockItem(BlockInit.ARENHERB.get(),
            (new Item.Properties())
                    .tab(CreativeModeTab.TAB_MATERIALS)
    ));

    public static final RegistryObject<BlockItem> ARENHERB_WILD = ITEMS.register("arenherb_wild",
            () -> new BlockItem(BlockInit.ARENHERB_WILD.get(),
                    new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)
            ));
}
