package dev.akarah.quantized.paper;

import dev.akarah.quantized.api.scheduler.EventHandler;
import dev.akarah.quantized.api.util.MinecraftServer;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class EventFiring implements Listener {
    @org.bukkit.event.EventHandler
    public void event(PlayerJoinEvent event) {
        MinecraftServer.get().eventBus().fireEvent(EventHandler::onPlayerJoin);
    }

    @org.bukkit.event.EventHandler
    public void event(PlayerQuitEvent event) {
        MinecraftServer.get().eventBus().fireEvent(EventHandler::onPlayerQuit);
    }
}
