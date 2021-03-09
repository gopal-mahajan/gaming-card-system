package com.helpnow.funfactory.gamingcardsystem.exceptions;

public class InvalidLevelException extends RuntimeException {

    public InvalidLevelException(String message){
        super("Invalid Level!! " + message);
    }
}
