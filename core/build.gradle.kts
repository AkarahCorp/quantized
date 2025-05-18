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
    compileOnly(project(":api"))
    compileOnly("com.mojang:datafixerupper:8.0.16")
}

tasks.test {
    useJUnitPlatform()
}