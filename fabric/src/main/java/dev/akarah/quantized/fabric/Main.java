package dev.akarah.quantized.fabric;

import dev.akarah.quantized.core.MinecraftServerSetter;
import dev.akarah.quantized.core.PluginLoader;
import dev.akarah.quantized.fabric.impls.MinecraftServerImpl;
import net.fabricmc.api.ModInitializer;
import net.minecraft.server.MinecraftServer;

import java.io.IOException;

public class Main implements ModInitializer {
    public static MinecraftServer FABRIC_SERVER;
    public static MinecraftServerImpl PLUGIN_SERVER;

    @Override
    public void onInitialize() {
        var server = new MinecraftServerImpl();
        PLUGIN_SERVER = server;
        MinecraftServerSetter.setServer(server);
        server.getRegistryAccess();



        try {
            PluginLoader.loadAllJars();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
