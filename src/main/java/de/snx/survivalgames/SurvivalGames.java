package de.snx.survivalgames;

import de.snx.statsapi.StatsAPI;
import de.snx.survivalgames.manager.ChestManager;
import de.snx.survivalgames.manager.FileManager;
import de.snx.survivalgames.manager.GameManager;
import de.snx.survivalgames.manager.LanguageManager;
import de.snx.survivalgames.tasks.LobbyTask;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class SurvivalGames extends JavaPlugin {

    public static SurvivalGames instance;
    public static FileManager fileManager;
    public static StatsAPI statsAPI;
    public static GameManager gameManager;
    public static LanguageManager languageManager;
    public static ChestManager chestManager;

    @Override
    public void onDisable() {
        instance = null;
    }

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getConsoleSender().sendMessage("§8-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage("§8[§aSurvivalGames§8] §cManagers is Loading...");
        this.fileManager = new FileManager();
        this.gameManager = new GameManager();
        Bukkit.getConsoleSender().sendMessage("§8[§aSurvivalGames§8] §aManagers loaded successfully!");
        Bukkit.getConsoleSender().sendMessage(" ");

        Bukkit.getConsoleSender().sendMessage("§8[§aSurvivalGames§8] §cLanguage is Loading...");
        this.languageManager = new LanguageManager();
        Bukkit.getConsoleSender().sendMessage("§8[§aSurvivalGames§8] §aLanguage loaded successfully!");
        Bukkit.getConsoleSender().sendMessage(" ");

        Bukkit.getConsoleSender().sendMessage("§8[§aSurvivalGames§8] §cChest Items is Loading...");
        this.chestManager = new ChestManager();
        Bukkit.getConsoleSender().sendMessage("§8[§aSurvivalGames§8] §aChest Items loaded successfully!");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage("§8[§aSurvivalGames§8] §4§lGAME IS STARTING!!");
        LobbyTask.start();
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage("§8-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
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

    public static SurvivalGames getInstance() {
        return instance;
    }

    public static ChestManager getChestManager() {
        return chestManager;
    }
}