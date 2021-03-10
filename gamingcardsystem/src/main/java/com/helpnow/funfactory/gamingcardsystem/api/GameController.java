package com.helpnow.funfactory.gamingcardsystem.api;


import com.helpnow.funfactory.gamingcardsystem.model.Game;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/game")
public class GameController {

    @PostMapping("/addGame")
    public Game addGame(@RequestParam int levels, @RequestParam int weekdayCost,
                          @RequestParam int weekendCost,
                          @RequestParam boolean hardRefresh) {
        return Game.getInstance(levels, weekdayCost, weekendCost, hardRefresh);
    }

}
