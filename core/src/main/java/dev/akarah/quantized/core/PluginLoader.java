package dev.akarah.quantized.core;

import dev.akarah.quantized.api.plugin.Plugin;
import dev.akarah.quantized.api.registry.BuiltInRegistries;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;
import java.util.jar.JarFile;

public class PluginLoader {
    public static void loadAllJars() throws IOException {
        var pluginDirectory = Paths.get("./quantized/plugin/");

        var jarFiles = new ArrayList<Path>();
        try(var stream = Files.walk(pluginDirectory)) {
            stream.forEach(path -> {
                if(path.getFileName().toString().endsWith(".jar")) {
                    jarFiles.add(path);
                }
            });
        }

        for(var jar : jarFiles) {
            try(var classLoader = new URLClassLoader(new URL[]{jar.toUri().toURL()}, PluginLoader.class.getClassLoader());
                var jarFile = new JarFile(jar.toFile())) {
                    jarFile.stream().forEach(jarEntry -> {
                        var rawClassFileName = jarEntry.getName();
                        if(rawClassFileName.endsWith(".class") && !rawClassFileName.contains("module-info")) {
                            var rawClassName = rawClassFileName.replace(".class", "")
                                    .replace("/", ".");
                            System.out.println("Loading class " + rawClassName);
                            try {
                                var clazz = classLoader.loadClass(rawClassName);
                                var interfaces = new ArrayList<>(List.of(clazz.getInterfaces()));
                                if(interfaces.contains(Plugin.class)) {
                                    var constructor = clazz.getConstructor();
                                    var instance = (Plugin) constructor.newInstance();

                                    BuiltInRegistries.PLUGIN.register(instance.name(), instance);
                                    instance.load();
                                }
                            } catch (ClassNotFoundException | InvocationTargetException | NoSuchMethodException |
                                     IllegalAccessException | InstantiationException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    });
            }
        }
    }
}
