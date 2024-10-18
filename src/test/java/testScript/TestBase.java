package testScript;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    static RequestSpecBuilder requestSpecBuilder;

    @BeforeMethod
    public void beforeMethod(){
        requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setAccept(ContentType.JSON);
        requestSpecBuilder.setBaseUri("https://reqres.in");
        requestSpecBuilder.setBasePath("/api");
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.log(LogDetail.ALL);
    }
}
