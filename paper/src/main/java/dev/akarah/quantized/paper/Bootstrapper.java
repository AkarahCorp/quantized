package dev.akarah.quantized.paper;

import dev.akarah.quantized.core.PluginLoader;
import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.bootstrap.PluginBootstrap;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class Bootstrapper implements PluginBootstrap {
    @Override
    public void bootstrap(@NotNull BootstrapContext bootstrapContext) {
        try {
            PluginLoader.loadAllJars();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
