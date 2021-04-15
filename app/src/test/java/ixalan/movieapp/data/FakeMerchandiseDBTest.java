package ixalan.movieapp.data;

import org.junit.Test;

import java.util.ArrayList;

import ixalan.movieapp.objects.Merchandise;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class FakeMerchandiseDBTest {
    private ArrayList<Merchandise> merchandise_list;

    @Test
    public void testFakeMerchandiseDB() {
        System.out.println("\nStarting testFakeMerchandiseDB");

        FakeMerchandiseDB fake_merchandise_db = new FakeMerchandiseDB();
        assertNotNull(fake_merchandise_db);

        merchandise_list = new ArrayList<>(2);

        Merchandise merchandise1 = new Merchandise("Key chain", new Float(2.99));
        Merchandise merchandise2= new Merchandise("Key chain", new Float(2.99));

        merchandise_list.add(merchandise1);
        merchandise_list.add(merchandise2);
        assertNotNull(merchandise_list);

        fake_merchandise_db.addMerchandise(merchandise1);
        fake_merchandise_db.addMerchandise(merchandise2);
        assertTrue(fake_merchandise_db.getAllMerchandise().equals(merchandise_list));

        System.out.println("Finished testFakeMerchandiseDB");

    }
}
