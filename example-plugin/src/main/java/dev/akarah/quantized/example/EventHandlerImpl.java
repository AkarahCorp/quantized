package dev.akarah.quantized.example;

import dev.akarah.quantized.api.dimension.Player;
import dev.akarah.quantized.api.registry.RegistryKeys;
import dev.akarah.quantized.api.scheduler.EventHandler;
import dev.akarah.quantized.api.util.MinecraftServer;

public class EventHandlerImpl implements EventHandler {
    @Override
    public void onPlayerJoin(Player player) {
        player.sendMessage("Welcome to the server!");
        player.sendMessage(
                MinecraftServer.registryAccess()
                        .getOrThrow(RegistryKeys.PLUGIN)
                        .keySet()
                        .toString()
        );
        player.sendMessage(
                player.position()
                        .toString()
        );
    }

    @Override
    public void onPlayerQuit(Player player) {
        System.out.println("quit");
    }
}
