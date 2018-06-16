package me.admin.rentahorse.listeners;

import me.admin.rentahorse.handlers.ChatHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

/**
 * RentaHorse started
 */
public class SignBreak implements Listener {

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event) {
        if (event.getBlock().getState() instanceof Sign) {
            Sign sign = (Sign) event.getBlock().getState();
            if (sign.getLine(0).equalsIgnoreCase(ChatColor.DARK_PURPLE + "[HORSE]")) {
                if (event.getPlayer().hasPermission("horse.signremove")) {
                    event.getPlayer().sendMessage(ChatHandler.signBroken());

                    for(Player p : Bukkit.getServer().getOnlinePlayers()){
                        if(p.hasPermission("horse.notify")){
                            p.sendMessage(ChatColor.GOLD + event.getPlayer().getName() + " has just removed a horse sign!");
                        }else{
                            return;
                        }
                    }
                } else {
                    event.getPlayer().sendMessage(ChatHandler.noPerm() + ChatColor.GOLD + " You are not allowed to break signs!");
                    event.setCancelled(true);
                }
            }
        }
    }
}
