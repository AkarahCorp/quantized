package dev.akarah.quantized.fabric.convert;

import dev.akarah.quantized.api.components.BlockComponents;
import dev.akarah.quantized.api.components.DataComponentMap;
import dev.akarah.quantized.fabric.Main;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class BlockStateConversion {
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> Property<T> getProperty(BlockState blockState, String property) {
        return (Property<T>) blockState.getBlock().getStateDefinition().getProperty(property);
    }

    public static <T extends Comparable<T>> Optional<T> readProperty(BlockState blockState, String property, Class<T> clazz) {
        var prop = BlockStateConversion.<T>getProperty(blockState, property);
        if(prop == null) {
            return Optional.empty();
        }
        return Optional.of(blockState.getValue(prop));
    }

    public static <T extends Comparable<T>> BlockState writeProperty(BlockState blockState, String property, T value) {
        var prop = BlockStateConversion.<T>getProperty(blockState, property);
        if(prop == null) {
            return blockState;
        }
        return blockState.setValue(prop, value);
    }

    public static BlockState convert(dev.akarah.quantized.api.dimension.BlockState blockState) {
        var block = Main.FABRIC_SERVER.registryAccess().lookup(Registries.BLOCK)
                .flatMap(x -> x.get(Converters.convert(blockState.blockType())))
                .map(Holder.Reference::value)
                .orElseThrow();

        AtomicReference<BlockState> state = new AtomicReference<>(block.defaultBlockState());

        blockState.components().get(BlockComponents.AGE).ifPresent(value -> state.set(writeProperty(state.get(), "age", value)));

        return state.get();
    }

    public static dev.akarah.quantized.api.dimension.BlockState convert(BlockState blockState) {
        var components = DataComponentMap.builder();

        var blockType = Main.FABRIC_SERVER.registryAccess().lookup(Registries.BLOCK)
                .map(x -> x.getKey(blockState.getBlock()))
                .orElseThrow();

        readProperty(blockState, "age", Integer.class).ifPresent(value -> components.set(BlockComponents.AGE, value));

        return dev.akarah.quantized.api.dimension.BlockState.of(Converters.convert(blockType))
                .withComponents(components);
    }
}
