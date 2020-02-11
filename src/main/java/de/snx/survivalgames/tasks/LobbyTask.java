package de.snx.survivalgames.tasks;

import de.snx.survivalgames.SurvivalGames;
import de.snx.survivalgames.manager.GameManager;
import de.snx.survivalgames.manager.other.GameType;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class LobbyTask {

    public static int Lobby;
    public static int lobbyint = 61;

    public static void start(){

        Lobby = Bukkit.getScheduler().scheduleAsyncRepeatingTask(SurvivalGames.getInstance(), new BukkitRunnable() {

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
                    case 1:
                        String message = SurvivalGames.getLanguageManager().getMessage("SURVIVALGAMES.MESSAGE.COUNTDOWN.LOBBY");
                        message = message.replace("%SECONDS%", String.valueOf(lobbyint));
                        Bukkit.broadcastMessage(message);
                        break;
                    case 0:
                        if(!(Bukkit.getOnlinePlayers().size() >= SurvivalGames.getGameManager().getMin_players())){
                                lobbyint = 61;
                                Bukkit.broadcastMessage(SurvivalGames.getLanguageManager().getMessage("SURVIVALGAMES.MESSAGE.NOTENOUGTPLAYERS"));
                        }else{
                            SurvivalGames.getGameManager().setGameType(GameType.SPAWNPHASE);
                            SpawnTask.start();
                            stop();
                        }
                        break;
                    default:
                        break;
                }
            }
        }, 0, 1*20);
    }

    public static void stop(){
        Bukkit.getScheduler().cancelTask(Lobby);
    }
}