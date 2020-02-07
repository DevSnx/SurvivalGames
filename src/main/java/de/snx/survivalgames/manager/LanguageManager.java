package de.snx.survivalgames.manager;

import de.snx.survivalgames.SurvivalGames;
import de.snx.survivalgames.manager.other.LanguageType;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class LanguageManager {

    public LanguageType languageType;

    public LanguageManager(){
        loadLanguageTyppe();
    }

    public String getMessage(String path){
        if(isLanguageFileExists(getLanguageType())){
            File file = new File("plugins/SurvivalGames/languages", getLanguageType().toString() + ".yml");
            FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
            String message = cfg.getString(path);
            message = message.replace("&", "§");
            message = message.replace("%PREFIX%", SurvivalGames.getFileManager().getConfigFile().getConfig().getString("SURIVALGAMES.CONFIG.PREFIX").replace("&", "§"));
            return message;
        }
        return "§4No Language file is exists for §b" + getLanguageType().toString();
    }

    public boolean isLanguageFileExists(LanguageType languageType){
        File file = new File("plugins/SurvivalGames/languages", languageType.toString() + ".yml");
        if(file == null){
            return false;
        }else{
            return true;
        }
    }

    public void loadLanguageTyppe(){
       this.languageType = LanguageType.getLanguageByName(SurvivalGames.getFileManager().getConfigFile().getConfig().getString("SURIVALGAMES.CONFIG.LANGUAGE"));
    }

    public LanguageType getLanguageType() {
        return languageType;
    }

    public void setLanguageType(LanguageType languageType) {
        this.languageType = languageType;
    }
}