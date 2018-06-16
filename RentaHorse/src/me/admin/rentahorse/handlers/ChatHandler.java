package me.admin.rentahorse.handlers;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

/**
 * RentaHorse started
 */
public class ChatHandler {

    public static String signCreated(){
    return ChatColor.GREEN + "Horse Sign created by player!";
    }

    public static String noPerm(){
        return ChatColor.RED + "You do not have permission to do this!";

    }

    public static String pluginReloaded(){
        return ChatColor.GREEN + "Plugin reloaded successfully!";
    }
}
