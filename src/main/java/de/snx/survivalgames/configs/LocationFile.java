package de.snx.survivalgames.configs;

import org.bukkit.configuration.file.FileConfiguration;

public class LocationFile extends FileBase{

    public LocationFile(){
        super("","location");
    }

    public void getLocation(){
        saveConfig();
    }

    public void saveLocation(){
        saveConfig();
    }

    public void changeLocation(){
        saveConfig();
    }

    public void deleteLocation(){
        saveConfig();
    }
}