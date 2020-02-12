package de.snx.survivalgames.manager;

import de.snx.survivalgames.file.ChestFile;
import de.snx.survivalgames.file.ConfigFile;
import de.snx.survivalgames.file.LocationFile;

public class FileManager {

    public ConfigFile configFile;
    public LocationFile locationFile;
    public ChestFile chestFile;

    public FileManager(){
        this.chestFile = new ChestFile();
        this.configFile = new ConfigFile();
        this.locationFile = new LocationFile();
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
}
