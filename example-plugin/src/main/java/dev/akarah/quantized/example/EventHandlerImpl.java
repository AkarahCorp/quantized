package dev.akarah.quantized.example;

import dev.akarah.quantized.api.dimension.Player;
import dev.akarah.quantized.api.scheduler.EventHandler;

public class EventHandlerImpl implements EventHandler {
    @Override
    public void onPlayerJoin(Player player) {
        player.sendMessage("Welcome to the server!");
        System.out.println("join");
    }

    @Override
    public void onPlayerQuit(Player player) {
        System.out.println("quit");
    }
}
