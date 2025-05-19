package dev.akarah.quantized.api.plugin;

import dev.akarah.quantized.api.util.ResourceLocation;

public interface Plugin {
    ResourceLocation name();
    void load();
    void unload();
}
