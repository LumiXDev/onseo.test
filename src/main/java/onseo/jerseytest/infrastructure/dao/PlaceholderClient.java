package onseo.jerseytest.infrastructure.dao;

//import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import onseo.jerseytest.infrastructure.dao.models.Entity;
import org.springframework.beans.factory.annotation.Value;
//import org.glassfish.jersey.client.JerseyClient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
//import javax.ws.rs.client.Invocation;
//import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
//import javax.ws.rs.core.Response;

@Slf4j
public class PlaceholderClient<T extends Entity>{

    private final Client client = ClientBuilder.newClient();

    //Use the VALUE annotation to fetch external properties (e.g. from yaml config file):
    @Value("${placeholderclient.baseURI}")
    private String baseURI;

    /*
    Alternatively, one can use the Environment class to get
    external properties and their values. This field
    should be autowired automatically:
    @Autowired
    private Environment env;

    public void PROC() {
        String path = env.getProperty("PATH_BASE.PATH_NESTED...");
    }
    */

    public T getEntity(int id, String endpointSuffix, Class<T> cls) {
        log.info("Client class has been called for entity " + cls.getName());

        Response response = client
                .target(baseURI + endpointSuffix + id)
                .request(MediaType.APPLICATION_JSON)
                .get();

        //Invoking GET request as follows:
        //T result = builder.get().readEntity(cls);
        //For POST request use appropriate entities:
        //Response response = builder.post(javax.ws.rs.client.Entity.entity(ENTITY_TYPE, MediaType.APPLICATION_JSON_TYPE));

        //TODO: investigate Response class and its dependencies

        T result = handleResponse(response, cls);
        log.info("Response from JSON_Placeholder handled successfully");

        return result;

    }
    //proc for validating response object fields
    private T handleResponse(Response response, Class<T> cls)
    {
        if (response.getStatus() == 200) {
            return response.readEntity(cls);
        };
        return null;
    }
}
