package services;

import base.BaseService;
import io.restassured.response.Response;

public class UserServices extends BaseService {

    public Response getSingleUser(String userId){
        return executeGetRequest("/users/" + userId);
    }

    public Response getListOfUsers(String pageValue){
        setQueryParameter("page", pageValue);
        return executeGetRequest("/users");
    }

    public Response getListOfResources() {
        return executeGetRequest("/unknown");
    }

    public Response getSingleUserWithUnknown(String userId){
        return executeGetRequest("/users/" + userId);
    }

    public Response createUser(String requestBody){
        setBody(requestBody);
        return executePostRequest("/users");
    }

    public Response updateUser(String requestBody, String userId){
        setBody(requestBody);
        return executePutRequest("/users/" + userId);
    }

    public Response deleteUser(String userId){
        return executeDeleteRequest("/users/" + userId);
    }

}
