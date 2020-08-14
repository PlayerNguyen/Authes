package com.playernguyen;

import com.playernguyen.config.AuthesConfiguration;
import com.playernguyen.sql.MySQLEstablishment;
import com.playernguyen.sql.SQLEstablishment;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class Authes extends JavaPlugin {

    private static Authes instance;
    private AuthesConfiguration configuration;
    private SQLEstablishment establishment;

    @Override
    public void onEnable() {
        instance = this;
        // Set up file
        setupConfiguration();
        // Set up the connection
        setupConnection();
    }

    private void setupConfiguration() {
        try {
            this.configuration = new AuthesConfiguration();
        } catch (IOException e) {
            this.getLogger().severe("Cannot saving config.yml...");
            e.printStackTrace();
        }

    }

    private void setupConnection() {
        this.establishment = new MySQLEstablishment();
    }

    protected AuthesConfiguration getConfiguration() {
        return configuration;
    }

    protected SQLEstablishment getEstablishment() {
        return establishment;
    }

    protected static Authes getInstance() {
        return instance;
    }
}
