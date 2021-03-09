package com.helpnow.funfactory.gamingcardsystem.api;

import com.helpnow.funfactory.gamingcardsystem.service.CardService;
import com.helpnow.funfactory.gamingcardsystem.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/card")
public class CardController {
    private CardService cardService;

    @PostMapping("/addAmount")
    public String addAmount(@RequestParam String userName, @RequestParam long amount){
        CardService.addAmount(userName, amount);
        return "Updated Card Balance for "+ userName+" is "+ UserService.users.get(userName).getCard().getAmount();
    }

    @PostMapping("/gameFees")
    public String gameFees(@RequestParam String userName, @RequestParam long amount){
        CardService.gameFee(userName,amount);
        return "Updated Card Balance for "+ userName+" is "+ UserService.users.get(userName).getCard().getAmount();
    }

}
