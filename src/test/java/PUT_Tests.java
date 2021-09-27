import io.restassured.config.JsonConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ValidatableResponse;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


public class PUT_Tests {
    @Test

    public void test_03() {
        JSONObject request = new JSONObject();
        request.put("name", "morpheus");
        request.put("job", "zion resident");

        ValidatableResponse all = given().
                body(request.toJSONString()).
                when().
                put("https://reqres.in/api/users/2").
                then().
                statusCode(200).
                log().
                all();
    }

}
