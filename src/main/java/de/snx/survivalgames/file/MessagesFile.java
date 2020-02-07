package de.snx.survivalgames.file;

import de.snx.survivalgames.SurvivalGames;
import de.snx.survivalgames.utils.FileBase;
import org.bukkit.configuration.file.FileConfiguration;

public class MessagesFile extends FileBase {

    public MessagesFile() {
        super("", "message");
        writeDefaults();
    }

    private void writeDefaults() {
        FileConfiguration cfg = getConfig();
        cfg.addDefault("SURIVALGAMES.MESSAGE.NOPERMISSION", "%PREFIX% &4Keine Berechtigung!");
        cfg.addDefault("SURIVALGAMES.MESSAGE.NOMINECRAFTACCOUNT", "%PREFIX% &cEs existiert kein Minecraftaccount mit diesem Namen!");
        cfg.addDefault("SURVIVALGAMES.MESSAGE.LOBBY.NOTENOUGTPLAYERS", "%PREFIX% &cWarte auf weitere Spieler...");

        cfg.addDefault("SURVIVALGAMES.MESSAGE.LOBBY.JOIN", "%PREFIX% &e%PLAYER% &7hat das Spiel betreten.");
        cfg.addDefault("SURVIVALGAMES.MESSAGE.INGAME.JOIN", "%PREFIX% &4Spiel läuft bereits!");

        cfg.addDefault("SURVIVALGAMES.MESSAGE.LOBBY.QUIT", "%PREFIX% &e%PLAYER% &7hat das Spiel verlassen.");
        cfg.addDefault("SURVIVALGAMES.MESSAGE.INGAME.QUIT", "%PREFIX% &e%PLAYER% &7hat das Spiel verlassen.");

        cfg.addDefault("SURVIVALGAMES.MESSAGE.COUNTDOWN.LOBBY", "%PREFIX% &7Das Spiel startet in &e%SECONDS% &7Sekunden.");
        cfg.addDefault("SURVIVALGAMES.MESSAGE.COUNTDOWN.SPAWN", "%PREFIX% &7Das Spiel beginnt in &e%SECONDS% &7Sekunden.");
        cfg.addDefault("SURVIVALGAMES.MESSAGE.COUNTDOWN.PRETIME", "%PREFIX% &7Die Schutzzeit endet in &e%SECONDS% &7Sekunden.");
        cfg.addDefault("SURVIVALGAMES.MESSAGE.COUNTDOWN.DEATHMATCH", "%PREFIX% &7Das Deathmatch startet in &e%SECONDS% &7Sekunden.");
        cfg.addDefault("SURVIVALGAMES.MESSAGE.COUNTDOWN.RESTART", "%PREFIX% &7Der Server startet in &e%SECONDS% &7Sekunden neu.");

        cfg.addDefault("SURVIVALGAMES.MESSAGE.DEATH.KILLERMESSAGE", "%PREFIX% &7Du hast &e%PLAYER% &7getötet.");
        cfg.addDefault("SURVIVALGAMES.MESSAGE.DEATH.PLAYERMESSAGE", "%PREFIX% &7Der Spieler &e%KILLER%&7 hat dich getötet.");
        cfg.addDefault("SURVIVALGAMES.MESSAGE.DEATH.DEATHPLAYERMESSAGE", "%PREFIX% &e%KILLER% &7hat &e%PLAYER% &7getötet.");
        cfg.addDefault("SURVIVALGAMES.MESSAGE.DEATH.DEATHMESSAGE", "%PREFIX% &e%PLAYER% &7ist gestorben.");

        cfg.options().copyDefaults(true);
        saveConfig();
    }

    public String getMessage(String path){
        FileConfiguration cfg = SurvivalGames.getFileManager().getMessageFile().getConfig();
        FileConfiguration cfg2 = SurvivalGames.getFileManager().getConfigFile().getConfig();
        String prefix = cfg2.getString("SURIVALGAMES.CONFIG.PREFIX").replace("&", "§");
        String message = cfg.getString(path).replace("&", "§");
        if(message.contains("%NewLine%")){
            message = message.replace("%NewLine%", "\n");
        }
        if(message.contains("%PREFIX%")){
            message = message.replace("%PREFIX%", prefix);
        }
        return message;
    }
}