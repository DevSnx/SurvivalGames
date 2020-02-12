package de.snx.survivalgames.listener.player;

import com.google.common.math.Stats;
import de.snx.statsapi.StatsAPI;
import de.snx.statsapi.manager.other.PlayerStats;
import de.snx.survivalgames.SurvivalGames;
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
        player.spigot().respawn();

        if(event.getEntity().getKiller() instanceof Entity){
            Player killer = event.getEntity().getKiller();
            PlayerStats playerStats = StatsAPI.getStatsManager().getPlayerStats(player.getUniqueId());
            PlayerStats killerStats = StatsAPI.getStatsManager().getPlayerStats(killer.getUniqueId());


        }else{


        }
    }
}