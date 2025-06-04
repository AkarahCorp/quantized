package dev.akarah.quantized.api.registry;

import java.util.Optional;

public interface RegistryAccess {
    <T> Optional<T> get(RegistryKey<T> registryKey);

    default <T> T getOrThrow(RegistryKey<T> registryKey) {
        return this.get(registryKey).orElseThrow();
    }
}
