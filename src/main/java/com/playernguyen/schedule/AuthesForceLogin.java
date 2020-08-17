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
            if (getAccountManager().getAccountFromUUID(getPlayer().getUniqueId()) == null) {
                this.cancel();
                return;
            }
            // Handle information of login/register
            if (!getAccountManager().getAccountFromUUID(getPlayer().getUniqueId()).isRegistered()) {
                // Anti spam
                if (ticker % 2 == 0) {
                    this.getPlayer().sendMessage(getLanguage().get(LanguageFlag.REQUIRE_REGISTER));
                    return;
                }
            } else if (!getSessionManager().hasSession(player.getUniqueId())) {
                if (ticker % 2 == 0) {
                    this.getPlayer().sendMessage(getLanguage().get(LanguageFlag.REQUIRE_LOGIN));
                    return;
                }
            } else {
                this.cancel();
                this.getPlayer().sendMessage(getLanguage().get(LanguageFlag.LOGIN_SUCCESS));
                return;
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
