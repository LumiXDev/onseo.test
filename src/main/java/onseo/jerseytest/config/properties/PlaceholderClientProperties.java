package onseo.jerseytest.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("placeholderclient.params")
public class PlaceholderClientProperties {
    private int mockport;
    private int timeout;
    private int retries;
}
