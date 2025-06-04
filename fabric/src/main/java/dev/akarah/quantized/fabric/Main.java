package dev.akarah.quantized.fabric;

import dev.akarah.quantized.core.MinecraftServerSetter;
import dev.akarah.quantized.core.PluginLoader;
import dev.akarah.quantized.fabric.impls.MinecraftServerImpl;
import net.fabricmc.api.ModInitializer;

import java.io.IOException;

public class Main implements ModInitializer {

    @Override
    public void onInitialize() {
        var server = new MinecraftServerImpl();
        MinecraftServerSetter.setServer(server);

        try {
            PluginLoader.loadAllJars();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
