package de.snx.survivalgames.listener;

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

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player p = event.getPlayer();
        event.setJoinMessage(null);
        if(SurvivalGames.getGameManager().getGameType() == GameType.LOBBYPHASE){
            String message = SurvivalGames.getFileManager().getMessageFile().getMessage("SURVIVALGAMES.MESSAGE.LOBBY.JOIN");
            message = message.replace("%PLAYER%", p.getName());
            event.setJoinMessage(message);
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        Player p = event.getPlayer();
        if(SurvivalGames.getGameManager().getGameType() == GameType.LOBBYPHASE){
            String message = SurvivalGames.getFileManager().getMessageFile().getMessage("SURVIVALGAMES.MESSAGE.LOBBY.QUIT");
            message = message.replace("%PLAYER%", p.getName());
            event.setQuitMessage(message);
        }
    }

    @EventHandler
    public void onPlayerPickItem(PlayerPickupItemEvent event){
        event.setCancelled(true);
    }
}