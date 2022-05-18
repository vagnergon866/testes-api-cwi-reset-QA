package br.com.restassuredapitest.tests.ping.tests;

import br.com.restassuredapitest.suites.AllTests;
import br.com.restassuredapitest.tests.ping.requests.GetPingRequest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThan;

public class GetPingTest {
    GetPingRequest getPingRequest = new GetPingRequest();

    @Test
    @Category({AllTests.class})
    public void validaApiOnline() {

        getPingRequest.pingReturnApi()
                .then()
                .statusCode(201)
                .time(lessThan(2L), TimeUnit.SECONDS);
    }


}