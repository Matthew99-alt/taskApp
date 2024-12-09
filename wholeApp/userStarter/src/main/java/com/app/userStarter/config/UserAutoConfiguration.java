package com.app.userStarter.config;

import com.app.userApp.service.User;
import com.app.userApp.service.UserConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(UserProperties.class)
public class UserAutoConfiguration {
    private final UserProperties userProperties;

    public UserAutoConfiguration(UserProperties userProperties){
        this.userProperties = userProperties;
    }

    @Bean
    public User user(){
        User newUser = new User(userProperties.getUserName(),userProperties.getUserPassword());
        if (newUser.getUserName() == null || newUser.getUserPassword() == null){
            newUser = new User("blablabla","1100");
        }
        return newUser;
    }

    @Bean
    public UserConfig userConfig(User user){
        return new UserConfig(user);
    }
}
