package dev.akarah.quantized.api.registry;

import dev.akarah.quantized.api.util.ResourceLocation;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

public interface Registry<T> {
    Optional<T> get(ResourceLocation resourceLocation);
    Set<ResourceLocation> keySet();
    ResourceLocation name();

    default T getOrThrow(ResourceLocation resourceLocation) {
        return this.get(resourceLocation).orElseThrow();
    }

    default Registry<T> ifWritable(Consumer<WritableRegistry<T>> consumer) {
        if(this instanceof WritableRegistry<T> writableRegistry) {
            consumer.accept(writableRegistry);
        }
        return this;
    }

    static <T> WritableRegistry<T> empty(ResourceLocation name) {
        return new SimpleMap<>(new Object2ObjectOpenHashMap<>(), name);
    }

    record SimpleMap<T>(Map<ResourceLocation, T> map, ResourceLocation name) implements WritableRegistry<T> {
        @Override
        public Optional<T> get(ResourceLocation resourceLocation) {
            return Optional.ofNullable(map.get(resourceLocation));
        }

        @Override
        public Set<ResourceLocation> keySet() {
            return map.keySet();
        }

        @Override
        public ResourceLocation register(ResourceLocation resourceLocation, T value) {
            this.map.put(resourceLocation, value);
            return resourceLocation;
        }
    }
}
