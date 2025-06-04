package dev.akarah.quantized.fabric.impls;

import dev.akarah.quantized.api.dimension.BlockState;
import dev.akarah.quantized.api.dimension.Dimension;
import dev.akarah.quantized.api.util.position.BlockPosition;
import dev.akarah.quantized.fabric.convert.BlockStateConversion;
import dev.akarah.quantized.fabric.convert.Converters;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class DimensionImpl implements Dimension {
    ServerLevel level;

    public DimensionImpl(ServerLevel level) {
        this.level = level;
    }

    @Override
    public BlockState getBlock(BlockPosition blockPosition) {
        return BlockStateConversion.convert(level.getBlockState(Converters.convert(blockPosition)));
    }

    @Override
    public void setBlock(BlockPosition blockPosition, BlockState blockState) {
        level.setBlock(
                Converters.convert(blockPosition),
                BlockStateConversion.convert(blockState),
                Block.UPDATE_ALL_IMMEDIATE
        );
    }
}
