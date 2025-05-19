package dev.akarah.quantized.api.registry;

import dev.akarah.quantized.api.plugin.Plugin;
import dev.akarah.quantized.api.util.ResourceLocation;

public class BuiltInRegistries {
    public static WritableRegistry<Plugin> PLUGIN =
            Registry.empty(ResourceLocation.of("quantized", "plugin"));
}
