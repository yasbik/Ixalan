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

    /*
        Returns a list of currently running movies
    */
    public List<Movie> getCurrentlyRunningMovies()
    {
        List<Movie> currentlyRunningMovies = new ArrayList<Movie>();
        for(Movie movie : getMovies())
        {
            if (movie.isCurrentlyRunning())
            {
                currentlyRunningMovies.add(movie);
            }
        }

        return currentlyRunningMovies;
    }

    /*
       Returns a list of currently running movies
   */
    public List<Movie> getUpcomingMovies()
    {
        List<Movie> upcomingMovies = new ArrayList<Movie>();
        for(Movie movie : getMovies())
        {
            if (movie.isUpcoming())
            {
                upcomingMovies.add(movie);
            }
        }

        return upcomingMovies;
    }

    /*
        Function that returns a list of movies whose names contain the search_criteria
    */
    public List<Movie> getFilteredMovies(String search_criteria)
    {
        List<Movie> filtered_movies = new ArrayList<Movie>();
        for(Movie movie : getMovies())
        {
            if (movie.getMovieName().contains(search_criteria))
            {
                filtered_movies.add(movie);
            }
        }
        return filtered_movies;
    }
}
