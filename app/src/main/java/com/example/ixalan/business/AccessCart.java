package com.example.ixalan.business;
import com.example.ixalan.objects.Merchandise;
import com.example.ixalan.objects.Movie;

import java.util.ArrayList;
import java.util.List;

public class AccessCart {

    private ArrayList<Merchandise> cart_list;

    /*hard coded list for now */
    public ArrayList<Merchandise> getCartItems() {
         cart_list = new ArrayList<Merchandise>(){{
            add(new Merchandise("KeyChain",new Float(10.0)));
            add(new Merchandise("Mug",new Float(39.99)));
        }};
         return cart_list;
    }
}
