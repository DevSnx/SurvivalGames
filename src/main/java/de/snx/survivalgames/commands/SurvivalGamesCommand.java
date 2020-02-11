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

        if(!(sender instanceof Player)){
            sender.sendMessage("Nur Spieler können den Befehl ausführen!");
            return true;
        }

        Player player = (Player) sender;
            if(args.length == 0){
                sendHelp(player);
            }
        return true;
    }

    private void sendHelp(Player player) {
        File file = SurvivalGames.getLanguageManager().getLanguageFile();
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        for(String message : cfg.getStringList("SURVIVALGAMES.COMMANDS.HELPSITE")){
            message = message.replace("&", "§");
            player.sendMessage(message);
        }
    }
}