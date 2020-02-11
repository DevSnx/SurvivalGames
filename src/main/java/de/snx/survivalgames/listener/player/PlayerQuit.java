package de.snx.survivalgames.listener.player;

import de.snx.survivalgames.manager.GameManager;
import de.snx.survivalgames.SurvivalGames;
import de.snx.survivalgames.manager.other.GameType;
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
            event.setQuitMessage(message);
        }
    }
}