package dev.akarah.quantized.api.dimension;

import dev.akarah.quantized.api.util.position.BlockPosition;

public interface Dimension {
    BlockState getBlock(BlockPosition blockPosition);
    void setBlock(BlockPosition blockPosition, BlockState blockState);
}
