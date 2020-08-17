package com.playernguyen.listener;

import com.playernguyen.AuthesInstance;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener extends AuthesInstance implements Listener {

    @EventHandler
    public void onMoveListen(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (!getAccountManager().getAccountFromUUID(player.getUniqueId()).isRegistered()
            || !getSessionManager().hasSession(player.getUniqueId())) {
            event.setCancelled(true);
        }
    }
}
