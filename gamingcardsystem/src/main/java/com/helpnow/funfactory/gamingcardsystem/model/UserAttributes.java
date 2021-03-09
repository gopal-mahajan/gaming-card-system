package com.helpnow.funfactory.gamingcardsystem.model;

public class UserAttributes {
    private final String userName;
    private final String name;
    private final String contactNumber;

    public UserAttributes(String userName, String name, String contactNumber) {
        this.userName = userName;
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public String getuserName() {
        return userName;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() { return contactNumber; }
}
