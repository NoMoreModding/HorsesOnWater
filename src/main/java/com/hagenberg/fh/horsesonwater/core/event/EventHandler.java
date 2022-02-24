package com.hagenberg.fh.horsesonwater.core.event;

import com.hagenberg.fh.horsesonwater.HorsesOnWater;
import com.hagenberg.fh.horsesonwater.init.EffectInit;
import com.hagenberg.fh.horsesonwater.init.ItemInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.entity.passive.horse.DonkeyEntity;
import net.minecraft.entity.passive.horse.LlamaEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HorsesOnWater.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EventHandler {

    @SubscribeEvent
    public static void ItemUseOnHorse(final PlayerInteractEvent.EntityInteract event){
        if (event.getPlayer().getHeldItem(event.getHand()).getItem() == ItemInit.ARENHERB.get()){
            Entity entity = event.getTarget();

            if (entity instanceof AbstractHorseEntity) {

                AbstractHorseEntity animalEntity = (AbstractHorseEntity) entity;
                animalEntity.addPotionEffect(new EffectInstance(EffectInit.FROST_WALKER_EFFECT.get(), 3600, 1));

                // playing sound
                if (!entity.isSilent()) {
                    SoundEvent soundevent = getSoundEvent(animalEntity);
                    if (soundevent != null) {
                        event.getWorld().playSound((PlayerEntity)null, entity.getPosX(), entity.getPosY(), entity.getPosZ(), soundevent, entity.getSoundCategory(), 1.0F, 1.0F);
                    }
                }

                // consuming Item
                PlayerEntity player = event.getPlayer();

                player.swing(event.getHand(),true);

                if (!player.abilities.isCreativeMode){
                    player.getHeldItem(event.getHand()).shrink(1);
                }
                event.setCanceled(true);
            }
        }
    }

    private static SoundEvent getSoundEvent(AbstractHorseEntity abstractHorseEntity) {

        if (abstractHorseEntity instanceof DonkeyEntity){
            return SoundEvents.ENTITY_DONKEY_EAT;
        } else if (abstractHorseEntity instanceof LlamaEntity) {
            return SoundEvents.ENTITY_LLAMA_EAT;
        }
        return SoundEvents.ENTITY_HORSE_EAT;
    }
}
