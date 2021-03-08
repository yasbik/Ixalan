package com.example.ixalan.objects;

import java.util.ArrayList;
public class RegiUser extends User {
    private String id; //Possibly alphanumeric
    private char[] password; //Store password as char array for mroe security
    private ArrayList<Movie> moviesWatched = new ArrayList<>();
    private ArrayList<Movie> moviesLiked = new ArrayList<>();
    private String paymentInfo;
    private String savedAddress;

    public String getId()
    {
        return this.id;
    }

    public char[] getPassword()
    {
        return this.password;
    }

    public ArrayList<Movie> getMoviesLiked()
    {
        return this.moviesLiked;
    }

    public ArrayList<Movie> getMoviesWatched()
    {
        return this.moviesWatched;
    }

    public String getSavedAddress()
    {
        return this.getSavedAddress();
    }

    public String getPaymentInfo()
    {
        return this.paymentInfo;
    }

}
