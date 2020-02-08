package de.snx.survivalgames.file;

import de.snx.survivalgames.SurvivalGames;
import de.snx.survivalgames.utils.FileBase;
import org.bukkit.configuration.file.FileConfiguration;

public class DefaultFile extends FileBase {

    public DefaultFile() {
        super("", "default_messages");
        writeDefaults();
    }

    private void writeDefaults() {
        FileConfiguration cfg = getConfig();
        cfg.addDefault("SURVIVALGAMES.MESSAGE.NOPERMISSION", "%PREFIX% &4Keine Berechtigung!");
        cfg.addDefault("SURVIVALGAMES.MESSAGE.NOMINECRAFTACCOUNT", "%PREFIX% &cEs existiert kein Minecraftaccount mit diesem Namen!");
        cfg.addDefault("SURVIVALGAMES.MESSAGE.NOTENOUGTPLAYERS", "%PREFIX% &cWarte auf weitere Spieler...");

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
}