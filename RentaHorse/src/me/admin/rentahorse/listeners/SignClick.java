package me.admin.rentahorse.listeners;

import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * RentaHorse started
 */
public class SignClick implements Listener {

    @EventHandler
    public void onSignClick(PlayerInteractEvent event){
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(event.getClickedBlock().getType() == Material.SIGN){

                Sign sign = (Sign) event.getClickedBlock();

                if(sign.getLine(0).equalsIgnoreCase("[horse]")){
                    event.getPlayer().sendMessage("1");
                }
            }
        }
    }
}
