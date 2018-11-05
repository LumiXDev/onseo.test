package onseo.jerseytest;

import onseo.jerseytest.infrastructure.dao.models.ToDoEntity;
import onseo.jerseytest.services.SummaryService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Sample/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SampleEndpoint {

    private final SummaryService service;

    @Inject
    public SampleEndpoint(SummaryService service) {
        this.service = service;
    }

    @GET
    public String sampleString() {
        return "This is a sample jersey string I created.";
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ToDoEntity sampleToDo(@PathParam("id") int id) {
        return service.getToDo(id);
    }



}
