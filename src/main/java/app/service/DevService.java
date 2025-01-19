package app.service;

import app.config.PermissionsConfig;
import app.properties.DatasourceProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Slf4j
@Profile("dev")
@Service
public class DevService implements CommandLineRunner {
    private final DatasourceProperties datasourceProperties;

    private final PermissionsConfig permissionsConfig;

    public DevService(DatasourceProperties datasourceProperties, PermissionsConfig permissionsConfig) {
        this.datasourceProperties = datasourceProperties;
        this.permissionsConfig = permissionsConfig;
    }

    @Override
    public void run(String... args) {
        log.info("DevService started with db url {}", datasourceProperties.getUrl());
        log.info("DevService started with db password {}", datasourceProperties.getPassword());
        log.info("DevService started with db username {}", datasourceProperties.getUsername());
        log.info("DevService started with db driver class name {}", datasourceProperties.getDriverClassName());

        log.info("Service permissions password {}", permissionsConfig.getPassword());
        log.info("Service permissions username {}", permissionsConfig.getUsername());
        log.info("Service permissions roles {}", permissionsConfig.getRoles());
    }
}
