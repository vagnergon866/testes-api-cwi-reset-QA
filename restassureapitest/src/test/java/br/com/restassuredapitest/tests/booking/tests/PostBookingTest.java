package br.com.restassuredapitest.tests.booking.tests;

import br.com.restassuredapitest.base.BaseTest;
import br.com.restassuredapitest.suites.AcceptanceTest;
import br.com.restassuredapitest.suites.AllTests;
import br.com.restassuredapitest.tests.booking.requests.PostBookingRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.greaterThan;
@Feature("Feature - Cria uma nova reserva")
public class PostBookingTest extends BaseTest {
    PostBookingRequest postBookingRequest = new PostBookingRequest();

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Cria uma nova reserva")
    @Category({AllTests.class, AcceptanceTest.class})
    public void validaCriacaoDeUmaNovaReserva(){
        postBookingRequest.createBooking()
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));

    }
}
