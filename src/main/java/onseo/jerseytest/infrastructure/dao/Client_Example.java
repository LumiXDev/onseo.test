package onseo.jerseytest.infrastructure.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
/*
@Slf4j
public class Client_Example{

    private final Client client = ClientBuilder.newClient();

    Use the VALUE annotation to fetch external properties (e.g. from yaml config file):

    @Value("${placeholderclient.baseURI}")
    private String baseURI;

    Alternatively, one can use the Environment class to get
    external properties and their values. This field
    should be autowired automatically:

    @Autowired
    private Environment env;

    public void PROC() {
        String path = env.getProperty("PATH_BASE.PATH_NESTED...");
    }

    public Entity getEntity(int id, String endpointSuffix, Class<Entity> cls) {
        log.info("Client class has been called for entity " + cls.getName());

        Response response = client
                .target(baseURI + endpointSuffix + id)
                .request(MediaType.APPLICATION_JSON)
                .get();

        Invoking GET request as follows:
        T result = builder.get().readEntity(cls);
        For POST request use appropriate entities:
        Response response = builder.post(javax.ws.rs.client.Entity.entity(ENTITY_TYPE, MediaType.APPLICATION_JSON_TYPE));

        Entity result = handleResponse(response, cls);
        log.info("Response from JSON_Placeholder handled successfully");

        return result;

    }
    Sample proc for validating response object fields

    private T handleResponse(Response response, Class<T> cls)
    {
        if (response.getStatus() == 200) {
            return response.readEntity(cls);
        };

        Let's say our response status is not 200 or anything we expected:

        return null;
    }
}*/
