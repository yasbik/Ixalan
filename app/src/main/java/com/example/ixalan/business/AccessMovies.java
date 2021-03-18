package com.example.ixalan.business;

import com.example.ixalan.application.Services;
import com.example.ixalan.data.FakeMovieDB;
import com.example.ixalan.data.IMovieDB;
import com.example.ixalan.objects.Movie;

import java.util.ArrayList;
import java.util.List;

public class AccessMovies
{
    private IMovieDB movieDB;

    public AccessMovies()
    {
        movieDB = Services.getiMovieDB();
    }

    /*
        Function to get a list of currently running and upcoming movies.
        Returns them as a list
    */
    public List<Movie> getMovies()
    {
        return movieDB.getAllMovies();
    }

    public List<Movie> filterMovies(String search_criteria, boolean isUpcoming) {
        List<Movie> toReturn = new ArrayList<Movie>();

        for (Movie movie : getMovies()) {
            if (movie.getMovieName().toLowerCase().contains(search_criteria.toLowerCase())) { //match search criteria
                if (isUpcoming) {
                    if (movie.isUpcoming()) {
                        toReturn.add(movie);
                    }
                } else {
                    if (movie.isCurrentlyRunning()) {
                        toReturn.add(movie);
                    }
                }
            }
        }
        return toReturn;
    }
}