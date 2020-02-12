package de.snx.survivalgames.tasks;

import de.snx.survivalgames.SurvivalGames;
import de.snx.survivalgames.manager.other.GameType;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class DeathmatchTask {

    public static int deathmatch;
    public static int deathmatchint = SurvivalGames.getFileManager().getConfigFile().getConfig().getInt("SURIVALGAMES.CONFIG.COUNTDOWN.DEATHMATCHTIME");

    public static void start(){
        deathmatch = Bukkit.getScheduler().scheduleAsyncRepeatingTask(SurvivalGames.getInstance(), new BukkitRunnable() {
            @Override
            public void run() {
                deathmatchint--;
                switch(deathmatchint){
                    case 300:
                    case 240:
                    case 180:
                    case 120:
                    case 60:
                    case 30:
                    case 10:
                    case 5:
                    case 4:
                    case 3:
                    case 2:
                    case 1:
                        String message = "";
                        message = message.replace("%SECONDS%", String.valueOf(deathmatchint));
                        Bukkit.broadcastMessage(message);
                        break;
                    case 0:
                        RestartTask.start();
                        SurvivalGames.getGameManager().setGameType(GameType.NEUSTARTPHASE);
                        stop();
                        break;
                    default:
                        break;
                }
            }
        }, 0, 1*20);
    }

    public static void stop(){
        Bukkit.getScheduler().cancelTask(deathmatch);
    }
}