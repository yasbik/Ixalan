package com.example.ixalan;

public  interface movieDBInterface{

    // Get a User from the database by there movieID
    public Movie getMovie(int movieID);

    //removes a movie completely from the dataBase
    // updating should not use this function
    public void removeMovie(int movieID);

}