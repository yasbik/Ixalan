package ixalan.movieapp.objects;

import java.util.ArrayList;
public class RegiUser extends User {
    private int id; //Possibly alphanumeric
    private String password; //Store password as char array for mroe security
    private ArrayList<Movie> moviesWatched = new ArrayList<>();
    private ArrayList<Movie> moviesLiked = new ArrayList<>();
    private String paymentInfo;
    private String email;

    public RegiUser(String name, String email, String password, int balance, int pointsBalance, int userID, String creditCard) {
        super(name, email, password, balance, pointsBalance, userID, creditCard);
    }


    public int getId()
    {
        return this.id;
    }

    public String getPassword()
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

    public String getEmail()
    {
        return this.email;
    }

    public String getPaymentInfo()
    {
        return this.paymentInfo;
    }

}
