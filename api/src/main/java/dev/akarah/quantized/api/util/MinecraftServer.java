package dev.akarah.quantized.api.util;

import dev.akarah.quantized.api.scheduler.EventBus;
import dev.akarah.quantized.api.scheduler.Scheduler;

public interface MinecraftServer {
    Scheduler getScheduler();
    EventBus eventBus();

    static MinecraftServer get() {
        return MinecraftServer.InstanceHolder.instance;
    }

    class InstanceHolder {
        protected static MinecraftServer instance;
    }
}
