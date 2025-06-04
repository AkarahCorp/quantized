package dev.akarah.quantized.example;

import dev.akarah.quantized.api.dimension.BlockState;
import dev.akarah.quantized.api.dimension.Player;
import dev.akarah.quantized.api.registry.RegistryKeys;
import dev.akarah.quantized.api.scheduler.EventHandler;
import dev.akarah.quantized.api.util.MinecraftServer;
import dev.akarah.quantized.api.util.ResourceLocation;

import java.time.Duration;

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
        recursionLoop(player);
    }

    @Override
    public void onPlayerQuit(Player player) {
        System.out.println("quit");
    }

    public static void recursionLoop(Player player) {
        player.dimension().setBlock(
                player.position().blockPosition(),
                BlockState.of(ResourceLocation.of("minecraft", "oak_log"))
        );
        MinecraftServer.get().getScheduler().execute(() -> EventHandlerImpl.recursionLoop(player), Duration.ofMillis(100));
    }
}
