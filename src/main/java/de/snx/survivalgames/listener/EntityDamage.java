package de.snx.survivalgames.listener;

import de.snx.survivalgames.SurvivalGames;
import de.snx.survivalgames.manager.other.GameType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamage implements Listener {

    @EventHandler
    public void onEntityDamage (EntityDamageByBlockEvent event){
        if(SurvivalGames.getGameManager().getGameType() == GameType.LOBBYPHASE
                || SurvivalGames.getGameManager().getGameType() == GameType.NEUSTARTPHASE
                || SurvivalGames.getGameManager().getGameType() == GameType.SPAWNPHASE
                || SurvivalGames.getGameManager().getGameType() == GameType.SCHUTZPHASE){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEntityDamage (EntityDamageEvent event){
        if(SurvivalGames.getGameManager().getGameType() == GameType.LOBBYPHASE
                || SurvivalGames.getGameManager().getGameType() == GameType.NEUSTARTPHASE
                || SurvivalGames.getGameManager().getGameType() == GameType.SPAWNPHASE
                || SurvivalGames.getGameManager().getGameType() == GameType.SCHUTZPHASE){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEntityDamage (EntityDamageByEntityEvent event){
        if(SurvivalGames.getGameManager().getGameType() == GameType.LOBBYPHASE
                || SurvivalGames.getGameManager().getGameType() == GameType.NEUSTARTPHASE
                || SurvivalGames.getGameManager().getGameType() == GameType.SPAWNPHASE
                || SurvivalGames.getGameManager().getGameType() == GameType.SCHUTZPHASE){
            event.setCancelled(true);
        }
    }
}