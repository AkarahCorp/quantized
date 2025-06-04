package dev.akarah.quantized.fabric.impls;

import dev.akarah.quantized.api.registry.Registry;
import dev.akarah.quantized.api.registry.RegistryKey;
import dev.akarah.quantized.api.util.ResourceLocation;
import net.minecraft.resources.ResourceKey;

public class Converters {
    public static net.minecraft.resources.ResourceLocation convert(ResourceLocation resourceLocation) {
        return net.minecraft.resources.ResourceLocation.fromNamespaceAndPath(resourceLocation.namespace(), resourceLocation.path());
    }

    public static ResourceLocation convert(net.minecraft.resources.ResourceLocation resourceLocation) {
        return ResourceLocation.of(resourceLocation.getNamespace(), resourceLocation.getPath());
    }
}
