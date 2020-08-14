package com.playernguyen.config;

public enum LanguageFlag {

    REQUIRE_REGISTER("require-register", "Please register by using /login <password> <confirmPassword>"),
    REQUIRE_LOGIN("require-login", "Please login by using /login <password>"),
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
