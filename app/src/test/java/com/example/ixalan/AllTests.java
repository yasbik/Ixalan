package com.example.ixalan;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.example.ixalan.business.AccessMoviesTest;
import com.example.ixalan.data.FakeMovieDBTest;
import com.example.ixalan.data.FakePosterDBTest;
import com.example.ixalan.data.FakeUserDBTest;
import com.example.ixalan.objects.MovieTest;

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
