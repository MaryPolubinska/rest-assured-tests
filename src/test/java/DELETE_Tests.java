import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class DELETE_Tests {

    @Test
    public void test_04() {
        when().
                delete("https://reqres.in/api/users/2").
                then().statusCode(204).
                log().
                all();
    }

}
