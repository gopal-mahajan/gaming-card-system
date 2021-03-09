package com.helpnow.funfactory.gamingcardsystem.exceptions;

public class NoUserExist extends RuntimeException{

    public NoUserExist(){
        super("No User Exists!! Please Add Users");
    }
}
