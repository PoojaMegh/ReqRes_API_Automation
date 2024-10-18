package standAloneScripts;

import constants.StatusCode;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteRequest {
    RequestSpecBuilder requestSpecBuilder;

    @BeforeMethod
    public void beforeMethod(){
        requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setAccept(ContentType.JSON);
        requestSpecBuilder.setBaseUri("https://reqres.in");
        requestSpecBuilder.setBasePath("/api");
        requestSpecBuilder.log(LogDetail.ALL);
    }

    @Test
    public void deleteUser(){
        Response response = RestAssured.
                given()
                .spec(requestSpecBuilder.build()).
                when()
                .delete("/users/2")
                .then()
                .extract()
                .response();
        System.out.println("Status Code : " + response.statusCode());
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(), StatusCode.NOT_CONTENT);
        Assert.assertTrue(response.getTime() < 1500, "Response time is more than 1.5 Seconds");
    }
}
