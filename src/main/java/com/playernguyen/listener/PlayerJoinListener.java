package com.playernguyen.listener;

import com.playernguyen.AuthesInstance;
import com.playernguyen.schedule.ForceRegisterRunnable;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener extends AuthesInstance implements Listener {

    @EventHandler
    public void onPlayerJoinListen(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        // Put into AccountManager
        getAccountManager().add(getSQLAccountManager().getAccount(p.getUniqueId()));
        // Create new task
        Bukkit.getScheduler().runTaskTimer(getInstance(), new ForceRegisterRunnable(p), 20, 20);

    }

}
