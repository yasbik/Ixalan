package ixalan.movieapp;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import ixalan.movieapp.business.AccessMerchandiseIT;
import ixalan.movieapp.business.AccessMerchandiseTest;
import ixalan.movieapp.business.AccessMovieDetail;
import ixalan.movieapp.business.AccessMovieDetailTest;
import ixalan.movieapp.business.AccessMoviesIT;
import ixalan.movieapp.business.AccessMoviesTest;
import ixalan.movieapp.data.FakeMovieDBTest;
import ixalan.movieapp.data.FakePosterDBTest;
import ixalan.movieapp.data.FakeUserDBTest;
import ixalan.movieapp.data.MerchandiseDBStub;
import ixalan.movieapp.data.MovieDBStub;
import ixalan.movieapp.objects.MerchandiseTest;
import ixalan.movieapp.objects.MovieTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccessMerchandiseTest.class,
        AccessMovieDetailTest.class,
        AccessMoviesTest.class,
        FakeMovieDBTest.class,
        FakePosterDBTest.class,
        FakeUserDBTest.class,
        MerchandiseDBStub.class,
        MovieDBStub.class,
        MerchandiseTest.class,
        MovieTest.class,
})

public class UnitTests {
}
