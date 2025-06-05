package dev.akarah.quantized.api.components;

import dev.akarah.quantized.api.util.ResourceLocation;

public class BlockComponents {
    public static DataComponentType<Integer> AGE = DataComponentType.<Integer>builder()
            .named(ResourceLocation.of("minecraft", "age"))
            .build();
    public static DataComponentType<Boolean> ATTACHED = DataComponentType.<Boolean>builder()
            .named(ResourceLocation.of("minecraft", "attached"))
            .build();
}
