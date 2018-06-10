package me.admin.rentahorse.listeners;

import me.admin.rentahorse.managers.EconManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * RentaHorse started
 */
public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        if(EconManager.hasAccount(event.getPlayer().getName())) return;
        EconManager.setBalance(event.getPlayer().getName(), 200D);
    }
}
