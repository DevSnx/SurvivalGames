package de.devsnx.survivalgames.listener.player;

import de.devsnx.survivalgames.SurvivalGames;
import de.devsnx.survivalgames.manager.other.GameType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

public class AsyncPlayerPreLogin implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onAsncyJoin(AsyncPlayerPreLoginEvent event){
        if(!(SurvivalGames.getGameManager().getGameType() == GameType.LOBBYPHASE)){
            String message = SurvivalGames.getLanguageManager().getMessage("SURVIVALGAMES.MESSAGE.INGAME.JOIN");
            message = message.replace("&", "§");
            event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, message);
        }
    }
}