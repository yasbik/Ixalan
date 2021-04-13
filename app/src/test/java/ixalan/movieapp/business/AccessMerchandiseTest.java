package ixalan.movieapp.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import ixalan.movieapp.data.IMerchandiseDB;
import ixalan.movieapp.objects.Merchandise;
import ixalan.movieapp.objects.Movie;

public class AccessMerchandiseTest
{
    //TODO: Write tests

    private AccessMerchandise accessMerchandise;
    private IMerchandiseDB merchandiseDB;
    private ArrayList<Merchandise> merchandise;

    @Before
    public void setUp()
    {
        merchandiseDB = mock(IMerchandiseDB.class);

        merchandise = new ArrayList<Merchandise>(){
        {
            add(new Merchandise((float)4.99, 5, "Test Merch 1", 1, "Test description 1", 1, 1000, "testUrl1"));
            add(new Merchandise((float)9.99, 2, "Test Merch 2", 2, "Test description 2", 2, 100, "testUrl2"));
            add(new Merchandise((float)14.99, 1, "Test Merch 3", 3, "Test description 3", 1, 5, "testUrl3"));
        }};
        when(merchandiseDB.getMerchandiseForMovie(1)).thenReturn(new ArrayList<Merchandise>(merchandise.subList(0, 2)));
        when(merchandiseDB.getMerchandiseForMovie(2)).thenReturn(new ArrayList<Merchandise>(merchandise.subList(2, 2)));
        when(merchandiseDB.getMerchandiseForMovie(3)).thenReturn(new ArrayList<Merchandise>());

        accessMerchandise = new AccessMerchandise(merchandiseDB);
    }

    @Test
    public void test1()
    {
        System.out.println("\nStarting AccessMerchandiseTest1\n");

        assertNotNull(accessMerchandise);
        assertNotNull(merchandiseDB);
        assertNotNull(merchandise);
        assertEquals(accessMerchandise.getMovie(), null);
        assertNotNull(accessMerchandise.getDetails());
        assertTrue(accessMerchandise.getDetails().equals(""));
        assertEquals(accessMerchandise.getQuantity(), 0);
        assertEquals(accessMerchandise.getIndexPointer(), 0);

        System.out.println("\nFinished AccessMerchandiseTest1\n");
    }

    @Test
    public void testQuantities()
    {
        System.out.println("\nStarting AccessMerchandise_testQuantities\n");

        assertNotNull(accessMerchandise);
        accessMerchandise.setMovie(new Movie(1, "Test Movie"));
        assertNotNull(accessMerchandise.getMovie());
        assertFalse(accessMerchandise.setQuantity(merchandise.get(0).getStock()+10));
        assertTrue(accessMerchandise.setQuantity(1));
        assertEquals(accessMerchandise.getQuantity(), 1);
        assertTrue(accessMerchandise.merchandiseAvailable());

        //revert back to what it was for following tests
        assertTrue(accessMerchandise.setQuantity(0));
        assertEquals(accessMerchandise.getQuantity(), 0);

        System.out.println("\nFinished AccessMerchandise_testQuantities\n");
    }

    @Test
    public void test2()
    {
        System.out.println("\nStarting AccessMerchandise_test2\n");

        assertNotNull(accessMerchandise);
        accessMerchandise.setMovie(new Movie(1, "Test Movie"));
        assertNotNull(accessMerchandise.getMovie());
        assertEquals(accessMerchandise.getCurrentItem(), merchandise.get(0));
        assertTrue(accessMerchandise.getDetails().contains(""+merchandise.get(0).getPrice()));
        assertTrue(accessMerchandise.getDetails().contains(merchandise.get(0).getDescription()));
        accessMerchandise.incrementIndexPtr();
        assertEquals(accessMerchandise.getIndexPointer(), 1);
        assertEquals(accessMerchandise.getCurrentItem(), merchandise.get(1));
        assertTrue(accessMerchandise.getDetails().contains(""+merchandise.get(1).getPrice()));
        assertTrue(accessMerchandise.getDetails().contains(merchandise.get(1).getDescription()));
        assertTrue(accessMerchandise.merchandiseAvailable());

        System.out.println("\nFinished AccessMerchandise_test2\n");
    }

    @Test
    public void testMerchandiseAvailable()
    {
        System.out.println("\nStarting AccessMerchandise_testMerchandiseAvailable\n");

        assertNotNull(accessMerchandise);
        accessMerchandise.setMovie(new Movie(3, "Test Movie"));
        assertFalse(accessMerchandise.merchandiseAvailable());

        System.out.println("\nFinished AccessMerchandise_testMerchandiseAvailable\n");
    }

}
