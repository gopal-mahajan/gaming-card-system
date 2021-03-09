package com.helpnow.funfactory.gamingcardsystem.exceptions;

public class UserAlreadyException extends RuntimeException {

    public UserAlreadyException(){
        super("User Id Already Exists");
    }
}
