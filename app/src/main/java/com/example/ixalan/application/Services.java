package com.example.ixalan.application;

import com.example.ixalan.data.FakeMovieDB;
import com.example.ixalan.data.FakePosterDB;
import com.example.ixalan.data.FakeUserDB;
import com.example.ixalan.data.IMovieDB;
import com.example.ixalan.data.IPosterDB;
import com.example.ixalan.data.IUserDB;
import com.example.ixalan.objects.Movie;
import com.example.ixalan.objects.Theatre;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Services
{
    private static IMovieDB iMovieDB = null;
    private static IPosterDB iPosterDB = null;
    private static IUserDB iUserDB = null;

    public static synchronized IMovieDB getiMovieDB()
    {
        if(iMovieDB == null)
        {
            iMovieDB = new FakeMovieDB();

            //TODO: Code to temporarily test with, remove later
            init();
        }

        return iMovieDB;
    }

    private static void init()
    {
        Date date = new Date();

        ArrayList<Theatre> list_of_theatres = new ArrayList<Theatre>();
        list_of_theatres.add(new Theatre());
        Calendar cal = Calendar.getInstance();

        //One movie where release date is same as today
        List<Movie> list_of_movies = new ArrayList<Movie>(){{
            add(new Movie("Avengers Endgame","poster_1", cal.getTime(), list_of_theatres, "Cast\n\nDirector\n\nBlaBl"));
        }};

        //One movie where release date is before today
        cal.set(2021, Calendar.FEBRUARY, 13);
        list_of_movies.add(new Movie("Replicas","poster_4", cal.getTime(), list_of_theatres, ""));

        //One movie where release date is after today
        cal.set(2021, Calendar.MAY, 13);
        list_of_movies.add(new Movie("The Nightingale","poster_3", cal.getTime(), null, "Cast\n\nDirector\n\nBlaBl\n\nBl\n\nBl\n\nBl"));

        for (Movie movie : list_of_movies)
        {
            iMovieDB.addMovie(movie);
        }
    }

    public static synchronized IPosterDB getiPosterDBDB()
    {
        if(iPosterDB == null) {
            iPosterDB = new FakePosterDB();
        }

        return iPosterDB;
    }

    public static synchronized IUserDB getiUserDB()
    {
        if(iUserDB == null) {
            iUserDB= new FakeUserDB();
        }

        return iUserDB;
    }
}
