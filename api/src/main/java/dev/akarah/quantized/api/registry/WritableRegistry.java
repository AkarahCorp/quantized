package dev.akarah.quantized.api.registry;

import dev.akarah.quantized.api.util.ResourceLocation;

public interface WritableRegistry<T> extends Registry<T> {
    ResourceLocation register(ResourceLocation resourceLocation, T value);
}
