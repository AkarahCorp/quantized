package dev.akarah.quantized.api.dimension;

import dev.akarah.quantized.api.components.DataComponentMap;
import dev.akarah.quantized.api.util.ResourceLocation;
import dev.akarah.quantized.api.util.position.EulerAngles;
import dev.akarah.quantized.api.util.position.FinePosition;

import java.util.Optional;

public interface Entity extends DataComponentMap.Mutable {
    FinePosition position();
    EulerAngles rotation();

    ResourceLocation entityType();
    Optional<Player> player();
}
