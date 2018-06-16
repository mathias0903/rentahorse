package me.admin.rentahorse.listeners;

import me.admin.rentahorse.handlers.ChatHandler;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

/**
 * RentaHorse started
 */
public class SignCreate implements Listener{

    @EventHandler
    public void onSignCreate(SignChangeEvent event){
        if(event.getPlayer().hasPermission("horse.signcreate")) {
            if (event.getLine(0).equalsIgnoreCase("[HORSE]")) {
                event.setLine(0, ChatColor.DARK_PURPLE + "[HORSE]");
                event.getPlayer().sendMessage(ChatHandler.signCreated());
            }
            if(event.getLine(1).isEmpty()){
                event.getPlayer().sendMessage("1");
            }
        }else{
            event.getPlayer().sendMessage(ChatHandler.noPerm());
        }

    }
}
