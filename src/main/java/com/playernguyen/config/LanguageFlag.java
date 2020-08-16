package com.playernguyen.config;

public enum LanguageFlag {

    REQUIRE_REGISTER("require-register", "&cPlease register by using /register <password> <confirmPassword>"),
    REQUIRE_LOGIN("require-login", "&cPlease login by using /login <password>"),
    KICK_REASON("kick-reason", "&cYou has been kicked because not register/login"),
    NO_PERMISSION_COMMAND("no-permission-command", "&cYou has no permission to do this"),
    ALREADY_REGISTERED("already-registered", "&cYou are ready registered!"),
    MISSING_REGISTER_COMMAND("missing-register-command", "&cMissing arguments: &6/register <password> <confirmPassword>"),
    NOT_MATCH_REGISTER("no-match-register", "&cPassword doesn't match with confirm password"),
    REGISTER_SUCCESS("register-success", "&aRegister success."),
    REGISTER_FAILED("register-failed", "&cFailed to register."),
    INVALID_SENDER("invalid-sender", "&cYou cannot use this command on console/remote!"),
    NOT_REGISTER("not-register", "&cYou aren't register yet. Using &6/register <password> <confirmPassword>"),
    MISSING_LOGIN_COMMAND("missing-login-command", "&cMissing arguments: &6/login <password>"),
    LOGIN_SUCCESS("login-success", "&aLogin success"),
    LOGIN_FAIL("login-fail", "&cLogin fail!"),
    WRONG_PASSWORD("wrong-password", "&cWrong password. Please try again!"),
    PASSWORD_TOO_SHORT("password-too-short", "&cYour password is too short, please try again with logger password")
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
