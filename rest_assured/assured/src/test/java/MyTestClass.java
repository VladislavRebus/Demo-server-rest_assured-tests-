import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class MyTestClass {

    @BeforeClass
    private void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8090;
    }

    @Test()
    public void checkDefaultName() {
        get("/name").then().body("name", equalTo("vasya"));
    }

    @Test()
    public void checkCustomName() {
        given()
                .param("n", "oleg")
                .get("/name")
                .then()
                .body("name", equalTo("oleg"));
    }

    @Test()
    public void checkDefaultAge() {
        get("/age").then().body("age", equalTo(123));
    }

    @Test()
    public void checkBoys() {
        given()
                .param("c", "supermans")
                .post("/child")
                .then()
                .body("child.boys", equalTo("supermans"));
    }

    @Test()
    public void checkGirls() {
        given().
                post("/child")
                .then()
                .body("child.girls", equalTo(4));
    }


}
