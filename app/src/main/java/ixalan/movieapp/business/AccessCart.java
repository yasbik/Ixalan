package ixalan.movieapp.business;
import android.os.Parcelable;

import ixalan.movieapp.objects.CartItem;
import ixalan.movieapp.objects.Merchandise;
import ixalan.movieapp.objects.Ticket;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AccessCart {

    private static HashMap<CartItem, Integer> cart_list = new HashMap<CartItem, Integer>();

    public AccessCart()
    {

    }

    public AccessCart(HashMap<CartItem, Integer> cart_list)
    {
        this.cart_list = cart_list;
    }

    public static HashMap<CartItem, Integer> getCartItems() {
        return cart_list;
    }

    public static void addCartItem(CartItem cartItem, int quantity)
    {
        if (cartItem != null && cart_list != null && quantity > 0)
        {
            boolean item_added = false;
            for(Map.Entry<CartItem, Integer> entry : cart_list.entrySet())
            {
                if (cartItem instanceof Merchandise && entry.getKey() instanceof Merchandise)
                {
                    if (((Merchandise)cartItem).equals((Merchandise)entry.getKey()))
                    {
                        cart_list.put(entry.getKey(), quantity);
                        item_added = true;
                    }
                } else if (cartItem instanceof Ticket && entry.getKey() instanceof Ticket)
                {
                    if (((Ticket)cartItem).equals((Ticket)entry.getKey()))
                    {
                        cart_list.put(entry.getKey(), quantity);
                        item_added = true;
                    }
                }
            }

            if (!item_added)
            {
                cart_list.put(cartItem, new Integer(quantity));
            }

        }
    }
}

