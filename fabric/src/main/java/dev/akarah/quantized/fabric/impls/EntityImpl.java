package dev.akarah.quantized.fabric.impls;

import dev.akarah.quantized.api.components.DataComponentType;
import dev.akarah.quantized.api.dimension.Dimension;
import dev.akarah.quantized.api.dimension.Entity;
import dev.akarah.quantized.api.dimension.Player;
import dev.akarah.quantized.api.util.ResourceLocation;
import dev.akarah.quantized.api.util.position.EulerAngles;
import dev.akarah.quantized.api.util.position.FinePosition;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;

import java.util.Optional;
import java.util.Set;

public class EntityImpl implements Entity {
    net.minecraft.world.entity.Entity entity;

    public EntityImpl(net.minecraft.world.entity.Entity entity) {
        this.entity = entity;
    }

    @Override
    public FinePosition position() {
        return FinePosition.of(
                this.entity.getX(),
                this.entity.getY(),
                this.entity.getZ()
        );
    }

    @Override
    public EulerAngles rotation() {
        return EulerAngles.of(
                this.entity.getYRot(),
                this.entity.getXRot()
        );
    }

    @Override
    public Dimension dimension() {
        return new DimensionImpl((ServerLevel) this.entity.level());
    }

    @Override
    public ResourceLocation entityType() {
        return ResourceLocation.parse(this.entity.getType().toShortString());
    }

    @Override
    public Optional<Player> player() {
        if(this.entity instanceof ServerPlayer serverPlayer) {
            return Optional.of(new PlayerImpl(serverPlayer));
        }
        return Optional.empty();
    }

    @Override
    public <T> void set(DataComponentType<T> type, T value) {

    }

    @Override
    public <T> Optional<T> get(DataComponentType<T> dataComponentType) {
        return Optional.empty();
    }

    @Override
    public Set<DataComponentType<?>> keySet() {
        return Set.of();
    }
}
