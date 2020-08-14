package com.playernguyen;

import com.playernguyen.account.AccountManager;
import com.playernguyen.config.AuthesConfiguration;
import com.playernguyen.sql.SQLEstablishment;

public abstract class AuthesInstance {

    protected Authes getInstance() {
        return Authes.getInstance();
    }

    protected AuthesConfiguration getConfiguration() {
        return getInstance().getConfiguration();
    }

    protected SQLEstablishment getEstablishment() {
        return getInstance().getEstablishment();
    }

    protected AccountManager getAccountManager() {
        return getInstance().getAccountManager();
    }

}
