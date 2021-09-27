import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GET_Tests {
@Test
    public void test_01() {
        given().
                get("https://reqres.in/api/users?page=2").
                then().
                statusCode(200).
               body("data.avatar[1]", equalTo("https://reqres.in/img/faces/8-image.jpg")).
                body("data.first_name", hasItems("Michael", "Byron")).
                log().all();


    }
}
