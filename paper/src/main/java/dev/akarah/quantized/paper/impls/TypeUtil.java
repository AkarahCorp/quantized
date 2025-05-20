package dev.akarah.quantized.paper.impls;

import dev.akarah.quantized.api.util.ResourceLocation;
import dev.akarah.quantized.api.util.Rotation;
import dev.akarah.quantized.api.util.WorldPos;
import net.kyori.adventure.key.Key;
import org.bukkit.Location;

public class TypeUtil {
    public static WorldPos worldPos(Location location) {
        return new WorldPos(location.x(), location.y(), location.z());
    }

    public static Rotation rotation(Location location) {
        return new Rotation(location.getPitch(), location.getYaw());
    }

    public static ResourceLocation resourceLocation(Key key) {
        return ResourceLocation.of(key.namespace(), key.value());
    }
}
