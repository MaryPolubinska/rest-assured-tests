package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;



public class GetsAndPosts {

    @Test
    public void gets() {
        baseURI = "https://reqres.in/api";
        given().
                get("/users?page=2").
                then().
                statusCode(200).
                body("data[1].last_name", equalTo("Ferguson")).
                body("data.email", hasItems("michael.lawson@reqres.in", "byron.fields@reqres.in", "rachel.howell@reqres.in"));
    }
@Test
public static void post() {
    Map<String, Object> map = new HashMap<String, Object>();
 /*   map.put("name", "Morpheus");
    map.put("job", "leader");
    System.out.println("MAP:::"+map);
    */

    JSONObject request = new JSONObject(map);
    request.put("name", "Morpheus");
    request.put("job", "leader");
    System.out.println("REQUEST:::"+request);

    baseURI = "https://reqres.in/api";
    given().
            body(request.toJSONString()).
            when().
            post("/users").
            then().
            assertThat().
            statusCode(201).
            log().
            all();
}

}
