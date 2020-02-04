package de.snx.survivalgames.file;

import de.snx.survivalgames.utils.FileBase;

public class LocationFile extends FileBase {

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