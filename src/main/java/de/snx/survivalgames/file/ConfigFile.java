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
        cfg.addDefault("SURIVALGAMES.CONFIG.LANGUAGE", "en_EN");
        cfg.addDefault("SURIVALGAMES.CONFIG.FALLBACKSERVER", "Lobby");
        cfg.addDefault("SURIVALGAMES.CONFIG.MIN_PLAYERS", 2);
        cfg.addDefault("SURIVALGAMES.CONFIG.MAX_PLAYERS", 8);
        cfg.addDefault("SURIVALGAMES.CONFIG.MOTD.LOBBY", "&aLobby");
        cfg.addDefault("SURIVALGAMES.CONFIG.MOTD.FULL_LOBBY", "&6Lobby");
        cfg.addDefault("SURIVALGAMES.CONFIG.MOTD.INGAME", "&4Ingame");
        cfg.addDefault("SURIVALGAMES.CONFIG.MOTD.RESTART", "&cRestart");
        cfg.options().copyDefaults(true);
        saveConfig();
    }
}