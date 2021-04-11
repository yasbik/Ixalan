package ixalan.movieapp.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

import ixalan.movieapp.data.IMerchandiseDB;
import ixalan.movieapp.objects.Merchandise;

public class AccessMerchandiseTest
{
    //TODO: Write tests

    private AccessMerchandise accessMerchandise;
    private IMerchandiseDB merchandiseDB;

    @Before
    public void setUp()
    {
        merchandiseDB = mock(IMerchandiseDB.class);
        accessMerchandise = new AccessMerchandise(merchandiseDB);
    }

    @Test
    public void test1()
    {

    }

}
