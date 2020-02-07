package de.snx.survivalgames.manager;

import de.snx.survivalgames.SurvivalGames;
import de.snx.survivalgames.listener.ServerListPing;
import de.snx.survivalgames.listener.player.PlayerInteract;
import de.snx.survivalgames.listener.player.PlayerJoin;
import de.snx.survivalgames.listener.player.PlayerPickupItem;
import de.snx.survivalgames.listener.player.PlayerQuit;
import de.snx.survivalgames.manager.other.GameType;
import de.snx.survivalgames.tasks.LobbyTask;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class GameManager {

    GameType gameType;
    public int lobbyCooldown;
    public int gameCooldown;
    public int restartCooldown;
    public int pregameCooldown;
    public int deathmatchCooldown;

    public GameManager(){
        this.gameType = GameType.LOBBYPHASE;
        this.lobbyCooldown = 301;
        this.gameCooldown = 301;
        this.restartCooldown = 16;
        this.pregameCooldown = 301;
        this.deathmatchCooldown = 301;
        loadSG();
        startSG();
    }

    private void startSG(){
        this.gameType = GameType.LOBBYPHASE;
        LobbyTask.start();
    }

    private void loadSG(){
        PluginManager load = Bukkit.getPluginManager();
        load.registerEvents(new PlayerInteract(), SurvivalGames.getInstance());
        load.registerEvents(new PlayerJoin(), SurvivalGames.getInstance());
        load.registerEvents(new PlayerQuit(), SurvivalGames.getInstance());
        load.registerEvents(new PlayerPickupItem(), SurvivalGames.getInstance());
        load.registerEvents(new PlayerJoin(), SurvivalGames.getInstance());
        load.registerEvents(new PlayerInteract(), SurvivalGames.getInstance());
        load.registerEvents(new ServerListPing(), SurvivalGames.getInstance());
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
}