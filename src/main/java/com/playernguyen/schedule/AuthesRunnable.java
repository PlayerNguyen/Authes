package com.playernguyen.schedule;

import com.playernguyen.Authes;
import com.playernguyen.config.AuthesConfiguration;
import com.playernguyen.config.AuthesLanguage;
import org.bukkit.scheduler.BukkitRunnable;

public abstract class AuthesRunnable extends BukkitRunnable {

    public Authes getInstance() {
        return Authes.getInstance();
    }

    public AuthesConfiguration getConfiguration() {
        return this.getInstance().getConfiguration();
    }

    public AuthesLanguage getLanguage() {
        return this.getInstance().getLanguage();
    }

}
