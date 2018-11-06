package onseo.jerseytest.infrastructure.dao;

import lombok.extern.slf4j.Slf4j;
import onseo.jerseytest.infrastructure.dao.models.Entity;
import org.springframework.beans.factory.annotation.Value;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Slf4j
public class PlaceholderClient<T extends Entity>{

    private final Client client = ClientBuilder.newClient();

    @Value("${placeholderclient.baseURI}")
    private String baseURI;

    public T getEntity(int id, String endpointSuffix, Class<T> cls) {
        log.info("Client class has been called for entity " + cls.getName());

        Response response = client
                .target(baseURI + endpointSuffix + id)
                .request(MediaType.APPLICATION_JSON)
                .get();

        T result = handleResponse(response, cls);
        log.info("Response from JSON_Placeholder handled successfully");

        return result;

    }

    private T handleResponse(Response response, Class<T> cls)
    {
        if (response.getStatus() == 200) {
            return response.readEntity(cls);
        };
        return null;
    }
}
