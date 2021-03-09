package com.helpnow.funfactory.gamingcardsystem.api;

import com.helpnow.funfactory.gamingcardsystem.config.Constant;
import com.helpnow.funfactory.gamingcardsystem.exceptions.InsufficientBalanceException;
import com.helpnow.funfactory.gamingcardsystem.exceptions.InvalidLevelException;
import com.helpnow.funfactory.gamingcardsystem.exceptions.NoUserExist;
import com.helpnow.funfactory.gamingcardsystem.model.Card;
import com.helpnow.funfactory.gamingcardsystem.model.Game;
import com.helpnow.funfactory.gamingcardsystem.model.PlayerDetails;
import com.helpnow.funfactory.gamingcardsystem.service.PlayerDetailsService;
import com.helpnow.funfactory.gamingcardsystem.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.InsufficientResourcesException;
import java.util.Date;

@RestController("/game/player")
public class PlayerController {
    PlayerDetailsService playerDetailsService;

    @PostMapping("/swipe_out")
    public PlayerDetails swipeOutUser(@RequestParam String userName) {
        PlayerDetails playerDetails = PlayerDetailsService.getPlayerHistory().get(userName);
        if (Constant.GameStatus.SWIPED_IN.equals(playerDetails.getGameStatus())) {
            playerDetails.setGameStatus(Constant.GameStatus.SWIPED_OUT);
            PlayerDetailsService.setPlayerHistory(playerDetails);
            return playerDetails;
        }
        return null;
    }

    @PostMapping("/swipe_in")
    public PlayerDetails swipeInUser(@RequestParam String userName, @RequestParam int level) {
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
        long cardAmount = UserService.users.get(userName).getCard().getAmount();
        int todayDay = new Date().getDay();

        if (!((incremental && currentLevel + 1 == level) || (!incremental && currentLevel - 1 == level)) && gameStatus.equals("SWIPED_OUT")) {
            throw new InvalidLevelException("");
        }
        Game game = Game.getInstance();
        int todayCost = game.getWeekDayCost();
        if (todayDay == 0 || todayDay == 6) {
            todayCost = game.getWeekendCost();
        }
        if (cardAmount < todayCost || cardAmount - todayCost < 10) {
            throw new InsufficientBalanceException();
        }
        UserService.users.get(userName).getCard().setAmount(cardAmount - todayCost);
        playerDetails = new PlayerDetails(level, userName, new Date(), Constant.GameStatus.SWIPED_IN, incremental);
        return playerDetails;
    }

}
