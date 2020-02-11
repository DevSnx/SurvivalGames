package de.snx.survivalgames.commands;

import de.snx.survivalgames.SurvivalGames;
import de.snx.survivalgames.manager.other.LanguageType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import java.io.File;

public class SurvivalGamesCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Nur Spieler können den Befehl ausführen!");
            return true;
        }

        Player player = (Player) sender;
        if (args.length < 1 || args.length > 2) {
            if(player.hasPermission("survivalgames.*")){
                sendHelp(player);
                return true;
            }else{
                SurvivalGames.getLanguageManager().getMessage("SURVIVALGAMES.MESSAGE.NOPERMISSION");
                return true;
            }
        }
        if(args.length == 1){
            player.sendMessage("HALLO!");
            if(args[0].equalsIgnoreCase("start")){
                if(player.hasPermission("survivalgames.start") || player.hasPermission("survivalgames.*")){
                    player.sendMessage(SurvivalGames.getLanguageManager().getMessage("SURVIVALGAMES.COMMANDS.START"));
                    return true;
                }else{
                    SurvivalGames.getLanguageManager().getMessage("SURVIVALGAMES.MESSAGE.NOPERMISSION");
                    return true;
                }
            }else if(args[0].equalsIgnoreCase("setlobby")){
                if(player.hasPermission("survivalgames.setlobby") || player.hasPermission("survivalgames.*")){
                    SurvivalGames.getFileManager().getLocationFile().saveLocation(player.getLocation(), "LOBBY");
                    player.sendMessage(SurvivalGames.getLanguageManager().getMessage("SURVIVALGAMES.COMMANDS.SETLOBBY"));
                    return true;
                }else{
                    SurvivalGames.getLanguageManager().getMessage("SURVIVALGAMES.MESSAGE.NOPERMISSION");
                    return true;
                }
            }else{
                sendHelp(player);
                return true;
            }
        }
        if(args.length == 2){
            if(args[0].equalsIgnoreCase("setspawn")){
                try{
                    int number = Integer.parseInt(args[0]);
                    SurvivalGames.getFileManager().getLocationFile().saveLocation(player.getLocation(), "SPAWN." + number);
                    player.sendMessage(SurvivalGames.getLanguageManager().getMessage("SURVIVALGAMES.COMMANDS.SETSPAWN.SUCCESSFUL"));
                    return true;
                }catch( NumberFormatException ex){
                    player.sendMessage(SurvivalGames.getLanguageManager().getMessage("SURVIVALGAMES.COMMANDS.SETSPAWN.ERROR"));
                    return true;
                }
            }else{
                sendHelp(player);
                return true;
            }
        }else{
            return true;
        }
    }

    private void sendHelp(Player player) {
        File file = SurvivalGames.getLanguageManager().getLanguageFile();
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        for (String message : cfg.getStringList("SURVIVALGAMES.COMMANDS.HELPSITE")) {
            message = message.replace("&", "§");
            player.sendMessage(message);
        }
    }
}