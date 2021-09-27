package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PutPatchDelete {

    //@Test
    public static void put() {
        baseURI = "https://reqres.in/api";
        Map<String, Object> map = new HashMap<String, Object>();
        JSONObject request = new JSONObject(map);
        request.put("name", "Morpheus");
        request.put("job", "leader");
        System.out.println("REQUEST:::"+request);
        given().
                body(request.toJSONString()).
                when().
                put("/users/2").
                then().
                assertThat().
                statusCode(200).
                log().
                all();

    }

 //   @Test
    public static void patch() {
        baseURI = "https://reqres.in/api";
        Map<String, Object> map = new HashMap<String, Object>();
        JSONObject request = new JSONObject(map);
        request.put("name", "Morpheus");
        request.put("job", "zion resident");
        System.out.println("REQUEST:::"+request);
        given().
                body(request.toJSONString()).
                when().
                patch("/users/2").
                then().
                assertThat().
                statusCode(200).
                log().
                all();

    }

    @Test
    public static void delete() {
        baseURI = "https://reqres.in/api";

        given().
                when().
                delete("/users/2").
                then().
                assertThat().
                statusCode(204).
                log().
                all();

    }

}
