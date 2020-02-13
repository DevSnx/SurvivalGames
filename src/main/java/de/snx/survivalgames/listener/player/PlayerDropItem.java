package de.snx.survivalgames.listener.player;

import de.snx.survivalgames.SurvivalGames;
import de.snx.survivalgames.manager.other.GameType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDropItem implements Listener {

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event){
        if(SurvivalGames.getGameManager().getGameType() == GameType.LOBBYPHASE||SurvivalGames.getGameManager().getGameType() == GameType.NEUSTARTPHASE){
            event.setCancelled(true);
        }
    }
}
