package de.snx.survivalgames.manager;

import de.snx.survivalgames.SurvivalGames;
import de.snx.survivalgames.commands.SurvivalGamesCommand;
import de.snx.survivalgames.listener.*;
import de.snx.survivalgames.listener.player.*;
import de.snx.survivalgames.manager.other.GameType;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class GameManager {

    GameType gameType;
    public int lobbyCooldown;
    public int gameCooldown;
    public int restartCooldown;
    public int pregameCooldown;
    public int deathmatchCooldown;
    public int min_players;
    public int maxplayers;

    public GameManager(){
        this.gameType = GameType.LOBBYPHASE;
        this.lobbyCooldown = 301;
        this.gameCooldown = 301;
        this.restartCooldown = 16;
        this.pregameCooldown = 301;
        this.deathmatchCooldown = 301;
        this.min_players = 4;
        this.maxplayers = 8;
        loadSG();
    }

    private void loadSG(){
        PluginManager load = Bukkit.getPluginManager();
        load.registerEvents(new AsyncPlayerPreLogin(), SurvivalGames.getInstance());
        load.registerEvents(new FoodLevelChange(), SurvivalGames.getInstance());
        load.registerEvents(new PlayerLogin(), SurvivalGames.getInstance());
        load.registerEvents(new PlayerInteract(), SurvivalGames.getInstance());
        load.registerEvents(new PlayerJoin(), SurvivalGames.getInstance());
        load.registerEvents(new PlayerQuit(), SurvivalGames.getInstance());
        load.registerEvents(new PlayerPickupItem(), SurvivalGames.getInstance());
        load.registerEvents(new PlayerJoin(), SurvivalGames.getInstance());
        load.registerEvents(new PlayerInteract(), SurvivalGames.getInstance());
        load.registerEvents(new ServerListPing(), SurvivalGames.getInstance());
        load.registerEvents(new BlockPlace(), SurvivalGames.getInstance());
        load.registerEvents(new BlockBreak(), SurvivalGames.getInstance());
        load.registerEvents(new EntityDamage(), SurvivalGames.getInstance());

        SurvivalGames.getInstance().getCommand("survivalgames").setExecutor(new SurvivalGamesCommand());
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public int getDeathmatchCooldown() {
        return this.deathmatchCooldown;
    }

    public int getGameCooldown() {
        return this.gameCooldown;
    }

    public int getLobbyCooldown() {
        return this.lobbyCooldown;
    }

    public int getPregameCooldown() {
        return this.pregameCooldown;
    }

    public int getRestartCooldown() {
        return this.restartCooldown;
    }

    public int getMin_players() {
        return this.min_players;
    }

    public int getMaxplayers() {
        return this.maxplayers;
    }
}