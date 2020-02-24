package de.snx.survivalgames.tasks;

import de.snx.survivalgames.SurvivalGames;
import de.snx.survivalgames.manager.other.GameType;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class GameTask {

    public static int game;
    public static int gameint = SurvivalGames.getFileManager().getConfigFile().getConfig().getInt("SURIVALGAMES.CONFIG.COUNTDOWN.GAMETIME");

    public static void start(){
        game = Bukkit.getScheduler().scheduleAsyncRepeatingTask(SurvivalGames.getInstance(), new BukkitRunnable() {
            @Override
            public void run() {
                gameint--;
                switch(gameint){
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
                        String message = SurvivalGames.getLanguageManager().getMessage("SURVIVALGAMES.MESSAGE.COUNTDOWN.DEATHMATCH");
                        message = message.replace("%SECONDS%", String.valueOf(gameint));
                        Bukkit.broadcastMessage(message);
                        break;
                    case 0:
                            DeathmatchTask.start();
                            SurvivalGames.getGameManager().setGameType(GameType.DEATHMATCHPHASE);
                            stop();
                        break;
                    default:
                        break;
                }
            }
        }, 0, 1*20);
    }

    public static void stop(){
        Bukkit.getScheduler().cancelTask(game);
    }
}