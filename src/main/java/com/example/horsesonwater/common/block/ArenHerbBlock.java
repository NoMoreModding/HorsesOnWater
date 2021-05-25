package com.example.horsesonwater.common.block;

import com.example.horsesonwater.init.ItemInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class ArenHerbBlock extends CropsBlock {
    private final int maxAge = 3;

    public static final IntegerProperty ARENHERB_AGE = BlockStateProperties.AGE_0_3;


    public ArenHerbBlock (Properties properties){
        super(properties);
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return ARENHERB_AGE;
    }

    @Override
    public int getMaxAge() {
        return maxAge;
    }

    @Override
    protected IItemProvider getSeedsItem() {
        return ItemInit.AREN_SEEDS.get();
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if(random.nextInt(3) != 0){
            super.randomTick(state,worldIn,pos,random);
        }
    }

    @Override
    protected int getBonemealAgeIncrease(World worldIn) {
        return super.getBonemealAgeIncrease(worldIn)/3;
    }

}
