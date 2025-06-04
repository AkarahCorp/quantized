package dev.akarah.quantized.fabric.convert;

import dev.akarah.quantized.api.components.DataComponentMap;
import dev.akarah.quantized.fabric.Main;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.block.state.BlockState;

public class BlockStateConversion {
    public static BlockState convert(dev.akarah.quantized.api.dimension.BlockState blockState) {
        var block = Main.FABRIC_SERVER.registryAccess().lookup(Registries.BLOCK)
                .flatMap(x -> x.get(Converters.convert(blockState.blockType())))
                .map(Holder.Reference::value)
                .orElseThrow();

        return block.defaultBlockState();
    }

    public static dev.akarah.quantized.api.dimension.BlockState convert(BlockState blockState) {
        var components = DataComponentMap.builder();

        var blockType = Main.FABRIC_SERVER.registryAccess().lookup(Registries.BLOCK)
                .map(x -> x.getKey(blockState.getBlock()))
                .orElseThrow();

        return dev.akarah.quantized.api.dimension.BlockState.of(Converters.convert(blockType))
                .withComponents(components);
    }
}
