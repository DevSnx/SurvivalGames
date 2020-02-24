package de.snx.survivalgames.file;

import de.snx.survivalgames.utils.FileBase;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;

public class ChestFile extends FileBase {

    public ChestFile(){
        super("","chest");
        writeDefaults();
    }

    public void writeDefaults(){
        FileConfiguration cfg = getConfig();
        List<String> tier1 = cfg.getStringList("SURVIVALGAMES.CHEST.ITEMS");
        tier1.add(Material.WOODEN_SWORD.toString() + ", 1, 60");
        tier1.add(Material.IRON_SWORD.toString() + ", 1, 25");
        tier1.add(Material.GOLDEN_SWORD.toString() + ", 1, 35");
        cfg.addDefault("SURVIVALGAMES.CHEST.ITEMS", tier1);

        List<String> tier2 = cfg.getStringList("SURVIVALGAMES.ENDERCHEST.ITEMS");
        tier2.add(Material.DIAMOND_AXE.toString() + ", 1, 35");
        tier2.add(Material.DIAMOND_SWORD.toString() + ", 1, 25");
        tier2.add(Material.GOLDEN_APPLE.toString() + ", 1, 10");
        cfg.addDefault("SURVIVALGAMES.ENDERCHEST.ITEMS", tier2);
        cfg.options().copyDefaults(true);
        saveConfig();
    }
}
