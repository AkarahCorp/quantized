package dev.akarah.quantized.api.registry;

import dev.akarah.quantized.api.plugin.Plugin;
import dev.akarah.quantized.api.util.ResourceLocation;

public class RegistryKeys {
    public static ResourceLocation ROOT = ResourceLocation.of("minecraft", "root");
    public static RegistryKey<Registry<Plugin>> PLUGIN = RegistryKey.of(ROOT, ResourceLocation.of("quantized", "plugin"));
}
