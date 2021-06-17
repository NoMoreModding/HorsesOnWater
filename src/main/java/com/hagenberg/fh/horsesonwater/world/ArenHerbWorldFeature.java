package com.hagenberg.fh.horsesonwater.world;

import com.hagenberg.fh.horsesonwater.init.BlockInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class ArenHerbWorldFeature extends Feature<ArenHerbWorldConfig> {
    public ArenHerbWorldFeature() {
        super(ArenHerbWorldConfig.CODEC);
    }
    @Override
    public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, ArenHerbWorldConfig config) {
        BlockState blockstate = BlockInit.ARENHERB_WILD.get().getDefaultState();
        int i = 0;
        //if(rand.nextInt(100)*(100/ config.getHerbChance()) <= 100){
            int x = pos.getX() + rand.nextInt(16);
            int z = pos.getZ() + rand.nextInt(16);
            int y = reader.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, x, z);
            BlockPos blockpos = new BlockPos(x,y,z);
            if (reader.isAirBlock(blockpos) && blockpos.getY() < 255 && blockstate.isValidPosition(reader, blockpos)) {
                reader.setBlockState(blockpos, blockstate, 2);
                for(int k = 0; k < config.getHerbPlotSize()*((float)rand.nextInt(100)/100.0f); k++){
                    x += rand.nextInt(3)*positiveOrNegative(rand);
                    z += rand.nextInt(3)*positiveOrNegative(rand);
                    y = reader.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, x, z);
                    BlockPos temp = new BlockPos(x,y,z);
                    if (reader.isAirBlock(temp) && temp.getY() < 255 && blockstate.isValidPosition(reader, temp)) {
                        reader.setBlockState(temp, blockstate, 2);
                        ++i;
                    }
                    ++i;
                }
            }
        //}
        return i > 0;
    }

    private int positiveOrNegative(Random rand){
        return rand.nextBoolean() ? 1 : -1;
    }


}
