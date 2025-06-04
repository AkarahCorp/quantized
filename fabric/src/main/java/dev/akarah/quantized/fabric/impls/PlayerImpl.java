package dev.akarah.quantized.fabric.impls;

import dev.akarah.quantized.api.dimension.Entity;
import dev.akarah.quantized.api.dimension.Player;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class PlayerImpl extends EntityImpl implements Player {
    ServerPlayer player;

    public PlayerImpl(net.minecraft.world.entity.Entity entity) {
        super(entity);
        assert entity instanceof ServerPlayer;
    }

    public PlayerImpl(ServerPlayer serverPlayer) {
        super(serverPlayer);
        this.player = serverPlayer;
    }

    @Override
    public Entity asEntity() {
        return this;
    }

    @Override
    public void sendMessage(String message) {
        this.player.sendSystemMessage(
                Component.literal(message)
        );
    }
}
