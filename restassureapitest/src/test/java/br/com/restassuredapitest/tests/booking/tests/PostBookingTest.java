package br.com.restassuredapitest.tests.booking.tests;

import br.com.restassuredapitest.base.BaseTest;
import br.com.restassuredapitest.suites.AcceptanceExceptionTest;
import br.com.restassuredapitest.suites.AcceptanceCripticalTest;
import br.com.restassuredapitest.suites.AllTests;
import br.com.restassuredapitest.tests.booking.requests.PostBookingRequest;
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

@Feature("Feature - Cria uma nova reserva")
public class PostBookingTest extends BaseTest {
    PostBookingRequest postBookingRequest = new PostBookingRequest();

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Cria uma nova reserva")
    @Category({AllTests.class, AcceptanceCripticalTest.class})
    public void validaCriacaoDeUmaNovaReserva() {
        postBookingRequest.createBooking()
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));

    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Garantir o schema da criação de reserva")
    @Category({AllTests.class, AcceptanceCripticalTest.class})
    public void validaSchemaCriacaoDeUmaReserva() {
        postBookingRequest.createBooking()
                .then()
                .statusCode(200)
                .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("booking", "createBookings"))));

    }


    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Fazer criação de reserva com payload inválido")
    @Category({AllTests.class, AcceptanceExceptionTest.class})
    public void validaCriacaoDeUmaNovaReservaComPayloadInvalido() {
        postBookingRequest.createBookingPayloadInvalido()
                .then()
                .statusCode(500);

    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Criar uma reserva enviando mais parâmetros no payload")
    @Category({AllTests.class, AcceptanceExceptionTest.class})
    public void validaCriacaoDeUmaNovaReservaComPayloadComMaisParametros() {
        postBookingRequest.createBookingPayloadComMaisParametros()
                .then()
                .statusCode(500);

    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Validar a criação de mais de uma reserva em sequência")
    @Category({AllTests.class, AcceptanceExceptionTest.class})
    public void validaCriacaoDeMaisDeUmaReserva() {
        postBookingRequest.createBooking()
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));

    }
}
