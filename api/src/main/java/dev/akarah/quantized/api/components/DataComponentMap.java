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

    interface Mutable extends DataComponentMap {
        <T> void set(DataComponentType<T> type, T value);
    }

    static Builder builder() { return new Builder(); }

    DataComponentMap EMPTY = new DataComponentMap() {
        @Override
        public <T> Optional<T> get(DataComponentType<T> dataComponentType) {
            return Optional.empty();
        }

        @Override
        public Set<DataComponentType<?>> keySet() {
            return Set.of();
        }
    };

    class Builder implements DataComponentMap.Mutable {
        Map<DataComponentType<?>, Object> map = new Reference2ObjectArrayMap<>();

        public <T> Builder with(DataComponentType<T> type, T value) {
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

        @Override
        public <T> void set(DataComponentType<T> type, T value) {
            this.map.put(type, value);
        }

        @Override
        @SuppressWarnings("unchecked")
        public <T> Optional<T> get(DataComponentType<T> dataComponentType) {
            return (Optional<T>) Optional.ofNullable(this.map.get(dataComponentType));
        }

        @Override
        public Set<DataComponentType<?>> keySet() {
            return this.map.keySet();
        }
    }

    record SimpleMap(Map<DataComponentType<?>, Object> map) implements DataComponentMap.Mutable {
        @Override
        @SuppressWarnings("unchecked")
        public <T> Optional<T> get(DataComponentType<T> dataComponentType) {
            return Optional.ofNullable((T) this.map.get(dataComponentType));
        }

        @Override
        public Set<DataComponentType<?>> keySet() {
            return this.map.keySet();
        }

        @Override
        public <T> void set(DataComponentType<T> type, T value) {
            this.map.put(type, value);
        }
    }
}
