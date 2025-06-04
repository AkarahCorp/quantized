package dev.akarah.quantized.api.registry;

import dev.akarah.quantized.api.util.ResourceLocation;

import java.util.Objects;

public class RegistryKey<T> {
    ResourceLocation registry;
    ResourceLocation value;

    private RegistryKey(ResourceLocation registry, ResourceLocation value) {
        this.registry = registry;
        this.value = value;
    }

    public ResourceLocation registry() {
        return this.registry;
    }

    public ResourceLocation value() {
        return this.value;
    }

    public static <T> RegistryKey<T> of(Registry<T> registry, ResourceLocation value) {
        return new RegistryKey<>(registry.name(), value);
    }

    public static <T> RegistryKey<T> of(ResourceLocation registry, ResourceLocation value) {
        return new RegistryKey<>(registry, value);
    }

    public static <T> RegistryKey<T> of(ResourceLocation registry) {
        return new RegistryKey<>(ResourceLocation.of("minecraft", "root"), registry);
    }

    @SuppressWarnings("unchecked")
    public <U> RegistryKey<U> retype() {
        return (RegistryKey<U>) this;
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof RegistryKey<?> registryKey
                && registryKey.registry.equals(this.registry)
                && registryKey.value.equals(this.value);
    }

    @Override
    public String toString() {
        return "[" + this.registry + " / " + this.value + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.registry, this.value);
    }
}
