package dev.akarah.quantized.fabric.registry;

import dev.akarah.quantized.api.registry.WritableRegistry;
import dev.akarah.quantized.api.util.ResourceLocation;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class DataRegistry<T> implements WritableRegistry<T> {
    Map<ResourceLocation, T> map = new HashMap<>();
    ResourceLocation name;

    public DataRegistry(ResourceLocation name) {
        this.name = name;
    }

    public DataRegistry(ResourceLocation name, Map<ResourceLocation, T> map) {
        this.name = name;
        this.map = map;
    }

    @Override
    public Optional<T> get(ResourceLocation resourceLocation) {
        return Optional.ofNullable(map.get(resourceLocation));
    }

    @Override
    public Set<ResourceLocation> keySet() {
        return map.keySet();
    }

    @Override
    public ResourceLocation name() {
        return this.name;
    }

    @Override
    public ResourceLocation register(ResourceLocation resourceLocation, T value) {
        this.map.put(resourceLocation, value);
        return resourceLocation;
    }
}
