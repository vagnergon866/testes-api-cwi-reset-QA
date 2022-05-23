package br.com.restassuredapitest.tests.booking.requests;

import br.com.restassuredapitest.tests.booking.requests.payloads.BookingPayloads;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PutBookingRequest {
    BookingPayloads bookingPayloads = new BookingPayloads();

    @Step("Atualiza uma reserva especifica com o parâmetro token")
    public Response updateBookingToken(int id, String token) {
        return given()
                .header("Content-Type", "application/json")
                .header( "Accept","application/json")
                .header("Cookie", token)
                .when()
                .body(bookingPayloads.payloadValidBooking().toString())
                .put("booking/"+ id);

    }

    @Step("Atualiza reserva sem enviar o token")
    public Response updateBookingSemToken(int id) {
        return given()
                .header("Content-Type", "application/json")
                .header( "Accept","application/json")
                .when()
                .body(bookingPayloads.payloadValidBooking().toString())
                .put("booking/"+ id);

    }

    @Step("Atualiza uma reserva especificada com basic auth")
    public Response updateBookingBasicAuth(int id) {
        return given()
                .header("Content-Type", "application/json")
                .header( "Accept","application/json")
                .auth()
                .preemptive()
                .basic("admin", "password123")
                .when()
                .body(bookingPayloads.payloadValidBooking().toString())
                .put("booking/"+ id);
    }
}
