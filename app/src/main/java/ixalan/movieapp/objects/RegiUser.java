package ixalan.movieapp.objects;

import java.util.ArrayList;
public class RegiUser extends User {
    private String id; //Possibly alphanumeric
    private char[] password; //Store password as char array for more security
    private ArrayList<Movie> moviesWatched ;
    private ArrayList<Movie> moviesLiked ;
    private String paymentInfo;
    private String savedAddress;

    public RegiUser(String id , char[] password , String savedAddress){
        this.id = id;
        this.password = password;
        moviesWatched = new ArrayList<>();
        moviesLiked = new ArrayList<>();
        this.savedAddress = savedAddress;
    }

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
