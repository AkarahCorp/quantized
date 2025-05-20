package dev.akarah.quantized.api.dimension;

import dev.akarah.quantized.api.components.DataComponentMap;
import dev.akarah.quantized.api.util.ResourceLocation;
import dev.akarah.quantized.api.util.Rotation;
import dev.akarah.quantized.api.util.WorldPos;

import java.util.Optional;

public interface Entity extends DataComponentMap.Mutable {
    WorldPos position();
    Rotation rotation();

    ResourceLocation entityType();
    Optional<Player> player();
}
