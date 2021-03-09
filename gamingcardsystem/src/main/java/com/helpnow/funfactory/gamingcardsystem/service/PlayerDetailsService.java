package com.helpnow.funfactory.gamingcardsystem.service;

import com.helpnow.funfactory.gamingcardsystem.model.PlayerDetails;

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
}
