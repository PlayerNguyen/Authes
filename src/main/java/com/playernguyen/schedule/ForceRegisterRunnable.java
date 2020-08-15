package com.playernguyen.schedule;

import com.playernguyen.config.ConfigurationFlag;
import com.playernguyen.config.LanguageFlag;
import org.bukkit.entity.Player;

public class ForceRegisterRunnable extends AuthesRunnable {

    private int ticker;
    private final Player player;

    public ForceRegisterRunnable(Player player) {
        this.player = player;
        this.ticker = getConfiguration().getInt(ConfigurationFlag.KICK_AFTER_LOGIN);
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public void run() {
        this.ticker --;
        if (player != null) {
            this.getPlayer().sendMessage(getLanguage().get(LanguageFlag.REQUIRE_REGISTER));
            // If out of time, kick player
            if (ticker <= 0) {
                this.getPlayer().kickPlayer(this.getLanguage().get(LanguageFlag.KICK_REASON));
                // Cancel the task too
                this.cancel();
            }
        } else {
            this.cancel();
        }
    }
}
