package com.caseyweed.goawayphantom;

import com.caseyweed.goawayphantom.events.SpawnEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Goawayphantom extends JavaPlugin {

     private Logger log = Bukkit.getLogger();

    @Override
    public void onEnable() {
        this.log.info("Started");
        Bukkit.getPluginManager().registerEvents(new SpawnEvent(), this);
    }

    @Override
    public void onDisable() {
        this.log.info("Stopped");
    }
}
