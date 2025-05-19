module quantized.example.plugin.main {
    requires dev.akarah.quantized.api;

    provides dev.akarah.quantized.api.plugin.Plugin with dev.akarah.quantized.example.Main;
}