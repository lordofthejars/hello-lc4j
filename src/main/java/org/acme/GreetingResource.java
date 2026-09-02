package org.acme;

import org.jboss.resteasy.reactive.RestPath;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    GreetingService greetingService;

    @GET
    @Path("{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@RestPath String name) {
        return greetingService.generate(name);
    }
}
