package dev.akarah.quantized.fabric.registry;

import dev.akarah.quantized.api.registry.Registry;
import dev.akarah.quantized.api.util.ResourceLocation;
import dev.akarah.quantized.fabric.impls.Converters;

import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class VanillaRegistryWrapper<T, O> implements Registry<O> {
    net.minecraft.core.Registry<T> registry;
    BiFunction<T, ResourceLocation, O> mappingFunction;
    ResourceLocation name;

    public VanillaRegistryWrapper(
            net.minecraft.core.Registry<T> registry,
            BiFunction<T, ResourceLocation, O> mappingFunction,
            ResourceLocation name
    ) {
        this.registry = registry;
        this.mappingFunction = mappingFunction;
        this.name = name;
    }

    @Override
    public Optional<O> get(ResourceLocation resourceLocation) {
        return this.registry.getOptional(Converters.convert(resourceLocation)).map(x -> this.mappingFunction.apply(x, resourceLocation));
    }

    @Override
    public Set<ResourceLocation> keySet() {
        return this.registry.keySet().stream().map(Converters::convert).collect(Collectors.toSet());
    }

    @Override
    public ResourceLocation name() {
        return this.name;
    }
}
