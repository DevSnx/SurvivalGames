package de.devsnx.survivalgames.listener;

import de.devsnx.survivalgames.SurvivalGames;
import de.devsnx.survivalgames.manager.other.GameType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLevelChange implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void FoodlevelChange(FoodLevelChangeEvent event){
        if(SurvivalGames.getGameManager().getGameType() == GameType.LOBBYPHASE
                || SurvivalGames.getGameManager().getGameType() == GameType.NEUSTARTPHASE
                || SurvivalGames.getGameManager().getGameType() == GameType.SPAWNPHASE){
            event.setCancelled(true);
        }
    }
}