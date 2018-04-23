package com.jda.resource;

import com.jda.bo.GroovyPerson;
import com.jda.dao.PersonDAO;
import com.jda.impl.PersonDAOImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/people")
public class PersonResource {

    PersonDAO dao = new PersonDAOImpl();

    @Context
    private UriInfo uriInfo;

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<GroovyPerson> findAll() {
        return dao.findAll();
    }

    @GET @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response findById(@PathParam("id") long id) {
        return Response.ok(dao.findById(id)).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response create(GroovyPerson person) {
        dao.create(person);
        UriBuilder builder = UriBuilder.fromUri(uriInfo.getRequestUri()).path("{id}");

        return Response.created(builder.build(person.getId()))
                .entity(person)
                .build();
    }
}
