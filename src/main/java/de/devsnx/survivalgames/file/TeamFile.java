package de.devsnx.survivalgames.file;

import de.devsnx.survivalgames.manager.other.TeamTypes;
import de.devsnx.survivalgames.utils.FileBase;
import org.bukkit.configuration.file.FileConfiguration;

public class TeamFile extends FileBase {

    public TeamFile() {
        super("", "teams");
        writeDefaults();
    }


    private void writeDefaults() {
        FileConfiguration cfg = getConfig();
        cfg.addDefault("TEAMS.TEAMMODE", true);
        cfg.addDefault("TEAMS.PLAYERSPROTEAM", 1);
        cfg.addDefault("TEAMS.JOINITEM.NAME", "&4Team Selector");

        cfg.addDefault("TEAMS." + TeamTypes.getTeambyTeamID(1).toString() + ".ENABLE", true);
        cfg.addDefault("TEAMS." + TeamTypes.getTeambyTeamID(2).toString() + ".ENABLE", true);
        cfg.addDefault("TEAMS." + TeamTypes.getTeambyTeamID(3).toString() + ".ENABLE", true);
        cfg.addDefault("TEAMS." + TeamTypes.getTeambyTeamID(4).toString() + ".ENABLE", true);
        cfg.addDefault("TEAMS." + TeamTypes.getTeambyTeamID(5).toString() + ".ENABLE", true);
        cfg.addDefault("TEAMS." + TeamTypes.getTeambyTeamID(6).toString() + ".ENABLE", true);
        cfg.addDefault("TEAMS." + TeamTypes.getTeambyTeamID(7).toString() + ".ENABLE", true);
        cfg.addDefault("TEAMS." + TeamTypes.getTeambyTeamID(8).toString() + ".ENABLE", true);
        cfg.options().copyDefaults(true);
        saveConfig();
    }
}