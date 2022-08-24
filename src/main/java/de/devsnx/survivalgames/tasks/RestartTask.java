package de.devsnx.survivalgames.tasks;

import de.devsnx.survivalgames.SurvivalGames;
import de.devsnx.survivalgames.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class RestartTask {

    public static int neustartrun;
    public static int neustartime = SurvivalGames.getFileManager().getConfigFile().getConfig().getInt("SURIVALGAMES.CONFIG.COUNTDOWN.RESTARTIME");

    public static void start(){
        neustartrun = Bukkit.getScheduler().scheduleAsyncRepeatingTask(SurvivalGames.getInstance(), new BukkitRunnable() {
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
                        String message = SurvivalGames.getLanguageManager().getMessage("SURVIVALGAMES.MESSAGE.COUNTDOWN.RESTART");
                        message = message.replace("%SECONDS%", String.valueOf(neustartime));
                        Bukkit.broadcastMessage(message);
                        break;
                    case 1:
                        String message2 = SurvivalGames.getLanguageManager().getMessage("SURVIVALGAMES.MESSAGE.COUNTDOWN.RESTART");
                        message2 = message2.replace("%SECONDS%", String.valueOf(neustartime));
                        Bukkit.broadcastMessage(message2);
                        for(Player all : Bukkit.getOnlinePlayers()){
                            Utils.joinserver(all, SurvivalGames.getFileManager().getConfigFile().getConfig().getString("SURIVALGAMES.CONFIG.FALLBACKSERVER"));
                            all.kickPlayer("§4RESTART!");
                        }
                        break;
                    case 0:
                        for(Player all : Bukkit.getOnlinePlayers()){
                            Utils.joinserver(all, SurvivalGames.getFileManager().getConfigFile().getConfig().getString("SURIVALGAMES.CONFIG.FALLBACKSERVER"));
                            all.kickPlayer("§4RESTART!");
                        }
                        Bukkit.getServer().shutdown();
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
}