package de.snx.survivalgames.listener.player;

import de.snx.survivalgames.manager.other.GameType;
import de.snx.survivalgames.SurvivalGames;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

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
}