package me.admin.rentahorse;

import me.admin.rentahorse.apis.SLAPI;
import me.admin.rentahorse.commands.EconCommand;
import me.admin.rentahorse.listeners.PlayerJoinListener;
import me.admin.rentahorse.managers.EconManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * RentaHorse started
 */
public class Core extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("rentaleconomy").setExecutor(new EconCommand());
        new EconManager(this);

        SLAPI.loadBalances();

        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
    }

    @Override
    public void onDisable() {
        SLAPI.saveBalances();
    }
}
