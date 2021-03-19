package ixalan.movieapp.business;
import ixalan.movieapp.objects.Merchandise;

import java.util.ArrayList;

public class AccessCart {

    private ArrayList<Merchandise> cart_list;

    /*hard coded list for now because cart list not created for each user in database*/
    public ArrayList<Merchandise> getCartItems() {
        cart_list = new ArrayList<Merchandise>(){{
            add(new Merchandise("KeyChain",new Float(10.0)));
            add(new Merchandise("Mug",new Float(39.99)));
        }};
        return cart_list;
    }
}

