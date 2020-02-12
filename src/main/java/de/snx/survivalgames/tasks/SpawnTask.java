package de.snx.survivalgames.tasks;

import de.snx.survivalgames.SurvivalGames;
import de.snx.survivalgames.manager.other.GameType;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class SpawnTask {

    public static int spawn;
    public static int spawnint = 6;

    public static void start() {
        spawn = Bukkit.getScheduler().scheduleAsyncRepeatingTask(SurvivalGames.getInstance(), new BukkitRunnable() {
            @Override
            public void run() {
                spawnint--;
                switch (spawnint) {
                    case 5:
                    case 4:
                    case 3:
                    case 2:
                    case 1:
                        String message = SurvivalGames.getLanguageManager().getMessage("SURVIVALGAMES.MESSAGE.COUNTDOWN.SPAWN");
                        message = message.replace("%SECONDS%", String.valueOf(spawnint));
                        Bukkit.broadcastMessage(message);
                        break;
                    case 0:
                        SurvivalGames.getGameManager().setGameType(GameType.SCHUTZPHASE);
                        PreGameTask.start();
                        stop();
                        break;
                    default:
                        break;
                }
            }
        }, 0, 1 * 20);
    }

    public static void stop() {
        Bukkit.getScheduler().cancelTask(spawn);
    }
}