package de.snx.survivalgames.tasks;

import de.snx.survivalgames.SurvivalGames;
import de.snx.survivalgames.manager.other.GameType;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class LobbyTask {

    public static int lobby;
    public static int lobbyint = 61;

    public static void start(){
        lobby = Bukkit.getScheduler().scheduleSyncRepeatingTask(SurvivalGames.getInstance(), new BukkitRunnable() {
            @Override
            public void run() {
                lobbyint--;
                switch (lobbyint){
                    case 60:
                    case 50:
                    case 40:
                    case 30:
                    case 20:
                    case 10:
                    case 5:
                    case 4:
                    case 3:
                    case 2:
                        String message = SurvivalGames.getLanguageManager().getMessage("SURVIVALGAMES.MESSAGE.COUNTDOWN.LOBBY");
                        message = message.replace("%SECONDS%", String.valueOf(lobbyint));
                        Bukkit.broadcastMessage(message);
                        break;
                    case 1:
                        String message2 = SurvivalGames.getLanguageManager().getMessage("SURVIVALGAMES.MESSAGE.COUNTDOWN.LOBBY");
                        message2 = message2.replace("%SECONDS%", String.valueOf(lobbyint));
                        Bukkit.broadcastMessage(message2);


                        if(Bukkit.getOnlinePlayers().size() >= SurvivalGames.getFileManager().getConfigFile().getConfig().getInt("SURIVALGAMES.CONFIG.MIN_PLAYERS")){
                            SurvivalGames.getGameManager().setGameType(GameType.SPAWNPHASE);
                            int id = 1;
                            for(Player player : Bukkit.getOnlinePlayers()){
                                player.teleport(SurvivalGames.getFileManager().getLocationFile().getLocation("SPAWN." + id));
                                player.getInventory().clear();
                                id++;
                            }
                            SpawnTask.start();
                        }else{
                            lobbyint = 61;
                            Bukkit.broadcastMessage(SurvivalGames.getLanguageManager().getMessage("SURVIVALGAMES.MESSAGE.NOTENOUGTPLAYERS"));
                        }
                        break;
                    case 0:
                        stop();
                        break;
                    default:
                        break;
                }
            }
        }, 0, 1*20);
    }
    public static void stop(){
        Bukkit.getScheduler().cancelTask(lobby);
    }
}