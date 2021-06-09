package com.hagenberg.fh.horsesonwater.common.block;

import com.hagenberg.fh.horsesonwater.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.client.audio.Sound;
import net.minecraft.entity.Entity;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;

public class ArenHerbBlock extends CropsBlock {
    public static final IntegerProperty AREN_AGE = BlockStateProperties.AGE_0_3;

    private static final VoxelShape[] SHAPE = new VoxelShape[]{
            Block.makeCuboidShape(7.0D,0.0D,7.0D,9.0D,1.0D,9.0D),
            Block.makeCuboidShape(7.5D,0.0D,7.5D,9.5D,4.0D,9.5D),
            Block.makeCuboidShape(6.0D,0.0D,6.0D,10.0D,7.0D,10.0D),
            Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 11.0D, 12.0D),
    };


    @Override
    public SoundType getSoundType(BlockState state, IWorldReader world, BlockPos pos, @Nullable Entity entity) {
        if(state.get(this.getAgeProperty()) < 3) {
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
        return 3;
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

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(AREN_AGE);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE[state.get(this.getAgeProperty())];
    }
}
