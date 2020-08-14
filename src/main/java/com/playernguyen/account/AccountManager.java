package com.playernguyen.account;

import com.playernguyen.manager.ManagerList;

import java.util.UUID;

public class AccountManager extends ManagerList<Account> {

    public Account getAccountFromUUID (UUID uuid) {
        for (Account account : getContainer()) {
            if (account.getUniqueId().equals(uuid)) return account;
        }
        return null;
    }

}
