package com.helpnow.funfactory.gamingcardsystem.service;

import com.helpnow.funfactory.gamingcardsystem.config.Constant;
import com.helpnow.funfactory.gamingcardsystem.exceptions.InsufficientBalanceException;
import com.helpnow.funfactory.gamingcardsystem.exceptions.InvalidLevelException;
import com.helpnow.funfactory.gamingcardsystem.exceptions.InvalidRequestException;
import com.helpnow.funfactory.gamingcardsystem.model.Game;
import com.helpnow.funfactory.gamingcardsystem.model.PlayerDetails;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PlayerDetailsService {

    static Map<String, PlayerDetails> playerHistory = new HashMap<>();

    public static Map<String, PlayerDetails> getPlayerHistory() {
        return playerHistory;
    }

    public static void setPlayerHistory(PlayerDetails playerdetails) {
        playerHistory.put(playerdetails.getUserName(), playerdetails);
    }

    public PlayerDetails swipeInUser(String userName, int level) {
        PlayerDetails playerDetails = PlayerDetailsService.getPlayerHistory().get(userName);
        if (playerDetails == null) {
            if (level == 1
                    || level == Game.getInstance().getLevels()) {
                boolean incremental = true;
                if (level == Game.getInstance().getLevels())
                    incremental = false;
                playerDetails = new PlayerDetails(level, userName, new Date(), Constant.GameStatus.SWIPED_IN, incremental);
                return playerDetails;
            } else {
                throw new InvalidLevelException("Starting levels can be G1 or G" + Game.getInstance().getLevels());
            }
        }

        boolean incremental = playerDetails.isIncrementalGame();
        int currentLevel = playerDetails.getGameLevel();
        String gameStatus = playerDetails.getGameStatus().name();
        if (!((incremental && currentLevel + 1 == level) || (!incremental && currentLevel - 1 == level)) && gameStatus.equals("SWIPED_OUT")) {
            throw new InvalidLevelException("");
        }
        playerDetails = new PlayerDetails(level, userName, new Date(), Constant.GameStatus.SWIPED_IN, incremental);
        return playerDetails;
    }

    public PlayerDetails swipeOutUser(String userName) {
        PlayerDetails playerDetails = PlayerDetailsService.getPlayerHistory().get(userName);
        if (Constant.GameStatus.SWIPED_IN.equals(playerDetails.getGameStatus())) {
            long cardAmount = UserService.users.get(userName).getCard().getAmount();
            Game game = Game.getInstance();
            int todayDay = new Date().getDay();
            int todayCost = todayDay == 0 || todayDay == 6 ? game.getWeekendCost() : game.getWeekDayCost();
            if (cardAmount < todayCost || cardAmount - todayCost < 10) {
                throw new InsufficientBalanceException();
            }
            UserService.users.get(userName).getCard().setAmount(cardAmount - todayCost);
            playerDetails.setGameStatus(Constant.GameStatus.SWIPED_OUT);
            PlayerDetailsService.setPlayerHistory(playerDetails);
            return playerDetails;
        }
        throw new InvalidRequestException();
    }
}
