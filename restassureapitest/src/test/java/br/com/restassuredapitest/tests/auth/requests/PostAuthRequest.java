package br.com.restassuredapitest.tests.auth.requests;

import br.com.restassuredapitest.tests.auth.requests.payloads.AuthPayloads;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostAuthRequest {
    AuthPayloads authPayloads = new AuthPayloads();

    @Step("Retorna o Token")
    public Response tokenReturn() {

        return given()
                .header("Content-Type", "application/json")
                .when()
                .body(authPayloads.jsonAuthLogin().toString())
                .post("auth");
    }

    @Step("Busca o token")
    public String getToken() {
        return "token=" + this.tokenReturn()
                .then()
                .statusCode(200)
                .extract()
                .path("token");
    }
}
