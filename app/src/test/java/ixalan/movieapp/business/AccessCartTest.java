package ixalan.movieapp.business;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import ixalan.movieapp.data.IMerchandiseDB;
import ixalan.movieapp.data.IMovieDB;
import ixalan.movieapp.objects.CartItem;
import ixalan.movieapp.objects.Merchandise;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccessCartTest {
    private AccessCart accessCart;
    private HashMap<CartItem, Integer> cart_list;

    @Before
    public void setUp(){

        cart_list = new HashMap<CartItem, Integer>();
        cart_list.put(new CartItem("Key Ring", new Float(5.99), 2), 2);
        cart_list.put(new CartItem("Coffee Mug", new Float(15.99), 1), 1);
        cart_list.put(new CartItem("Friends T-shirt", new Float(20.99), 1), 1);

        accessCart = new AccessCart(cart_list);
    }

    @Test
    public void testAddCartItems() {
        System.out.println("\nStarting AccessCart_addCartItems");
        CartItem cart_item = new CartItem("Bagpack", new Float(40), 1);
        int quantity = 1;
        accessCart.addCartItem(cart_item, quantity);
        cart_list.put(cart_item, quantity);

        assertEquals(accessCart.getCartItems(), cart_list);
        System.out.println("Finished AccessCart_addCartItems");
    }

    @Test
    public void testGetCartItems() {
        System.out.println("\nStarting AccessCart_getCartItems");
        assertEquals(accessCart.getCartItems(), cart_list);
        System.out.println("Finished AccessCart_getCartItems");
    }
}
