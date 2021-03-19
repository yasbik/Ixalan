package ixalan.application;

import ixalan.data.FakeMovieDB;
import ixalan.data.FakePosterDB;
import ixalan.data.FakeUserDB;
import ixalan.data.IMovieDB;
import ixalan.data.IPosterDB;
import ixalan.data.IUserDB;
import ixalan.objects.Movie;
import ixalan.objects.Theatre;

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

            //TODO: Initialize database entries, to be changed later to load from an sql script
            initMovieDB();
        }

        return iMovieDB;
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

    private static void initMovieDB()
    {
        Calendar cal = Calendar.getInstance();

        ArrayList<Theatre> list_of_theatres = new ArrayList<Theatre>();
        list_of_theatres.add(new Theatre());

        //One movie where release date is same as today
        iMovieDB.addMovie(new Movie("Avengers Endgame","poster_1", cal.getTime(), list_of_theatres, "Cast\n\nDirector\n\nBlaBl"));

        //One movie where release date is before today
        cal.set(2021, Calendar.FEBRUARY, 13);
        iMovieDB.addMovie(new Movie("Replicas","poster_4", cal.getTime(), list_of_theatres, ""));

        //One movie where release date is after today
        cal.set(2021, Calendar.MAY, 13);
        iMovieDB.addMovie(new Movie("The Nightingale","poster_3", cal.getTime(), null, "Cast\n\nDirector\n\nBlaBl\n\nBl\n\nBl\n\nBl"));
    }
}
