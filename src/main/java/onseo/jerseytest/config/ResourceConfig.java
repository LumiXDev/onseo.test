package onseo.jerseytest.config;


import lombok.extern.slf4j.Slf4j;
import onseo.jerseytest.SampleEndpoint;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ResourceConfig extends org.glassfish.jersey.server.ResourceConfig {
    ResourceConfig(){
        register(SampleEndpoint.class);

        //Register endpoints for jersey here if necessary
        //Like so:
        //register(ENDP_CLS.class);
    }
}
