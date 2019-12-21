package de.snx.survivalgames.configs;

public class FileManager {

    private ConfigFile configFile;
    private MessagesFile messageFile;
    private LocationFile locationFile;
    private ChestFile chestFile;

    public FileManager(){
        this.configFile = new ConfigFile();
        this.messageFile = new MessagesFile();
        this.locationFile = new LocationFile();
        this.chestFile = new ChestFile();
    }

    public ChestFile getChestFile() {
        return chestFile;
    }

    public ConfigFile getConfigFile() {
        return configFile;
    }

    public LocationFile getLocationFile() {
        return locationFile;
    }

    public MessagesFile getMessageFile() {
        return messageFile;
    }
}
