package de.snx.survivalgames;

        import de.snx.survivalgames.configs.FileManager;
        import de.snx.survivalgames.listener.*;
        import de.snx.survivalgames.manager.GameManager;
        import org.bukkit.Bukkit;
        import org.bukkit.plugin.PluginManager;
        import org.bukkit.plugin.java.JavaPlugin;

public class SurvivalGames extends JavaPlugin {

    public static SurvivalGames instance;
    public static FileManager fileManager;
    public static GameManager gameManager;

    @Override
    public void onDisable() {
        instance = null;
    }

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§7--] §aSurvivalGames §7[--");
        Bukkit.getConsoleSender().sendMessage("          §c13%");
        instance = this;
        Bukkit.getConsoleSender().sendMessage("          §c33%");
        this.fileManager = new FileManager();
        this.gameManager = new GameManager();
        Bukkit.getConsoleSender().sendMessage("          §c53%");
        loadAll();
        Bukkit.getConsoleSender().sendMessage("         §c100%");
        Bukkit.getConsoleSender().sendMessage("§7--] §aSurvivalGames §7[--");
    }

    public void loadAll(){
        PluginManager load = Bukkit.getPluginManager();
        load.registerEvents(new CommandListener(), this);
        load.registerEvents(new EntityListener(), this);
        load.registerEvents(new InteractListener(), this);
        load.registerEvents(new PlayerListener(), this);
        load.registerEvents(new ServerListener(), this);
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
}