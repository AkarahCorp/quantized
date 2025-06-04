package dev.akarah.quantized.api.components;

import com.mojang.serialization.Codec;
import dev.akarah.quantized.api.util.ResourceLocation;

import java.util.Optional;

/**
 * A key to accessing a property in a {@link DataComponentMap}
 * @param <T> The type of the property to access.
 */
public interface DataComponentType<T> {
    /**
     * Gets the codec associated with the property.
     * @return The codec associated with the property.
     */
    Optional<Codec<T>> customCodec();

    /**
     * Gets the name associated with the property.
     * @return The name associated with the property.
     */
    ResourceLocation name();

    /**
     * Returns an empty builder, allowing you to create a new {@link DataComponentType}.
     * @return The builder.
     * @param <T> The type of the final {@link DataComponentType}.
     */
    static <T> Builder<T> builder() { return new Builder<>(); }

    class Builder<T> {
        Codec<T> codec;
        ResourceLocation name;

        public Builder<T> custom(Codec<T> codec) {
            this.codec = codec;
            return this;
        }

        public Builder<T> named(ResourceLocation name) {
            this.name = name;
            return this;
        }

        public DataComponentType<T> build() {
            if(this.name == null) {
                throw new IllegalArgumentException("All DataComponentTypes must have a name.");
            }

            var t = new SimpleType<T>();
            t.codec = this.codec;
            t.name = this.name;
            return t;
        }
    }

    class SimpleType<T> implements DataComponentType<T> {
        Codec<T> codec;
        ResourceLocation name;

        @Override
        public Optional<Codec<T>> customCodec() {
            return Optional.ofNullable(this.codec);
        }

        @Override
        public ResourceLocation name() {
            return this.name;
        }
    }
}
