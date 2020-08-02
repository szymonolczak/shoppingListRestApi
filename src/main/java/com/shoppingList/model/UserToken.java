package com.shoppingList.model;

public class UserToken {

    private String userName;

    public UserToken(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
