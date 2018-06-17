package me.admin.rentahorse.listeners;

import me.admin.rentahorse.Core;
import me.admin.rentahorse.handlers.HorseHandler;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Horse;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import static me.admin.rentahorse.Core.economy;

/**
 * RentaHorse started
 */
public class SignClick implements Listener {

    Core core;

    public SignClick(Core core) {
        this.core = core;
    }

    @EventHandler
    public void onSignClick(PlayerInteractEvent e) {

        if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK))
            return;
        if (e.getClickedBlock().getState() instanceof Sign) {

            Sign s = (Sign) e.getClickedBlock().getState();
            Player player = e.getPlayer();

            if (s.getLine(0).equalsIgnoreCase(ChatColor.DARK_PURPLE + "[HORSE]")) {
                 try {
                	int price = Integer.parseInt(ChatColor.stripColor(s.getLine(3).substring(7)));
                }catch(NumberFormatException e1) {
                	int price = 0;
                }
                if(economy.has(player, price)) {
                    economy.withdrawPlayer(player, price);
                      if (s.getLine(1).equalsIgnoreCase(ChatColor.GOLD + "Level " + ChatColor.GRAY + ": " + ChatColor.GREEN + "1")) {
                         HorseHandler.addLevelOneHorse(e.getPlayer());

                      }
                      if (s.getLine(1).equalsIgnoreCase(ChatColor.GOLD + "Level " + ChatColor.GRAY + ": " + ChatColor.GREEN + "2")) {

                          HorseHandler.addLevelTwoHorse(e.getPlayer());

                      }
                    if (s.getLine(1).equalsIgnoreCase(ChatColor.GOLD + "Level " + ChatColor.GRAY + ": " + ChatColor.GREEN + "3")) {
                          HorseHandler.addLevelThreeHorse(e.getPlayer());

                       }
                     if (s.getLine(1).equalsIgnoreCase(ChatColor.GOLD + "Level " + ChatColor.GRAY + ": " + ChatColor.GREEN + "4")) {

                         HorseHandler.addLevelFourHorse(e.getPlayer());
                        }
                    
                }
            }
        }

    }

}
