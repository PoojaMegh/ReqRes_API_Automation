package testScript;

import constants.StatusCode;
import constants.TimeConstants;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import services.UserServices;
import utility.TestData;

import static org.hamcrest.MatcherAssert.assertThat;

public class ReqRes_PutRequest {

    UserServices userServices = new UserServices();

    @Test
    public void updateUser(){
        String firstName = TestData.getFirstName();
        String jobName = TestData.getJobName();
        String body = "{\n" +
                "    \"name\": \""+ firstName +"\",\n" +
                "    \"job\": \""+ jobName +"\"\n" +
                "}";
        Response response = userServices.updateUser(body, "2");
        assertThat(response.getTime(), Matchers.lessThan(TimeConstants.THREASHOLD_TIME));
        assertThat(response.statusCode(),Matchers.is(StatusCode.OK));

        assertThat(response.jsonPath().getString("name"), Matchers.equalTo(firstName));
        assertThat(response.jsonPath().getString("job"), Matchers.equalTo(jobName));
    }
}
