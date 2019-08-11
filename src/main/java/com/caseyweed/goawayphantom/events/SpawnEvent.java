package com.caseyweed.goawayphantom.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

import java.util.logging.Logger;

public class SpawnEvent implements Listener {

    private Logger log = Bukkit.getLogger();

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        int days = (int) event.getLocation().getWorld().getFullTime() / 24000;
        int phase = days % 8;

        if (phase != 0) {
            if (event.getEntityType().equals(EntityType.PHANTOM)) {
                event.setCancelled(true);
            }
        }
    }
}
