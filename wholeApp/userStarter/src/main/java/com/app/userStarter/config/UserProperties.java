package com.app.userStarter.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "auth")
public class UserProperties {

    private String userName;

    private String userPassword;

    public UserProperties(String userName, String userPassword){
        this.userName = userName;
        this.userPassword = userPassword;
    }
}
