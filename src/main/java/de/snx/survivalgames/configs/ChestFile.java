package de.snx.survivalgames.configs;

import de.snx.survivalgames.SurvivalGames;
import org.bukkit.configuration.file.FileConfiguration;

public class ChestFile extends FileBase{

    public ChestFile(){
        super("","chest");
        //writeDefaults();
    }

    public void writeDefaults(){
        FileConfiguration cfg = SurvivalGames.getFileManager().getChestFile().getConfig();






        cfg.options().copyDefaults(true);
        saveConfig();
    }
}
