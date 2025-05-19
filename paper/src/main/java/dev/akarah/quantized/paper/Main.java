package dev.akarah.quantized.paper;

import dev.akarah.quantized.api.util.MinecraftServer;
import dev.akarah.quantized.core.MinecraftServerSetter;
import dev.akarah.quantized.core.SchedulerImpl;
import net.minecraft.core.WritableRegistry;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> {
            if(MinecraftServer.get().getScheduler() instanceof SchedulerImpl scheduler) {
                scheduler.tick();
            }
        }, 1, 1);
        Bukkit.getPluginManager().registerEvents(new EventFiring(), this);
    }
}