package de.devsnx.survivalgames.manager;

import de.devsnx.survivalgames.file.TeamFile;
import de.devsnx.survivalgames.file.ChestFile;
import de.devsnx.survivalgames.file.ConfigFile;
import de.devsnx.survivalgames.file.LocationFile;

public class FileManager {

    public ConfigFile configFile;
    public LocationFile locationFile;
    public ChestFile chestFile;
    public TeamFile teamFile;

    public FileManager(){
        this.chestFile = new ChestFile();
        this.configFile = new ConfigFile();
        this.locationFile = new LocationFile();
        this.teamFile = new TeamFile();
    }

    public ConfigFile getConfigFile() {
        return this.configFile;
    }

    public ChestFile getChestFile() {
        return this.chestFile;
    }

    public LocationFile getLocationFile() {
        return this.locationFile;
    }

    public TeamFile getTeamFile() {
        return this.teamFile;
    }
}
