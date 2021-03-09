package com.helpnow.funfactory.gamingcardsystem.exceptions;

public class InsufficientBalanceException extends RuntimeException{

    public InsufficientBalanceException(){
        super("InsufficientBalance!! Add Balance in card!!");
    }
}
