package de.snx.survivalgames.tasks;

import de.snx.survivalgames.SurvivalGames;
import de.snx.survivalgames.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class RestartTask {

    public static int neustartrun;
    public static int neustartime = SurvivalGames.getGameManager().getRestartCooldown();

    public static void start(){
        neustartrun = Bukkit.getScheduler().scheduleSyncRepeatingTask(SurvivalGames.getInstance(), new BukkitRunnable() {
            @Override
            public void run() {
                neustartime--;
                switch (neustartime) {
                    case 15:
                    case 10:
                    case 5:
                    case 4:
                    case 3:
                    case 2:
                        Bukkit.broadcastMessage(getMessage("SURVIVALGAMES.MESSAGE.COUNTDOWN.RESTARTSERVER.BROADCAST.MESSAGE", neustartime));
                        break;
                    case 1:
                        Bukkit.broadcastMessage(getMessage("SURVIVALGAMES.MESSAGE.COUNTDOWN.RESTARTSERVER.BROADCAST.MESSAGE", neustartime));
                        for(Player all : Bukkit.getOnlinePlayers()){
                            Utils.joinserver(all, SurvivalGames.getFileManager().getConfigFile().getConfig().getString("SURIVALGAMES.CONFIG.FALLBACKSERVER"));
                        }
                        break;
                    case 0:
                        Bukkit.getServer().shutdown();
                        stop();
                        break;
                    default:
                        break;
                }
            }
        }, 0, 1 * 20);
    }

    public static void stop() {
        Bukkit.getScheduler().cancelTask(neustartrun);
    }

    public static String getMessage(String path, int Sekunden) {
        String messages = SurvivalGames.getLanguageManager().getMessage(path);
        //messages = messages.replace("&", "§").replace("%PREFIX%", Main.getPreix()).replace("%SEKUNDEN%", String.valueOf(Sekunden));
        return messages;
    }
}