package de.snx.survivalgames.listener.player;

import de.snx.survivalgames.SurvivalGames;
import de.snx.survivalgames.manager.other.GameType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

public class AsyncPlayerPreLogin implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onAsncyJoin(AsyncPlayerPreLoginEvent event){
        if(!(SurvivalGames.getGameManager().getGameType() == GameType.LOBBYPHASE)){
            String message = SurvivalGames.getFileManager().getMessageFile().getMessage("SURVIVALGAMES.MESSAGE.INGAME.JOIN");
            message = message.replace("&", "§");
            event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, message);
        }
    }
}