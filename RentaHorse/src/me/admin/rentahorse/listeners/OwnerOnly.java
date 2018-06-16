package me.admin.rentahorse.listeners;

import me.admin.rentahorse.handlers.ChatHandler;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.spigotmc.event.entity.EntityMountEvent;

/**
 * RentaHorse started
 */
public class OwnerOnly implements Listener {

    @EventHandler
    public void onEntityMountEvent(EntityMountEvent event) {
        if (event.getMount() instanceof Horse) {
            Horse horse = (Horse) event.getMount();

            if(!(event.getEntity().equals(horse.getOwner()))){
                    event.setCancelled(true);
                    event.getEntity().sendMessage(ChatHandler.notOwner());
            }
        }
    }
}
