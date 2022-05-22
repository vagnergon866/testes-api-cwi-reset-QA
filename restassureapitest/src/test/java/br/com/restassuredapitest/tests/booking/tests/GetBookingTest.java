package br.com.restassuredapitest.tests.booking.tests;

import br.com.restassuredapitest.base.BaseTest;
import br.com.restassuredapitest.suites.AcceptanceExceptionTest;
import br.com.restassuredapitest.suites.AcceptanceCripticalTest;
import br.com.restassuredapitest.suites.AllTests;
import br.com.restassuredapitest.suites.ContractTest;
import br.com.restassuredapitest.tests.booking.requests.GetBookingRequest;
import br.com.restassuredapitest.utils.Utils;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.greaterThan;

@Feature("Feature - Retorno de reservas")
public class GetBookingTest extends BaseTest {
    GetBookingRequest getBookingRequest = new GetBookingRequest();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class})
    @DisplayName("validar a listagem de ids das reservas")
    public void validaListagensDeIdsDasReservas() {

        getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));

    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, ContractTest.class})
    @DisplayName("Garantir o schema do retorno da lista de reservas")
    public void validaSchemaDaListagemDeReserva() {
        getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("booking", "bookings"))));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, ContractTest.class})
    @DisplayName("Garantir o schema do retorno de uma reserva específica")
    public void validaSchemaDaListagemDeReservaEspecifica() {
       int id = getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");

        getBookingRequest.retornaUmIdEspecifico(id)
                .then()
                .statusCode(200)
                .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("booking", "bookingsId"))));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Category({AllTests.class, AcceptanceCripticalTest.class})
    @DisplayName("Listar uma reserva específica")
    public void validaListarUmaReservaEspecifica() {
        int primeiroId = getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");

        getBookingRequest.retornaUmIdEspecifico(primeiroId)
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));

    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Category({AllTests.class, AcceptanceCripticalTest.class})
    @DisplayName("Listar IDs de reservas utilizando o filtro firstname")
    public void validaListarIdsComFiltroFirstname() {

        String firstname = "Will";
        getBookingRequest.retornaFiltroFirstname(firstname)
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));


    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Category({AllTests.class, AcceptanceCripticalTest.class})
    @DisplayName("Listar IDs de reservas utilizando o filtro lastname")
    public void validaListarIdsComFiltroLastname() {

        String lastname = "Smith";
        getBookingRequest.retornaFiltroLastname(lastname)
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));


    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Category({AllTests.class, AcceptanceCripticalTest.class})
    @DisplayName("Listar IDs de reservas utilizando o filtro checkin")
    public void validaListarIdsComFiltroCheckin() {

        String checkin = "2018-01-01";
        getBookingRequest.retornaFiltroCheckin(checkin)
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Category({AllTests.class, AcceptanceCripticalTest.class})
    @DisplayName("Listar IDs de reservas utilizando o filtro checkout")
    public void validaListarIdsComFiltroCheckout() {

        String checkout = "2019-01-01";
        getBookingRequest.retornaFiltroCheckout(checkout)
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Category({AllTests.class, AcceptanceCripticalTest.class})
    @DisplayName("Listar IDs de reservas utilizando o filtro checkin e checkout")
    public void validaListarIdsComFiltroCheckinCheckout() {

        String checkin = "2018-01-01";
        String checkout = "2019-01-01";
        getBookingRequest.retornaFiltroCheckinCheckout(checkin, checkout)
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Category({AllTests.class, AcceptanceCripticalTest.class})
    @DisplayName("Listar IDs de reservas utilizando o filtro name, checkin e checkout")
    public void validaListarIdsComFiltroNameCheckinCheckout() {

        String firstname = "Lucas";
        String lastname = "Smith";
        String checkin = "2018-01-01";
        String checkout = "2019-01-01";
        getBookingRequest.retornaFiltroNameCheckinCheckout( firstname, lastname, checkin, checkout)
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Category({AllTests.class, AcceptanceExceptionTest.class})
    @DisplayName("Fazer consulta de reservas enviando filtro mal formatado")
    public void validaListarIdsComFiltroFirstnameMalFormatado() {

        String firstname = "Will";
        getBookingRequest.retornaFiltroFirstnameMalFormatado(firstname)
                .then()
                .statusCode(400);


    }
}
