package onseo.jerseytest.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("placeholderclient")
public class PlaceholderClientProperties {
    private String hostURL;
    private int port;
    private String toDoPath;
    private String commentPath;
    private String userPath;
}
