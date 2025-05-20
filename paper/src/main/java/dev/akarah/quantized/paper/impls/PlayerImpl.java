package dev.akarah.quantized.paper.impls;

import dev.akarah.quantized.api.dimension.Entity;
import dev.akarah.quantized.api.dimension.Player;
import net.kyori.adventure.text.Component;

public class PlayerImpl extends EntityImpl implements Player {
    public PlayerImpl(org.bukkit.entity.Player entity) {
        super(entity);
    }

    public org.bukkit.entity.Player getPlayer() {
        return (org.bukkit.entity.Player) this.entity;
    }

    @Override
    public Entity asEntity() {
        return new EntityImpl(this.entity);
    }

    @Override
    public void sendMessage(String message) {
        getPlayer().sendMessage(Component.text(message));
    }
}
