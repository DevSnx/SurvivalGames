package de.snx.survivalgames.listener.player;

import de.snx.survivalgames.SurvivalGames;
import de.snx.survivalgames.manager.other.GameType;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove {

    @EventHandler (priority = EventPriority.MONITOR)
    public void onMove(PlayerMoveEvent event){
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