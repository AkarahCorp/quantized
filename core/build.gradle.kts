plugins {
    id("java")
    id("org.javamodularity.moduleplugin") version "1.8.15"
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

java {
    modularity.inferModulePath.set(true)
}