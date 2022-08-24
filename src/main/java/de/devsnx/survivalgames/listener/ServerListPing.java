package de.devsnx.survivalgames.listener;

import de.devsnx.survivalgames.SurvivalGames;
import de.devsnx.survivalgames.manager.other.GameType;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerListPing implements Listener {

    @EventHandler
    public void onPing(ServerListPingEvent event){
        if(SurvivalGames.getFileManager().getLocationFile().getLocation("LOBBY") != null){
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
                event.setMotd("§aSurvivalGames v.§c" + SurvivalGames.getInstance().getDescription().getVersion() + " §7by §bSnx");
            }
        }else{
            event.setMotd("§aSurvivalGames v.§c" + SurvivalGames.getInstance().getDescription().getVersion() + " §7by §bSnx");
        }
        event.setMaxPlayers(SurvivalGames.getFileManager().getConfigFile().getConfig().getInt("SURIVALGAMES.CONFIG.MAX_PLAYERS"));
    }
}