package com.playernguyen.account;

import com.playernguyen.AuthesInstance;
import com.playernguyen.config.ConfigurationFlag;
import com.playernguyen.util.ResultFetcher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class AccountManager extends AuthesInstance {

    private final String tableName;

    public AccountManager() {
        this.tableName = getConfiguration().getString(ConfigurationFlag.MYSQL_TABLE_ACCOUNT);
    }

    /**
     * Check that player found or not
     * @param uuid The uuid of player
     * @return Whether player are existed or not
     */
    public boolean hasPlayer(UUID uuid) {
        try (Connection connection = getEstablishment().openConnection()) {
            // Prepare statement
            PreparedStatement preparedStatement = connection.prepareStatement(String.format(
                    "SELECT * FROM `%s` WHERE `uuid`=?",
                    tableName
            ));
            // Parameter define
            preparedStatement.setString(1, uuid.toString());
            // Execute query
            ResultSet resultSet = preparedStatement.executeQuery();
            // Fetch
            return new ResultFetcher(resultSet).size() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Account getAccount(UUID uuid) {
        try (Connection connection = getEstablishment().openConnection()) {
            // New member
            if (!hasPlayer(uuid)) {
                return new UserAccount(uuid, false);
            }
            // The old one
            PreparedStatement statement = connection.prepareStatement(String.format(
                    "SELECT * FROM `%s` WHERE `uuid`=?",
                    tableName
            ));
            // Parameter set
            statement.setString(1, uuid.toString());
            // Fire in a hole & get hash
            ResultSet resultSet = statement.executeQuery();
            String hash = (String) new ResultFetcher(resultSet).first().get("hash");
            return new UserAccount(uuid, true, hash);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
