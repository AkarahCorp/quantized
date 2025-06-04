package dev.akarah.quantized.fabric.convert;

import dev.akarah.quantized.api.util.ResourceLocation;
import dev.akarah.quantized.api.util.position.BlockPosition;
import net.minecraft.core.BlockPos;

public class Converters {
    public static net.minecraft.resources.ResourceLocation convert(ResourceLocation resourceLocation) {
        return net.minecraft.resources.ResourceLocation.fromNamespaceAndPath(resourceLocation.namespace(), resourceLocation.path());
    }

    public static ResourceLocation convert(net.minecraft.resources.ResourceLocation resourceLocation) {
        return ResourceLocation.of(resourceLocation.getNamespace(), resourceLocation.getPath());
    }

    public static BlockPos convert(BlockPosition blockPosition) {
        return new BlockPos(blockPosition.x(), blockPosition.y(), blockPosition.z());
    }

    public static BlockPosition convert(BlockPos blockPos) {
        return BlockPosition.of(blockPos.getX(), blockPos.getY(), blockPos.getZ());
    }
}
