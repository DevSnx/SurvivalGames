package de.snx.survivalgames.listener.player;

import de.snx.survivalgames.SurvivalGames;
import de.snx.survivalgames.manager.other.GameType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLevelChange implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void FoodlevelChange(FoodLevelChangeEvent event){
        if(SurvivalGames.getGameManager().getGameType() == GameType.LOBBYPHASE || SurvivalGames.getGameManager().getGameType() == GameType.NEUSTARTPHASE){
            event.setCancelled(true);
        }
    }
}