package de.snx.survivalgames.listener;

import de.snx.statsapi.manager.StatsManager;
import de.snx.statsapi.manager.other.PlayerStats;
import de.snx.survivalgames.GameType;
import de.snx.survivalgames.SurvivalGames;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

    public StatsManager statsManager;

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        statsManager.addPlayerToCache(event.getPlayer().getUniqueId());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        statsManager.removePlayerFromCache(event.getPlayer().getUniqueId());

        PlayerStats stats = statsManager.getPlayerStats(event.getPlayer().getUniqueId());
        int kills = stats.getKills();
        int deaths = stats.getDeaths();
        int games = stats.getGames();
        int wins = stats.getWins();
        double kd = stats.getKD();
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player p = event.getPlayer();
        event.setJoinMessage(null);
        if(SurvivalGames.getGameManager().getGameType() == GameType.LOBBYPHASE){
            String message = SurvivalGames.getFileManager().getMessageFile().getMessage("SURVIVALGAMES.MESSAGE.LOBBY.JOIN");
            message = message.replace("%PLAYER%", p.getName());
            event.setJoinMessage(message);
        }


        SurvivalGames.getStatsManager().addPlayerToCache(p.getUniqueId());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        Player p = event.getPlayer();
        if(SurvivalGames.getGameManager().getGameType() == GameType.LOBBYPHASE){
            String message = SurvivalGames.getFileManager().getMessageFile().getMessage("SURVIVALGAMES.MESSAGE.LOBBY.QUIT");
            message = message.replace("%PLAYER%", p.getName());
            event.setQuitMessage(message);
        }

        SurvivalGames.getStatsManager().addPlayerToCache(p.getUniqueId());
        PlayerStats stats = SurvivalGames.getStatsManager().getPlayerStats(p.getUniqueId());
        int kills = stats.getKills();



    }

    @EventHandler
    public void onPlayerPickItem(PlayerPickupItemEvent event){
        event.setCancelled(true);
    }
}