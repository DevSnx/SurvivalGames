package de.snx.survivalgames.tasks;

import de.snx.survivalgames.SurvivalGames;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class CheckPlayersTask {

    public static BukkitTask check;
    public static int checkint = 10;

    public static void start(){
        check = new BukkitRunnable() {
            @Override
            public void run() {
                checkint--;
                switch (checkint) {
                    case 1:
                        if(!(Bukkit.getServer().getOnlinePlayers().size() >= SurvivalGames.getFileManager().getConfigFile().getConfig().getInt("SURIVALGAMES.CONFIG.MIN_PLAYERS"))) {
                            checkint = 10;
                            Bukkit.broadcastMessage(SurvivalGames.getLanguageManager().getMessage("SURVIVALGAMES.MESSAGE.NOTENOUGTPLAYERS"));
                        }else{
                            LobbyTask.start();
                        }
                        break;
                    case 0:
                        stop();
                        break;
                    default:
                        break;
                }
            }
        }.runTaskTimer(SurvivalGames.getInstance(), 0, 1*20);
    }

    public static void stop(){
        Bukkit.getScheduler().cancelTask(checkint);
    }
}
