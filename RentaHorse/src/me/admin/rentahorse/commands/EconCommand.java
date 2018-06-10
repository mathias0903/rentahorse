package me.admin.rentahorse.commands;

import me.admin.rentahorse.managers.EconManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * RentaHorse started
 */
public class EconCommand implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command command, String commandlabel, String[] args) {
        if (commandlabel.equalsIgnoreCase("rentaleconomy")) {
            if (args.length != 3) {
                sender.sendMessage(ChatColor.RED + "Incorrect Syntax!");
                sender.sendMessage(ChatColor.GREEN + "Usage: /econ <add/remove/set> <player> <amount>");
                return true;
            }
            if (args[0].equalsIgnoreCase("add")) {
                if (!(EconManager.hasAccount(args[1]))) {
                    sender.sendMessage(ChatColor.RED + "Error: Player does not have an account!");
                    return true;
                }
                double amount = 0;
                try {
                    amount = Double.parseDouble(args[2]);

                } catch (Exception e) {
                    sender.sendMessage(ChatColor.RED + "Please enter a valid number!");
                    return true;
            }
            EconManager.setBalance(args[1], EconManager.getBalance(args[1]) + amount);

            } else if (args[0].equalsIgnoreCase("remove")) {

                if (!(EconManager.hasAccount(args[1]))) {
                    sender.sendMessage(ChatColor.RED + "Error: Player does not have an account!");
                    return true;
                }
                double amount = 0;
                try {
                    amount = Double.parseDouble(args[2]);

                } catch (Exception e) {
                    sender.sendMessage(ChatColor.RED + "Please enter a valid number!");
                    return true;
                }
                EconManager.setBalance(args[1], EconManager.getBalance(args[1]) - amount);

            } else if (args[0].equalsIgnoreCase("set")) {

                if (!(EconManager.hasAccount(args[1]))) {
                    sender.sendMessage(ChatColor.RED + "Error: Player does not have an account!");
                    return true;
                }
                double amount = 0;
                try {
                    amount = Double.parseDouble(args[2]);

                } catch (Exception e) {
                    sender.sendMessage(ChatColor.RED + "Please enter a valid number!");
                    return true;
                }
                EconManager.setBalance(args[1], amount);
                sender.sendMessage(ChatColor.GOLD + args[1] + ChatColor.GOLD + "'s" + ChatColor.GREEN + " new balance has been set to " + ChatColor.GOLD + amount);

            } else {
                sender.sendMessage(ChatColor.RED + "Incorrect Syntax!");
                sender.sendMessage(ChatColor.GREEN + "Usage: /econ <add/remove/set> <player> <amount>");
            }
        }

        return true;
    }
}
