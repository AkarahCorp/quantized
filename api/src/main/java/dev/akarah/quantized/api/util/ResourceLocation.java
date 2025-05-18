package dev.akarah.quantized.api.util;

public class ResourceLocation {
    String namespace;
    String path;

    private ResourceLocation(String namespace, String path) {
        this.namespace = namespace;
        this.path = path;
    }

    public static ResourceLocation parse(String rawString) {
        if(!rawString.contains(":")) {
            rawString = "minecraft:" + rawString;
        }
        var split = rawString.split(":");
        return new ResourceLocation(split[0], split[1]);
    }

    public static ResourceLocation of(String namespace, String path) {
        return new ResourceLocation(namespace, path);
    }

    public String namespace() {
        return this.namespace;
    }

    public String path() {
        return this.path;
    }

    public ResourceLocation withNamespace(String newNamespace) {
        return new ResourceLocation(newNamespace, path);
    }

    public ResourceLocation withPath(String newPath) {
        return new ResourceLocation(namespace, newPath);
    }
}
