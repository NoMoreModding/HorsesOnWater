package com.hagenberg.fh.horsesonwater.core.event;

import com.hagenberg.fh.horsesonwater.HorsesOnWater;
import com.hagenberg.fh.horsesonwater.init.EffectInit;
import com.hagenberg.fh.horsesonwater.init.ItemInit;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.animal.horse.Donkey;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = HorsesOnWater.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EventHandler {


    @SubscribeEvent
    public static void ItemUseOnHorse(final PlayerInteractEvent.EntityInteract event){

        if (event.getItemStack().getItem() == ItemInit.ARENHERB.get()){
            Entity entity = event.getTarget();

            if (entity instanceof AbstractHorse animalEntity) {

                animalEntity.addEffect(new MobEffectInstance(EffectInit.FROST_WALKER_EFFECT.get(), 3600, 1));

                // playing sound
                if (!entity.isSilent()) {
                    SoundEvent soundevent = getSoundEvent(animalEntity);
                    if (soundevent != null) {
                        event.getWorld().playSound(null, entity.getX(), entity.getY(), entity.getZ(), soundevent, entity.getSoundSource(), 1.0F, 1.0F);
                    }
                }

                // consuming Item
                Player player = event.getPlayer();

                player.swing(event.getHand(),true);

                if (!player.isCreative()){
                    event.getItemStack().shrink(1);
                }
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void addArenSeedsTrade(final WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> trades = event.getRareTrades();
        trades.add((trader, rand) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 4),
                new ItemStack(ItemInit.AREN_SEEDS.get(),1),8,8,0.2f
        ));
    }

    private static SoundEvent getSoundEvent(AbstractHorse abstractHorseEntity) {

        if (abstractHorseEntity instanceof Donkey){
            return SoundEvents.DONKEY_EAT;
        } else if (abstractHorseEntity instanceof Llama) {
            return SoundEvents.LLAMA_EAT;
        }
        return SoundEvents.HORSE_EAT;
    }
}
