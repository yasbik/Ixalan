package com.example.ixalan.business;

import com.example.ixalan.data.FakeMovieDB;
import com.example.ixalan.objects.Movie;

import java.util.ArrayList;
import java.util.List;

public class AccessMovies
{
    private FakeMovieDB movieDB;
    private List<Movie> list_of_movies;

    /*
        Function to get a list of currently running and upcoming movies.
        Returns them as a list
    */
    public List<Movie> getMovies()
    {
        //TODO: Fetch a list of currently running and upcoming movies. As database isn't fully implemented, we'll just hardcode them for now

         list_of_movies = new ArrayList<Movie>(){{
            add(new Movie("Avengers Endgame","poster_1"));
            add(new Movie("Black Panther","poster_2"));
            add(new Movie("The Nightingale","poster_3"));
            add(new Movie("Replicas","poster_4"));
        }};

         return list_of_movies;
    }

    /*
        Returns a list of currently running movies
    */
    public List<Movie> getCurrentlyRunningMovies()
    {
         //TODO: As there's no way of saying if a movie is currently running, just return the list of hardcoded movies
        return getMovies();
    }

    /*
       Returns a list of currently running movies
   */
    public List<Movie> getUpcomingMovies()
    {
        //TODO: As there's no way of saying if a movie is upcoming, just return the list of hardcoded movies
        return getMovies();
    }

    /*
        Function that returns a list of movies whose names contain the search_criteria
    */
    public List<Movie> getFilteredMovies(String search_criteria)
    {
        //TODO: As the db hasn't been fully implemented, just return the list of hardcoded movies
        return getMovies();
    }
}
