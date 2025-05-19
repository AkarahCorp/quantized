package dev.akarah.quantized.core;

import dev.akarah.quantized.api.util.MinecraftServer;

public class MinecraftServerSetter {
    public static void setServer(MinecraftServer minecraftServer) {
        try {
            // use reflection since the field shouldn't be public ngl
            var field = MinecraftServer.InstanceHolder.class.getDeclaredField("instance");
            field.setAccessible(true);
            field.set(null, minecraftServer);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
}
