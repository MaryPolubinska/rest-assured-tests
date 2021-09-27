import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class DbExamples {

  //  @Test
    public void localTest_01() {

  //      baseURI = "http://localhost:3000/";
        given().
                param("name", "Muriia").
                get("/users").
                then().
                statusCode(200).
                log().all();
    }

 //   @Test
    public void localTest_02() {
        baseURI = "http://localhost:3000/";
        JSONObject request = new JSONObject();
        request.put("firstName", "Tom");
        request.put("lastName", "Yam");
        request.put("subjectId", 2);

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
//@Test
    public void localDelete() {
    baseURI = "http://localhost:3000/";
    for (int i = 6; i < 9; i++) {
        when().
                delete("/users/" + String.valueOf(i)).
                then().statusCode(200);
    }

}

}