package de.snx.survivalgames.listener.player;

import de.snx.survivalgames.manager.GameManager;
import de.snx.survivalgames.SurvivalGames;
import de.snx.survivalgames.manager.other.GameType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player p = event.getPlayer();
        if(SurvivalGames.getGameManager().getGameType() == GameType.LOBBYPHASE){
            String message = SurvivalGames.getLanguageManager().getMessage("SURVIVALGAMES.MESSAGE.LOBBY.JOIN");
            message = message.replace("&", "§");
            message = message.replace("%PLAYER%", p.getName());
            event.setJoinMessage(message);
            p.setHealth(20D);
            p.setFoodLevel(20);
            p.getInventory().clear();
            p.teleport(SurvivalGames.getFileManager().getLocationFile().getLocation("LOBBY"));
        }
    }
}