package standAloneScripts;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetRequest {

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
    public void getListOfUsers() {
        Response response =
                RestAssured
                    .given()
                    .spec(requestSpecBuilder.build())
                    .queryParam("page", 2)
                .when()
                    .get("/users")
                .then()
                    .extract()
                    .response();
        System.out.println("Status Code : " + response.statusCode());
        System.out.println(response.asPrettyString());
        long responseTime = response.getTime();
        System.out.println("Response Time : " + responseTime);
        Assert.assertTrue(response.asString().contains("total"));
        Assert.assertTrue(responseTime < 1500, "Response time is more than 1.5 Seconds");
    }

    @Test
    public void getSingleUser() {
        Response response =
                RestAssured
                        .given()
                        .spec(requestSpecBuilder.build())
                        .when()
                    .get("/users/2")
                .then()
                    .extract()
                    .response();
        System.out.println("Status Code : " + response.statusCode());
        System.out.println(response.asPrettyString());
        long responseTime = response.getTime();
        System.out.println("Response Time : " + responseTime);
        Assert.assertTrue(responseTime < 1500, "Response time is more than 1.5 Seconds");
    }
}
