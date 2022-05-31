package in.reqres.userinfo;

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class UserGetTest extends TestBase {

    @Test
    public void getListOfUsers() {

        Response response = given()
                .queryParam("page", 2)
                .when()
                .get("/users");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleUser() {

        Response response = given()
                .pathParam("id", 2)
                .when()
                .get("/users" + "/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
