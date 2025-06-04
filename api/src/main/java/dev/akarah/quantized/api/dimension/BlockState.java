package dev.akarah.quantized.api.dimension;

import dev.akarah.quantized.api.components.DataComponentMap;
import dev.akarah.quantized.api.util.ResourceLocation;

public class BlockState {
    ResourceLocation blockType;
    DataComponentMap components;

    private BlockState(ResourceLocation blockType, DataComponentMap components) {
        this.blockType = blockType;
        this.components = components;
    }

    public static BlockState of(ResourceLocation id) {
        return new BlockState(id, DataComponentMap.EMPTY);
    }

    public ResourceLocation blockType() {
        return this.blockType;
    }

    public BlockState withBlockType(ResourceLocation blockType) {
        return new BlockState(blockType, this.components);
    }

    public BlockState withComponents(DataComponentMap dataComponentMap) {
        return new BlockState(this.blockType, dataComponentMap);
    }

    public DataComponentMap components() {
        return this.components;
    }
}
