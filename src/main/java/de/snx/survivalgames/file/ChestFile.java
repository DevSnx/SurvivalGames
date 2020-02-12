package de.snx.survivalgames.file;

import de.snx.survivalgames.utils.FileBase;
import org.bukkit.configuration.file.FileConfiguration;

public class ChestFile extends FileBase {

    public ChestFile(){
        super("","chest");
        //writeDefaults();
    }

    public void writeDefaults(){
        FileConfiguration cfg = getConfig();

        cfg.options().copyDefaults(true);
        saveConfig();
    }
}
