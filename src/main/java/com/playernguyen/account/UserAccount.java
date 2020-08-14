package com.playernguyen.account;

import java.util.UUID;

public class UserAccount implements Account {

    private final UUID uniqueId;

    public UserAccount(UUID uniqueId) {
        this.uniqueId = uniqueId;
    }

    @Override
    public UUID getUniqueId() {
        return uniqueId;
    }

    @Override
    public boolean validPassword(String password) {
        return false;// TODO: put this function into work :)
    }
}
