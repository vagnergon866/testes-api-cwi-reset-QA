package br.com.restassuredapitest.tests.booking.tests;

import br.com.restassuredapitest.base.BaseTest;
import br.com.restassuredapitest.suites.AllTests;
import br.com.restassuredapitest.suites.SecurityTest;
import br.com.restassuredapitest.tests.auth.requests.PostAuthRequest;
import br.com.restassuredapitest.tests.booking.requests.DeleteBookingRequest;
import br.com.restassuredapitest.tests.booking.requests.GetBookingRequest;
import br.com.restassuredapitest.tests.booking.requests.PutBookingRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.greaterThan;
@Feature("Feature - Atualização de reservas")
public class PutBookingTest extends BaseTest {

    PutBookingRequest putBookingRequest = new PutBookingRequest();
    GetBookingRequest getBookingRequest = new GetBookingRequest();
    PostAuthRequest postAuthRequest = new PostAuthRequest();
    DeleteBookingRequest deleteBookingRequest = new DeleteBookingRequest();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(AllTests.class)
    @DisplayName("Alterar uma reserva usando o token")
    public void validarAlteracaoDeUmaReservaUtilizandoToken() {
        int primeiroId = getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");

        putBookingRequest.updateBookingToken(primeiroId, postAuthRequest.getToken())
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, SecurityTest.class})
    @DisplayName("Alterar uma reserva quando o token não for enviado")
    public void validarAlteracaoDeUmaReservaSemToken() {
        int primeiroId = getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");

        putBookingRequest.updateBookingSemToken(primeiroId)
                .then()
                .statusCode(403);


    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, SecurityTest.class})
    @DisplayName("Alterar uma reserva quando o token enviado for inválido")
    public void validarAlteracaoDeUmaReservaUtilizandoTokenInvalido() {
        int primeiroId = getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");

        putBookingRequest.updateBookingToken(primeiroId, postAuthRequest.getTokenInvalido())
                .then()
                .statusCode(403);

    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Category({AllTests.class})
    @DisplayName("Alterar uma reserva usando o Basic auth")
    public void validarAlteracaoDeUmaReservaUtilizandoBasicAuth() {
        int id = getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");

        putBookingRequest.updateBookingBasicAuth(id)
                 .then()
                 .statusCode(200)
                 .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Category({AllTests.class})
    @DisplayName("Alterar uma reserva que não existe")
    public void validarAlteracaoDeUmaReservaQueNaoExiste() {
        int id = getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");

        deleteBookingRequest.deleteBooking(id, postAuthRequest.getToken())
                .then()
                .statusCode(201);

        putBookingRequest.updateBookingToken(id, postAuthRequest.getToken())
                .then()
                .statusCode(405);


    }
}
