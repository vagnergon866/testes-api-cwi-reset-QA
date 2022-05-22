package br.com.restassuredapitest.runners;

import br.com.restassuredapitest.tests.booking.tests.DeleteBookingTest;
import br.com.restassuredapitest.tests.booking.tests.PostBookingTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(br.com.restassuredapitest.suites.AcceptanceCripticalTest.class)
@Suite.SuiteClasses({
        AcceptanceCripticalTest.class,
        PostBookingTest.class,
        DeleteBookingTest.class
})
public class AcceptanceCripticalTest {
}
