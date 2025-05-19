package dev.akarah.quantized.example;

import dev.akarah.quantized.api.scheduler.EventHandler;

public class EventHandlerImpl implements EventHandler {
    @Override
    public void onPlayerJoin() {
        System.out.println("join");
    }

    @Override
    public void onPlayerQuit() {
        System.out.println("quit");
    }
}
