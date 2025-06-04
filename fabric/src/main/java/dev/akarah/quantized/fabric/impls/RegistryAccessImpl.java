package dev.akarah.quantized.fabric.impls;

import dev.akarah.quantized.api.registry.*;
import dev.akarah.quantized.api.util.ResourceLocation;
import dev.akarah.quantized.fabric.registry.DataRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RegistryAccessImpl implements RegistryAccess {
    Map<ResourceLocation, Registry<?>> registries = new HashMap<>();

    @SuppressWarnings("unchecked")
    public RegistryAccessImpl() {
        this.registries.put(
                RegistryKeys.PLUGIN.value(),
                new DataRegistry<>(RegistryKeys.PLUGIN.value())
        );
        this.registries.put(
                RegistryKeys.ROOT,
                new DataRegistry<>(RegistryKeys.ROOT, this.registries)
        );
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> Optional<T> get(RegistryKey<T> registryKey) {
        System.out.println("rk: " + registryKey);
        return Optional.ofNullable(this.registries.get(registryKey.registry()))
                .flatMap(x -> x.get(registryKey.value()))
                .map(x -> (T) x);
    }
}
