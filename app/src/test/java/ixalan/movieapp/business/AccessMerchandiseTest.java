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
        when(merchandiseDB.getAllMerchandise()).thenReturn(merchandise);

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
        assertTrue(accessMerchandise.getDetails().equals(""));
        assertEquals(accessMerchandise.getQuantity(), 0);
        assertEquals(accessMerchandise.getMerchandise_index(), 0);

        System.out.println("\nFinished AccessMerchandiseTest1\n");
    }

    @Test
    public void testQuantities()
    {
        System.out.println("\nStarting AccessMerchandise_testQuantities\n");

        assertFalse(accessMerchandise.setQuantity(merchandise.get(0).getStock()+10));
        assertTrue(accessMerchandise.setQuantity(1));
        assertEquals(accessMerchandise.getQuantity(), 1);

        System.out.println("\nFinished AccessMerchandise_testQuantities\n");
    }

    @Test
    public void testgetNextItem()
    {
        System.out.println("\nStarting AccessMerchandise_testgetNextItem\n");

        assertEquals(accessMerchandise.getNextItem(), merchandise.get(0));

        assertTrue(accessMerchandise.getDetails().contains(merchandise.get(0).getDescription()));
        assertTrue(accessMerchandise.getDetails().contains(""+merchandise.get(0).getPrice()));

        assertEquals(accessMerchandise.getMerchandise_index(), 1);
        assertEquals(accessMerchandise.getQuantity(), 0);

        //reset if any tests follow after this
        accessMerchandise.setMerchandise_index(0);
        assertEquals(accessMerchandise.getMerchandise_index(), 0);

        System.out.println("\nFinished AccessMerchandise_testgetNextItem\n");
    }

    @Test
    public void testgetCurrentItem()
    {
        System.out.println("\nStarting AccessMerchandise_testgetCurrentItem\n");

        //local initialization
        accessMerchandise.setMerchandise_index(2);
        assertEquals(accessMerchandise.getMerchandise_index(), 2);

        assertEquals(accessMerchandise.getCurrentItem(), merchandise.get(2));

        assertTrue(accessMerchandise.getDetails().contains(merchandise.get(2).getDescription()));
        assertTrue(accessMerchandise.getDetails().contains(""+merchandise.get(2).getPrice()));

        assertEquals(accessMerchandise.getMerchandise_index(), 2); //called again to ensure function call didn't move pointer
        assertEquals(accessMerchandise.getQuantity(), 0);

        //reset if any tests follow after this
        accessMerchandise.setMerchandise_index(0);
        assertEquals(accessMerchandise.getMerchandise_index(), 0);

        System.out.println("\nFinished AccessMerchandise_testgetCurrentItem\n");
    }

}
