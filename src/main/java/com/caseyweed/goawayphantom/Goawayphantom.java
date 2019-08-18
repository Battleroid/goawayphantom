package com.caseyweed.goawayphantom;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Goawayphantom extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("Started");
    }

    public boolean isFullMoon(float time) {
        int days = (int) time / 24000;
        int phase = days % 8;
        return phase == 0;
    }

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        // don't bother if it's full moon
        if (isFullMoon(event.getLocation().getWorld().getFullTime()))
            return;

        // if spawned naturally, deny spawn, otherwise allow (such as spawn eggs, spawners, etc)
        if (event.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.NATURAL))
            event.setCancelled(true);
    }

    @Override
    public void onDisable() {
        getLogger().info("Stopped");
    }
}
