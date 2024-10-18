package jsonPath;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class JsonPathTest {

    public static void main(String[] args) {
        Response response = RestAssured.given().get("https://mocki.io/v1/01ddb7d8-f6ad-4480-b71a-d9f58bb1e1de").then().extract().response();

        //1. Equal Condition
//        List<Integer> idList = response.jsonPath().get("users.findAll { it.name == 'Alice' }.id");
//        System.out.println(idList);
//
//        int id = response.jsonPath().get("users.find { it.name == 'Alice' }.id");
//        System.out.println(id);
//
//        ArrayList<LinkedHashMap> user = response.jsonPath().get("users.findAll { it.name == 'Alice' }");
//        System.out.println(user);


        //2. Greater/Less Than Condition
//        Response response1 = RestAssured.given().get("https://restful-booker.herokuapp.com/booking").then().extract().response();
//        ArrayList<LinkedHashMap> list = response1.jsonPath().get("findAll { it.bookingid >= 1000 }");
//        System.out.println(list.size());
//        System.out.println(list);


        //3. Multiple Conditions
//        ArrayList<LinkedHashMap> list = response.jsonPath().get("users.findAll { it.id > 5 && it.active == true }");
//        ArrayList<LinkedHashMap> list1 = response.jsonPath().get("users.findAll { it.id > 5 && it.active == true && it.name.length() > 4 }");
//        System.out.println(list1);


        //4. Extracting Specific Fields
//        List<Integer> idList = response.jsonPath().get("users.findAll { it.name == 'Alice' }.id");
//        System.out.println(idList);


        //5. Multiple Fields (Using a map)
//        ArrayList<LinkedHashMap> map = response.jsonPath().get("users.findAll { it.active == true }.collect { [it.id, it.name] }");
//        System.out.println(map);


        //6. Using Count
        //https://mocki.io/v1/617abf91-3ea6-4ded-beff-f3dddba83cb4

    }
}
