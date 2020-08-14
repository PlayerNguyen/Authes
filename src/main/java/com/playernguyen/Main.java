package com.playernguyen;

import com.playernguyen.sql.MySQLEstablishment;
import com.playernguyen.sql.SQLEstablishment;
import com.playernguyen.util.MySQLUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        SQLEstablishment sqlEstablishment =
                new MySQLEstablishment("localhost", "nguyen", "", "authes", "3306");

        try (Connection c = sqlEstablishment.openConnection();) {
            PreparedStatement execution = c.prepareStatement("SHOW TABLES;");
            ResultSet resultSet = execution.executeQuery();

            System.out.println(MySQLUtil.hasTable(c, "demo"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
