package de.snx.survivalgames.commands;

        import org.bukkit.command.Command;
        import org.bukkit.command.CommandExecutor;
        import org.bukkit.command.CommandSender;
        import org.bukkit.entity.Player;

public class SurvivalGamesCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage("Nur Spieler können den Befehl ausführen!");
            return true;
        }

        Player p = (Player) sender;

        if(args.length == 0){
            p.sendMessage("");
        }
        return true;
    }
}