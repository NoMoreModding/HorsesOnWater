package com.hagenberg.fh.horsesonwater.common.item;

import com.hagenberg.fh.horsesonwater.init.EffectInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Predicate;

public class ArenHerbItem extends Item {

    private double range = 4;

    private static final Food ARENHERBFOOD = (new Food.Builder())
            .hunger(1)
            .saturation(0.3f)
            .effect(new EffectInstance(Effects.POISON, 1200, 3),1.0f)
            .build();

    public ArenHerbItem(Properties builder) {
        super(builder);
    }

    @Override
    public boolean isFood() {
        return true;
    }

    @Nullable
    @Override
    public Food getFood() {
        return ARENHERBFOOD;
    }

//    @Override
//    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
//        List<Entity> entities = worldIn.getEntitiesWithinAABB (Class<EntityType.HORSE>,new AxisAlignedBB(playerIn.getPosition(),
//                new BlockPos(
//                        new Vector3d(playerIn.getPosX(),playerIn.getPosY(),playerIn.getPosZ())
//                                .add(playerIn.getLookVec().normalize()
//                                        .mul(range,range,range)))));
//
//       for (Entity entity : entities){
//           entity.remove();
//       }
//
//       return null;
//    }


    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        if (entity instanceof AnimalEntity) {
            AnimalEntity animalEntity = (AnimalEntity) entity;
            animalEntity.addPotionEffect(new EffectInstance(EffectInit.FROST_WALKER_EFFECT.get(),800,1));
        }
        return super.onLeftClickEntity(stack, player, entity);
    }
}
