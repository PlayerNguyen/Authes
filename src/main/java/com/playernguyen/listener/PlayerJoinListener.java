package com.playernguyen.listener;

import com.playernguyen.AuthesInstance;
import com.playernguyen.account.Account;
import com.playernguyen.schedule.AuthesForceLogin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerJoinListener extends AuthesInstance implements Listener {

    @EventHandler
    public void onPlayerJoinListen(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        // Put into AccountManager
        Account account = getSQLAccountManager().getAccount(p.getUniqueId());
        getAccountManager().add(account);

        getInstance().getLogger().info(String.format(
                "Player %s (%s), registered: %s",
                p.getName(), p.getUniqueId(), (account.isRegistered()) ? "Yes":"No"
        ));
        // Create new task to force player :)
        BukkitRunnable runnable = new AuthesForceLogin(p);
        runnable.runTaskTimer(getInstance(), 20, 20);

    }

}
