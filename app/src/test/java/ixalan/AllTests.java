package ixalan;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import ixalan.business.AccessMoviesTest;
import ixalan.data.FakeMovieDBTest;
import ixalan.data.FakePosterDBTest;
import ixalan.data.FakeUserDBTest;
import ixalan.objects.MovieTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccessMoviesTest.class,
        FakeMovieDBTest.class,
        FakePosterDBTest.class,
        FakeUserDBTest.class,
        MovieTest.class,
})

public class AllTests {
}
