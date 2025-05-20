package dev.akarah.quantized.api.dimension;

public interface Player extends Entity {
    Entity asEntity();
    void sendMessage(String message);
}
