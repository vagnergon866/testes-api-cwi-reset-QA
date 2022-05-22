package br.com.restassuredapitest.tests.booking.requests;

import br.com.restassuredapitest.tests.booking.requests.payloads.BookingPayloads;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetBookingRequest {

    BookingPayloads bookingPayloads = new BookingPayloads();

    @Step("Retorna os ids da listagem de reservas")
    public Response bookingReturnIds() {
        return given()
                .when()
                .get("booking");
    }

    @Step("Restorna um Id especifico")
    public Response retornaUmIdEspecifico(int id) {
        return given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .when()
                .get("booking/" + id);
    }

    @Step("Filtra por firstname")
    public Response retornaFiltroFirstname(String firstname) {
        return given()
                .when()
                .get("booking?firstname=" + firstname);
    }

    @Step("Filtra por lastname")
    public Response retornaFiltroLastname(String lastname) {
        return given()
                .when()
                .get("booking?lastname=" + lastname);
    }

    @Step("Filtra por checkin")
    public Response retornaFiltroCheckin(String checkin) {
        return given()
                .when()
                .get("booking?checkin=" + checkin);
    }

    @Step("Filtra por checkout")
    public Response retornaFiltroCheckout(String checkout) {
        return given()
                .when()
                .get("booking?checkout=" + checkout);
    }

    @Step("Filtra por checkin e checkout")
    public Response retornaFiltroCheckinCheckout(String checkin, String checkout) {
        return given()
                .when()
                .get("booking?checkin" + checkin + "&checkout=" + checkout);
    }

    @Step("Filtra por nome, checkin e checkout")
    public Response retornaFiltroNameCheckinCheckout(String firstname,
                                                     String lastname, String checkin, String checkout) {
        return given()
                .when()
                .get("booking?firstname=" + firstname + "&lastname="
                        + lastname + "&checkin" + checkin + "&checkout=" + checkout);
    }

    @Step("Filtra por firstname mal formatato")
    public Response retornaFiltroFirstnameMalFormatado(String firstname) {
        return given()
                .when()
                .get("booking?firstna=" + firstname);
    }

}
