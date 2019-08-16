
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class Tests {

    Controller helper = new Controller();
    RequestSpecification request = RestAssured.given();

    @Test
    public void get() {
        given().
                       get("https://reqres.in/api/users?page=2")
               .then()
               .statusCode(200);
    }

    @Test
    public void post() {
        {
            request.header("Content-Type", "application/json");
            request.body(helper.jsonObject("morpheus", "leader").toJSONString());
            Response response = request.post("http://localhost:3000/posts");
            int code = response.getStatusCode();
            Assert.assertEquals(code, 201);
        }
    }

    @Test
    public void put() {
        request.header("Content-Type", "application/json");
        request.body(helper.jsonObject("morpheus", "zion resident!!").toJSONString());
        Response response = request.put("http://localhost:3000/posts/91");
        int code = response.getStatusCode();
        Assert.assertEquals(code, 200);
    }

    @Test
    public void patch() {
        request.header("Content-Type", "application/json");
        request.body(helper.jsonObject("morpheus", "zion resident").toJSONString());
        Response response = request.put("http://localhost:3000/posts/643");
        int code = response.getStatusCode();
        Assert.assertEquals(code, 200);
    }

    @Test
    public void delete() {
        Response response = request.delete("http://localhost:3000/posts/1425");
        int code = response.getStatusCode();
        Assert.assertEquals(code, 200);
    }


}
