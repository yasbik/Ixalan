package ixalan.movieapp;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import ixalan.movieapp.business.AccessMerchandiseIT;
import ixalan.movieapp.business.AccessMerchandiseTest;
import ixalan.movieapp.business.AccessMovieDetailTest;
import ixalan.movieapp.business.AccessMoviesIT;
import ixalan.movieapp.business.AccessMoviesTest;
import ixalan.movieapp.data.FakeMovieDBTest;
import ixalan.movieapp.data.FakePosterDBTest;
import ixalan.movieapp.data.FakeUserDBTest;
import ixalan.movieapp.objects.MerchandiseTest;
import ixalan.movieapp.objects.MovieTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AllUnitTests.class,
        AllIntegrationTests.class
})

public class AllTests {
}
