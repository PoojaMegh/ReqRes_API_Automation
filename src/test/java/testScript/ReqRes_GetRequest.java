package testScript;

import constants.StatusCode;
import constants.TimeConstants;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import services.UserServices;

import static org.hamcrest.MatcherAssert.assertThat;

public class ReqRes_GetRequest {

    UserServices userServices = new UserServices();

    @Test
    public void getSingleUser(){
        Response response = userServices.getSingleUser("2");
        assertThat(response.getTime(), Matchers.lessThan(TimeConstants.THREASHOLD_TIME));
        assertThat(response.statusCode(),Matchers.is(StatusCode.OK));
    }

    @Test
    public void getListOfUsers(){
        Response response = userServices.getListOfUsers("2");
        assertThat(response.getTime(), Matchers.lessThan(TimeConstants.THREASHOLD_TIME));
        assertThat(response.statusCode(),Matchers.is(StatusCode.OK));
    }

    @Test
    public void getUserNotFound(){
        Response response = userServices.getListOfUsers("2");
        int totalUsersInSystem = response.jsonPath().getInt("total") + 1;
        System.out.println("Total users in system : " + totalUsersInSystem);
        response = userServices.getSingleUser(String.valueOf(totalUsersInSystem));

        assertThat(response.getTime(), Matchers.lessThan(TimeConstants.THREASHOLD_TIME));
        assertThat(response.statusCode(),Matchers.is(StatusCode.NOT_FOUND));
    }

    @Test
    public void getListOfResources(){
        Response response = userServices.getListOfResources();
        assertThat(response.getTime(), Matchers.lessThan(TimeConstants.THREASHOLD_TIME));
        assertThat(response.statusCode(),Matchers.is(StatusCode.OK));
    }

    @Test
    public void getUserWithUnknown(){
        Response response = userServices.getSingleUserWithUnknown("2");
        assertThat(response.getTime(), Matchers.lessThan(TimeConstants.THREASHOLD_TIME));
        assertThat(response.statusCode(),Matchers.is(StatusCode.OK));
    }
}
