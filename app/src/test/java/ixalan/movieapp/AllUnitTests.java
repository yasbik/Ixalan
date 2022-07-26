package ixalan.movieapp;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import ixalan.movieapp.business.AccessCartTest;
import ixalan.movieapp.business.AccessMerchandiseTest;
import ixalan.movieapp.business.AccessMovieDetailTest;
import ixalan.movieapp.business.AccessMoviesTest;
import ixalan.movieapp.data.FakeMerchandiseDB;
import ixalan.movieapp.data.FakeMerchandiseDBTest;
import ixalan.movieapp.data.FakeMovieDBTest;
import ixalan.movieapp.data.FakePosterDBTest;
import ixalan.movieapp.data.FakeUserDBTest;
import ixalan.movieapp.objects.CartItemTest;
import ixalan.movieapp.objects.MerchandiseTest;
import ixalan.movieapp.objects.MovieTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccessMerchandiseTest.class,
        AccessMovieDetailTest.class,
        AccessMoviesTest.class,
        AccessCartTest.class,
        FakeMovieDBTest.class,
        FakePosterDBTest.class,
        FakeMerchandiseDBTest.class,
        FakeUserDBTest.class,
        MerchandiseTest.class,
        MovieTest.class,
        CartItemTest.class,
})

public class AllUnitTests {
}
