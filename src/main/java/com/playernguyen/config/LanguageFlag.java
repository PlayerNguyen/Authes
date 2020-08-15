package com.playernguyen.config;

public enum LanguageFlag {

    REQUIRE_REGISTER("require-register", "Please register by using /register <password> <confirmPassword>"),
    REQUIRE_LOGIN("require-login", "Please login by using /login <password>"),

    KICK_REASON("kick-reason", "You has been kicked because not register/login"),
    NO_PERMISSION_COMMAND("no-permission-command", "You has no permission to do this"),
    ALREADY_REGISTERED("already-registered", "You are ready registered!"),
    MISSING_REGISTER_COMMAND("missing-register-command", "Missing arguments: /register <password> <confirmPassword>")
    ;

    private final String path;
    private final Object declare;

    LanguageFlag(String path, Object declare) {
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
