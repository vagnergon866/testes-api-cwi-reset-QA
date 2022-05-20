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
                .header("Cookie",token)
                .when()
                .body(bookingPayloads.payloadValidBooking().toString())
                .put("booking/"+ id);

    }
}
