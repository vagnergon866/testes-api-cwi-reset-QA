package br.com.restassuredapitest.tests.booking.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteBookingRequest {

    @Step("Excluir um reserva com sucesso")
    public Response deleteBooking(int id, String token){
        return given()
                .header("Content-Type", "application/json")
                .header("Cookie", token)
                .when()
                .delete("booking/"+ id);
    }

    @Step("Excluir um reserva sem autorização")
    public Response deleteBookingSemAutorizacao(int id){
        return given()
                .header("Content-Type", "application/json")
                .when()
                .delete("booking/"+ id);
    }
}
