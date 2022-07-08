package com.hagenberg.fh.horsesonwater.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ArenHerbWildBlock extends BushBlock {
    private final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 12.0D, 12.0D);

    public ArenHerbWildBlock(Properties properties){
        super(properties);
    }


    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        Vec3 offset = state.getOffset(worldIn, pos);
        return SHAPE.move(offset.x,offset.y,offset.z);
    }

    @Override
    public OffsetType getOffsetType() {
        return super.getOffsetType().XZ;
    }
}
