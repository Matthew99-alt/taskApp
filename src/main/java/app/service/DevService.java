package app.service;

import app.config.PermissionsConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Slf4j
@Profile("dev")
@Service
public class DevService implements CommandLineRunner {
    //TODO: datasource собрать в свой класс пропертей, вывести так же в лог, как и с Value (учти профиль DEV для старта!)

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    private final PermissionsConfig permissionsConfig;

    public DevService(PermissionsConfig permissionsConfig) {
        this.permissionsConfig = permissionsConfig;
    }

    @Override
    public void run(String... args) {
        log.info("DevService started with db url {}", dbUrl);
        log.info("DevService started with db password {}", password);
        log.info("DevService started with db username {}", username);
        log.info("DevService started with db driver class name {}", driverClassName);

        log.info("Service permissions password {}", permissionsConfig.getPassword());
        log.info("Service permissions username {}", permissionsConfig.getUsername());
        log.info("Service permissions roles {}", permissionsConfig.getRoles());
    }
}
