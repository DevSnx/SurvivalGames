package de.snx.survivalgames.listener.player;

import de.snx.survivalgames.SurvivalGames;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import java.util.Random;

public class PlayerInteract implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Player p = event.getPlayer();
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(event.getClickedBlock().getType() == Material.TRAPPED_CHEST || event.getClickedBlock().getType() == Material.CHEST){
                Location loc = event.getClickedBlock().getLocation();
                if(SurvivalGames.getChestManager().getChests().containsKey(loc)){
                    event.setCancelled(true);
                    p.openInventory(SurvivalGames.getChestManager().getChests().get(loc));
                }else{
                    event.setCancelled(true);
                    Random r = new Random();
                    int l = r.nextInt(15);
                    Inventory inv = Bukkit.createInventory(null, InventoryType.CHEST, "§cSurvivalGames §8- §aTier I");
                    while(l != 0){
                        l--;
                        Random r2 = new Random();
                        Random r3 = new Random();
                        int n2 = r2.nextInt(27);
                        int n3 = r3.nextInt(SurvivalGames.getChestManager().getItems_tier1().size());
                        inv.setItem(n2, SurvivalGames.getChestManager().getItems_tier1().get(n3));
                    }
                    SurvivalGames.getChestManager().chests.put(loc, inv);
                    p.openInventory(SurvivalGames.getChestManager().getChests().get(loc));
                }
            }else if(event.getClickedBlock().getType() == Material.ENDER_CHEST){
                Location loc = event.getClickedBlock().getLocation();
                if(SurvivalGames.getChestManager().getChests().containsKey(loc)){
                    event.setCancelled(true);
                    p.openInventory(SurvivalGames.getChestManager().getChests().get(loc));
                }else{
                    event.setCancelled(true);
                    Random r = new Random();
                    int l = r.nextInt(15);
                    Inventory inv = Bukkit.createInventory(null, InventoryType.CHEST, "§cSurvivalGames §8- §bTier II");
                    while(l != 0){
                        l--;
                        Random r2 = new Random();
                        Random r3 = new Random();
                        int n2 = r2.nextInt(27);
                        int n3 = r3.nextInt(SurvivalGames.getChestManager().getItems_tier2().size());
                        inv.setItem(n2, SurvivalGames.getChestManager().getItems_tier2().get(n3));
                    }
                    SurvivalGames.getChestManager().chests.put(loc, inv);
                    p.openInventory(SurvivalGames.getChestManager().getChests().get(loc));
                }
            }else{
                return;
            }
            return;
        }
        return;
    }
}