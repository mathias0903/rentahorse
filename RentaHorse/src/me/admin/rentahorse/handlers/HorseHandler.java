package me.admin.rentahorse.handlers;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * RentaHorse started
 */
public class HorseHandler {

    public static void addLevelOneHorse(Player player) {

        Horse horse = player.getWorld().spawn(player.getLocation(), Horse.class);

        horse.setAdult();
        horse.isCustomNameVisible();
        horse.setCustomName(ChatColor.GOLD + player.getName() + ChatColor.GOLD + "'s" + ChatColor.GREEN + " L1 horse");

        horse.getInventory().setSaddle(new ItemStack(Material.SADDLE));

        horse.setOwner(player);

        player.sendMessage(ChatColor.GOLD + "Level one" + ChatColor.GREEN + " horse spawned! You are now the owner!");
    }

    public static void addLevelTwoHorse(Player player) {

        Horse horse = player.getWorld().spawn(player.getLocation(), Horse.class);

        horse.setAdult();
        horse.isCustomNameVisible();
        horse.setCustomName(ChatColor.GOLD + player.getName() + ChatColor.GOLD + "'s" + ChatColor.GREEN + " L2 horse");

        horse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
        horse.getInventory().setArmor(new ItemStack(Material.GOLD_BARDING));

        horse.setOwner(player);

        player.sendMessage(ChatColor.GOLD + "Level two" + ChatColor.GREEN + " horse spawned! You are now the owner!");
    }

    public static void addLevelThreeHorse(Player player) {

        Horse horse = player.getWorld().spawn(player.getLocation(), Horse.class);

        horse.setAdult();
        horse.isCustomNameVisible();
        horse.setCustomName(ChatColor.GOLD + player.getName() + ChatColor.GOLD + "'s" + ChatColor.GREEN + " L3 horse");


        horse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
        horse.getInventory().setArmor(new ItemStack(Material.IRON_BARDING));

        horse.setOwner(player);

        player.sendMessage(ChatColor.GOLD + "Level three" + ChatColor.GREEN + " horse spawned! You are now the owner!");
    }

    public static void addLevelFourHorse(Player player) {

        Horse horse = player.getWorld().spawn(player.getLocation(), Horse.class);

        horse.setAdult();
        horse.isCustomNameVisible();
        horse.setCustomName(ChatColor.GOLD + player.getName() + ChatColor.GOLD + "'s" + ChatColor.GREEN + " L4 horse");

        horse.setOwner(player);

        horse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
        horse.getInventory().setArmor(new ItemStack(Material.DIAMOND_BARDING));

        player.sendMessage(ChatColor.GOLD + "Level four" + ChatColor.GREEN + " horse spawned! You are now the owner!");


    }
}
