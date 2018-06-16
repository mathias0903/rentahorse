package me.admin.rentahorse.commands;

import me.admin.rentahorse.Core;
import me.admin.rentahorse.handlers.ChatHandler;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * RentaHorse started
 */
public class SetStable implements CommandExecutor {

    Core core;

    public SetStable(Core core){
        this.core = core;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String args[]) {
        if(commandlabel.equalsIgnoreCase("setstable")){
            if(!(sender instanceof Player)){
                sender.sendMessage(ChatHandler.noPerm());
                return true;
            }
            Player p = (Player) sender;
            if(!(p.hasPermission("horse.setstable"))){
                p.sendMessage(ChatHandler.noPerm());
                return true;
            }
            Location loc = p.getLocation();
            String world = loc.getWorld().getName();
            int x = loc.getBlockX();
            int y = loc.getBlockY();
            int z = loc.getBlockZ();

            core.getConfig().set("stable.x", x);
            core.getConfig().set("stable.y", y);
            core.getConfig().set("stable.z", z);
            core.getConfig().set("stable.world", world);

            core.saveConfig();

            p.sendMessage(ChatHandler.stableSet());

        }
        return true;
    }
}
