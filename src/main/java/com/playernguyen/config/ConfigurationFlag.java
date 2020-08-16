package com.playernguyen.config;

public enum ConfigurationFlag {

    MYSQL_HOST("mysql.host", "localhost"),
    MYSQL_USERNAME("mysql.username", "nguyen"),
    MYSQL_PASSWORD("mysql.password", ""),
    MYSQL_DATABASE("mysql.database", "authes"),
    MYSQL_PORT("mysql.port", "3306"),
    MYSQL_TABLE_ACCOUNT("mysql.table.account", "authes_account"),
    OPTIONAL_BCRYPT_SALT ("settings.bcrypt.salt-round", 7),
    PASSWORD_MIN_SIZE("settings.password-min-size", 6),
    KICK_AFTER_LOGIN("settings.kick-after-login", 15),
    LOGIN_AFTER_REGISTER("settings.login-after-register", true)
    ;

    private final String path;
    private final Object declare;

    ConfigurationFlag(String path, Object declare) {
        this.path = path;
        this.declare = declare;
    }

    public String getPath() {
        return path;
    }

    public Object getDeclare() {
        return declare;
    }
}
