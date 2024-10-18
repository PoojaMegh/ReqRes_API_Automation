package jsonSchemaValidation;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import java.io.File;

public class SchemaValidationInRestAssured {

    public static void main(String[] args) {
        Response response = RestAssured.given().get("https://mocki.io/v1/849e389a-5cde-4d85-b6cb-5d4a9b4bf0d2").then().extract().response();

        response.then().body(JsonSchemaValidator.matchesJsonSchema(new File("src/main/resources/jsonScemas/users.json")));
        System.out.println("Schema validation was successful");
    }
}
