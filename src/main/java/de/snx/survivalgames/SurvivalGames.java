package de.snx.survivalgames;

import de.snx.statsapi.StatsAPI;
import de.snx.survivalgames.manager.FileManager;
import de.snx.survivalgames.manager.GameManager;
import de.snx.survivalgames.manager.LanguageManager;
import de.snx.survivalgames.tasks.LobbyTask;
import org.bukkit.plugin.java.JavaPlugin;

public class SurvivalGames extends JavaPlugin {

    public static SurvivalGames instance;
    public static FileManager fileManager;
    public static StatsAPI statsAPI;
    public static GameManager gameManager;
    public static LanguageManager languageManager;

    @Override
    public void onDisable() {
        instance = null;
    }

    @Override
    public void onEnable() {
        instance = this;
        this.fileManager = new FileManager();
        this.gameManager = new GameManager();
        this.languageManager = new LanguageManager();

        LobbyTask.start();

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

    public static StatsAPI getStatsAPI() {
        return statsAPI;
    }

    public static LanguageManager getLanguageManager() {
        return languageManager;
    }
}