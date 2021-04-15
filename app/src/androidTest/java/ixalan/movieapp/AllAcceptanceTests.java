package ixalan.movieapp;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        MerchandiseTest.class,
        PaymentTest.class,
        MoviesTest.class
})
public class AllAcceptanceTests {
}
