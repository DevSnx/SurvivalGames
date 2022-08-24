package de.devsnx.survivalgames.listener.player;

import de.devsnx.survivalgames.SurvivalGames;
import de.devsnx.survivalgames.manager.other.GameType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class PlayerPickupItem implements Listener {

    @EventHandler
    public void onPlayerPickUpItem(PlayerPickupItemEvent event){
        if(SurvivalGames.getGameManager().getGameType() == GameType.LOBBYPHASE||SurvivalGames.getGameManager().getGameType() == GameType.NEUSTARTPHASE){
            event.setCancelled(true);
        }
    }
}
