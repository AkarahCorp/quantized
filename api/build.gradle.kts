plugins {
    id("java")
}

group = "dev.akarah"
version = "unspecified"

repositories {
    mavenCentral()

    maven {
        url = uri("https://libraries.minecraft.net")
    }
}

dependencies {
    compileOnly("com.mojang:datafixerupper:8.0.16")
}