package de.devsnx.survivalgames.listener.player;

import de.devsnx.survivalgames.SurvivalGames;
import de.devsnx.survivalgames.manager.other.GameType;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener {

    @EventHandler (priority = EventPriority.MONITOR)
    public void onMove(PlayerMoveEvent event){
        if(SurvivalGames.getGameManager().getGameType() == GameType.LOBBYPHASE || SurvivalGames.getGameManager().getGameType() == GameType.NEUSTARTPHASE){
            Player player = event.getPlayer();
            if(player.getLocation().getY() < SurvivalGames.getFileManager().getConfigFile().getConfig().getInt("SURIVALGAMES.CONFIG.FALLDISTANCE")){
                player.teleport(SurvivalGames.getFileManager().getLocationFile().getLocation("LOBBY"));
            }
        }
        if(SurvivalGames.getGameManager().getGameType() == GameType.SPAWNPHASE){
            Location from = event.getFrom();
            Location to = event.getTo();
            double x = Math.floor(from.getX());
            double z = Math.floor(from.getZ());
            if (Math.floor(to.getX()) != x || Math.floor(to.getZ()) != z) {
                x += .5;
                z += .5;
                event.getPlayer().teleport(new Location(from.getWorld(), x, from.getY(), z, from.getYaw(), from.getPitch()));
            }
        }
    }
}