package de.snx.survivalgames;

import de.snx.statsapi.manager.StatsManager;
import de.snx.survivalgames.manager.FileManager;
import de.snx.survivalgames.listener.*;
import de.snx.survivalgames.listener.player.PlayerInteract;
import de.snx.survivalgames.listener.player.PlayerJoin;
import de.snx.survivalgames.listener.player.PlayerPickupItem;
import de.snx.survivalgames.listener.player.PlayerQuit;
import de.snx.survivalgames.manager.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SurvivalGames extends JavaPlugin {

    public static SurvivalGames instance;
    public static FileManager fileManager;
    public static StatsManager statsManager;
    public static GameManager gameManager;

    @Override
    public void onDisable() {
        instance = null;
    }

    @Override
    public void onEnable() {
        instance = this;
        this.fileManager = new FileManager();
        this.gameManager = new GameManager();
        loadAll();
    }

    public void loadAll(){
        PluginManager load = Bukkit.getPluginManager();
        load.registerEvents(new PlayerInteract(), this);
        load.registerEvents(new PlayerJoin(), this);
        load.registerEvents(new PlayerQuit(), this);
        load.registerEvents(new PlayerPickupItem(), this);
        load.registerEvents(new PlayerJoin(), this);
        load.registerEvents(new PlayerInteract(), this);
        load.registerEvents(new ServerListPing(), this);
    }

    public static SurvivalGames getInstance() {
        return instance;
    }

    public static FileManager getFileManager() {
        return fileManager;
    }

    public static GameManager getGameManager() {
        return gameManager;
    }

    public static StatsManager getStatsManager() {
        return statsManager;
    }
}