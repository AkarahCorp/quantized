package dev.akarah.quantized.fabric.mixin;

import dev.akarah.quantized.api.util.MinecraftServer;
import dev.akarah.quantized.fabric.impls.PlayerImpl;
import net.minecraft.network.Connection;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.CommonListenerCookie;
import net.minecraft.server.players.PlayerList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerList.class)
public class PlayerListMixin {
    @Inject(method = "placeNewPlayer", at = @At("TAIL"))
    public void placeNewPlayer(Connection connection, ServerPlayer serverPlayer, CommonListenerCookie commonListenerCookie, CallbackInfo ci) {
        var player = new PlayerImpl(serverPlayer);
        MinecraftServer.get().eventBus().fireEvent(handler -> handler.onPlayerJoin(player));
    }
}
