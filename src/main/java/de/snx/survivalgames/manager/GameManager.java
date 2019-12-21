package de.snx.survivalgames.manager;

import de.snx.survivalgames.GameType;

public class GameManager {

    GameType gameType;

    public GameManager(){
        this.gameType = GameType.LOBBYPHASE;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }
}