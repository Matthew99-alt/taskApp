package com.app.userApp.service;

public class UserConfig {

    private final User user;

    public UserConfig(User user) {
        this.user = user;
    }

    public void checkUser(String name, String password){
        if(user.getUserName()==name&&user.getUserPassword()==password){
            System.out.println("User is authorized, welcome back!");
        }else{
            System.out.println("Access denied");
        }
    };

}
