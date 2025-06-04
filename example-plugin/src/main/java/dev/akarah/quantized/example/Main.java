package dev.akarah.quantized.example;

import dev.akarah.quantized.api.components.DataComponentMap;
import dev.akarah.quantized.api.plugin.Plugin;
import dev.akarah.quantized.api.util.MinecraftServer;
import dev.akarah.quantized.api.util.ResourceLocation;

import java.time.Duration;

public class Main implements Plugin {
    @Override
    public ResourceLocation name() {
        return ResourceLocation.of("quantized", "example_plugin");
    }

    @Override
    public void load() {
        System.out.println("I've been loaded :)");

        MinecraftServer.get().getScheduler().execute(() -> {
            System.out.println("Executing on main thread :D");
        });
    }

    @Override
    public void unload() {

    }
}