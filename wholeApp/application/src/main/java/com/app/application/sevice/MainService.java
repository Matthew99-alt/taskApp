package com.app.application.sevice;

import com.app.userApp.service.UserConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class MainService implements CommandLineRunner {

    private final UserConfig userConfig;

    public MainService(UserConfig userConfig){
        this.userConfig = userConfig;
    }

    @Override
    public void run(String... args) {
        userConfig.checkUser("stepa", "1109");
    }
}
