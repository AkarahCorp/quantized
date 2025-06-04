package dev.akarah.quantized.fabric.mixin;

import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.BooleanSupplier;

@Mixin(MinecraftServer.class)
public class MinecraftServerMixin {
    @Inject(method = "tickServer", at = @At("HEAD"))
    public void tickServer(BooleanSupplier booleanSupplier, CallbackInfo ci) {
        System.out.println("ticking!");
    }
}
