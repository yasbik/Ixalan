package com.example.ixalan.data;

import org.junit.Test;
import com.example.ixalan.data.FakeUserDB;
import static org.junit.Assert.*;

public class FakeUserDBTest {
    @Test
    public void testFakeUserDB1() {
        System.out.println("\nStarting testFakeUserDB1");

        FakeUserDB fake_user_db = new FakeUserDB();

        assertNotNull(fake_user_db);
        String user = String.valueOf(fake_user_db.getUser(-1));
        assertTrue("null".equals(user));

        System.out.println("Finished testFakeUserDB1");

    }
}
