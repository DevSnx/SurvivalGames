package de.devsnx.survivalgames.listener.player;

import de.devsnx.survivalgames.SurvivalGames;
import de.devsnx.survivalgames.manager.other.GameType;
import org.bukkit.GameMode;
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
            p.setGameMode(GameMode.ADVENTURE);
            //if(SurvivalGames.getFileManager().getTeamFile().getConfig().getBoolean("TEAMS.TEAMMODE")){
            //    p.getInventory().setItem(0, new ItemCreator().material(Material.RED_BED).displayName(SurvivalGames.getFileManager().getTeamFile().getConfig().getString("TEAMS.JOINITEM.NAME").replace("&", "§")).build());
            //}
        }
    }
}