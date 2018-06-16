package me.admin.rentahorse.listeners;

import me.admin.rentahorse.handlers.ChatHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

/**
 * RentaHorse started
 */
public class SignCreate implements Listener {

    @EventHandler
    public void onSignCreate(SignChangeEvent event) {
        if (event.getPlayer().hasPermission("horse.signcreate")) {
            if (event.getLine(0).equalsIgnoreCase("[HORSE]")) {
                event.setLine(0, ChatColor.DARK_PURPLE + "[HORSE]");
                event.getPlayer().sendMessage(ChatHandler.signCreated());
            }
            if (event.getLine(0).equalsIgnoreCase(ChatColor.DARK_PURPLE + "[HORSE]")) {
                if (event.getLine(1).isEmpty()) {
                    event.setLine(1, ChatColor.GOLD + "Level: " + ChatColor.RED + "\"1 -4\"");
                }
                if (event.getLine(2).isEmpty()) {
                    event.setLine(2, ChatColor.GOLD + "Price: " + ChatColor.RED + "\"Integer\"");
                    return;
                }

                if (!(event.getLine(1).isEmpty())) {
                    event.setLine(1, ChatColor.GOLD + "Level " + ChatColor.GRAY + ": " + ChatColor.GREEN + event.getLine(1));
                }
                if (!(event.getLine(2).isEmpty())) {
                    event.setLine(2, ChatColor.GOLD + "Price " + ChatColor.GRAY + ": " + ChatColor.GREEN + "£" + ChatColor.GREEN + event.getLine(2));
                }
                if (!(event.getLine(1).isEmpty() && event.getLine(2).isEmpty())) {
                    for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                        if (p.hasPermission("horse.notify")) {
                            if (!(p.equals(event.getPlayer()))) {
                                p.sendMessage(ChatColor.GOLD + event.getPlayer().getName() + " has just created a horse sign!");
                            }
                        }
                    }
                }

            }

        } else {
            event.getPlayer().sendMessage(ChatHandler.noPerm());
        }
    }

}

