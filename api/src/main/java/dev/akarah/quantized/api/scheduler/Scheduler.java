package dev.akarah.quantized.api.scheduler;

import java.time.Duration;

public interface Scheduler {
    void execute(Task task);
    void execute(Task task, Duration delay);
}
