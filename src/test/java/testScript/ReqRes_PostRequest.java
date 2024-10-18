package testScript;

import constants.StatusCode;
import constants.TimeConstants;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import services.UserServices;
import utility.TestData;

import static org.hamcrest.MatcherAssert.assertThat;

public class ReqRes_PostRequest {

    UserServices userServices = new UserServices();

    @Test
    public void createUser(){
        String body = "{\n" +
                "    \"name\": \""+ TestData.getFirstName() +"\",\n" +
                "    \"job\": \""+TestData.getJobName()+"\"\n" +
                "}";
        Response response = userServices.createUser(body);
        assertThat(response.getTime(), Matchers.lessThan(TimeConstants.THREASHOLD_TIME));
        assertThat(response.statusCode(),Matchers.is(StatusCode.CREATED));
        assertThat(Integer.parseInt(response.jsonPath().getString("id")), Matchers.greaterThan(0));

    }
}
