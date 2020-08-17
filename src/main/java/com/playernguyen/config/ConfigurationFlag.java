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
    LOGIN_AFTER_REGISTER("settings.login-after-register", true),

    EMAIL_SMTP_AUTH("settings.email.smtp.auth", true),
    EMAIL_SMTP_TSL("settings.email.smtp.tsl.enable", true),
    EMAIL_SMTP_HOST("settings.email.smtp.host", "smtp.mailtrap.io"),
    EMAIL_SMTP_PORT("settings.email.smtp.port", "25"),
    EMAIL_SMTP_SSL_TRUST("settings.email.smtp.ssl.enable", "smtp.mailtrap.io"),
    EMAIL_SMTP_USERNAME("settings.email.smtp.auth.username", ""),
    EMAIL_SMTP_PASSWORD("settings.email.smtp.auth.password", ""),

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
