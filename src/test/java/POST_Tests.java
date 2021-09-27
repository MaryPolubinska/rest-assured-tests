import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class POST_Tests {
    @Test
    public  void test_02() {

//Map<String, Object> map = new HashMap<String, Object>();
 //       map.put("name", "Mary");
//        map.put("job", "QA + Dev");
        JSONObject request = new JSONObject();
        request.put("name", "Mary");
        request.put("job", "QA + Dev");
        System.out.println("Request Iss::");
        System.out.println(request);

        given().
                body(request.toJSONString()).
                when().
                post("https://reqres.in/api/users").
                then().
                statusCode(201);

    }
}
