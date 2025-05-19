module dev.akarah.quantized.api {
    requires datafixerupper;
    requires it.unimi.dsi.fastutil;

    exports dev.akarah.quantized.api.components;
    exports dev.akarah.quantized.api.plugin;
    exports dev.akarah.quantized.api.registry;
    exports dev.akarah.quantized.api.scheduler;
    exports dev.akarah.quantized.api.util;
}