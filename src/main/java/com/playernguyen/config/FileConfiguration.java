package com.playernguyen.config;

import com.playernguyen.AuthesInstance;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class FileConfiguration extends AuthesInstance {

    private final File file;
    private final YamlConfiguration fileConfiguration;

    public FileConfiguration() {
        // Load configuration
        this.file = new File(getInstance().getDataFolder(), "config.yml");
        // Load configuration
        this.fileConfiguration = YamlConfiguration.loadConfiguration(file);
        // Valuable set defaut
        for (ConfigurationFlag value : ConfigurationFlag.values()) {
            if (!fileConfiguration.contains(value.getPath())) {
                // Set
                this.fileConfiguration.set(value.getPath(), value.getDeclare());
            }
        }
    }

    public File getFile() {
        return file;
    }

    public YamlConfiguration getFileConfiguration() {
        return fileConfiguration;
    }

    public Object getByFlag(ConfigurationFlag flag) {
        return getFileConfiguration().get(flag.getPath());
    }

}
