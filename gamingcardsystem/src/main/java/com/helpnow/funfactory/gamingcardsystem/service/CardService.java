package com.helpnow.funfactory.gamingcardsystem.service;

public class CardService {

    public static void addAmount(String userName,long amount){
        long initialAmount= UserService.users.get(userName).getCard().getAmount();
        UserService.users.get(userName).getCard().setAmount(initialAmount+amount);
    }

    public static void gameFee(String userName,long amount){
        long initialAmount= UserService.users.get(userName).getCard().getAmount();
        UserService.users.get(userName).getCard().setAmount(initialAmount-amount);
    }


}
