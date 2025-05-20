package dev.akarah.quantized.paper.impls;

import dev.akarah.quantized.api.components.DataComponentType;
import dev.akarah.quantized.api.dimension.Player;
import dev.akarah.quantized.api.util.ResourceLocation;
import dev.akarah.quantized.api.util.Rotation;
import dev.akarah.quantized.api.util.WorldPos;
import org.bukkit.Registry;
import org.bukkit.entity.Entity;

import java.util.Optional;
import java.util.Set;

public class EntityImpl implements dev.akarah.quantized.api.dimension.Entity {
    Entity entity;

    public EntityImpl(Entity entity) {
        this.entity = entity;
    }

    @Override
    public WorldPos position() {
        return TypeUtil.worldPos(entity.getLocation());
    }

    @Override
    public Rotation rotation() {
        return TypeUtil.rotation(entity.getLocation());
    }

    @Override
    public ResourceLocation entityType() {
        var entityType = Registry.ENTITY_TYPE.getKey(this.entity.getType());
        assert entityType != null;
        return TypeUtil.resourceLocation(entityType);
    }

    @Override
    public Optional<Player> player() {
        if(this.entity instanceof org.bukkit.entity.Player p) {
            return Optional.of(new PlayerImpl(p));
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
