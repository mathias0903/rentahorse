package me.admin.rentahorse.handlers;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * RentaHorse started
 */
public class ChatHandler {

    public static String signCreated(Player p){
     p.sendMessage(ChatColor.GREEN + "Horse Sign created by player!");
        return null;
    }

    public static String noPerm(CommandSender sender){
        sender.sendMessage(ChatColor.RED + "You do not have permission to do this!");
        return null;
    }

    public static String pluginReloaded(CommandSender sender){
        sender.sendMessage(ChatColor.GREEN + "Plugin reloaded successfully!");
        return null;
    }
}
