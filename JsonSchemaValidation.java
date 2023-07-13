import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import java.io.File;

public class JsonSchemaValidation {

    @Test
    public void validationUsingJsonSchemaInClassPath()
    {
        File inputJson =new File("src/test/resources/input.json");
        RestAssured.given()
                .baseUri("https://reqres.in/api")
                .header("Content-Type","application/json")
                .body(inputJson)
                .when()
                .post("/users")
                .then()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"));
    }
    }

