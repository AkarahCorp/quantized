package dev.akarah.quantized.paper;

import dev.akarah.quantized.api.scheduler.EventHandler;
import dev.akarah.quantized.api.util.MinecraftServer;
import dev.akarah.quantized.paper.impls.PlayerImpl;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class EventFiring implements Listener {
    @org.bukkit.event.EventHandler
    public void event(PlayerJoinEvent event) {
        MinecraftServer.get().eventBus().fireEvent(h -> h.onPlayerJoin(
                new PlayerImpl(event.getPlayer())
        ));
    }

    @org.bukkit.event.EventHandler
    public void event(PlayerQuitEvent event) {
        MinecraftServer.get().eventBus().fireEvent(h -> h.onPlayerQuit(
                new PlayerImpl(event.getPlayer())
        ));
    }
}
