package br.com.restassuredapitest.tests.auth.requests;

import br.com.restassuredapitest.tests.auth.requests.payloads.AuthPayloads;
import io.restassured.response.Response;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

public class PostAuthRequest {
    AuthPayloads authPayloads = new AuthPayloads();
    public Response tokenReturn() throws JSONException {

        return given()
                .header("Content-Type", "application/json")
                .when()
                .body(authPayloads.jsonAuthLogin().toString())
                .post("auth");
    }

    public String getToken() throws JSONException {
        return "token=" + this.tokenReturn()
                .then()
                .statusCode(200)
                .extract()
                .path("token");
    }
}
