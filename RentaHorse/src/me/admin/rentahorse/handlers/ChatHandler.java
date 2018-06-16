package me.admin.rentahorse.handlers;

import org.bukkit.ChatColor;

/**
 * RentaHorse started
 */
public class ChatHandler {

    public static String notOwner(){
        return ChatColor.RED + "You are not the owner of this horse, so you can't ride it!";
    }


    public static String stableSet(){
        return ChatColor.GREEN + "The Stable has been successfully been set!";
    }

    public static String signCreated(){
    return ChatColor.GREEN + "Horse Sign created by player!";
    }

    public static String noPerm(){
        return ChatColor.RED + "You do not have permission to do this!";

    }
    public static String signBroken() {
        return ChatColor.GOLD + "Horse Sign removed";
    }
}
