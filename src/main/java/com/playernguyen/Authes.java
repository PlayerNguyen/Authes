package com.playernguyen;

import org.bukkit.plugin.java.JavaPlugin;

public class Authes extends JavaPlugin {

    private static Authes instance;

    @Override
    public void onEnable() {
        instance = this;
    }

    private void setupTable() {

    }

    protected static Authes getInstance() {
        return instance;
    }
}
