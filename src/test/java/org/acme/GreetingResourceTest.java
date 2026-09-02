package org.acme;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class GreetingResourceTest {

    @InjectMock
    GreetingService greetingService;

    @BeforeEach
    void setup() {
        Mockito.when(greetingService.generate("Alex")).thenReturn("Hello, Alex!");
    }

    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/hello/Alex")
          .then()
             .statusCode(200)
             .body(is("Hello, Alex!"));
    }
}
