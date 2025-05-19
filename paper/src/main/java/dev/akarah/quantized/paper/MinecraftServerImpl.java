package dev.akarah.quantized.paper;

import dev.akarah.quantized.api.scheduler.Scheduler;
import dev.akarah.quantized.api.util.MinecraftServer;
import dev.akarah.quantized.core.SchedulerImpl;

public class MinecraftServerImpl implements MinecraftServer {
    SchedulerImpl scheduler = new SchedulerImpl();

    @Override
    public Scheduler getScheduler() {
        return scheduler;
    }
}
