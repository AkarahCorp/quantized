package dev.akarah.quantized.fabric.impls;

import dev.akarah.quantized.api.scheduler.EventBus;
import dev.akarah.quantized.api.scheduler.Scheduler;
import dev.akarah.quantized.api.util.MinecraftServer;
import dev.akarah.quantized.core.SchedulerImpl;

public class MinecraftServerImpl implements MinecraftServer {
    SchedulerImpl scheduler = new SchedulerImpl();
    EventBus eventBus = new EventBus();

    @Override
    public Scheduler getScheduler() {
        return this.scheduler;
    }

    @Override
    public EventBus eventBus() {
        return this.eventBus;
    }
}
