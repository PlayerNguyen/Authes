package com.playernguyen;

import com.playernguyen.config.AuthesConfiguration;
import com.playernguyen.config.ConfigurationFlag;
import com.playernguyen.sql.MySQLEstablishment;
import com.playernguyen.sql.SQLEstablishment;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

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
        // Set up
        try {
            this.establishment = new MySQLEstablishment(
                    getConfiguration().getString(ConfigurationFlag.MYSQL_HOST),
                    getConfiguration().getString(ConfigurationFlag.MYSQL_USERNAME),
                    getConfiguration().getString(ConfigurationFlag.MYSQL_PASSWORD),
                    getConfiguration().getString(ConfigurationFlag.MYSQL_DATABASE),
                    getConfiguration().getString(ConfigurationFlag.MYSQL_PORT)
            );
        } catch (ClassNotFoundException e) {
            this.getLogger().severe("Not found driver class of MySQL...");
            e.printStackTrace();
        }
        // Hit the tester
        this.getLogger().info("Connecting to the MySQL server...");
        try (Connection connection = getEstablishment().openConnection()) {
            this.getLogger().info("Success connect to the MySQL server");
        } catch (SQLException e) {
            this.getLogger().severe("Cannot connect to the MySQL server. StackTrace: ");
            e.printStackTrace();
        }
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
