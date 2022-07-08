package com.hagenberg.fh.horsesonwater.common.effect;

import com.hagenberg.fh.horsesonwater.HorsesOnWater;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;

public class FrostWalkerEffect extends MobEffect {

    public FrostWalkerEffect(){
        super(MobEffectCategory.BENEFICIAL,14474495);
    }

    @Override
    public boolean isInstantenous() {
        return false;
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyEffectTick(LivingEntity entityLivingBaseIn, int amplifier) {
        freezeNearby(entityLivingBaseIn,entityLivingBaseIn.level,entityLivingBaseIn.getOnPos().above(),amplifier);

        super.applyEffectTick(entityLivingBaseIn, amplifier);
    }

    //from FrostWalkerEnchantment
    public static void freezeNearby(LivingEntity living, Level worldIn, BlockPos pos, int level) {
        if (living.isOnGround()) {
            BlockState blockstate = Blocks.FROSTED_ICE.defaultBlockState();
            float f = (float)Math.min(16, 2 + level);
            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

            for(BlockPos blockpos : BlockPos.betweenClosed(pos.offset((double)(-f), -1.0D, (double)(-f)), pos.offset((double)f, -1.0D, (double)f))) {
                if (blockpos.closerToCenterThan(living.position(), (double)f)) {
                    blockpos$mutableblockpos.set(blockpos.getX(), blockpos.getY() + 1, blockpos.getZ());
                    BlockState blockstate1 = worldIn.getBlockState(blockpos$mutableblockpos);
                    if (blockstate1.isAir()) {
                        BlockState blockstate2 = worldIn.getBlockState(blockpos);
                        boolean isFull = blockstate2.getBlock() == Blocks.WATER && blockstate2.getValue(LiquidBlock.LEVEL) == 0;
                        if (blockstate2.getMaterial() == Material.WATER && isFull && blockstate.canSurvive(worldIn, blockpos) && worldIn.isUnobstructed(blockstate, blockpos, CollisionContext.empty()) && !net.minecraftforge.event.ForgeEventFactory.onBlockPlace(living, net.minecraftforge.common.util.BlockSnapshot.create(worldIn.dimension(), worldIn, blockpos), net.minecraft.core.Direction.UP)) {
                            worldIn.setBlockAndUpdate(blockpos, blockstate);
                            worldIn.scheduleTick(blockpos, Blocks.FROSTED_ICE, Mth.nextInt(living.getRandom(), 60, 120));
                        }
                    }
                }
            }

        }
    }


}
