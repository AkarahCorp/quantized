package dev.akarah.quantized.api.scheduler;

import java.util.function.Supplier;

public interface Task {
    void execute();

    default Task andThen(Task next) {
        var currentTask = this;
        return () -> {
            currentTask.execute();
            next.execute();
        };
    }

    default Task filter(Supplier<Boolean> predicate) {
        var currentTask = this;
        return () -> {
            if(predicate.get()) {
                currentTask.execute();
            }
        };
    }
}
