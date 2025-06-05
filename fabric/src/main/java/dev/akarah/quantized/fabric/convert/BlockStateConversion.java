package dev.akarah.quantized.fabric.convert;

import dev.akarah.quantized.api.components.BlockComponents;
import dev.akarah.quantized.api.components.DataComponentMap;
import dev.akarah.quantized.api.components.DataComponentType;
import dev.akarah.quantized.fabric.Main;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

public class BlockStateConversion {
    record ConversionRule<Q, M extends Comparable<M>>(Property<M> property, DataComponentType<Q> type, Function<M, Q> fromMc, Function<Q, M> toMc) {
        public static <M extends Comparable<M>> ConversionRule<M, M> rule(Property<M> property, DataComponentType<M> type) {
            return new ConversionRule<>(property, type, x -> x, x -> x);
        }
    }

    static List<ConversionRule<?, ?>> PROPERTY_TO_COMPONENT = List.of(
            ConversionRule.rule(BlockStateProperties.AGE_1, BlockComponents.AGE),
            ConversionRule.rule(BlockStateProperties.AGE_2, BlockComponents.AGE),
            ConversionRule.rule(BlockStateProperties.AGE_3, BlockComponents.AGE),
            ConversionRule.rule(BlockStateProperties.AGE_4, BlockComponents.AGE),
            ConversionRule.rule(BlockStateProperties.AGE_5, BlockComponents.AGE),
            ConversionRule.rule(BlockStateProperties.AGE_7, BlockComponents.AGE),
            ConversionRule.rule(BlockStateProperties.AGE_15, BlockComponents.AGE),
            ConversionRule.rule(BlockStateProperties.AGE_25, BlockComponents.AGE),
            ConversionRule.rule(BlockStateProperties.ATTACHED, BlockComponents.ATTACHED)
    );

    public static <P extends Comparable<P>, C> void readProperty(
            BlockState blockState,
            Property<P> property,
            DataComponentMap.Builder dataComponentMap,
            DataComponentType<C> type,
            Function<P, C> convert
    ) {
        if(blockState.hasProperty(property)) {
            dataComponentMap.setUnchecked(type, convert.apply(blockState.getValue(property)));
        }
    }

    public static <P extends Comparable<P>, C> void writeProperty(
            AtomicReference<BlockState> blockState,
            Property<P> property,
            DataComponentMap dataComponentMap,
            DataComponentType<C> dataComponentType,
            Function<C, P> convert
    ) {
        if(blockState.get().hasProperty(property)) {
            dataComponentMap.get(dataComponentType).ifPresent(value -> blockState.set(blockState.get().trySetValue(property, convert.apply(value))));
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static BlockState convert(dev.akarah.quantized.api.dimension.BlockState blockState) {
        var block = Main.FABRIC_SERVER.registryAccess().lookup(Registries.BLOCK)
                .flatMap(x -> x.get(Converters.convert(blockState.blockType())))
                .map(Holder.Reference::value)
                .orElseThrow();

        AtomicReference<BlockState> state = new AtomicReference<>(block.defaultBlockState());

        for(var prop : PROPERTY_TO_COMPONENT) {
            writeProperty(state, (Property) prop.property(), blockState.components(), (DataComponentType) prop.type(), prop.toMc());
        }

        return state.get();
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static dev.akarah.quantized.api.dimension.BlockState convert(BlockState blockState) {
        var components = DataComponentMap.builder();

        var blockType = Main.FABRIC_SERVER.registryAccess().lookup(Registries.BLOCK)
                .map(x -> x.getKey(blockState.getBlock()))
                .orElseThrow();

        for(var prop : PROPERTY_TO_COMPONENT) {
            readProperty(blockState, (Property) prop.property(), components, (DataComponentType) prop.type(), prop.fromMc());
        }

        return dev.akarah.quantized.api.dimension.BlockState.of(Converters.convert(blockType))
                .withComponents(components);
    }
}
