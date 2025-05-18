package dev.akarah.quantized.api.components;

import it.unimi.dsi.fastutil.objects.Reference2ObjectArrayMap;

import java.util.*;

/**
 * DataComponentMap is a map where you can store multiple dynamic properties on one object.
 * Each component has an associated {@link DataComponentType} that is a key into accessing its associated property.
 */
public interface DataComponentMap {
    <T> Optional<T> get(DataComponentType<T> dataComponentType);
    Set<DataComponentType<?>> keySet();

    static Builder builder() { return new Builder(); }

    class Builder {
        Map<DataComponentType<?>, Object> map = new Reference2ObjectArrayMap<>();

        public <T> Builder set(DataComponentType<T> type, T value) {
            this.setUnchecked(type, value);
            return this;
        }

        public <T> void setUnchecked(DataComponentType<T> type, T value) {
            if(value == null) {
                this.map.remove(type);
            } else {
                this.map.put(type, value);
            }
        }

        public DataComponentMap build() {
            return new SimpleMap(Collections.unmodifiableMap(this.map));
        }
    }

    record SimpleMap(Map<DataComponentType<?>, ?> map) implements DataComponentMap {
        @Override
        @SuppressWarnings("unchecked")
        public <T> Optional<T> get(DataComponentType<T> dataComponentType) {
            return Optional.ofNullable((T) this.map.get(dataComponentType));
        }

        @Override
        public Set<DataComponentType<?>> keySet() {
            return this.map.keySet();
        }
    }
}
