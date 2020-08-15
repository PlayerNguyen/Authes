package com.playernguyen;

import com.playernguyen.account.AccountManager;
import com.playernguyen.account.SQLAccountManager;
import com.playernguyen.account.SessionManager;
import com.playernguyen.config.AuthesConfiguration;
import com.playernguyen.config.AuthesLanguage;
import com.playernguyen.config.ConfigurationFlag;
import com.playernguyen.listener.ListenerManager;
import com.playernguyen.listener.PlayerInteractListener;
import com.playernguyen.listener.PlayerJoinListener;
import com.playernguyen.listener.PlayerMoveListener;
import com.playernguyen.sql.MySQLEstablishment;
import com.playernguyen.sql.SQLEstablishment;
import com.playernguyen.util.MySQLUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Authes extends JavaPlugin {

    private static Authes instance;
    private AuthesConfiguration configuration;
    private SQLEstablishment establishment;
    private SQLAccountManager SQLAccountManager;
    private ListenerManager listenerManager;
    private AccountManager accountManager;
    private SessionManager sessionManager;
    private AuthesLanguage authesLanguage;

    @Override
    public void onEnable() {
        instance = this;
        // Set up file
        setupConfiguration();
        // Set up the connection
        setupConnection();
        // Set up accounts
        setupAccount();
        // Set up listener
        setupListener();
        // Session
        setupSession();
    }

    private void setupSession() {
        sessionManager = new SessionManager();
    }

    private void setupAccount() {
        this.SQLAccountManager = new SQLAccountManager();
        this.accountManager = new AccountManager();
    }

    private void setupConfiguration() {
        try {
            this.configuration = new AuthesConfiguration();
            this.authesLanguage = new AuthesLanguage();
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
        // Hit the tester & handle table
        this.getLogger().info("Connecting to the MySQL server...");
        try (Connection connection = getEstablishment().openConnection()) {
            this.getLogger().info("Success connect to the MySQL server");
            // Initial the table
            // If not found account table. Initial one
            if (!MySQLUtil.hasTable(connection, getConfiguration().getString(ConfigurationFlag.MYSQL_TABLE_ACCOUNT))) {
                this.getLogger().info("Not found account table. Create the new one...");
                // Create account table. Which storage all players information
                PreparedStatement preparedStatement = connection.prepareStatement(String.format(
                        "CREATE TABLE `%s` (`id` INT(32) NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                                "`username` VARCHAR(255) NOT NULL," +
                                "`uuid` VARCHAR(255) NOT NULL," +
                                "`hash` VARCHAR(255) NOT NULL," +
                                "`email` VARCHAR(255) NOT NULL);",
                        getConfiguration().getString(ConfigurationFlag.MYSQL_TABLE_ACCOUNT)
                ));
                // Execute
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            this.getLogger().severe("SQLException. Disable...StackTrace: ");
            e.printStackTrace();
            // catch error and disable plugin
            this.getPluginLoader().disablePlugin(this);
        }

    }

    private void setupListener() {
        this.listenerManager = new ListenerManager();
        // Append event here
        getListenerManager().add(new PlayerJoinListener());
        getListenerManager().add(new PlayerMoveListener());
        getListenerManager().add(new PlayerInteractListener());
        // Register listener
        getListenerManager().forEach(e
                -> Bukkit.getServer().getPluginManager().registerEvents(e, this));
    }

    public ListenerManager getListenerManager() {
        return listenerManager;
    }

    public SQLAccountManager getSQLAccountManager() {
        return SQLAccountManager;
    }

    public AuthesConfiguration getConfiguration() {
        return configuration;
    }

    public AccountManager getAccountManager() {
        return accountManager;
    }

    public SessionManager getSessionManager() {
        return sessionManager;
    }

    public SQLEstablishment getEstablishment() {
        return establishment;
    }

    public AuthesLanguage getLanguage() {
        return authesLanguage;
    }

    public static Authes getInstance() {
        return instance;
    }
}
