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

    private boolean isUpcoming;
    private String search_criteria;

    /*
    Constructor
    */
    public AccessMovies(boolean isUpcoming, String search_criteria)
    {
        this();
        this.isUpcoming = isUpcoming;
        this.search_criteria = search_criteria;
    }

    /*
    Constructor
    No arguments assumes empty search criteria and filter currently running movies
    */
    public AccessMovies()
    {
        this.isUpcoming = false;
        this.search_criteria = "";
        movieDB = Services.getiMovieDB();
    }

    public AccessMovies(final IMovieDB movieDB)
    {
        this();
        this.movieDB = movieDB;
    }

    public void setUpcoming(boolean upcoming)
    {
        isUpcoming = upcoming;
    }

    public void setSearch_criteria(String search_criteria)
    {
        if (search_criteria != null) {
            this.search_criteria = search_criteria;
        }
    }

    public boolean isUpcoming()
    {
        return isUpcoming;
    }

    public String getSearch_criteria()
    {
        return search_criteria;
    }

    /*
        Function to get a list of currently running and upcoming movies.
        Returns them as a list
    */
    public List<Movie> getMovies()
    {
        return movieDB.getAllMovies();
    }

    /*
    Filter based on pre-set globals
    */
    public List<Movie> filterMovies()
    {
        return filterMovies(search_criteria, isUpcoming);
    }

    /*
    Get a list of filtered movies
    Parameters: search_criteria (if movie name contains this text), isUpcoming: If movie is upcoming (if not, it is currently running)
     */
    public List<Movie> filterMovies(String search_criteria, boolean isUpcoming)
    {
        List<Movie> toReturn = new ArrayList<Movie>();

        for (Movie movie : getMovies()) {
            if (movie.getMovieName() != null && search_criteria != null)
            {
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
        }
        return toReturn;
    }

}