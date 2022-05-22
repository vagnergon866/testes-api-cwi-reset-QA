package br.com.restassuredapitest.tests.booking.requests;

import br.com.restassuredapitest.tests.booking.requests.payloads.BookingPayloads;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostBookingRequest {
    BookingPayloads bookingPayloads = new BookingPayloads();

    @Step("Cria uma nova reserva")
    public Response createBooking(){
        return given()
                .header("Content-Type", "application/json")
                .when()
                .body(bookingPayloads.payloadValidBooking().toString())
                .post("booking");
    }

    @Step("Cria uma nova reserva com payload invalido")
    public Response createBookingPayloadInvalido(){
        return given()
                .header("Content-Type", "application/json")
                .when()
                .body(bookingPayloads.payloadInvalido().toString())
                .post("booking");
    }

    @Step("Cria uma nova reserva com peyload com mais parametros")
    public Response createBookingPayloadComMaisParametros(){
        return given()
                .header("Content-Type", "application/json")
                .when()
                .body(bookingPayloads.payloadComMaisParametros().toString())
                .post("booking");
    }


}
