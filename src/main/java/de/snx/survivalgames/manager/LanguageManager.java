package de.snx.survivalgames.manager;

import de.snx.survivalgames.SurvivalGames;
import de.snx.survivalgames.manager.other.LanguageType;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class LanguageManager {

    public LanguageType languageType;

    public LanguageManager(){
        loadLanguages();
        loadLanguageTyppe();
    }

    public String getMessage(String path){
        if(isLanguageFileExists(getLanguageType())){
            File file = new File( "plugins/SurvivalGames/languages", getLanguageType().toString() + ".yml");
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

    public void loadLanguages(){
        File Language = new File(SurvivalGames.getInstance().getDataFolder(), "language.yml");
        File de_DE = new File(SurvivalGames.getInstance().getDataFolder() + "languages", "de_DE.yml");
        File en_EN = new File(SurvivalGames.getInstance().getDataFolder() + "languages", "en_EN.yml");
        if(!Language.exists()){
            SurvivalGames.getInstance().saveResource("language.yml", false);
        }
        if(!de_DE.exists()){
            SurvivalGames.getInstance().saveResource("languages/de_DE.yml", false);
        }
        if(!(en_EN.exists())){
            SurvivalGames.getInstance().saveResource("languages/en_EN.yml", false);
        }
    }

    public void loadLanguageTyppe(){
        File Language = new File(SurvivalGames.getInstance().getDataFolder(), "language.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(Language);
        this.languageType = LanguageType.getLanguageByName(cfg.getString("LANGUAGE"));
    }

    public LanguageType getLanguageType() {
        return languageType;
    }

    public void setLanguageType(LanguageType languageType) {
        this.languageType = languageType;
    }
}