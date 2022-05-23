package br.com.restassuredapitest.tests.booking.tests;

import br.com.restassuredapitest.base.BaseTest;
import br.com.restassuredapitest.suites.AcceptanceExceptionTest;
import br.com.restassuredapitest.suites.AcceptanceCripticalTest;
import br.com.restassuredapitest.suites.AllTests;
import br.com.restassuredapitest.tests.auth.requests.PostAuthRequest;
import br.com.restassuredapitest.tests.booking.requests.DeleteBookingRequest;
import br.com.restassuredapitest.tests.booking.requests.GetBookingRequest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DeleteBookingTest extends BaseTest {

    DeleteBookingRequest deleteBookingRequest = new DeleteBookingRequest();
    GetBookingRequest getBookingRequest = new GetBookingRequest();
    PostAuthRequest postAuthRequest = new PostAuthRequest();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceCripticalTest.class})
    @DisplayName("Excluir um reserva com sucesso")
    public void excluiUmaReservaComSucesso(){
        int primeiroId = getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");

        deleteBookingRequest.deleteBooking(primeiroId, postAuthRequest.getToken())
                .then()
                .statusCode(201);

        getBookingRequest.retornaUmIdEspecifico(primeiroId)
                .then()
                .statusCode(404);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceExceptionTest.class})
    @DisplayName("Tentar excluir um reserva que não existe")
    public void excluiUmaReservaQueNaoExiste(){
        int id = getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");

        deleteBookingRequest.deleteBooking(id, postAuthRequest.getToken())
                .then()
                .statusCode(201);

        deleteBookingRequest.deleteBooking(id, postAuthRequest.getToken())
                .then()
                .statusCode(405);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceCripticalTest.class})
    @DisplayName("Excluir uma reserva sem autorização")
    public void excluiUmaReservaSemAutorizacao(){
        int primeiroId = getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");

        deleteBookingRequest.deleteBookingSemAutorizacao(primeiroId)
                .then()
                .statusCode(403);
    }


}
