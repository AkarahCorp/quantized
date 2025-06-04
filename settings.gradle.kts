rootProject.name = "quantized"

include("api")
include("core")
include("fabric")
include("example-plugin")

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven { url = uri("https://maven.fabricmc.net/") }
    }
}