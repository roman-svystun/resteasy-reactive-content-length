package org.acme.getting.started;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class PersonResource {

    @GET
    @Path("/person")
    @Produces(MediaType.APPLICATION_JSON)
    public Person person() {
        var string = Stream.generate(() -> "z").limit(245).collect(Collectors.joining());
        return new Person(string);
    }

    @GET
    @Path("/text")
    @Produces(MediaType.TEXT_PLAIN)
    public String text() {
        return Stream.generate(() -> "a").limit(256).collect(Collectors.joining());
    }

}