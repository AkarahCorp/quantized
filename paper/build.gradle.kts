plugins {
    id("java")
    id("xyz.jpenilla.run-paper") version "2.3.1"
    id("io.papermc.paperweight.userdev") version "2.0.0-beta.14"
    id("org.javamodularity.moduleplugin") version "1.8.15"
}

group = "dev.akarah"
version = "unspecified"

repositories {
    mavenCentral()

    maven {
        name = "papermc-repo"
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }

    maven {
        name = "sonatype"
        url = uri("https://oss.sonatype.org/content/groups/public/")
    }
}

dependencies {
    paperweight.paperDevBundle("1.21.5-R0.1-SNAPSHOT")

    implementation(project(":api"))
    implementation(project(":core"))
    implementation("com.mojang:datafixerupper:8.0.16")
}

tasks {
    runServer {
        minecraftVersion("1.21.5")
    }

    register("prepareKotlinBuildScriptModel") {}
}

java {
    modularity.inferModulePath.set(true)
}
