package base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;

public abstract class BaseService {

    RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
    Response response;
    private void setup(){
        if(requestSpecBuilder == null) {
            requestSpecBuilder = new RequestSpecBuilder();
        }
        requestSpecBuilder.setAccept(ContentType.JSON);
        requestSpecBuilder.setBaseUri("https://reqres.in");
        requestSpecBuilder.setBasePath("/api");
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.log(LogDetail.ALL);
    }

    protected void setQueryParameter(String queryParameterKey, String queryParameterValue){
        if(requestSpecBuilder == null)
            requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.addQueryParam(queryParameterKey, queryParameterValue);
    }

    protected void setBody(String requestPayload){
        if(requestSpecBuilder == null)
            requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBody(requestPayload);
    }
    protected Response executeGetRequest(String endPoint){
        setup();
        response = RestAssured.
                given()
                    .spec(requestSpecBuilder.build())
                .when()
                    .get(endPoint)
                .then()
                    .extract().response();
        tearDown();
        System.out.println("Status Code : " + response.statusCode());
        System.out.println(response.asPrettyString());
        return response;
    }

    protected Response executePostRequest(String endPoint){
        setup();
        response = RestAssured.
                given()
                    .spec(requestSpecBuilder.build())
                .when()
                    .post(endPoint)
                .then()
                .extract().response();
        tearDown();
        System.out.println("Status Code : " + response.statusCode());
        System.out.println(response.asPrettyString());
        return response;
    }

    protected Response executePutRequest(String endPoint){
        setup();
        response = RestAssured.
                given()
                .spec(requestSpecBuilder.build())
                .when()
                .put(endPoint)
                .then()
                .extract().response();
        tearDown();
        System.out.println("Status Code : " + response.statusCode());
        System.out.println(response.asPrettyString());
        return response;
    }

    protected Response executeDeleteRequest(String endPoint){
        setup();
        response = RestAssured.
                given()
                .spec(requestSpecBuilder.build())
                .when()
                .delete(endPoint)
                .then()
                .extract().response();
        tearDown();
        System.out.println("Status Code : " + response.statusCode());
        System.out.println(response.asPrettyString());
        return response;
    }

    private void tearDown(){
        requestSpecBuilder = null;
    }
}
