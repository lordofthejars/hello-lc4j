package org.acme;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
class GreetingResourceTest {

    @InjectMock
    GreetingService greetingService;

    @Test
    void helloEndpointReturnsGreeting() {
        Mockito.when(greetingService.generate("Ada")).thenReturn("Hello, Ada!");

        given()
            .when().get("/hello/Ada")
            .then()
                .statusCode(200)
                .body(containsString("Ada"));
    }
}
