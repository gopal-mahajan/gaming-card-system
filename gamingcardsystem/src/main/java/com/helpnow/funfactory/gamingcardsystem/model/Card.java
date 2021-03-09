package com.helpnow.funfactory.gamingcardsystem.model;

import com.helpnow.funfactory.gamingcardsystem.config.Constant;

import java.time.LocalDate;
import java.util.UUID;

public class Card {

    private final String id;
    private final String userName;
    private long amount;
    private final String joiningDate;
    private final String expiryDate;

    public Card(String userName) {
        this(userName, 10);
    }

    public Card(String userName, long amount) {
        this.userName = userName;
        this.amount = amount;
        this.id = UUID.randomUUID().toString();
        this.joiningDate = LocalDate.now().format(Constant.formatter);
        this.expiryDate = LocalDate.now().plusYears(Constant.expiryYearLength).format(Constant.formatter);
    }

    public String getId() {
        return id;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getuserName() {
        return userName;
    }

}
