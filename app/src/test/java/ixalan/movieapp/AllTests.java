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
        AccessMerchandiseIT.class,
        AccessMerchandiseTest.class,
        AccessMovieDetailTest.class,
        AccessMoviesIT.class,
        AccessMoviesTest.class,
        FakeMovieDBTest.class,
        FakePosterDBTest.class,
        FakeUserDBTest.class,
        MerchandiseTest.class,
        MovieTest.class,
})

public class AllTests {
}
