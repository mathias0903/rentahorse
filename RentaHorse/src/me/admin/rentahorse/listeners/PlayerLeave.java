package me.admin.rentahorse.listeners;

import me.admin.rentahorse.Core;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Tameable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.List;

/**
 * RentaHorse started
 */
public class PlayerLeave implements Listener {

    Core core;

    public PlayerLeave(Core core) {
        this.core = core;
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {

        World world = event.getPlayer().getWorld();

        List<Entity> entities = world.getEntities();

        for (Entity entity : entities) {
            if (entity instanceof Horse) {
                if (((Tameable) entity).isTamed()) {
                    if (((Tameable) entity).getOwner().getName().equalsIgnoreCase(event.getPlayer().getName())) {

                        World w = Bukkit.getServer().getWorld(core.getConfig().getString("stable.world"));
                        int x = core.getConfig().getInt("stable.x");
                        int y = core.getConfig().getInt("stable.y");
                        int z = core.getConfig().getInt("stable.z");
                        Location stable = new Location(world, x, y ,z);

                        entity.teleport(stable);

                    }
                }
            }
        }

    }
}
