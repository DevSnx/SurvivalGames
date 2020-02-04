package de.snx.survivalgames.manager;

import de.snx.survivalgames.file.ChestFile;
import de.snx.survivalgames.file.ConfigFile;
import de.snx.survivalgames.file.LocationFile;
import de.snx.survivalgames.file.MessagesFile;

public class FileManager {

    public ConfigFile configFile;
    public MessagesFile messageFile;
    public LocationFile locationFile;
    public ChestFile chestFile;

    public FileManager(){
        this.chestFile = new ChestFile();
        this.configFile = new ConfigFile();
        this.locationFile = new LocationFile();
        this.chestFile = new ChestFile();
        this.messageFile = new MessagesFile();
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

    public MessagesFile getMessageFile() {
        return this.messageFile;
    }
}
