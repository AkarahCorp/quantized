package dev.akarah.quantized.core;

import dev.akarah.quantized.api.scheduler.Scheduler;
import dev.akarah.quantized.api.scheduler.Task;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class SchedulerImpl implements Scheduler {
    List<ScheduledTask> tasks = new ArrayList<>();

    @Override
    public void execute(Task task) {
        execute(task, Duration.ZERO);
    }

    @Override
    public void execute(Task task, Duration delay) {
        this.tasks.addLast(new ScheduledTask(task, Instant.now().plus(delay)));
    }

    public void tick() {
        var taskList = tasks.stream().toList(); // copy this to stop ConcurrentModificationException

        for(var task : taskList) {
            if(Instant.now().isAfter(task.executeBy())) {
                task.task().execute();
                tasks.remove(task);
            }
        }
    }

    record ScheduledTask(Task task, Instant executeBy) {

    }
}
