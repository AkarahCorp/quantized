package dev.akarah.quantized.api.scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class EventBus {
    public List<EventHandler> handlerList = new ArrayList<>();

    public void registerEventHandler(EventHandler eventHandler) {
        this.handlerList.add(eventHandler);
    }

    public void fireEvent(Consumer<EventHandler> consumer) {
        for(var event : handlerList) {
            consumer.accept(event);
        }
    }
}
