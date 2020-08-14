package com.playernguyen.account;

import org.mindrot.jbcrypt.BCrypt;

import java.util.UUID;

public class UserAccount implements Account {

    private final UUID uniqueId;
    private final boolean isRegistered;
    private String hash;

    public UserAccount(UUID uniqueId, boolean isRegistered) {
        this.uniqueId = uniqueId;
        this.isRegistered = isRegistered;
    }

    public UserAccount(UUID uniqueId, boolean isRegistered, String hash) {
        this.uniqueId = uniqueId;
        this.isRegistered = isRegistered;
        this.hash = hash;
    }

    @Override
    public UUID getUniqueId() {
        return uniqueId;
    }

    @Override
    public boolean validate(String password) {
        return BCrypt.checkpw(password, hash);
    }

    @Override
    public boolean isRegistered() {
        return isRegistered;
    }
}
