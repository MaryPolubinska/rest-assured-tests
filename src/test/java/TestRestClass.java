import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.Map;

public class TestRestClass {

    @Test
    void test_01() {
      Response response = get("https://reqres.in/api/users?page=2");
      int statusCode1 = response.getStatusCode();
        System.out.println("Here I tried to get StatusCode:");
        System.out.println(statusCode1);
      System.out.println("As String:");
      System.out.println(response.asString());
        System.out.println("Body As String:");
      System.out.println(response.getBody().asString());
        System.out.println("Get Status Code:");
      System.out.println(response.getStatusCode());
        System.out.println("Get Session ID:");
        System.out.println(response.getSessionId());
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        Map<String, String> allCookies = response.getCookies();
        System.out.println("All Cookies:");
        System.out.println(allCookies);
    }

    @Test public void test_02() {
        given()
                .get("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .body("data.first_name", equalTo("Janet")).
                log().all();
    }

}
