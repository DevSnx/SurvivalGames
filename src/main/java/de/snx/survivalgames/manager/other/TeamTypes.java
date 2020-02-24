package de.snx.survivalgames.manager.other;

import net.md_5.bungee.api.ChatColor;

public enum TeamTypes {

    RED(ChatColor.RED, 1),
    BLUE(ChatColor.BLUE, 2),
    GREEN(ChatColor.GREEN, 3),
    YELLOW(ChatColor.YELLOW, 4),
    PRUPLE(ChatColor.LIGHT_PURPLE, 5),
    BLACK(ChatColor.BLACK, 6),
    WHITE(ChatColor.WHITE, 7),
    ORANGE(ChatColor.GOLD, 8);

    ChatColor color;
    int Teamid;

    private TeamTypes(ChatColor color, int teamid){
        this.color = color;
        this.Teamid = teamid;
    }

    public ChatColor getColor() {
        return color;
    }

    public int getTeamid() {
        return Teamid;
    }

    public static TeamTypes getTeambyTeamID(int id) {
        TeamTypes[] arrayOfTeams;
        int j = (arrayOfTeams = values()).length;
        for (int i = 0; i < j; i++) {
            TeamTypes teams = arrayOfTeams[i];
            if(teams.getTeamid() == id){
                return teams;
            }
        }
        return null;
    }
}