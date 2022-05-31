package in.reqres.userinfo;

import in.reqres.model.UserPojo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserPostTest extends TestBase {

    @Test
    public void createUser() {

        UserPojo userpojo = new UserPojo();
        userpojo.setName("Name123");
        userpojo.setJob("Job123");

        Response response = given()
                .body(userpojo)
                .when()
                .post("/users");
        response.then().statusCode(201);
        response.prettyPrint();
    }

    @Test
    public void sendLogIn() {


        UserPojo userPojo = new UserPojo();
        userPojo.setEmail("eve.holt@reqres.in");
        userPojo.setPassword("cityslicka1");

        Response response = given()
                .header("Authorization","Bearer b5f2ee3fca5b4efacce265745546d4fd7f1501611b151cf408ac45f7648bb5d0")
                .header("Content-Type","application/json")
                .body(userPojo)
                .when()
                .post("/login");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
