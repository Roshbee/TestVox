package apiTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReqresApiTest {

    @Test
    public void testGetUsers() {
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getList("data").size(), 6);
    }

    @Test
    public void testCreateUser() {
        String body = "{ \"name\": \"Roshan\", \"job\": \"QA Engineer\" }";

        Response response = RestAssured.given()
            .header("Content-Type", "application/json")
            .body(body)
            .post("https://reqres.in/api/users");

        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertTrue(response.jsonPath().getString("id") != null);
    }

    @Test
    public void testDeleteUser() {
        Response response = RestAssured.delete("https://reqres.in/api/users/2");
        Assert.assertEquals(response.statusCode(), 204);
    }
}

