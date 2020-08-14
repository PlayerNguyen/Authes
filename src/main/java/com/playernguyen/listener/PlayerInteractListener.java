package com.playernguyen.listener;

import com.playernguyen.AuthesInstance;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener extends AuthesInstance implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (!getAccountManager().getAccountFromUUID(player.getUniqueId()).isRegistered()) {

            event.setCancelled(true);
        }
    }
}
