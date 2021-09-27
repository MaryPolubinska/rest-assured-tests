import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class DataDrivenTests  extends DataForTests {

 //@Test(dataProvider = "DataForPosting")
    public void dd_tests(String first, String last, int subjectId) {
    baseURI = "http://localhost:3000/";
    JSONObject request = new JSONObject();
        request.put("firstName", first);
        request.put("lastName", last);
        request.put("subjectId", subjectId);

    given().
    contentType(ContentType.JSON).
    accept(ContentType.JSON).
    header("Content-Type", "application/json").
    body(request.toJSONString()).
    when().
    post("/users").
    then().
    statusCode(201).
    log().
    all();

    }

//    @Test(dataProvider = "DataForDeletion")
    public void localDelete(int userId) {
        baseURI = "http://localhost:3000/";

            when().
                    delete("/users/"+userId).
                    then().statusCode(200);
        }


        @Test
        @Parameters({"userId"})
    public void localDelete1(int userId) {
        baseURI = "http://localhost:3000/";

        when().
                delete("/users/"+userId).
                then().statusCode(200);
    }

    }
