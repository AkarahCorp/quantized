package dev.akarah.quantized.api.scheduler;

import dev.akarah.quantized.api.dimension.Player;

public interface EventHandler {
    void onPlayerJoin(Player player);
    void onPlayerQuit(Player player);
}
