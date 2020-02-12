package de.snx.survivalgames.tasks;

import com.mojang.datafixers.types.templates.Check;
import de.snx.statsapi.StatsAPI;
import de.snx.statsapi.manager.other.PlayerStats;
import de.snx.survivalgames.SurvivalGames;
import de.snx.survivalgames.manager.other.GameType;
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
                            for (Player player : Bukkit.getOnlinePlayers()) {
                                PlayerStats stats = StatsAPI.getStatsManager().getPlayerStats(player.getUniqueId());
                                stats.addGames(1);
                                player.teleport(SurvivalGames.getFileManager().getLocationFile().getLocation("SPAWN." + id));
                                player.getInventory().clear();
                                SurvivalGames.getGameManager().players.add(player);
                                id++;
                            }
                            CheckTask.start();
                            SpawnTask.start();
                        } else {
                            lobbyint = 61;
                            Bukkit.broadcastMessage(SurvivalGames.getLanguageManager().getMessage("SURVIVALGAMES.MESSAGE.NOTENOUGTPLAYERS"));
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