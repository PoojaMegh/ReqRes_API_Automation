package testScript;

import constants.StatusCode;
import constants.TimeConstants;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import services.UserServices;
import utility.TestData;

import static org.hamcrest.MatcherAssert.assertThat;

public class ReqRes_DeleteRequest {

    UserServices userServices = new UserServices();

    @Test
    public void deleteUser(){
        Response response = userServices.deleteUser("2");
        assertThat(response.getTime(), Matchers.lessThan(TimeConstants.THREASHOLD_TIME));
        assertThat(response.statusCode(),Matchers.is(StatusCode.NOT_CONTENT));

     }
}
