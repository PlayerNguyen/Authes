package com.playernguyen.schedule;

import com.playernguyen.config.ConfigurationFlag;
import com.playernguyen.config.LanguageFlag;
import org.bukkit.entity.Player;

public class AuthesForceLogin extends AuthesRunnable {

    private int ticker;
    private final Player player;

    public AuthesForceLogin(Player player) {
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
            // Handle information of login/register
            if (!getAccountManager().getAccountFromUUID(getPlayer().getUniqueId()).isRegistered()) {
                this.getPlayer().sendMessage(getLanguage().get(LanguageFlag.REQUIRE_REGISTER));
            } else if (!getSessionManager().hasSession(player.getUniqueId())) {
                this.getPlayer().sendMessage(getLanguage().get(LanguageFlag.REQUIRE_LOGIN));
            } else {
                this.getPlayer().sendMessage(getLanguage().get(LanguageFlag.LOGIN_SUCCESS));
                this.cancel();
            }

            // If out of time (idle), kick player
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
