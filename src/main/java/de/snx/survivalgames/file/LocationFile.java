package de.snx.survivalgames.file;

import de.snx.survivalgames.SurvivalGames;
import de.snx.survivalgames.utils.FileBase;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

public class LocationFile extends FileBase {

    public LocationFile() {
        super("", "location");
    }


    public void saveLocation(Location loc, String path) {
        FileConfiguration cfg = getConfig();
        cfg.set("LOCATION." + path + ".WORLD", loc.getWorld().getName());
        cfg.set("LOCATION." + path + ".X", Double.valueOf(loc.getX()));
        cfg.set("LOCATION." + path + ".Y", Double.valueOf(loc.getY()));
        cfg.set("LOCATION." + path + ".Z", Double.valueOf(loc.getZ()));
        cfg.set("LOCATION." + path + ".YAW", Double.valueOf(loc.getYaw()));
        cfg.set("LOCATION." + path + ".PITCH", Double.valueOf(loc.getPitch()));
        saveConfig();
    }

    public Location getLocation(String path) {
        FileConfiguration cfg = getConfig();
        if (cfg.getString("LOCATION." + path) != null) {
            String world = cfg.getString("LOCATION." + path + ".WORLD");
            double x = cfg.getDouble("LOCATION." + path + ".X");
            double y = cfg.getDouble("LOCATION." + path + ".Y");
            double z = cfg.getDouble("LOCATION." + path + ".Z");
            float yaw = (float) cfg.getDouble("LOCATION." + path + ".YAW");
            float pitch = (float) cfg.getDouble("LOCATION." + path + ".PITCH");
            Location loc = new Location(Bukkit.getWorld(world), x, y, z);
            loc.setPitch(pitch);
            loc.setYaw(yaw);
            return loc;
        } else {
            return null;
        }
    }

    public enum LocationType {
        SPAWN, DEATHMATCH;
    }
}