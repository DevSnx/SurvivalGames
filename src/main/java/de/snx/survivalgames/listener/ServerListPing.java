package de.snx.survivalgames.listener;

import de.snx.survivalgames.SurvivalGames;
import de.snx.survivalgames.manager.other.GameType;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerListPing implements Listener {

    @EventHandler
    public void onPing(ServerListPingEvent event){
        if(SurvivalGames.getGameManager().getGameType() == GameType.LOBBYPHASE){
            if(Bukkit.getServer().getOnlinePlayers().size() != Bukkit.getServer().getMaxPlayers()){
                event.setMotd(SurvivalGames.getFileManager().getConfigFile().getConfig().getString("SURIVALGAMES.CONFIG.MOTD.LOBBY").replace("&", "§"));
            }else{
                event.setMotd(SurvivalGames.getFileManager().getConfigFile().getConfig().getString("SURIVALGAMES.CONFIG.MOTD.FULL_LOBBY").replace("&", "§"));
            }
        }else if(SurvivalGames.getGameManager().getGameType() == GameType.SPAWNPHASE ||
                SurvivalGames.getGameManager().getGameType() == GameType.INGAMEPHASE ||
                SurvivalGames.getGameManager().getGameType() == GameType.DEATHMATCHPHASE){
            event.setMotd(SurvivalGames.getFileManager().getConfigFile().getConfig().getString("SURIVALGAMES.CONFIG.MOTD.INGAME").replace("&", "§"));
        }else if(SurvivalGames.getGameManager().getGameType() == GameType.NEUSTARTPHASE){
            event.setMotd(SurvivalGames.getFileManager().getConfigFile().getConfig().getString("SURIVALGAMES.CONFIG.MOTD.RESTART").replace("&", "§"));
        }else{
            event.setMotd("§aSurvivalGames §7by §bSnx");
        }
    }
}