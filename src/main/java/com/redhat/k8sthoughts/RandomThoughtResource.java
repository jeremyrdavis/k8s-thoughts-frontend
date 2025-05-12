package com.redhat.k8sthoughts;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/api/thoughts")
@Produces(MediaType.APPLICATION_JSON)
public class RandomThoughtResource {

    @Inject
    @RestClient
    ThoughtOfTheDayClient thoughtClient;

    @GET
    @Path("/random")
    public ThoughtOfTheDay getRandomThought() {
        return thoughtClient.getRandomThought();
    }
} 