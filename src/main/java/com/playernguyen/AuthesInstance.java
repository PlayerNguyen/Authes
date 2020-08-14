package com.playernguyen;

import com.playernguyen.account.AccountManager;
import com.playernguyen.account.SQLAccountManager;
import com.playernguyen.account.SessionManager;
import com.playernguyen.config.AuthesConfiguration;
import com.playernguyen.config.AuthesLanguage;
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

    protected SQLAccountManager getSQLAccountManager() {
        return getInstance().getSQLAccountManager();
    }

    protected SessionManager getSessionManager() {
        return getInstance().getSessionManager();
    }

    protected AuthesLanguage getLanguage() {
        return getInstance().getLanguage();
    }

}
