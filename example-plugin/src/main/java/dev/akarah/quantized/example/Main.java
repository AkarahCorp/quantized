package dev.akarah.quantized.example;

import dev.akarah.quantized.api.plugin.Plugin;
import dev.akarah.quantized.api.util.ResourceLocation;

public class Main implements Plugin {
    @Override
    public ResourceLocation name() {
        return ResourceLocation.of("quantized", "example_plugin");
    }

    @Override
    public void load() {
        System.out.println("I've been loaded :)");
    }

    @Override
    public void unload() {

    }
}