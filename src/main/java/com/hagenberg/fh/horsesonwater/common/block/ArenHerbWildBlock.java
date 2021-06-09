package com.hagenberg.fh.horsesonwater.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;

public class ArenHerbWildBlock extends BushBlock {
    private final VoxelShape SHAPE = Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 12.0D, 12.0D);

    public ArenHerbWildBlock(Properties properties){
        super(properties);
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        Vector3d offset = state.getOffset(worldIn, pos);
        return SHAPE.withOffset(offset.x,offset.y,offset.z);
    }

    @Override
    public OffsetType getOffsetType() {
        return super.getOffsetType().XZ;
    }
}
