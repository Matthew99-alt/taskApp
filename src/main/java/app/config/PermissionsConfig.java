package app.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Set;

@Getter
@ConfigurationProperties(prefix = "service.permissions")
public class PermissionsConfig {

    private final String username;
    private final String password;
    private final Set<String> roles;

    public PermissionsConfig(String username, String password, Set<String> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

}
