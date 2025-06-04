package dev.akarah.quantized.fabric.impls;

import dev.akarah.quantized.api.components.DataComponentType;
import dev.akarah.quantized.api.dimension.Entity;
import dev.akarah.quantized.api.dimension.Player;
import dev.akarah.quantized.api.util.ResourceLocation;
import dev.akarah.quantized.api.util.Rotation;
import dev.akarah.quantized.api.util.WorldPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.server.level.ServerPlayer;

import java.util.Optional;
import java.util.Set;

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
