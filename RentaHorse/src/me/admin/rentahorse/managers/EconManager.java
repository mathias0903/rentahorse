package me.admin.rentahorse.managers;

import me.admin.rentahorse.Core;
import org.bukkit.entity.Player;

import java.util.HashMap;

/**
 * RentaHorse started
 */
public class EconManager {

    private static Core core;
    public EconManager(Core instance){
        core = instance;
    }

    public static HashMap<String, Double> bal = new HashMap<>(); //PLAYER, BALANCE

    public static void setBalance(String player, double amount){
        bal.put(player, amount);
    }

    public static Double getBalance(String player){
        return bal.get(player);
    }

    public static boolean hasAccount(String player){
        return bal.containsKey(player);
    }

    public static HashMap<String, Double> getBalanceMap(){
        return bal;
    }

    public static Core getPlugin(){
        return core;
    }




}
