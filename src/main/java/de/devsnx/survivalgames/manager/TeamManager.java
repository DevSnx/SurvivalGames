package de.devsnx.survivalgames.manager;

import de.devsnx.survivalgames.manager.other.TeamTypes;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class TeamManager {

    public static ArrayList<Player> allPlayers;
    public static ArrayList<Player> T1;
    public static ArrayList<Player> T2;
    public static ArrayList<Player> T3;
    public static ArrayList<Player> T4;
    public static ArrayList<Player> T5;
    public static ArrayList<Player> T6;
    public static ArrayList<Player> T7;
    public static ArrayList<Player> T8;
    public static ArrayList<Player> none;

    public TeamManager(){
        this.T1 = new ArrayList<Player>();
        this.T2 = new ArrayList<Player>();
        this.T3 = new ArrayList<Player>();
        this.T4 = new ArrayList<Player>();
        this.T5 = new ArrayList<Player>();
        this.T6 = new ArrayList<Player>();
        this.T7 = new ArrayList<Player>();
        this.T8 = new ArrayList<Player>();
        this.none = new ArrayList<Player>();
    }

    public void addPlayerToTeam(Player player, TeamTypes teamTypes){
        if(T1.contains(player)){
            return;
        }
    }

    public void getTeamOfPlayer(){
        //RETURN TEAM!
    }

    public void removePlayerFromTeam(Player player){

    }
}