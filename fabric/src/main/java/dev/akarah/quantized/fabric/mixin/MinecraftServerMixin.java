package dev.akarah.quantized.fabric.mixin;

import dev.akarah.quantized.core.SchedulerImpl;
import dev.akarah.quantized.fabric.Main;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.BooleanSupplier;

@Mixin(MinecraftServer.class)
public class MinecraftServerMixin {
    @Inject(method = "<init>", at = @At("TAIL"))
    private void init(CallbackInfo ci) {
        Main.FABRIC_SERVER = (MinecraftServer) (Object) this;
    }

    @Inject(method = "tickServer", at = @At("HEAD"))
    public void tickServer(BooleanSupplier booleanSupplier, CallbackInfo ci) {
        if(Main.PLUGIN_SERVER.getScheduler() instanceof SchedulerImpl scheduler) {
            scheduler.tick();
        }
    }
}
