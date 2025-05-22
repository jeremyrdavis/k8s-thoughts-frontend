package com.redhat.k8sthoughts;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class RandomThoughtResourceTest {

    @InjectMock
    @RestClient
    ThoughtOfTheDayClient thoughtClient;

    @Test
    public void testGetRandomThoughtEndpoint() {
        // Create a test thought
        ThoughtOfTheDay testThought = new ThoughtOfTheDay("Test thought","Test Author", LocalDate.now());

        // Set up the mock
        Mockito.when(thoughtClient.getRandomThought()).thenReturn(testThought);

        // Test the endpoint
        given()
          .when().get("/api/thoughts/random")
          .then()
             .statusCode(200)
             .body("thought", is("Test thought"))
             .body("author", is("Test Author"))
             .body("day", is(LocalDate.now().toString()));
    }
}