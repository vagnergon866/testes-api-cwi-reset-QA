package br.com.restassuredapitest.runners;

import br.com.restassuredapitest.tests.booking.tests.DeleteBookingTest;
import br.com.restassuredapitest.tests.booking.tests.PostBookingTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(br.com.restassuredapitest.suites.AcceptanceTest.class)
@Suite.SuiteClasses({
        AcceptanceTest.class,
        PostBookingTest.class,
        DeleteBookingTest.class
})
public class AcceptanceTest {
}
