package com.app.userApp.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    String userName;

    String userPassword;

    public User(String userName, String userPassword){
        this.userName = userName;
        this.userPassword = userPassword;
    }
}
