package de.snx.survivalgames.utils;

import de.snx.survivalgames.SurvivalGames;
import org.bukkit.entity.Player;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

public class Utils {

    public static void joinserver(Player p, String servername) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        try {
            out.writeUTF("Connect");
            out.writeUTF(servername);
        } catch (Exception localException) {
        }
        p.sendPluginMessage(SurvivalGames.getInstance(), "BungeeCord", out.toByteArray());
    }
}