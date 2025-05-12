package com.redhat.k8sthoughts;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/thoughts")
@RegisterRestClient(configKey = "thoughts-api")
public interface ThoughtOfTheDayClient {
    
    @GET
    @Path("/random")
    @Produces(MediaType.APPLICATION_JSON)
    ThoughtOfTheDay getRandomThought();
} 