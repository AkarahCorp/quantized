package dev.akarah.quantized.api.util;

import dev.akarah.quantized.api.registry.RegistryAccess;
import dev.akarah.quantized.api.scheduler.EventBus;
import dev.akarah.quantized.api.scheduler.Scheduler;

public interface MinecraftServer {
    Scheduler getScheduler();
    EventBus getEventBus();
    RegistryAccess getRegistryAccess();

    static MinecraftServer get() {
        return MinecraftServer.InstanceHolder.instance;
    }

    static Scheduler scheduler() {
        return MinecraftServer.get().getScheduler();
    }

    static EventBus eventBus() {
        return MinecraftServer.get().getEventBus();
    }

    static RegistryAccess registryAccess() {
        return MinecraftServer.get().getRegistryAccess();
    }



    class InstanceHolder {
        protected static MinecraftServer instance;
    }
}
