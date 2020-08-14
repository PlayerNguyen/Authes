package com.playernguyen;

import com.playernguyen.config.AuthesConfiguration;
import com.playernguyen.config.ConfigurationFlag;
import com.playernguyen.sql.MySQLEstablishment;
import com.playernguyen.sql.SQLEstablishment;
import com.playernguyen.util.MySQLUtil;
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
        // Set up the connection
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
            // Initial the table
            // If not found account table. Initial one
            if (!MySQLUtil.hasTable(connection, getConfiguration().getString(ConfigurationFlag.MYSQL_TABLE_ACCOUNT))) {
                this.getLogger().info("Not found account table. Create the new one...");
                // Create account table. Which storage all players information
                connection.prepareStatement("CREATE TABLE (`id` INT(32) NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                        "`username` VARCHAR(255) NOT NULL," +
                        "`uuid` VARCHAR(255) NOT NULL," +
                        "`hash` VARCHAR(255) NOT NULL," +
                        "`email` VARCHAR(255) NOT NULL);")
                ;
            }
        } catch (SQLException e) {
            this.getLogger().severe("SQLException...StackTrace: ");
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
