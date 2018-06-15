package me.admin.rentahorse;

import me.admin.rentahorse.listeners.SignCreate;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * RentaHorse started
 */
public class Core extends JavaPlugin implements Listener {

    private static Core core;

    public void onEnable(){

        registerEvents(this, new SignCreate());
    }

    public void onDisable(){

    }

    public static Core getPlugin(){
        return core;
    }

    public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }


}
