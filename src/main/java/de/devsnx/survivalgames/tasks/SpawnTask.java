package de.devsnx.survivalgames.tasks;

import de.devsnx.survivalgames.SurvivalGames;
import de.devsnx.survivalgames.manager.other.GameType;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class SpawnTask {

    public static int spawn;
    public static int spawnint = SurvivalGames.getFileManager().getConfigFile().getConfig().getInt("SURIVALGAMES.CONFIG.COUNTDOWN.SPAWNTIME");

    public static void start() {
        spawn = Bukkit.getScheduler().scheduleAsyncRepeatingTask(SurvivalGames.getInstance(), new BukkitRunnable() {
            @Override
            public void run() {
                spawnint--;
                switch (spawnint) {
                    case 10:
                    case 5:
                    case 4:
                    case 3:
                    case 2:
                        String message = SurvivalGames.getLanguageManager().getMessage("SURVIVALGAMES.MESSAGE.COUNTDOWN.SPAWN");
                        message = message.replace("%SECONDS%", String.valueOf(spawnint));
                        Bukkit.broadcastMessage(message);
                        break;
                    case 1:
                        String message2 = SurvivalGames.getLanguageManager().getMessage("SURVIVALGAMES.MESSAGE.COUNTDOWN.SPAWN");
                        message2 = message2.replace("%SECONDS%", String.valueOf(spawnint));
                        Bukkit.broadcastMessage(message2);
                        SurvivalGames.getGameManager().setGameType(GameType.SCHUTZPHASE);
                        PreGameTask.start();
                        break;
                    case 0:
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