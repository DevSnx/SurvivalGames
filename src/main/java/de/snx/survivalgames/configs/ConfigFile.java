package de.snx.survivalgames.configs;

import org.bukkit.configuration.file.FileConfiguration;

public class ConfigFile extends FileBase {

    public ConfigFile() {
        super("", "config");
        writeDefaults();
    }

    private void writeDefaults() {
        FileConfiguration cfg = getConfig();
        cfg.addDefault("SURIVALGAMES.CONFIG.PREFIX", "&8[&aSurvivalGames&8]");
        cfg.options().copyDefaults(true);
        saveConfig();
    }
}