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
        return playerDetailsService.swipeOutUser(userName);
    }

    @PostMapping("/swipe_in")
    public PlayerDetails swipeInUser(@RequestParam String userName, @RequestParam int level) {
        return playerDetailsService.swipeInUser(userName, level);
    }

}
