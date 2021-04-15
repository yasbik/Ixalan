package ixalan.movieapp.objects;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CartItemTest {
    String item_name;
    Float price;
    int quantity;
    CartItem cart_item;

    @Before
    public void setUp(){
        item_name = "Key chain";
        price = new Float(2.99);
        quantity = 2;
        cart_item = new CartItem(item_name, price, quantity);
        assertNotNull(cart_item);
    }

    @Test
    public void cartItemGetPriceTest() {
        System.out.println("\nStarting cartItemGetPriceTest");
        assertTrue(price.equals(cart_item.getPrice()));
        System.out.println("Finished cartItemGetPriceTest");
    }

    @Test
    public void cartItemGetNameTest() {
        System.out.println("\nStarting cartItemGetNameTest");
        assertTrue(item_name.equals(cart_item.getName()));
        System.out.println("Finished cartItemGetNameTest");
    }

    @Test
    public void cartItemGetQuantityTest() {
        System.out.println("\nStarting cartItemGetQuantityTest");
        String quantity_string = String.valueOf(quantity);
        String returned_quantity = String.valueOf(cart_item.getQuantity());
        assertTrue(quantity_string.equals(returned_quantity));
        System.out.println("Finished cartItemGetQuantityTest");
    }

    @Test
    public void cartItemSetPriceTest() {
        System.out.println("\nStarting cartItemSetPriceTest");
        Float new_price = new Float(3.99);
        cart_item.setPrice(new_price);
        assertTrue(new_price.equals(cart_item.getPrice()));
        System.out.println("Finished cartItemSetPriceTest");
    }

    @Test
    public void cartItemSetNameTest() {
        System.out.println("\nStarting cartItemSetNameTest");
        String new_name = "Silver Key Chain";
        cart_item.setName(new_name);
        assertTrue(new_name.equals(cart_item.getName()));
        System.out.println("Finished cartItemSetNameTest");
    }

    @Test
    public void cartItemSetQuantityTest() {
        System.out.println("\nStarting cartItemSetQuantityTest");
        int new_quantity = 3;
        cart_item.setQuantity(new_quantity);
        String quantity_string = String.valueOf(new_quantity);
        String returned_quantity = String.valueOf(cart_item.getQuantity());
        assertTrue(quantity_string.equals(returned_quantity));
        System.out.println("Finished cartItemSetQuantityTest");
    }
}
