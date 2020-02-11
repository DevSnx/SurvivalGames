package de.snx.survivalgames.tasks;

import de.snx.survivalgames.SurvivalGames;
import de.snx.survivalgames.manager.other.GameType;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class PreGameTask {

    public static int schutzzeit;
    public static int schutzzeitint = 61;

    public static void start(){
        schutzzeit = Bukkit.getScheduler().scheduleAsyncRepeatingTask(SurvivalGames.getInstance(), new BukkitRunnable() {
            @Override
            public void run() {
                schutzzeitint--;
                switch(schutzzeitint){
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
                        String message = SurvivalGames.getLanguageManager().getMessage("SURVIVALGAMES.MESSAGE.COUNTDOWN.PRETIME");
                        message = message.replace("%SECONDS%", String.valueOf(schutzzeitint));
                        Bukkit.broadcastMessage(message);
                        break;
                    case 0:
                        SurvivalGames.getGameManager().setGameType(GameType.INGAMEPHASE);
                        GameTask.start();
                        stop();
                        break;
                    default:
                        break;
                }
            }
        }, 0, 1*20);
    }

    public static void stop(){
        Bukkit.getScheduler().cancelTask(schutzzeit);
    }
}