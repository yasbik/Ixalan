package ixalan.movieapp.business;

import ixalan.movieapp.application.Services;
import ixalan.movieapp.data.IMerchandiseDB;
import ixalan.movieapp.data.IMovieDB;
import ixalan.movieapp.data.MerchandiseDB;
import ixalan.movieapp.data.MovieDB;
import ixalan.movieapp.utils.TestUtils;

import org.junit.Test;
import org.junit.Before;

import java.io.File;
import java.io.IOException;

import static org.mockito.Mockito.mock;

import static org.junit.Assert.*;

public class AccessMerchandiseIT
{
    private AccessMerchandise accessMerchandise;
    private File tempDB;

    @Before
    public void setUp() throws IOException
    {
        this.tempDB = TestUtils.copyDB();
        final IMerchandiseDB persistence = new MerchandiseDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.accessMerchandise = new AccessMerchandise(persistence);
    }
}
