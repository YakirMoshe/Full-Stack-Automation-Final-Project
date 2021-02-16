package restAssuredHelper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;


public class TempAPI {

    RequestSpecification httpRequest;
    Response response;
    String url = "http://localhost:3000/";

    @Test
    public void testingAPI() {
        RestAssured.baseURI = url;
        httpRequest = RestAssured.given().auth().preemptive().basic("admin", "admin");

        //Get Request
        response = httpRequest.get("/api/teams/search?name=YakirTeam");
        response.prettyPrint();

        //Post + Put Request
        JSONObject params = new JSONObject();
        params.put("name", "Ateam");
        params.put("email", "Ateam@gmail.com");
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.post("/api/teams");
        response.prettyPrint();

        //Edit Team
        params.put("name", "BBteam");
        params.put("email", "Ateam@KUKU.com");
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.put("/api/teams/2");
        response.prettyPrint();

        //Delete Team
        response = httpRequest.delete("/api/teams/4");
        response.prettyPrint();
    }

}
