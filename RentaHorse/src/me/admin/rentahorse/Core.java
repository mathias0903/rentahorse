package me.admin.rentahorse;

import me.admin.rentahorse.commands.SetStable;
import me.admin.rentahorse.listeners.*;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.Bukkit.getServer;

/**
 * RentaHorse started
 */
public class Core extends JavaPlugin implements Listener {

    private static Core core;

    public void onEnable() {

        setupEconomy();


        registerEvents(this, new SignCreate(), new SignClick(this), new SignBreak(), new PlayerLeave(this), new OwnerOnly());

        getCommand("setstable").setExecutor(new SetStable(this));
    }

    public void onDisable() {

        saveConfig();

    }

    public static Core getPlugin() {
        return core;
    }

    public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }

    public static Economy economy = null;

    private boolean setupEconomy() {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }
}

