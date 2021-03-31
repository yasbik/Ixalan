package ixalan.movieapp.business;
import ixalan.movieapp.objects.CartItem;
import ixalan.movieapp.objects.Merchandise;

import java.util.ArrayList;

public class AccessCart {

    private static ArrayList<CartItem> cart_list;

    /*hard coded list for now because cart list not created for each user in database*/
    public static ArrayList<CartItem> getCartItems()
    {
        cart_list = new ArrayList<CartItem>(){{
            add(new Merchandise("KeyChain",new Float(10.0)));
            add(new Merchandise("Mug",new Float(39.99)));
        }};
        return cart_list;
    }

    public static void addCartItem(CartItem cartItem)
    {
        if (cartItem != null)
        {
            cart_list.add(cartItem);
        }
    }
}

