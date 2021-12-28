package org.acme.getting.started;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpHeaders.CONTENT_LENGTH;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.matchesPattern;

@QuarkusTest
public class PersonResourceTest {

    // Failing test
    @Test
    public void testPersonEndpoint() {
        given().when()
                .get("/person")
                .then()
                .statusCode(200)
                .header(CONTENT_LENGTH, is(matchesPattern("^\\d+$")))
                .body(is("{\"name\":\"256 Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute\"}"));
    }

}
