package com.helpnow.funfactory.gamingcardsystem.model;

public class Game {
    private static Game game = null;
    private int levels;

    private int weekDayCost;

    public int getLevels() {
        return levels;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }

    public int getWeekDayCost() {
        return weekDayCost;
    }

    public void setWeekDayCost(int weekDayCost) {
        this.weekDayCost = weekDayCost;
    }

    public int getWeekendCost() {
        return weekendCost;
    }

    public void setWeekendCost(int weekendCost) {
        this.weekendCost = weekendCost;
    }

    private int weekendCost;

    private Game(int levels, int weekDayCost, int weekendCost) {
        this.levels = levels;
        this.weekDayCost = weekDayCost;
        this.weekendCost = weekendCost;
    }

    public static Game getInstance(int levels, int weekDayCost, int weekendCost, boolean hardRefresh) {
        if (game == null || hardRefresh) {
            game = new Game(levels, weekDayCost, weekendCost);
        }
        return game;
    }

    public static Game getInstance() {
        return game;
    }
}
