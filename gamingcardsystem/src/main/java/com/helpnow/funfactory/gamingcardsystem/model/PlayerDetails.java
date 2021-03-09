package com.helpnow.funfactory.gamingcardsystem.model;

import com.helpnow.funfactory.gamingcardsystem.config.Constant;

import java.util.Date;

public class PlayerDetails {

    public boolean isIncrementalGame() {
        return incrementalGame;
    }

    public void setIncrementalGame(boolean incrementalGame) {
        this.incrementalGame = incrementalGame;
    }

    public PlayerDetails(int gameLevel, String userName, Date gameDate, Constant.GameStatus gameStatus, boolean incrementalGame) {
        this.gameLevel = gameLevel;
        this.userName = userName;
        this.gameDate = gameDate;
        this.incrementalGame = incrementalGame;
        this.gameStatus = gameStatus;
    }

    public int getGameLevel() {
        return gameLevel;
    }

    public void setGameLevel(int gameLevel) {
        this.gameLevel = gameLevel;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getGameDate() {
        return gameDate;
    }

    public void setGameDate(Date gameDate) {
        this.gameDate = gameDate;
    }

    private int gameLevel;

    private String userName;

    private Date gameDate;

    private Constant.GameStatus gameStatus;

    private boolean incrementalGame;

    public Constant.GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(Constant.GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
}
