package de.snx.survivalgames.file;

import de.snx.survivalgames.utils.FileBase;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigFile extends FileBase {

    public ConfigFile() {
        super("", "config");
        writeDefaults();
    }

    private void writeDefaults() {
        FileConfiguration cfg = getConfig();
        cfg.addDefault("SURIVALGAMES.CONFIG.PREFIX", "&8[&aSurvivalGames&8]");
        cfg.addDefault("SURIVALGAMES.CONFIG.FALLBACKSERVER", "Lobby");
        cfg.addDefault("SURIVALGAMES.CONFIG.FALLDISTANCE", 50);
        cfg.addDefault("SURIVALGAMES.CONFIG.MIN_PLAYERS", 2);
        cfg.addDefault("SURIVALGAMES.CONFIG.MAX_PLAYERS", 8);
        cfg.addDefault("SURIVALGAMES.CONFIG.MOTD.LOBBY", "&aLobby");
        cfg.addDefault("SURIVALGAMES.CONFIG.MOTD.FULL_LOBBY", "&6Lobby");
        cfg.addDefault("SURIVALGAMES.CONFIG.MOTD.INGAME", "&4Ingame");
        cfg.addDefault("SURIVALGAMES.CONFIG.MOTD.RESTART", "&cRestart");
        cfg.addDefault("SURIVALGAMES.CONFIG.COUNTDOWN.LOBBYTIME", 61);
        cfg.addDefault("SURIVALGAMES.CONFIG.COUNTDOWN.SPAWNTIME", 5);
        cfg.addDefault("SURIVALGAMES.CONFIG.COUNTDOWN.GRAYTIME", 300);
        cfg.addDefault("SURIVALGAMES.CONFIG.COUNTDOWN.GAMETIME", 10000);
        cfg.addDefault("SURIVALGAMES.CONFIG.COUNTDOWN.DEATHMATCHTIME", 500);
        cfg.addDefault("SURIVALGAMES.CONFIG.COUNTDOWN.RESTARTIME", 15);
        cfg.options().copyDefaults(true);
        saveConfig();
    }
}