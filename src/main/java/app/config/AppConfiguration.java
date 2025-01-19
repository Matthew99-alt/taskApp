package app.config;

import app.properties.DatasourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({PermissionsConfig.class, DatasourceProperties.class})
public class AppConfiguration {

}
