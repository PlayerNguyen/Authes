package com.playernguyen.sql;

import java.sql.Connection;

public class MySQLEstablishment implements SQLEstablishment {

    private final String host;
    private final String username;
    private final String password;
    private final String database;

    public MySQLEstablishment(String host, String username, String password, String database) {
        this.host = host;
        this.username = username;
        this.password = password;
        this.database = database;
    }



    public Connection openConnection() {
        return null;
    }
}
