package com.hagenberg.fh.horsesonwater.common.block;

import com.hagenberg.fh.horsesonwater.init.ItemInit;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.property.Properties;

import javax.annotation.Nullable;
import java.util.Random;

public class ArenHerbBlock extends CropBlock {
    public static final int MAX_AGE = 3;
    public static final IntegerProperty AREN_AGE = BlockStateProperties.AGE_3;

    private static final VoxelShape[] SHAPE = new VoxelShape[]{
            Block.box(3.0D,0.0D,3.0D,13.0D,2.0D,13.0D),
            Block.box(6D,0.0D,6D,10D,5.0D,10D),
            Block.box(6.0D,0.0D,6.0D,10.0D,7.0D,10.0D),
            Block.box(4.0D, 0.0D, 4.0D, 12.0D, 11.0D, 12.0D),
    };


    @Override
    public SoundType getSoundType(BlockState state, LevelReader level, BlockPos pos, @org.jetbrains.annotations.Nullable Entity entity) {
        if(state.getValue(this.getAgeProperty()) < 3) {
            return SoundType.CROP;
        }
        return SoundType.WOOD;
    }

    public ArenHerbBlock (Properties properties){
        super(properties);
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AREN_AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ItemInit.AREN_SEEDS.get();
    }

    @Override
    public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, Random random) {
        if(random.nextInt(3) != 0){
            super.randomTick(state,worldIn,pos,random);
        }
    }

    @Override
    protected int getBonemealAgeIncrease(Level worldIn) {
        return  super.getBonemealAgeIncrease(worldIn)/2;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_49665_) {
        p_49665_.add(AREN_AGE);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return SHAPE[state.getValue(this.getAgeProperty())];
    }
}
