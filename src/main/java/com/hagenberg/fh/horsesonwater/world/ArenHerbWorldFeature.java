package com.hagenberg.fh.horsesonwater.world;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class ArenHerbWorldFeature extends Feature<ArenHerbWorldConfig> {
    public ArenHerbWorldFeature() {
        super(ArenHerbWorldConfig.CODEC);
    }
    @Override
    public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, ArenHerbWorldConfig config) {
        BlockState blockstate = Blocks.DIAMOND_BLOCK.getDefaultState();
        int i = 0;

        for(int j = 0; j < 5; ++j) {
            int x = pos.getX() + rand.nextInt(16);
            int z = pos.getZ() + rand.nextInt(16);
            int y = 90;
            // int y = reader.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, x, z);
            BlockPos blockpos = new BlockPos(x,y,z);
            if (reader.isAirBlock(blockpos) && blockpos.getY() < 255 && blockstate.isValidPosition(reader, blockpos)) {
                reader.setBlockState(blockpos, blockstate, 2);
                ++i;
            }
        }

        return i > 0;
    }




}
