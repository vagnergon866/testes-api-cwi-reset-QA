import io.restassured.response.Response;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class ClasseDeTeste {

    @Test
    public void validaApiOnline(){
        Response responsePing =
                        given()
                        .header("Content-Type", "application/json")
                        .when()
                        .get("https://treinamento-api.herokuapp.com/ping");

        responsePing
                .then()
                .statusCode(201)
                .time(lessThan(2L), TimeUnit.SECONDS);
    }

    @Test
    public void validaListagensDeIdsDasReservas(){
        Response responseListagemIdsReservas =
                        given()
                        .when()
                        .get("https://treinamento-api.herokuapp.com/booking");

        responseListagemIdsReservas
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));

    }

}
