package de.devsnx.survivalgames.manager;

import de.devsnx.survivalgames.listener.*;
import de.devsnx.survivalgames.listener.player.*;
import de.devsnx.survivalgames.manager.other.GameType;
import de.devsnx.survivalgames.SurvivalGames;
import de.devsnx.survivalgames.commands.SurvivalGamesCommand;
import de.devsnx.survivalgames.listener.*;
import de.devsnx.survivalgames.listener.player.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import java.util.ArrayList;
import java.util.HashMap;

public class GameManager {

    GameType gameType;

    public ArrayList<Player> players;
    public ArrayList<Player> spectators;

    public HashMap<Integer, Player> playerRanks;

    public GameManager(){
        this.gameType = GameType.LOBBYPHASE;
        this.players = new ArrayList<Player>();
        this.spectators = new ArrayList<Player>();
        this.playerRanks = new HashMap<Integer, Player>();
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
        load.registerEvents(new PlayerMove(), SurvivalGames.getInstance());
        load.registerEvents(new PlayerDropItem(), SurvivalGames.getInstance());
        load.registerEvents(new PlayerDeath(), SurvivalGames.getInstance());

        SurvivalGames.getInstance().getCommand("survivalgames").setExecutor(new SurvivalGamesCommand());
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public ArrayList<Player> getSpectators() {
        return this.spectators;
    }

    public HashMap<Integer, Player> getPlayerRanks() {
        return this.playerRanks;
    }

    public void addPlayerToSpectator(Player player){
        getPlayers().remove(player);
        getSpectators().add(player);

    }
}