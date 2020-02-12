package de.snx.survivalgames.manager;

import de.snx.survivalgames.SurvivalGames;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChestManager {

    public HashMap<Location, Inventory> chests;
    public List<ItemStack> items_tier1;
    public List<ItemStack> items_tier2;

    public ChestManager(){
        this.chests = new HashMap<Location, Inventory>();
        this.items_tier1 = new ArrayList<ItemStack>();
        this.items_tier2 = new ArrayList<ItemStack>();
        loadItemList();
    }

    public void loadItemList(){
        int tier1items = 1;
        int tier2items = 1;
        for(String all : SurvivalGames.getFileManager().getChestFile().getConfig().getStringList("SURVIVALGAMES.CHEST.ITEMS")){
            String material = "";
            int amount = 0;
            int chance = 0;

            String[] array = all.split(", ");
            material = String.valueOf(array[0]);
            amount = Integer.valueOf(array[1]);
            chance = Integer.valueOf(array[2]);

            for(int i = 0; i < chance; i++){
                items_tier1.add(new ItemStack(Material.valueOf(material), amount));
            }
        }
        for(String all : SurvivalGames.getFileManager().getChestFile().getConfig().getStringList("SURVIVALGAMES.ENDERCHEST.ITEMS")){
            String material = "";
            int amount = 0;
            int chance = 0;

            String[] array = all.split(", ");
            material = String.valueOf(array[0]);
            amount = Integer.valueOf(array[1]);
            chance = Integer.valueOf(array[2]);

            for(int i = 0; i < chance; i++){
                items_tier2.add(new ItemStack(Material.valueOf(material), amount));
                tier2items++;
            }
        }
    }

    public List<ItemStack> getItems_tier1() {
        return items_tier1;
    }

    public List<ItemStack> getItems_tier2() {
        return items_tier2;
    }

    public HashMap<Location, Inventory> getChests() {
        return this.chests;
    }
}