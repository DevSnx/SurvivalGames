package de.snx.survivalgames.manager;

import org.bukkit.Location;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;

public class ChestManager {

    public HashMap<Inventory, Location> chests;

    public ChestManager(){
        this.chests = new HashMap<Inventory, Location>();
        loadItemList();
    }

    public void loadItemList(){

    }

    public HashMap<Inventory, Location> getChests() {
        return this.chests;
    }
}