package standAloneScripts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.requestPayloads.createUser.CreateUserRequestPayload;
import entities.responsePayloads.createUser.CreateUserResponsePayload;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import utility.TestData;

public class SerializationTest {
    public static void main(String[] args) throws JsonProcessingException {

//        CreateUserRequestPayload createUserRequestPayload = new CreateUserRequestPayload();
//        createUserRequestPayload.setJob(TestData.getJobName());
//        createUserRequestPayload.setName(TestData.getFirstName());

        CreateUserRequestPayload createUserRequestPayload = CreateUserRequestPayload.builder()
                .job(TestData.getJobName())
                .name(TestData.getFirstName())
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(createUserRequestPayload);

        System.out.println("Request Payload : \n" + payload);

        Response response = RestAssured.
                given()
                .baseUri("https://reqres.in")
                .basePath("/api")
                .contentType(ContentType.JSON).
                when()
                .body(createUserRequestPayload)
                .post("/users")
                .then()
                .extract()
                .response();
        System.out.println("Status Code : " + response.statusCode());
        System.out.println("Create User Response : \n" + response.asPrettyString());
        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertTrue(response.getTime() < 2500, "Response time is more than 2.5 Seconds");

        CreateUserResponsePayload createUserResponsePayload = response.as(CreateUserResponsePayload.class);
        System.out.println("Name : " + createUserResponsePayload.name);
        System.out.println("Job : " + createUserResponsePayload.job);
        System.out.println("ID : " + createUserResponsePayload.id);
        System.out.println("Created At : " + createUserResponsePayload.createdAt);
    }
}
