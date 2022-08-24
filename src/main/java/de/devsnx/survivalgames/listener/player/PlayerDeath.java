package de.devsnx.survivalgames.listener.player;

import de.devsnx.survivalgames.SurvivalGames;
import de.devsnx.survivalgames.manager.other.GameType;
import de.devsnx.survivalgames.tasks.DeathmatchTask;
import de.devsnx.survivalgames.tasks.GameTask;
import de.devsnx.survivalgames.tasks.RestartTask;
import de.snx.statsapi.StatsAPI;
import de.snx.statsapi.manager.other.PlayerStats;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath implements Listener {

    @EventHandler (priority = EventPriority.MONITOR)
    public void onDeath(PlayerDeathEvent event){
        Player player = event.getEntity().getPlayer();
        Location loc = player.getLocation();
        player.spigot().respawn();
        if(SurvivalGames.getGameManager().getPlayers().contains(player)){
            int rank = SurvivalGames.getGameManager().getPlayers().size();
            SurvivalGames.getGameManager().getPlayerRanks().put(rank, player);
            SurvivalGames.getGameManager().getPlayers().remove(player);
            SurvivalGames.getGameManager().getSpectators().add(player);
            player.teleport(loc);
            player.setGameMode(GameMode.SPECTATOR);
            player.sendMessage("§7Du bist #" + rank + " §7in dieser Runde geworden.");
            if(SurvivalGames.getGameManager().getPlayers().size() == 1){
                for(Player all: Bukkit.getOnlinePlayers()){
                    all.setGameMode(GameMode.ADVENTURE);
                    all.getInventory().clear();
                    if(SurvivalGames.getFileManager().getLocationFile().getLocation("LOBBY") != null){
                        all.teleport(SurvivalGames.getFileManager().getLocationFile().getLocation("LOBBY"));
                    }
                }
                Player firstPlace = SurvivalGames.getGameManager().getPlayers().get(0);
                int rank2 = SurvivalGames.getGameManager().getPlayers().size();
                SurvivalGames.getGameManager().getPlayerRanks().put(rank2, firstPlace);
                BroadcastWonGamesMessage();
                GameTask.stop();
                DeathmatchTask.stop();
                SurvivalGames.getGameManager().setGameType(GameType.NEUSTARTPHASE);
                RestartTask.start();
            }else if(SurvivalGames.getGameManager().getPlayers().size() < 1){
                Bukkit.getServer().shutdown();
            }
        }
        if(SurvivalGames.getGameManager().getPlayers().contains(player)){
            PlayerStats playerStats = StatsAPI.getStatsManager().getPlayerStats(player.getUniqueId());
            playerStats.addDeaths(1);
            SurvivalGames.getGameManager().getPlayers().remove(player);
        }
        if(event.getEntity().getKiller() instanceof Entity){
            Player killer = event.getEntity().getKiller();
            PlayerStats killerStats = StatsAPI.getStatsManager().getPlayerStats(killer.getUniqueId());
            killerStats.addKills(1);
        }
    }

    public static void BroadcastWonGamesMessage(){
        String rank1 = null;
        String rank2 = null;
        String rank3 = null;
        String noPlayer = "§c-/-";
        if(SurvivalGames.getGameManager().getPlayerRanks().get(1) != null){
            rank1 = SurvivalGames.getGameManager().getPlayerRanks().get(1).getName();
        }else{
            rank1 = noPlayer;
        }
        if(SurvivalGames.getGameManager().getPlayerRanks().get(2) != null){
            rank2 = SurvivalGames.getGameManager().getPlayerRanks().get(2).getName();
        }else{
            rank2 = noPlayer;
        }
        if(SurvivalGames.getGameManager().getPlayerRanks().get(3) != null){
            rank3 = SurvivalGames.getGameManager().getPlayerRanks().get(3).getName();
        }else{
            rank3 = noPlayer;
        }

        for(String message : SurvivalGames.getLanguageManager().getLanguageFileConfiguration().getStringList("SURVIVALGAMES.MESSAGE.WONGAME")){
            message = message.replace("%1STPLACE%", rank1);
            message = message.replace("%2STPLACE%", rank2);
            message = message.replace("%3STPLACE%", rank3);
            message = message.replace("&", "§");
            Bukkit.broadcastMessage(message);
        }
    }
}