package de.snx.survivalgames.listener.player;

import de.snx.statsapi.StatsAPI;
import de.snx.statsapi.manager.other.PlayerStats;
import de.snx.survivalgames.manager.GameManager;
import de.snx.survivalgames.SurvivalGames;
import de.snx.survivalgames.manager.other.GameType;
import de.snx.survivalgames.tasks.RestartTask;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit  implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        Player p = event.getPlayer();
        if(SurvivalGames.getGameManager().getGameType() == GameType.LOBBYPHASE){
            String message = SurvivalGames.getLanguageManager().getMessage("SURVIVALGAMES.MESSAGE.LOBBY.QUIT");
            message = message.replace("&", "§");
            message = message.replace("%PLAYER%", p.getName());
            if(SurvivalGames.getGameManager().getPlayers().contains(p)){
                SurvivalGames.getGameManager().getPlayers().remove(p);
            }
            if(SurvivalGames.getGameManager().getSpectators().contains(p)){
                SurvivalGames.getGameManager().getSpectators().remove(p);
            }
            event.setQuitMessage(message);
        }else if(SurvivalGames.getGameManager().getGameType() == GameType.SPAWNPHASE
                || SurvivalGames.getGameManager().getGameType() == GameType.SCHUTZPHASE
                || SurvivalGames.getGameManager().getGameType() == GameType.INGAMEPHASE
                || SurvivalGames.getGameManager().getGameType() == GameType.DEATHMATCHPHASE){
            if(!(SurvivalGames.getGameManager().getPlayers().size() > 1)){
                //WINNER = LATEST! :)
                //PlayerStats stats = StatsAPI.getStatsManager().getPlayerStats(winner.getUniqueId());
                //stats.addWins(1);

                SurvivalGames.getGameManager().setGameType(GameType.NEUSTARTPHASE);
                RestartTask.start();
            }
        }
    }
}