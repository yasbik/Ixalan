package ixalan.data;

import ixalan.objects.Movie;
import ixalan.data.FakePosterDB;
import org.junit.Test;
import static org.junit.Assert.*;

public class FakePosterDBTest {
    @Test
    public void testFakePosterDB1() {
        System.out.println("\nStarting testFakePosterDB1");

        FakePosterDB fake_poster_db = new FakePosterDB();
        assertNotNull(fake_poster_db);

        String status = String.valueOf(fake_poster_db.insertPoster("test_poster_url",100));
        assertTrue(status.equals("1"));
        assertTrue("test_poster_url".equals(fake_poster_db.getPoster(100)));

        System.out.println("Finished testFakePosterDB1");

    }
}
