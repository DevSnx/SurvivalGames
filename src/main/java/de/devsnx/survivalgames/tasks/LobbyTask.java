package de.devsnx.survivalgames.tasks;

import de.devsnx.survivalgames.SurvivalGames;
import de.devsnx.survivalgames.manager.other.GameType;
import de.snx.statsapi.StatsAPI;
import de.snx.statsapi.manager.other.PlayerStats;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class LobbyTask {

    public static BukkitTask lobby;
    public static int lobbyint = SurvivalGames.getFileManager().getConfigFile().getConfig().getInt("SURIVALGAMES.CONFIG.COUNTDOWN.LOBBYTIME");

    public static void start() {
        lobby = new BukkitRunnable() {
            @Override
            public void run() {
                lobbyint--;
                switch (lobbyint) {
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
                        if (Bukkit.getServer().getOnlinePlayers().size() >= SurvivalGames.getFileManager().getConfigFile().getConfig().getInt("SURIVALGAMES.CONFIG.MIN_PLAYERS")) {
                            SurvivalGames.getGameManager().setGameType(GameType.SPAWNPHASE);
                            int id = 1;
                            for (Player all : Bukkit.getOnlinePlayers()) {
                                PlayerStats stats = StatsAPI.getStatsManager().getPlayerStats(all.getUniqueId());
                                stats.addGames(1);
                                all.teleport(SurvivalGames.getFileManager().getLocationFile().getLocation("SPAWN." + id));
                                all.getInventory().clear();
                                SurvivalGames.getGameManager().players.add(all);
                                id++;
                            }
                            SpawnTask.start();
                        } else {
                            CheckPlayersTask.start();
                        }
                        break;
                    case 0:
                        stop();
                        break;
                }
            }
        }.runTaskTimer(SurvivalGames.getInstance(), 0, 1 * 20);
    }

    public static void stop() {
        lobby.cancel();
    }
}