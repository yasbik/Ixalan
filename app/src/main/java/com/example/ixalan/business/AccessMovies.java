package com.example.ixalan.business;

import com.example.ixalan.data.FakeMovieDB;
import com.example.ixalan.data.IMovieDB;
import com.example.ixalan.objects.Movie;

import java.util.ArrayList;
import java.util.List;

public class AccessMovies
{
    private FakeMovieDB movieDB = new FakeMovieDB();
    private List<Movie> list_of_movies = new ArrayList<Movie>();

    /*
        Function to get a list of currently running and upcoming movies.
        Returns them as a list
    */
    public List<Movie> getMovies()
    {
        list_of_movies.clear();
        for(Movie movie : movieDB.getAllMovies())
        {
            if (movie.isCurrentlyRunning() || movie.isUpcoming())
            {
                list_of_movies.add(movie);
            }
        }

         /*list_of_movies = new ArrayList<Movie>(){{
            add(new Movie("Avengers Endgame","poster_1"));
            add(new Movie("Black Panther","poster_2"));
            add(new Movie("The Nightingale","poster_3"));
            add(new Movie("Replicas","poster_4"));
        }};*/

         return list_of_movies;
    }

    /*
        Returns a list of currently running movies
    */
    public List<Movie> getCurrentlyRunningMovies()
    {
        list_of_movies.clear();
        for(Movie movie : movieDB.getAllMovies())
        {
            if (movie.isCurrentlyRunning())
            {
                list_of_movies.add(movie);
            }
        }

        return list_of_movies;
    }

    /*
       Returns a list of currently running movies
   */
    public List<Movie> getUpcomingMovies()
    {
        list_of_movies.clear();
        for(Movie movie : movieDB.getAllMovies())
        {
            if (movie.isUpcoming())
            {
                list_of_movies.add(movie);
            }
        }

        return list_of_movies;
    }

    /*
        Function that returns a list of movies whose names contain the search_criteria
    */
    public List<Movie> getFilteredMovies(String search_criteria)
    {
        ArrayList<Movie> filtered_movies = new ArrayList<Movie>();
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
