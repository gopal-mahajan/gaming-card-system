package com.helpnow.funfactory.gamingcardsystem.config;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Constant {

    public static DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
    public static final int expiryYearLength = 2;
    public static final int LIMIT_USER_WRITE = 5;


   public enum GameStatus{
        SWIPED_IN,SWIPED_OUT
    }

}
