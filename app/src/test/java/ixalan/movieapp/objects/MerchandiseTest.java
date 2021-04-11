package ixalan.movieapp.objects;

import org.junit.Test;

import static org.junit.Assert.*;

public class MerchandiseTest
{
    //TODO: Write tests

    @Test
    public void test1()
    {
        Merchandise merchandise;

        System.out.println("\nStarting MerchandiseTest\n");

        merchandise = new Merchandise(1, "Test Merchandise", (float)2.99);
        merchandise.setDescription("Test Description");
        merchandise.setMovieTag(1000);
        merchandise.setStock(15);
        merchandise.setImageUrl("Test Image URL");

        assertNotNull(merchandise);
        assertEquals(merchandise.getMerchID(), 1);
        assert(merchandise.getPrice() == 2.99);
        assertTrue("Test Merchandise".equals(merchandise.getName()));
        assertTrue("Test Description".equals(merchandise.getDescription()));
        assertEquals(1000, merchandise.getMovieTag());
        assertEquals(15, merchandise.getStock());
        assertTrue("Test Image URL".equals(merchandise.getImageUrl()));
        assertEquals(1,merchandise.getQuantity());

        System.out.println("\nFinished MerchandiseTest\n");
    }
}
