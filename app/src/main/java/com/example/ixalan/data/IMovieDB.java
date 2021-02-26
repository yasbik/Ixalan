package com.example.ixalan.data;

import com.example.ixalan.objects.Movie;

public interface IMovieDB
{
    // Get a User from the database by there movieID
    public Movie getMovie(int movieID);

    //removes a movie completely from the dataBase
    // updating should not use this function
    public int removeMovie(int movieID);

    public void addMovie(Movie newMovie);
}
