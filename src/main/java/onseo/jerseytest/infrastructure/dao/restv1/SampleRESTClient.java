package onseo.jerseytest.infrastructure.dao.restv1;

import onseo.jerseytest.infrastructure.dao.models.ToDoEntity;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;


//Simple calling service. TODO: Relocate this to DAO
public class SampleRESTClient {

    //TODO: reallocate this field to app config file somewhere

    private static final String REST_TODO_URI
            = "http://localhost:8080/ToDos";

    private Client client = ClientBuilder.newClient();

    public ToDoEntity getToDoEntity(int todoId) {

        //TODO: Concatenate ID into query string in an elegant way

        return client.target(REST_TODO_URI).path("/todos").request(MediaType.APPLICATION_JSON_TYPE).get(ToDoEntity.class);
    }
}
